package com.msy.travel.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.*;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.common.wx.Sha1Util;
import com.msy.travel.pojo.*;
import com.msy.travel.service.*;
import com.msy.travel.wx.utils.WeixinService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/webOrder")
public class WebOrderController extends BaseController {
	public static final Log log = LogFactory.getLog(WebOrderController.class);

	@Resource(name = "orderServiceImpl")
	private OrderService orderService;

	@Resource(name = "orderListServiceImpl")
	private OrderListService orderListService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Resource(name = "orderExpressServiceImpl")
	private OrderExpressService orderExpressService;

	@Resource(name = "consigneeServiceImpl")
	private ConsigneeService consigneeService;

	@Resource(name = "goodsPriceServiceImpl")
	private GoodsPriceService goodsPriceService;

	@Resource(name = "commproductServiceImpl")
	private CommproductService commproductService;

	@Resource(name = "orderCustomerServiceImpl")
	private OrderCustomerService orderCustomerService;

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;

  @Resource(name = "pubmapServiceImpl")
  private IPubmapService pubmapService;

  @Resource(name = "destspServiceImpl")
  private IDestspService destspService;

  @Resource(name = "serviceCodeServiceImpl")
  private IServiceCodeService serviceCodeService;

  @Resource(name = "orderBackServiceImpl")
  private OrderBackService orderBackService;

	@Resource(name = "companyExpressServiceImpl")
	private CompanyExpressService companyExpressService;

	@Resource(name = "rsPicServiceImpl")
	private IRsPicService rsPicService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@RequestMapping(params = "method=test")
	public ModelAndView test() {
		ModelAndView view = new ModelAndView("/web/order/test");
		return view;
	}
	/**
	 * 进入订单收集数据页面
	 * prepareOrderJson
	 * {
	 * price:
	 * {
	 *		priceType;活动类型,
	 *		活动特殊字段
	 * }
	 * orderListList:
	 * [
	 * {
	 * priceId:  //销售id，必须
	 * num:      //购买数量，必须
	 * cartId:   //购物车Id，非必须
	 *
	 * }
	 * ]
	 * }
	 * @param
	 * @return
	 */
	@RequestMapping(params = "method=toCreateOrder")
	public ModelAndView toCreateOrder(String prepareOrderJson,HttpServletRequest request) {
		ModelAndView view = null;
		try {
			JSONObject prepareOrderJsonObject = JSON.parseObject(prepareOrderJson);

			List<OrderList> orderListList = new ArrayList<>();
			JSONArray orderListListJSONArray = prepareOrderJsonObject.getJSONArray("orderListList");
			for (int i=0;i<orderListListJSONArray.size();i++)
			{
				JSONObject orderListJSONObject = orderListListJSONArray.getJSONObject(i);
				OrderList orderList = new OrderList();
				orderList.setPriceId(orderListJSONObject.getString("priceId"));
				orderList.setNum(orderListJSONObject.getString("num"));
				orderList.setCartId(orderListJSONObject.getString("cartId"));

				SellPrice sellPrice = new SellPrice();
				sellPrice.setPriceId(orderList.getPriceId());
				sellPrice = sellPriceService.displaySellPrice(sellPrice);
				orderList.setSellPrice(sellPrice);

				GoodsPrice goodsPrice = new GoodsPrice();//规格
				goodsPrice.setGoodsPriceId(sellPrice.getGoodsPriceId());
				goodsPrice = goodsPriceService.displayGoodsPrice(goodsPrice);
				orderList.setGoodsPrice(goodsPrice);

				Commproduct commproduct = new Commproduct();
				commproduct.setProductId(goodsPrice.getProductId());
				commproduct = commproductService.displayCommproduct(commproduct);
				orderList.setCommproduct(commproduct);

				orderListList.add(orderList);
			}
			Consignee consignee = new Consignee();
			consignee.setUserId(getLoginUser(request).getUserId());
			List<Consignee> consigneeList = consigneeService.queryConsigneeList(consignee);

			view = new ModelAndView("/web/order/createOrder");
			view.addObject("orderListList",orderListList);
			view.addObject("consigneeList",consigneeList);
			view.addObject("newCcnsigneeId", PrimaryKeyUtil.generateKey());
			if (prepareOrderJsonObject.containsKey("price"))
			{
				view.addObject("price",prepareOrderJsonObject.getJSONObject("price").toJSONString());
			}
			view.addObject("user",getLoginUser(request));
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}


	/**
	 * ajax 创建订单
	 * param
	 * {newConsignee:新收货地址,consigneeId:收货地址Id,userId:用户Id,memo:备注,price:{priceType:销售类型,其他字段},orderListList[{priceId:销售id,num:数量,cartId:购物车Id}]}
	 */
	@RequestMapping(params = "method=createOrders")
	public void createOrders(String param,HttpServletRequest request,HttpServletResponse response) {
		Result result = null;
		try {

			JSONObject paramObject = JSON.parseObject(URLDecoder.decode(param, "UTF-8"));
			if (paramObject.containsKey("newConsignee"))
			{
				JSONObject newConsigneeObj = paramObject.getJSONObject("newConsignee");
				Consignee consignee = new Consignee();
				consignee.setConsigneeId(newConsigneeObj.getString("consigneeId"));
				consignee.setConsigneeId(newConsigneeObj.getString("consigneeId"));
				consignee.setUserId(newConsigneeObj.getString("userId"));
				consignee.setCustName(newConsigneeObj.getString("custName"));
				consignee.setCustPhone(newConsigneeObj.getString("custPhone"));
				consignee.setPcx(newConsigneeObj.getString("pcx"));
				consignee.setRecAddress(newConsigneeObj.getString("recAddress"));
				consignee.setIsDefault("0");
				Consignee consigneeDb = new Consignee();
				consigneeDb.setConsigneeId(consignee.getConsigneeId());
				consigneeDb = consigneeService.displayConsignee(consigneeDb);
				if(consigneeDb == null)
				{
					consigneeService.createConsignee(consignee);
				}else
				{
					consigneeService.updateConsignee(consignee);
				}
				paramObject.remove("newConsignee");
			}
			result = orderService.validateCreateOrder(paramObject);

		}catch (LogicException e1)
		{
			result = new Result();
			result.setResultCode("1");
			result.setResultMsg(e1.getMessage());
		}catch (Exception e)
		{
			log.error(e);
			result = new Result();
			result.setResultCode("1");
			result.setResultMsg("未知异常，请联系管理员");
		}
		try {
			response.setContentType("text/json;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(JSON.toJSONString(result));
		}catch (Exception e)
		{
			log.error(e);
		}
	}

	/**
	 * 确定快递已收货
	 */
	@RequestMapping(params = "method=closeOrderExpress")
	public void closeOrderExpress(String orderId,String userId,HttpServletRequest request,HttpServletResponse response)
	{
		Result result = new Result();
		try {
			if(orderId == null || orderId.trim().equals(""))
			{
				throw new  LogicException("请输入订单编号");
			}

			if(userId == null || userId.trim().equals(""))
			{
				throw new  LogicException("未找到操作人用户信息");
			}

			OrderExpress orderExpress = new OrderExpress();
			orderExpress.setStatus("1"); //已发货订单
			orderExpress.setOrderId(orderId);
			orderExpress.setDelTag("0");
			List<OrderExpress> orderExpressList = orderExpressService.queryOrderExpressList(orderExpress);

			User user = new User();
			user.setUserId(userId);
			user = userService.displayUser(user);

			for(OrderExpress orderExpressTmp : orderExpressList)
			{
				orderService.closeExpress(orderExpressTmp,user);
			}
			result.setResultCode("0");
			result.setResultMsg("订单收货完成");
		}catch (LogicException le)
		{
			result.setResultCode("1");
			result.setResultMsg(le.getMessage());
		}catch (Exception e) {
			result.setResultCode("1");
			result.setResultMsg("系统异常");
			log.error(e, e);
		}
		try {
			response.setContentType("text/json;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(JSON.toJSONString(result));
		}catch (Exception e)
		{
			log.error(e);
		}
	}

	/**
	 * 申请退货
	 * @param orderId
	 * @return
	 */
	@RequestMapping(params = "method=toOrderBack")
	public ModelAndView toOrderBack(String orderId,HttpServletRequest request)
	{
		ModelAndView view = null;
		try {
		  Order order = new Order();
		  order.setOrderId(orderId);
		  order = orderService.displayOrder(order);

      OrderList orderList = new OrderList();
      orderList.setOrderId(orderId);
      orderList.setDelFlag("0");
      List<OrderList> orderListList = orderListService.queryOrderListList(orderList);
      for (OrderList ol : orderListList)
      {
        SellPrice sellPrice = new SellPrice();
        sellPrice.setPriceId(ol.getPriceId());
        sellPrice = sellPriceService.displaySellPrice(sellPrice);
        ol.setSellPrice(sellPrice);
      }

      List<Pubmap> pubmapList = pubmapService.getPubmapListByType("BACKREASON");

			view = new ModelAndView("wx/order/orderBack");
			view.addObject("order",order);
      view.addObject("orderListList",orderListList);
      view.addObject("pubmapList",pubmapList);
		}catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

  /**
   * 创建申请退货
   * @param
   * @return
   */
  @RequestMapping(params = "method=createOrderBack")
  public ModelAndView createOrderBack(OrderBack orderBack,String serverIds,HttpServletRequest request)
  {
    ModelAndView view = null;
    try {
			view = new ModelAndView("redirect:/wxorder?method=toOrderList&orderListType=0");
			ServiceCode serviceCode = serviceCodeService.getServiceCodeBySpId(Destsp.currentSpId);
			wxSetViewObjects(view, request,serviceCode,userService);

			ModelMap modelMap = view.getModelMap();
			User user = (User) modelMap.get("user");
			if (user == null)
			{
			}else {
				OrderBack orderBackDb = new OrderBack();
				orderBackDb.setOrderId(orderBack.getOrderId());
				orderBackDb = orderBackService.displayOrderBack(orderBack);
				if (orderBackDb == null)
				{
					Map<String,String> param = new HashMap<>();
					param.put("orderId",orderBack.getOrderId());
					param.put("wxImgServiceIds",serverIds);
					param.put("backReason",orderBack.getBackReason());
					param.put("backReasonType",orderBack.getBackReasonType());
					orderBackService.orderAllBack(param,user);
				}
			}
    }catch (Exception e) {
      view = new ModelAndView("error");
      view.addObject("e", getExceptionInfo(e));
      log.error(e, e);
    }
    return view;
  }

	/**
	 * 去订单详情
	 */
	@RequestMapping(params = "method=toOrderBackDetail")
	public ModelAndView toOrderBackDetail(String orderId,HttpServletRequest request)
	{
		ModelAndView view = null;
		try {
			if (orderId== null || orderId.trim().equals(""))
			{
				throw new LoginException("请输入orderId");
			}
			Order order = new Order();
			order.setOrderId(orderId);
			order = orderService.displayOrder(order);

			OrderCustomer orderCustomer = new OrderCustomer();
			orderCustomer.setOrderId(order.getOrderId());
			orderCustomer = orderCustomerService.displayOrderCustomer(orderCustomer);

			OrderList orderList = new OrderList();
			orderList.setOrderId(orderId);
			orderList.setDelFlag("0");
			List<OrderList> orderListList = orderListService.queryOrderListList(orderList);
			for (OrderList ol : orderListList)
			{
				SellPrice sellPrice = new SellPrice();
				sellPrice.setPriceId(ol.getPriceId());
				sellPrice = sellPriceService.displaySellPrice(sellPrice);
				ol.setSellPrice(sellPrice);

				GoodsPrice goodsPrice = new GoodsPrice();//规格
				goodsPrice.setGoodsPriceId(ol.getGoodsPriceId());
				goodsPrice = goodsPriceService.displayGoodsPrice(goodsPrice);
				ol.setGoodsPrice(goodsPrice);

				Commproduct commproduct = new Commproduct();
				commproduct.setProductId(goodsPrice.getProductId());
				commproduct = commproductService.displayCommproduct(commproduct);
				ol.setCommproduct(commproduct);
			}

			OrderBack orderBack = new OrderBack();
			orderBack.setOrderId(order.getOrderId());
			orderBack = orderBackService.displayOrderBack(orderBack);

			RsPic rsPic = new RsPic();
			rsPic.setRsId(orderBack.getBackId());
			List<RsPic> rsPicList = rsPicService.queryRsPicList(rsPic);

			List<Pubmap> expressList = pubmapService.getPubmapListByType("EXPRESS");

			view = new ModelAndView("/wx/order/orderBackDetail");
			view.addObject("order",order);
			view.addObject("orderListList",orderListList);
			view.addObject("orderBack",orderBack);
			view.addObject("rsPicList",rsPicList);
			view.addObject("expressList",expressList);
		}catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 去订单详情
	 */
	@RequestMapping(params = "method=toOrderExpress")
	public ModelAndView toOrderExpress(String orderId,HttpServletRequest request)
	{
		ModelAndView view = null;
		try {
			if (orderId == null || orderId.trim().equals("")) {
				throw new LoginException("请输入orderId");
			}
			OrderExpress orderExpress = new OrderExpress();
			orderExpress.setOrderId(orderId);
			List<OrderExpress> orderExpressList = orderExpressService.queryOrderExpressList(orderExpress);
			view = new ModelAndView("/wx/order/orderExpressDetail");
			view.addObject("orderExpressList",orderExpressList);
		}catch (Exception e)
		{
			log.error(e);
		}
		return view;
	}

	/**
	 * 退货发货
	 */
	@RequestMapping(params = "method=sendGoods")
	public ModelAndView sendGoods(OrderBack orderBack, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		Result result = new Result();
		try {
			view = new ModelAndView("redirect:/wxorder?method=toOrderList&orderListType=0");
			ServiceCode serviceCode = serviceCodeService.getServiceCodeBySpId(Destsp.currentSpId);
			wxSetViewObjects(view, request,serviceCode,userService);
			ModelMap modelMap = view.getModelMap();
			User user = (User) modelMap.get("user");

			if (user == null)
			{
			}else {
				Map<String,String> param = new HashMap<>();
				param.put("backId",orderBack.getBackId());
				param.put("backGoodsEpmeCompany",orderBack.getBackGoodsEpmeCompany());
				param.put("backGoodsEpmeOrdCode",orderBack.getBackGoodsEpmeOrdCode());
				result = orderBackService.sendGoods(param,user);
			}
		}catch (Exception e) {
			log.error(e, e);
			result.setResultCode("1");
			result.setResultMsg("未知异常");
		}
		return view;
	}
  // 通过config接口注入权限
  @RequestMapping(params = "method=wxJsConfig")
  public void wxJsConfig(HttpServletRequest request,HttpServletResponse response,String spId,String url) {
    try {
      Destsp destsp = new Destsp();
      destsp.setSpId(spId);
      destsp = destspService.displayDestsp(destsp);

      ServiceCode serviceCode = new ServiceCode();
      serviceCode.setServiceId(destsp.getWxServiceId());
      serviceCode = serviceCodeService.displayServiceCode(serviceCode);

      String jsapiticket = WeixinService.getJsApiTicket(serviceCode);
      String timeStamp = Sha1Util.getTimeStamp();
      String nonceStr = Sha1Util.getNonceStr();

      SortedMap<String, String> paramMap = new TreeMap<String, String>();
      paramMap.put("noncestr", nonceStr);
      paramMap.put("jsapi_ticket", jsapiticket);
      paramMap.put("timestamp", timeStamp);
      url = URLDecoder.decode(url, "UTF-8");
      paramMap.put("url", url);

      String signature = Sha1Util.createSHA1Sign(paramMap);
      System.out.println("signature="+signature);

      HashMap<String, String> retMap = new HashMap<String, String>();
      retMap.put("appId", serviceCode.getAppId());
      retMap.put("timestamp", timeStamp);
      retMap.put("nonceStr", nonceStr);
      retMap.put("signature", signature);

      response.getWriter().print(
          net.sf.json.JSONObject.fromObject(retMap).toString());

    } catch (Exception e) {
      log.error(e, e);
      try {
        response.getWriter().print("");
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }
  }
	/**
	 * ajax 获取订单列表
	 */
	@RequestMapping(params = "method=ajaxOrderList")
	public void ajaxOrderList(Order order,int pageNum,int pageSize,HttpServletRequest request,HttpServletResponse response) {
		JSONObject result = new JSONObject();
		try {
			if(order.getEntityPage()==null){
				order.setEntityPage(new EntityPage());
			}
			order.getEntityPage().setSortField("t.F_CREATETIME");
			order.getEntityPage().setSortOrder("DESC");
			order.getEntityPage().setCurrentPage(pageNum);
			order.getEntityPage().setRowsPerPage(pageSize);
			PageHelper.startPage(super.getPageNum(order.getEntityPage()), super.getPageSize(order.getEntityPage()));
			List<Order> orderList =
					orderService.queryOrderList(order);
			PageInfo<Order> pageInfo = new PageInfo<Order>(orderList);
			//result.put("orderList",orderList);
			result.put("pageInfo",pageInfo);
		}catch (Exception e)
		{
			log.error(e);
		}
		try {
			response.setContentType("text/json;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			log.error(result.toJSONString());
			response.getWriter().write(result.toJSONString());
		}catch (Exception e)
		{
			log.error(e);
		}
	}

	/**
	 * ajax 获取订单的orderList列表
	 */
	@RequestMapping(params = "method=wxAjaxOrderDetail")
	public void wxAjaxOrderDetail(String orderId,HttpServletRequest request,HttpServletResponse response) {
		JSONObject object = new JSONObject();
		//验证微信用户
		try {
			if (orderId== null || orderId.trim().equals(""))
			{
				throw new LoginException("请输入orderId");
			}
			Order order = new Order();
			order.setOrderId(orderId);
			order = orderService.displayOrder(order);

			object.put("order",order);

			OrderCustomer orderCustomer = new OrderCustomer();
			orderCustomer.setOrderId(order.getOrderId());
			orderCustomer = orderCustomerService.displayOrderCustomer(orderCustomer);
			object.put("orderCustomer",orderCustomer);

			OrderList orderList = new OrderList();
			orderList.setOrderId(orderId);
			orderList.setDelFlag("0");
			List<OrderList> orderListList = orderListService.queryOrderListList(orderList);
			for (OrderList ol : orderListList)
			{
				SellPrice sellPrice = new SellPrice();
				sellPrice.setPriceId(ol.getPriceId());
				sellPrice = sellPriceService.displaySellPrice(sellPrice);
				ol.setSellPrice(sellPrice);

				GoodsPrice goodsPrice = new GoodsPrice();//规格
				goodsPrice.setGoodsPriceId(ol.getGoodsPriceId());
				goodsPrice = goodsPriceService.displayGoodsPrice(goodsPrice);
				ol.setGoodsPrice(goodsPrice);

				Commproduct commproduct = new Commproduct();
				commproduct.setProductId(goodsPrice.getProductId());
				commproduct = commproductService.displayCommproduct(commproduct);
				ol.setCommproduct(commproduct);
			}
			object.put("orderListList",orderListList);

			OrderBack orderBack = new OrderBack();
			orderBack.setOrderId(order.getOrderId());
			orderBack = orderBackService.displayOrderBack(orderBack);
			object.put("orderBack",orderBack);
		}catch (Exception e)
		{
			log.error(e);
		}
		try {
			response.setContentType("text/json;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(object.toJSONString());
		}catch (Exception e)
		{
			log.error(e);
		}
	}

	/*
	 * 获取用户默认的收货地址
	 * @param consignee.userId
	 */
	@RequestMapping(params = "method=getUserConsignee")
	public void getUserConsignee(Consignee consignee,HttpServletResponse response)
	{
		try {
			if ("1".equals(consignee.getDefaultFirst()))
			{
				EntityPage entityPage = new EntityPage();
				entityPage.setSortField("t.F_ISDEFAULT");
				entityPage.setSortOrder("DESC");
			}
			List<Consignee> consigneeList = consigneeService.queryConsigneeList(consignee);
			response.getWriter().write(net.sf.json.JSONArray.fromObject(consigneeList).toString());
		}catch (Exception e) {
			log.error(e, e);
		}
	}


	/*
	 * 获取用户默认的收货地址
	 * @param consignee.userId
	 */
	@RequestMapping(params = "method=getPriceExpress")
	public void getPriceExpress(String priceId,String num,String province,HttpServletResponse response)
	{
		Result result = new Result();
		result.setResultCode("0");
		try {
			if(priceId == null || priceId.trim().equals(""))
			{
				throw new LogicException("请确认销售物品");
			}
			if(num == null || num.trim().equals(""))
			{
				throw new LogicException("请确认销售数量");
			}
			result = companyExpressService.getCompanyPrice(priceId,num,province);
		}catch (LogicException le)
		{
			result.setResultCode("1");
			result.setResultMsg(le.getMessage());
		}
		catch (Exception e) {
			result.setResultCode("1");
			result.setResultMsg("系统内部异常");
			log.error(e, e);
		}
		try {
			response.getWriter().write(JSON.toJSONString(result).toString());
		}catch (Exception e)
		{

		}
	}
}

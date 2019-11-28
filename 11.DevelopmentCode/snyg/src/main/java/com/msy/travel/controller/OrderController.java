package com.msy.travel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.msy.travel.common.LogicException;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.Result;
import com.msy.travel.pojo.Commproduct;
import com.msy.travel.pojo.Company;
import com.msy.travel.pojo.OrderBack;
import com.msy.travel.pojo.OrderCustomer;
import com.msy.travel.pojo.OrderExpress;
import com.msy.travel.pojo.OrderList;
import com.msy.travel.pojo.Pubmap;
import com.msy.travel.service.CompanyExpressService;
import com.msy.travel.service.IPubmapService;
import com.msy.travel.service.OrderBackService;
import com.msy.travel.service.OrderCustomerService;
import com.msy.travel.service.OrderExpressService;
import com.msy.travel.service.OrderListService;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.pojo.User;

import com.msy.travel.common.BaseController;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.pojo.Order;
import com.msy.travel.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/order")
public class OrderController extends BaseController{
	public static final Log log = LogFactory.getLog(OrderController.class);

	@Resource(name = "pubmapServiceImpl")
	private IPubmapService pubmapService;

	@Resource(name = "orderServiceImpl")	
	private OrderService orderService;

	@Resource(name = "orderListServiceImpl")
	private OrderListService orderListService;

	@Resource(name = "companyExpressServiceImpl")
	private CompanyExpressService companyExpressService;

	@Resource(name = "orderExpressServiceImpl")
	private OrderExpressService orderExpressService;

	@Resource(name = "orderBackServiceImpl")
	private OrderBackService orderBackService;

	@Resource(name = "orderCustomerServiceImpl")
	private OrderCustomerService orderCustomerService;

	@RequestMapping(params = "method=toAddCompanyRemark")
	public ModelAndView toAddPlatFormRemark(Order order,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			order = orderService.displayOrder(order);
			view = new ModelAndView("order/addCompanyRemark");
			view.addObject("order",order);
		}catch (Exception e)
		{
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}


	@RequestMapping(params = "method=toRefuseOrder")
	public ModelAndView toRefuseOrder(Order order,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			order = orderService.displayOrder(order);
			OrderBack orderBack = new OrderBack();
			orderBack.setOrderId(order.getOrderId());
			List<OrderBack> orderBackList = orderBackService.queryOrderBackList(orderBack);
			if (orderBackList.size()>0)
			{
				throw new LogicException("已有退订记录，不能再次退订");
			}
			List<Pubmap> pubmapList = pubmapService.getPubmapListByType("BACKREASON");

			view = new ModelAndView("order/refuseOrder");
			view.addObject("order",order);
			view.addObject("pubmapList",pubmapList);
		}catch (Exception e)
		{
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}


	/**
	 * refuseOrder 确认拒绝
	 */
	@RequestMapping(params = "method=refuseOrder")
	public void refuseOrder(OrderBack orderBack,HttpServletRequest request,HttpServletResponse response) {
		Result result = new Result();
		try {
			if (orderBack.getOrderId() == null || orderBack.getOrderId().trim().equals(""))
			{
				throw  new LogicException("order id = null");
			}
			orderBack.setOrderId(orderBack.getOrderId());
			List<OrderBack> orderBackList = orderBackService.queryOrderBackList(orderBack);
			if(orderBackList.size()>0)
			{
				throw  new LogicException("订单已退订");
			}
			Map<String,String> param = new HashMap<>();
			param.put("orderId",orderBack.getOrderId());
			param.put("backReason",orderBack.getBackReason());
			param.put("backReasonType",orderBack.getBackReasonType());
			result = orderService.refuseOrder(param,getLoginUser(request));
		} catch (LogicException  e1){
			result.setResultCode("1");
			result.setResultCode(e1.getMessage());
		}
		catch (Exception  e){
			result.setResultCode("1");
			result.setResultCode("系统异常");
		}finally {
			try {
				response.getWriter().write(JSON.toJSONString(result));
			}catch (Exception e1)
			{
				log.error(e1);
			}
		}
	}

	/**
	 * 新增Order CompanyRemark
	 */
	@RequestMapping(params = "method=addCompanyRemark")
	public void addCompanyRemark(Order order,HttpServletRequest request,HttpServletResponse response) {
		String result = "1";
		try {
			if (order.getOrderId() == null || order.getOrderId().trim().equals(""))
			{
				throw  new LogicException("order id = null");
			}
			orderService.updateOrderCompanyRemark(order.getOrderId(),order.getCompanyRemark(),getLoginUser(request));

		} catch (Exception  e){
			result = "0";
			log.error(e, e);
		}finally {
			try {
				response.getWriter().write(result);
			}catch (Exception e1)
			{
				log.error(e1);
			}
		}

	}

	/**
	 * 分页查询
	 * order 查询参数
	 * queryOrderStatus订单状态(0，未支付，1待确认，2已发货，3确认拒绝，4已收货，6已退货，7已关闭)
	 * shortCuts 快捷方式查询  0.最近十天订单 1.未关闭待付款 2待确认 ，3.待收货，4退货/退款
	 */
	@RequestMapping(params = "method=query")
	public ModelAndView queryOrderList(Order order,String queryOrderStatus,String shortCuts,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try {
				 if(order.getEntityPage()==null){
					 order.setEntityPage(new EntityPage());
		         }
				order.getEntityPage().setSortField("t.F_CREATETIME");
				order.getEntityPage().setSortOrder("DESC");
				order.setSpId(getLoginUser(request).getAccId());
				Order searchOrder = new Order();
				searchOrder.setEntityPage(order.getEntityPage());
				if (shortCuts != null && !shortCuts.trim().equals("")) //快捷方式
				{
					//快捷方式查询 0.最近十天订单 1.未关闭待付款 2待确认 ，3.待收货，4退货/退款
					if ("0".equals(shortCuts))
					{
						String dateEnd = DateTimeUtil.getDateTime10();
						String dateStart = DateTimeUtil.addDate("yyyy-MM-dd", dateEnd, "-9");
						searchOrder.setCreateTimeS(dateStart);
						searchOrder.setCreateTimeE(dateEnd);
					}else if("1".equals(shortCuts))
					{
						searchOrder.setPayTag("0");
						searchOrder.setBeforePayStatus("0");
					}else if("2".equals(shortCuts))
					{
						searchOrder.setPayTag("1");
						searchOrder.setStatus("0");
					}else if("3".equals(shortCuts))
					{
						searchOrder.setPayTag("1");
						searchOrder.setStatus("1");
					}else if("4".equals(shortCuts))
					{
						searchOrder.setBackNumS("1");
					}
				}else //查询条件
				{
					searchOrder.setOrderCodeLike(order.getOrderCodeLike());
					searchOrder.setPriceType(order.getPriceType());
					searchOrder.setOrderCodeLike(order.getOrderCodeLike());
					searchOrder.setProductNameLike(order.getProductNameLike());
					searchOrder.setCustPhoneLike(order.getCustPhoneLike());
					searchOrder.setCustNameLike(order.getCustNameLike());
					searchOrder.setMoneyS(order.getMoneyS());
					searchOrder.setMoneyE(order.getMoneyE());
					searchOrder.setCreateTimeS(order.getCreateTimeS());
					searchOrder.setCreateTimeE(order.getCreateTimeE());

					//订单状态(0，未支付，1待确认，2已发货，3确认拒绝，4已收货，6已退货，7已关闭)
					if (queryOrderStatus != null && !queryOrderStatus.trim().equals("")) //如果商户选择了自己的状态
					{
						if ("0".equals(queryOrderStatus)) //未支付
						{
							searchOrder.setPayTag("0");
						}else if("1".equals(queryOrderStatus))//1待确认
						{
							searchOrder.setPayTag("1");
							searchOrder.setStatus("0");
						}else if("2".equals(queryOrderStatus)) //2已发货
						{
							searchOrder.setPayTag("1");
							searchOrder.setStatus("1");
						}else if("3".equals(queryOrderStatus)) //3确认拒绝
						{
							searchOrder.setPayTag("1");
							searchOrder.setStatus("3");
						}else if("4".equals(queryOrderStatus)) //4已收货
						{
							searchOrder.setPayTag("1");
							searchOrder.setStatus("2");
						}else if("6".equals(queryOrderStatus)) //6已退货
						{
							searchOrder.setBackNumS("1");
						}	else if("7".equals(queryOrderStatus)) //7-订单关闭（定时、后台）
						{
							searchOrder.setPayTag("1");
							searchOrder.setStatus("5");
						}
					}
				}

				if (searchOrder.getCreateTimeS() != null && !searchOrder.getCreateTimeS().equals(""))
				{
					searchOrder.setCreateTimeS(searchOrder.getCreateTimeS()+" 00:00:00");
				}
				if (searchOrder.getCreateTimeE() != null && !searchOrder.getCreateTimeE().equals(""))
				{
					searchOrder.setCreateTimeE(searchOrder.getCreateTimeE()+" 23:59:59");
				}

				Order staticOrder = orderService.queryOrderListStatic(searchOrder);
				 super.saveBackUrl(request);
	        	// 设置分页
				PageHelper.startPage(super.getPageNum(searchOrder.getEntityPage()), super.getPageSize(searchOrder.getEntityPage()));
				List<Order>  orderList =
		        			orderService.queryOrderList(searchOrder);
	      PageInfo<Order> pageInfo = new PageInfo<Order>(orderList);

	      for(int i=0;i<orderList.size();i++)
				{
					OrderList orderListTmp = new OrderList();
					orderListTmp.setOrderId(orderList.get(i).getOrderId());
					orderListTmp.setDelFlag("0");
					orderList.get(i).setOrderListList(orderListService.queryOrderListList(orderListTmp));
					OrderBack orderBack = new OrderBack();
					orderBack.setOrderId(orderList.get(i).getOrderId());
					List<OrderBack> orderBackList = orderBackService.queryOrderBackList(orderBack);
					if (orderBackList.size()>0)
					{
						orderList.get(i).setBackId(orderBackList.get(0).getBackId());
					}
				}
				view = new ModelAndView("order/queryOrder");
				view.addObject("orderList", orderList);
				view.addObject("entityPage", searchOrder.getEntityPage());
				view.addObject("pageInfo", pageInfo);
				view.addObject("order", order);
				view.addObject("queryOrderStatus", queryOrderStatus);
				view.addObject("shortCuts", shortCuts);
				view.addObject("staticOrder", staticOrder);
			} catch (Exception e) {
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
			}
			return view; 
	}

	/**
	 * 跳转到 订单发货页面
	 */
	@RequestMapping(params = "method=toAddExpress")
	public ModelAndView toAddExpress(Order order, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			List<Pubmap> expressList = pubmapService.getPubmapListByType("EXPRESS");

			order = orderService.displayOrder(order);

			OrderList orderList = new OrderList();
			orderList.setOrderId(order.getOrderId());
			orderList.setOrderListType("0");
			List<OrderList> orderListList = orderListService.queryOrderListList(orderList);
			for (int i=0;i<orderListList.size();i++)
			{
				OrderExpress orderExpress = new OrderExpress();
				orderExpress.setOrderId(orderListList.get(i).getOrderId());
				orderExpress.setOneOrderListId(orderListList.get(i).getOrderListId());
				orderExpress.setDelTag("0");
				List<OrderExpress> orderExpressList = orderExpressService.queryOrderExpressList(orderExpress);
				orderListList.get(i).setOrderExpressList(orderExpressList);
			}
			Result result = companyExpressService.getCompanyPrice(orderListList.get(0).getPriceId(),orderListList.get(0).getNum(),order.getRecAddress().split(" ")[0]);
			String expressCode = null;
			if (result.getResultCode().equals("0"))
			{
				JSONObject expressResultPojo = (JSONObject) result.getResultPojo();
				expressCode = expressResultPojo.getString("expressCode");
			}
			view = new ModelAndView("order/addOrderListExpress");
			view.addObject("order", order);
			view.addObject("expressCode", expressCode);
			view.addObject("orderListList", orderListList);
			view.addObject("expressList", expressList);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 订单发货
	 *       orderListId:delIds,
	 *       epmeCompany:epmeCompany,
	 *       epmeOrdCode:epmeOrdcode
	 */
	@RequestMapping(params = "method=addExpress")
	public void addExpress(OrderExpress orderExpress
			, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			User operator = getLoginUser(request);
			if (orderExpress.getOrderListId() == null || orderExpress.getOrderListId().trim().equals(""))
			{
				throw new LogicException("订单明细未设置");
			}
			if (orderExpress.getEpmeCompany() == null || orderExpress.getEpmeCompany().trim().equals(""))
			{
				throw new LogicException("快递公司未设置");
			}
			if (orderExpress.getEpmeOrdCode() == null || orderExpress.getEpmeOrdCode().trim().equals(""))
			{
				throw new LogicException("快递单号未设置");
			}

			OrderList orderList = new OrderList();
			orderList.setOrderListId(orderExpress.getOrderListId().split(",")[0]);
			orderList = orderListService.displayOrderList(orderList);

			OrderExpress orderExpressDb = new OrderExpress();
			orderExpressDb.setOrderListId(orderExpress.getOrderListId());
			orderExpressDb.setEpmeOrdCode(orderExpress.getEpmeOrdCode());
			orderExpressDb.setEpmeCompany(orderExpress.getEpmeCompany());
			orderExpressDb.setOrderExpressId(PrimaryKeyUtil.generateKey());
			orderExpressDb.setOrderId(orderList.getOrderId());
			orderExpressDb.setVenId(orderList.getVenId());
			orderExpressDb.setSpId(operator.getAccId());
			orderExpressDb.setDelTag("0");
			orderExpressDb.setCreateTime(DateTimeUtil.getDateTime19());
			orderExpressDb.setCreator(operator.getUserName());
			orderExpressDb.setCreatorUID(operator.getUserId());
			orderExpressDb.setUpdateTime(orderExpressDb.getCreateTime());
			orderExpressDb.setUpdateUID(operator.getUserId());
			orderExpressDb.setUpdater(operator.getUserName());
			orderExpressDb.setStatus("1");
			orderService.addExpress(orderExpressDb,operator);
			result.setResultCode("0");
			result.setResultMsg("发货成功");
		}catch (LogicException e1)
		{
			result.setResultCode("1");
			result.setResultMsg(e1.getMessage());
		}catch (Exception e) {
			log.error(e, e);
			result.setResultCode("1");
			result.setResultMsg("未知");
		}
		try {
			response.getWriter().write(JSON.toJSONString(result));
		}catch (Exception e)
		{
			log.error(e);
		}
	}


	/**
	 * 关闭订单
	 */
	@RequestMapping(params = "method=closeOrder")
	public ModelAndView closeOrder(Order order, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Result result = orderService.changeOrderStatus(order.getOrderId(),"5",getLoginUser(request));
			if (!"0".equals(result.getResultCode()))
			{
				throw new LogicException(result.getResultMsg());
			}
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}


	/**
	 * 跳转到详细页面
	 */
	@RequestMapping(params = "method=toDetail")
	public ModelAndView toDetailOrder(Order order,String readOnly, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			order = orderService.displayOrder(order);

			OrderList orderlist = new OrderList();
			orderlist.setOrderId(order.getOrderId());
			orderlist.setOrderListType("0");
			List<OrderList> orderListList = orderListService.queryOrderListList(orderlist);

			OrderCustomer orderCustomer = new OrderCustomer();
			orderCustomer.setOrderId(order.getOrderId());
			orderCustomer = orderCustomerService.displayOrderCustomer(orderCustomer);

			OrderExpress orderExpress = new OrderExpress();
			orderExpress.setOrderId(order.getOrderId());
			List<OrderExpress> orderExpressList = orderExpressService.queryOrderExpressList(orderExpress);
			List<Company> companyList = new ArrayList<Company>();

			view = new ModelAndView("order/detailOrder");
			view.addObject("order", order);
			view.addObject("readOnly", readOnly);
			view.addObject("orderListList", orderListList);
			view.addObject("orderCustomer", orderCustomer);
			view.addObject("companyList", companyList);
			view.addObject("orderExpressList", orderExpressList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

}

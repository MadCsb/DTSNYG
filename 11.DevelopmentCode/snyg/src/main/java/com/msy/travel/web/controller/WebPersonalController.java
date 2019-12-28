package com.msy.travel.web.controller;

import com.alibaba.dubbo.common.URL;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.MD5;
import com.msy.travel.common.ResourceCommon;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.*;
import com.msy.travel.service.CommproductService;
import com.msy.travel.service.GoodsPriceService;
import com.msy.travel.service.IArticleService;
import com.msy.travel.service.OrderCustomerService;
import com.msy.travel.service.OrderListService;
import com.msy.travel.service.OrderService;
import com.msy.travel.service.ShopcartService;
import net.sf.json.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 微信web用户
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/webPersonal")
public class WebPersonalController extends BaseController {
	public static final Log log = LogFactory.getLog(WebPersonalController.class);

	@Resource(name = "orderServiceImpl")
	private OrderService orderService;

	@Resource(name = "shopcartServiceImpl")
	private ShopcartService shopcartService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Resource(name = "orderCustomerServiceImpl")
	private OrderCustomerService orderCustomerService;

	@Resource(name = "goodsPriceServiceImpl")
	private GoodsPriceService goodsPriceService;

	@Resource(name = "commproductServiceImpl")
	private CommproductService commproductService;

	@Resource(name = "orderListServiceImpl")
	private OrderListService orderListService;

	private void setCommonPersonalObject(ModelAndView view,HttpServletRequest request, HttpServletResponse response)
	{
		view.addObject("user",getLoginUser(request));
	}
	/**
	 * 个人中心
	 *
	 * @return
	 */
	@RequestMapping(params = "method=index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Order order = new Order();
			order.setEntityPage(new EntityPage());
			order.getEntityPage().setSortField("t.F_CREATETIME");
			order.getEntityPage().setSortOrder("DESC");
			order.setUserId(getLoginUser(request).getUserId());
			order.setPayTag("0");
			order.setBeforePayStatus("0");
			PageHelper.startPage(1, 10);
			List<Order> orderList = orderService.queryOrderList(order);
			PageInfo<Order> orderPageInfo = new PageInfo<Order>(orderList);

			Shopcart shopcart = new Shopcart();
			shopcart.setUserId(getLoginUser(request).getUserId());
			shopcart.setDelFlag("0");
			PageHelper.startPage(1, 10);
			List<Shopcart> shopcartList = shopcartService.queryShopcartList(shopcart);
			PageInfo<Shopcart> shopcartPageInfo = new PageInfo<Shopcart>(shopcartList);

			view = new ModelAndView("web/personal/index");
			view.addObject("orderList",orderList);
			view.addObject("shopcartList",shopcartList);
			setCommonPersonalObject(view,request,response);

		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}



	/**
	 * 进入个人订单列表
	 * userId 用户Id
	 * orderListType = 0 全部订单
	 * orderListType = 1 待支付
	 * orderListType = 2 待发货
	 * orderListType = 3 待收货
	 * orderListType = 4 退换货
	 * @return
	 */
	@RequestMapping(params = "method=toOrderList")
	public ModelAndView toOrderList(String orderListType,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("/web/personal/orderList");
			view.addObject("orderListType",orderListType);
			setCommonPersonalObject(view,request,response);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 去订单详情
	 */
	@RequestMapping(params = "method=toOrderDetail")
	public ModelAndView toOrderDetail(String orderId,HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView view = null;
		try {
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

				GoodsPrice goodsPrice = new GoodsPrice();//规格
				goodsPrice.setGoodsPriceId(ol.getGoodsPriceId());
				goodsPrice = goodsPriceService.displayGoodsPrice(goodsPrice);
				ol.setGoodsPrice(goodsPrice);

				Commproduct commproduct = new Commproduct();
				commproduct.setProductId(goodsPrice.getProductId());
				commproduct = commproductService.displayCommproduct(commproduct);
				ol.setCommproduct(commproduct);
			}

			view = new ModelAndView("/web/personal/orderDetail");
			view.addObject("order",order);
			view.addObject("orderCustomer",orderCustomer);
			view.addObject("orderListList",orderListList);
			view.addObject("orderId",orderId);
			view.addObject("wxpayValidateTime",configParameter.getWxpayValidateTime());
			setCommonPersonalObject(view,request,response);
		}catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

}

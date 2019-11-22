package com.msy.travel.task;

import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.LogicException;
import com.msy.travel.common.Result;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Commproduct;
import com.msy.travel.pojo.Company;
import com.msy.travel.pojo.Order;
import com.msy.travel.pojo.OrderBack;
import com.msy.travel.pojo.OrderCustomer;
import com.msy.travel.pojo.OrderExpress;
import com.msy.travel.pojo.OrderList;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IFeedbackService;
import com.msy.travel.service.IWxMenuService;
import com.msy.travel.service.OrderExpressService;
import com.msy.travel.service.OrderService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Component
public class Scheduled{
	public static final Log log = LogFactory.getLog(Scheduled.class);

	@Resource(name = "orderServiceImpl")
	private OrderService orderService;

	@Resource(name = "orderExpressServiceImpl")
	private OrderExpressService orderExpressService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	/**
	 * 每分钟 ，自动关闭超时未支付订单，不需要异步
	 */
	@org.springframework.scheduling.annotation.Scheduled(cron="0 * * * * ? ")
	public void closeNotPayOrder() {
		List<Order> orderList = null;
		try {
			Order order = new Order();
			order.setDelFlag("0");
			order.setPayTag("0"); //未支付
			order.setBeforePayStatus("0"); //支付前状态正常

			SimpleDateFormat sdf = new SimpleDateFormat(DateTimeUtil.sdf19);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.SECOND,0-Integer.valueOf(configParameter.getWxpayValidateTime())-1);
			order.setCreateTimeE(sdf.format(cal.getTime()));
			orderList = orderService.queryOrderList(order);
		}catch (Exception e)
		{
			log.error("定时关闭超时未支付订单：获取订单列表失败");
		}
		if (orderList != null)
		{
			for (int i=0;i<orderList.size();i++)
			{
				try {
					orderService.closeUnPayOrder(orderList.get(i).getOrderId(),null);
				}catch (Exception e)
				{
					log.error("定时关闭超时未支付订单：订单ID【"+orderList.get(i).getOrderId()+"】失败");
				}
			}
		}

	}


	/**
	 * 每天1点开始，自动【已收货】超过七天的快递单，待接入快递100以后取消该定时器
	 */
	@Async
	@org.springframework.scheduling.annotation.Scheduled(cron="0 0 1 * * ? ")
	public void closeOrderExpress() {
		List<OrderExpress> orderExpressList = null;
		try {
			OrderExpress orderExpress = new OrderExpress();
			orderExpress.setStatus("1"); //已发货订单

			SimpleDateFormat sdf = new SimpleDateFormat(DateTimeUtil.sdf19);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE,0-Integer.valueOf(configParameter.getOrderExpressCloseDay()));
			orderExpress.setCreateTimeE(sdf.format(cal.getTime()));
			orderExpressList = orderExpressService.queryOrderExpressList(orderExpress);
		}catch (Exception e)
		{
			log.error("定时关闭超时未支付订单：获取订单列表失败");
		}
		if (orderExpressList != null)
		{
			for (int i=0;i<orderExpressList.size();i++)
			{
				try {
					orderService.closeExpress(orderExpressList.get(i),null);
				}catch (Exception e)
				{
					log.error("定时关闭超时订单快递：订单ID【"+orderExpressList.get(i).getOrderId()+"】,快递公司【"+orderExpressList.get(i).getEpmeCompany()+"】,快递单号【"+orderExpressList.get(i).getEpmeOrdCode()+"】失败");
				}
			}
		}
	}


	/**
	 * 每天1点开始，自动把已收货超过30天的订单 设置为已关闭订单
	 */
	@Async
	@org.springframework.scheduling.annotation.Scheduled(cron="0 0 1 * * ? ")
	public void closeOrder() {
		List<Order> orderList = null;
		try {
			Order order = new Order();
			order.setPayType("1");
			order.setStatus("2");

			SimpleDateFormat sdf = new SimpleDateFormat(DateTimeUtil.sdf19);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE,0-Integer.valueOf(configParameter.getOrderCloseDay()));
			order.setCreateTimeE(sdf.format(cal.getTime()));
			orderList = orderService.queryOrderList(order);
		}catch (Exception e)
		{
			log.error("定时关闭超时已收货订单：获取订单列表失败");
		}
		if (orderList != null)
		{
			for (int i=0;i<orderList.size();i++)
			{
				try {
					Result result = orderService.changeOrderStatus(orderList.get(i).getOrderId(),"5",null);
					if ("1".equals(result.getResultCode()))
					{
						throw new LogicException(result.getResultMsg());
					}
				}catch (Exception e)
				{
					log.error("定时关闭已收货订单：订单ID【"+orderList.get(i).getOrderId()+"】失败,未知异常");
				}
			}
		}
	}

}

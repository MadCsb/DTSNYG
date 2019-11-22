package com.msy.travel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.msy.travel.common.BigDecimalUtil;
import com.msy.travel.common.LogicException;
import com.msy.travel.common.Result;
import com.msy.travel.common.SysConsts;
import com.msy.travel.pojo.Company;
import com.msy.travel.pojo.Order;
import com.msy.travel.pojo.OrderCustomer;
import com.msy.travel.pojo.OrderList;
import com.msy.travel.pojo.OrderLog;
import com.msy.travel.pojo.RsPic;
import com.msy.travel.service.CompanyService;
import com.msy.travel.service.IRsPicService;
import com.msy.travel.service.OrderCustomerService;
import com.msy.travel.service.OrderListService;
import com.msy.travel.service.OrderLogService;
import com.msy.travel.service.OrderService;
import com.msy.travel.service.impl.RsPicServiceImpl;
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
import com.msy.travel.pojo.OrderBack;
import com.msy.travel.service.OrderBackService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/orderBack")
public class OrderBackController extends BaseController{
	public static final Log log = LogFactory.getLog(OrderBackController.class);

	@Resource(name = "orderBackServiceImpl")	
	private OrderBackService orderBackService;


	@Resource(name = "orderServiceImpl")
	private OrderService orderService;

	@Resource(name = "orderCustomerServiceImpl")
	private OrderCustomerService orderCustomerService;

	@Resource(name = "orderLogServiceImpl")
	private OrderLogService orderLogService;

	@Resource(name = "rsPicServiceImpl")
	private IRsPicService rsPicService;

	@Resource(name = "orderListServiceImpl")
	private OrderListService orderListService;

	@Resource(name = "companyServiceImpl")
	private CompanyService companyService;

	/**
	 * 分页查询
	 * order 查询参数
	 * shortCuts 快捷方式查询   0.近十天申请 1.待受理 2 待收货 ，3.待付款，4已关闭
	 *
	 */
	@RequestMapping(params = "method=query")
	public ModelAndView queryOrderBackList(OrderBack orderBack,String shortCuts,HttpServletRequest request,HttpServletResponse response)  {
		ModelAndView view = null;
		try {
			if(orderBack.getEntityPage()==null){
				orderBack.setEntityPage(new EntityPage());
			}
			orderBack.getEntityPage().setSortField("t.F_APPLYTIME");
			orderBack.getEntityPage().setSortOrder("DESC");
			orderBack.setSpId(getLoginUser(request).getAccId());

			OrderBack searchOrderBack = new OrderBack();
			searchOrderBack.setEntityPage(orderBack.getEntityPage());
			if (shortCuts != null && !shortCuts.trim().equals("")) //快捷方式
			{
				//快捷方式查询 0.近十天申请 1.待受理 2 待收货 ，3.待付款，4已关闭
				if ("0".equals(shortCuts))
				{
					String dateEnd = DateTimeUtil.getDateTime10();
					String dateStart = DateTimeUtil.addDate("yyyy-MM-dd", dateEnd, "-9");
					searchOrderBack.setApplyTimeS(dateStart);
					searchOrderBack.setApplyTimeE(dateEnd);
				}else if("1".equals(shortCuts))
				{
					searchOrderBack.setStatus("1");
				}else if("2".equals(shortCuts))
				{
					searchOrderBack.setStatus("4");
					searchOrderBack.setBackGoodsStatus("1");
				}else if("3".equals(shortCuts))
				{
					searchOrderBack.setStatus("5");
					searchOrderBack.setBackMoneyStatus("0");
				}else if("4".equals(shortCuts))
				{
					searchOrderBack.setStatus("6");
				}
			}else //查询条件
			{
				//退款单编号 backCodeLike 订单编号orderCodeLike 买家手机号custPhoneLike 买家名称custNameLike
				//退款状态 1-申请退订2-受理3-不受理4-退货5-退款6-关闭 status
				//退款金额 applyBackMoneyS applyBackMoneyE
				//时间范围  申请时间 applyTimeS applyTimeE |收货时间 backGoodsReceiveTimeS backGoodsReceiveTimeE|退款时间 backMoneyReceiveTimeS backMoneyReceiveTimeE
				//
				searchOrderBack.setSpId(orderBack.getSpId());
				searchOrderBack.setBackCodeLike(orderBack.getBackCodeLike());
				searchOrderBack.setOrderCodeLike(orderBack.getOrderCodeLike());
				searchOrderBack.setCustPhoneLike(orderBack.getCustPhoneLike());
				searchOrderBack.setCustNameLike(orderBack.getCustNameLike());
				searchOrderBack.setStatus(orderBack.getStatus());
				searchOrderBack.setApplyBackMoneyS(orderBack.getApplyBackMoneyS());
				searchOrderBack.setApplyBackMoneyE(orderBack.getApplyBackMoneyE());
				searchOrderBack.setApplyTimeS(orderBack.getApplyTimeS());
				searchOrderBack.setApplyTimeE(orderBack.getApplyTimeE());
				searchOrderBack.setBackGoodsReceiveTimeS(orderBack.getBackGoodsReceiveTimeS());
				searchOrderBack.setBackGoodsReceiveTimeE(orderBack.getBackGoodsReceiveTimeE());
				searchOrderBack.setBackMoneyReceiveTimeS(orderBack.getBackMoneyReceiveTimeS());
				searchOrderBack.setBackMoneyReceiveTimeE(orderBack.getBackMoneyReceiveTimeE());
			}

			if (searchOrderBack.getApplyTimeS() != null && !searchOrderBack.getApplyTimeS().equals(""))
			{
				searchOrderBack.setApplyTimeS(searchOrderBack.getApplyTimeS()+" 00:00:00");
			}
			if (searchOrderBack.getApplyTimeE() != null && !searchOrderBack.getApplyTimeE().equals(""))
			{
				searchOrderBack.setApplyTimeE(searchOrderBack.getApplyTimeE()+" 23:59:59");
			}


			OrderBack staticOrderBack = orderBackService.queryOrderBackListStatic(searchOrderBack);
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(searchOrderBack.getEntityPage()), super.getPageSize(searchOrderBack.getEntityPage()));
			List<OrderBack>  orderBackList =
					orderBackService.queryOrderBackList(searchOrderBack);
			PageInfo<OrderBack> pageInfo = new PageInfo<OrderBack>(orderBackList);

			view = new ModelAndView("orderBack/queryOrderBack");
			view.addObject("orderBackList", orderBackList);
			view.addObject("entityPage", searchOrderBack.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("orderBack", orderBack);
			view.addObject("shortCuts", shortCuts);
			view.addObject("staticOrderBack", staticOrderBack);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}


	/**
	 * 跳转到退款详情页面
	 */
	@RequestMapping(params = "method=detailOrderBack")
	public ModelAndView detailOrderBack(OrderBack orderBack,String readOnly, HttpServletRequest request, HttpServletResponse response) {

		ModelAndView view = null;
		try {

			// 退款单信息
			orderBack = orderBackService.displayOrderBack(orderBack);

			JSONArray orderListJSON = JSON.parseArray(orderBack.getBackData());
			List<OrderList> orderListList = new ArrayList<>();
			for (int i=0;i<orderListJSON.size();i++)
			{
				OrderList orderList = new OrderList();
				orderList.setOrderListId(orderListJSON.getJSONObject(i).getString("orderListId"));
				orderList = orderListService.displayOrderList(orderList);
				orderList.setBackNum(orderListJSON.getJSONObject(i).getString("num"));
				orderListList.add(orderList);
			}

			// 订单信息
			Order order = new Order();
			order.setOrderId(orderBack.getOrderId());
			order = orderService.displayOrder(order);

			// 订单表的游客信息
			OrderCustomer orderCustomer = new OrderCustomer();
			orderCustomer.setOrderId(orderBack.getOrderId());
			orderCustomer = orderCustomerService.displayOrderCustomer(orderCustomer);

			// 检索日志
			OrderLog orderLog = new OrderLog();
			orderLog.setLinkId(orderBack.getBackId());
			orderLog.setType("2"); // 日志类型:1订单日志，2退订日志
			orderLog.setEntityPage(new EntityPage());
			orderLog.getEntityPage().setSortField("F_OPTIME");
			List<OrderLog> orderLogList = orderLogService.queryOrderLogList(orderLog);

			// 检索退款图片
			RsPic rsPic = new RsPic();
			rsPic.setRsId(orderBack.getBackId());
			rsPic.setRsType(SysConsts.RSTYPE_ORDERBACKPIC);
			if (rsPic.getEntityPage() == null) {
				rsPic.setEntityPage(new EntityPage());
			}
			rsPic.getEntityPage().setSortField("t.F_ORDER");
			rsPic.getEntityPage().setSortOrder("ASC");
			List<RsPic> rsPicList = this.rsPicService.queryRsPicList(rsPic);

			view = new ModelAndView("orderBack/detailOrderBack");
			view.addObject("orderBack", orderBack);
			view.addObject("order", order);
			view.addObject("readOnly", readOnly);
			view.addObject("orderListList",orderListList);
			view.addObject("orderCustomer", orderCustomer);
			view.addObject("orderLogList", orderLogList);
			view.addObject("rsPicList", rsPicList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 跳转操作退单页面
	 * @param orderBack
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "method=toOpOrderBack")
	public ModelAndView toOpOrderBack(OrderBack orderBack,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			OrderBack orderBackDb = new OrderBack();
			orderBackDb.setBackId(orderBack.getBackId());
			orderBackDb = orderBackService.displayOrderBack(orderBackDb);
			orderBackDb.setStatus(orderBack.getStatus());

			OrderList orderList = new OrderList();
			orderList.setOrderId(orderBackDb.getOrderId());
			List<OrderList> orderListList = orderListService.queryOrderListList(orderList);

			Company company = new Company();
			company.setVenId(orderListList.get(0).getVenId());
			company = companyService.displayCompany(company);

			view = new ModelAndView("orderBack/opOrderBack");
			view.addObject("orderBack",orderBackDb);
			view.addObject("company",company);
		}catch (Exception e)
		{
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}


	/**
	 * 操作退单
	 */
	@RequestMapping(params = "method=opOrderBack")
	public void opOrderBack(OrderBack orderBack,HttpServletRequest request,HttpServletResponse response) {
		Result result = null;
		try {
			User loginUser = getLoginUser(request);
			Map<String,String> param = new HashMap<>();
			if("2".equals(orderBack.getStatus())) //受理
			{
				param.put("backId",orderBack.getBackId());
				param.put("backGoodsName",orderBack.getBackGoodsName());
				param.put("backGoodsPhone",orderBack.getBackGoodsPhone());
				param.put("backGoodsAddr",orderBack.getBackGoodsAddr());
				result = orderBackService.agressOrderBack(param,loginUser);
			}else if("3".equals(orderBack.getStatus())) //拒绝
			{
				param.put("backId",orderBack.getBackId());
				param.put("refuseReason",orderBack.getRefuseReason());
				result = orderBackService.refuseOrderBack(param,loginUser);
			}else if("6".equals(orderBack.getStatus())) //关闭
			{
				param.put("backId",orderBack.getBackId());
				param.put("backMoney",orderBack.getBackMoney());
				result = orderBackService.receiveMoney(param,loginUser);
			}
		} catch (Exception  e){
			result = new Result();
			result.setResultCode("1");
			result.setResultMsg("系统错误");
			log.error(e, e);
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
	 * 关闭订单
	 */
	@RequestMapping(params = "method=receiveGoods")
	public void receiveGoods(OrderBack orderBack, HttpServletRequest request, HttpServletResponse response) {
		Result result = null;
		try {
			Map<String, String> param = new HashMap<>();
			param.put("backId",orderBack.getBackId());
			User loginUser = getLoginUser(request);
			result = orderBackService.receiveGoods(param,loginUser);
		}catch (Exception e)
		{
			result = new Result();
			result.setResultCode("1");
			result.setResultMsg("系统错误");
			log.error(e, e);
		}finally {
			try {
				response.getWriter().write(JSON.toJSONString(result));
			}catch (Exception e1)
			{
				log.error(e1);
			}
		}
	}

}

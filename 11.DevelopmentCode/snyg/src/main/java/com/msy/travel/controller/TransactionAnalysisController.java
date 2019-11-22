package com.msy.travel.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.msy.travel.common.BaseController;
import com.msy.travel.common.BigDecimalUtil;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.Result;
import com.msy.travel.pojo.Charts;
import com.msy.travel.pojo.TransactionAnalysis;
import com.msy.travel.pojo.User;
import com.msy.travel.service.ITransactionAnalysisService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/transactionAnalysis")
public class TransactionAnalysisController extends BaseController {
	public static final Log log = LogFactory.getLog(TransactionAnalysisController.class);

	@Resource(name = "transactionAnalysisServiceImpl")
	private ITransactionAnalysisService transactionAnalysisService;

	/**
	 * 跳转到页面
	 */
	@RequestMapping(params = "method=toView")
	public ModelAndView toView(String orderDateType, String orderDate, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {

			view = new ModelAndView("statistics/transactionAnalysis");

			if (orderDateType == null || "".equals(orderDateType)) {
				orderDateType = "0";
			}
			// 统计周期
			view.addObject("orderDateType", orderDateType);

			// 默认今天
			if (orderDate == null || "".equals(orderDate)) {
				orderDate = DateTimeUtil.getDateTime10();
			}
			// 统计日期
			view.addObject("orderDate", orderDate);

			String dateTimeStart = "";
			String dateTimeEnd = "";

			if (orderDateType.equals("0")) {
				dateTimeStart = orderDate;
				dateTimeEnd = orderDate;
			} else if ("1".equals(orderDateType)) {
				dateTimeStart = DateTimeUtil.getWeekDateStart(orderDate);
				dateTimeEnd = DateTimeUtil.getWeekDateEnd(orderDate);
			} else if ("2".equals(orderDateType)) {
				dateTimeStart = DateTimeUtil.getMonthDateStart(orderDate);
				dateTimeEnd = DateTimeUtil.getMonthDateEnd(orderDate);
			}

			String spId = getLoginUser(request).getAccId();

			// 计算日 周期 不受结果影响
			TransactionAnalysis transactionAnalysisForDate = new TransactionAnalysis();
			transactionAnalysisForDate.setSpId(spId);
			transactionAnalysisForDate.setOrderDateTimeStart(dateTimeStart);
			transactionAnalysisForDate.setOrderDateTimeEnd(dateTimeEnd);

			TransactionAnalysis transactionAnalysis = transactionAnalysisService.getTransactionAnalysisInfo(transactionAnalysisForDate);

			view.addObject("transactionAnalysis", transactionAnalysis);
			// 成交转化率 成交量/访问量
			String conversionRate = "";
			// 下单转化率 下单量/访问量
			String orderRate = "";
			// 支付转化率 成交量/下单量
			String orderPayRate = "";
			if (transactionAnalysis != null) {
				conversionRate = BigDecimalUtil.divide(BigDecimalUtil.multiply(transactionAnalysis.getOrderNumPayTotal(), "100"), transactionAnalysis.getAccessNum());
				orderRate = BigDecimalUtil.divide(BigDecimalUtil.multiply(transactionAnalysis.getOrderNumTotal(), "100"), transactionAnalysis.getAccessNum());
				orderPayRate = BigDecimalUtil.divide(BigDecimalUtil.multiply(transactionAnalysis.getOrderNumPayTotal(), "100"), transactionAnalysis.getOrderNumTotal());
			}
			// 成交转化率 成交量/访问量
			view.addObject("conversionRate", conversionRate);
			// 下单转化率 下单量/访问量
			view.addObject("orderRate", orderRate);
			// 支付转化率 成交量/下单量
			view.addObject("orderPayRate", orderPayRate);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			TransactionAnalysis transactionAnalysisForTodayDateInfo = new TransactionAnalysis();
			transactionAnalysisForTodayDateInfo.setSpId(spId);
			transactionAnalysisForTodayDateInfo.setOrderDateTimeStart(orderDate);
			transactionAnalysisForTodayDateInfo.setOrderDateTimeEnd(orderDate);
			TransactionAnalysis transactionAnalysisForTodayDate = transactionAnalysisService.getTransactionAnalysisInfo(transactionAnalysisForTodayDateInfo);

			// 昨日日期
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(orderDate));
			cal.add(Calendar.DATE, -1);
			String yestoday = sdf.format(cal.getTime());

			// 上周同日
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(orderDate));
			c.add(Calendar.DATE, -7);
			String lastDay = sdf.format(c.getTime());

			// 访问量 start
			// 昨日信息
			TransactionAnalysis yDay = new TransactionAnalysis();
			yDay.setSpId(spId);
			yDay.setOrderDateTimeStart(yestoday);
			yDay.setOrderDateTimeEnd(yestoday);

			// 昨日访问的信息
			TransactionAnalysis yesTodayInfo = transactionAnalysisService.getTransactionAnalysisInfo(yDay);

			String accessNumRingRatio = BigDecimalUtil.divide(BigDecimalUtil.multiply(BigDecimalUtil.subtract(transactionAnalysisForTodayDate.getAccessNum(), yesTodayInfo.getAccessNum()), "100"),
					yesTodayInfo.getAccessNum());
			yesTodayInfo.setAccessNumRingRatio(accessNumRingRatio); // 访问量 环比昨日
			view.addObject("yesTodayInfoAccessNumRingRatio", accessNumRingRatio);

			// 上周信息
			TransactionAnalysis lastInfoDay = new TransactionAnalysis();
			lastInfoDay.setSpId(getLoginUser(request).getAccId());
			lastInfoDay.setOrderDateTimeStart(lastDay);
			lastInfoDay.setOrderDateTimeEnd(lastDay);

			TransactionAnalysis lastInfo = transactionAnalysisService.getTransactionAnalysisInfo(lastInfoDay);

			accessNumRingRatio = BigDecimalUtil.divide(BigDecimalUtil.multiply(BigDecimalUtil.subtract(transactionAnalysisForTodayDate.getAccessNum(), lastInfo.getAccessNum()), "100"),
					lastInfo.getAccessNum());
			lastInfo.setAccessNumRingRatio(accessNumRingRatio); // 访问量 环比上周

			view.addObject("lastInfoAccessNumRingRatio", accessNumRingRatio);

			// 访问量 end

			// 选择的日期 获得 交易额 退款金额
			TransactionAnalysis orderInfoToday = transactionAnalysisService.getTransactionAnalysisOrderInfo(transactionAnalysisForDate);

			String backOrderCount = orderInfoToday.getBackOrderCount();
			String accessNumPay = orderInfoToday.getAccessNumPay();
			// 全部交易额
			view.addObject("orderPayMoneyAllDate", orderInfoToday.getOrderPayMoneyAll());
			// 选择日期的当天的信息
			orderInfoToday = transactionAnalysisService.getTransactionAnalysisOrderInfo(transactionAnalysisForTodayDateInfo);
			// 昨天 获得 交易额 退款金额
			TransactionAnalysis orderInfoYestoday = transactionAnalysisService.getTransactionAnalysisOrderInfo(yDay);
			// 上周本日 获得 交易额 退款金额
			TransactionAnalysis orderlastInfo = transactionAnalysisService.getTransactionAnalysisOrderInfo(lastInfoDay);

			// 完成交易额 start
			String rate = BigDecimalUtil.divide(BigDecimalUtil.multiply(BigDecimalUtil.subtract(orderInfoToday.getOrderPayMoneyAll(), orderInfoYestoday.getOrderPayMoneyAll()), "100"),
					orderInfoYestoday.getOrderPayMoneyAll());
			orderInfoYestoday.setOrderPayMoneyRate(rate);

			rate = BigDecimalUtil.divide(BigDecimalUtil.multiply(BigDecimalUtil.subtract(orderInfoToday.getOrderPayMoneyAll(), orderlastInfo.getOrderPayMoneyAll()), "100"),
					orderlastInfo.getOrderPayMoneyAll());
			orderlastInfo.setOrderPayMoneyRate(rate);
			// 完成交易额 end

			// 成交转换
			// 按时间计算
			rate = BigDecimalUtil.divide(BigDecimalUtil.multiply(accessNumPay, "100"), transactionAnalysis.getAccessNum());
			orderInfoToday.setAccessNumPayRate(rate);

			// 昨日
			rate = BigDecimalUtil.divide(BigDecimalUtil.multiply(orderInfoYestoday.getAccessNumPay(), "100"), yesTodayInfo.getAccessNum());
			orderInfoYestoday.setAccessNumPayRate(rate);

			// 环比昨日
			String rateToday1 = BigDecimalUtil.divide(BigDecimalUtil.multiply(orderInfoToday.getAccessNumPay(), "100"), transactionAnalysisForTodayDate.getAccessNum());
			rate = BigDecimalUtil.divide(BigDecimalUtil.multiply(BigDecimalUtil.subtract(rateToday1, orderInfoYestoday.getAccessNumPayRate()), "100"), orderInfoYestoday.getAccessNumPayRate());
			orderlastInfo.setAccessNumPayRingRate(rate);

			// 上周
			rate = BigDecimalUtil.divide(BigDecimalUtil.multiply(orderlastInfo.getAccessNumPay(), "100"), lastInfo.getAccessNum());
			rate = BigDecimalUtil.divide(BigDecimalUtil.multiply(BigDecimalUtil.subtract(rateToday1, rate), "100"), rate);
			orderlastInfo.setAccessNumPayRate(rate);

			// 成交转换 end

			// 退款 转换率
			// 按选择日期
			rate = BigDecimalUtil.divide(BigDecimalUtil.multiply(backOrderCount, "100"), transactionAnalysis.getOrderNumPayTotal());
			orderInfoToday.setBackMoneyAllRate(rate);

			// 昨日
			rate = BigDecimalUtil.divide(BigDecimalUtil.multiply(orderInfoYestoday.getBackOrderCount(), "100"), yesTodayInfo.getOrderNumPayTotal());
			orderInfoYestoday.setBackMoneyAllRate(rate);

			// 环比昨日
			// rateToday 今天
			String rateToday = BigDecimalUtil.divide(BigDecimalUtil.multiply(orderInfoToday.getBackOrderCount(), "100"), transactionAnalysisForTodayDate.getOrderNumPayTotal());
			rate = BigDecimalUtil.divide(BigDecimalUtil.multiply(BigDecimalUtil.subtract(rateToday, orderInfoYestoday.getBackMoneyAllRate()), "100"), orderInfoYestoday.getBackMoneyAllRate());
			orderInfoYestoday.setBackMoneyAllRingRate(rate);

			// 上周
			rate = BigDecimalUtil.divide(BigDecimalUtil.multiply(orderlastInfo.getBackOrderCount(), "100"), lastInfo.getOrderNumPayTotal());
			rate = BigDecimalUtil.divide(BigDecimalUtil.multiply(BigDecimalUtil.subtract(rateToday, rate), "100"), rate);
			orderlastInfo.setBackMoneyAllRingRate(rate);
			// 退款转换率

			view.addObject("orderRate", orderRate);
			view.addObject("orderPayRate", orderPayRate);
			view.addObject("yesTodayInfo", yesTodayInfo);
			view.addObject("lastDay", lastDay);
			view.addObject("orderInfoToday", orderInfoToday);
			view.addObject("orderInfoYestoday", orderInfoYestoday);
			view.addObject("orderlastInfo", orderlastInfo);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	@RequestMapping(params = "method=getAccessChartData")
	public void getAccessChartData(String orderDateType, String orderDate, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {

			User user = this.getLoginUser(request);
			String spId = user.getAccId();

			String orderDateTimeStart = "";
			String orderDateTimeEnd = "";
			if ("0".equals(orderDateType)) {
				orderDateTimeStart = orderDate + " 00:00:00";
				orderDateTimeEnd = orderDate + " 23:59:59";
			} else if ("1".equals(orderDateType)) {
				orderDateTimeStart = DateTimeUtil.getWeekDateStart(orderDate) + " 00:00:00";
				orderDateTimeEnd = DateTimeUtil.getWeekDateEnd(orderDate) + " 23:59:59";
			} else if ("2".equals(orderDateType)) {
				orderDateTimeStart = DateTimeUtil.getMonthDateStart(orderDate) + " 00:00:00";
				orderDateTimeEnd = DateTimeUtil.getMonthDateEnd(orderDate) + " 23:59:59";
			}

			// 图表数据
			List<Charts> chartList = getSectionList(orderDateType, orderDate);

			// 检索
			TransactionAnalysis seach = new TransactionAnalysis();
			seach.setSpId(spId);
			seach.setOrderDateTimeStart(orderDateTimeStart);
			seach.setOrderDateTimeEnd(orderDateTimeEnd);

			// 退款列表
			List<TransactionAnalysis> cList = transactionAnalysisService.getAccessList(seach);

			int lastIndex = 0;
			String value = "0";
			if (cList != null && cList.size() > 0) {
				for (int i = 0; i < cList.size(); i++) {
					TransactionAnalysis obj = cList.get(i);
					String statisticTime = obj.getAccessTime();
					for (int j = lastIndex; j < chartList.size(); j++) {
						if (statisticTime.compareTo(chartList.get(j).getTimeStart()) >= 0 && statisticTime.compareTo(chartList.get(j).getTimeEnd()) <= 0) {
							lastIndex = j;
							value = BigDecimalUtil.add(chartList.get(j).getPointsValue(), "1");
							chartList.get(j).setPointsValue(value);

						}
					}
				}
			}

			// 返回
			result.setResultCode("0");
			result.setResultPojo(chartList);
			JSONObject json = JSONObject.fromObject(result);
			response.getWriter().print(json.toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 获取交易额折线图数据
	 * 
	 * @param transactionAnalysis
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "method=getOrderMoneyChartData")
	public void getOrderMoneyChartData(String orderDateType, String orderDate, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {

			User user = this.getLoginUser(request);
			String spId = user.getAccId();

			String orderDateTimeStart = "";
			String orderDateTimeEnd = "";
			if ("0".equals(orderDateType)) {
				orderDateTimeStart = orderDate + " 00:00:00";
				orderDateTimeEnd = orderDate + " 23:59:59";
			} else if ("1".equals(orderDateType)) {
				orderDateTimeStart = DateTimeUtil.getWeekDateStart(orderDate) + " 00:00:00";
				orderDateTimeEnd = DateTimeUtil.getWeekDateEnd(orderDate) + " 23:59:59";
			} else if ("2".equals(orderDateType)) {
				orderDateTimeStart = DateTimeUtil.getMonthDateStart(orderDate) + " 00:00:00";
				orderDateTimeEnd = DateTimeUtil.getMonthDateEnd(orderDate) + " 23:59:59";
			}

			// 图表数据
			List<Charts> chartList = getSectionList(orderDateType, orderDate);

			int lastIndex = 0;
			String orderTime = "";
			String value = "0";

			// 检索
			TransactionAnalysis seach = new TransactionAnalysis();
			seach.setSpId(spId);
			seach.setOrderDateTimeStart(orderDateTimeStart);
			seach.setOrderDateTimeEnd(orderDateTimeEnd);
			List<TransactionAnalysis> tList = transactionAnalysisService.getOrderMoneyList(seach);
			if (tList != null && tList.size() > 0) {
				for (int i = 0; i < tList.size(); i++) {
					TransactionAnalysis obj = tList.get(i);
					orderTime = obj.getOrderDate();
					for (int j = lastIndex; j < chartList.size(); j++) {
						if (orderTime.compareTo(chartList.get(j).getTimeStart()) >= 0 && orderTime.compareTo(chartList.get(j).getTimeEnd()) <= 0) {
							lastIndex = j;
							value = BigDecimalUtil.add(chartList.get(j).getPointsValue(), obj.getOrderMoney());
							chartList.get(j).setPointsValue(value);

						}
					}
				}
			}

			// 返回
			result.setResultCode("0");
			result.setResultPojo(chartList);
			JSONObject json = JSONObject.fromObject(result);
			response.getWriter().print(json.toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 获取成交转换率折线图数据
	 * 
	 * @param transactionAnalysis
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "method=getOrderRateData")
	public void getOrderRateData(String orderDateType, String orderDate, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {

			User user = this.getLoginUser(request);
			String spId = user.getAccId();

			String orderDateTimeStart = "";
			String orderDateTimeEnd = "";
			if ("0".equals(orderDateType)) {
				orderDateTimeStart = orderDate + " 00:00:00";
				orderDateTimeEnd = orderDate + " 23:59:59";
			} else if ("1".equals(orderDateType)) {
				orderDateTimeStart = DateTimeUtil.getWeekDateStart(orderDate) + " 00:00:00";
				orderDateTimeEnd = DateTimeUtil.getWeekDateEnd(orderDate) + " 23:59:59";
			} else if ("2".equals(orderDateType)) {
				orderDateTimeStart = DateTimeUtil.getMonthDateStart(orderDate) + " 00:00:00";
				orderDateTimeEnd = DateTimeUtil.getMonthDateEnd(orderDate) + " 23:59:59";
			}

			// 图表数据
			List<Charts> chartList = getSectionList(orderDateType, orderDate);

			// 检索
			TransactionAnalysis seach = new TransactionAnalysis();
			seach.setSpId(spId);
			seach.setOrderDateTimeStart(orderDateTimeStart);
			seach.setOrderDateTimeEnd(orderDateTimeEnd);

			// 客户量
			List<TransactionAnalysis> cList = transactionAnalysisService.getOrderCustomerList(seach);

			if (cList != null && cList.size() > 0) {
				String value = "0";
				int lastIndex = 0;
				String orderTime = "";

				for (int i = 0; i < cList.size(); i++) {
					TransactionAnalysis obj = cList.get(i);
					orderTime = obj.getOrderDate();
					for (int j = lastIndex; j < chartList.size(); j++) {
						if (orderTime.compareTo(chartList.get(j).getTimeStart()) >= 0 && orderTime.compareTo(chartList.get(j).getTimeEnd()) <= 0) {
							lastIndex = j;
							value = BigDecimalUtil.add(chartList.get(j).getData1(), "1");
							chartList.get(j).setData1(value);

						}
					}
				}
			}

			// 访问量
			List<TransactionAnalysis> aList = transactionAnalysisService.getAccessList(seach);
			if (aList != null && aList.size() > 0) {
				String value = "0";
				int lastIndex = 0;
				String orderTime = "";

				for (int i = 0; i < aList.size(); i++) {
					TransactionAnalysis obj = aList.get(i);
					orderTime = obj.getAccessTime();
					for (int j = lastIndex; j < chartList.size(); j++) {
						if (orderTime.compareTo(chartList.get(j).getTimeStart()) >= 0 && orderTime.compareTo(chartList.get(j).getTimeEnd()) <= 0) {
							lastIndex = j;
							value = BigDecimalUtil.add(chartList.get(j).getData2(), "1");
							chartList.get(j).setData2(value);

						}
					}
				}
			}

			for (int i = 0; i < chartList.size(); i++) {
				Charts chart = chartList.get(i);
				String data1 = chart.getData1();
				String data2 = chart.getData2();
				chartList.get(i).setPointsValue(BigDecimalUtil.divide(BigDecimalUtil.multiply(data1, "100"), data2));
			}

			// 返回
			result.setResultCode("0");
			result.setResultPojo(chartList);
			JSONObject json = JSONObject.fromObject(result);
			response.getWriter().print(json.toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 获取退款转换率折线图数据
	 * 
	 * @param transactionAnalysis
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "method=getBackRateData")
	public void getBackRateData(String orderDateType, String orderDate, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {

			User user = this.getLoginUser(request);
			String spId = user.getAccId();

			String orderDateTimeStart = "";
			String orderDateTimeEnd = "";
			if ("0".equals(orderDateType)) {
				orderDateTimeStart = orderDate + " 00:00:00";
				orderDateTimeEnd = orderDate + " 23:59:59";
			} else if ("1".equals(orderDateType)) {
				orderDateTimeStart = DateTimeUtil.getWeekDateStart(orderDate) + " 00:00:00";
				orderDateTimeEnd = DateTimeUtil.getWeekDateEnd(orderDate) + " 23:59:59";
			} else if ("2".equals(orderDateType)) {
				orderDateTimeStart = DateTimeUtil.getMonthDateStart(orderDate) + " 00:00:00";
				orderDateTimeEnd = DateTimeUtil.getMonthDateEnd(orderDate) + " 23:59:59";
			}

			// 图表数据
			List<Charts> chartList = getSectionList(orderDateType, orderDate);

			// 检索
			TransactionAnalysis seach = new TransactionAnalysis();
			seach.setSpId(spId);
			seach.setOrderDateTimeStart(orderDateTimeStart);
			seach.setOrderDateTimeEnd(orderDateTimeEnd);

			// 退款列表
			List<TransactionAnalysis> cList = transactionAnalysisService.getOrderBackList(seach);

			if (cList != null && cList.size() > 0) {
				String value = "0";
				int lastIndex = 0;
				String orderTime = "";

				for (int i = 0; i < cList.size(); i++) {
					TransactionAnalysis obj = cList.get(i);
					orderTime = obj.getOrderDate();
					for (int j = lastIndex; j < chartList.size(); j++) {
						if (orderTime.compareTo(chartList.get(j).getTimeStart()) >= 0 && orderTime.compareTo(chartList.get(j).getTimeEnd()) <= 0) {
							lastIndex = j;
							value = BigDecimalUtil.add(chartList.get(j).getData1(), "1");
							chartList.get(j).setData1(value);

						}
					}
				}
			}

			// 支付订单
			List<TransactionAnalysis> aList = transactionAnalysisService.getOrderPayList(seach);
			if (aList != null && aList.size() > 0) {
				String value = "0";
				int lastIndex = 0;
				String orderTime = "";

				for (int i = 0; i < aList.size(); i++) {
					TransactionAnalysis obj = aList.get(i);
					orderTime = obj.getOrderDate();
					for (int j = lastIndex; j < chartList.size(); j++) {
						if (orderTime.compareTo(chartList.get(j).getTimeStart()) >= 0 && orderTime.compareTo(chartList.get(j).getTimeEnd()) <= 0) {
							lastIndex = j;
							value = BigDecimalUtil.add(chartList.get(j).getData2(), "1");
							chartList.get(j).setData2(value);

						}
					}
				}
			}

			for (int i = 0; i < chartList.size(); i++) {
				Charts chart = chartList.get(i);
				String data1 = chart.getData1();
				String data2 = chart.getData2();
				chartList.get(i).setPointsValue(BigDecimalUtil.divide(BigDecimalUtil.multiply(data1, "100"), data2));
			}

			// 返回
			result.setResultCode("0");
			result.setResultPojo(chartList);
			JSONObject json = JSONObject.fromObject(result);
			response.getWriter().print(json.toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 获取统计区间
	 * 
	 * @param orderDateType
	 * @param date
	 * @return
	 */
	private static List<Charts> getSectionList(String orderDateType, String date) {
		List<Charts> list = new ArrayList<Charts>();

		// 每日 0 每周1 每月 2
		if ("0".equals(orderDateType)) {
			String[] pointsNameList = new String[] { "0:00", "2:00", "4:00", "6:00", "8:00", "10:00", "12:00", "14:00", "16:00", "18:00", "20:00", "22:00", "0:00" };
			String[] startList = new String[] { date + " 00:00:00", date + " 00:00:01", date + " 02:00:00", date + " 04:00:00", date + " 06:00:00", date + " 08:00:00", date + " 10:00:00",
					date + " 12:00:00", date + " 14:00:00", date + " 16:00:00", date + " 18:00:00", date + " 20:00:00", date + " 22:00:00" };
			String[] endList = new String[] { date + " 00:00:00", date + " 01:59:59", date + " 03:59:59", date + " 05:59:59", date + " 07:59:59", date + " 09:59:59", date + " 11:59:59",
					date + " 13:59:59", date + " 15:59:59", date + " 17:59:59", date + " 19:59:59", date + " 21:59:59", date + " 23:59:59" };

			for (int i = 0; i < 13; i++) {
				Charts charts = new Charts();
				charts.setPointsName(pointsNameList[i]);
				charts.setTimeStart(startList[i]);
				charts.setTimeEnd(endList[i]);
				charts.setPointsValue("0");
				charts.setData1("0");
				charts.setData2("0");
				list.add(charts);
			}
		} else if ("1".equals(orderDateType)) {
			String[] pointsNameList = new String[] { "0", "周一", "周二", "周三", "周四", "周五", "周六", "周日" };
			String[] startList = new String[8];
			String[] endList = new String[8];

			String weekStartDate = DateTimeUtil.getWeekDateStart(date);

			startList[0] = weekStartDate + " 00:00:00";
			endList[0] = weekStartDate + " 00:00:00";

			startList[1] = weekStartDate + " 00:00:01";
			endList[1] = weekStartDate + " 23:59:59";

			for (int i = 1; i < 7; i++) {
				startList[i + 1] = DateTimeUtil.addDate("yyyy-MM-dd", weekStartDate, String.valueOf(i)) + " 00:00:00";
				endList[i + 1] = DateTimeUtil.addDate("yyyy-MM-dd", weekStartDate, String.valueOf(i)) + " 23:59:59";
			}

			for (int i = 0; i < 8; i++) {
				Charts charts = new Charts();
				charts.setPointsName(pointsNameList[i]);
				charts.setTimeStart(startList[i]);
				charts.setTimeEnd(endList[i]);
				charts.setPointsValue("0");
				charts.setData1("0");
				charts.setData2("0");
				list.add(charts);
			}

		} else if ("2".equals(orderDateType)) {
			String monthStartDate = DateTimeUtil.getMonthDateStart(date);
			String monthEndDate = DateTimeUtil.getMonthDateEnd(date);

			List<String> pointsNameList = new ArrayList<String>();
			List<String> startList = new ArrayList<String>();
			List<String> endList = new ArrayList<String>();

			// 0
			pointsNameList.add("0");
			startList.add(monthStartDate + " 00:00:00");
			endList.add(monthStartDate + " 00:00:00");

			// 第一个坐标
			pointsNameList.add(DateTimeUtil.addDate("yyyy-MM-dd", monthStartDate, "1"));
			startList.add(monthStartDate + " 00:00:01");
			endList.add(DateTimeUtil.addDate("yyyy-MM-dd", monthStartDate, "1") + " 23:59:59");

			int index = 1;
			String startDate = DateTimeUtil.addDate("yyyy-MM-dd", monthStartDate, String.valueOf(index * 2));
			String endDate = DateTimeUtil.addDate("yyyy-MM-dd", startDate, "1");

			while (monthEndDate.compareTo(endDate) > 0) {
				pointsNameList.add(endDate);
				startList.add(startDate + " 00:00:00");
				endList.add(endDate + " 23:59:59");
				index++;

				startDate = DateTimeUtil.addDate("yyyy-MM-dd", monthStartDate, String.valueOf(index * 2));
				endDate = DateTimeUtil.addDate("yyyy-MM-dd", startDate, "1");
			}

			pointsNameList.add(monthEndDate);
			startList.add(startDate + " 00:00:00");
			endList.add(monthEndDate + " 23:59:59");

			for (int i = 0; i < pointsNameList.size(); i++) {
				Charts charts = new Charts();
				charts.setPointsName(pointsNameList.get(i));
				charts.setTimeStart(startList.get(i));
				charts.setTimeEnd(endList.get(i));
				charts.setPointsValue("0");
				charts.setData1("0");
				charts.setData2("0");
				list.add(charts);
			}
		}

		return list;
	}
}

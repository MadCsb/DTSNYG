package com.msy.travel.pojo;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "transactionAnalysis")
public class TransactionAnalysis extends BaseEntity implements java.io.Serializable {

	/**
	 * 下单时间
	 */
	private String orderDate;

	/**
	 * 每日 0 每周1 每月 2
	 */
	private String orderDateType;

	/**
	 * 下单时间开始（检索条件）
	 */
	private String orderDateTimeStart;

	/**
	 * 下单时间结束（检索条件）
	 */
	private String orderDateTimeEnd;

	/**
	 * 支撑商ID（检索条件）
	 */
	private String spId;

	/**
	 * 浏览量
	 */
	private String viewNum;

	/**
	 * 访问量
	 */
	private String accessNum;

	/**
	 * 订单量
	 */
	private String orderNum;

	/**
	 * 订单金额
	 */
	private String orderMoney;

	/**
	 * 下单数量SKU
	 */
	private String orderNumSku;

	/**
	 * 成交量
	 */
	private String orderNumPay;

	/**
	 * 成交金额
	 */
	private String orderMoneyPay;

	/**
	 * 成交订单SKU
	 */
	private String orderNumPaySku;

	/**
	 * 下单总量
	 */
	private String orderNumTotal;

	/**
	 * 成交总量
	 */
	private String orderNumPayTotal;

	/**
	 * 访问量环比
	 */
	private String accessNumRingRatio;

	/**
	 * 完成交易额 环比
	 */
	private String orderPayMoneyRingRatio;

	/**
	 * 成交转换量 环比
	 */
	private String orderNunRingRatio;

	/**
	 * 退款转换率 环比
	 */
	private String orderBackMoneyRingRatio;

	/**
	 * 完成交易额
	 */
	private String orderPayMoneyAll;

	private String orderPayMoneyRate;

	/**
	 * 成交客户量
	 */
	private String accessNumPay;

	private String accessNumPayRate;

	private String accessNumPayRingRate;

	/**
	 * 退款金额
	 */
	private String backMoneyAll;
	private String backMoneyAllRate;

	private String backMoneyAllRingRate;

	/**
	 * 访问时间
	 */
	private String accessTime;

	/**
	 * 用户ID
	 */
	private String userId;

	private String backOrderCount;

	private String backOrderRate;
	private String backOrderRingRate;

	public String getBackOrderCount() {
		return backOrderCount;
	}

	public void setBackOrderCount(String backOrderCount) {
		this.backOrderCount = backOrderCount;
	}

	public String getBackOrderRate() {
		return backOrderRate;
	}

	public void setBackOrderRate(String backOrderRate) {
		this.backOrderRate = backOrderRate;
	}

	public String getBackOrderRingRate() {
		return backOrderRingRate;
	}

	public void setBackOrderRingRate(String backOrderRingRate) {
		this.backOrderRingRate = backOrderRingRate;
	}

	public String getAccessNumPayRingRate() {
		return accessNumPayRingRate;
	}

	public void setAccessNumPayRingRate(String accessNumPayRingRate) {
		this.accessNumPayRingRate = accessNumPayRingRate;
	}

	public String getBackMoneyAllRingRate() {
		return backMoneyAllRingRate;
	}

	public void setBackMoneyAllRingRate(String backMoneyAllRingRate) {
		this.backMoneyAllRingRate = backMoneyAllRingRate;
	}

	public String getOrderPayMoneyRate() {
		return orderPayMoneyRate;
	}

	public void setOrderPayMoneyRate(String orderPayMoneyRate) {
		this.orderPayMoneyRate = orderPayMoneyRate;
	}

	public String getAccessNumPayRate() {
		return accessNumPayRate;
	}

	public void setAccessNumPayRate(String accessNumPayRate) {
		this.accessNumPayRate = accessNumPayRate;
	}

	public String getBackMoneyAllRate() {
		return backMoneyAllRate;
	}

	public void setBackMoneyAllRate(String backMoneyAllRate) {
		this.backMoneyAllRate = backMoneyAllRate;
	}

	public String getOrderPayMoneyAll() {
		return orderPayMoneyAll;
	}

	public void setOrderPayMoneyAll(String orderPayMoneyAll) {
		this.orderPayMoneyAll = orderPayMoneyAll;
	}

	public String getAccessNumPay() {
		return accessNumPay;
	}

	public void setAccessNumPay(String accessNumPay) {
		this.accessNumPay = accessNumPay;
	}

	public String getBackMoneyAll() {
		return backMoneyAll;
	}

	public void setBackMoneyAll(String backMoneyAll) {
		this.backMoneyAll = backMoneyAll;
	}

	public String getAccessNumRingRatio() {
		return accessNumRingRatio;
	}

	public void setAccessNumRingRatio(String accessNumRingRatio) {
		this.accessNumRingRatio = accessNumRingRatio;
	}

	public String getOrderPayMoneyRingRatio() {
		return orderPayMoneyRingRatio;
	}

	public void setOrderPayMoneyRingRatio(String orderPayMoneyRingRatio) {
		this.orderPayMoneyRingRatio = orderPayMoneyRingRatio;
	}

	public String getOrderNunRingRatio() {
		return orderNunRingRatio;
	}

	public void setOrderNunRingRatio(String orderNunRingRatio) {
		this.orderNunRingRatio = orderNunRingRatio;
	}

	public String getOrderBackMoneyRingRatio() {
		return orderBackMoneyRingRatio;
	}

	public void setOrderBackMoneyRingRatio(String orderBackMoneyRingRatio) {
		this.orderBackMoneyRingRatio = orderBackMoneyRingRatio;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderDateType() {
		return orderDateType;
	}

	public void setOrderDateType(String orderDateType) {
		this.orderDateType = orderDateType;
	}

	public String getAccessNum() {
		return accessNum;
	}

	public void setAccessNum(String accessNum) {
		this.accessNum = accessNum;
	}

	public String getOrderNumTotal() {
		return orderNumTotal;
	}

	public void setOrderNumTotal(String orderNumTotal) {
		this.orderNumTotal = orderNumTotal;
	}

	public String getOrderNumPayTotal() {
		return orderNumPayTotal;
	}

	public void setOrderNumPayTotal(String orderNumPayTotal) {
		this.orderNumPayTotal = orderNumPayTotal;
	}

	public String getOrderDateTimeStart() {
		return orderDateTimeStart;
	}

	public void setOrderDateTimeStart(String orderDateTimeStart) {
		this.orderDateTimeStart = orderDateTimeStart;
	}

	public String getOrderDateTimeEnd() {
		return orderDateTimeEnd;
	}

	public void setOrderDateTimeEnd(String orderDateTimeEnd) {
		this.orderDateTimeEnd = orderDateTimeEnd;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getViewNum() {
		return viewNum;
	}

	public void setViewNum(String viewNum) {
		this.viewNum = viewNum;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(String orderMoney) {
		this.orderMoney = orderMoney;
	}

	public String getOrderNumSku() {
		return orderNumSku;
	}

	public void setOrderNumSku(String orderNumSku) {
		this.orderNumSku = orderNumSku;
	}

	public String getOrderNumPay() {
		return orderNumPay;
	}

	public void setOrderNumPay(String orderNumPay) {
		this.orderNumPay = orderNumPay;
	}

	public String getOrderMoneyPay() {
		return orderMoneyPay;
	}

	public void setOrderMoneyPay(String orderMoneyPay) {
		this.orderMoneyPay = orderMoneyPay;
	}

	public String getOrderNumPaySku() {
		return orderNumPaySku;
	}

	public void setOrderNumPaySku(String orderNumPaySku) {
		this.orderNumPaySku = orderNumPaySku;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}
}

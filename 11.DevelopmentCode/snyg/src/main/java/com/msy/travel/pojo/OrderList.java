package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "orderList")
public class OrderList extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"orderListId:订单产品明细编号", "orderId:订单ID", "spId:运营商编号：前端下单时根据产品关联出来", "venId:供应商编号", "venName:供应商名称", "priceId:销售价ID", "productName:产品名称", "price:产品单价：客户实际销售金额", "num:数量",
			"money:总金额(预定时=商品费用+运费，退订时=应退订金额-费用)", "payMoney:支付金额", "backNum:退订数量", "goodsPriceId:子产品编号：规格ID", "childName:子产品名称：商品规格名称", "transFee:运费", "delFlag:fdelflag",
			"orderListType:0：下单 ；1：退订单；2：赠送"

	};

	/**
	 * 用于确定导出EXCEL的列 账单清单 日 月
	 */
	public static final String[] EXPORT_HEADERS_DAY = {
			// columns START
			"payDateTime:日期", "money:收益总额(¥)", "backMoney:支出总额(¥)", "surplusMoney:当月结余(¥)" };

	/**
	 * 用于确定导出EXCEL的列 账单明细
	 */
	public static final String[] EXPORT_HEADERS_DETAILLIST = {
			// columns START
			"orderCode:单据编号", "createTime:发生日期", "money:发生金额(¥)", "orderListType:发生类型", "productName:商品名称", "childName:商品规格", "custName:收货人", "custPhone:收货电话", "recAddress:收货地址" };
	// columns START
	/**
	 * 订单产品明细编号 db_column: F_ORDERLISTID
	 */
	private String orderListId;
	/**
	 * 订单ID db_column: F_ORDERID
	 */
	private String orderId;
	/**
	 * 运营商编号：前端下单时根据产品关联出来 db_column: F_SPID
	 */
	private String spId;
	/**
	 * 供应商编号 db_column: F_VENID
	 */
	private String venId;
	/**
	 * 供应商名称 db_column: F_VENNAME
	 */
	private String venName;
	/**
	 * 销售价ID db_column: F_PRICEID
	 */
	private String priceId;
	/**
	 * 子产品编号：规格ID db_column: F_GOODSPRICEID
	 */
	private String goodsPriceId;
	/**
	 * 子产品名称：商品规格名称 db_column: F_CHILDNAME
	 */
	private String childName;
	/**
	 * 产品id db_column: F_PRODUCTID
	 */
	private String productId;

	/**
	 * 产品名称 db_column: F_PRODUCTNAME
	 */
	private String productName;
	/**
	 * 产品单价：客户实际销售金额 db_column: F_PRICE
	 */
	private String price;
	/**
	 * 数量 db_column: F_NUM
	 */
	private String num;
	/**
	 * 总金额(预定时=商品费用+运费，退订时=应退订金额-费用) db_column: F_MONEY
	 */
	private String money;
	/**
	 * 支付金额 db_column: F_PAYMONEY
	 */
	private String payMoney;
	/**
	 * 退订数量 db_column: F_BACKNUM
	 */
	private String backNum;

	/**
	 * 运费 db_column: F_TRANSFEE
	 */
	private String transFee;
	/**
	 * fdelflag db_column: F_DELFLAG
	 */
	private String delFlag;
	/**
	 * 0：下单 ；1：退订单；2：赠送 db_column: F_ORDERLISTTYPE
	 */
	private String orderListType;

	/**
	 * 0优惠金额 db_column: F_COUPON_MONEY
	 */
	private String couponMoney;

	/**
	 * 客户优惠券关联ID db_column: F_CUSTOMERCOUPONID
	 */
	private String customerCouponId;

	/**
	 * 商品
	 */
	private Commproduct commproduct;

	private GoodsPrice goodsPrice;

	private SellPrice sellPrice;

	private List<OrderExpress> orderExpressList;

	/**
	 * 缩略图文件名称 db_column: F_THUMBPIC
	 */
	private String thumbPic;
	/**
	 * 对应购物车Id
	 */
	private String cartId;

	// 是否支付：0-未支付1-已支付 db_column: F_PAYTAG
	private String payTag;
	// columns END
	private List<String> orderListIdList;

	private String backMoney;

	private String payDateTime;

	private String surplusMoney;

	private String billType;

	private String payDateTimeStart;

	private String payDateTimeEnd;

	private String createTime;

	private String orderCode;

	private String userName;

	private String custName;

	private String recAddress;

	private String epmeOrdCode;

	private String epmeCompany;

	private String custPhone;

	private String channelId;

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getRecAddress() {
		return recAddress;
	}

	public void setRecAddress(String recAddress) {
		this.recAddress = recAddress;
	}

	public String getEpmeOrdCode() {
		return epmeOrdCode;
	}

	public void setEpmeOrdCode(String epmeOrdCode) {
		this.epmeOrdCode = epmeOrdCode;
	}

	public String getEpmeCompany() {
		return epmeCompany;
	}

	public void setEpmeCompany(String epmeCompany) {
		this.epmeCompany = epmeCompany;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getPayDateTimeStart() {
		return payDateTimeStart;
	}

	public void setPayDateTimeStart(String payDateTimeStart) {
		this.payDateTimeStart = payDateTimeStart;
	}

	public String getPayDateTimeEnd() {
		return payDateTimeEnd;
	}

	public void setPayDateTimeEnd(String payDateTimeEnd) {
		this.payDateTimeEnd = payDateTimeEnd;
	}

	public String getBackMoney() {
		return backMoney;
	}

	public void setBackMoney(String backMoney) {
		this.backMoney = backMoney;
	}

	public String getPayDateTime() {
		return payDateTime;
	}

	public void setPayDateTime(String payDateTime) {
		this.payDateTime = payDateTime;
	}

	public String getSurplusMoney() {
		return surplusMoney;
	}

	public void setSurplusMoney(String surplusMoney) {
		this.surplusMoney = surplusMoney;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public void setOrderListId(String orderListId) {
		this.orderListId = orderListId;
	}

	public String getOrderListId() {
		return this.orderListId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getSpId() {
		return this.spId;
	}

	public void setVenId(String venId) {
		this.venId = venId;
	}

	public String getVenId() {
		return this.venId;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenName() {
		return this.venName;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	public String getPriceId() {
		return this.priceId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return this.price;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getNum() {
		return this.num;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMoney() {
		return this.money;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	public String getPayMoney() {
		return this.payMoney;
	}

	public void setBackNum(String backNum) {
		this.backNum = backNum;
	}

	public String getBackNum() {
		return this.backNum;
	}

	public void setGoodsPriceId(String goodsPriceId) {
		this.goodsPriceId = goodsPriceId;
	}

	public String getGoodsPriceId() {
		return this.goodsPriceId;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public String getChildName() {
		return this.childName;
	}

	public void setTransFee(String transFee) {
		this.transFee = transFee;
	}

	public String getTransFee() {
		return this.transFee;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getDelFlag() {
		return this.delFlag;
	}

	public void setOrderListType(String orderListType) {
		this.orderListType = orderListType;
	}

	public String getOrderListType() {
		return this.orderListType;
	}

	public void setOrderListIdList(List<String> orderListIdList) {
		this.orderListIdList = orderListIdList;
	}

	public List<String> getOrderListIdList() {
		return this.orderListIdList;
	}

	public Commproduct getCommproduct() {
		return commproduct;
	}

	public void setCommproduct(Commproduct commproduct) {
		this.commproduct = commproduct;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public GoodsPrice getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(GoodsPrice goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public SellPrice getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(SellPrice sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public List<OrderExpress> getOrderExpressList() {
		return orderExpressList;
	}

	public void setOrderExpressList(List<OrderExpress> orderExpressList) {
		this.orderExpressList = orderExpressList;
	}

	public String getThumbPic() {
		return thumbPic;
	}

	public void setThumbPic(String thumbPic) {
		this.thumbPic = thumbPic;
	}

	public String getPayTag() {
		return payTag;
	}

	public void setPayTag(String payTag) {
		this.payTag = payTag;
	}

	public String getCouponMoney() {
		return couponMoney;
	}

	public void setCouponMoney(String couponMoney) {
		this.couponMoney = couponMoney;
	}

	public String getCustomerCouponId() {
		return customerCouponId;
	}

	public void setCustomerCouponId(String customerCouponId) {
		this.customerCouponId = customerCouponId;
	}
}

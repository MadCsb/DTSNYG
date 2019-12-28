
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "order")
public class Order extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "orderId:订单ID"
          ,
          "orderCode:流水号"
          ,
          "spId:运营商编号：前端下单时根据产品关联出来"
          ,
          "userId:用户ID"
          ,
          "productName:订单名称，生成规则待定"
          ,
          "backNum:退订数量"
          ,
          "giftNum:赠送数量"
          ,
          "num:购买数量"
          ,
          "money:总金额=商品费用+运费"
          ,
          "payMoney:支付金额"
          ,
          "productPrice:商品费用"
          ,
          "transFee:运费"
          ,
          "orderDate:订单日期"
          ,
          "memo:订单备注"
          ,
          "status:订单状态：0-未确认 1-已发货2-已收货3-已取消（商户拒绝）4-发货失败5-订单关闭（定时、后台）"
          ,
          "beforePayStatus:支付前状态:0：正常 ；1：用户取消； 2：系统取消"
          ,
          "payTag:是否支付：0-未支付1-已支付"
          ,
          "payDate:支付日期"
          ,
          "payType:付款类型：0-微信1-支付宝"
          ,
          "platformFlowCode:我方批次流水号"
          ,
          "delFlag:fdelflag"
          ,
          "createTime:创建时间"
          ,
          "creatorUid:创建人"
          ,
          "creator:创建人姓名"
          ,
          "updateTime:修改时间"
          ,
          "updateUid:修改人"
          ,
          "updater:修改人姓名"
          
        };
	
	//columns START
    /**
     * 订单ID       db_column: F_ORDERID 
     */	
	private String orderId;
    /**
     * 流水号       db_column: F_ORDERCODE 
     */	
	private String orderCode;
    /**
     * 运营商编号：前端下单时根据产品关联出来       db_column: F_SPID 
     */	
	private String spId;
    /**
     * 用户ID       db_column: F_USERID 
     */	
	private String userId;
    /**
     * 订单名称，生成规则待定       db_column: F_PRODUCTNAME 
     */	
	private String productName;
    /**
     * 退订数量       db_column: F_BACKNUM 
     */	
	private String backNum;
    /**
     * 赠送数量       db_column: F_GIFTNUM 
     */	
	private String giftNum;
    /**
     * 购买数量       db_column: F_NUM 
     */	
	private String num;
    /**
     * 总金额=商品费用+运费      db_column: F_MONEY
     */
	private String money;
    /**
     * 支付金额       db_column: F_PAYMONEY 
     */	
	private String payMoney;
    /**
     * 商品费用       db_column: F_PRODUCTPRICE 
     */	
	private String productPrice;
    /**
     * 运费       db_column: F_TRANSFEE 
     */	
	private String transFee;
    /**
     * 订单日期       db_column: F_ORDERDATE 
     */	
	private String orderDate;
    /**
     * 订单备注       db_column: F_MEMO 
     */	
	private String memo;
    /**
     * 订单状态：0-未确认 1-已发货2-已收货3-已取消（商户拒绝）4-发货失败5-订单关闭（定时、后台）       db_column: F_STATUS 
     */	
	private String status;
    /**
     * 支付前状态:0：正常 ；1：用户取消； 2：系统取消       db_column: F_BEFORE_PAY_STATUS 
     */	
	private String beforePayStatus;
    /**
     * 是否支付：0-未支付1-已支付       db_column: F_PAYTAG 
     */	
	private String payTag;
    /**
     * 支付日期       db_column: F_PAYDATE 
     */	
	private String payDate;
    /**
     * 付款类型：0-微信1-支付宝       db_column: F_PAYTYPE 
     */	
	private String payType;
    /**
     * 我方批次流水号       db_column: F_PLATFORM_FLOW_CODE 
     */	
	private String platformFlowCode;
    /**
     * fdelflag       db_column: F_DELFLAG 
     */	
	private String delFlag;
    /**
     * 创建时间       db_column: F_CREATETIME 
     */	
	private String createTime;
    /**
     * 创建人       db_column: F_CREATORUID 
     */	
	private String creatorUid;
    /**
     * 创建人姓名       db_column: F_CREATOR 
     */	
	private String creator;
    /**
     * 修改时间       db_column: F_UPDATETIME 
     */	
	private String updateTime;
    /**
     * 修改人       db_column: F_UPDATERUID 
     */	
	private String updateUid;
    /**
     * 修改人姓名       db_column: F_UPDATER 
     */	
	private String updater;

	/**
	 * 商家备注       db_column: F_COMPANYREMARK
	 */
	private String companyRemark;

	/**
	 * 已申请退货次数
	 */
	private String backTimes;

	private List<OrderList> orderListList;

	private OrderCustomer orderCustomer;

	/**
	 * 缩略图文件名称 db_column: F_THUMBPIC
	 */
	private String thumbPic;


	//搜索类型

	private String orderCodeLike;//订单编码like
	private String productNameLike;//订单名称like
	private String custPhoneLike; //买家手机号like
	private String custNameLike; //买家名称like
	private String moneyS; //订单金额起
	private String moneyE; //订单金额止
	private String orderDateS; //下单时间起
	private String orderDateE; //下单时间止
	private String createTimeS; //创建时间起
	private String createTimeE; //创建时间止

	private String orderCount; //订单数量
	private String perMoney; //订单均价
	private String beforePayStatusIn ; //支付前状态in
	private String statusIn ; //支付后状态in
	private String backNumS; //退货数量起
	private String searchKey;
	private String custPhone;
	private String custName;
	private String recAddress;

	private String type;

	private String payDateS;
	private String payDateE;
	private String outTicketTimeS;
	private String outTicketTimeE;
	private String backId;
	private String priceType; //销售类型
	//columns END
	private List<String> orderIdList;
	public void setOrderId(String orderId) {
		this.orderId =orderId;
	}
	
	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode =orderCode;
	}
	
	public String getOrderCode() {
		return this.orderCode;
	}
	public void setSpId(String spId) {
		this.spId =spId;
	}
	
	public String getSpId() {
		return this.spId;
	}
	public void setUserId(String userId) {
		this.userId =userId;
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setProductName(String productName) {
		this.productName =productName;
	}
	
	public String getProductName() {
		return this.productName;
	}
	public void setBackNum(String backNum) {
		this.backNum =backNum;
	}
	
	public String getBackNum() {
		return this.backNum;
	}
	public void setGiftNum(String giftNum) {
		this.giftNum =giftNum;
	}
	
	public String getGiftNum() {
		return this.giftNum;
	}
	public void setNum(String num) {
		this.num =num;
	}
	
	public String getNum() {
		return this.num;
	}
	public void setMoney(String money) {
		this.money =money;
	}
	
	public String getMoney() {
		return this.money;
	}
	public void setPayMoney(String payMoney) {
		this.payMoney =payMoney;
	}
	
	public String getPayMoney() {
		return this.payMoney;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice =productPrice;
	}
	
	public String getProductPrice() {
		return this.productPrice;
	}
	public void setTransFee(String transFee) {
		this.transFee =transFee;
	}
	
	public String getTransFee() {
		return this.transFee;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate =orderDate;
	}
	
	public String getOrderDate() {
		return this.orderDate;
	}
	public void setMemo(String memo) {
		this.memo =memo;
	}
	
	public String getMemo() {
		return this.memo;
	}
	public void setStatus(String status) {
		this.status =status;
	}
	
	public String getStatus() {
		return this.status;
	}
	public void setBeforePayStatus(String beforePayStatus) {
		this.beforePayStatus =beforePayStatus;
	}
	
	public String getBeforePayStatus() {
		return this.beforePayStatus;
	}
	public void setPayTag(String payTag) {
		this.payTag =payTag;
	}
	
	public String getPayTag() {
		return this.payTag;
	}
	public void setPayDate(String payDate) {
		this.payDate =payDate;
	}
	
	public String getPayDate() {
		return this.payDate;
	}
	public void setPayType(String payType) {
		this.payType =payType;
	}
	
	public String getPayType() {
		return this.payType;
	}
	public void setPlatformFlowCode(String platformFlowCode) {
		this.platformFlowCode =platformFlowCode;
	}
	
	public String getPlatformFlowCode() {
		return this.platformFlowCode;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag =delFlag;
	}
	
	public String getDelFlag() {
		return this.delFlag;
	}
	public void setCreateTime(String createTime) {
		this.createTime =createTime;
	}
	
	public String getCreateTime() {
		return this.createTime;
	}
	public void setCreatorUid(String creatorUid) {
		this.creatorUid =creatorUid;
	}
	
	public String getCreatorUid() {
		return this.creatorUid;
	}
	public void setCreator(String creator) {
		this.creator =creator;
	}
	
	public String getCreator() {
		return this.creator;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime =updateTime;
	}
	
	public String getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdateUid(String updateUid) {
		this.updateUid =updateUid;
	}
	
	public String getUpdateUid() {
		return this.updateUid;
	}
	public void setUpdater(String updater) {
		this.updater =updater;
	}
	
	public String getUpdater() {
		return this.updater;
	}
	public void setOrderIdList(List<String> orderIdList) {
		this.orderIdList = orderIdList;
	}
	
	public List<String> getOrderIdList() {
		return this.orderIdList;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMoneyS() {
		return moneyS;
	}

	public void setMoneyS(String moneyS) {
		this.moneyS = moneyS;
	}

	public String getMoneyE() {
		return moneyE;
	}

	public void setMoneyE(String moneyE) {
		this.moneyE = moneyE;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrderDateS() {
		return orderDateS;
	}

	public void setOrderDateS(String orderDateS) {
		this.orderDateS = orderDateS;
	}

	public String getOrderDateE() {
		return orderDateE;
	}

	public void setOrderDateE(String orderDateE) {
		this.orderDateE = orderDateE;
	}

	public String getPayDateS() {
		return payDateS;
	}

	public void setPayDateS(String payDateS) {
		this.payDateS = payDateS;
	}

	public String getPayDateE() {
		return payDateE;
	}

	public void setPayDateE(String payDateE) {
		this.payDateE = payDateE;
	}

	public String getOutTicketTimeS() {
		return outTicketTimeS;
	}

	public void setOutTicketTimeS(String outTicketTimeS) {
		this.outTicketTimeS = outTicketTimeS;
	}

	public String getOutTicketTimeE() {
		return outTicketTimeE;
	}

	public void setOutTicketTimeE(String outTicketTimeE) {
		this.outTicketTimeE = outTicketTimeE;
	}

	public String getBackTimes() {
		return backTimes;
	}

	public void setBackTimes(String backTimes) {
		this.backTimes = backTimes;
	}

	public String getCompanyRemark() {
		return companyRemark;
	}

	public void setCompanyRemark(String companyRemark) {
		this.companyRemark = companyRemark;
	}

	public String getProductNameLike() {
		return productNameLike;
	}

	public void setProductNameLike(String productNameLike) {
		this.productNameLike = productNameLike;
	}

	public String getCustPhoneLike() {
		return custPhoneLike;
	}

	public void setCustPhoneLike(String custPhoneLike) {
		this.custPhoneLike = custPhoneLike;
	}

	public String getCustNameLike() {
		return custNameLike;
	}

	public void setCustNameLike(String custNameLike) {
		this.custNameLike = custNameLike;
	}

	public String getOrderCodeLike() {
		return orderCodeLike;
	}

	public void setOrderCodeLike(String orderCodeLike) {
		this.orderCodeLike = orderCodeLike;
	}

	public String getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}

	public String getBeforePayStatusIn() {
		return beforePayStatusIn;
	}

	public void setBeforePayStatusIn(String beforePayStatusIn) {
		this.beforePayStatusIn = beforePayStatusIn;
	}

	public String getBackNumS() {
		return backNumS;
	}

	public void setBackNumS(String backNumS) {
		this.backNumS = backNumS;
	}

	public String getPerMoney() {
		return perMoney;
	}

	public void setPerMoney(String perMoney) {
		this.perMoney = perMoney;
	}

	public String getCreateTimeS() {
		return createTimeS;
	}

	public void setCreateTimeS(String createTimeS) {
		this.createTimeS = createTimeS;
	}

	public String getCreateTimeE() {
		return createTimeE;
	}

	public void setCreateTimeE(String createTimeE) {
		this.createTimeE = createTimeE;
	}

	public List<OrderList> getOrderListList() {
		return orderListList;
	}

	public void setOrderListList(List<OrderList> orderListList) {
		this.orderListList = orderListList;
	}

	public OrderCustomer getOrderCustomer() {
		return orderCustomer;
	}

	public void setOrderCustomer(OrderCustomer orderCustomer) {
		this.orderCustomer = orderCustomer;
	}

	public String getBackId() {
		return backId;
	}

	public void setBackId(String backId) {
		this.backId = backId;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getRecAddress() {
		return recAddress;
	}

	public void setRecAddress(String recAddress) {
		this.recAddress = recAddress;
	}

	public String getThumbPic() {
		return thumbPic;
	}

	public void setThumbPic(String thumbPic) {
		this.thumbPic = thumbPic;
	}

}


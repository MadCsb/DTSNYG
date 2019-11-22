
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "orderBack")
public class OrderBack extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "backId:退订记录ID"
          ,
          "backCode:退订单号"
          ,
          "status:退订状态：1-申请退订2-受理3-不受理4-退货5-退款6-关闭"
          ,
          "orderId:订单ID"
          ,
          "backData:退订数据[{orderListId:,num}]"
          ,
          "backReasonType:退订原因类型(PUBMAP)"
          ,
          "backReason:退订原因"
          ,
          "applyTime:退订申请时间"
          ,
          "applyUID:退订申请人ID"
          ,
          "applyUName:退订申请人名称"
          ,
          "opTime:退订受理时间"
          ,
          "opUID:退订受理人ID"
          ,
          "opUName:退订受理人名称"
          ,
          "isBackGoods:是否退货 1是，0否"
          ,
          "backGoodsStatus:退货状态 0待发货，1已发货，2已收货"
          ,
          "backGoodsEpmeCompany:退货快递公司"
          ,
          "backGoodsEpmeOrdCode:退货快递单号"
          ,
          "backGoodsName:退货快递接收人"
          ,
          "backGoodsPhone:退货快递接收人电话"
          ,
				 "backGoodsAddr:退货快递接收地址"
				 ,
          "backGoodsReceiveTime:退货接收时间"
          ,
          "isBackMoney:是否退款 1是，0否"
          ,
          "backMoneyStatus:退款状态 0待退款，1已退款"
          ,
          "backMoneyReceiveTime:退款接收时间"
          ,
          "applyBackMoney:申请退订金额"
          ,
          "backMoney:实际退订金额"
          ,
          "refuseReason:不受理原因"
          
        };
	
	//columns START
    /**
     * 退订记录ID       db_column: F_BACKID 
     */	
	private String backId;
    /**
     * 退订单号       db_column: F_BACKCODE 
     */	
	private String backCode;

	private String backCodeLike;
    /**
     * 退订状态：1-申请退订2-受理3-不受理4-退货5-退款6-关闭       db_column: F_STATUS 
     */	
	private String status;
    /**
     * 订单ID       db_column: F_ORDERID 
     */	
	private String orderId;
    /**
     * 退订数据[{orderListId:,num}]       db_column: F_BACKDATA 
     */	
	private String backData;
    /**
     * 退订原因类型(PUBMAP)       db_column: F_BACKREASON_TYPE 
     */	
	private String backReasonType;

	private String backReasonTypeValue;
    /**
     * 退订原因       db_column: F_BACKREASON 
     */	
	private String backReason;
    /**
     * 退订申请时间       db_column: F_APPLYTIME 
     */	
	private String applyTime;
	private String applyTimeS;
	private String applyTimeE;
    /**
     * 退订申请人ID       db_column: F_APPLY_UID 
     */	
	private String applyUID;
    /**
     * 退订申请人名称       db_column: F_APPLY_UNAME 
     */	
	private String applyUName;

	private String applyUNameLike;
    /**
     * 退订受理时间       db_column: F_OPTIME 
     */	
	private String opTime;
	private String opTimeS;
	private String opTimeE;
    /**
     * 退订受理人ID       db_column: F_OP_UID 
     */	
	private String opUID;
    /**
     * 退订受理人名称       db_column: F_OP_UNAME 
     */	
	private String opUName;
	private String opUNameLike;
    /**
     * 是否退货 1是，0否       db_column: F_ISBACK_GOODS 
     */	
	private String isBackGoods;
    /**
     * 退货状态 0待发货，1已发货，2已收货       db_column: F_BACK_GOODS_STATUS 
     */	
	private String backGoodsStatus;
    /**
     * 退货快递公司       db_column: F_BACK_GOODS_EPMECOMPANY 
     */	
	private String backGoodsEpmeCompany;
    /**
     * 退货快递单号       db_column: F_BACK_GOODS_EPMEORDCODE 
     */	
	private String backGoodsEpmeOrdCode;
    /**
     * 退货快递接收人       db_column: F_BACK_GOODS_NAME 
     */	
	private String backGoodsName;
    /**
     * 退货快递接收人电话       db_column: F_BACK_GOODS_PHONE 
     */	
	private String backGoodsPhone;
	/**
	 * 退货快递接收地址       db_column: F_BACK_GOODS_ADDR
	 */
	private String backGoodsAddr;
    /**
     * 退货接收时间       db_column: F_BACK_GOODS_RECEIVE_TIME 
     */	
	private String backGoodsReceiveTime;

	private String backGoodsReceiveTimeS;

	private String backGoodsReceiveTimeE;
    /**
     * 是否退款 1是，0否       db_column: F_ISBACK_MONEY 
     */	
	private String isBackMoney;
    /**
     * 退款状态 0待退款，1已退款       db_column: F_BACK_MONEY_STATUS 
     */	
	private String backMoneyStatus;
    /**
     * 退款接收时间       db_column: F_BACK_MONEY_RECEIVE_TIME 
     */	
	private String backMoneyReceiveTime;
	private String backMoneyReceiveTimeS;
	private String backMoneyReceiveTimeE;
    /**
     * 申请退订金额       db_column: F_APPLYBACKMONEY 
     */	
	private String applyBackMoney;
	private String applyBackMoneyS;
	private String applyBackMoneyE;
    /**
     * 实际退订金额       db_column: F_BACKMONEY 
     */	
	private String backMoney;
    /**
     * 不受理原因       db_column: F_REFUSE_REASON 
     */	
	private String refuseReason;

	/**
	 * 运营商编号：前端下单时根据产品关联出来       db_column: F_SPID
	 */
	private String spId;

	/**
	 * 流水号       db_column: F_ORDERCODE
	 */
	private String orderCode;
	private String orderCreateTime;

	private String orderCodeLike;

	/**
	 * 客户姓名       db_column: F_CUSTNAME
	 */
	private String custName;

	private String custNameLike;
	/**
	 * 客户手机号       db_column: F_CUSTPHONE
	 */
	private String custPhone;
	private String custPhoneLike;

	private String money; //退单总金额
	private String orderBackCount; //退单总笔数
	private String perMoney;
	//columns END
	private List<String> orderBackIdList;
	public void setBackId(String backId) {
		this.backId =backId;
	}
	
	public String getBackId() {
		return this.backId;
	}
	public void setBackCode(String backCode) {
		this.backCode =backCode;
	}
	
	public String getBackCode() {
		return this.backCode;
	}
	public void setStatus(String status) {
		this.status =status;
	}
	
	public String getStatus() {
		return this.status;
	}
	public void setOrderId(String orderId) {
		this.orderId =orderId;
	}
	
	public String getOrderId() {
		return this.orderId;
	}
	public void setBackData(String backData) {
		this.backData =backData;
	}
	
	public String getBackData() {
		return this.backData;
	}
	public void setBackReasonType(String backReasonType) {
		this.backReasonType =backReasonType;
	}
	
	public String getBackReasonType() {
		return this.backReasonType;
	}
	public void setBackReason(String backReason) {
		this.backReason =backReason;
	}
	
	public String getBackReason() {
		return this.backReason;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime =applyTime;
	}
	
	public String getApplyTime() {
		return this.applyTime;
	}
	public void setApplyUID(String applyUID) {
		this.applyUID =applyUID;
	}
	
	public String getApplyUID() {
		return this.applyUID;
	}
	public void setApplyUName(String applyUName) {
		this.applyUName =applyUName;
	}
	
	public String getApplyUName() {
		return this.applyUName;
	}
	public void setOpTime(String opTime) {
		this.opTime =opTime;
	}
	
	public String getOpTime() {
		return this.opTime;
	}
	public void setOpUID(String opUID) {
		this.opUID =opUID;
	}
	
	public String getOpUID() {
		return this.opUID;
	}
	public void setOpUName(String opUName) {
		this.opUName =opUName;
	}
	
	public String getOpUName() {
		return this.opUName;
	}
	public void setIsBackGoods(String isBackGoods) {
		this.isBackGoods =isBackGoods;
	}
	
	public String getIsBackGoods() {
		return this.isBackGoods;
	}
	public void setBackGoodsStatus(String backGoodsStatus) {
		this.backGoodsStatus =backGoodsStatus;
	}
	
	public String getBackGoodsStatus() {
		return this.backGoodsStatus;
	}
	public void setBackGoodsEpmeCompany(String backGoodsEpmeCompany) {
		this.backGoodsEpmeCompany =backGoodsEpmeCompany;
	}
	
	public String getBackGoodsEpmeCompany() {
		return this.backGoodsEpmeCompany;
	}
	public void setBackGoodsEpmeOrdCode(String backGoodsEpmeOrdCode) {
		this.backGoodsEpmeOrdCode =backGoodsEpmeOrdCode;
	}
	
	public String getBackGoodsEpmeOrdCode() {
		return this.backGoodsEpmeOrdCode;
	}
	public void setBackGoodsName(String backGoodsName) {
		this.backGoodsName =backGoodsName;
	}
	
	public String getBackGoodsName() {
		return this.backGoodsName;
	}
	public void setBackGoodsPhone(String backGoodsPhone) {
		this.backGoodsPhone =backGoodsPhone;
	}
	
	public String getBackGoodsPhone() {
		return this.backGoodsPhone;
	}
	public void setBackGoodsReceiveTime(String backGoodsReceiveTime) {
		this.backGoodsReceiveTime =backGoodsReceiveTime;
	}
	
	public String getBackGoodsReceiveTime() {
		return this.backGoodsReceiveTime;
	}
	public void setIsBackMoney(String isBackMoney) {
		this.isBackMoney =isBackMoney;
	}
	
	public String getIsBackMoney() {
		return this.isBackMoney;
	}
	public void setBackMoneyStatus(String backMoneyStatus) {
		this.backMoneyStatus =backMoneyStatus;
	}
	
	public String getBackMoneyStatus() {
		return this.backMoneyStatus;
	}
	public void setBackMoneyReceiveTime(String backMoneyReceiveTime) {
		this.backMoneyReceiveTime =backMoneyReceiveTime;
	}
	
	public String getBackMoneyReceiveTime() {
		return this.backMoneyReceiveTime;
	}
	public void setApplyBackMoney(String applyBackMoney) {
		this.applyBackMoney =applyBackMoney;
	}
	
	public String getApplyBackMoney() {
		return this.applyBackMoney;
	}
	public void setBackMoney(String backMoney) {
		this.backMoney =backMoney;
	}
	
	public String getBackMoney() {
		return this.backMoney;
	}
	public void setRefuseReason(String refuseReason) {
		this.refuseReason =refuseReason;
	}
	
	public String getRefuseReason() {
		return this.refuseReason;
	}
	public void setOrderBackIdList(List<String> orderBackIdList) {
		this.orderBackIdList = orderBackIdList;
	}
	
	public List<String> getOrderBackIdList() {
		return this.orderBackIdList;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getBackReasonTypeValue() {
		return backReasonTypeValue;
	}

	public void setBackReasonTypeValue(String backReasonTypeValue) {
		this.backReasonTypeValue = backReasonTypeValue;
	}

	public String getApplyTimeS() {
		return applyTimeS;
	}

	public void setApplyTimeS(String applyTimeS) {
		this.applyTimeS = applyTimeS;
	}

	public String getApplyTimeE() {
		return applyTimeE;
	}

	public void setApplyTimeE(String applyTimeE) {
		this.applyTimeE = applyTimeE;
	}

	public String getApplyUNameLike() {
		return applyUNameLike;
	}

	public void setApplyUNameLike(String applyUNameLike) {
		this.applyUNameLike = applyUNameLike;
	}

	public String getOpTimeS() {
		return opTimeS;
	}

	public void setOpTimeS(String opTimeS) {
		this.opTimeS = opTimeS;
	}

	public String getOpTimeE() {
		return opTimeE;
	}

	public void setOpTimeE(String opTimeE) {
		this.opTimeE = opTimeE;
	}

	public String getBackCodeLike() {
		return backCodeLike;
	}

	public void setBackCodeLike(String backCodeLike) {
		this.backCodeLike = backCodeLike;
	}

	public String getOrderCodeLike() {
		return orderCodeLike;
	}

	public void setOrderCodeLike(String orderCodeLike) {
		this.orderCodeLike = orderCodeLike;
	}

	public String getOpUNameLike() {
		return opUNameLike;
	}

	public void setOpUNameLike(String opUNameLike) {
		this.opUNameLike = opUNameLike;
	}

	public String getBackMoneyReceiveTimeS() {
		return backMoneyReceiveTimeS;
	}

	public void setBackMoneyReceiveTimeS(String backMoneyReceiveTimeS) {
		this.backMoneyReceiveTimeS = backMoneyReceiveTimeS;
	}

	public String getBackMoneyReceiveTimeE() {
		return backMoneyReceiveTimeE;
	}

	public void setBackMoneyReceiveTimeE(String backMoneyReceiveTimeE) {
		this.backMoneyReceiveTimeE = backMoneyReceiveTimeE;
	}

	public String getApplyBackMoneyS() {
		return applyBackMoneyS;
	}

	public void setApplyBackMoneyS(String applyBackMoneyS) {
		this.applyBackMoneyS = applyBackMoneyS;
	}

	public String getApplyBackMoneyE() {
		return applyBackMoneyE;
	}

	public void setApplyBackMoneyE(String applyBackMoneyE) {
		this.applyBackMoneyE = applyBackMoneyE;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustNameLike() {
		return custNameLike;
	}

	public void setCustNameLike(String custNameLike) {
		this.custNameLike = custNameLike;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustPhoneLike() {
		return custPhoneLike;
	}

	public void setCustPhoneLike(String custPhoneLike) {
		this.custPhoneLike = custPhoneLike;
	}

	public String getBackGoodsReceiveTimeS() {
		return backGoodsReceiveTimeS;
	}

	public void setBackGoodsReceiveTimeS(String backGoodsReceiveTimeS) {
		this.backGoodsReceiveTimeS = backGoodsReceiveTimeS;
	}

	public String getBackGoodsReceiveTimeE() {
		return backGoodsReceiveTimeE;
	}

	public void setBackGoodsReceiveTimeE(String backGoodsReceiveTimeE) {
		this.backGoodsReceiveTimeE = backGoodsReceiveTimeE;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getOrderBackCount() {
		return orderBackCount;
	}

	public void setOrderBackCount(String orderBackCount) {
		this.orderBackCount = orderBackCount;
	}

	public String getPerMoney() {
		return perMoney;
	}

	public void setPerMoney(String perMoney) {
		this.perMoney = perMoney;
	}

	public String getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(String orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public String getBackGoodsAddr() {
		return backGoodsAddr;
	}

	public void setBackGoodsAddr(String backGoodsAddr) {
		this.backGoodsAddr = backGoodsAddr;
	}
}


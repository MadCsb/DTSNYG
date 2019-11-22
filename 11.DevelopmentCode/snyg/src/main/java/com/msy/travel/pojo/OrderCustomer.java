
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "orderCustomer")
public class OrderCustomer extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "orderId:订单ID"
          ,
          "orderListId:订单产品明细编号"
          ,
          "custName:客户姓名"
          ,
          "custPhone:客户手机号"
          ,
          "recAddress:收货地址"
          ,
          "custCard:客户证件号"
          ,
          "cardType:客户证件类型：1身份证（默认）"
          
        };
	
	//columns START
    /**
     * 订单ID       db_column: F_ORDERID 
     */	
	private String orderId;
    /**
     * 订单产品明细编号       db_column: F_ORDERLISTID 
     */	
	private String orderListId;
    /**
     * 客户姓名       db_column: F_CUSTNAME 
     */	
	private String custName;
    /**
     * 客户手机号       db_column: F_CUSTPHONE 
     */	
	private String custPhone;
    /**
     * 收货地址       db_column: F_RECADDRESS 
     */	
	private String recAddress;
    /**
     * 客户证件号       db_column: F_CUSTCARD 
     */	
	private String custCard;
    /**
     * 客户证件类型：1身份证（默认）       db_column: F_CARDTYPE 
     */	
	private String cardType;
	//columns END
	private List<String> orderCustomerIdList;
	public void setOrderId(String orderId) {
		this.orderId =orderId;
	}
	
	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderListId(String orderListId) {
		this.orderListId =orderListId;
	}
	
	public String getOrderListId() {
		return this.orderListId;
	}
	public void setCustName(String custName) {
		this.custName =custName;
	}
	
	public String getCustName() {
		return this.custName;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone =custPhone;
	}
	
	public String getCustPhone() {
		return this.custPhone;
	}
	public void setRecAddress(String recAddress) {
		this.recAddress =recAddress;
	}
	
	public String getRecAddress() {
		return this.recAddress;
	}
	public void setCustCard(String custCard) {
		this.custCard =custCard;
	}
	
	public String getCustCard() {
		return this.custCard;
	}
	public void setCardType(String cardType) {
		this.cardType =cardType;
	}
	
	public String getCardType() {
		return this.cardType;
	}
	public void setOrderCustomerIdList(List<String> orderCustomerIdList) {
		this.orderCustomerIdList = orderCustomerIdList;
	}
	
	public List<String> getOrderCustomerIdList() {
		return this.orderCustomerIdList;
	}

}


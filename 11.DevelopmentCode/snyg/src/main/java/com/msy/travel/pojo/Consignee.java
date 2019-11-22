
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "consignee")
public class Consignee extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "consigneeId:收货人ID"
          ,
          "userId:用户ID  "
          ,
          "custName:客户姓名"
          ,
          "custPhone:客户手机号"
          ,
          "pcx:省市区"
          ,
          "recAddress:收货地址"
          ,
          "custCard:客户证件号"
          ,
          "cardType:客户证件类型：1身份证（默认）"
          ,
          "isDefault:是否默认收货人：0否，1是"
          
        };
	
	//columns START
    /**
     * 收货人ID       db_column: F_CONSIGNEE 
     */	
	private String consigneeId;
    /**
     * 用户ID         db_column: F_USER_ID 
     */	
	private String userId;
    /**
     * 客户姓名       db_column: F_CUSTNAME 
     */	
	private String custName;
    /**
     * 客户手机号       db_column: F_CUSTPHONE 
     */	
	private String custPhone;
    /**
     * 省市区       db_column: F_PCX 
     */	
	private String pcx;
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
    /**
     * 是否默认收货人：0否，1是       db_column: F_ISDEFAULT 
     */	
	private String isDefault;

	private String userName;

	private String defaultFirst; //收货地址排前边
	//columns END
	private List<String> consigneeIdList;
	public void setConsigneeId(String consigneeId) {
		this.consigneeId =consigneeId;
	}
	
	public String getConsigneeId() {
		return this.consigneeId;
	}
	public void setUserId(String userId) {
		this.userId =userId;
	}
	
	public String getUserId() {
		return this.userId;
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
	public void setPcx(String pcx) {
		this.pcx =pcx;
	}
	
	public String getPcx() {
		return this.pcx;
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
	public void setIsDefault(String isDefault) {
		this.isDefault =isDefault;
	}
	
	public String getIsDefault() {
		return this.isDefault;
	}
	public void setConsigneeIdList(List<String> consigneeIdList) {
		this.consigneeIdList = consigneeIdList;
	}
	
	public List<String> getConsigneeIdList() {
		return this.consigneeIdList;
	}

	public String getDefaultFirst() {
		return defaultFirst;
	}

	public void setDefaultFirst(String defaultFirst) {
		this.defaultFirst = defaultFirst;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}


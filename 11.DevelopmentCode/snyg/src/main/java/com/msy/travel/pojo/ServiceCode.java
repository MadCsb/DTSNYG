
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "serviceCode")
public class ServiceCode extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "serviceId:fwxserviceid"
          ,
          "name:fname"
          ,
          "fullName:ffullname"
          ,
          "code:fcode"
          ,
          "type:0-订阅号1-服务号 pub_map中 ServiceCodeType"
          ,
          "appId:fappid"
          ,
          "appSecret:fappsecret"
          ,
          "logoFileName:flogofilename"
          ,
          "url:furl"
          ,
          "token:ftoken"
          ,
          "welcome:fwelcome"
          ,
          "paySignKey:fpaysignkey"
          ,
          "tenPayPartner:ftenpaypartner"
          ,
          "tenPayPartnerKey:ftenpaypartnerkey"
          ,
          "aliPayEmail:falipayemail"
          ,
          "aliPayPartner:falipaypartner"
          ,
          "aliPayPartnerKey:falipaypartnerkey"
          ,
          "delTag:fdeltag"
          ,
          "createDate:fcreatedate"
          ,
          "inMsgId:finmsgid"
          ,
          "unreadMsgId:funreadmsgid"
          ,
          "couponMemo:fcouponmemo"
          ,
          "couponLink:fcouponlink"
          
        };
	
	//columns START
    /**
     * fwxserviceid       db_column: F_WXSERVICEID 
     */	
	private String serviceId;
    /**
     * fname       db_column: F_NAME 
     */	
	private String name;
    /**
     * ffullname       db_column: F_FULLNAME 
     */	
	private String fullName;
    /**
     * fcode       db_column: F_CODE 
     */	
	private String code;
    /**
     * 0-订阅号1-服务号 pub_map中 ServiceCodeType       db_column: F_TYPE 
     */	
	private String type;
    /**
     * fappid       db_column: F_APPID 
     */	
	private String appId;
    /**
     * fappsecret       db_column: F_APPSECRET 
     */	
	private String appSecret;
    /**
     * flogofilename       db_column: F_LOGOFILENAME 
     */	
	private String logoFileName;
    /**
     * furl       db_column: F_URL 
     */	
	private String url;
    /**
     * ftoken       db_column: F_TOKEN 
     */	
	private String token;
    /**
     * fwelcome       db_column: F_WELCOME 
     */	
	private String welcome;
    /**
     * fpaysignkey       db_column: F_PAYSIGNKEY 
     */	
	private String paySignKey;
    /**
     * ftenpaypartner       db_column: F_TENPAYPARTNER 
     */	
	private String tenPayPartner;
    /**
     * ftenpaypartnerkey       db_column: F_TENPAYPARTNERKEY 
     */	
	private String tenPayPartnerKey;
    /**
     * falipayemail       db_column: F_ALIPAYEMAIL 
     */	
	private String aliPayEmail;
    /**
     * falipaypartner       db_column: F_ALIPAYPARTNER 
     */	
	private String aliPayPartner;
    /**
     * falipaypartnerkey       db_column: F_ALIPAYPARTNERKEY 
     */	
	private String aliPayPartnerKey;
    /**
     * fdeltag       db_column: F_DELTAG 
     */	
	private String delTag;
    /**
     * fcreatedate       db_column: F_CREATEDATE 
     */	
	private String createDate;
    /**
     * finmsgid       db_column: F_INMSGID 
     */	
	private String inMsgId;
    /**
     * funreadmsgid       db_column: F_UNREADMSGID 
     */	
	private String unreadMsgId;
    /**
     * fcouponmemo       db_column: F_COUPONMEMO 
     */	
	private String couponMemo;
    /**
     * fcouponlink       db_column: F_COUPONLINK 
     */	
	private String couponLink;

    private String inMsgType;

    private String unReadMsgType;
    
	//columns END
	private List<String> serviceCodeIdList;
	public void setServiceId(String serviceId) {
		this.serviceId =serviceId;
	}
	
	public String getServiceId() {
		return this.serviceId;
	}
	public void setName(String name) {
		this.name =name;
	}
	
	public String getName() {
		return this.name;
	}
	public void setFullName(String fullName) {
		this.fullName =fullName;
	}
	
	public String getFullName() {
		return this.fullName;
	}
	public void setCode(String code) {
		this.code =code;
	}
	
	public String getCode() {
		return this.code;
	}
	public void setType(String type) {
		this.type =type;
	}
	
	public String getType() {
		return this.type;
	}
	public void setAppId(String appId) {
		this.appId =appId;
	}
	
	public String getAppId() {
		return this.appId;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret =appSecret;
	}
	
	public String getAppSecret() {
		return this.appSecret;
	}
	public void setLogoFileName(String logoFileName) {
		this.logoFileName =logoFileName;
	}
	
	public String getLogoFileName() {
		return this.logoFileName;
	}
	public void setUrl(String url) {
		this.url =url;
	}
	
	public String getUrl() {
		return this.url;
	}
	public void setToken(String token) {
		this.token =token;
	}
	
	public String getToken() {
		return this.token;
	}
	public void setWelcome(String welcome) {
		this.welcome =welcome;
	}
	
	public String getWelcome() {
		return this.welcome;
	}
	public void setPaySignKey(String paySignKey) {
		this.paySignKey =paySignKey;
	}
	
	public String getPaySignKey() {
		return this.paySignKey;
	}
	public void setTenPayPartner(String tenPayPartner) {
		this.tenPayPartner =tenPayPartner;
	}
	
	public String getTenPayPartner() {
		return this.tenPayPartner;
	}
	public void setTenPayPartnerKey(String tenPayPartnerKey) {
		this.tenPayPartnerKey =tenPayPartnerKey;
	}
	
	public String getTenPayPartnerKey() {
		return this.tenPayPartnerKey;
	}
	public void setAliPayEmail(String aliPayEmail) {
		this.aliPayEmail =aliPayEmail;
	}
	
	public String getAliPayEmail() {
		return this.aliPayEmail;
	}
	public void setAliPayPartner(String aliPayPartner) {
		this.aliPayPartner =aliPayPartner;
	}
	
	public String getAliPayPartner() {
		return this.aliPayPartner;
	}
	public void setAliPayPartnerKey(String aliPayPartnerKey) {
		this.aliPayPartnerKey =aliPayPartnerKey;
	}
	
	public String getAliPayPartnerKey() {
		return this.aliPayPartnerKey;
	}
	public void setDelTag(String delTag) {
		this.delTag =delTag;
	}
	
	public String getDelTag() {
		return this.delTag;
	}
	public void setCreateDate(String createDate) {
		this.createDate =createDate;
	}
	
	public String getCreateDate() {
		return this.createDate;
	}
	public void setInMsgId(String inMsgId) {
		this.inMsgId =inMsgId;
	}
	
	public String getInMsgId() {
		return this.inMsgId;
	}
	public void setUnreadMsgId(String unreadMsgId) {
		this.unreadMsgId =unreadMsgId;
	}
	
	public String getUnreadMsgId() {
		return this.unreadMsgId;
	}
	public void setCouponMemo(String couponMemo) {
		this.couponMemo =couponMemo;
	}
	
	public String getCouponMemo() {
		return this.couponMemo;
	}
	public void setCouponLink(String couponLink) {
		this.couponLink =couponLink;
	}
	
	public String getCouponLink() {
		return this.couponLink;
	}
	public void setServiceCodeIdList(List<String> serviceCodeIdList) {
		this.serviceCodeIdList = serviceCodeIdList;
	}
	
	public List<String> getServiceCodeIdList() {
		return this.serviceCodeIdList;
	}

	public String getInMsgType() {
		return inMsgType;
	}

	public void setInMsgType(String inMsgType) {
		this.inMsgType = inMsgType;
	}

	public String getUnReadMsgType() {
		return unReadMsgType;
	}

	public void setUnReadMsgType(String unReadMsgType) {
		this.unReadMsgType = unReadMsgType;
	}
}


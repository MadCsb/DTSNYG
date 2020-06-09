
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "weixinOpenApplication")
public class WeixinOpenApplication extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "appId:应用ID"
          ,
          "appSecret:应用秘钥"
          ,
          "appType:应用类型(网站应用:website,第三方平台:thirdPartyPlatform)"
          ,
          "token:公众平台上，开发者设置的token"
          ,
          "encodingAESKey:公众平台上，开发者设置的EncodingAESKey"
          ,
          "componentVerifyTicket:微信服务器推送component_verify_ticket"
          ,
          "componentAccessToken:令牌"
          ,
          "preAuthCode:预授权码"
          ,
          "verifyTicketExp:component_verify_ticket 过期时间"
          ,
          "accessTokenExp:令牌 过期时间"
          
        };
	
	//columns START

	/**
	 * 应用类型：网站应用 website
	 */
	public static final String APPTYPE_WEBSITE = "website";
    /**
     * 应用ID       db_column: F_APPID 
     */	
	private String appId;
    /**
     * 应用秘钥       db_column: F_APPSECRET 
     */	
	private String appSecret;
    /**
     * 应用类型(网站应用:website,第三方平台:thirdPartyPlatform)       db_column: F_APPTYPE 
     */	
	private String appType;
    /**
     * 公众平台上，开发者设置的token       db_column: F_TOKEN 
     */	
	private String token;
    /**
     * 公众平台上，开发者设置的EncodingAESKey       db_column: F_ENCODINGAESKEY 
     */	
	private String encodingAESKey;
    /**
     * 微信服务器推送component_verify_ticket       db_column: F_COMPONENTVERIFYTICKET 
     */	
	private String componentVerifyTicket;
    /**
     * 令牌       db_column: F_COMPONENTACCESSTOKEN 
     */	
	private String componentAccessToken;
    /**
     * 预授权码       db_column: F_PREAUTHCODE 
     */	
	private String preAuthCode;
    /**
     * component_verify_ticket 过期时间       db_column: F_VERIFYTICKET_EXP 
     */	
	private String verifyTicketExp;
    /**
     * 令牌 过期时间       db_column: F_ACCESSTOKEN_EXP 
     */	
	private String accessTokenExp;

	/**
	 * 指定时间需要刷新accessToken
	 */
	private String timeRefreshAccessToken;
	//columns END
	private List<String> weixinOpenApplicationIdList;
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
	public void setAppType(String appType) {
		this.appType =appType;
	}
	
	public String getAppType() {
		return this.appType;
	}
	public void setToken(String token) {
		this.token =token;
	}
	
	public String getToken() {
		return this.token;
	}
	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey =encodingAESKey;
	}
	
	public String getEncodingAESKey() {
		return this.encodingAESKey;
	}
	public void setComponentVerifyTicket(String componentVerifyTicket) {
		this.componentVerifyTicket =componentVerifyTicket;
	}
	
	public String getComponentVerifyTicket() {
		return this.componentVerifyTicket;
	}
	public void setComponentAccessToken(String componentAccessToken) {
		this.componentAccessToken =componentAccessToken;
	}
	
	public String getComponentAccessToken() {
		return this.componentAccessToken;
	}
	public void setPreAuthCode(String preAuthCode) {
		this.preAuthCode =preAuthCode;
	}
	
	public String getPreAuthCode() {
		return this.preAuthCode;
	}
	public void setVerifyTicketExp(String verifyTicketExp) {
		this.verifyTicketExp =verifyTicketExp;
	}
	
	public String getVerifyTicketExp() {
		return this.verifyTicketExp;
	}
	public void setAccessTokenExp(String accessTokenExp) {
		this.accessTokenExp =accessTokenExp;
	}
	
	public String getAccessTokenExp() {
		return this.accessTokenExp;
	}
	public void setWeixinOpenApplicationIdList(List<String> weixinOpenApplicationIdList) {
		this.weixinOpenApplicationIdList = weixinOpenApplicationIdList;
	}
	
	public List<String> getWeixinOpenApplicationIdList() {
		return this.weixinOpenApplicationIdList;
	}

	public String getTimeRefreshAccessToken() {
		return timeRefreshAccessToken;
	}

	public void setTimeRefreshAccessToken(String timeRefreshAccessToken) {
		this.timeRefreshAccessToken = timeRefreshAccessToken;
	}
}


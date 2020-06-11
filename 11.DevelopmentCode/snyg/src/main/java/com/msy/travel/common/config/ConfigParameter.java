package com.msy.travel.common.config;

public class ConfigParameter {

	private String picUrl; // 图片地址

	private String uploadPicUrl; // 图片上传物理地址

	private String previewUrl;// 富文本图片预览路径

	private String wxNotifyUrl; // 微信支付回调地址

	private String wxAuthorizeUrl;// 微信Authorize

	private String ipmsUname;// 集成平台对接用户名

	private String ipmsPassword;// 集成平台对接密钥

	private String ipmsVersion;// 集成平台对接版本号

	private String ipmsUrl;// 集成平台对接用户地址

	private String ipmsPublicKey; // 集成平台对接公钥

	private String ipmsPrivateKey;// 集成平台对接私钥

	private String ipmsSpId;// 集成平台对接spid

	private String ipmsSyn;// 集成平台同步标识0：不同步，1：同步

	private String maxLoginTime; // 最大登录时间

	private String website;

	private String wxpayValidateTime;

	private String wxpayNotifyUrl;

	private String wxpayWapReturnUrl;

	private String price1PatchTime;// 团购活动自动成团时间

	private String orderExpressCloseDay;//订单快递，自动关闭时间

	private String orderCloseDay; //订单，已收货自动关闭时间

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUploadPicUrl() {
		return uploadPicUrl;
	}

	public void setUploadPicUrl(String uploadPicUrl) {
		this.uploadPicUrl = uploadPicUrl;
	}

	public String getPreviewUrl() {
		return previewUrl;
	}

	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}

	public String getWxNotifyUrl() {
		return wxNotifyUrl;
	}

	public void setWxNotifyUrl(String wxNotifyUrl) {
		this.wxNotifyUrl = wxNotifyUrl;
	}

	public String getWxAuthorizeUrl() {
		return wxAuthorizeUrl;
	}

	public void setWxAuthorizeUrl(String wxAuthorizeUrl) {
		this.wxAuthorizeUrl = wxAuthorizeUrl;
	}

	public String getIpmsUname() {
		return ipmsUname;
	}

	public void setIpmsUname(String ipmsUname) {
		this.ipmsUname = ipmsUname;
	}

	public String getIpmsPassword() {
		return ipmsPassword;
	}

	public void setIpmsPassword(String ipmsPassword) {
		this.ipmsPassword = ipmsPassword;
	}

	public String getIpmsVersion() {
		return ipmsVersion;
	}

	public void setIpmsVersion(String ipmsVersion) {
		this.ipmsVersion = ipmsVersion;
	}

	public String getIpmsUrl() {
		return ipmsUrl;
	}

	public void setIpmsUrl(String ipmsUrl) {
		this.ipmsUrl = ipmsUrl;
	}

	public String getIpmsPublicKey() {
		return ipmsPublicKey;
	}

	public void setIpmsPublicKey(String ipmsPublicKey) {
		this.ipmsPublicKey = ipmsPublicKey;
	}

	public String getIpmsPrivateKey() {
		return ipmsPrivateKey;
	}

	public void setIpmsPrivateKey(String ipmsPrivateKey) {
		this.ipmsPrivateKey = ipmsPrivateKey;
	}

	public String getIpmsSpId() {
		return ipmsSpId;
	}

	public void setIpmsSpId(String ipmsSpId) {
		this.ipmsSpId = ipmsSpId;
	}

	public String getIpmsSyn() {
		return ipmsSyn;
	}

	public void setIpmsSyn(String ipmsSyn) {
		this.ipmsSyn = ipmsSyn;
	}

	public String getMaxLoginTime() {
		return maxLoginTime;
	}

	public void setMaxLoginTime(String maxLoginTime) {
		this.maxLoginTime = maxLoginTime;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWxpayValidateTime() {
		return wxpayValidateTime;
	}

	public void setWxpayValidateTime(String wxpayValidateTime) {
		this.wxpayValidateTime = wxpayValidateTime;
	}

	public String getWxpayNotifyUrl() {
		return wxpayNotifyUrl;
	}

	public void setWxpayNotifyUrl(String wxpayNotifyUrl) {
		this.wxpayNotifyUrl = wxpayNotifyUrl;
	}

	public String getPrice1PatchTime() {
		return price1PatchTime;
	}

	public void setPrice1PatchTime(String price1PatchTime) {
		this.price1PatchTime = price1PatchTime;
	}

	public String getOrderExpressCloseDay() {
		return orderExpressCloseDay;
	}

	public void setOrderExpressCloseDay(String orderExpressCloseDay) {
		this.orderExpressCloseDay = orderExpressCloseDay;
	}

	public String getOrderCloseDay() {
		return orderCloseDay;
	}

	public void setOrderCloseDay(String orderCloseDay) {
		this.orderCloseDay = orderCloseDay;
	}

	public String getWxpayWapReturnUrl() {
		return wxpayWapReturnUrl;
	}

	public void setWxpayWapReturnUrl(String wxpayWapReturnUrl) {
		this.wxpayWapReturnUrl = wxpayWapReturnUrl;
	}
}

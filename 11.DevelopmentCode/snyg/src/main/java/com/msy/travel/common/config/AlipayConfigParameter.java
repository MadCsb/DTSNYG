package com.msy.travel.common.config;

public class AlipayConfigParameter {
	private String notifyUrl;

	private String wapReturnUrl;

	private String alipayPublicKey;

	private String charset;

	private String signType;

	private String zfbPublicKey;

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getAlipayPublicKey() {
		return alipayPublicKey;
	}

	public void setAlipayPublicKey(String alipayPublicKey) {
		this.alipayPublicKey = alipayPublicKey;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getWapReturnUrl() {
		return wapReturnUrl;
	}

	public void setWapReturnUrl(String wapReturnUrl) {
		this.wapReturnUrl = wapReturnUrl;
	}

	public String getZfbPublicKey() {
		return zfbPublicKey;
	}

	public void setZfbPublicKey(String zfbPublicKey) {
		this.zfbPublicKey = zfbPublicKey;
	}
}

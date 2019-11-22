package com.msy.travel.common.wx;

public class JsApiTicket {

	// 获取到的凭证
	private String ticket;

	// 凭证有效时间，单位：秒
	private int expiresIn;

	// 到期时间long类型
	private long untildate;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public long getUntildate() {
		return untildate;
	}

	public void setUntildate(long untildate) {
		this.untildate = untildate;
	}

}

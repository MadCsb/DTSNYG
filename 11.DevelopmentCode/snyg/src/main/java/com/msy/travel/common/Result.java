package com.msy.travel.common;

import java.io.Serializable;

public class Result implements Serializable{

	private static final long serialVersionUID = 1L;

	//结果码   0成功   1失败
    private String  resultCode;

    // 描述信息
    private String  resultMsg;

    //返回的pojo
    private Object  resultPojo;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public Object getResultPojo() {
		return resultPojo;
	}

	public void setResultPojo(Object resultPojo) {
		this.resultPojo = resultPojo;
	}

	@Override
	public String toString() {
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("resultCode[");
		sbf.append(resultCode);
		sbf.append("]resultMsg[");
		sbf.append(resultMsg);
		sbf.append("]resultPojo[");
		sbf.append(resultPojo);
		sbf.append("]");
		
		return sbf.toString();
	}

}

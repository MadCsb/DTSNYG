
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "printInfo")
public class PrintInfo extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "printInfoId:fid"
          ,
          "wxServiceId:fwxserviceid"
          ,
          "getKey:fgetkey"
          ,
          "ticketFix:fticketfix"
          ,
          "deviceCode:fdevicecode"
          ,
          "picText:fpictext"
          ,
          "succText:fsucctext"
          
        };
	
	//columns START
    /**
     * fid       db_column: F_ID 
     */	
	private String printInfoId;
    /**
     * fwxserviceid       db_column: F_WXSERVICEID 
     */	
	private String wxServiceId;
    /**
     * fgetkey       db_column: F_GETKEY 
     */	
	private String getKey;
    /**
     * fticketfix       db_column: F_TICKETFIX 
     */	
	private String ticketFix;
    /**
     * fdevicecode       db_column: F_DEVICECODE 
     */	
	private String deviceCode;
    /**
     * fpictext       db_column: F_PICTEXT 
     */	
	private String picText;
    /**
     * fsucctext       db_column: F_SUCCTEXT 
     */	
	private String succText;
	//columns END
	private List<String> printInfoIdList;
	public void setPrintInfoId(String printInfoId) {
		this.printInfoId =printInfoId;
	}
	
	public String getPrintInfoId() {
		return this.printInfoId;
	}
	public void setWxServiceId(String wxServiceId) {
		this.wxServiceId =wxServiceId;
	}
	
	public String getWxServiceId() {
		return this.wxServiceId;
	}
	public void setGetKey(String getKey) {
		this.getKey =getKey;
	}
	
	public String getGetKey() {
		return this.getKey;
	}
	public void setTicketFix(String ticketFix) {
		this.ticketFix =ticketFix;
	}
	
	public String getTicketFix() {
		return this.ticketFix;
	}
	public void setDeviceCode(String deviceCode) {
		this.deviceCode =deviceCode;
	}
	
	public String getDeviceCode() {
		return this.deviceCode;
	}
	public void setPicText(String picText) {
		this.picText =picText;
	}
	
	public String getPicText() {
		return this.picText;
	}
	public void setSuccText(String succText) {
		this.succText =succText;
	}
	
	public String getSuccText() {
		return this.succText;
	}
	public void setPrintInfoIdList(List<String> printInfoIdList) {
		this.printInfoIdList = printInfoIdList;
	}
	
	public List<String> getPrintInfoIdList() {
		return this.printInfoIdList;
	}

}


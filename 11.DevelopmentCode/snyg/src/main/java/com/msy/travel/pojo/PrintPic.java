
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "printPic")
public class PrintPic extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "picId:fpicid"
          ,
          "wxServiceId:fwxserviceid"
          ,
          "openId:fopenid"
          ,
          "picUrl:fpicurl"
          
        };
	
	//columns START
    /**
     * fpicid       db_column: F_PICID 
     */	
	private String picId;
    /**
     * fwxserviceid       db_column: F_WXSERVICEID 
     */	
	private String wxServiceId;
    /**
     * fopenid       db_column: F_OPENID 
     */	
	private String openId;
    /**
     * fpicurl       db_column: F_PICURL 
     */	
	private String picUrl;
	//columns END
	private List<String> printPicIdList;
	public void setPicId(String picId) {
		this.picId =picId;
	}
	
	public String getPicId() {
		return this.picId;
	}
	public void setWxServiceId(String wxServiceId) {
		this.wxServiceId =wxServiceId;
	}
	
	public String getWxServiceId() {
		return this.wxServiceId;
	}
	public void setOpenId(String openId) {
		this.openId =openId;
	}
	
	public String getOpenId() {
		return this.openId;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl =picUrl;
	}
	
	public String getPicUrl() {
		return this.picUrl;
	}
	public void setPrintPicIdList(List<String> printPicIdList) {
		this.printPicIdList = printPicIdList;
	}
	
	public List<String> getPrintPicIdList() {
		return this.printPicIdList;
	}

}


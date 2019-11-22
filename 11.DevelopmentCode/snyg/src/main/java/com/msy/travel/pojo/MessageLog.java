
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "messageLog")
public class MessageLog extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "logId:flogid"
          ,
          "fansId:ffansid"
          ,
          "wxServiceId:fwxserviceid"
          ,
          "openId:fopenid"
          ,
          "fromType:0-微信1-自驾游"
          ,
          "direct:0-移动端到服务器1-服务器到移动端"
          ,
          "msgType:0-关注1-取消关注2-普通消息"
          ,
          "context:fcontext"
          ,
          "date:fdate"
          
        };
	
	//columns START
    /**
     * flogid       db_column: F_LOGID 
     */	
	private String logId;
    /**
     * ffansid       db_column: F_FANSID 
     */	
	private String fansId;
    /**
     * fwxserviceid       db_column: F_WXSERVICEID 
     */	
	private String wxServiceId;
    /**
     * fopenid       db_column: F_OPENID 
     */	
	private String openId;
    /**
     * 0-微信1-自驾游       db_column: F_FROMTYPE 
     */	
	private String fromType;
    /**
     * 0-移动端到服务器1-服务器到移动端       db_column: F_DIRECT 
     */	
	private String direct;
    /**
     * 0-关注1-取消关注2-普通消息       db_column: F_MSGTYPE 
     */	
	private String msgType;
    /**
     * fcontext       db_column: F_CONTEXT 
     */	
	private String context;
    /**
     * fdate       db_column: F_DATE 
     */	
	private String date;
	//columns END
	private List<String> messageLogIdList;
	public void setLogId(String logId) {
		this.logId =logId;
	}
	
	public String getLogId() {
		return this.logId;
	}
	public void setFansId(String fansId) {
		this.fansId =fansId;
	}
	
	public String getFansId() {
		return this.fansId;
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
	public void setFromType(String fromType) {
		this.fromType =fromType;
	}
	
	public String getFromType() {
		return this.fromType;
	}
	public void setDirect(String direct) {
		this.direct =direct;
	}
	
	public String getDirect() {
		return this.direct;
	}
	public void setMsgType(String msgType) {
		this.msgType =msgType;
	}
	
	public String getMsgType() {
		return this.msgType;
	}
	public void setContext(String context) {
		this.context =context;
	}
	
	public String getContext() {
		return this.context;
	}
	public void setDate(String date) {
		this.date =date;
	}
	
	public String getDate() {
		return this.date;
	}
	public void setMessageLogIdList(List<String> messageLogIdList) {
		this.messageLogIdList = messageLogIdList;
	}
	
	public List<String> getMessageLogIdList() {
		return this.messageLogIdList;
	}

}



package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "channel")
public class channel extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "channelId:渠道ID"
          ,
          "spId:运营商编号"
          ,
          "venId:供应商编号"
          ,
          "channelName:渠道名称"
          ,
          "status:渠道状态 0:禁用,1:启用"
          ,
          "channelKey:渠道标识"
          ,
          "channelDesc:渠道描述"
          
        };
	
	//columns START
    /**
     * 渠道ID       db_column: F_CHANNELID 
     */	
	private String channelId;
    /**
     * 运营商编号       db_column: F_SPID 
     */	
	private String spId;
    /**
     * 供应商编号       db_column: F_VENID 
     */	
	private String venId;
    /**
     * 渠道名称       db_column: F_CHANNELNAME 
     */	
	private String channelName;
    /**
     * 渠道状态 0:禁用,1:启用       db_column: F_STATUS 
     */	
	private String status;
    /**
     * 渠道标识       db_column: F_CHANNELKEY 
     */	
	private String channelKey;
    /**
     * 渠道描述       db_column: F_CHANNELDESC 
     */	
	private String channelDesc;
	//columns END
	private List<String> channelIdList;
	public void setChannelId(String channelId) {
		this.channelId =channelId;
	}
	
	public String getChannelId() {
		return this.channelId;
	}
	public void setSpId(String spId) {
		this.spId =spId;
	}
	
	public String getSpId() {
		return this.spId;
	}
	public void setVenId(String venId) {
		this.venId =venId;
	}
	
	public String getVenId() {
		return this.venId;
	}
	public void setChannelName(String channelName) {
		this.channelName =channelName;
	}
	
	public String getChannelName() {
		return this.channelName;
	}
	public void setStatus(String status) {
		this.status =status;
	}
	
	public String getStatus() {
		return this.status;
	}
	public void setChannelKey(String channelKey) {
		this.channelKey =channelKey;
	}
	
	public String getChannelKey() {
		return this.channelKey;
	}
	public void setChannelDesc(String channelDesc) {
		this.channelDesc =channelDesc;
	}
	
	public String getChannelDesc() {
		return this.channelDesc;
	}
	public void setchannelIdList(List<String> channelIdList) {
		this.channelIdList = channelIdList;
	}
	
	public List<String> getchannelIdList() {
		return this.channelIdList;
	}

}


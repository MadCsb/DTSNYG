
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "userBindChannel")
public class UserBindChannel extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "channelId:渠道ID"
          ,
          "userId:fuserid"
          
        };
	
	//columns START
    /**
     * 渠道ID       db_column: F_CHANNELID 
     */	
	private String channelId;
    /**
     * fuserid       db_column: F_USERID 
     */	
	private String userId;
	//columns END
	private List<String> userBindChannelIdList;
	public void setChannelId(String channelId) {
		this.channelId =channelId;
	}
	
	public String getChannelId() {
		return this.channelId;
	}
	public void setUserId(String userId) {
		this.userId =userId;
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setUserBindChannelIdList(List<String> userBindChannelIdList) {
		this.userBindChannelIdList = userBindChannelIdList;
	}
	
	public List<String> getUserBindChannelIdList() {
		return this.userBindChannelIdList;
	}

}


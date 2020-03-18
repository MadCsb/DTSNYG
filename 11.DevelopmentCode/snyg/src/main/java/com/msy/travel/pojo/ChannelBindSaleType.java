
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "channelBindSaleType")
public class ChannelBindSaleType extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "saleTypeId:活动类型ID"
          ,
          "channelId:渠道ID"
          
        };
	
	//columns START
    /**
     * 活动类型ID       db_column: F_SALETYPEID 
     */	
	private String saleTypeId;
    /**
     * 渠道ID       db_column: F_CHANNELID 
     */	
	private String channelId;
	//columns END
	private List<String> channelBindSaleTypeIdList;
	public void setSaleTypeId(String saleTypeId) {
		this.saleTypeId =saleTypeId;
	}
	
	public String getSaleTypeId() {
		return this.saleTypeId;
	}
	public void setChannelId(String channelId) {
		this.channelId =channelId;
	}
	
	public String getChannelId() {
		return this.channelId;
	}
	public void setChannelBindSaleTypeIdList(List<String> channelBindSaleTypeIdList) {
		this.channelBindSaleTypeIdList = channelBindSaleTypeIdList;
	}
	
	public List<String> getChannelBindSaleTypeIdList() {
		return this.channelBindSaleTypeIdList;
	}

}


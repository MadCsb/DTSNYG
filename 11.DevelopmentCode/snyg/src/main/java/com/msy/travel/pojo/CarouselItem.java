
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "carouselItem")
public class CarouselItem extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "itemId:轮播图明细ID"
          ,
          "carouselId:轮播图ID"
          ,
          "title:明细标题"
          ,
          "picUrl:图片URL"
          ,
          "linkUrl:关联URL"
          ,
          "seqNum:顺序"
          
        };
	
	//columns START
    /**
     * 轮播图明细ID       db_column: F_ITEMID 
     */	
	private String itemId;
    /**
     * 轮播图ID       db_column: F_CAROUSELID 
     */	
	private String carouselId;
    /**
     * 明细标题       db_column: F_TITLE 
     */	
	private String title;
    /**
     * 图片URL       db_column: F_PICURL 
     */	
	private String picUrl;
    /**
     * 关联URL       db_column: F_LINKURL 
     */	
	private String linkUrl;
    /**
     * 顺序       db_column: F_SEQNUM 
     */	
	private String seqNum;
	//columns END
	private List<String> carouselItemIdList;
	public void setItemId(String itemId) {
		this.itemId =itemId;
	}
	
	public String getItemId() {
		return this.itemId;
	}
	public void setCarouselId(String carouselId) {
		this.carouselId =carouselId;
	}
	
	public String getCarouselId() {
		return this.carouselId;
	}
	public void setTitle(String title) {
		this.title =title;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl =picUrl;
	}
	
	public String getPicUrl() {
		return this.picUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl =linkUrl;
	}
	
	public String getLinkUrl() {
		return this.linkUrl;
	}
	public void setSeqNum(String seqNum) {
		this.seqNum =seqNum;
	}
	
	public String getSeqNum() {
		return this.seqNum;
	}
	public void setCarouselItemIdList(List<String> carouselItemIdList) {
		this.carouselItemIdList = carouselItemIdList;
	}
	
	public List<String> getCarouselItemIdList() {
		return this.carouselItemIdList;
	}

}


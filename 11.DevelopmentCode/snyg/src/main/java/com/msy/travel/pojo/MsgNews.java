
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "msgNews")
public class MsgNews extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "newsId:fnewsid"
          ,
          "feedbackId:ffeedbackid"
          ,
          "newsTitle:ftitle"
          ,
          "newsDesc:fdesc"
          ,
          "picUrl:fpicurl"
          ,
          "linkUrl:furl"
          ,
          "isMain:0-否1-是"
          ,
          "sortNum:fsortnum"
          
        };
	
	//columns START
    /**
     * fnewsid       db_column: F_NEWSID 
     */	
	private String newsId;
    /**
     * ffeedbackid       db_column: F_FEEDBACKID 
     */	
	private String feedbackId;
    /**
     * ftitle       db_column: F_TITLE 
     */	
	private String newsTitle;
    /**
     * fdesc       db_column: F_DESC 
     */	
	private String newsDesc;
    /**
     * fpicurl       db_column: F_PICURL 
     */	
	private String picUrl;
    /**
     * furl       db_column: F_URL 
     */	
	private String linkUrl;
    /**
     * 0-否1-是       db_column: F_ISMAIN 
     */	
	private String isMain;
    /**
     * fsortnum       db_column: F_SORTNUM 
     */	
	private String sortNum;
	
	//columns END
	private List<String> msgNewsIdList;
	public void setNewsId(String newsId) {
		this.newsId =newsId;
	}
	
	public String getNewsId() {
		return this.newsId;
	}
	public void setFeedbackId(String feedbackId) {
		this.feedbackId =feedbackId;
	}
	
	public String getFeedbackId() {
		return this.feedbackId;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle =newsTitle;
	}
	
	public String getNewsTitle() {
		return this.newsTitle;
	}
	public void setNewsDesc(String newsDesc) {
		this.newsDesc =newsDesc;
	}
	
	public String getNewsDesc() {
		return this.newsDesc;
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
	public void setIsMain(String isMain) {
		this.isMain =isMain;
	}
	
	public String getIsMain() {
		return this.isMain;
	}

	public void setMsgNewsIdList(List<String> msgNewsIdList) {
		this.msgNewsIdList = msgNewsIdList;
	}
	
	public List<String> getMsgNewsIdList() {
		return this.msgNewsIdList;
	}

	public String getSortNum() {
		return sortNum;
	}

	public void setSortNum(String sortNum) {
		this.sortNum = sortNum;
	}
}


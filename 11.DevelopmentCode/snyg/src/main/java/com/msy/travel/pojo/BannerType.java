
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "bannerType")
public class BannerType extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "bannerTypeId:栏目类型ID"
          ,
          "typeName:栏目类型名称"
          ,
          "spId:运营商ID"
          ,
          "createTime:创建时间"
          ,
          "creatorUid:创建人"
          ,
          "creator:创建人姓名"
          ,
          "updateTime:修改时间"
          ,
          "updaterUid:修改人"
          ,
          "updater:修改人姓名"
          ,
          "bannerTypeTag:栏目类型标识"
          ,
          "picUrl:栏目类型图片"
          ,
          "seqNum:排序"
          ,
          "delFlag:是否删除0-未删除1-已删除"
          
        };
	
	//columns START
    /**
     * 栏目类型ID       db_column: F_BANNERTYPEID 
     */	
	private String bannerTypeId;
    /**
     * 栏目类型名称       db_column: F_TYPENAME 
     */	
	private String typeName;
    /**
     * 运营商ID       db_column: F_SPID 
     */	
	private String spId;
    /**
     * 创建时间       db_column: F_CREATETIME 
     */	
	private String createTime;
    /**
     * 创建人       db_column: F_CREATORUID 
     */	
	private String creatorUid;
    /**
     * 创建人姓名       db_column: F_CREATOR 
     */	
	private String creator;
    /**
     * 修改时间       db_column: F_UPDATETIME 
     */	
	private String updateTime;
    /**
     * 修改人       db_column: F_UPDATERUID 
     */	
	private String updaterUid;
    /**
     * 修改人姓名       db_column: F_UPDATER 
     */	
	private String updater;
    /**
     * 栏目类型标识       db_column: F_BANNERTYPETAG 
     */	
	private String bannerTypeTag;
    /**
     * 栏目类型图片       db_column: F_PICURL 
     */	
	private String picUrl;
    /**
     * 排序       db_column: F_SEQNUM 
     */	
	private String seqNum;
    /**
     * 是否删除0-未删除1-已删除       db_column: F_DELFLAG 
     */	
	private String delFlag;
	//columns END
	private List<String> bannerTypeIdList;
	public void setBannerTypeId(String bannerTypeId) {
		this.bannerTypeId =bannerTypeId;
	}
	
	public String getBannerTypeId() {
		return this.bannerTypeId;
	}
	public void setTypeName(String typeName) {
		this.typeName =typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	public void setSpId(String spId) {
		this.spId =spId;
	}
	
	public String getSpId() {
		return this.spId;
	}
	public void setCreateTime(String createTime) {
		this.createTime =createTime;
	}
	
	public String getCreateTime() {
		return this.createTime;
	}
	public void setCreatorUid(String creatorUid) {
		this.creatorUid =creatorUid;
	}
	
	public String getCreatorUid() {
		return this.creatorUid;
	}
	public void setCreator(String creator) {
		this.creator =creator;
	}
	
	public String getCreator() {
		return this.creator;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime =updateTime;
	}
	
	public String getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdaterUid(String updaterUid) {
		this.updaterUid =updaterUid;
	}
	
	public String getUpdaterUid() {
		return this.updaterUid;
	}
	public void setUpdater(String updater) {
		this.updater =updater;
	}
	
	public String getUpdater() {
		return this.updater;
	}
	public void setBannerTypeTag(String bannerTypeTag) {
		this.bannerTypeTag =bannerTypeTag;
	}
	
	public String getBannerTypeTag() {
		return this.bannerTypeTag;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl =picUrl;
	}
	
	public String getPicUrl() {
		return this.picUrl;
	}
	public void setSeqNum(String seqNum) {
		this.seqNum =seqNum;
	}
	
	public String getSeqNum() {
		return this.seqNum;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag =delFlag;
	}
	
	public String getDelFlag() {
		return this.delFlag;
	}
	public void setBannerTypeIdList(List<String> bannerTypeIdList) {
		this.bannerTypeIdList = bannerTypeIdList;
	}
	
	public List<String> getBannerTypeIdList() {
		return this.bannerTypeIdList;
	}

}


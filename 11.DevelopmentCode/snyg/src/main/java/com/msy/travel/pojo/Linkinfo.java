
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "linkinfo")
public class Linkinfo extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "linkId:联系人编号"
          ,
          "venId:供应商编号"
          ,
          "duty:职务"
          ,
          "name:姓名"
          ,
          "handPhone:手机"
          ,
          "fax:传真"
          ,
          "tel:办公电话"
          ,
          "qq:QQ"
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
          
        };
	
	//columns START
    /**
     * 联系人编号       db_column: F_LINKID 
     */	
	private String linkId;
    /**
     * 供应商编号       db_column: F_VENID 
     */	
	private String venId;
    /**
     * 职务       db_column: F_DUTY 
     */	
	private String duty;
    /**
     * 姓名       db_column: F_NAME 
     */	
	private String name;
    /**
     * 手机       db_column: F_HANDPHONE 
     */	
	private String handPhone;
    /**
     * 传真       db_column: F_FAX 
     */	
	private String fax;
    /**
     * 办公电话       db_column: F_TEL 
     */	
	private String tel;
    /**
     * QQ       db_column: F_QQ 
     */	
	private String qq;
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
	
	private int size;
	//columns END
	private List<String> linkinfoIdList;
	public void setLinkId(String linkId) {
		this.linkId =linkId;
	}
	
	public String getLinkId() {
		return this.linkId;
	}
	public void setVenId(String venId) {
		this.venId =venId;
	}
	
	public String getVenId() {
		return this.venId;
	}
	public void setDuty(String duty) {
		this.duty =duty;
	}
	
	public String getDuty() {
		return this.duty;
	}
	public void setName(String name) {
		this.name =name;
	}
	
	public String getName() {
		return this.name;
	}
	public void setHandPhone(String handPhone) {
		this.handPhone =handPhone;
	}
	
	public String getHandPhone() {
		return this.handPhone;
	}
	public void setFax(String fax) {
		this.fax =fax;
	}
	
	public String getFax() {
		return this.fax;
	}
	public void setTel(String tel) {
		this.tel =tel;
	}
	
	public String getTel() {
		return this.tel;
	}
	public void setQq(String qq) {
		this.qq =qq;
	}
	
	public String getQq() {
		return this.qq;
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
	public void setLinkinfoIdList(List<String> linkinfoIdList) {
		this.linkinfoIdList = linkinfoIdList;
	}
	
	public List<String> getLinkinfoIdList() {
		return this.linkinfoIdList;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}


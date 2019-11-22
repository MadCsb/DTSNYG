
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "rsPic")
public class RsPic extends BaseEntity implements java.io.Serializable
{
	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "picId:主键"
          ,
          "rsId:资源编号"
          ,
          "picTitle:图片标题"
          ,
          "picFileName:图片文件名"
          ,
          "picOrder:图片顺序"
          ,
          "rsType:资源类型"
          
        };
	
	//columns START
    /**
     * 主键       db_column: F_PICID 
     */	
	private String picId;
    /**
     * 资源编号       db_column: F_RSID 
     */	
	private String rsId;
    /**
     * 图片标题       db_column: F_PICTITLE 
     */	
	private String picTitle;
    /**
     * 图片文件名       db_column: F_PICFILENAME 
     */	
	private String picFileName;
    /**
     * 图片顺序       db_column: F_ORDER 
     */	
	private String picOrder;
    /**
     * 资源类型       db_column: F_RSTYPE 
     */	
	private String rsType;
	//columns END
	private List<String> rsPicIdList;
	public void setPicId(String picId) {
		this.picId =picId;
	}
	
	public String getPicId() {
		return this.picId;
	}
	public void setRsId(String rsId) {
		this.rsId =rsId;
	}
	
	public String getRsId() {
		return this.rsId;
	}
	public void setPicTitle(String picTitle) {
		this.picTitle =picTitle;
	}
	
	public String getPicTitle() {
		return this.picTitle;
	}
	public void setPicFileName(String picFileName) {
		this.picFileName =picFileName;
	}
	
	public String getPicFileName() {
		return this.picFileName;
	}
	public void setPicOrder(String picOrder) {
		this.picOrder =picOrder;
	}
	
	public String getPicOrder() {
		return this.picOrder;
	}
	public void setRsType(String rsType) {
		this.rsType =rsType;
	}
	
	public String getRsType() {
		return this.rsType;
	}
	public void setRsPicIdList(List<String> rsPicIdList) {
		this.rsPicIdList = rsPicIdList;
	}
	
	public List<String> getRsPicIdList() {
		return this.rsPicIdList;
	}

}


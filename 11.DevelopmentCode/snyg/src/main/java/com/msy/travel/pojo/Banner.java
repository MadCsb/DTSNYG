
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "banner")
public class Banner extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "bannId:产品栏目编号"
          ,
          "type:栏目类型：0-推荐产品1-热门产品 2-秒购产品 3-特惠产品 4-包装袋产品 5-送家人产品 6-送自己产品 7-送朋友产品"
          ,
          "fcproductid:产品编号"
          ,
          "sort:默认顺序"
          ,
          "spId:运营商ID"
          
        };
	
	//columns START
    /**
     * 产品栏目编号       db_column: F_BANNID 
     */	
	private String bannId;
    /**
     * 栏目类型：0-推荐产品1-热门产品 2-秒购产品 3-特惠产品 4-包装袋产品 5-送家人产品 6-送自己产品 7-送朋友产品       db_column: F_TYPE 
     */	
	private String type;
    /**
     * 产品编号       db_column: F_CPRODUCTID 
     */	
	private java.lang.String fcproductid;
    /**
     * 默认顺序       db_column: F_SORT 
     */	
	private String sort;
    /**
     * 运营商ID       db_column: F_SPID 
     */	
	private String spId;
	//columns END
	private List<String> bannerIdList;
	public void setBannId(String bannId) {
		this.bannId =bannId;
	}
	
	public String getBannId() {
		return this.bannId;
	}
	public void setType(String type) {
		this.type =type;
	}
	
	public String getType() {
		return this.type;
	}
	public void setFcproductid(java.lang.String fcproductid) {
		this.fcproductid =fcproductid;
	}
	
	public java.lang.String getFcproductid() {
		return this.fcproductid;
	}
	public void setSort(String sort) {
		this.sort =sort;
	}
	
	public String getSort() {
		return this.sort;
	}
	public void setSpId(String spId) {
		this.spId =spId;
	}
	
	public String getSpId() {
		return this.spId;
	}
	public void setBannerIdList(List<String> bannerIdList) {
		this.bannerIdList = bannerIdList;
	}
	
	public List<String> getBannerIdList() {
		return this.bannerIdList;
	}

}


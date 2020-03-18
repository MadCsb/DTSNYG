
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "saleType")
public class SaleType extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "saleTypeId:活动类型ID"
          ,
          "spId:运营商编号"
          ,
          "venId:供应商编号"
          ,
          "saleTypeName:活动名称"
          ,
          "status:渠道状态 0:禁用,1:启用"
          ,
          "saleTypeKey:活动标识"
          ,
          "saleTypeDesc:活动描述"
          
        };
	
	//columns START
    /**
     * 活动类型ID       db_column: F_SALETYPEID 
     */	
	private String saleTypeId;
    /**
     * 运营商编号       db_column: F_SPID 
     */	
	private String spId;
    /**
     * 供应商编号       db_column: F_VENID 
     */	
	private String venId;
    /**
     * 活动名称       db_column: F_SALETYPENAME 
     */	
	private String saleTypeName;
    /**
     * 渠道状态 0:禁用,1:启用       db_column: F_STATUS 
     */	
	private String status;
    /**
     * 活动标识       db_column: F_SALETYPEKEY 
     */	
	private String saleTypeKey;
    /**
     * 活动描述       db_column: F_SALETYPEDESC 
     */	
	private String saleTypeDesc;
	//columns END
	private List<String> saleTypeIdList;
	public void setSaleTypeId(String saleTypeId) {
		this.saleTypeId =saleTypeId;
	}
	
	public String getSaleTypeId() {
		return this.saleTypeId;
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
	public void setSaleTypeName(String saleTypeName) {
		this.saleTypeName =saleTypeName;
	}
	
	public String getSaleTypeName() {
		return this.saleTypeName;
	}
	public void setStatus(String status) {
		this.status =status;
	}
	
	public String getStatus() {
		return this.status;
	}
	public void setSaleTypeKey(String saleTypeKey) {
		this.saleTypeKey =saleTypeKey;
	}
	
	public String getSaleTypeKey() {
		return this.saleTypeKey;
	}
	public void setSaleTypeDesc(String saleTypeDesc) {
		this.saleTypeDesc =saleTypeDesc;
	}
	
	public String getSaleTypeDesc() {
		return this.saleTypeDesc;
	}
	public void setSaleTypeIdList(List<String> saleTypeIdList) {
		this.saleTypeIdList = saleTypeIdList;
	}
	
	public List<String> getSaleTypeIdList() {
		return this.saleTypeIdList;
	}

}


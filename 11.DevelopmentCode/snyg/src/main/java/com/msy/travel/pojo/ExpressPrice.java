
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "expressPrice")
public class ExpressPrice extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "expressPriceId:运费价格表ID"
          ,
          "companyExpressId:运费模板Id"
          ,
          "province:省份"
          ,
          "expressNum:首件"
          ,
          "expressPrice:首件价格"
          ,
          "expressNumAdd:续件"
          ,
          "expressPriceAdd:续件价格"
          
        };
	
	//columns START
    /**
     * 运费价格表ID       db_column: F_EXPRESSPRICEID 
     */	
	private String expressPriceId;
    /**
     * 运费模板Id       db_column: F_COMPANYEXPRESSID 
     */	
	private String companyExpressId;
    /**
     * 省份       db_column: F_PROVINCE 
     */	
	private String province;
    /**
     * 首件       db_column: F_EXPRESSNUM 
     */	
	private String expressNum;
    /**
     * 首件价格       db_column: F_EXPRESSPRICE 
     */	
	private String expressPrice;
    /**
     * 续件       db_column: F_EXPRESSNUMADD 
     */	
	private String expressNumAdd;
    /**
     * 续件价格       db_column: F_EXPRESSPRICEADD 
     */	
	private String expressPriceAdd;
	//columns END
	private List<String> expressPriceIdList;
	public void setExpressPriceId(String expressPriceId) {
		this.expressPriceId =expressPriceId;
	}
	
	public String getExpressPriceId() {
		return this.expressPriceId;
	}
	public void setCompanyExpressId(String companyExpressId) {
		this.companyExpressId =companyExpressId;
	}
	
	public String getCompanyExpressId() {
		return this.companyExpressId;
	}
	public void setProvince(String province) {
		this.province =province;
	}
	
	public String getProvince() {
		return this.province;
	}
	public void setExpressNum(String expressNum) {
		this.expressNum =expressNum;
	}
	
	public String getExpressNum() {
		return this.expressNum;
	}
	public void setExpressPrice(String expressPrice) {
		this.expressPrice =expressPrice;
	}
	
	public String getExpressPrice() {
		return this.expressPrice;
	}
	public void setExpressNumAdd(String expressNumAdd) {
		this.expressNumAdd =expressNumAdd;
	}
	
	public String getExpressNumAdd() {
		return this.expressNumAdd;
	}
	public void setExpressPriceAdd(String expressPriceAdd) {
		this.expressPriceAdd =expressPriceAdd;
	}
	
	public String getExpressPriceAdd() {
		return this.expressPriceAdd;
	}
	public void setExpressPriceIdList(List<String> expressPriceIdList) {
		this.expressPriceIdList = expressPriceIdList;
	}
	
	public List<String> getExpressPriceIdList() {
		return this.expressPriceIdList;
	}

}


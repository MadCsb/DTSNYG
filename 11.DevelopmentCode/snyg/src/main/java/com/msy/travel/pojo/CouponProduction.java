
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "couponProduction")
public class CouponProduction extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "couponPdcId:优惠券产品关联ID"
          ,
          "couponId:优惠券ID"
          ,
          "useCouponId:产品ID/活动ID"
          ,
          "couponType:优惠类型:1全部商品，2指定商品 3活动商品"
          
        };
	
	//columns START
    /**
     * 优惠券产品关联ID       db_column: F_COUPONPDCID 
     */	
	private String couponPdcId;
    /**
     * 优惠券ID       db_column: F_COUPONID 
     */	
	private String couponId;
    /**
     * 产品ID/活动ID       db_column: F_USECOUPONID 
     */	
	private String useCouponId;
    /**
     * 优惠类型:1全部商品，2指定商品 3活动商品       db_column: F_COUPONTYPE 
     */	
	private String couponType;
	//columns END
	private List<String> couponProductionIdList;
	public void setCouponPdcId(String couponPdcId) {
		this.couponPdcId =couponPdcId;
	}
	
	public String getCouponPdcId() {
		return this.couponPdcId;
	}
	public void setCouponId(String couponId) {
		this.couponId =couponId;
	}
	
	public String getCouponId() {
		return this.couponId;
	}
	public void setUseCouponId(String useCouponId) {
		this.useCouponId =useCouponId;
	}
	
	public String getUseCouponId() {
		return this.useCouponId;
	}
	public void setCouponType(String couponType) {
		this.couponType =couponType;
	}
	
	public String getCouponType() {
		return this.couponType;
	}
	public void setCouponProductionIdList(List<String> couponProductionIdList) {
		this.couponProductionIdList = couponProductionIdList;
	}
	
	public List<String> getCouponProductionIdList() {
		return this.couponProductionIdList;
	}

}


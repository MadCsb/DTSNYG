package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "couponCommproduct")
public class CouponCommproduct extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"couponCommId:优惠券商品关联ID", "couponId:优惠券ID", "useCouponPdcId:产品ID", "isCommon:是否包含普通商品 0否 1是", "isGroupPro:是否包含团购商品0否1是", "isSeckill:是否包含秒杀商品0否 1是"

	};

	// columns START
	/**
	 * 优惠券商品关联ID db_column: F_COUPONCOMMID
	 */
	private String couponCommId;
	/**
	 * 优惠券ID db_column: F_COUPONID
	 */
	private String couponId;
	/**
	 * 产品ID db_column: F_USECOUPONPDCID
	 */
	private String useCouponPdcId;
	/**
	 * 是否包含普通商品 0否 1是 db_column: F_ISCOMMON
	 */
	private String isCommon;
	/**
	 * 是否包含团购商品0否1是 db_column: F_ISGROUPPRO
	 */
	private String isGroupPro;
	/**
	 * 是否包含秒杀商品0否 1是 db_column: F_ISSECKILL
	 */
	private String isSeckill;

	/**
	 * 创建时间 F_CREATETIME
	 */
	private String createTime;

	/**
	 * F_SOURCETYPE数据类型 0临时 1正式
	 */
	private String sourceType;

	// columns END
	private List<String> couponCommproductIdList;

	private String useCouponPdcIdString;

	public String getUseCouponPdcIdString() {
		return useCouponPdcIdString;
	}

	public void setUseCouponPdcIdString(String useCouponPdcIdString) {
		this.useCouponPdcIdString = useCouponPdcIdString;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public void setCouponCommId(String couponCommId) {
		this.couponCommId = couponCommId;
	}

	public String getCouponCommId() {
		return this.couponCommId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getCouponId() {
		return this.couponId;
	}

	public void setUseCouponPdcId(String useCouponPdcId) {
		this.useCouponPdcId = useCouponPdcId;
	}

	public String getUseCouponPdcId() {
		return this.useCouponPdcId;
	}

	public void setIsCommon(String isCommon) {
		this.isCommon = isCommon;
	}

	public String getIsCommon() {
		return this.isCommon;
	}

	public void setIsGroupPro(String isGroupPro) {
		this.isGroupPro = isGroupPro;
	}

	public String getIsGroupPro() {
		return this.isGroupPro;
	}

	public void setIsSeckill(String isSeckill) {
		this.isSeckill = isSeckill;
	}

	public String getIsSeckill() {
		return this.isSeckill;
	}

	public void setCouponCommproductIdList(List<String> couponCommproductIdList) {
		this.couponCommproductIdList = couponCommproductIdList;
	}

	public List<String> getCouponCommproductIdList() {
		return this.couponCommproductIdList;
	}

}

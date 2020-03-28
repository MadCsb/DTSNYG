package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "customerCoupon")
public class CustomerCoupon extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"customerCouponId:客户优惠券关联ID", "customerCode:客户编号", "couponId:优惠券ID", "useType:使用类型:1满减，2折扣", "useLimit:使用限制：满XXXX元", "discount:折扣优惠", "couponType:优惠类型:1全部商品，2指定商品", "validBegin:有效开始日期",
			"validEnd:有效结束日期", "obtainTime:领券时间", "status:使用状态:0未使用，1已使用", "orderId:订单ID", "delFlag:是否删除0-未删除1-已删除"

	};

	// columns START
	/**
	 * 客户优惠券关联ID db_column: F_CUSTOMERCOUPONID
	 */
	private String customerCouponId;
	/**
	 * 客户编号 db_column: F_CUSTOMERCODE
	 */
	private String customerCode;
	/**
	 * 优惠券ID db_column: F_COUPONID
	 */
	private String couponId;
	/**
	 * 使用类型:1满减，2折扣 db_column: F_USETYPE
	 */
	private String useType;
	/**
	 * 使用限制：满XXXX元 db_column: F_USELIMIT
	 */
	private String useLimit;
	/**
	 * 折扣优惠 db_column: F_DISCOUNT
	 */
	private String discount;
	/**
	 * 优惠类型:1全部商品，2指定商品 db_column: F_COUPONTYPE
	 */
	private String couponType;
	/**
	 * 有效开始日期 db_column: F_VALIDBEGIN
	 */
	private String validBegin;
	/**
	 * 有效结束日期 db_column: F_VALIDEND
	 */
	private String validEnd;
	/**
	 * 领券时间 db_column: F_OBTAINTIME
	 */
	private String obtainTime;
	/**
	 * 使用状态:0未使用，1已使用 db_column: F_STATUS
	 */
	private String status;
	/**
	 * 订单ID db_column: F_ORDERID
	 */
	private String orderId;
	/**
	 * 是否删除0-未删除1-已删除 db_column: F_DELFLAG
	 */
	private String delFlag;

	// columns END
	private List<String> customerCouponIdList;

	// 使用的priceId
	private List<String> useCouponIdList;

	private String crrObtainDate;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCrrObtainDate() {
		return crrObtainDate;
	}

	public void setCrrObtainDate(String crrObtainDate) {
		this.crrObtainDate = crrObtainDate;
	}

	public List<String> getUseCouponIdList() {
		return useCouponIdList;
	}

	public void setUseCouponIdList(List<String> useCouponIdList) {
		this.useCouponIdList = useCouponIdList;
	}

	public void setCustomerCouponId(String customerCouponId) {
		this.customerCouponId = customerCouponId;
	}

	public String getCustomerCouponId() {
		return this.customerCouponId;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerCode() {
		return this.customerCode;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getCouponId() {
		return this.couponId;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public String getUseType() {
		return this.useType;
	}

	public void setUseLimit(String useLimit) {
		this.useLimit = useLimit;
	}

	public String getUseLimit() {
		return this.useLimit;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getDiscount() {
		return this.discount;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getCouponType() {
		return this.couponType;
	}

	public void setValidBegin(String validBegin) {
		this.validBegin = validBegin;
	}

	public String getValidBegin() {
		return this.validBegin;
	}

	public void setValidEnd(String validEnd) {
		this.validEnd = validEnd;
	}

	public String getValidEnd() {
		return this.validEnd;
	}

	public void setObtainTime(String obtainTime) {
		this.obtainTime = obtainTime;
	}

	public String getObtainTime() {
		return this.obtainTime;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getDelFlag() {
		return this.delFlag;
	}

	public void setCustomerCouponIdList(List<String> customerCouponIdList) {
		this.customerCouponIdList = customerCouponIdList;
	}

	public List<String> getCustomerCouponIdList() {
		return this.customerCouponIdList;
	}

}

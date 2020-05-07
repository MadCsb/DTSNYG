package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "coupon")
public class Coupon extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"couponId:优惠券ID", "spId:运营商编号", "name:优惠券名称", "obtainType:获取方式:1商品页领取；2活动页领取", "totalNum:发行总量", "dayNum:日发行量", "userType:使用类型:1满减，2折扣", "useLimit:使用限制：满XXXX元", "discount:折扣优惠",
			"obtainLimit:每人限领", "dayObtainLimit:每人每天限领", "validBegin:有效开始日期", "validEnd:有效结束日期", "obtainDateType:领券日期类型：1有效时段，2有效时长", "obtainDateBegin:领券开始日期", "obtainDateEnd:领券结束日期",
			"obtainDateSpan:领券结束时长", "couponType:优惠类型:1全部商品，2指定商品", "status:状态:1", "createTime:创建时间", "creatorUid:创建人", "creator:创建人姓名", "updateTime:修改时间", "updaterUid:修改人", "updater:修改人姓名",
			"delFlag:是否删除0-未删除1-已删除", "couponTag:优惠券标识，0:历史数据 1最新数据", "pcouponId:首次生成优惠券ID"

	};
	// columns START
	/**
	 * 优惠券ID db_column: F_COUPONID
	 */
	private String couponId;
	/**
	 * 运营商编号 db_column: F_SPID
	 */
	private String spId;
	/**
	 * 优惠券名称 db_column: F_NAME
	 */
	private String name;
	/**
	 * 获取方式:1商品页领取；2活动页领取 db_column: F_OBTAINTYPE
	 */
	private String obtainType;
	/**
	 * 发行总量 db_column: F_TOTALNUM
	 */
	private String totalNum;
	/**
	 * 日发行量 db_column: F_DAYNUM
	 */
	private String dayNum;
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
	 * 每人限领 db_column: F_OBTAINLIMIT
	 */
	private String obtainLimit;
	/**
	 * 每人每天限领 db_column: F_DAYOBTAINLIMIT
	 */
	private String dayObtainLimit;
	/**
	 * 有效开始日期 db_column: F_VALIDBEGIN
	 */
	private String validBegin;
	/**
	 * 有效结束日期 db_column: F_VALIDEND
	 */
	private String validEnd;
	/**
	 * 领券日期类型：1有效时段，2有效时长 db_column: F_OBTAINDATETYPE
	 */
	private String obtainDateType;
	/**
	 * 领券开始日期 db_column: F_OBTAINDATEBEGIN
	 */
	private String obtainDateBegin;
	/**
	 * 领券结束日期 db_column: F_OBTAINDATEEND
	 */
	private String obtainDateEnd;
	/**
	 * 领券结束时长 db_column: F_OBTAINDATESPAN
	 */
	private String obtainDateSpan;
	/**
	 * 优惠类型:1全部商品，2指定商品 db_column: F_COUPONTYPE
	 */
	private String couponType;
	/**
	 * 状态:1 db_column: F_STATUS
	 */
	private String status;
	/**
	 * 创建时间 db_column: F_CREATETIME
	 */
	private String createTime;
	/**
	 * 创建人 db_column: F_CREATORUID
	 */
	private String creatorUid;
	/**
	 * 创建人姓名 db_column: F_CREATOR
	 */
	private String creator;
	/**
	 * 修改时间 db_column: F_UPDATETIME
	 */
	private String updateTime;
	/**
	 * 修改人 db_column: F_UPDATERUID
	 */
	private String updaterUid;
	/**
	 * 修改人姓名 db_column: F_UPDATER
	 */
	private String updater;
	/**
	 * 是否删除0-未删除1-已删除 db_column: F_DELFLAG
	 */
	private String delFlag;
	/**
	 * 优惠券标识，0:历史数据 1最新数据 db_column: F_COUPONTAG
	 */
	private String couponTag;
	/**
	 * 首次生成优惠券ID db_column: F_PCOUPONID
	 */
	private String pcouponId;

	// columns END
	private List<String> couponIdList;

	// 全部商品 使用范围
	private String useCouponId;

	// 剩余
	private String surplus;

	// 成交用户量
	private String customerUseNum;

	// 日期类型
	private String dateType;

	// 日期范围类型
	private String dateTimeType;

	private String dateStart;

	private String dateEnd;

	// 当天日期
	private String crrObtainDate;

	// USECOUPONID
	private List<String> useCouponIdList;

	private String userId;

	private String receiveCount;

	private String todayCount;

	private String money;

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getReceiveCount() {
		return receiveCount;
	}

	public void setReceiveCount(String receiveCount) {
		this.receiveCount = receiveCount;
	}

	public String getTodayCount() {
		return todayCount;
	}

	public void setTodayCount(String todayCount) {
		this.todayCount = todayCount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getUseCouponIdList() {
		return useCouponIdList;
	}

	public void setUseCouponIdList(List<String> useCouponIdList) {
		this.useCouponIdList = useCouponIdList;
	}

	public String getCrrObtainDate() {
		return crrObtainDate;
	}

	public void setCrrObtainDate(String crrObtainDate) {
		this.crrObtainDate = crrObtainDate;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getDateTimeType() {
		return dateTimeType;
	}

	public void setDateTimeType(String dateTimeType) {
		this.dateTimeType = dateTimeType;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getSurplus() {
		return surplus;
	}

	public void setSurplus(String surplus) {
		this.surplus = surplus;
	}

	public String getCustomerUseNum() {
		return customerUseNum;
	}

	public void setCustomerUseNum(String customerUseNum) {
		this.customerUseNum = customerUseNum;
	}

	public String getUseCouponId() {
		return useCouponId;
	}

	public void setUseCouponId(String useCouponId) {
		this.useCouponId = useCouponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getCouponId() {
		return this.couponId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getSpId() {
		return this.spId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getObtainType() {
		return obtainType;
	}

	public void setObtainType(String obtainType) {
		this.obtainType = obtainType;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	public String getTotalNum() {
		return this.totalNum;
	}

	public void setDayNum(String dayNum) {
		this.dayNum = dayNum;
	}

	public String getDayNum() {
		return this.dayNum;
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
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

	public void setObtainLimit(String obtainLimit) {
		this.obtainLimit = obtainLimit;
	}

	public String getObtainLimit() {
		return this.obtainLimit;
	}

	public void setDayObtainLimit(String dayObtainLimit) {
		this.dayObtainLimit = dayObtainLimit;
	}

	public String getDayObtainLimit() {
		return this.dayObtainLimit;
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

	public void setObtainDateType(String obtainDateType) {
		this.obtainDateType = obtainDateType;
	}

	public String getObtainDateType() {
		return this.obtainDateType;
	}

	public void setObtainDateBegin(String obtainDateBegin) {
		this.obtainDateBegin = obtainDateBegin;
	}

	public String getObtainDateBegin() {
		return this.obtainDateBegin;
	}

	public void setObtainDateEnd(String obtainDateEnd) {
		this.obtainDateEnd = obtainDateEnd;
	}

	public String getObtainDateEnd() {
		return this.obtainDateEnd;
	}

	public void setObtainDateSpan(String obtainDateSpan) {
		this.obtainDateSpan = obtainDateSpan;
	}

	public String getObtainDateSpan() {
		return this.obtainDateSpan;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getCouponType() {
		return this.couponType;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreatorUid(String creatorUid) {
		this.creatorUid = creatorUid;
	}

	public String getCreatorUid() {
		return this.creatorUid;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdaterUid(String updaterUid) {
		this.updaterUid = updaterUid;
	}

	public String getUpdaterUid() {
		return this.updaterUid;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getUpdater() {
		return this.updater;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getDelFlag() {
		return this.delFlag;
	}

	public void setCouponTag(String couponTag) {
		this.couponTag = couponTag;
	}

	public String getCouponTag() {
		return this.couponTag;
	}

	public void setPcouponId(String pcouponId) {
		this.pcouponId = pcouponId;
	}

	public String getPcouponId() {
		return this.pcouponId;
	}

	public void setCouponIdList(List<String> couponIdList) {
		this.couponIdList = couponIdList;
	}

	public List<String> getCouponIdList() {
		return this.couponIdList;
	}

}

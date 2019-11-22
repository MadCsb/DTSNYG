package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "price1Ref")
public class Price1Ref extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"refId:信息ID/团购批次/每个订单", "priceId:销售价ID", "userId:用户ID", "orderListId:订单明细ID", "refPatchCode:团购批次(一起参团，相同团购批次)", "isBegin:发起人=1，非发起人=0", "priceStartDate:发起人保存-效期开始日期",
			"priceEndDate:发起人保存-效期结束日期", "createTime:创建时间"

	};

	// columns START
	/**
	 * 信息ID/团购批次/每个订单 db_column: F_REFID
	 */
	private String refId;
	/**
	 * 销售价ID db_column: F_PRICEID
	 */
	private String priceId;
	/**
	 * 用户ID db_column: F_USERID
	 */
	private String userId;

	/**
	 * 订单产品明细编号 db_column: F_ORDERLISTID
	 */
	private String orderListId;
	/**
	 * 团购批次(一起参团，相同团购批次) db_column: F_REF_PATCHCODE
	 */
	private String refPatchCode;
	/**
	 * 发起人=1，非发起人=0 db_column: F_ISBEGIN
	 */
	private String isBegin;
	/**
	 * 发起人保存-效期开始日期 db_column: F_PRICESTARTDATE
	 */
	private String priceStartDate;
	/**
	 * 发起人保存-效期结束日期 db_column: F_PRICEENDDATE
	 */
	private String priceEndDate;
	/**
	 * 创建时间 db_column: F_CREATETIME
	 */
	private String createTime;

	// 验证有效日期,如现在时间有效
	private String validateDate;

	private String orderCount;

	private String num;

	private String userName;

	// columns END
	private List<String> price1RefIdList;

	private String headPic;

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public String getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getRefId() {
		return this.refId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	public String getPriceId() {
		return this.priceId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setRefPatchCode(String refPatchCode) {
		this.refPatchCode = refPatchCode;
	}

	public String getRefPatchCode() {
		return this.refPatchCode;
	}

	public void setIsBegin(String isBegin) {
		this.isBegin = isBegin;
	}

	public String getIsBegin() {
		return this.isBegin;
	}

	public void setPriceStartDate(String priceStartDate) {
		this.priceStartDate = priceStartDate;
	}

	public String getPriceStartDate() {
		return this.priceStartDate;
	}

	public void setPriceEndDate(String priceEndDate) {
		this.priceEndDate = priceEndDate;
	}

	public String getPriceEndDate() {
		return this.priceEndDate;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setPrice1RefIdList(List<String> price1RefIdList) {
		this.price1RefIdList = price1RefIdList;
	}

	public List<String> getPrice1RefIdList() {
		return this.price1RefIdList;
	}

	public String getOrderListId() {
		return orderListId;
	}

	public void setOrderListId(String orderListId) {
		this.orderListId = orderListId;
	}

	public String getValidateDate() {
		return validateDate;
	}

	public void setValidateDate(String validateDate) {
		this.validateDate = validateDate;
	}
}

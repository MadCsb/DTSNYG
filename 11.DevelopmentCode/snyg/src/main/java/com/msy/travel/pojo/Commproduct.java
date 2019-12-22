package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "commproduct")
public class Commproduct extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"productId:产品编号", "spId:运营商编号", "venId:供应商编号", "venName:供应商名称", "productName:产品名称", "productInfo:产品详情", "feeMemo:费用说明", "tigInfo:温馨提示", "state:0：未上架；1：已上架", "thumbPic:缩略图文件名称",
			"reOrder:是否允许退货：0-否1-是", "subject:产品主题：多个主题ID以,分隔", "saleNum:默认顺序号（默认购买数量）", "creatorUid:创建人", "creator:创建人姓名", "createrTime:创建时间", "updateTime:修改时间", "updaterUid:修改人", "updater:修改人姓名",
			"delFlag:是否删除0-未删除1-已删除", "recommend:0-不推荐1-推荐"

	};

	// columns START
	/**
	 * 产品ID db_column: F_PRODUCTID
	 */
	private String productId;

	/**
	 * F_PRODUCTCODE 产品编号 8为随机数
	 */
	private String productCode;
	/**
	 * 运营商编号 db_column: F_SPID
	 */
	private String spId;
	/**
	 * 供应商编号 db_column: F_VENID
	 */
	private String venId;
	/**
	 * 供应商名称 db_column: F_VENNAME
	 */
	private String venName;
	/**
	 * 产品名称 db_column: F_PRODUCTNAME
	 */
	private String productName;
	/**
	 * F_TYPE 商品类别一级类别
	 */
	private String type;
	/**
	 * F_SUBTYPE 商品类别二级类别
	 */
	private String subType;
	/**
	 * 产品详情 db_column: F_PRODUCTINFO
	 */
	private String productInfo;
	/**
	 * 费用说明 db_column: F_FEEMEMO
	 */
	private String feeMemo;
	/**
	 * 温馨提示 db_column: F_TIGINFO
	 */
	private String tigInfo;
	/**
	 * 0：未上架；1：已上架 db_column: F_STATE
	 */
	private String state;
	/**
	 * 缩略图文件名称 db_column: F_THUMBPIC
	 */
	private String thumbPic;
	/**
	 * 是否允许退货：0-否1-是 db_column: F_REORDER
	 */
	private String reorder;
	/**
	 * 产品主题：多个主题ID以,分隔 db_column: F_SUBJECT
	 */
	private String subject;
	/**
	 * 默认顺序号（默认购买数量） db_column: F_SALENUM
	 */
	private String saleNum;
	/**
	 * 创建人 db_column: F_CREATORUID
	 */
	private String creatorUid;
	/**
	 * 创建人姓名 db_column: F_CREATOR
	 */
	private String creator;
	/**
	 * 创建时间 db_column: F_CREATETIME
	 */
	private String createrTime;
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
	 * 0-不推荐1-推荐 db_column: F_RECOMMEND
	 */
	private String recommend;
	// columns END
	private List<String> commproductIdList;

	private String typeName;

	private String priceIds;

	private String priceType;

	private String price;

	private String priceId;

	private String priceStartDate;

	private String priceEndDate;

	private String peopleNum;

	private String expressNum;

	private String goodsPriceId;

	private String subjectName;

	private String typeUrl;

	/**
	 * F_SORTNUM
	 */
	private String sortNum;

	private String isSortNum;

	public String getIsSortNum() {
		return isSortNum;
	}

	public void setIsSortNum(String isSortNum) {
		this.isSortNum = isSortNum;
	}

	public String getSortNum() {
		return sortNum;
	}

	public void setSortNum(String sortNum) {
		this.sortNum = sortNum;
	}

	public String getTypeUrl() {
		return typeUrl;
	}

	public void setTypeUrl(String typeUrl) {
		this.typeUrl = typeUrl;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getGoodsPriceId() {
		return goodsPriceId;
	}

	public void setGoodsPriceId(String goodsPriceId) {
		this.goodsPriceId = goodsPriceId;
	}

	public String getExpressNum() {
		return expressNum;
	}

	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}

	public String getPriceStartDate() {
		return priceStartDate;
	}

	public void setPriceStartDate(String priceStartDate) {
		this.priceStartDate = priceStartDate;
	}

	public String getPriceEndDate() {
		return priceEndDate;
	}

	public void setPriceEndDate(String priceEndDate) {
		this.priceEndDate = priceEndDate;
	}

	public String getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(String peopleNum) {
		this.peopleNum = peopleNum;
	}

	public String getPriceId() {
		return priceId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getPriceIds() {
		return priceIds;
	}

	public void setPriceIds(String priceIds) {
		this.priceIds = priceIds;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getSpId() {
		return this.spId;
	}

	public void setVenId(String venId) {
		this.venId = venId;
	}

	public String getVenId() {
		return this.venId;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenName() {
		return this.venName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public String getProductInfo() {
		return this.productInfo;
	}

	public void setFeeMemo(String feeMemo) {
		this.feeMemo = feeMemo;
	}

	public String getFeeMemo() {
		return this.feeMemo;
	}

	public void setTigInfo(String tigInfo) {
		this.tigInfo = tigInfo;
	}

	public String getTigInfo() {
		return this.tigInfo;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}

	public void setThumbPic(String thumbPic) {
		this.thumbPic = thumbPic;
	}

	public String getThumbPic() {
		return this.thumbPic;
	}

	public String getReorder() {
		return reorder;
	}

	public void setReorder(String reorder) {
		this.reorder = reorder;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSaleNum(String saleNum) {
		this.saleNum = saleNum;
	}

	public String getSaleNum() {
		return this.saleNum;
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

	public void setCreaterTime(String createrTime) {
		this.createrTime = createrTime;
	}

	public String getCreaterTime() {
		return this.createrTime;
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

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getRecommend() {
		return this.recommend;
	}

	public void setCommproductIdList(List<String> commproductIdList) {
		this.commproductIdList = commproductIdList;
	}

	public List<String> getCommproductIdList() {
		return this.commproductIdList;
	}

}

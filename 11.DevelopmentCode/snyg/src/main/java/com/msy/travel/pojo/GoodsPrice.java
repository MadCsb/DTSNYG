package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "goodsPrice")
public class GoodsPrice extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"goodsPriceId:商品规格ID", "productId:产品编号(普通商品表ID)", "priceName:规格类型名称", "storeCount:库存  -1无限库存", "thumbPic:缩略图文件名称", "createTime:创建时间"

	};

	// columns START
	/**
	 * 商品规格ID db_column: F_GOODSPRICEID
	 */
	private String goodsPriceId;
	/**
	 * 产品编号(普通商品表ID) db_column: F_CPRODUCTID
	 */
	private java.lang.String productId;
	/**
	 * 规格类型名称 db_column: F_PRICENAME
	 */
	private String priceName;
	/**
	 * 库存 无限库存 db_column: F_STORECOUNT
	 */
	private String storeCount;
	/**
	 * 缩略图文件名称 db_column: F_THUMBPIC
	 */
	private String thumbPic;
	/**
	 * 创建时间 db_column: F_CREATETIME
	 */
	private String createTime;
	// columns END
	private List<String> goodsPriceIdList;

	private String priceIds;

	private String tag;

	/**
	 * 销售单价 db_column: F_PRICE
	 */
	private String price;
	/**
	 * 活动类型 ：0常规商品；1团购价；2秒杀价 db_column: F_PRICETYPE
	 */
	private String priceType;
	/**
	 * fpricestartdate db_column: F_PRICESTARTDATE
	 */
	private String priceStartDate;
	/**
	 * fpriceenddate db_column: F_PRICEENDDATE
	 */
	private String priceEndDate;
	/**
	 * 产品最多购买数量 -1为不限 db_column: F_MAXBUYCOUNT
	 */
	private String maxBuyCount;
	/**
	 * 产品最少制购买数量 -1为不限 db_column: F_LIMITBUYCOUNT
	 */
	private String limitBuyCount;
	/**
	 * fpeoplenum db_column: F_PEOPLENUM
	 */
	private String peopleNum;

	private String delFlag;

	private String priceId;

	/**
	 * F_FREIGHT
	 */
	private String freight;

	/**
	 * F_COMPANYEXPRESSID 运费模板ID
	 */
	private String companyExpressId;

	private String feeName;

	public String getFeeName() {
		return feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public String getCompanyExpressId() {
		return companyExpressId;
	}

	public void setCompanyExpressId(String companyExpressId) {
		this.companyExpressId = companyExpressId;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getPriceId() {
		return priceId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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

	public String getMaxBuyCount() {
		return maxBuyCount;
	}

	public void setMaxBuyCount(String maxBuyCount) {
		this.maxBuyCount = maxBuyCount;
	}

	public String getLimitBuyCount() {
		return limitBuyCount;
	}

	public void setLimitBuyCount(String limitBuyCount) {
		this.limitBuyCount = limitBuyCount;
	}

	public String getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(String peopleNum) {
		this.peopleNum = peopleNum;
	}

	public String getPriceIds() {
		return priceIds;
	}

	public void setPriceIds(String priceIds) {
		this.priceIds = priceIds;
	}

	public void setGoodsPriceId(String goodsPriceId) {
		this.goodsPriceId = goodsPriceId;
	}

	public String getGoodsPriceId() {
		return this.goodsPriceId;
	}

	public java.lang.String getProductId() {
		return productId;
	}

	public void setProductId(java.lang.String productId) {
		this.productId = productId;
	}

	public void setPriceName(String priceName) {
		this.priceName = priceName;
	}

	public String getPriceName() {
		return this.priceName;
	}

	public void setStoreCount(String storeCount) {
		this.storeCount = storeCount;
	}

	public String getStoreCount() {
		return this.storeCount;
	}

	public void setThumbPic(String thumbPic) {
		this.thumbPic = thumbPic;
	}

	public String getThumbPic() {
		return this.thumbPic;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setGoodsPriceIdList(List<String> goodsPriceIdList) {
		this.goodsPriceIdList = goodsPriceIdList;
	}

	public List<String> getGoodsPriceIdList() {
		return this.goodsPriceIdList;
	}

}

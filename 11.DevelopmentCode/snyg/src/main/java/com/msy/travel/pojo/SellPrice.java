package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "sellPrice")
public class SellPrice extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"priceId:fpriceid", "goodsPriceId:商品规格ID", "productId:商品ID", "price:销售单价", "priceType:活动类型 ：0常规商品；1团购价；2秒杀价", "priceStartDate:fpricestartdate", "priceEndDate:fpriceenddate",
			"maxBuyCount:产品最多购买数量  null为不限", "limitBuyCount:产品最少制购买数量 null为不限", "peopleNum:f peoplenum"

	};

	// columns START
	/**
	 * fpriceid db_column: F_PRICEID
	 */
	private String priceId;
	/**
	 * 商品规格ID db_column: F_GOODSPRICEID
	 */
	private String goodsPriceId;
	/**
	 * 商品ID db_column: F_PRODUCTID
	 */
	private String productId;
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

	/**
	 * F_UPDATETIME
	 */
	private String updateTime;

	private String productName;

	private String priceName;

	private String subject;

	private String state;
	// columns END
	private List<String> sellPriceIdList;

	private String spId;

	private String thumbPic;

	private String type;

	private String subType;

	private String storeCount;

	private String productCode;

	private String pdcTypeId;

	private String venId;

	private String priceDate;

	private List<SellPrice> sellPriceList;

	/**
	 * F_FREIGHT
	 */
	private String freight;

	/**
	 * F_COMPANYEXPRESSID 运费模板ID
	 */
	private String companyExpressId;

	private String oldPrice;

	private int limit;

	private String saleNum;

	private String isSortNum;

	private String goodsThumbPic;

	// F_PRICECODE
	private String priceCode;

	private String checkPdc;

	private String saleTypeName;

	// 优惠券 记录已选择的
	private String sellPriceIdString;

	private String couponId;

	public String getSellPriceIdString() {
		return sellPriceIdString;
	}

	public void setSellPriceIdString(String sellPriceIdString) {
		this.sellPriceIdString = sellPriceIdString;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getSaleTypeName() {
		return saleTypeName;
	}

	public void setSaleTypeName(String saleTypeName) {
		this.saleTypeName = saleTypeName;
	}

	public String getCheckPdc() {
		return checkPdc;
	}

	public void setCheckPdc(String checkPdc) {
		this.checkPdc = checkPdc;
	}

	public String getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}

	public String getGoodsThumbPic() {
		return goodsThumbPic;
	}

	public void setGoodsThumbPic(String goodsThumbPic) {
		this.goodsThumbPic = goodsThumbPic;
	}

	public String getIsSortNum() {
		return isSortNum;
	}

	public void setIsSortNum(String isSortNum) {
		this.isSortNum = isSortNum;
	}

	public String getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(String saleNum) {
		this.saleNum = saleNum;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(String oldPrice) {
		this.oldPrice = oldPrice;
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

	public String getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(String priceDate) {
		this.priceDate = priceDate;
	}

	public List<SellPrice> getSellPriceList() {
		return sellPriceList;
	}

	public void setSellPriceList(List<SellPrice> sellPriceList) {
		this.sellPriceList = sellPriceList;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getPdcTypeId() {
		return pdcTypeId;
	}

	public void setPdcTypeId(String pdcTypeId) {
		this.pdcTypeId = pdcTypeId;
	}

	public String getVenId() {
		return venId;
	}

	public void setVenId(String venId) {
		this.venId = venId;
	}

	public String getStoreCount() {
		return storeCount;
	}

	public void setStoreCount(String storeCount) {
		this.storeCount = storeCount;
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

	public String getThumbPic() {
		return thumbPic;
	}

	public void setThumbPic(String thumbPic) {
		this.thumbPic = thumbPic;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPriceName() {
		return priceName;
	}

	public void setPriceName(String priceName) {
		this.priceName = priceName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	public String getPriceId() {
		return this.priceId;
	}

	public void setGoodsPriceId(String goodsPriceId) {
		this.goodsPriceId = goodsPriceId;
	}

	public String getGoodsPriceId() {
		return this.goodsPriceId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getPriceType() {
		return this.priceType;
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

	public void setMaxBuyCount(String maxBuyCount) {
		this.maxBuyCount = maxBuyCount;
	}

	public String getMaxBuyCount() {
		return this.maxBuyCount;
	}

	public void setLimitBuyCount(String limitBuyCount) {
		this.limitBuyCount = limitBuyCount;
	}

	public String getLimitBuyCount() {
		return this.limitBuyCount;
	}

	public void setPeopleNum(String peopleNum) {
		this.peopleNum = peopleNum;
	}

	public String getPeopleNum() {
		return this.peopleNum;
	}

	public void setSellPriceIdList(List<String> sellPriceIdList) {
		this.sellPriceIdList = sellPriceIdList;
	}

	public List<String> getSellPriceIdList() {
		return this.sellPriceIdList;
	}

}

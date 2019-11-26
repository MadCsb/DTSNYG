package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "shopcart")
public class Shopcart extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"cartId:购物车ID", "priceId:fpriceid", "num:数量", "userId:用户ID", "createTime:创建时间", "updateTime:更新时间"

	};

	// columns START
	/**
	 * 购物车ID db_column: F_CARTID
	 */
	private String cartId;
	/**
	 * fpriceid db_column: F_PRICEID
	 */
	private String priceId;
	/**
	 * 数量 db_column: F_NUM
	 */
	private String num;
	/**
	 * 用户ID db_column: F_USERID
	 */
	private String userId;
	/**
	 * 创建时间 db_column: F_CREATETIME
	 */
	private String createTime;
	/**
	 * 更新时间 db_column: F_UPDATETIME
	 */
	private String updateTime;
	// columns END
	private List<String> shopcartIdList;

	private String delFlag;

	private String productName;

	private String priceName;

	private String price;

	private String thumbPic;

	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getThumbPic() {
		return thumbPic;
	}

	public void setThumbPic(String thumbPic) {
		this.thumbPic = thumbPic;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getCartId() {
		return this.cartId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	public String getPriceId() {
		return this.priceId;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getNum() {
		return this.num;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setShopcartIdList(List<String> shopcartIdList) {
		this.shopcartIdList = shopcartIdList;
	}

	public List<String> getShopcartIdList() {
		return this.shopcartIdList;
	}

}

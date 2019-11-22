package com.msy.travel.pojo;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;
@Alias(value = "city")
public class City extends BaseEntity implements java.io.Serializable {

	// columns START
	/**
	 * 地市编号 db_column: F_CITYID
	 */
	private String cityId;
	/**
	 * NNN-NN-NNNN-NNNN 国家-省份-地市-区县，没有-分隔 db_column: F_CITYCODE
	 */
	private String cityCode;
	/**
	 * 名称 db_column: F_CITYNAME
	 */
	private String cityName;
	/**
	 * 0-国家1-省份2-地市3-区县 db_column: F_CITYLEVEL
	 */
	private String cityLevel;
	/**
	 * 0-国内1-国外 db_column: F_FOREIGH
	 */
	private String foreigh;
	/**
	 * 上级ID db_column: F_PCITYID
	 */
	private String pcityId;
	/**
	 * 所属省份 db_column: F_PROVINCE
	 */
	private String province;
	/**
	 * 所属市 db_column: F_CITY
	 */
	private String city;
	/**
	 * 所属区县 db_column: F_XIAN
	 */
	private String xian;
	/**
	 * 拼音码 db_column: F_PY
	 */
	private String py;
	/**
	 * 是否常用 db_column: F_IsAlaway
	 */
	private String isAlaway;

	/**
	 * 旅行社ID
	 */
	private String travelAgentId;

	// columns END

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityId() {
		return this.cityId;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityLevel(String cityLevel) {
		this.cityLevel = cityLevel;
	}

	public String getCityLevel() {
		return this.cityLevel;
	}

	public void setForeigh(String foreigh) {
		this.foreigh = foreigh;
	}

	public String getForeigh() {
		return this.foreigh;
	}

	public void setPcityId(String pcityId) {
		this.pcityId = pcityId;
	}

	public String getPcityId() {
		return this.pcityId;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince() {
		return this.province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}

	public void setXian(String xian) {
		this.xian = xian;
	}

	public String getXian() {
		return this.xian;
	}

	public void setPy(String py) {
		this.py = py;
	}

	public String getPy() {
		return this.py;
	}

	public String getTravelAgentId() {
		return travelAgentId;
	}

	public void setTravelAgentId(String travelAgentId) {
		this.travelAgentId = travelAgentId;
	}

	public String getIsAlaway() {
		return isAlaway;
	}

	public void setIsAlaway(String isAlaway) {
		this.isAlaway = isAlaway;
	}

}

package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "destsp")
public class Destsp extends BaseEntity implements java.io.Serializable {

	public static String currentSpId = "da14b98e-cb26-4169-9b58-babe98b98047";

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"spId:fspid", "wxServiceId:fwxserviceid", "spType:关联pubmap  运营商类型", "spName:fspname", "linkName:flinkname", "telephone:ftelphone", "fax:ffax", "wwwsite:fwwwsite", "address:faddress",
			"memo:fmemo", "delTag:fdeltag", "orderprefix:forderprefix", "carprefix:fcarprefix", "destPlace:fdestplace", "lng:flng", "lat:flat", "isHot:fishot", "isApp:fisapp", "isB2b:fisb2b",
			"accountPeriod:天数", "rate:天利率", "znRate:fznrate", "freePeriod:免息天数", "hot:fhot", "isB2c:fisb2c", "ticketSubject:fticketsubject", "lineSubject:flinesubject", "hotelSubject:fhotelsubject",
			"goodsSubject:fgoodssubject", "thumbpic:fthumbpic"

	};

	// columns START
	/**
	 * fspid db_column: F_SPID
	 */
	private String spId;
	/**
	 * fwxserviceid db_column: F_WXSERVICEID
	 */
	private String wxServiceId;
	/**
	 * 关联pubmap 运营商类型 db_column: F_SPTYPE
	 */
	private String spType;
	/**
	 * fspname db_column: F_SPNAME
	 */
	private String spName;
	/**
	 * flinkname db_column: F_LINKNAME
	 */
	private String linkName;
	/**
	 * ftelphone db_column: F_TELPHONE
	 */
	private String telephone;
	/**
	 * ffax db_column: F_FAX
	 */
	private String fax;
	/**
	 * fwwwsite db_column: F_WWWSITE
	 */
	private String wwwsite;
	/**
	 * faddress db_column: F_ADDRESS
	 */
	private String address;
	/**
	 * fmemo db_column: F_MEMO
	 */
	private String memo;
	/**
	 * fdeltag db_column: F_DELTAG
	 */
	private String delTag;
	/**
	 * forderprefix db_column: F_ORDERPREFIX
	 */
	private String orderprefix;
	/**
	 * fcarprefix db_column: F_CARPREFIX
	 */
	private String carprefix;
	/**
	 * fdestplace db_column: F_DESTPLACE
	 */
	private String destPlace;
	/**
	 * flng db_column: F_LNG
	 */
	private String lng;
	/**
	 * flat db_column: F_LAT
	 */
	private String lat;
	/**
	 * fishot db_column: F_ISHOT
	 */
	private String isHot;
	/**
	 * fisapp db_column: F_ISAPP
	 */
	private String isApp;
	/**
	 * fisb2b db_column: F_ISB2B
	 */
	private String isB2b;
	/**
	 * 天数 db_column: F_ACCOUNTPERIOD
	 */
	private String accountPeriod;
	/**
	 * 天利率 db_column: F_RATE
	 */
	private String rate;
	/**
	 * fznrate db_column: F_ZNRATE
	 */
	private String znRate;
	/**
	 * 免息天数 db_column: F_FREEPERIOD
	 */
	private String freePeriod;
	/**
	 * fhot db_column: F_HOT
	 */
	private String hot;
	/**
	 * fisb2c db_column: F_ISB2C
	 */
	private String isB2c;
	/**
	 * fticketsubject db_column: F_TICKETSUBJECT
	 */
	private String ticketSubject;
	/**
	 * flinesubject db_column: F_LINESUBJECT
	 */
	private String lineSubject;
	/**
	 * fhotelsubject db_column: F_HOTELSUBJECT
	 */
	private String hotelSubject;
	/**
	 * fgoodssubject db_column: F_GOODSSUBJECT
	 */
	private String goodsSubject;
	/**
	 * fthumbpic db_column: F_THUMBPIC
	 */
	private String thumbpic;
	// columns END
	private List<String> destspIdList;

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getSpId() {
		return this.spId;
	}

	public void setWxServiceId(String wxServiceId) {
		this.wxServiceId = wxServiceId;
	}

	public String getWxServiceId() {
		return this.wxServiceId;
	}

	public void setSpType(String spType) {
		this.spType = spType;
	}

	public String getSpType() {
		return this.spType;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getSpName() {
		return this.spName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkName() {
		return this.linkName;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFax() {
		return this.fax;
	}

	public void setWwwsite(String wwwsite) {
		this.wwwsite = wwwsite;
	}

	public String getWwwsite() {
		return this.wwwsite;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setDelTag(String delTag) {
		this.delTag = delTag;
	}

	public String getDelTag() {
		return this.delTag;
	}

	public void setOrderprefix(String orderprefix) {
		this.orderprefix = orderprefix;
	}

	public String getOrderprefix() {
		return this.orderprefix;
	}

	public void setCarprefix(String carprefix) {
		this.carprefix = carprefix;
	}

	public String getCarprefix() {
		return this.carprefix;
	}

	public void setDestPlace(String destPlace) {
		this.destPlace = destPlace;
	}

	public String getDestPlace() {
		return this.destPlace;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLng() {
		return this.lng;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLat() {
		return this.lat;
	}

	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}

	public String getIsHot() {
		return this.isHot;
	}

	public void setIsApp(String isApp) {
		this.isApp = isApp;
	}

	public String getIsApp() {
		return this.isApp;
	}

	public void setIsB2b(String isB2b) {
		this.isB2b = isB2b;
	}

	public String getIsB2b() {
		return this.isB2b;
	}

	public void setAccountPeriod(String accountPeriod) {
		this.accountPeriod = accountPeriod;
	}

	public String getAccountPeriod() {
		return this.accountPeriod;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getRate() {
		return this.rate;
	}

	public void setZnRate(String znRate) {
		this.znRate = znRate;
	}

	public String getZnRate() {
		return this.znRate;
	}

	public void setFreePeriod(String freePeriod) {
		this.freePeriod = freePeriod;
	}

	public String getFreePeriod() {
		return this.freePeriod;
	}

	public void setHot(String hot) {
		this.hot = hot;
	}

	public String getHot() {
		return this.hot;
	}

	public void setIsB2c(String isB2c) {
		this.isB2c = isB2c;
	}

	public String getIsB2c() {
		return this.isB2c;
	}

	public void setTicketSubject(String ticketSubject) {
		this.ticketSubject = ticketSubject;
	}

	public String getTicketSubject() {
		return this.ticketSubject;
	}

	public void setLineSubject(String lineSubject) {
		this.lineSubject = lineSubject;
	}

	public String getLineSubject() {
		return this.lineSubject;
	}

	public void setHotelSubject(String hotelSubject) {
		this.hotelSubject = hotelSubject;
	}

	public String getHotelSubject() {
		return this.hotelSubject;
	}

	public void setGoodsSubject(String goodsSubject) {
		this.goodsSubject = goodsSubject;
	}

	public String getGoodsSubject() {
		return this.goodsSubject;
	}

	public void setThumbpic(String thumbpic) {
		this.thumbpic = thumbpic;
	}

	public String getThumbpic() {
		return this.thumbpic;
	}

	public void setDestspIdList(List<String> destspIdList) {
		this.destspIdList = destspIdList;
	}

	public List<String> getDestspIdList() {
		return this.destspIdList;
	}

}

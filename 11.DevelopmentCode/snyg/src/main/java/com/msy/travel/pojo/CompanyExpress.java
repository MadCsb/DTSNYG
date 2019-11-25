package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "companyExpress")
public class CompanyExpress extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"companyExpressId:运费模板Id", "companyId:商家ID", "feeName:运费模板名称"

	};

	// columns START
	/**
	 * 运费模板Id db_column: F_COMPANYEXPRESSID
	 */
	private String companyExpressId;
	/**
	 * 商家ID db_column: F_COMPANYID
	 */
	private String companyId;
	/**
	 * 运费模板名称 db_column: F_FENNAME
	 */
	private String feeName;
	// columns END
	/**
	 * F_EPMECOMPANY 快递公司
	 */
	private String epmeCompany;

	/**
	 * F_UPDATETIME
	 */
	private String updateTime;

	/**
	 * F_SPID
	 */
	private String spId;

	private List<String> companyExpressIdList;

	private String venName;

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getEpmeCompany() {
		return epmeCompany;
	}

	public void setEpmeCompany(String epmeCompany) {
		this.epmeCompany = epmeCompany;
	}

	public void setCompanyExpressId(String companyExpressId) {
		this.companyExpressId = companyExpressId;
	}

	public String getCompanyExpressId() {
		return this.companyExpressId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public String getFeeName() {
		return this.feeName;
	}

	public void setCompanyExpressIdList(List<String> companyExpressIdList) {
		this.companyExpressIdList = companyExpressIdList;
	}

	public List<String> getCompanyExpressIdList() {
		return this.companyExpressIdList;
	}

}

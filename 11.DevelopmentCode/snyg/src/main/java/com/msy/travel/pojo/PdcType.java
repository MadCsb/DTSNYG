package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "pdcType")
public class PdcType extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"pdcTypeId:产品类型ID", "typeName:类别名称", "ppdcTypeId:上级编号", "delFlag:删除标志", "picUrl:fpicurl", "level:1：一级类别；2：二级类别；3：三级类别"

	};

	// columns START
	/**
	 * 产品类型ID db_column: F_PDCTYPEID
	 */
	private String pdcTypeId;
	/**
	 * 类别名称 db_column: F_TYPENAME
	 */
	private String typeName;
	/**
	 * 上级编号 db_column: F_PPDCTYPEID
	 */
	private String ppdcTypeId;
	/**
	 * 删除标志 db_column: F_DELFLAG
	 */
	private String delFlag;
	/**
	 * fpicurl db_column: F_PICURL
	 */
	private String picUrl;
	/**
	 * 1：一级类别；2：二级类别；3：三级类别 db_column: F_LEVEL
	 */
	private String level;
	// columns END
	private List<String> pdcTypeIdList;

	private String ppdcTypeName;

	/**
	 * F_SPID
	 */
	private String spId;

	/**
	 * F_SORT
	 */
	private String sort;

	private List<PdcType> pdcTypeList;

	public List<PdcType> getPdcTypeList() {
		return pdcTypeList;
	}

	public void setPdcTypeList(List<PdcType> pdcTypeList) {
		this.pdcTypeList = pdcTypeList;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getPpdcTypeName() {
		return ppdcTypeName;
	}

	public void setPpdcTypeName(String ppdcTypeName) {
		this.ppdcTypeName = ppdcTypeName;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public void setPdcTypeId(String pdcTypeId) {
		this.pdcTypeId = pdcTypeId;
	}

	public String getPdcTypeId() {
		return this.pdcTypeId;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setPpdcTypeId(String ppdcTypeId) {
		this.ppdcTypeId = ppdcTypeId;
	}

	public String getPpdcTypeId() {
		return this.ppdcTypeId;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getDelFlag() {
		return this.delFlag;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return this.level;
	}

	public void setPdcTypeIdList(List<String> pdcTypeIdList) {
		this.pdcTypeIdList = pdcTypeIdList;
	}

	public List<String> getPdcTypeIdList() {
		return this.pdcTypeIdList;
	}

}

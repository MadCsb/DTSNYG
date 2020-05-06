package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "pubmap")
public class Pubmap extends BaseEntity implements java.io.Serializable {

	// columns START
	/**
	 * 字典编号 db_column: F_MAPID
	 */
	private String mapId;
	/**
	 * 字典类别 db_column: F_MAPTYPE
	 */
	private String mapType;
	/**
	 * 字典键 db_column: F_MAPKEY
	 */
	private String mapKey;
	/**
	 * 字典值 db_column: F_MAPVALUE
	 */
	private String mapValue;
	/**
	 * 字典描述 db_column: F_MAPDESC
	 */
	private String mapDesc;
	/**
	 * 0-否1-是 db_column: F_SYS
	 */
	private String sys;

	/**
	 * 字典选项条件
	 */
	private String mapFilter;
	// columns END

	private List<String> pubMapIdList;

	public List<String> getPubMapIdList() {
		return pubMapIdList;
	}

	public void setPubMapIdList(List<String> pubMapIdList) {
		this.pubMapIdList = pubMapIdList;
	}

	public void setMapId(String mapId) {
		this.mapId = mapId;
	}

	public String getMapId() {
		return this.mapId;
	}

	public void setMapType(String mapType) {
		this.mapType = mapType;
	}

	public String getMapType() {
		return this.mapType;
	}

	public void setMapKey(String mapKey) {
		this.mapKey = mapKey;
	}

	public String getMapKey() {
		return this.mapKey;
	}

	public void setMapValue(String mapValue) {
		this.mapValue = mapValue;
	}

	public String getMapValue() {
		return this.mapValue;
	}

	public void setMapDesc(String mapDesc) {
		this.mapDesc = mapDesc;
	}

	public String getMapDesc() {
		return this.mapDesc;
	}

	public void setSys(String sys) {
		this.sys = sys;
	}

	public String getSys() {
		return this.sys;
	}

	public String getMapFilter() {
		return mapFilter;
	}

	public void setMapFilter(String mapFilter) {
		this.mapFilter = mapFilter;
	}

}

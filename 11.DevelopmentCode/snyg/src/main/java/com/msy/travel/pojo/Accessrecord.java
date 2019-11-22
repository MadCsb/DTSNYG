package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "accessrecord")
public class Accessrecord extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"recordId:访问记录ID", "spId:运营商编号", "customCode:客户编号", "accessTime:访问时间", "pdcId:产品ID", "type:访问类型：1微信端"

	};

	// columns START
	/**
	 * 访问记录ID db_column: F_RECORDID
	 */
	private String recordId;
	/**
	 * 运营商编号 db_column: F_SPID
	 */
	private String spId;
	/**
	 * 客户编号 db_column: F_USERID
	 */
	private String userId;
	/**
	 * 访问时间 db_column: F_ACCESSTIME
	 */
	private String accessTime;
	/**
	 * 产品ID db_column: F_PDCID
	 */
	private String pdcId;
	/**
	 * 访问类型：1微信端 db_column: F_TYPE
	 */
	private String type;
	// columns END
	private List<String> accessrecordIdList;

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getRecordId() {
		return this.recordId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getSpId() {
		return this.spId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}

	public String getAccessTime() {
		return this.accessTime;
	}

	public void setPdcId(String pdcId) {
		this.pdcId = pdcId;
	}

	public String getPdcId() {
		return this.pdcId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setAccessrecordIdList(List<String> accessrecordIdList) {
		this.accessrecordIdList = accessrecordIdList;
	}

	public List<String> getAccessrecordIdList() {
		return this.accessrecordIdList;
	}

}

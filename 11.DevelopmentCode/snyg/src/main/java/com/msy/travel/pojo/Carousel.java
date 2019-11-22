package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "carousel")
public class Carousel extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"carouselId:轮播图ID", "spId:运营商编号", "carouselName:名称", "carouselDesc:fdesc", "createTime:创建时间", "creatourUid:创建人", "creator:创建人姓名", "updateTime:修改时间", "updaterUid:修改人", "updater:修改人姓名",
			"delFlag:是否删除0-未删除1-已删除"

	};

	// columns START
	/**
	 * 轮播图ID db_column: F_CAROUSELID
	 */
	private String carouselId;
	/**
	 * 运营商编号 db_column: F_SPID
	 */
	private String spId;
	/**
	 * 名称 db_column: F_NAME
	 */
	private String carouselName;
	/**
	 * fdesc db_column: F_DESC
	 */
	private String carouselDesc;
	/**
	 * 创建时间 db_column: F_CREATETIME
	 */
	private String createTime;
	/**
	 * 创建人 db_column: F_CREATORUID
	 */
	private String creatourUid;
	/**
	 * 创建人姓名 db_column: F_CREATOR
	 */
	private String creator;
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
	// columns END
	private List<String> carouselIdList;

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCarouselId(String carouselId) {
		this.carouselId = carouselId;
	}

	public String getCarouselId() {
		return this.carouselId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getSpId() {
		return this.spId;
	}

	public void setCarouselName(String carouselName) {
		this.carouselName = carouselName;
	}

	public String getCarouselName() {
		return this.carouselName;
	}

	public String getCarouselDesc() {
		return carouselDesc;
	}

	public void setCarouselDesc(String carouselDesc) {
		this.carouselDesc = carouselDesc;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreatourUid(String creatourUid) {
		this.creatourUid = creatourUid;
	}

	public String getCreatourUid() {
		return this.creatourUid;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreator() {
		return this.creator;
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

	public void setCarouselIdList(List<String> carouselIdList) {
		this.carouselIdList = carouselIdList;
	}

	public List<String> getCarouselIdList() {
		return this.carouselIdList;
	}

}

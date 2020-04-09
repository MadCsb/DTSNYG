package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "roleData")
public class RoleData extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"userRoleDataId:用户角色Id", "roleType:用户角色类型 1:管理员 2:运营商 3:渠道 ", "accId:目前保存SPID", "userChannelId:用户渠道ID", "userId:用户ID", "isDefault:是否默认角色 0否1是"

	};

	public static String ADMIN = "1";

	public static String YYS = "2";

	public static String CHANNEL = "3";

	// columns START
	/**
	 * 用户角色Id db_column: F_USEROLEDATAID
	 */
	private String userRoleDataId;
	/**
	 * 用户角色类型 1:管理员 2:运营商 3:渠道 db_column: F_ROLETYPE
	 */
	private String roleType;
	/**
	 * 目前保存SPID db_column: F_ACCID
	 */
	private String accId;
	/**
	 * 用户渠道ID db_column: F_USERCHANNELID
	 */
	private String userChannelId;
	/**
	 * 用户ID db_column: F_USERID
	 */
	private String userId;
	/**
	 * 是否默认角色 0否1是 db_column: F_ISDEFAULT
	 */
	private String isDefault;
	// columns END
	private List<String> roleDataIdList;

	public void setUserRoleDataId(String userRoleDataId) {
		this.userRoleDataId = userRoleDataId;
	}

	public String getUserRoleDataId() {
		return this.userRoleDataId;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getRoleType() {
		return this.roleType;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getAccId() {
		return this.accId;
	}

	public void setUserChannelId(String userChannelId) {
		this.userChannelId = userChannelId;
	}

	public String getUserChannelId() {
		return this.userChannelId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getIsDefault() {
		return this.isDefault;
	}

	public void setRoleDataIdList(List<String> roleDataIdList) {
		this.roleDataIdList = roleDataIdList;
	}

	public List<String> getRoleDataIdList() {
		return this.roleDataIdList;
	}

}

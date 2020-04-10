package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "roleData")
public class RoleData extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = -6849794470754667710L;
	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"userRoleDataId:用户角色Id", "roleType:用户角色类型 1:管理员 2:运营商 3:渠道 ", "accId:目前保存SPID", "unitId:用户UNITID", "userId:用户ID", "isDefault:是否默认角色 0否1是"

	};

	/**
	 * 用户角色类型-管理员：1
	 */
	public static final String ROLE_TYPE_ADMIN = "1";

	/**
	 * 用户角色类型-运营商：2
	 */
	public static final String ROLE_TYPE_YYS = "2";

	/**
	 * 用户角色类型-渠道：3
	 */
	public static final String ROLE_TYPE_CHANNEL = "3";

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
	 * 用户渠道ID db_column: F_UNITID
	 */
	private String unitId;
	/**
	 * 用户ID db_column: F_USERID
	 */
	private String userId;
	/**
	 * 是否默认角色 0否1是 db_column: F_ISDEFAULT
	 */
	private String isDefault;

	/**
	 * 用户登录名
	 */
	private String userLoginName;
	/**
	 * 用户类型
	 */
	private String userType;
	/**
	 * 用户状态：1：有效；0：无效，不允许登录；-1：已删除
	 */
	private String userState;
	/**
	 * 用户是否被锁定0-没有1-锁定
	 */
	private String userLocked;
	/**
	 * 用户密码
	 */
	private String userPwd;
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

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
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

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserLocked() {
		return userLocked;
	}

	public void setUserLocked(String userLocked) {
		this.userLocked = userLocked;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
}

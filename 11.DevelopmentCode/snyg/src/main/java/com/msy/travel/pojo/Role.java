package com.msy.travel.pojo;

import com.msy.travel.common.BaseEntity;
import org.apache.ibatis.type.Alias;

@Alias(value = "role")
public class Role extends BaseEntity implements java.io.Serializable
{

	//columns START
    /**
     * 角色ID       db_column: F_ROLEID 
     */	
	private String roleId;
    /**
     * 角色名称       db_column: F_ROLENAME 
     */	
	private String roleName;
    /**
     * 是否需要权限控制       db_column: F_IFPRIV 
     */	
	private String ifPriv;
    /**
     * 允许多个单位       db_column: F_ISMULTI 
     */	
	private String isMulti;
    /**
     * 角色描述       db_column: F_ROLEDESC 
     */	
	private String roleDesc;

	//columns END
	private String accId;
	
	private String userRoleType;
	
	private String unitName;
	
	private String unitId;
	public void setRoleId(String roleId) {
		this.roleId =roleId;
	}
	
	public String getRoleId() {
		return this.roleId;
	}
	public void setRoleName(String roleName) {
		this.roleName =roleName;
	}
	
	public String getRoleName() {
		return this.roleName;
	}
	public void setIfPriv(String ifPriv) {
		this.ifPriv =ifPriv;
	}
	
	public String getIfPriv() {
		return this.ifPriv;
	}
	public void setIsMulti(String isMulti) {
		this.isMulti =isMulti;
	}
	
	public String getIsMulti() {
		return this.isMulti;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc =roleDesc;
	}
	
	public String getRoleDesc() {
		return this.roleDesc;
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUserRoleType() {
		return userRoleType;
	}

	public void setUserRoleType(String userRoleType) {
		this.userRoleType = userRoleType;
	}

	
}


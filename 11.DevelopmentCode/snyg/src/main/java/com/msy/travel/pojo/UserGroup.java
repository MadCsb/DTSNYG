package com.msy.travel.pojo;

import com.msy.travel.common.BaseEntity;
import org.apache.ibatis.type.Alias;

@Alias(value = "usergroup")
public class UserGroup extends BaseEntity implements java.io.Serializable
{

	//columns START
    /**
     * 用户组ID       db_column: F_USERGROUP_ID 
     */	
	private String userGroupId;
    /**
     * 用户组名称       db_column: F_USERGROUP_NAME 
     */	
	private String userGroupName;

	private String allUserGroupName;
    /**
     * 用户组状态：1：有效；0：禁用  -1:删除       db_column: F_USERGROUP_STATE 
     */	
	private String userGroupState;
    /**
     * 该用户组创建日期       db_column: F_USERGROUP_CREATE_DATE 
     */	
	private String userGroupCreateDate;

	private String memo;

	private String roleName;

	private String roleDesc;

	private String useNum;
	
	private String spId;
	
	private String roleType;
	//columns END
	private String userId;

	//F_CREATEROLETYPE
	private String createRoleType;
	//F_CREATEUNITID
	private String createUnitId;
	/**
	 * 是否已经绑定该用户组
	 */
	private String idUsed;
	public void setUserGroupId(String userGroupId) {
		this.userGroupId =userGroupId;
	}
	
	public String getUserGroupId() {
		return this.userGroupId;
	}
	public void setUserGroupName(String userGroupName) {
		this.userGroupName =userGroupName;
	}
	
	public String getUserGroupName() {
		return this.userGroupName;
	}
	public void setUserGroupState(String userGroupState) {
		this.userGroupState =userGroupState;
	}
	
	public String getUserGroupState() {
		return this.userGroupState;
	}
	public void setUserGroupCreateDate(String userGroupCreateDate) {
		this.userGroupCreateDate =userGroupCreateDate;
	}
	
	public String getUserGroupCreateDate() {
		return this.userGroupCreateDate;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getUseNum() {
		return useNum;
	}

	public void setUseNum(String useNum) {
		this.useNum = useNum;
	}

	public String getAllUserGroupName() {
		return allUserGroupName;
	}

	public void setAllUserGroupName(String allUserGroupName) {
		this.allUserGroupName = allUserGroupName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIdUsed() {
		return idUsed;
	}

	public void setIdUsed(String idUsed) {
		this.idUsed = idUsed;
	}

	public String getCreateRoleType() {
	    return createRoleType;
    }

	public void setCreateRoleType(String createRoleType) {
		this.createRoleType = createRoleType;
	}

	public String getCreateUnitId() {
		return createUnitId;
	}

	public void setCreateUnitId(String createUnitId) {
		this.createUnitId = createUnitId;
	}
}


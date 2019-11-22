package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "userGroupLink")
public class UserGroupLink extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"userId:用户编号", "userGroupId:用户组编号"

	};

	// columns START
	/**
	 * 用户编号 db_column: F_USER_ID
	 */
	private String userId;
	/**
	 * 用户组编号 db_column: F_USERGROUP_ID
	 */
	private String userGroupId;
	// columns END
	private List<String> userGroupLinkIdList;

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getUserGroupId() {
		return this.userGroupId;
	}

	public void setUserGroupLinkIdList(List<String> userGroupLinkIdList) {
		this.userGroupLinkIdList = userGroupLinkIdList;
	}

	public List<String> getUserGroupLinkIdList() {
		return this.userGroupLinkIdList;
	}

}

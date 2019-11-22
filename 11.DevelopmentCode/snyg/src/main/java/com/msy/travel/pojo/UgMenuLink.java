
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "ugMenuLink")
public class UgMenuLink extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "userGroupId:用户组ID"
          ,
          "menuId:菜单ID"
          
        };
	
	//columns START
    /**
     * 用户组ID       db_column: F_USERGROUP_ID 
     */	
	private String userGroupId;
    /**
     * 菜单ID       db_column: F_MENU_ID 
     */	
	private String menuId;
	//columns END
	private List<String> ugMenuLinkIdList;
	public void setUserGroupId(String userGroupId) {
		this.userGroupId =userGroupId;
	}
	
	public String getUserGroupId() {
		return this.userGroupId;
	}
	public void setMenuId(String menuId) {
		this.menuId =menuId;
	}
	
	public String getMenuId() {
		return this.menuId;
	}
	public void setUgMenuLinkIdList(List<String> ugMenuLinkIdList) {
		this.ugMenuLinkIdList = ugMenuLinkIdList;
	}
	
	public List<String> getUgMenuLinkIdList() {
		return this.ugMenuLinkIdList;
	}

}



package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "ugMenuButtonLlink")
public class UgMenuButtonLlink extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "userGroupId:用户组ID"
          ,
          "menuButtonId:菜单按钮ID"
          
        };
	
	//columns START
    /**
     * 用户组ID       db_column: F_USERGROUP_ID 
     */	
	private String userGroupId;
    /**
     * 菜单按钮ID       db_column: F_MENUBUTTON_ID 
     */	
	private String menuButtonId;
	//columns END
	private List<String> ugMenuButtonLlinkIdList;
	public void setUserGroupId(String userGroupId) {
		this.userGroupId =userGroupId;
	}
	
	public String getUserGroupId() {
		return this.userGroupId;
	}
	public void setMenuButtonId(String menuButtonId) {
		this.menuButtonId =menuButtonId;
	}
	
	public String getMenuButtonId() {
		return this.menuButtonId;
	}
	public void setUgMenuButtonLlinkIdList(List<String> ugMenuButtonLlinkIdList) {
		this.ugMenuButtonLlinkIdList = ugMenuButtonLlinkIdList;
	}
	
	public List<String> getUgMenuButtonLlinkIdList() {
		return this.ugMenuButtonLlinkIdList;
	}

}


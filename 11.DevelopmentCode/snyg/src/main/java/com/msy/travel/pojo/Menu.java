package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "menu")
public class Menu extends BaseEntity implements java.io.Serializable {

	// columns START
	/**
	 * 菜单编号 db_column: F_MENU_ID
	 */
	private String menuId;
	/**
	 * 菜单名称 db_column: F_MENU_NAME
	 */
	private String menuName;
	/**
	 * 菜单级别 最小为0级 db_column: F_MENU_LEVEL
	 */
	private String menuLevel;
	/**
	 * 上级菜单编号 db_column: F_PMENU_ID
	 */
	private String pMenuId;
	/**
	 * 菜单链接URL db_column: F_MENU_URL
	 */
	private String menuUrl;
	/**
	 * 该菜单对应的权限，即：具有哪个权限的时候才显示该菜单，0表示不受控制所有用户均可以看到该菜单 db_column: F_PRIV_ID
	 */
	private String privId;
	/**
	 * 同一级别下的顺序号 db_column: F_MENU_ORDER
	 */
	private String menuOrder;
	/**
	 * 菜单描述 db_column: F_MENU_DESC
	 */
	private String menuDesc;
	/**
	 * 不同系统公用菜单时用于区分 db_column: F_SYSTAG
	 */
	private String sysTag;
	/**
	 * fmenuIsAdmin db_column: F_MENU_IS_ADMIN
	 */
	private String menuIsAdmin;

	private String checked;

	/**
	 *
	 */
	private String pMenuName;

	private List<MenuButton> menuButtonList;

	private String usergroupId;
	// columns END

	private String roleType; // 用户角色

	private String userId; // 用户ID

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getMenuLevel() {
		return this.menuLevel;
	}

	public void setPMenuId(String pMenuId) {
		this.pMenuId = pMenuId;
	}

	public String getPMenuId() {
		return this.pMenuId;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setPrivId(String privId) {
		this.privId = privId;
	}

	public String getPrivId() {
		return this.privId;
	}

	public void setMenuOrder(String menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getMenuOrder() {
		return this.menuOrder;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public String getMenuDesc() {
		return this.menuDesc;
	}

	public void setSysTag(String sysTag) {
		this.sysTag = sysTag;
	}

	public String getSysTag() {
		return this.sysTag;
	}

	public void setMenuIsAdmin(String menuIsAdmin) {
		this.menuIsAdmin = menuIsAdmin;
	}

	public String getMenuIsAdmin() {
		return this.menuIsAdmin;
	}

	public String getpMenuId() {
		return pMenuId;
	}

	public void setpMenuId(String pMenuId) {
		this.pMenuId = pMenuId;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getpMenuName() {
		return pMenuName;
	}

	public void setpMenuName(String pMenuName) {
		this.pMenuName = pMenuName;
	}

	public List<MenuButton> getMenuButtonList() {
		return menuButtonList;
	}

	public void setMenuButtonList(List<MenuButton> menuButtonList) {
		this.menuButtonList = menuButtonList;
	}

	public String getUsergroupId() {
		return usergroupId;
	}

	public void setUsergroupId(String usergroupId) {
		this.usergroupId = usergroupId;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

}

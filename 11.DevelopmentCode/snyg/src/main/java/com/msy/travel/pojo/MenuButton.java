package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "menuButton")
public class MenuButton extends BaseEntity implements java.io.Serializable {

	// columns START
	/**
	 * fmenubuttonId db_column: F_MENUBUTTON_ID
	 */
	private String menuButtonId;
	/**
	 * 菜单编号 db_column: F_MENU_ID
	 */
	private String menuId;
	/**
	 * 该菜单对应的权限，即：具有哪个权限的时候才显示该菜单，0表示不受控制所有用户均可以看到该菜单 db_column: F_PRIV_ID
	 */
	private String privId;
	/**
	 * fmenubuttonName db_column: F_MENUBUTTON_NAME
	 */
	private String menuButtonName;
	/**
	 * fmenubuttonDesc db_column: F_MENUBUTTON_DESC
	 */
	private String menuButtonDesc;
	/**
	 * fmenubuttonTag db_column: F_MENUBUTTON_TAG
	 */
	private String menuButtonTag;
	// columns END

	private String hashChecked;

	private String checked;

	private String usergroupId;

	private String menuIsAdmin;

	private String menuName;

	private String name;

	private String msg;

	private List<String> menuButtonIdList;

	public List<String> getMenuButtonIdList() {
		return menuButtonIdList;
	}

	public void setMenuButtonIdList(List<String> menuButtonIdList) {
		this.menuButtonIdList = menuButtonIdList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuIsAdmin() {
		return menuIsAdmin;
	}

	public void setMenuIsAdmin(String menuIsAdmin) {
		this.menuIsAdmin = menuIsAdmin;
	}

	public void setMenuButtonId(String menuButtonId) {
		this.menuButtonId = menuButtonId;
	}

	public String getMenuButtonId() {
		return this.menuButtonId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuId() {
		return this.menuId;
	}

	public void setPrivId(String privId) {
		this.privId = privId;
	}

	public String getPrivId() {
		return this.privId;
	}

	public void setMenuButtonName(String menuButtonName) {
		this.menuButtonName = menuButtonName;
	}

	public String getMenuButtonName() {
		return this.menuButtonName;
	}

	public void setMenuButtonDesc(String menuButtonDesc) {
		this.menuButtonDesc = menuButtonDesc;
	}

	public String getMenuButtonDesc() {
		return this.menuButtonDesc;
	}

	public void setMenuButtonTag(String menuButtonTag) {
		this.menuButtonTag = menuButtonTag;
	}

	public String getMenuButtonTag() {
		return this.menuButtonTag;
	}

	public String getHashChecked() {
		return hashChecked;
	}

	public void setHashChecked(String hashChecked) {
		this.hashChecked = hashChecked;
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

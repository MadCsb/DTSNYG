package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "wxMenu")
public class WxMenu extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"menuId:菜单编号", "wxServiceId:fwxserviceid", "feedBackId:ffeedbackid", "menuName:菜单名称", "menuLevel:菜单级别 最小为0级", "pmenuId:上级菜单编号", "menuUrl:菜单链接URL", "menuOrder:同一级别下的顺序号", "menuDesc:菜单描述",
			"fxml:fxml"

	};

	// columns START
	/**
	 * 菜单编号 db_column: F_MENU_ID
	 */
	private String menuId;
	/**
	 * fwxserviceid db_column: F_WXSERVICEID
	 */
	private String wxServiceId;
	/**
	 * ffeedbackid db_column: F_FEEDBACKID
	 */
	private String feedBackId;
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
	private String pmenuId;
	/**
	 * 菜单链接URL db_column: F_MENU_URL
	 */
	private String menuUrl;
	/**
	 * 同一级别下的顺序号 db_column: F_MENU_ORDER
	 */
	private String menuOrder;
	/**
	 * 菜单描述 db_column: F_MENU_DESC
	 */
	private String menuDesc;
	/**
	 * fxml db_column: F_XML
	 */
	private String fxml;

	// 来自T_WX_FEEDBACK 表 F_MSGTYPE
	private String msgType;

	// 来自T_WX_FEEDBACK 表 F_LINKUEL
	private String linkUrl;
	// columns END
	private List<String> wxMenuIdList;

	private String menuType;

	private String feedbackType;

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuId() {
		return this.menuId;
	}

	public void setWxServiceId(String wxServiceId) {
		this.wxServiceId = wxServiceId;
	}

	public String getWxServiceId() {
		return this.wxServiceId;
	}

	public void setFeedBackId(String feedBackId) {
		this.feedBackId = feedBackId;
	}

	public String getFeedBackId() {
		return this.feedBackId;
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

	public void setPmenuId(String pmenuId) {
		this.pmenuId = pmenuId;
	}

	public String getPmenuId() {
		return this.pmenuId;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuUrl() {
		return this.menuUrl;
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

	public void setFxml(String fxml) {
		this.fxml = fxml;
	}

	public String getFxml() {
		return this.fxml;
	}

	public void setWxMenuIdList(List<String> wxMenuIdList) {
		this.wxMenuIdList = wxMenuIdList;
	}

	public List<String> getWxMenuIdList() {
		return this.wxMenuIdList;
	}

}

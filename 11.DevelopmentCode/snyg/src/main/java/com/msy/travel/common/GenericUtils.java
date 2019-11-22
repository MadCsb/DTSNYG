package com.msy.travel.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.msy.travel.pojo.Menu;

@SuppressWarnings("unchecked")
public class GenericUtils {
	private static final Log log = LogFactory.getLog(GenericUtils.class);

	/**
	 * 获取菜单的下一个编号
	 * 
	 * @param parentId
	 *            父类编号
	 * @param totalCount
	 *            以此父类编号为条件的总行数
	 * @return
	 */
	public static void getNextMenuId(Menu menu, int totalCount) {
		String menuId = "";

		StringBuffer strbuf = new StringBuffer();

		String parentId = menu.getPMenuId();

		int ruleBefore = ResourceCommon.RULE_MENU.indexOf("-");

		int ruleEnd = ResourceCommon.RULE_MENU.lastIndexOf("-");

		// 第一次添加菜单时
		if (null == parentId || "".equals(parentId)) {
			for (int i = 1; i <= ruleBefore; i++) {
				if (i == ruleBefore) {
					// menuId += "1";
					strbuf.append("1");

					break;
				}

				strbuf.append("1");
				// menuId += "0";
			}

			menuId = strbuf.toString();
		} else {
			// 如果是添加同级别的父类菜单（否则是子菜单）
			if ("0".equals(parentId)) {
				menuId = getMenuId(ruleBefore, totalCount);
			} else {
				if (ResourceCommon.RULE_MENU.substring(parentId.length()).length() > 0) {
					ruleEnd = ResourceCommon.RULE_MENU.substring(parentId.length()).split("-")[1].length();
				}
				menuId = parentId + "-" + getMenuId(ruleEnd, totalCount);
			}
		}

		menu.setMenuId(menuId);
		// menu.setMenuOrder("" + (totalCount + 1));

	}

	/**
	 * 计算下一个菜单编号
	 * 
	 * @param ruleIndex
	 *            菜单规则
	 * @param sameTotal
	 *            总行数
	 * @return
	 */
	public static String getMenuId(int ruleIndex, int sameTotal) {
		// String menuId = "";

		StringBuffer strbuf = new StringBuffer();

		int nextMenu = sameTotal + 1;

		int nextMenuLength = Integer.toString(nextMenu).length();

		int lastIndex = ruleIndex - nextMenuLength;

		for (int i = 1; i <= lastIndex; i++) {
			strbuf.append("0");
			// menuId += "0";
		}

		// menuId += nextMenu;
		strbuf.append(nextMenu);

		return strbuf.toString();
	}

	public static String getMenuLevel(String menuId) {
		String menuLevel = "1";

		if (null != menuId && !"".equals(menuId)) {
			menuLevel = String.valueOf(menuId.split("-").length);
		}

		return menuLevel;
	}
}

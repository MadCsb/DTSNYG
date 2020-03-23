package com.msy.travel.common;

import org.apache.commons.lang3.StringUtils;

/**
 * 系统常量类
 * 
 * @author Administrator
 *
 */
public class Consts {
	// base：基本详情,agent:旅行社信息,guide:旅行社导游,guide2:旅行社导游无照片,area:地域人员信息,vehicle:团队车辆信息，trip：团队行程信息,member团队游客信息
	public static final String C_TEAMINFO_MODULE_BASE = "base";
	public static final String C_TEAMINFO_MODULE_AREA = "area";
	public static final String C_TEAMINFO_MODULE_VEHICLE = "vehicle";
	public static final String C_TEAMINFO_MODULE_GUIDE = "guide";
	public static final String C_TEAMINFO_MODULE_GUIDE2 = "guide2";// 只有前端使用
	public static final String C_TEAMINFO_MODULE_TRIP = "trip";
	public static final String C_TEAMINFO_MODULE_MEMBER = "member";

	/**
	 * 团队变更操作
	 */
	public static final String TEAM_CHANGE_ANY = "0"; // 不限次数
	public static final String TEAM_CHANGE_ONCE = "1"; // 只能变更一次
	public static final String TEAM_CHANGE_NO = "2"; // 不能变更

	/**
	 * 微信图片文件夹名称
	 */
	public static final String WX_PIC_FOLDER_NAME = "wxpic";

	/**
	 * 微信文章文件夹名称
	 */
	public static final String WX_ARTICLE_FOLDER_NAME = "article";

	/**
	 * 登录页面-wx 微信
	 */
	public static final String LOGIN_PAGE_WX = "wx";
	/**
	 * 登录页面-WEB 网页
	 */
	public static final String LOGIN_PAGE_WEB = "web";
	/**
	 * 登录页面-WAP 移动网页
	 */
	public static final String LOGIN_PAGE_WAP = "wap";
	/**
	 * 登录页面-Management platform 管理平台
	 */
	public static final String LOGIN_PAGE_MP = "mp";

	/**
	 * 判断一个字符是否是中文
	 * 
	 * @author KDurant
	 * @date 2016年12月19日 上午10:45:52
	 * @param c
	 * @return
	 * @return boolean
	 */
	public static boolean isChinese(char c) {
		return c >= 0x4E00 && c <= 0x9FA5; // 根据字节码判断
	}

	/**
	 * 判断一个字符串是否含有中文
	 * 
	 * @author KDurant
	 * @date 2016年12月19日 上午10:46:40
	 * @param str
	 * @return
	 * @return boolean
	 */
	public static boolean isContainChinese(String str) {
		if (StringUtils.isEmpty(str))
			return false;
		for (char c : str.toCharArray()) {
			if (isChinese(c))
				return true; // 有一个中文字符就返回
		}
		return false;
	}

}

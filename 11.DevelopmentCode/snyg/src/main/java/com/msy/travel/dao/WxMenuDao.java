package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.WxMenu;

/**
 * WxMenuDao接口
 * 
 * @author wootide
 * 
 */
public interface WxMenuDao {
	/**
	 * 增加WxMenu
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 */
	void insertWxMenu(WxMenu wxMenu) throws Exception;

	/**
	 * 检查WxMenu
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 */
	void mergeWxMenu(WxMenu wxMenu) throws Exception;

	/**
	 * 删除WxMenu
	 * 
	 * @param wxMenu
	 *            成语对象
	 */
	void deleteWxMenu(WxMenu wxMenu) throws Exception;

	/**
	 * 批量删除WxMenu
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchWxMenu(WxMenu wxMenu) throws Exception;

	/**
	 * 修改WxMenu
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 */
	void updateWxMenu(WxMenu wxMenu) throws Exception;

	/**
	 * 查询单个WxMenu信息
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 * 
	 * @return WxMenu实体对象
	 */
	WxMenu queryWxMenu(WxMenu wxMenu) throws Exception;

	/**
	 * 查询WxMenu列表信息
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 * 
	 * @return WxMenu列表
	 */
	List<WxMenu> queryWxMenuList(WxMenu wxMenu) throws Exception;

	/**
	 * 获取WxMenuID
	 */
	String getWxMenuId() throws Exception;

	/**
	 * 根据serviceId查找菜单
	 * 
	 * @author yf-wuzhangdi
	 * @date 2018年4月10日 下午2:53:33
	 * @param wxMenu
	 * @return
	 * @throws Exception
	 * @return List<WxMenu>
	 */
	List<WxMenu> queryWxMenuListByServiceId(WxMenu wxMenu) throws Exception;

	/**
	 * 检测重名
	 * 
	 * @author Gengb
	 * @date 2019年3月23日 上午11:13:17
	 * @param wxMenu
	 * @throws Exception
	 * @return int
	 */
	int checkWxMenuName(WxMenu wxMenu) throws Exception;
}

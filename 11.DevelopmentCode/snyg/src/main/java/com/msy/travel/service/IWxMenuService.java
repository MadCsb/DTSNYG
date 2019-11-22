package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.WxMenu;

/**
 * WxMenuService接口
 * 
 * @author wootide
 * 
 */
public interface IWxMenuService {
	/**
	 * 新增WxMenu
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 */
	public void createWxMenu(WxMenu wxMenu) throws Exception;

	/**
	 * 检查WxMenu
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 */
	public void mergeWxMenu(WxMenu wxMenu) throws Exception;

	/**
	 * 删除WxMenu
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 */
	public void deleteWxMenu(WxMenu wxMenu) throws Exception;

	/**
	 * 批量删除WxMenu
	 * 
	 * @param wxMenuIdList
	 *            存放wxMenu主键的list
	 */
	public void deleteBatchWxMenu(WxMenu wxMenu) throws Exception;

	/**
	 * 修改WxMenu
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 */
	public void updateWxMenu(WxMenu wxMenu) throws Exception;

	/**
	 * 查询单个WxMenu
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 * 
	 * @return WxMenu实体对象
	 */
	public WxMenu displayWxMenu(WxMenu wxMenu) throws Exception;

	/**
	 * 查询WxMenu列表
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 * 
	 * @return WxMenu列表
	 */
	public List<WxMenu> queryWxMenuList(WxMenu wxMenu) throws Exception;

	/**
	 * 获取WxMenu主键ID
	 */
	public String getWxMenuId() throws Exception;

	public List<WxMenu> queryWxMenuListByServiceId(WxMenu wxMenu) throws Exception;

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

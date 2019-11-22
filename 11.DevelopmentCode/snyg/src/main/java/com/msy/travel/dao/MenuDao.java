package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.Menu;

/**
 * MenuDao接口
 * 
 * @author wootide
 * 
 */
public interface MenuDao {

	/**
	 * 查询单个Menu信息
	 *
	 * @param menu
	 *            Menu对象
	 *
	 * @return Menu实体对象
	 */
	Menu queryMenu(Menu menu) throws Exception;

	/**
	 * 根据用户id及roleType值获取用户菜单
	 * 
	 * @param menu
	 * @return
	 */
	List<Menu> getListByUserIdAndRoletype(Menu menu) throws Exception;

	/**
	 * 根据用户组id及参数获取当前级菜单
	 * 
	 * @param menu
	 * @return
	 */
	List<Menu> getAll(Menu menu) throws Exception;

	/**
	 * 增加Menu
	 * 
	 * @param menu
	 *            Menu对象
	 */
	void insertMenu(Menu menu) throws Exception;

	/**
	 * 检查Menu
	 * 
	 * @param menu
	 *            Menu对象
	 */
	void mergeMenu(Menu menu) throws Exception;

	/**
	 * 删除Menu
	 * 
	 * @param menu
	 *            成语对象
	 */
	void deleteMenu(Menu menu) throws Exception;

	/**
	 * 批量删除Menu
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchMenu(Menu menu) throws Exception;

	/**
	 * 修改Menu
	 * 
	 * @param menu
	 *            Menu对象
	 */
	void updateMenu(Menu menu) throws Exception;

	/**
	 * 查询Menu列表信息
	 * 
	 * @param menu
	 *            Menu对象
	 * 
	 * @return Menu列表
	 */
	List<Menu> queryMenuList(Menu menu) throws Exception;

	/**
	 * 获取MenuID
	 */
	String getMenuId() throws Exception;

	List<Menu> queryMenuListByMenuPid(String menuPid) throws Exception;

	Menu displayMenuById(String menuId) throws Exception;

	List<Menu> isExistMenuName(Menu menu) throws Exception;

	/**
	 * 查询最大id
	 *
	 * @param menu
	 *            Menu对象
	 *
	 * @return Menu实体对象
	 */
	Menu getMaxMenuId(Menu menu) throws Exception;


	/**
	 * 同步子系统菜单
	 * @param menu
	 * @return
	 * @throws Exception
	 */
	List<Menu> getSynAll(Menu menu) throws Exception;


}

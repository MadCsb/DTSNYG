package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.Menu;

/**
 * MenuService接口
 * 
 * @author wootide
 * 
 */
public interface IMenuService {

	/**
	 * 新增Menu
	 * 
	 * @param menu
	 *            Menu对象
	 */
	public void createMenu(Menu menu) throws Exception;

	/**
	 * 检查Menu
	 * 
	 * @param menu
	 *            Menu对象
	 */
	public void mergeMenu(Menu menu) throws Exception;

	/**
	 * 删除Menu
	 * 
	 * @param menu
	 *            Menu对象
	 */
	public void deleteMenu(Menu menu) throws Exception;

	/**
	 * 批量删除Menu
	 * 
	 * @param menuIdList
	 *            存放menu主键的list
	 */
	public void deleteBatchMenu(Menu menu) throws Exception;

	/**
	 * 修改Menu
	 * 
	 * @param menu
	 *            Menu对象
	 */
	public void updateMenu(Menu menu) throws Exception;

	/**
	 * 查询单个Menu
	 * 
	 * @param menu
	 *            Menu对象
	 * 
	 * @return Menu实体对象
	 */
	public Menu displayMenu(Menu menu) throws Exception;

	/**
	 * 查询Menu列表
	 * 
	 * @param menu
	 *            Menu对象
	 * 
	 * @return Menu列表
	 */
	public List<Menu> queryMenuList(Menu menu) throws Exception;

	/**
	 * 获取Menu主键ID
	 */
	public String getMenuId() throws Exception;

	/**
	 * 根据用户id及roleType值获取用户菜单
	 * 
	 * @param menu
	 * @return
	 */
	public List<Menu> getListByUserIdAndRoletype(Menu menu) throws Exception;

	/**
	 * 根据用户组id及参数获取当前级菜单
	 * 
	 * @param menu
	 * @return
	 */
	public List<Menu> getAll(Menu menu) throws Exception;

	public List<Menu> queryMenuListByMenuPid(String menuPid) throws Exception;

	/**
	 * 通过菜单ID查询菜单信息
	 * 
	 * @param menuId
	 *            菜单ID
	 * @return 菜单实体对象
	 */
	public Menu displayMenuById(String menuId) throws Exception;

	public List<Menu> isExistMenuName(Menu menu) throws Exception;

	public int getMaxMenuId(Menu menu) throws Exception;
}

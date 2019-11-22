package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.MenuButton;

/**
 * MenuButtonService接口
 * 
 * @author wootide
 * 
 */
public interface IMenuButtonService {

	/**
	 * 获取用户菜单按钮
	 * 
	 * @param userid
	 * @return
	 */
	public List<MenuButton> queryMenubuttonListByUserid(String userid);

	/**
	 * 获取用户菜单按钮
	 * 
	 * @param userloginname
	 * @return
	 */
	public List<MenuButton> queryMenubuttonListByUserLoginName(String userloginname);

	/**
	 *
	 * @param menuButton
	 * @return
	 */
	public List<MenuButton> getAll(MenuButton menuButton);

	/**
	 * 新增Menubutton
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 */
	public void createMenubutton(MenuButton menubutton) throws Exception;

	/**
	 * 检查Menubutton
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 */
	public void mergeMenubutton(MenuButton menubutton) throws Exception;

	/**
	 * 删除Menubutton
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 */
	public void deleteMenubutton(MenuButton menubutton) throws Exception;

	/**
	 * 批量删除Menubutton
	 * 
	 * @param menubuttonIdList
	 *            存放menubutton主键的list
	 */
	public void deleteBatchMenubutton(MenuButton menubutton) throws Exception;

	/**
	 * 修改Menubutton
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 */
	public void updateMenubutton(MenuButton menubutton) throws Exception;

	/**
	 * 查询单个Menubutton
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 * 
	 * @return Menubutton实体对象
	 */
	public MenuButton displayMenubutton(MenuButton menubutton) throws Exception;

	/**
	 * 查询Menubutton列表
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 * 
	 * @return Menubutton列表
	 */
	public List<MenuButton> queryMenubuttonList(MenuButton menubutton) throws Exception;

	/**
	 * 获取Menubutton主键ID
	 */
	public String getMenubuttonId() throws Exception;

	public List<MenuButton> isExistName(MenuButton menubutton) throws Exception;

	public List<MenuButton> isExistTag(MenuButton menubutton) throws Exception;

	public List<MenuButton> queryMenubuttonListByUserId(String userId) throws Exception;
}

package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.MenuButton;

/**
 * MenuButtonDao接口
 * 
 * @author wootide
 * 
 */
public interface MenuButtonDao {

	/**
	 * 获取用户菜单按钮
	 * 
	 * @param userid
	 * @return
	 */
	List<MenuButton> queryMenubuttonListByUserid(String userid);

	/**
	 * 获取用户菜单按钮
	 * 
	 * @param userloginname
	 * @return
	 */
	List<MenuButton> queryMenubuttonListByUserLoginName(String userloginname);

	/**
	 *
	 * @param menuButton
	 * @return
	 */
	List<MenuButton> getAll(MenuButton menuButton);

	/**
	 * 增加Menubutton
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 */
	void insertMenubutton(MenuButton menubutton) throws Exception;

	/**
	 * 检查Menubutton
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 */
	void mergeMenubutton(MenuButton menubutton) throws Exception;

	/**
	 * 删除Menubutton
	 * 
	 * @param menubutton
	 *            成语对象
	 */
	void deleteMenubutton(MenuButton menubutton) throws Exception;

	/**
	 * 批量删除Menubutton
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchMenubutton(MenuButton menubutton) throws Exception;

	/**
	 * 修改Menubutton
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 */
	void updateMenubutton(MenuButton menubutton) throws Exception;

	/**
	 * 查询单个Menubutton信息
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 * 
	 * @return Menubutton实体对象
	 */
	MenuButton queryMenubutton(MenuButton menubutton) throws Exception;

	/**
	 * 查询Menubutton列表信息
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 * 
	 * @return Menubutton列表
	 */
	List<MenuButton> queryMenubuttonList(MenuButton menubutton) throws Exception;

	/**
	 * 获取MenubuttonID
	 */
	String getMenubuttonId() throws Exception;

	/**
	 * 验证名称重名
	 * 
	 * @author wzd
	 * @date 2019年2月23日 下午2:21:30
	 * @param menubutton
	 * @return
	 * @throws Exception
	 * @return boolean
	 */
	List<MenuButton> isExistName(MenuButton menubutton) throws Exception;

	/**
	 * 验证tag重名
	 * 
	 * @author wzd
	 * @date 2019年2月23日 下午2:21:53
	 * @param menubutton
	 * @return
	 * @throws Exception
	 * @return boolean
	 */
	List<MenuButton> isExistTag(MenuButton menubutton) throws Exception;

	/**
	 * 获取需要同步的所有菜单
	 * 
	 * @param menuButton
	 * @return
	 * @throws Exception
	 */
	List<MenuButton> queryAllSynButton(MenuButton menuButton) throws Exception;

	List<MenuButton> queryMenubuttonListByUserId(String userId) throws Exception;

}

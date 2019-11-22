package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.dao.MenuButtonDao;
import com.msy.travel.pojo.MenuButton;
import com.msy.travel.service.IMenuButtonService;

/**
 * MenuButtonService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class MenuButtonServiceImpl implements IMenuButtonService {

	@Resource(name = "menuButtonDao")
	private MenuButtonDao menuButtonDao;

	/**
	 * 获取用户菜单按钮
	 */
	@Override
	public List<MenuButton> queryMenubuttonListByUserid(String userid) {

		return menuButtonDao.queryMenubuttonListByUserid(userid);
	}

	/**
	 * 获取用户菜单按钮
	 */
	@Override
	public List<MenuButton> queryMenubuttonListByUserLoginName(String userloginname) {
		return menuButtonDao.queryMenubuttonListByUserLoginName(userloginname);
	}

	/**
	 *
	 * @param menuButton
	 * @return
	 */
	public List<MenuButton> getAll(MenuButton menuButton) {
		return menuButtonDao.getAll(menuButton);
	}

	/**
	 * 新增Menubutton
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 */
	public void createMenubutton(MenuButton menubutton) throws Exception {
		// menubutton.setMenuButtonId(PrimaryKeyUtil.generateKey());
		menuButtonDao.insertMenubutton(menubutton);
	}

	/**
	 * 检查Menubutton
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 */
	public void mergeMenubutton(MenuButton menubutton) throws Exception {
		menuButtonDao.mergeMenubutton(menubutton);
	}

	/**
	 * 删除Menubutton
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 */
	public void deleteMenubutton(MenuButton menubutton) throws Exception {
		menuButtonDao.deleteMenubutton(menubutton);
	}

	/**
	 * 修改Menubutton
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 */
	public void updateMenubutton(MenuButton menubutton) throws Exception {
		menuButtonDao.updateMenubutton(menubutton);
	}

	/**
	 * 批量删除Menubutton
	 * 
	 * @param menubuttonIdList
	 *            存放menubutton主键的list
	 */
	public void deleteBatchMenubutton(MenuButton menubutton) throws Exception {
		menuButtonDao.deleteBatchMenubutton(menubutton);
	}

	/**
	 * 查询单个Menubutton
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 * 
	 * @return 成员实体对象
	 */
	public MenuButton displayMenubutton(MenuButton menubutton) throws Exception {
		return menuButtonDao.queryMenubutton(menubutton);
	}

	/**
	 * 查询Menubutton列表
	 * 
	 * @param menubutton
	 *            Menubutton对象
	 * 
	 * @return Menubutton列表
	 */
	public List<MenuButton> queryMenubuttonList(MenuButton menubutton) throws Exception {
		return menuButtonDao.queryMenubuttonList(menubutton);
	}

	/**
	 * 获取MenubuttonID
	 */
	public String getMenubuttonId() throws Exception {
		return menuButtonDao.getMenubuttonId();
	}

	public List<MenuButton> isExistName(MenuButton menubutton) throws Exception {
		return menuButtonDao.isExistName(menubutton);
	}

	public List<MenuButton> isExistTag(MenuButton menubutton) throws Exception {
		return menuButtonDao.isExistTag(menubutton);
	}

	public List<MenuButton> queryMenubuttonListByUserId(String userId) throws Exception {
		return menuButtonDao.queryMenubuttonListByUserId(userId);
	}
}

package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.dao.MenuButtonDao;
import com.msy.travel.dao.MenuDao;
import com.msy.travel.pojo.Menu;
import com.msy.travel.pojo.MenuButton;
import com.msy.travel.service.IMenuService;

/**
 * MenuService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class MenuServiceImpl implements IMenuService {

	@Resource(name = "menuDao")
	private MenuDao menuDao;

	@Resource(name = "menuButtonDao")
	private MenuButtonDao menuButtonDao;

	/**
	 * 查询单个Menu
	 *
	 * @param menu
	 *            Menu对象
	 *
	 * @return 成员实体对象
	 */
	public Menu displayMenu(Menu menu) throws Exception {
		return menuDao.queryMenu(menu);
	}

	/**
	 * 根据用户id及roleType值获取用户菜单
	 */
	@Override
	public List<Menu> getListByUserIdAndRoletype(Menu menu) throws Exception {

		return menuDao.getListByUserIdAndRoletype(menu);
	}

	/**
	 * 根据用户组id及参数获取当前级菜单
	 * 
	 * @param menu
	 * @return
	 */
	public List<Menu> getAll(Menu menu) throws Exception {
		return menuDao.getAll(menu);
	}

	/**
	 * 新增Menu
	 * 
	 * @param menu
	 *            Menu对象
	 */
	public void createMenu(Menu menu) throws Exception {
		menuDao.insertMenu(menu);
	}

	/**
	 * 检查Menu
	 * 
	 * @param menu
	 *            Menu对象
	 */
	public void mergeMenu(Menu menu) throws Exception {
		menuDao.mergeMenu(menu);
	}

	/**
	 * 删除Menu
	 * 
	 * @param menu
	 *            Menu对象
	 */
	public void deleteMenu(Menu menu) throws Exception {
		MenuButton mb = new MenuButton();
		mb.setMenuId(menu.getMenuId());
		menuButtonDao.deleteMenubutton(mb);
		menuDao.deleteMenu(menu);
	}

	/**
	 * 修改Menu
	 * 
	 * @param menu
	 *            Menu对象
	 */
	public void updateMenu(Menu menu) throws Exception {
		menuDao.updateMenu(menu);
	}

	/**
	 * 批量删除Menu
	 * 
	 * @param menuIdList
	 *            存放menu主键的list
	 */
	public void deleteBatchMenu(Menu menu) throws Exception {
		menuDao.deleteBatchMenu(menu);
	}

	/**
	 * 查询Menu列表
	 * 
	 * @param menu
	 *            Menu对象
	 * 
	 * @return Menu列表
	 */
	public List<Menu> queryMenuList(Menu menu) throws Exception {
		return menuDao.queryMenuList(menu);
	}

	/**
	 * 获取MenuID
	 */
	public String getMenuId() throws Exception {
		return menuDao.getMenuId();
	}

	public List<Menu> queryMenuListByMenuPid(String menuPid) throws Exception {
		return menuDao.queryMenuListByMenuPid(menuPid);
	}

	public Menu displayMenuById(String menuId) throws Exception {
		return menuDao.displayMenuById(menuId);
	}

	public List<Menu> isExistMenuName(Menu menu) throws Exception {
		return menuDao.isExistMenuName(menu);
	}

	public int getMaxMenuId(Menu menu) throws Exception {

		int nextMenuCount = 0;

		String maxMenuId = null;
		if (menuDao.getMaxMenuId(menu) != null && menuDao.getMaxMenuId(menu).getMenuId() != null && !menuDao.getMaxMenuId(menu).equals("")) {
			maxMenuId = menuDao.getMaxMenuId(menu).getMenuId();
		}

		// 表示添加子菜单的第一次菜单
		if (null == maxMenuId) {
			return nextMenuCount;
		}

		// 如果为0表示第一级菜单，否则为添加子菜单
		if ("0".equals(menu.getPMenuId())) {
			nextMenuCount = Integer.parseInt(maxMenuId);
		} else {
			String[] menuIds = maxMenuId.split("-");
			String lastMenuIdPart = menuIds[menuIds.length - 1];
			nextMenuCount = Integer.parseInt(lastMenuIdPart);
		}

		return nextMenuCount;
	}
}

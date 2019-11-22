package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.dao.WxMenuDao;
import com.msy.travel.pojo.WxMenu;
import com.msy.travel.service.IWxMenuService;

/**
 * WxMenuService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class WxMenuServiceImpl implements IWxMenuService {

	@Resource(name = "wxMenuDao")
	private WxMenuDao wxMenuDao;

	/**
	 * 新增WxMenu
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 */
	public void createWxMenu(WxMenu wxMenu) throws Exception {
		wxMenuDao.insertWxMenu(wxMenu);
	}

	/**
	 * 检查WxMenu
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 */
	public void mergeWxMenu(WxMenu wxMenu) throws Exception {
		wxMenuDao.mergeWxMenu(wxMenu);
	}

	/**
	 * 删除WxMenu
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 */
	public void deleteWxMenu(WxMenu wxMenu) throws Exception {
		wxMenuDao.deleteWxMenu(wxMenu);
	}

	/**
	 * 修改WxMenu
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 */
	public void updateWxMenu(WxMenu wxMenu) throws Exception {
		wxMenuDao.updateWxMenu(wxMenu);
	}

	/**
	 * 批量删除WxMenu
	 * 
	 * @param wxMenuIdList
	 *            存放wxMenu主键的list
	 */
	public void deleteBatchWxMenu(WxMenu wxMenu) throws Exception {
		wxMenuDao.deleteBatchWxMenu(wxMenu);
	}

	/**
	 * 查询单个WxMenu
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 * 
	 * @return 成员实体对象
	 */
	public WxMenu displayWxMenu(WxMenu wxMenu) throws Exception {
		return wxMenuDao.queryWxMenu(wxMenu);
	}

	/**
	 * 查询WxMenu列表
	 * 
	 * @param wxMenu
	 *            WxMenu对象
	 * 
	 * @return WxMenu列表
	 */
	public List<WxMenu> queryWxMenuList(WxMenu wxMenu) throws Exception {
		return wxMenuDao.queryWxMenuList(wxMenu);
	}

	/**
	 * 获取WxMenuID
	 */
	public String getWxMenuId() throws Exception {
		return wxMenuDao.getWxMenuId();
	}

	public List<WxMenu> queryWxMenuListByServiceId(WxMenu wxMenu) throws Exception {
		return wxMenuDao.queryWxMenuListByServiceId(wxMenu);
	}

	@Override
	public int checkWxMenuName(WxMenu wxMenu) throws Exception {
		// TODO Auto-generated method stub
		return this.wxMenuDao.checkWxMenuName(wxMenu);
	}
}

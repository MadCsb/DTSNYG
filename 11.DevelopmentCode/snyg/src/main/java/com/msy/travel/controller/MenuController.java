package com.msy.travel.controller;

import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.GenericUtils;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.pojo.Menu;
import com.msy.travel.service.IMenuService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/menu")
public class MenuController extends BaseController {
	public static final Log log = LogFactory.getLog(MenuController.class);

	@Resource(name = "menuServiceImpl")
	private IMenuService menuService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddMenu(Menu menu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("menu/addMenu");
		return view;
	}

	/**
	 * 新增Menu
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addMenu(Menu menu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			menuService.createMenu(menu);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 跳转到修改页面
	 */
	@RequestMapping(params = "method=toUpdate")
	public ModelAndView toUpdateMenu(Menu menu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Menu objMenu = menuService.displayMenu(menu);
			view = new ModelAndView("menu/updateMenu");
			view.addObject("menu", objMenu);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改Menu
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateMenu(Menu menu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			menuService.updateMenu(menu);

			// end
			view = new ModelAndView("redirect:/menu.do?method=query&menuIsAdmin=" + menu.getMenuIsAdmin());

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除Menu
	 */
	@RequestMapping(params = "method=deleteMenu")
	public ModelAndView deleteMenu(Menu menu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			menuService.deleteMenu(menu);
			// end
			view = new ModelAndView("redirect:/menu.do?method=query&menuIsAdmin=" + menu.getMenuIsAdmin());

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 批量删除
	 */
	@RequestMapping(params = "method=deleteBatch")
	public ModelAndView deleteBatchMenu(Menu menu, String checkedMenuIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] menuIds = checkedMenuIds.split(",");
		List<String> menuIdList = new ArrayList<String>();
		Collections.addAll(menuIdList, menuIds);
		try {
			// menu.setMenuIdList(menuIdList);
			menuService.deleteBatchMenu(menu);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 分页查询
	 */
	@RequestMapping(params = "method=query")
	public ModelAndView queryMenuList(Menu menu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			String treeMenu = gettree(menuService.queryMenuListByMenuPid("0"), menu.getMenuIsAdmin());

			view = new ModelAndView("menu/queryMenu");
			view.addObject("treeMenu", treeMenu);

			Map<String, String> menuOrderMap = new LinkedHashMap<String, String>();
			for (int i = 1; i <= 15; i++) {
				menuOrderMap.put("" + i, "" + i);
			}
			view.addObject("menuOrderMap", menuOrderMap);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 递归 生成树
	 *
	 * @param list
	 */
	public String gettree(List<Menu> list, String isAdmin) {

		String treeMenu = "";
		for (Menu menu : list) {
			try {
				if (isAdmin.equals(menu.getMenuIsAdmin())) {
					List<Menu> menuList = menuService.queryMenuListByMenuPid(menu.getMenuId());
					if (menuList.size() > 0) {
						treeMenu += "<li class=\"ren\" id=\"m" + menu.getMenuId() + "\"><label><a href=\"javascript:checkNode('" + menu.getMenuId() + "')\">" + menu.getMenuName()
								+ "</a></label></li><ul id=\"d" + menu.getMenuId() + "\" class=\"two\">";
						treeMenu += gettree(menuList, menu.getMenuIsAdmin());
						treeMenu += "</ul>";
					} else {
						treeMenu += "<li id=\"m" + menu.getMenuId() + "\"><label><a href=\"javascript:checkNode('" + menu.getMenuId() + "')\" class=\"ico\">" + menu.getMenuName()
								+ "</a></label></li>";
					}
				}
			} catch (Exception e) {
				log.error(e, e);
			}
		}
		return treeMenu;
	}

	/**
	 * 获得菜单详细信息
	 */
	@RequestMapping(params = "method=getMenuInfo")
	public void getMenuInfo(Menu menu, HttpServletRequest request, HttpServletResponse response) {
		try {
			menu = menuService.displayMenu(menu);
			JSONObject json = JSONObject.fromObject(menu);
			response.getWriter().write(json.toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 验证重名
	 *
	 * @author wzd
	 * @date 2019年2月22日 上午10:09:23
	 * @param menu
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=toCorMMenu")
	public void toCorMMenu(Menu menu, HttpServletRequest request, HttpServletResponse response) {
		try {

			String Name = URLDecoder.decode(menu.getMenuName(), "utf-8");
			menu.setMenuName(Name);

			List<Menu> menuList = menuService.isExistMenuName(menu);
			String exitedName = "";
			if (menuList.isEmpty()) {
				exitedName = "false";

			} else if (menuList.size() == 0) {
				exitedName = "false";
			} else if (menuList.size() == 1) {
				if (menu != null) {
					if (!menuList.get(0).getMenuId().equals(menu.getMenuId())) {
						exitedName = "true";
					}
				}
			} else if (menuList.size() > 1) {
				exitedName = "true";
			}

			response.getWriter().print(exitedName);

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 新建
	 */
	@RequestMapping(params = "method=createBortherMenu")
	public ModelAndView createBortherMenu(Menu menu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			int totalSize = menuService.getMaxMenuId(menu);

			GenericUtils.getNextMenuId(menu, totalSize);

			menuService.createMenu(menu);

			// end

			view = new ModelAndView("redirect:/menu.do?method=query&menuIsAdmin=" + menu.getMenuIsAdmin());
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除
	 */
	@RequestMapping(params = "method=toDeleteMenu")
	public void toDeleteMenu(Menu menu, HttpServletRequest request, HttpServletResponse response) {
		try {
			String menuId = menu.getMenuId();

			List<Menu> menuList = menuService.queryMenuListByMenuPid(menuId);

			String lstypes = JSONArray.fromObject(menuList).toString();

			response.getWriter().print(lstypes);
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 新建子菜单
	 */
	@RequestMapping(params = "method=createSonMenu")
	public ModelAndView createSonMenu(Menu menu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			int totalSize = menuService.getMaxMenuId(menu);

			GenericUtils.getNextMenuId(menu, totalSize);

			menu.setMenuLevel(GenericUtils.getMenuLevel(menu.getMenuId()));

			menuService.createMenu(menu);
			// end

			view = new ModelAndView("redirect:/menu.do?method=query&menuIsAdmin=" + menu.getMenuIsAdmin());
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新建根菜单
	 */
	@RequestMapping(params = "method=createRootMenu")
	public ModelAndView createRootMenu(Menu menu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			int totalSize = menuService.getMaxMenuId(menu);

			GenericUtils.getNextMenuId(menu, totalSize);

			menu.setMenuLevel(GenericUtils.getMenuLevel(menu.getMenuId()));

			menuService.createMenu(menu);

			view = new ModelAndView("redirect:/menu.do?method=query&menuIsAdmin=" + menu.getMenuIsAdmin());
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 导出excel
	 */
	@RequestMapping(params = "method=export")
	public void exportMenu(Menu menu, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "Menu-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (menu.getEntityPage() == null) {
				menu.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(menu.getEntityPage()), super.getPageSize(menu.getEntityPage()));
			List<Menu> exportlist = menuService.queryMenuList(menu);

			PoiWriteExcel<Menu> pwe = new PoiWriteExcel<Menu>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			// pwe.setHeaders(menu.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

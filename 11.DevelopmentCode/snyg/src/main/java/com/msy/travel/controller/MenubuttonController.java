package com.msy.travel.controller;

import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.pojo.Menu;
import com.msy.travel.pojo.MenuButton;
import com.msy.travel.service.IMenuButtonService;
import com.msy.travel.service.IMenuService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/menuButton")
public class MenubuttonController extends BaseController {
	public static final Log log = LogFactory.getLog(MenubuttonController.class);

	@Resource(name = "menuButtonServiceImpl")
	private IMenuButtonService menubuttonService;

	@Resource(name = "menuServiceImpl")
	private IMenuService menuService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddMenubutton(MenuButton menubutton, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;

		try {
			Menu menu = new Menu();
			menu.setMenuId(menubutton.getMenuId());
			menu = menuService.displayMenu(menu);
			menubutton.setMenuName(menu.getMenuName());
			view = new ModelAndView("menubutton/addMenubutton");
			view.addObject("menu", menu);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	@RequestMapping(params = "method=ajaxAdd")
	public void ajaxAdd(MenuButton menuButton, HttpServletResponse response) {
		String synResult = "1";
		try {
			menuButton.setMenuButtonId(PrimaryKeyUtil.generateKey());

			menubuttonService.createMenubutton(menuButton);
			response.getWriter().write(synResult);
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	@RequestMapping(params = "method=toSuccess")
	public ModelAndView toSuccess() {
		return new ModelAndView("success");
	}

	/**
	 * 新增Menubutton
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addMenubutton(MenuButton menubutton, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			menubutton.setMenuButtonId(PrimaryKeyUtil.generateKey());
			menubuttonService.createMenubutton(menubutton);

			// end
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
	public ModelAndView toUpdateMenubutton(MenuButton menubutton, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			MenuButton objMenubutton = menubuttonService.displayMenubutton(menubutton);
			view = new ModelAndView("menubutton/updateMenubutton");
			view.addObject("menubutton", objMenubutton);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	@RequestMapping(params = "method=ajaxUpdate")
	public void ajaxUpdate(MenuButton menuButton, HttpServletResponse response) {
		String synResult = "1";
		try {
			menubuttonService.updateMenubutton(menuButton);
			response.getWriter().write(synResult);
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 修改Menubutton
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateMenubutton(MenuButton menubutton, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			menubuttonService.updateMenubutton(menubutton);

			// end
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	@RequestMapping(params = "method=ajaxDelete")
	public void ajaxDelete(MenuButton menuButton, HttpServletResponse response) {
		String synResult = "1";
		try {
			menubuttonService.deleteMenubutton(menuButton);
			response.getWriter().write(synResult);
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 删除Menubutton
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteMenubutton(MenuButton menubutton, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			menubuttonService.deleteMenubutton(menubutton);

			// end
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	@RequestMapping(params = "method=ajaxDeleteBatch")
	public void ajaxDeleteBatch(MenuButton menuButton, HttpServletResponse response, String checkedMenubuttonIds) {
		String synResult = "1";
		String[] menubuttonIds = checkedMenubuttonIds.split(",");
		List<String> menubuttonIdList = new ArrayList<String>();
		Collections.addAll(menubuttonIdList, menubuttonIds);
		try {
			menuButton.setMenuButtonIdList(menubuttonIdList);
			if (menubuttonIdList.size() > 0) {
				menuButton.setMenuButtonId(menubuttonIdList.get(0));
				menubuttonService.deleteBatchMenubutton(menuButton);
			}
			response.getWriter().write(synResult);
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 批量删除
	 */
	@RequestMapping(params = "method=deleteBatch")
	public ModelAndView deleteBatchMenubutton(MenuButton menubutton, String checkedMenubuttonIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] menubuttonIds = checkedMenubuttonIds.split(",");
		List<String> menubuttonIdList = new ArrayList<String>();
		Collections.addAll(menubuttonIdList, menubuttonIds);
		try {
			menubutton.setMenuButtonIdList(menubuttonIdList);
			if (menubuttonIdList.size() > 0) {
				menubutton.setMenuButtonId(menubuttonIdList.get(0));
				menubuttonService.deleteBatchMenubutton(menubutton);
			}

			// end
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
	public ModelAndView queryMenubuttonList(MenuButton menubutton, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (menubutton.getEntityPage() == null) {
				menubutton.setEntityPage(new EntityPage());
			}

			// 出入时会添加菜单id
			Menu menu = new Menu();
			menu.setMenuId(menubutton.getMenuId());
			menu = menuService.displayMenu(menu);
			menubutton.setMenuName(menu.getMenuName());

			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(menubutton.getEntityPage()), super.getPageSize(menubutton.getEntityPage()));

			List<MenuButton> menubuttonlist = menubuttonService.queryMenubuttonList(menubutton);

			PageInfo<MenuButton> pageInfo = new PageInfo<MenuButton>(menubuttonlist);

			view = new ModelAndView("menubutton/queryMenubutton");
			view.addObject("menubuttonlist", menubuttonlist);
			view.addObject("menu", menu);
			view.addObject("menubutton", menubutton);
			view.addObject("entityPage", menubutton.getEntityPage());
			view.addObject("pageInfo", pageInfo);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 验证按钮名称重名
	 *
	 * @author wzd
	 * @date 2019年2月23日 下午2:16:11
	 * @param menubutton
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=judgeMenuButtonName")
	public void judgeMenuButtonName(MenuButton menubutton, HttpServletRequest request, HttpServletResponse response) {

		try {
			menubutton.setMenuButtonName(URLDecoder.decode(menubutton.getMenuButtonName(), "utf-8"));
			List<MenuButton> li = menubuttonService.isExistName(menubutton);
			MenuButton r1 = null;
			if (li.size() > 0) {
				r1 = new MenuButton();
				r1.setMsg("功能名称【" + menubutton.getMenuButtonName() + "】已经存在，请修改！");
			}
			String lstypes = JSONArray.fromObject(r1).toString();

			response.getWriter().print(lstypes);
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 验证标识名称重名
	 *
	 * @author wzd
	 * @date 2019年2月23日 下午2:16:11
	 * @param menubutton
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=judgeMenuButtonTag")
	public void judgeMenuButtonTag(MenuButton menubutton, HttpServletRequest request, HttpServletResponse response) {

		try {
			menubutton.setMenuButtonTag(URLDecoder.decode(menubutton.getMenuButtonTag(), "utf-8"));
			List<MenuButton> li = menubuttonService.isExistTag(menubutton);
			MenuButton r1 = null;
			if (li.size() > 0) {
				r1 = new MenuButton();
				r1.setMsg("功能标识【" + menubutton.getMenuButtonTag() + "】已经存在，请修改！");
			}
			String lstypes = JSONArray.fromObject(r1).toString();

			response.getWriter().print(lstypes);
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 导出excel
	 */
	@RequestMapping(params = "method=export")
	public void exportMenubutton(MenuButton menubutton, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "Menubutton-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (menubutton.getEntityPage() == null) {
				menubutton.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(menubutton.getEntityPage()), super.getPageSize(menubutton.getEntityPage()));
			List<MenuButton> exportlist = menubuttonService.queryMenubuttonList(menubutton);

			PoiWriteExcel<MenuButton> pwe = new PoiWriteExcel<MenuButton>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			// pwe.setHeaders(menubutton.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

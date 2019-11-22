package com.msy.travel.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.Feedback;
import com.msy.travel.pojo.WxMenu;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IFeedbackService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IWxMenuService;
import com.msy.travel.wx.pojo.Button;
import com.msy.travel.wx.pojo.CommonButton;
import com.msy.travel.wx.pojo.ComplexButton;
import com.msy.travel.wx.pojo.ViewButton;
import com.msy.travel.wx.utils.WeixinService;
import com.msy.travel.wx.utils.WeixinUtil;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wxMenu")
public class WxMenuController extends BaseController {
	public static final Log log = LogFactory.getLog(WxMenuController.class);

	@Resource(name = "wxMenuServiceImpl")
	private IWxMenuService wxMenuService;

	@Resource(name = "destspServiceImpl")
	private IDestspService destspService;

	@Resource(name = "feedbackServiceImpl")
	private IFeedbackService feedbackService;

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddWxMenu(WxMenu wxMenu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("wxMenu/addWxMenu");
			// 根据登陆用户的AccId查找serviceId
			Destsp destsp = new Destsp();
			destsp.setSpId(getLoginUser(request).getAccId());
			destsp = destspService.displayDestsp(destsp);

			Feedback feedback = new Feedback();

			feedback.setWxServiceId(destsp.getWxServiceId());

			if (wxMenu.getMsgType() == null) {
				wxMenu.setMsgType("0");
			}
			feedback.setMsgType(wxMenu.getMsgType());
			if (feedback.getEntityPage() == null) {
				EntityPage entityPage = new EntityPage();
				entityPage.setSortField("t.F_LASTUPDATE");
				entityPage.setSortOrder("DESC");
				feedback.setEntityPage(entityPage);
			}
			List<Feedback> feedBackList = feedbackService.queryFeedbackListByCustom(feedback);

			view.addObject("feedBackList", feedBackList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增WxMenu 无返回值
	 */
	@RequestMapping(params = "method=createWxMenu")
	public void createWxMenu(WxMenu wxMenu, HttpServletRequest request, HttpServletResponse response) {
		try {
			Destsp destsp = new Destsp();
			destsp.setSpId(getLoginUser(request).getAccId());
			destsp = destspService.displayDestsp(destsp);

			// ServiceCode serviceCode = new ServiceCode();
			// serviceCode.setServiceId(destsp.getWxServiceId());
			// serviceCode = serviceCodeService.displayServiceCode(serviceCode);

			Feedback feedback = new Feedback();
			feedback.setFeedBackId(wxMenu.getFeedBackId());
			feedback = feedbackService.displayFeedback(feedback);

			if (feedback.getDelFlag().equals("1")) {
				response.getWriter().write("{\"ret\":\"1\"}");
			} else {
				if (this.wxMenuService.checkWxMenuName(wxMenu) == 0) {
					wxMenu.setMenuId(PrimaryKeyUtil.generateKey());
					wxMenu.setWxServiceId(destsp.getWxServiceId());
					wxMenuService.createWxMenu(wxMenu);
					response.getWriter().write("{\"ret\":\"0\"}");
				} else {
					response.getWriter().write("{\"ret\":\"2\"}");
				}

			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 新增WxMenu
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addWxMenu(WxMenu wxMenu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			wxMenuService.createWxMenu(wxMenu);
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
	public ModelAndView toUpdateWxMenu(WxMenu wxMenu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("wxMenu/updateWxMenu");

			String feedBackType = wxMenu.getFeedbackType();
			String menuType = wxMenu.getMenuType();

			// 根据登陆用户的AccId查找serviceId
			Destsp destsp = new Destsp();
			destsp.setSpId(getLoginUser(request).getAccId());
			destsp = destspService.displayDestsp(destsp);
			wxMenu = wxMenuService.displayWxMenu(wxMenu);

			Feedback feedback = new Feedback();
			feedback.setFeedBackId(wxMenu.getFeedBackId());

			feedback = feedbackService.displayFeedback(feedback);
			feedback.setWxServiceId(destsp.getWxServiceId());

			if (menuType != null && "0".equals(menuType)) {
				feedback.setMsgType(feedBackType);
				wxMenu.setMsgType(feedBackType);
			} else {
				feedback.setMsgType(feedback.getMsgType());
				wxMenu.setMsgType(feedback.getMsgType());
			}
			if (feedback.getEntityPage() == null) {
				EntityPage entityPage = new EntityPage();
				entityPage.setSortField("t.F_LASTUPDATE");
				entityPage.setSortOrder("DESC");
				feedback.setEntityPage(entityPage);
			}
			List<Feedback> feedBackList = feedbackService.queryFeedbackListByCustom(feedback);

			view.addObject("feedBackList", feedBackList);
			view.addObject("wxMenu", wxMenu);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改WxMenu
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateWxMenu(WxMenu wxMenu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			wxMenuService.updateWxMenu(wxMenu);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改WxMenu 无返回值
	 */
	@RequestMapping(params = "method=updateWxMenuNew")
	public void updateWxMenuNew(WxMenu wxMenu, HttpServletRequest request, HttpServletResponse response) {
		try {
			Destsp destsp = new Destsp();
			destsp.setSpId(getLoginUser(request).getAccId());
			destsp = destspService.displayDestsp(destsp);

			// ServiceCode serviceCode = new ServiceCode();
			// serviceCode.setServiceId(destsp.getWxServiceId());
			// serviceCode = serviceCodeService.displayServiceCode(serviceCode);
			//
			Feedback feedback = new Feedback();
			feedback.setFeedBackId(wxMenu.getFeedBackId());
			feedback = feedbackService.displayFeedback(feedback);

			if (feedback.getDelFlag().equals("1")) {
				response.getWriter().write("{\"ret\":\"1\"}");
			} else {

				if (this.wxMenuService.checkWxMenuName(wxMenu) == 0) {
					wxMenu.setWxServiceId(destsp.getWxServiceId());
					wxMenuService.updateWxMenu(wxMenu);
					response.getWriter().write("{\"ret\":\"0\"}");
				} else {
					response.getWriter().write("{\"ret\":\"2\"}");
				}
			}

			// 生成响应xml文件
			// createNewsXmlFile(feedback, serviceCode);

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 删除WxMenu
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteWxMenu(WxMenu wxMenu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			wxMenuService.deleteWxMenu(wxMenu);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除WxMenu
	 */
	@RequestMapping(params = "method=deleteWxMenuNew")
	public void deleteWxMenuNew(WxMenu wxMenu, HttpServletRequest request, HttpServletResponse response) {
		try {
			wxMenu = wxMenuService.displayWxMenu(wxMenu);
			if (wxMenu.getMenuLevel().equals("0")) {
				WxMenu w = new WxMenu();
				w.setPmenuId(wxMenu.getMenuId());
				int num = wxMenuService.queryWxMenuList(w).size();
				if (num > 0) {
					response.getWriter().write("{\"ret\":\"1\"}");
				} else {
					wxMenuService.deleteWxMenu(wxMenu);
					response.getWriter().write("{\"ret\":\"0\"}");
				}
			} else {
				wxMenuService.deleteWxMenu(wxMenu);
				response.getWriter().write("{\"ret\":\"0\"}");
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 批量删除
	 */
	@RequestMapping(params = "method=deleteBatch")
	public ModelAndView deleteBatchWxMenu(WxMenu wxMenu, String checkedWxMenuIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] wxMenuIds = checkedWxMenuIds.split(",");
		List<String> wxMenuIdList = new ArrayList<String>();
		Collections.addAll(wxMenuIdList, wxMenuIds);
		try {
			wxMenu.setWxMenuIdList(wxMenuIdList);
			wxMenuService.deleteBatchWxMenu(wxMenu);
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
	public ModelAndView queryWxMenuList(WxMenu wxMenu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (wxMenu.getEntityPage() == null) {
				wxMenu.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(wxMenu.getEntityPage()), super.getPageSize(wxMenu.getEntityPage()));
			List<WxMenu> wxMenulist = wxMenuService.queryWxMenuList(wxMenu);
			PageInfo<WxMenu> pageInfo = new PageInfo<WxMenu>(wxMenulist);

			view = new ModelAndView("wxMenu/queryWxMenu");
			view.addObject("wxMenulist", wxMenulist);
			view.addObject("entityPage", wxMenu.getEntityPage());
			view.addObject("pageInfo", pageInfo);
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
	public void exportWxMenu(WxMenu wxMenu, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "WxMenu-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (wxMenu.getEntityPage() == null) {
				wxMenu.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(wxMenu.getEntityPage()), super.getPageSize(wxMenu.getEntityPage()));
			List<WxMenu> exportlist = wxMenuService.queryWxMenuList(wxMenu);

			PoiWriteExcel<WxMenu> pwe = new PoiWriteExcel<WxMenu>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(wxMenu.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 跳转到自定义菜单
	 */
	// @RequiresPermissions({ "queryWxMenu" })
	@RequestMapping(params = "method=toShowWxMenu")
	public ModelAndView toShowWxMenu(WxMenu wxMenu, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("wxMenu/toShowWxMenu");
		return view;
	}

	/**
	 * 获取菜单json数据
	 * 
	 * @author yf-wuzhangdi
	 * @date 2018年4月10日 下午2:10:35
	 * @param wxMenu
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=queryWxMenuJson")
	public void queryWxMenuJson(WxMenu wxMenu, HttpServletRequest request, HttpServletResponse response) {
		try {
			// 根据登陆用户的AccId查找serviceId
			Destsp destsp = new Destsp();
			destsp.setSpId(getLoginUser(request).getAccId());
			destsp = destspService.displayDestsp(destsp);

			// 查找一级和二级菜单
			if (wxMenu == null) {
				wxMenu = new WxMenu();
			}
			wxMenu.setWxServiceId(destsp.getWxServiceId());
			wxMenu.setMenuLevel("0");
			List<WxMenu> wxMenuList1 = wxMenuService.queryWxMenuListByServiceId(wxMenu);
			wxMenu.setMenuLevel("1");
			List<WxMenu> wxMenuList2 = wxMenuService.queryWxMenuListByServiceId(wxMenu);

			List<Object> jsonList = new ArrayList<Object>();
			List<WxMenu> m2List = null;
			for (int i = 0; i < wxMenuList1.size(); i++) {
				m2List = new ArrayList<WxMenu>();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("m1", wxMenuList1.get(i));
				for (int j = 0; j < wxMenuList2.size(); j++) {
					if (wxMenuList1.get(i).getMenuId().equals(wxMenuList2.get(j).getPmenuId())) {
						m2List.add(wxMenuList2.get(j));
					}
				}
				map.put("m2", m2List);
				jsonList.add(map);
			}

			JSONArray json = JSONArray.fromObject(jsonList);
			response.getWriter().write(json.toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	@RequestMapping(params = "method=publishMenu")
	public void publishMenu(WxMenu wxMenu, HttpServletRequest request, HttpServletResponse response) {
		try {
			Destsp destsp = new Destsp();
			destsp.setSpId(getLoginUser(request).getAccId());
			destsp = destspService.displayDestsp(destsp);

			// 查找一级和二级菜单
			if (wxMenu == null) {
				wxMenu = new WxMenu();
			}
			wxMenu.setWxServiceId(destsp.getWxServiceId());
			wxMenu.setMenuLevel("0");
			List<WxMenu> wxMenuList1 = wxMenuService.queryWxMenuListByServiceId(wxMenu);
			wxMenu.setMenuLevel("1");
			List<WxMenu> wxMenuList2 = wxMenuService.queryWxMenuListByServiceId(wxMenu);

			com.msy.travel.wx.pojo.WxMenu WXmenu = new com.msy.travel.wx.pojo.WxMenu();
			List<Button> buttonList = new ArrayList<Button>();

			WxMenu menu1;
			WxMenu menu2;
			boolean flag;
			for (int i = 0; i < wxMenuList1.size(); i++) {
				menu1 = wxMenuList1.get(i);
				flag = false;
				Button button = null;

				for (int j = 0; j < wxMenuList2.size(); j++) {
					menu2 = wxMenuList2.get(j);
					if (menu1.getMenuId().equals(menu2.getPmenuId())) {
						flag = true;
						break;
					}
				}

				if (flag == true) {
					button = new ComplexButton();
					button.setName(menu1.getMenuName());
					List<Button> sub_button = new ArrayList<Button>();
					Button button2 = null;
					for (int j = 0; j < wxMenuList2.size(); j++) {
						menu2 = wxMenuList2.get(j);
						if (menu1.getMenuId().equals(menu2.getPmenuId())) {

							if ("7".equals(menu2.getMsgType())) {
								button2 = new ViewButton();
								button2.setName(menu2.getMenuName());
								((ViewButton) button2).setType(Button.BUTTON_TYPE_VIEW);
								((ViewButton) button2).setUrl(menu2.getLinkUrl());
							} else {
								button2 = new CommonButton();
								button2.setName(menu2.getMenuName());
								((CommonButton) button2).setType(Button.BUTTON_TYPE_CLICK);
								((CommonButton) button2).setKey(menu2.getFeedBackId());
							}
							sub_button.add(button2);
						}
					}

					((ComplexButton) button).setSub_button(sub_button);
				} else {
					if ("7".equals(menu1.getMsgType())) {
						button = new ViewButton();
						button.setName(menu1.getMenuName());
						((ViewButton) button).setType(Button.BUTTON_TYPE_VIEW);
						((ViewButton) button).setUrl(menu1.getLinkUrl());
					} else {
						button = new CommonButton();
						button.setName(menu1.getMenuName());
						((CommonButton) button).setType(Button.BUTTON_TYPE_CLICK);
						((CommonButton) button).setKey(menu1.getFeedBackId());
					}
				}
				buttonList.add(button);
			}

			WXmenu.setButton(buttonList);
			int ret = WeixinUtil.createMenu(WXmenu, WeixinService.getAccessToken(serviceCodeService, destspService, request));

			if (ret == 0) {
				response.getWriter().write("{\"ret\":\"0\"}");
			} else {
				response.getWriter().write("{\"ret\":\"1\"}");
			}
		} catch (Exception e) {
			try {
				response.getWriter().write("{\"ret\":\"1\"}");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			log.error(e, e);
		}
	}
}

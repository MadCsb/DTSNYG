package com.msy.travel.controller;

import java.net.URLDecoder;
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
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.ResourceCommon;
import com.msy.travel.pojo.Menu;
import com.msy.travel.pojo.MenuButton;
import com.msy.travel.pojo.User;
import com.msy.travel.pojo.UserGroup;
import com.msy.travel.service.IMenuButtonService;
import com.msy.travel.service.IMenuService;
import com.msy.travel.service.IRoleService;
import com.msy.travel.service.IUserGroupService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/userGroup")
public class UserGroupController extends BaseController {
	public static final Log log = LogFactory.getLog(UserGroupController.class);

	@Resource(name = "userGroupServiceImpl")
	private IUserGroupService userGroupService;

	@Resource(name = "menuServiceImpl")
	private IMenuService menuService;

	@Resource(name = "menuButtonServiceImpl")
	private IMenuButtonService menuButtonService;

	@Resource(name = "roleServiceImpl")
	private IRoleService roleService;

	/**
	 * 跳转到新增页面
	 */
	// @RequiresPermissions({ "addUsergroup" })
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddUserGroup(UserGroup userGroup, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("usergroup/addUsergroup");

			User operator = getLoginUser(request);

			// 根据角色类型查询可以修改的角色类型
			// List<Role> roleList =
			// roleService.queryRoleByRoleType(operator.getUserRoleType());
			// view.addObject("roleList", roleList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增UserGroup
	 */
	// @RequiresPermissions({ "addUsergroup" })
	@RequestMapping(params = "method=add")
	public ModelAndView addUserGroup(UserGroup userGroup, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			User operator = getLoginUser(request);
			userGroup.setUserGroupState("1");
			userGroup.setSpId(operator.getAccId());
			userGroup.setUserGroupCreateDate(DateTimeUtil.getDateTime10());
			userGroup.setCreateRoleType(operator.getUserRoleType());
			userGroup.setCreateUnitId(operator.getUnitId());
			userGroup.setUserGroupId(PrimaryKeyUtil.generateKey());
			userGroup.setRoleType("2");
			userGroupService.createUserGroup(userGroup);
			view = new ModelAndView("success");
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 跳转到修改页面
	 */
	// @RequiresPermissions({ "modifyUsergroup" })
	@RequestMapping(params = "method=toUpdate")
	public ModelAndView queryUserGroup(UserGroup userGroup, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			UserGroup objUserGroup = userGroupService.displayUserGroup(userGroup);
			view = new ModelAndView("usergroup/updateUsergroup");
			view.addObject("userGroup", objUserGroup);

			User operator = getLoginUser(request);
			// 根据角色类型查询可以修改的角色类型
			// List<Role> roleList =
			// roleService.queryRoleByRoleType(operator.getUserRoleType());
			// view.addObject("roleList", roleList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改UserGroup
	 */
	// @RequiresPermissions({ "modifyUsergroup" })
	@RequestMapping(params = "method=update")
	public ModelAndView updateUserGroup(UserGroup userGroup, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			userGroupService.updateUserGroup(userGroup);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除UserGroup
	 */
	// @RequiresPermissions({ "delUsergroup" })
	@RequestMapping(params = "method=delete")
	public void deleteUserGroup(UserGroup userGroup, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String result = "success";
		try {
			List<UserGroup> list = this.userGroupService.queryUserGroupLinkList(userGroup);
			if (list.size() == 0) {
				userGroupService.deleteUserGroup(userGroup);
			} else {
				result = "fail";// 已绑定用户组，不允许删
			}

		} catch (Exception e) {
			result = "error";
			log.error(e, e);
		}
		response.getWriter().write(result);
	}

	/**
	 * 分页查询
	 */
	@RequestMapping(params = "method=query")
	public ModelAndView queryUserGroupList(UserGroup userGroup, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (null == userGroup) {
				userGroup = new UserGroup();
			}
			if (userGroup.getEntityPage() == null) {
				userGroup.setEntityPage(new EntityPage());
				userGroup.getEntityPage().setSortField("F_USERGROUP_CREATE_DATE");
				userGroup.getEntityPage().setSortOrder("DESC");
			}
			User operator = getLoginUser(request);
			// 当前旅游局只能操作当前角色
			userGroup.setSpId(operator.getAccId());
			userGroup.setCreateRoleType(operator.getUserRoleType());
			userGroup.setCreateUnitId(operator.getUnitId());
			userGroup.setUserGroupState("1");

			// 根据角色类型查询可以修改的角色类型
			// List<Role> roleList =
			// roleService.queryRoleByRoleType(operator.getUserRoleType());
			super.saveBackUrl(request);

			// 设置分页
			PageHelper.startPage(super.getPageNum(userGroup.getEntityPage()), super.getPageSize(userGroup.getEntityPage()));
			List<UserGroup> userGrouplist = userGroupService.queryUserGroupList(userGroup);
			PageInfo<UserGroup> pageInfo = new PageInfo<UserGroup>(userGrouplist);

			view = new ModelAndView("usergroup/queryUserGroup");
			view.addObject("loginUserRoleType", getLoginUser(request).getUserRoleType());
			view.addObject("loginUserUnitId", getLoginUser(request).getUnitId());
			// view.addObject("roleList", roleList);
			view.addObject("userGrouplist", userGrouplist);
			view.addObject("entityPage", userGroup.getEntityPage());
			view.addObject("pageInfo", pageInfo);

		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 *
	 * @param userGroup
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "method=ajaxList")
	public void ajaxUserGroupList(UserGroup userGroup, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (userGroup.getUserGroupName() != null) {
				userGroup.setUserGroupName(URLDecoder.decode(userGroup.getUserGroupName(), "utf-8"));
			}
			if (userGroup.getAllUserGroupName() != null) {
				userGroup.setAllUserGroupName(URLDecoder.decode(userGroup.getAllUserGroupName(), "utf-8"));
			}
			userGroup.setUserGroupState("1");
			User operator = getLoginUser(request);
			userGroup.setSpId(operator.getAccId());
			List<UserGroup> userGroupList = userGroupService.queryUserGroupList(userGroup);
			response.getWriter().write(JSONArray.fromObject(userGroupList).toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	// @RequiresPermissions({ "assignMenuAndButton" })
	@RequestMapping(params = "method=toUpdateMenu")
	public ModelAndView toUpdateMenu(UserGroup userGroup, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			userGroup = userGroupService.displayUserGroup(userGroup);
			String isAdmin = getIsAdmin(userGroup.getRoleType());

			Menu menu = new Menu();
			menu.setMenuIsAdmin(isAdmin);
			menu.setMenuLevel("2");
			menu.setUsergroupId(userGroup.getUserGroupId());
			List<Menu> menuList = menuService.getAll(menu);
			// List<MenuButton> menuButtonList = new ArrayList<MenuButton>();

			// MenuButton menuButton = new MenuButton();
			// menuButton.setUsergroupId(userGroup.getUserGroupId());
			// for (int i = 0; i < menuList.size(); i++) {
			// menuButton.setMenuId(menuList.get(i).getMenuId());
			// menuButtonList.addAll(menuButtonService.getAll(menuButton));
			// }
			view = new ModelAndView("usergroup/bindMenuAndButton");
			view.addObject("userGroup", userGroup);
			view.addObject("menuList", menuList);
			// view.addObject("menuButtonList", menuButtonList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 用户组权限菜单绑定
	 */
	@RequestMapping(params = "method=updateMenu")
	public ModelAndView bindUsergroupMenuAndButton(UserGroup userGroup, Menu menu, MenuButton menuButton, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			userGroupService.deleteUsergoupMenu(userGroup.getUserGroupId());
			userGroupService.deleteUsergoupMenuButton(userGroup.getUserGroupId());
			if (menu.getMenuId() != null) {
				userGroupService.insertUsergoupMenu(userGroup.getUserGroupId(), menu.getMenuId().split(","));
			}
			if (menuButton.getMenuButtonId() != null) {
				userGroupService.insertUsergourpMenubutton(userGroup.getUserGroupId(), menuButton.getMenuButtonId().split(","));
			}

			User user = getLoginUser(request);

			String isAdmin = getIsAdmin(user.getUserRoleType()); // 用户菜单编号
			// 获取用户菜单
			Menu dbMenu = new Menu();
			dbMenu.setUserId(user.getUserId());
			dbMenu.setRoleType(isAdmin);
			List<Menu> menuList = menuService.getListByUserIdAndRoletype(dbMenu);

			// 获取用户菜单按妞
			List<MenuButton> menuButtonList = menuButtonService.queryMenubuttonListByUserid(user.getUserId());
			request.getSession().setAttribute(ResourceCommon.LOGIN_USER_MENU, menuList);
			request.getSession().setAttribute(ResourceCommon.LOGIN_USER_MENU_BUTTON, menuButtonList);

			view = new ModelAndView("success");
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	private String getIsAdmin(String roleType) {
		// String isAdmin = "-1"; // 用户菜单编号
		// switch (roleType) {
		// case "0": // 旅行社
		// isAdmin = "2";
		// break;
		// case "1": // 景区
		// isAdmin = "3";
		// break;
		// case "3": // 运营商
		// isAdmin = "4";
		// break;
		// case "4": // 车队
		// isAdmin = "5";
		// break;
		// case "5": // 银行
		// isAdmin = "6";
		// break;
		// case "6": // 保险公司
		// isAdmin = "7";
		// break;
		// }
		// return isAdmin;

		if (roleType != null && !"".equals(roleType)) {
			return roleType;
		} else {
			return "-1";
		}
	}

}

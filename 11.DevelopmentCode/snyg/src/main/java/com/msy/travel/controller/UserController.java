package com.msy.travel.controller;

import com.msy.travel.common.LogicException;
import com.msy.travel.pojo.Destsp;
import java.io.PrintWriter;
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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.ComparePojo;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.MD5;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.RedisUtil;
import com.msy.travel.common.ResourceCommon;
import com.msy.travel.pojo.Menu;
import com.msy.travel.pojo.Role;
import com.msy.travel.pojo.User;
import com.msy.travel.pojo.UserGroup;
import com.msy.travel.service.IMenuButtonService;
import com.msy.travel.service.IMenuService;
import com.msy.travel.service.IPubUserLogService;
import com.msy.travel.service.IRoleService;
import com.msy.travel.service.IUserGroupService;
import com.msy.travel.service.IUserService;
import com.msy.travel.task.Scheduled;

@Controller
@Scope(value = "prototype")
public class UserController extends BaseController {
	public static final Log log = LogFactory.getLog(UserController.class);

	public static Map<String, Integer> loginUserLockMap = new HashMap<String, Integer>();

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Resource(name = "menuServiceImpl")
	private IMenuService menuService;

	@Resource(name = "menuButtonServiceImpl")
	private IMenuButtonService menuButtonService;

	@Resource(name = "userGroupServiceImpl")
	private IUserGroupService userGroupService;

	@Resource(name = "roleServiceImpl")
	private IRoleService roleService;

	@Resource(name = "scheduled")
	private Scheduled scheduled;

	@Resource(name = "pubUserLogServiceImpl")
	private IPubUserLogService pubUserLogService;

	@Resource(name = "redisUtil")
	private RedisUtil redisUtil;

	/**
	 * 跳转登陆页面
	 * @param loginPage
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/tologin")
	public ModelAndView toLogin(HttpServletRequest request, HttpServletResponse response, User user,String loginPage) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("login");
			if ("web".equals(loginPage))
			{
				view = new ModelAndView("web/personal/login");
			}
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}


	/**
	 * 跳转登陆页面
	 * @return
	 */
	@RequestMapping(value = "/toNewUser")
	public ModelAndView toNewUser(HttpServletRequest request) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("web/personal/zhuce");
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 用户登陆
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/newUser")
	public ModelAndView newUser(HttpServletRequest request, HttpServletResponse response, User user) {
		ModelAndView view = null;
		try {

			if (user.getUserLoginName() == null || user.getUserLoginName().trim().equals("")) {
				view = new ModelAndView("web/personal/zhuce");
				view.addObject("errorMsg", "请输入用户名");
				view.addObject("user", user);
			} else if (user.getUserPwd() == null || user.getUserPwd().trim().equals("")) {
				view = new ModelAndView("web/personal/zhuce");
				view.addObject("errorMsg", "请输入密码");
				view.addObject("user", user);
			} else if (user.getUserNewPwd() == null || user.getUserNewPwd().trim().equals("")) {
				view = new ModelAndView("web/personal/zhuce");
				view.addObject("errorMsg", "请输入确认密码");
				view.addObject("user", user);
			} else if (!user.getUserPwd().trim().equals(user.getUserNewPwd().trim())) {
				view = new ModelAndView("web/personal/zhuce");
				view.addObject("errorMsg", "两次输入密码不一致!");
				view.addObject("user", user);
			}else	if (null == user.getSecurityCode()
					|| user.getSecurityCode().equals("")
					|| request.getSession().getAttribute("rand") == null) {
				view = new ModelAndView("web/personal/zhuce");
				view.addObject("errorMsg", "请输入验证码");
				view.addObject("user",user);
			} else if (!request.getSession().getAttribute("rand").equals(user.getSecurityCode())) {
				view = new ModelAndView("web/personal/zhuce");
				view.addObject("errorMsg", "验证码错误");
				view.addObject("user",user);
			} else {
				User userTmp = new User();
				userTmp.setUserLoginName(user.getUserLoginName().trim());
				List<User> userList = userService.queryUserList(userTmp);
				if(userList.size()!=0)
				{
					view = new ModelAndView("web/personal/zhuce");
					view.addObject("errorMsg", "登录名已存在，请修改后重试!");
					view.addObject("user", user);
				}else
				{
					String time = DateTimeUtil.getDateTime19();
					User userDb = new User();
					userDb.setUserId(PrimaryKeyUtil.generateKey());
					userDb.setUserLoginName(user.getUserLoginName().trim());
					userDb.setUserName(PrimaryKeyUtil.getDefaultWxUserName());
					userDb.setUserPwd(MD5.encode(user.getUserPwd().trim()));
					userDb.setUserRegDate(time);
					userDb.setUserState("1");
					userDb.setUserLocked("0");
					userDb.setUserRoleType(null);
					userDb.setAccId(Destsp.currentSpId);
					userService.createUser(userDb);
					UsernamePasswordToken token = new UsernamePasswordToken(userDb.getUserLoginName(), userDb.getUserPwd());
					Subject subject = SecurityUtils.getSubject();
					subject.login(token);
					WebUtils.issueRedirect(request, response, "/webPersonal?method=personal");
				}
			}
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}


	/**
	 * 用户登陆
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, User user,String loginPage) {
		ModelAndView view = null;
		try {
			if ("web".equals(loginPage))
			{
				view = new ModelAndView("redirect:/webPersonal.do?method=personal");
			}else
			{
				view = new ModelAndView("main");
			}
			if (request.getSession().getAttribute(ResourceCommon.LOGIN_USER) != null) {
				return view;
			}

			if (null == user.getSecurityCode() || request.getSession().getAttribute("rand") == null) {
				throw new LogicException("请输入验证码");
			}
			if (!request.getSession().getAttribute("rand").equals(user.getSecurityCode())) {
				throw new LogicException("验证码错误");
			}

			UsernamePasswordToken token = new UsernamePasswordToken(user.getUserLoginName(), MD5.encode(user.getUserPwd()));
			Subject subject = SecurityUtils.getSubject();
			try {
				subject.login(token);
			} catch (Exception e) {
				throw new LogicException(e.getMessage());
			}
		}catch (LogicException le)
		{
			if ("web".equals(loginPage))
			{
				view = new ModelAndView("web/personal/login");
			}else
			{
				view = new ModelAndView("login");
			}
			view.addObject("errorMsg",le.getMessage());
		}catch (Exception e)
		{
			if ("web".equals(loginPage))
			{
				view = new ModelAndView("web/personal/login");
			}else
			{
				view = new ModelAndView("login");
			}
			view.addObject("errorMsg","系统异常");
		}
		return view;
	}

	/**
	 * 跳转到修改页面
	 */
	@RequestMapping(value = "/toUpdateUserPWD")
	public ModelAndView toUpdateUserPWD(User user, HttpServletRequest request) {
		ModelAndView view = null;
		try {
			user = this.getLoginUser(request);
			view = new ModelAndView("user/updateUserPWD");
			view.addObject("user", user);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 登出系统
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response,String loginPage) {
		ModelAndView view = new ModelAndView("redirect:/tologin");
		if ("web".equals(loginPage))
		{
			view = new ModelAndView("redirect:/tologin?loginPage="+loginPage);
		}
		request.getSession().removeAttribute(ResourceCommon.LOGIN_USER);
		request.getSession().invalidate();
		return view;
	}

	/**
	 * 获取首页导航栏
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/queryMenuBar")
	public void queryMenuBar(HttpServletRequest request, HttpServletResponse response, Menu menu) {

		try {
			StringBuffer res = new StringBuffer();
			Menu m = menuService.displayMenu(menu);

			if (m.getPMenuId() != null && !"0".equals(m.getPMenuId())) {
				Menu pm = new Menu();
				pm.setMenuId(m.getpMenuId());
				pm = menuService.displayMenu(pm);
				res.append(" > ");
				res.append(pm.getMenuName());
			}
			res.append(" > ");
			res.append(m.getMenuName());

			response.getWriter().print(res.toString());

		} catch (Exception e) {
			log.error(e, e);
		}

	}

	/**
	 * 修改
	 */
	// @RequiresPermissions(value = { "modifyUser", "saveLoginUser" }, logical =
	// Logical.OR)
	@RequestMapping(value = "/updateUser")
	public ModelAndView updateUser(User user, HttpServletRequest request) {
		ModelAndView view = null;
		try {
			String userId = user.getUserId();
			if (null == userId || "".equals(userId)) {
				view = new ModelAndView("error");
				return view;
			}
			User u = userService.displayUser(user);
			if (null == u) {
				view = new ModelAndView("error");
				return view;
			}
			String info = null;
			if (!"".equals(user.getUserPwd())) {
				user.setUserPwd(MD5.encode(user.getUserPwd()));
				userService.updateUserPWD(user);
				info = "1";
			}

			userService.updateUser(user);

			List<HashMap<String, String>> changeMap = ComparePojo.comparePojo(u, user);
			String changeInfo = ComparePojo.getChangeStrs(changeMap);
			if ((null != changeInfo && !"".equals(changeInfo)) || (null != info && "1".equals(info))) {
				if ((null != changeInfo && !"".equals(changeInfo)) && (null != info && "1".equals(info))) {
					pubUserLogService.createUserLog(request, "修改管理员", "1", "修改登录名为" + u.getUserLoginName() + "用户，修改登录密码，变更内容：" + changeInfo);
				} else if (null != changeInfo && !"".equals(changeInfo)) {
					pubUserLogService.createUserLog(request, "修改管理员", "1", "修改登录名为" + u.getUserLoginName() + "用户，变更内容：" + changeInfo);
				} else if (null != info && "1".equals(info)) {
					pubUserLogService.createUserLog(request, "修改管理员", "1", "修改登录名为" + u.getUserLoginName() + "用户，修改登录密码");
				}
			}

			view = new ModelAndView("success");
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 登录名是否重复
	 */
	@RequestMapping(value = "/checkUserLoginName")
	public void checkUserName(User user, HttpServletResponse response, HttpServletRequest request) {
		try {
			User us = new User();
			us.setDelFlag("0");
			us.setUserLoginName(user.getUserLoginName());
			int count = userService.getUserCountFromAdd(us);
			if (count > 0) {
				user.setMsg("登录名【" + user.getUserLoginName() + "】已经存在！");
			}
			String lstypes = JSONArray.fromObject(user).toString();
			response.setContentType("text/xml");
			response.getWriter().print(lstypes);
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 校验旧密码、新密码
	 */
	@RequestMapping(value = "/judgeUserPWD")
	public void judgeUserPWD(User user, String type, HttpServletRequest request, HttpServletResponse response) {
		String resultCode = "0";// 0:失败 1:成功 2：新密码和原密码相同,3：新支付密码和原支付密码相同
		try {
			PrintWriter out = response.getWriter();
			String userId = user.getUserId();
			if (null == userId || "".equals(userId)) {
				out.print(resultCode);
				out.flush();
				out.close();
				return;
			}
			User loginUser = this.getLoginUser(request);
			if (!loginUser.getUserId().equals(userId)) {
				out.print(resultCode);
				out.flush();
				out.close();
				return;
			}
			User u = new User();
			u.setUserId(user.getUserId());
			u = userService.displayUser(u);

			if (null == u) {
				out.print(resultCode);
				out.flush();
				out.close();
				return;
			}
			if ("0".equals(type)) {
				if (u.getUserPwd().equals(MD5.encode(user.getUserPwd()))) {
					resultCode = "1";
				}
			} else if ("1".equals(type)) {
				if (u.getUserPwd().equals(MD5.encode(user.getUserNewPwd()))) {
					resultCode = "2";
				} else {
					resultCode = "1";
				}

			}

			out.print(resultCode);
			out.flush();
			out.close();
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 修改密码
	 */
	@RequestMapping(value = "/updateUserPWD")
	public ModelAndView updateUserPWD(User user, String type, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			String userId = user.getUserId();
			if (null == userId || "".equals(userId)) {
				view = new ModelAndView("error");
				return view;
			}
			User loginUser = this.getLoginUser(request);
			if (!loginUser.getUserId().equals(userId)) {
				view = new ModelAndView("error");
				return view;
			}
			User u = new User();
			u.setUserId(user.getUserId());
			u = userService.displayUser(u);
			if (null == u) {
				view = new ModelAndView("error");
				return view;
			}
			if (!u.getUserPwd().equals(MD5.encode(user.getUserPwd()))) {
				view = new ModelAndView("error");
				return view;
			}
			if (u.getUserPwd().equals(MD5.encode(user.getUserNewPwd()))) {
				view = new ModelAndView("error");
				return view;
			}

			u.setUserPwd(MD5.encode(user.getUserNewPwd()));
			userService.updateUserPWD(u);
			userService.updateUser(u);

			pubUserLogService.createUserLog(request, "修改管理员", "1", "登录名为" + u.getUserLoginName() + "的用户修改登录密码 成功");
			// view = new ModelAndView("user/transitPage");
			response.getWriter().print("1");
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 查询用户列表
	 *
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	// @RequiresPermissions({ "queryUser" })
	@RequestMapping(value = "/queryUserList")
	public ModelAndView queryUser(User user, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			User u = this.getLoginUser(request);
			if (user.getEntityPage() == null) {
				user.setEntityPage(new EntityPage());
				user.getEntityPage().setSortField("F_USER_REG_DATE");
				user.getEntityPage().setSortOrder("DESC");
			}
			// 链接中的角色类型
			String roleType = user.getUserRoleType();

			// 支撑商下获取所有单位数据否则获取当前用户的单位编号
			user.setUnitId(u.getUnitId());
			if (!roleType.equals(u.getUserRoleType()) && "2".equals(u.getUserRoleType())) {
				user.setUnitId("");
			}
			// 是否有权限审批
			String isApprove = "0";// 否
			if ("2".equals(u.getUserRoleType())) {
				isApprove = "1";
			}
			// 未删除
			user.setDelFlag("0");
			user.setAccId(u.getAccId());

			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(user.getEntityPage()), super.getPageSize(user.getEntityPage()));
			List<User> userList = userService.queryUserList(user);
			PageInfo<User> pageInfo = new PageInfo<User>(userList);

			// 商家
			if ("3".equals(roleType)) {
				view = new ModelAndView("user/queryUserListVen");
			} else {
				view = new ModelAndView("user/queryUserList");
			}

			view.addObject("user", user);
			view.addObject("isApprove", isApprove);
			view.addObject("userList", userList);
			view.addObject("entityPage", user.getEntityPage());
			view.addObject("pageInfo", pageInfo);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 跳转到新增页面
	 */
	// @RequiresPermissions({ "addUser" })
	@RequestMapping(value = "/toAddSysUser")
	public ModelAndView toAddSysUser(User user, HttpServletRequest request) {
		ModelAndView view = null;
		try {
			Role role = new Role();
			List<Role> roleList = roleService.queryRoleList(role);
			view = new ModelAndView("user/addSysUser");
			User u = this.getLoginUser(request);
			User loginUser = userService.displayUser(u);
			if (loginUser.getUserRoleType().equals(user.getUserRoleType())) {

			} else {
				loginUser.setUnitId("");
				loginUser.setUnitName("");
			}
			view.addObject("u", loginUser);
			view.addObject("roleList", roleList);
			view.addObject("user", user);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增
	 */
	// @RequiresPermissions({ "addUser" })
	@RequestMapping(value = "/addSysUser")
	public ModelAndView addSysUser(User user, HttpServletRequest request) {
		ModelAndView view = null;
		try {
			User us = new User();
			User u = this.getLoginUser(request);
			us.setUserLoginName(user.getUserLoginName());
			us.setDelFlag("0");
			List<User> userList = userService.queryUserList(us);
			if (userList.size() > 0) {
				view = new ModelAndView("user/addSysUser");
				view.addObject("msg", "登录名【" + user.getUserLoginName() + "】已经存在！");
				view.addObject("u", user);
				return view;
			}

			user.setAccId(u.getAccId());
			user.setUserState("1");// 1:有效
			user.setUserPwd(MD5.encode(user.getUserPwd()));
			user.setUserLocked("0");
			user.setUserRegDate(DateTimeUtil.getDateTime19());
			user.setUserId(PrimaryKeyUtil.generateKey());
			user.setUnitId(u.getAccId());
			user.setUserRoleType("2");

			userService.createUser(user);

			pubUserLogService.createUserLog(request, "新增管理员", "1", "新增用户:登录名为" + user.getUserLoginName() + "  成功");

			view = new ModelAndView("success");
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	@RequestMapping(value = "/bindUserRole")
	public ModelAndView bindUserRole(HttpServletRequest request, String userId, String checkedUnitId, HttpServletResponse response, Role role) {
		ModelAndView view = null;
		try {
			User u = this.getLoginUser(request);
			if (null == u) {
				view = new ModelAndView("error");
				return view;
			}
			String roleType = role.getUserRoleType();
			if (null == roleType && "".equals(roleType)) {
				view = new ModelAndView("error");
				return view;
			}
			String loginRoleType = u.getUserRoleType();
			Role unitRole = new Role();
			unitRole.setUserRoleType(role.getUserRoleType());
			if (roleType.equals(loginRoleType) && !"3".equals(roleType)) {
				unitRole.setUnitId(u.getUnitId());
			}
			unitRole.setUnitName(role.getUnitName());
			unitRole.setAccId(u.getAccId());
			List<Role> unitRoleList = roleService.queryRoleLinkUnitList(unitRole);
			view = new ModelAndView("user/bindUserRole");
			if (null == checkedUnitId || "".equals(checkedUnitId)) {
				if (null != userId && !"".equals(userId)) {
					User user = new User();
					user.setUserId(userId);
					user = userService.displayUser(user);
					if (null != user) {
						checkedUnitId = user.getUnitId();
					}
				}
			}
			Role r = new Role();
			List<Role> roleList = roleService.queryRoleList(r);
			view.addObject("checkedUnitId", checkedUnitId);
			view.addObject("roleList", roleList);
			view.addObject("role", role);
			view.addObject("unitRoleList", unitRoleList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}

		return view;
	}

	// @RequiresPermissions({ "delUser" })
	@RequestMapping(value = "/deleteUserGroupLink")
	public ModelAndView deleteUserGroupLink(User user, HttpServletRequest request) {
		ModelAndView view = null;
		try {
			if (null == user || null == user.getUserId() || "".equals(user.getUserId())) {
				view = new ModelAndView("error");
				return view;
			}
			User u = userService.displayUser(user);
			if (null == u) {
				view = new ModelAndView("error");
				return view;
			}
			u.setUserState("-1");
			userService.updateUser(u);
			UserGroup userGroup = new UserGroup();
			userGroup.setUserId(user.getUserId());
			userGroupService.deleteUserGroupLink(userGroup);

			pubUserLogService.createUserLog(request, "删除管理员", "1", "删除登录名为" + u.getUserLoginName() + "的用户  成功");

			view = new ModelAndView("success");
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	// @RequiresPermissions(value = { "modifyUser", "queryLoginUser" }, logical
	// = Logical.OR)
	@RequestMapping(value = "/toUpdateSysUser")
	public ModelAndView toUpdateSysUser(User user, String entranceType, HttpServletRequest request) {
		ModelAndView view = null;
		try {
			User loginUser = this.getLoginUser(request);
			if (null == loginUser) {
				view = new ModelAndView("error");
				return view;
			}
			User u = new User();
			String loginRoleType = "";
			String userId = user.getUserId();
			if (null == userId || "".equals(userId)) {
				if ("1".equals(entranceType)) {
					super.saveBackUrl(request);
					u.setUserId(this.getLoginUser(request).getUserId());
					u = userService.displayUser(u);
					loginRoleType = u.getUserRoleType();
				} else {
					view = new ModelAndView("error");
					return view;
				}
			} else {
				u = userService.displayUser(user);
				if (null == u) {
					view = new ModelAndView("error");
					return view;
				}
				loginRoleType = user.getUserRoleType();
			}

			Role role = new Role();
			List<Role> roleList = roleService.queryRoleList(role);

			view = new ModelAndView("user/updateSysUser");

			view.addObject("roleList", roleList);
			view.addObject("entranceType", entranceType);
			view.addObject("user", u);
			view.addObject("roleType", loginRoleType);
			view.addObject("loginRoleType", loginUser.getUserRoleType());
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 绑定用户组
	 *
	 * @param user
	 * @return
	 */
	// @RequiresPermissions({ "bindUsergroup" })
	@RequestMapping(value = "/toBinkUserGroupLink")
	public ModelAndView toBinkUserGroupLink(User user, HttpServletRequest request) {
		ModelAndView view = null;
		try {
			User userDb = userService.displayUser(user);

			User u = this.getLoginUser(request);
			UserGroup userGroup = new UserGroup();
			userGroup.setEntityPage(new EntityPage());
			userGroup.setSpId(u.getAccId());
			userGroup.setCreateRoleType(u.getUserRoleType());
			userGroup.setCreateUnitId(u.getUnitId());
			userGroup.setUserGroupState("1");
			userGroup.setRoleType(userDb.getUserRoleType());

			int totalSize = userGroupService.getTotalCount(userGroup);
			userGroup.getEntityPage().setRowsPerPage(totalSize);
			super.entityPageHandler(userGroup.getEntityPage(), totalSize);
			List<UserGroup> userGroupList = userGroupService.queryUserGroupListByPage(userGroup);
			String userId = user.getUserId();
			if (null != userId && !"".equals(userId)) {
				UserGroup ug = new UserGroup();
				ug.setUserId(userId);
				List<UserGroup> isUserdGroupList = userGroupService.queryUserGroupLinkList(ug);
				if (null != isUserdGroupList && isUserdGroupList.size() > 0) {
					for (int t = 0; t < userGroupList.size(); t++) {
						UserGroup userGroup1 = userGroupList.get(t);
						String userGroupId = userGroup1.getUserGroupId();
						for (int k = 0; k < isUserdGroupList.size(); k++) {
							UserGroup userGroup2 = isUserdGroupList.get(k);
							if (userGroupId.equals(userGroup2.getUserGroupId())) {
								userGroup1.setIdUsed("1");
								break;
							}
						}
					}
				}
			}
			Role r = new Role();
			List<Role> roleList = roleService.queryRoleList(r);

			view = new ModelAndView("user/bindUserGroup");
			view.addObject("userGroupList", userGroupList);
			view.addObject("roleList", roleList);
			view.addObject("user", user);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 绑定用户组
	 *
	 * @param userGroup
	 * @return
	 */
	// @RequiresPermissions({ "bindUsergroup" })
	@RequestMapping(value = "/binkUserGroupLink")
	public void binkUserGroupLink(UserGroup userGroup, String checkedGroupIds, HttpServletRequest request, HttpServletResponse response) {
		String resultCode = "0";// 0:失败 1：成功
		try {
			PrintWriter out = response.getWriter();
			User u = new User();
			u.setUserId(userGroup.getUserId());
			u = userService.displayUser(u);
			if (null == u) {
				resultCode = "0";
				out.print(resultCode);
				out.flush();
				out.close();
				return;
			}
			StringBuffer stringBuffer = new StringBuffer();
			if (null == checkedGroupIds || "".equals(checkedGroupIds)) {
				List<UserGroup> isUserdGroupList = userGroupService.queryUserGroupLinkList(userGroup);
				if (null == isUserdGroupList || isUserdGroupList.size() < 1) {
					resultCode = "2";
				} else {
					userGroupService.deleteUserGroupLink(userGroup);
					stringBuffer.append("删除登录名为" + u.getUserLoginName() + "绑定的角色：");
					for (int i = 0; i < isUserdGroupList.size(); i++) {
						UserGroup ug = isUserdGroupList.get(i);
						if ((i + 1) == isUserdGroupList.size()) {
							stringBuffer.append(ug.getUserGroupName());
						} else {
							stringBuffer.append(ug.getUserGroupName() + "、");
						}
					}
					pubUserLogService.createUserLog(request, "修改管理员", "1", stringBuffer.toString());
					resultCode = "1";
				}
				out.print(resultCode);
				out.flush();
				out.close();
				return;
			}
			String[] groupIds = checkedGroupIds.split(",");
			if (groupIds.length > 0) {
				List<UserGroup> isUserdGroupList = userGroupService.queryUserGroupLinkList(userGroup);
				List<String> groupIdList = new ArrayList<String>();
				Collections.addAll(groupIdList, groupIds);
				userGroupService.deleteUserGroupLink(userGroup);
				if (isUserdGroupList.size() > 0) {
					stringBuffer.append("修改登录名为" + u.getUserLoginName() + "绑定的角色，原始已绑定角色：");
					for (int j = 0; j < isUserdGroupList.size(); j++) {
						UserGroup ug1 = isUserdGroupList.get(j);
						if ((j + 1) == isUserdGroupList.size()) {
							stringBuffer.append(ug1.getUserGroupName());
						} else {
							stringBuffer.append(ug1.getUserGroupName() + "、");
						}
					}
					stringBuffer.append(",新角色：");
				} else {
					stringBuffer.append("新增登录名为" + u.getUserLoginName() + "绑定的角色：");
				}
				for (int i = 0; i < groupIdList.size(); i++) {
					userGroup.setUserGroupId(groupIdList.get(i));
					userGroupService.insertUserGroupLink(userGroup);
					UserGroup selectUserGroup = userGroupService.displayUserGroup(userGroup);
					if ((i + 1) == groupIdList.size()) {
						stringBuffer.append(selectUserGroup.getUserGroupName());
					} else {
						stringBuffer.append(selectUserGroup.getUserGroupName() + "、");
					}
				}
				pubUserLogService.createUserLog(request, "修改管理员", "1", stringBuffer.toString());
				resultCode = "1";
			} else {
				resultCode = "0";
			}
			out.print(resultCode);
			out.flush();
			out.close();
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	// @RequiresPermissions({ "lockUser" })
	@RequestMapping(value = "/lockUser")
	public ModelAndView lockUser(User user, String type, HttpServletRequest request) {
		ModelAndView view = null;
		try {
			if (null == user || null == user.getUserId() || "".equals(user.getUserId())) {
				view = new ModelAndView("error");
				return view;
			}
			user = userService.displayUser(user);
			if (null == user) {
				view = new ModelAndView("error");
				return view;
			}
			user.setUserLocked(type);
			String operationContext = null;
			String operationName = null;
			if ("1".equals(type)) {
				operationName = "锁定管理员";
				user.setUserLockTime(System.currentTimeMillis() + "");
				operationContext = "锁定登录名为" + user.getUserLoginName() + "的用户  成功";
			} else {
				operationName = "解锁管理员";
				operationContext = "解锁登录名为" + user.getUserLoginName() + "的用户  成功";
			}
			userService.updateUser(user);
			pubUserLogService.createUserLog(request, operationName, "1", operationContext);
			view = new ModelAndView("success");
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	// @RequiresPermissions({ "viewUser" })
	@RequestMapping(value = "/toQuerySysUserDetail")
	public ModelAndView toQuerySysUserDetail(User user, HttpServletRequest request) {
		ModelAndView view = null;
		try {
			user = userService.displayUser(user);
			if (null == user) {
				view = new ModelAndView("error");
				return view;
			}
			Role role = new Role();
			List<Role> roleList = roleService.queryRoleList(role);

			UserGroup ug = new UserGroup();
			ug.setUserId(user.getUserId());
			List<UserGroup> isUserdGroupList = userGroupService.queryUserGroupLinkList(ug);

			view = new ModelAndView("user/querySysUserDetail");
			view.addObject("user", user);
			view.addObject("roleList", roleList);
			view.addObject("userGroupList", isUserdGroupList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 无权限访问跳转
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/unauthorized")
	public ModelAndView unauthorized(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("unauthorized");

		return view;
	}

	/**
	 * 重新登陆跳转
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/relogin")
	public ModelAndView relogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("relogin");

		return view;
	}

	/**
	 * 重新登陆跳转
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/test")
	public void test(HttpServletRequest request, HttpServletResponse response) {
		scheduled.closeOrderExpress();
		scheduled.closeOrder();
	}

	/**
	 * 非平台用户管理
	 * 
	 * @author wzd
	 * @date 2019年11月16日 下午7:27:03
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/queryUserListForType")
	public ModelAndView queryUserListForType(User user, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (user.getEntityPage() == null) {
				user.setEntityPage(new EntityPage());
				user.getEntityPage().setSortField("F_UPDATETIME");
				user.getEntityPage().setSortOrder("DESC");
			}

			if (user.getType() == null && "".equals(user.getType())) {
				user.setType("0");
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(user.getEntityPage()), super.getPageSize(user.getEntityPage()));
			List<User> userList = userService.queryUserListByType(user);
			PageInfo<User> pageInfo = new PageInfo<User>(userList);

			if (user.getType().equals("0")) {
				view = new ModelAndView("user/queryUserListForTypeWx");
			} else {
				view = new ModelAndView("user/queryUserListForTypePc");
			}

			view.addObject("user", user);
			view.addObject("userList", userList);
			view.addObject("entityPage", user.getEntityPage());
			view.addObject("pageInfo", pageInfo);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}
}

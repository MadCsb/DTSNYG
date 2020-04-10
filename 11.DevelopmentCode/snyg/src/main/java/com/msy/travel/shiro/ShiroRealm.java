package com.msy.travel.shiro;

import com.msy.travel.common.EntityPage;
import com.msy.travel.pojo.RoleData;
import com.msy.travel.service.RoleDataService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import com.msy.travel.common.ResourceCommon;
import com.msy.travel.pojo.Menu;
import com.msy.travel.pojo.MenuButton;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IMenuButtonService;
import com.msy.travel.service.IMenuService;
import com.msy.travel.service.IUserService;

public class ShiroRealm extends AuthorizingRealm {

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Resource(name = "roleDataServiceImpl")
	private RoleDataService roleDataService;

	@Resource(name = "menuServiceImpl")
	private IMenuService menuService;

	@Resource(name = "menuButtonServiceImpl")
	private IMenuButtonService menuButtonService;

	@Resource(name = "cacheManager")
	private EhCacheManager cacheManager;

	private Cache<String, AtomicInteger> passwordRetryCache;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		RoleData roleData = (RoleData) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		// 暂不使用用户组权限
		// HashSet<String> roleList = new HashSet<String>();
		// authorizationInfo.setRoles(roleList);

		List<MenuButton> menuButtonList = new ArrayList<MenuButton>();
		try {
			menuButtonList = menuButtonService.queryMenubuttonListByUserId(roleData.getUserId());
		} catch (Exception e) {

		}

		if (!(menuButtonList != null && menuButtonList.size() > 0)) {
			return authorizationInfo;
		}

		HashSet<String> permissList = new HashSet<String>();
		for (MenuButton menuButton : menuButtonList) {
			permissList.add(menuButton.getMenuButtonTag());
		}
		authorizationInfo.setStringPermissions(permissList);
		return authorizationInfo;
	}

	/**
	 * 用户登陆 认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordRoledataToken usernamePasswordRoledataToken = (UsernamePasswordRoledataToken)token;
		RoleData roleData = usernamePasswordRoledataToken.getRoleData();
		roleData.setUserPwd(null);

		// 判断 登录方式/角色类型/用户名 是否存在
		List<RoleData> roleDataList = null;
		try {
			EntityPage entityPage = new EntityPage(); //相同用户 相同角色类型 相同unit下 排序
			entityPage.setSortField("t.F_ISDEFAULT");
			entityPage.setSortOrder("DESC");
			roleData.setEntityPage(entityPage);
			roleDataList = roleDataService.queryRoleDataList(roleData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (roleDataList != null && roleDataList.size() > 0) {
			roleData = roleDataList.get(0);
		} else {
			roleData = null;
		}
		if (roleData == null) {
			throw new AuthenticationException("用户不存在");
		}else if (!"1".equals(roleData.getUserState())) {
			throw new AuthenticationException("帐号已失效");
		} else if (!"0".equals(roleData.getUserLocked())) {
			throw new AuthenticationException("帐号已锁定");
		}

		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(roleData,
				roleData.getUserPwd().toCharArray(), getName() // realm name
		);

		return authenticationInfo;
	}

	/**
	 * 重写密码验证方法
	 */
	@Override
	protected void assertCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) throws AuthenticationException {

		String submittedPassword = new String((char[]) token.getCredentials());
		String storedCredentials = new String((char[]) info.getCredentials());

		if (passwordRetryCache == null) {
			passwordRetryCache = cacheManager.getCache("passwordRetryCache");
		}
		RoleData roleData = (RoleData) info.getPrincipals().getPrimaryPrincipal();
		String userLoginName = roleData.getUserLoginName();
		AtomicInteger retryCount = passwordRetryCache.get(userLoginName);

		if (retryCount == null) {
			retryCount = new AtomicInteger(1);
			passwordRetryCache.put(userLoginName, retryCount);
		}
		if (retryCount.get() > 5) {
			// if retry count > 5 throw
			throw new ExcessiveAttemptsException("登录失败多次，账户锁定10分钟");
		}
		if (!submittedPassword.equals(storedCredentials)) {
			retryCount.incrementAndGet();
			throw new IncorrectCredentialsException("用户名或密码错误.");
		}

		if (passwordRetryCache != null) {
			passwordRetryCache.remove(userLoginName);
		}

		// 获取用户菜单
		Menu menu = new Menu();
		menu.setUserId(roleData.getUserId());
		menu.setRoleType(roleData.getRoleType());
		try {
			List<Menu> menuList = menuService.getListByUserIdAndRoletype(menu);
			setSession(ResourceCommon.LOGIN_USER_MENU, menuList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		User user = new User();
		try {
			user.setUserId(roleData.getUserId());
			user = userService.displayUser(user);
			user.setAccId(roleData.getAccId());
			user.setUnitId(roleData.getUnitId());
			user.setUserRoleType(roleData.getRoleType());
			user.setRoleData(roleData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSession(ResourceCommon.LOGIN_USER, user);
	}

	/**
	 * 保存session
	 */
	private void setSession(Object key, Object value) {
		Session session = getSession();
		// System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
		if (null != session) {
			session.setAttribute(key, value);
		}
	}

	/**
	 * 获取session
	 */
	private Session getSession() {
		try {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null) {
				session = subject.getSession();
			}
			if (session != null) {
				return session;
			}
		} catch (InvalidSessionException e) {

		}
		return null;
	}

	/**
	 * 清空当前用户权限信息
	 */
	public void clearCachedAuthorizationInfo() {
		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 指定principalCollection 清除
	 */
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 
	 * 单一登陆处理 相同用户只能登陆一次
	 */
	public void clearSameUserSession(String username) {

		// 处理session
		DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
		DefaultWebSessionManager sessionManager = (DefaultWebSessionManager) securityManager.getSessionManager();
		Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();// 获取当前已登录的用户session列表

		User user;
		for (Session session : sessions) {
			// 清除该用户以前登录时保存的session
			user = (User) session.getAttribute(ResourceCommon.LOGIN_USER);
			// 用户名相同并且sessionId不同时 清除
			if (user != null && username.equals(user.getUserLoginName()) && !(getSession().getId().equals(session.getId()))) {
				sessionManager.getSessionDAO().delete(session);
			}
		}
	}
}
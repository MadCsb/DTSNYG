package com.msy.travel.shiro;

import com.msy.travel.common.BaseController;
import java.net.URLEncoder;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.msy.travel.common.Consts;
import com.msy.travel.common.ResourceCommon;

public class SessionFilter extends AccessControlFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object object) throws Exception {

		HttpServletRequest httpRequest = ((HttpServletRequest) request);
		String url = httpRequest.getRequestURI();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;application/json");
		// 微信链接、微信图片
		if (url.indexOf("/logout") != -1 || url.indexOf("/wx/core") != -1 || url.indexOf("/wx.do") != -1 || url.indexOf("/" + Consts.WX_PIC_FOLDER_NAME + "/") != -1 || url.indexOf("/wx/") != -1
				|| url.indexOf("/wxAfterPay") != -1 || url.indexOf("/api") != -1 || url.indexOf("/loginApi") != -1 || url.indexOf("/wx") != -1 || url.indexOf("/pay") != -1
				|| url.indexOf("/city") != -1) {
			return Boolean.TRUE;
		}
		// web 端无需登录controller
		if (url.indexOf("/webIndex") != -1 || url.indexOf("/toNewUser") != -1 || url.indexOf("/toArticleContext") != -1 || url.indexOf("/newUser") != -1 || url.indexOf("/webArticle") != -1
				|| url.indexOf("/webCommproduct") != -1 || url.indexOf("/webPdcType") != -1 || url.indexOf("/webPrice1Ref") != -1 || url.indexOf("/webSellPrice") != -1) {
			return Boolean.TRUE;
		}

		// wap 端无需登录controller
		if (url.indexOf("/toNewUser") != -1 || url.indexOf("/newUser") != -1 || url.indexOf("/wapCommproduct") != -1 || url.indexOf("/wapCoupon") != -1 || url.indexOf("/wapPdcType") != -1
				|| url.indexOf("/wapPrice1Ref") != -1 || url.indexOf("/wapSellPrice") != -1 || url.indexOf("/wapIndex") != -1) {
			return Boolean.TRUE;
		}

		Subject subject = getSubject(request, response);
		Session session = subject.getSession(false);
		if (session == null || session.getAttribute(ResourceCommon.LOGIN_USER) == null) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

		HttpServletRequest httpRequest = ((HttpServletRequest) request);
		String url = httpRequest.getRequestURI();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;application/json");

		String redictUrl = URLEncoder.encode(BaseController.getCurrentUrlStr(httpRequest), "UTF-8");
		// 先退出
		Subject subject = getSubject(request, response);
		subject.logout();
		if (url.indexOf("/" + Consts.LOGIN_PAGE_WEB) != -1) {
			WebUtils.issueRedirect(request, response, "/relogin?loginPage=" + Consts.LOGIN_PAGE_WEB+"&redictUrl="+redictUrl);
		} else if (url.indexOf("/" + Consts.LOGIN_PAGE_WAP) != -1) {
			WebUtils.issueRedirect(request, response, "/relogin?loginPage=" + Consts.LOGIN_PAGE_WAP+"&redictUrl="+redictUrl);
		} else {
			WebUtils.issueRedirect(request, response, "/relogin?loginPage=" + Consts.LOGIN_PAGE_MP+"&redictUrl="+redictUrl);
		}
		// 再重定向

		return false;

	}

}

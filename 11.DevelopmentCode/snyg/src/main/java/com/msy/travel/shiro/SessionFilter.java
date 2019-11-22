package com.msy.travel.shiro;

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
				|| url.indexOf("/wxAfterPay") != -1 || url.indexOf("/api") != -1 || url.indexOf("/loginApi") != -1 || url.indexOf("/wx") != -1 || url.indexOf("/pay") != -1) {
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

		// 先退出
		Subject subject = getSubject(request, response);
		subject.logout();
		// 再重定向
		WebUtils.issueRedirect(request, response, "/relogin");
		return false;

	}

}

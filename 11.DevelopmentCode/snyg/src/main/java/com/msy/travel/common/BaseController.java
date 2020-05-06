package com.msy.travel.common;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.Map;

import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IUserService;
import com.msy.travel.wx.utils.WeixinUtil;

public class BaseController {


	/**
	 * ?
	 */
	private static final String SIGN_1 = "?";

	/**
	 * &
	 */
	private static final String SIGN_2 = "&";

	/**
	 * =
	 */
	private static final String SIGN_3 = "=";

	/**
	 * "/"
	 */
	private static final String SIGN_4 = "/";

	public static final Log log = LogFactory.getLog(BaseController.class);

	/**
	 * 处理分页参数
	 * 
	 * @param entityPage
	 *            分页对象
	 * @param totleSize
	 *            记录总条数
	 * @throws Exception
	 */
	protected void entityPageHandler(EntityPage entityPage, int totleSize) throws Exception {

		// 如果当前页数小于1 则将当前页数设置为1
		if (entityPage.getCurrentPage() < 1) {
			entityPage.setCurrentPage(1);
		}

		// 如果每页显示条数为0 则设置为1
		if (entityPage.getRowsPerPage() == 0) {
			entityPage.setRowsPerPage(1);
		}

		// 设置数据总条数
		entityPage.setTotalSize(totleSize);

		// 计算总页数
		int rowsPerPage = entityPage.getRowsPerPage();
		int total = entityPage.getTotalSize();
		int pages = total % rowsPerPage > 0 ? total / rowsPerPage + 1 : total / rowsPerPage;

		// 如果当前页数大于总页数 则将当前页数设置为总页数
		if (entityPage.getCurrentPage() > pages) {
			entityPage.setCurrentPage(pages);
		}
		if (entityPage.getCurrentPage() == 0) {
			entityPage.setCurrentPage(1);
		}
		// 设置总页数
		entityPage.setTotalPages(pages);

		// 计算当前页开始位置 （当前页数-1）*每页显示数据条数
		entityPage.setPageBegin((entityPage.getCurrentPage() - 1) * entityPage.getRowsPerPage());

		// 计算当前页结束位置 开始位置+每页显示数据条数
		entityPage.setPageEnd(entityPage.getPageBegin() + entityPage.getRowsPerPage());
	}

	/**
	 * 获取当前页数
	 * 
	 * @author yf-wanghuan
	 * @date 2017年8月2日 下午2:45:23
	 * @param entityPage
	 * @return
	 * @return int
	 */
	protected int getPageNum(EntityPage entityPage) {

		// 如果当前页数小于1 则将当前页数设置为1
		if (entityPage.getCurrentPage() < 1) {
			entityPage.setCurrentPage(1);
		}

		return entityPage.getCurrentPage();
	}

	/**
	 * 获取每页显示数据条数
	 * 
	 * @author yf-wanghuan
	 * @date 2017年8月2日 下午2:46:20
	 * @param entityPage
	 * @return
	 * @return int
	 */
	protected int getPageSize(EntityPage entityPage) {

		// 如果每页显示条数为0 则设置为1
		if (entityPage.getRowsPerPage() == 0) {
			entityPage.setRowsPerPage(1);
		}

		return entityPage.getRowsPerPage();
	}

	/**
	 * 获取当前登陆用户对象
	 * 
	 * @param request
	 * @return
	 */
	protected User getLoginUser(HttpServletRequest request) {

		return (User) request.getSession().getAttribute(ResourceCommon.LOGIN_USER);

	}

	/**
	 * 保存当前页面的访问的URL
	 * 
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	protected void saveBackUrl(HttpServletRequest request) throws Exception {

		StringBuffer backUrl = new StringBuffer();
		backUrl.append(request.getRequestURI());

		Map<String, String[]> paramMap = request.getParameterMap();

		if (paramMap != null && paramMap.size() > 0) {

			backUrl.append("?");

			for (String param : paramMap.keySet()) {

				backUrl.append("&");
				backUrl.append(param);
				backUrl.append("=");
				backUrl.append(request.getParameter(param));
			}
		}

		saveBackUrl(request, backUrl.toString().replaceFirst("&", ""));
	}

	/**
	 * 保存自定义页面的访问的URL
	 * 
	 * @param request
	 */
	protected void saveBackUrl(HttpServletRequest request, String url) throws Exception {

		request.getSession().setAttribute(ResourceCommon.BACK_URL, url);
	}

	/**
	 * 文件下载
	 * 
	 * @author whn
	 * @date 2015年9月18日 下午2:08:21
	 * @param request
	 * @param response
	 * @param filePath
	 *            下载文件具体路径 如 c:/data.txt
	 * @param displayName
	 *            现在展示的文件名带扩展名 如 11.txt
	 * @return void
	 * 
	 *         调用事例: downloadFile(request, response, "c://data.txt", "111.txt");
	 */
	public void downloadFile(HttpServletRequest request, HttpServletResponse response, String filePath, String displayName) {

		// 设置为下载application/x-download
		response.setContentType("application/x-download");

		// 中文编码转换
		try {
			displayName = new String(displayName.getBytes("GBK"), "iso-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.addHeader("Content-Disposition", "attachment;filename=" + displayName);
		try {
			java.io.OutputStream os = response.getOutputStream();
			java.io.FileInputStream fis = new java.io.FileInputStream(filePath);
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = fis.read(b)) > 0) {
				os.write(b, 0, i);
			}
			fis.close();
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取异常详细信息字符串
	 * 
	 * @author yf-wanghuan
	 * @date 2016年12月19日 下午1:35:53
	 * @param e
	 * @return
	 * @return String
	 */
	public static String getExceptionInfo(Exception e) {
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			return sw.toString();
		} catch (Exception e2) {
			return e.getMessage();
		}
	}

	/**
	 * 获取访问URL
	 * 
	 * @author Gengb
	 * @date 2018年8月7日 上午9:12:01
	 * @param request
	 * @throws Exception
	 * @return String
	 */
	protected String getAccessUrl(HttpServletRequest request) throws Exception {

		StringBuffer backUrl = new StringBuffer();
		backUrl.append(request.getRequestURI());

		Map<String, String[]> paramMap = request.getParameterMap();

		if (paramMap != null && paramMap.size() > 0) {

			backUrl.append("?");

			for (String param : paramMap.keySet()) {

				if (!"code".equals(param) && !"state".equals(param)) {
					backUrl.append("&");
					backUrl.append(param);
					backUrl.append("=");
					backUrl.append(URLEncoder.encode(request.getParameter(param), "UTF-8"));
				}

			}
		}

		return backUrl.toString().replaceFirst("&", "");
	}

	/**
	 * 微信设置view object对象
	 *
	 */
	public void wxSetViewObjects(ModelAndView view, HttpServletRequest request, ServiceCode serviceCode, IUserService userService) throws Exception {
		String code = request.getParameter("code");// 微信回调获取 openId

		if (code == null || "".equals(code)) {
			// 分享进入
			String wxUrl = WeixinUtil.getWxAuthorizeUrl(serviceCode.getAppId(), serviceCode.getUrl() + trimSperatro(this.getAccessUrl(request), "/"));
			view.setViewName("redirect:" + wxUrl);
		} else {
			// 刷新
			String userId = PrimaryKeyUtil.getUserIdByCode(code);
			if (userId != null) {
				User u = new User();
				u.setUserId(userId);
				u = userService.displayUser(u);
				view.addObject("user", u);
			} else {
				User u = userService.getOrCreateByUserLoginName(Destsp.currentSpId, code,getLoginUser(request));
				view.addObject("user", u);
				PrimaryKeyUtil.setUserIdByCode(code, u.getUserId());
			}
		}
	}

	/**
	 * 去掉url中最前边的字符
	 * 
	 * @param url
	 * @return
	 */
	private String trimSperatro(String url, String replace) {
		while (url.indexOf(replace) == 0) {
			url = url.substring(replace.length());
		}
		return url;
	}


	/**
	 * 获取当前完整URL地址
	 *
	 * @return
	 */
	public static String getCurrentUrlStr(HttpServletRequest request) {

		StringBuffer url = new StringBuffer();

		request.getRequestURI().toLowerCase();

		// getServletPath与getRequestURI 区别在于项目名
		// /toWxJsApi.action
		// /qner/toWxJsApi.action
		url.append(request.getServletPath());

		Map<String, String[]> tm = request.getParameterMap();
		TreeMap<String, String> paramMap = new TreeMap<String, String>();

		if (tm != null && tm.size() > 0) {

			for (Map.Entry<String, String[]> entry : tm.entrySet()) {

				paramMap.put(entry.getKey(), request.getParameter(entry.getKey()));
			}
		}

		if (null != paramMap && paramMap.size() > 0) {
			url.append(SIGN_1);

			int index = 0;

			for (String paramName : paramMap.keySet()) {

				if ("CODE".equals(paramName.toUpperCase()) || "STATE".equals(paramName.toUpperCase()) || "FROM".equals(paramName.toUpperCase()) || "ISAPPINSTALLED".equals(paramName.toUpperCase())) {
					continue;
				} else {
					if (index == 0) {
						index = 1;
					} else {
						url.append(SIGN_2);
					}
				}
				url.append(paramName + SIGN_3 + request.getParameter(paramName));
			}
		}

		String reurl = url.toString();
		String append = "&";

		if (null != request.getParameter("code") && !"".equals(request.getParameter("code"))) {
			if ("?".equals(reurl.substring(reurl.length() - 1))) {
				reurl += "code=" + request.getParameter("code");
			} else {
				reurl += append + "code=" + request.getParameter("code");
			}
		}

		if (null != request.getParameter("state") && !"".equals(request.getParameter("state"))) {
			if ("?".equals(reurl.substring(reurl.length() - 1))) {
				reurl += "state=" + request.getParameter("state");
			} else {
				reurl += append + "state=" + request.getParameter("state");
			}
		}

		if (null != request.getParameter("from") && !"".equals(request.getParameter("from"))) {
			if ("?".equals(reurl.substring(reurl.length() - 1))) {
				reurl += "from=" + request.getParameter("from");
			} else {
				reurl += append + "from=" + request.getParameter("from");
			}
		}

		if (null != request.getParameter("isappinstalled") && !"".equals(request.getParameter("isappinstalled"))) {
			if ("?".equals(reurl.substring(reurl.length() - 1))) {
				reurl += "isappinstalled=" + request.getParameter("isappinstalled");
			} else {
				reurl += append + "isappinstalled=" + request.getParameter("isappinstalled");
			}
		}

		return reurl;
	}
}

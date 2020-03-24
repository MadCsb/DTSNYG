package com.msy.travel.wap.controller;

import com.msy.travel.common.BaseController;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wappersonal")
public class WapPersonalController extends BaseController {
	public static final Log log = LogFactory.getLog(WapPersonalController.class);

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Resource(name = "destspServiceImpl")
	private IDestspService destspService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	/**
	 * 获取当前微信用户通过OpenId
	 * 
	 * @param userId
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "method=getUserByUserId")
	public void getUserByUserId(String userId, HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = new User();
			user.setUserId(userId);
			user = userService.displayUser(user);
			response.setContentType("text/plain");
			response.setContentType("application/json");
			response.getWriter().write(net.sf.json.JSONObject.fromObject(user).toString());
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * 进入微信个人中心
	 * 
	 * @return
	 */
	@RequestMapping(params = "method=toPersonal")
	public ModelAndView toPersonal(HttpServletRequest request) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("wx/personal/personal");
			ServiceCode serviceCode = serviceCodeService.getServiceCodeBySpId(Destsp.currentSpId);
			wxSetViewObjects(view, request,serviceCode,userService);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

}

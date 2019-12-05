package com.msy.travel.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.msy.travel.common.BaseController;
import com.msy.travel.service.CarouselItemService;
import com.msy.travel.service.CarouselService;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IUserService;

/**
 * 微信首页
 * 
 * @author Gengb
 * @date 2018年7月19日 上午10:57:02
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/webIndex")
public class WebIndexController extends BaseController {
	public static final Log log = LogFactory.getLog(WebIndexController.class);
	@Resource(name = "destspServiceImpl")
	private IDestspService destspService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Resource(name = "carouselServiceImpl")
	private CarouselService carouselService;

	@Resource(name = "carouselItemServiceImpl")
	private CarouselItemService carouselItemService;

	@RequestMapping(params = "method=webIndex")
	public ModelAndView wxIndex(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("web/index");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

}

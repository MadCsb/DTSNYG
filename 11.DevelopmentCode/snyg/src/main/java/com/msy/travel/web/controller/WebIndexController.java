package com.msy.travel.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.pojo.Carousel;
import com.msy.travel.pojo.CarouselItem;
import com.msy.travel.pojo.User;
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

	/**
	 * 首页
	 * 
	 * @author wzd
	 * @date 2019年12月7日 下午12:59:52
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=webIndex")
	public ModelAndView wxIndex(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("web/index");

			String currentDay = DateTimeUtil.getDateTime10();

			view.addObject("currentDay", currentDay);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 广告
	 * 
	 * @author wzd
	 * @date 2019年12月7日 下午12:59:58
	 * @param carousel
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=wxAjaxCarouselDetail")
	public void wxAjaxCarouselDetail(Carousel carousel, HttpServletRequest request, HttpServletResponse response) {
		List<CarouselItem> carouselItemList = new ArrayList<>();
		try {
			carousel = carouselService.displayCarousel(carousel);
			CarouselItem carouselItem = new CarouselItem();
			carouselItem.setCarouselId(carousel.getCarouselId());
			EntityPage entityPage = new EntityPage();
			entityPage.setSortField("t.F_SEQNUM");
			entityPage.setSortOrder("ASC");
			carouselItem.setEntityPage(entityPage);

			carouselItemList = carouselItemService.queryCarouselItemList(carouselItem);
		} catch (Exception e) {
			log.error(e);
		}
		try {
			response.setContentType("text/json;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(JSON.toJSONString(carouselItemList));
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * 是否登录
	 * 
	 * @author wzd
	 * @date 2020年5月16日 上午9:57:12
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=checkLogin")
	public void checkLogin(HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = getLoginUser(request);
			if (user != null && user.getUserId() != null) {
				response.getWriter().print("1");
			} else {
				response.getWriter().print("0");
			}
		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

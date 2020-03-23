package com.msy.travel.wx.controller;

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
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.service.CarouselItemService;
import com.msy.travel.service.CarouselService;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;

/**
 * 微信首页
 * 
 * @author Gengb
 * @date 2018年7月19日 上午10:57:02
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wx")
public class WxIndexController extends BaseController {
	public static final Log log = LogFactory.getLog(WxIndexController.class);
	@Resource(name = "destspServiceImpl")
	private IDestspService destspService;

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Resource(name = "carouselServiceImpl")
	private CarouselService carouselService;

	@Resource(name = "carouselItemServiceImpl")
	private CarouselItemService carouselItemService;

	@RequestMapping(params = "method=wxIndex")
	public ModelAndView wxIndex(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			ServiceCode serviceCode = serviceCodeService.getServiceCodeBySpId(Destsp.currentSpId);

			String currentDay = DateTimeUtil.getDateTime10();
			view = new ModelAndView("wx/index");

			wxSetViewObjects(view, request, serviceCode, userService);

			// User user = new User();
			// user.setUserId("5cb674732c2f488f8bb1f3dc0b6fc8c0");
			// view.addObject("user", user);

			view.addObject("spId", Destsp.currentSpId);
			view.addObject("serviceCode", serviceCode);
			view.addObject("currentDay", currentDay);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * ajax 获取广告列表
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

}

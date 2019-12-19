package com.msy.travel.web.controller;

import com.alibaba.dubbo.common.URL;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.MD5;
import com.msy.travel.common.ResourceCommon;
import com.msy.travel.pojo.*;
import com.msy.travel.service.IArticleService;
import com.msy.travel.service.OrderService;
import com.msy.travel.service.ShopcartService;
import net.sf.json.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 微信web用户
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/webPersonal")
public class WebPersonalController extends BaseController {
	public static final Log log = LogFactory.getLog(WebPersonalController.class);

	@Resource(name = "orderServiceImpl")
	private OrderService orderService;

	@Resource(name = "shopcartServiceImpl")
	private ShopcartService shopcartService;

	/**
	 * 个人中心
	 *
	 * menuId 菜单ID
	 * url 直接跳转URL
	 * @return
	 */
	@RequestMapping(params = "method=personal")
	public ModelAndView personal(HttpServletRequest request, HttpServletResponse response,String menuId,String url) {
		ModelAndView view = null;
		try {
			if (url != null && !url.trim().equals(""))
			{
				url = URL.decode(url);
			}
			view = new ModelAndView("web/personal/personal");
			view.addObject("user",getLoginUser(request));
			view.addObject("url",url);
			view.addObject("menuId",menuId);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 个人中心
	 *
	 * @return
	 */
	@RequestMapping(params = "method=index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Order order = new Order();
			order.setEntityPage(new EntityPage());
			order.getEntityPage().setSortField("t.F_CREATETIME");
			order.getEntityPage().setSortOrder("DESC");
			order.setUserId(getLoginUser(request).getUserId());
			order.setPayTag("0");
			order.setBeforePayStatus("0");
			PageHelper.startPage(1, 10);
			List<Order> orderList = orderService.queryOrderList(order);
			PageInfo<Order> orderPageInfo = new PageInfo<Order>(orderList);

			Shopcart shopcart = new Shopcart();
			shopcart.setUserId(getLoginUser(request).getUserId());
			shopcart.setDelFlag("0");
			PageHelper.startPage(1, 10);
			List<Shopcart> shopcartList = shopcartService.queryShopcartList(shopcart);
			PageInfo<Shopcart> shopcartPageInfo = new PageInfo<Shopcart>(shopcartList);

			view = new ModelAndView("web/personal/index");
			view.addObject("orderList",orderList);
			view.addObject("shopcartList",shopcartList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

}

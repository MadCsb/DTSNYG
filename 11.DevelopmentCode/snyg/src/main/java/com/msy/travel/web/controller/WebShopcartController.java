package com.msy.travel.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msy.travel.common.BaseController;
import com.msy.travel.common.ResourceCommon;
import com.msy.travel.pojo.Shopcart;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.ShopcartService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/webShopcart")
public class WebShopcartController extends BaseController {
	public static final Log log = LogFactory.getLog(WebShopcartController.class);

	@Resource(name = "shopcartServiceImpl")
	private ShopcartService shopcartService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	/**
	 * pc端商品加入购物车
	 * 
	 * @author wzd
	 * @date 2019年12月5日 下午7:17:12
	 * @param shopcart
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=toAddOrUpdateShopCart")
	public void toAddOrUpdateShopCart(Shopcart shopcart, HttpServletRequest request, HttpServletResponse response) {
		try {

			if (request.getSession().getAttribute(ResourceCommon.LOGIN_USER) == null) {
				response.getWriter().print("nologin");
			} else {
				shopcart.setUserId(getLoginUser(request).getUserId());
				shopcartService.createOrUpdateShopcart(shopcart);
				response.getWriter().print("success");
			}
		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

package com.msy.travel.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msy.travel.common.BaseController;
import com.msy.travel.common.EntityPage;
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

	/**
	 * 获取购物车信息
	 * 
	 * @author wzd
	 * @date 2019年12月6日 下午4:17:09
	 * @param shopcart
	 * @param request
	 * @param response
	 * @param spId
	 * @param userId
	 * @return void
	 */
	@RequestMapping(params = "method=getShopCartListWeb")
	public void getShopCartListWeb(Shopcart shopcart, HttpServletRequest request, HttpServletResponse response, String spId, String userId) {
		try {
			// if (request.getSession().getAttribute(ResourceCommon.LOGIN_USER)
			// == null) {
			// response.getWriter().print("");
			// } else {
			shopcart = new Shopcart();
			shopcart.setUserId(getLoginUser(request).getUserId());
			shopcart.setUserId("d417d39463f34103bf376677a1db0fae");
			shopcart.setDelFlag("0");
			shopcart.setState("1");
			EntityPage en = new EntityPage();
			en.setSortOrder("DESC");
			en.setSortField("t.F_UPDATETIME");
			shopcart.setEntityPage(en);
			List<Shopcart> shopCartList = shopcartService.queryShopcartList(shopcart);
			JSONArray jsonArray = JSONArray.fromObject(shopCartList);
			response.getWriter().print(jsonArray.toString());
			// }
		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

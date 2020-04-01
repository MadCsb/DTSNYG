package com.msy.travel.wap.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.msy.travel.common.BaseController;
import com.msy.travel.common.EntityPage;
import com.msy.travel.pojo.Shopcart;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.ShopcartService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wapShopCart")
public class WapShopcartController extends BaseController {
	public static final Log log = LogFactory.getLog(WapShopcartController.class);

	@Resource(name = "shopcartServiceImpl")
	private ShopcartService shopcartService;

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	/**
	 * wap端 商品加入购物车
	 * 
	 * @author wzd
	 * @date 2019年10月15日 下午2:40:58
	 * @param shopcart
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=toAddOrUpdateShopCart")
	public void toAddOrUpdateShopCart(Shopcart shopcart, HttpServletRequest request, HttpServletResponse response) {
		try {
			shopcart.setUserId(getLoginUser(request).getUserId());
			shopcartService.createOrUpdateShopcart(shopcart);
			response.getWriter().print("success");
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 跳转到购物车列表
	 * 
	 * @author wzd
	 * @date 2019年10月20日 下午4:53:50
	 * @param shopcart
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=toQueryShopCartWx")
	public ModelAndView toQueryShopCartWx(Shopcart shopcart, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("wap/shopcart/queryShopcartWx");
			view.addObject("shopcart", shopcart);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 获取购物车里信息
	 * 
	 * @author wzd
	 * @date 2019年10月20日 下午5:15:44
	 * @param shopcart
	 * @param request
	 * @param response
	 * @param spId
	 * @param userId
	 * @return void
	 */
	@RequestMapping(params = "method=getShopCartListWx")
	public void getShopCartListWx(Shopcart shopcart, HttpServletRequest request, HttpServletResponse response, String spId, String userId) {
		try {
			shopcart.setUserId(getLoginUser(request).getUserId());
			shopcart.setDelFlag("0");
			shopcart.setState("1");
			EntityPage en = new EntityPage();
			en.setSortOrder("DESC");
			en.setSortField("t.F_UPDATETIME");
			shopcart.setEntityPage(en);
			List<Shopcart> shopCartList = shopcartService.queryShopcartList(shopcart);
			JSONArray jsonArray = JSONArray.fromObject(shopCartList);
			response.getWriter().print(jsonArray.toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 修改购物车数量
	 * 
	 * @author wzd
	 * @date 2019年10月20日 下午6:54:39
	 * @param shopcart
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=changeShopCartNum")
	public void changeShopCartNum(Shopcart shopcart, HttpServletRequest request, HttpServletResponse response) {
		try {
			shopcart.setUserId(getLoginUser(request).getUserId());
			String num = shopcart.getNum();
			shopcart = shopcartService.displayShopcart(shopcart);
			shopcart.setNum(num);
			shopcartService.updateShopcart(shopcart);
			response.getWriter().print("success");
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 获取购物车数量
	 * 
	 * @author wzd
	 * @date 2019年11月25日 下午1:27:06
	 * @param shopcart
	 * @param request
	 * @param response
	 * @param spId
	 * @param userId
	 * @return void
	 */
	@RequestMapping(params = "method=getShopCartListLength")
	public void getShopCartListLength(Shopcart shopcart, HttpServletRequest request, HttpServletResponse response, String spId, String userId) {
		try {
			shopcart.setUserId(getLoginUser(request).getUserId());
			shopcart.setDelFlag("0");
			EntityPage en = new EntityPage();
			en.setSortOrder("DESC");
			en.setSortField("t.F_UPDATETIME");
			shopcart.setEntityPage(en);
			shopcart.setState("1");
			List<Shopcart> shopCartList = shopcartService.queryShopcartList(shopcart);
			response.getWriter().print(shopCartList.size());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 修改购物车数量
	 * 
	 * @author wzd
	 * @date 2019年10月20日 下午6:54:39
	 * @param shopcart
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=deleteShopCart")
	public void deleteShopCart(Shopcart shopcart, HttpServletRequest request, HttpServletResponse response) {
		try {
			shopcart.setUserId(getLoginUser(request).getUserId());
			shopcart = shopcartService.displayShopcart(shopcart);
			shopcartService.deleteShopcart(shopcart);
			response.getWriter().print("success");
		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

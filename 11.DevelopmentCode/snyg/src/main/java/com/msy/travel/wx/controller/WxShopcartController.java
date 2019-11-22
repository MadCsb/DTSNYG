package com.msy.travel.wx.controller;

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
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.Shopcart;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.ShopcartService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wx")
public class WxShopcartController extends BaseController {
	public static final Log log = LogFactory.getLog(WxShopcartController.class);

	@Resource(name = "shopcartServiceImpl")
	private ShopcartService shopcartService;

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	/**
	 * 微信端 商品加入购物车
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

			view = new ModelAndView("wx/shopcart/queryShopcartWx");

			ServiceCode serviceCode = serviceCodeService.getServiceCodeBySpId(Destsp.currentSpId);
			wxSetViewObjects(view, request, serviceCode, userService);

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
			shopcart.setDelFlag("0");
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
			String num = shopcart.getNum();
			shopcart = shopcartService.displayShopcart(shopcart);
			shopcart.setNum(num);
			shopcartService.updateShopcart(shopcart);
			response.getWriter().print("success");
		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

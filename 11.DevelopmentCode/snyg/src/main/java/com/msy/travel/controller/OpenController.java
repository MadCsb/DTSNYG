package com.msy.travel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinamobile.sd.openapi.Common;
import com.msy.travel.common.*;
import com.msy.travel.pojo.*;
import com.msy.travel.service.ICityService;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.SellPriceService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msy.travel.shiro.UsernamePasswordRoledataToken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/open")
public class OpenController extends BaseController {
	public static final Log log = LogFactory.getLog(OpenController.class);

	@Resource(name = "cityServiceImpl")
	private ICityService cityService;

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;
	/**
	 * 跳转到产品详情
	 */
	@RequestMapping(value = "/{spId}/{priceCode}")
	public ModelAndView toSellPriceDetail(@PathVariable("spId") String spId,@PathVariable("priceCode") String priceCode, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("open/displaySellPrice");
			//判断是否通过山东移动进入
			String sdToken = request.getParameter("token");
			if (sdToken != null && !sdToken.equals("")) //如果存在token，表示是山东进来的
			{
				User user = userService.getOrCreateBySdToken(sdToken);

				RoleData loginRoleData = new RoleData();
				loginRoleData.setRoleType(RoleData.ROLE_TYPE_CHANNEL);
				loginRoleData.setAccId(Destsp.currentSpId);
				loginRoleData.setUserId(user.getUserId());
				UsernamePasswordRoledataToken token = new UsernamePasswordRoledataToken(user.getUserLoginName(), MD5.encode(user.getUserLoginName()), loginRoleData); //山东移动登录名=密码

				Subject subject = SecurityUtils.getSubject();
				subject.login(token);

				//进入详情具体的页面类型
				view.addObject("detailPage","WAP");
				view.addObject("userRoleDataId",getLoginUser(request).getRoleData().getUserRoleDataId());
			}

			//priceCode = "178";//正式需要注释

			SellPrice sellPrice = new SellPrice();
			sellPrice.setPriceCode(priceCode);
			sellPrice = sellPriceService.displaySellPrice(sellPrice);

			if (sellPrice == null)
			{
				throw new LogicException("未找到销售产品");
			}

			view.addObject("sellPrice",sellPrice);
			view.addObject("spId",spId);
		}catch (Exception e)
		{
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}
	/**
	 * 跳转到订单列表
	 */
	@RequestMapping(value = "/orderList")
	public ModelAndView toOrderListDetail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("open/displayOrderList");
			User user = null;
			//判断是否通过山东移动进入
			String sdToken = request.getParameter("token");
			if (sdToken != null && !sdToken.equals("")) //如果存在token，表示是山东进来的
			{
				user = userService.getOrCreateBySdToken(sdToken);

				RoleData loginRoleData = new RoleData();
				loginRoleData.setRoleType(RoleData.ROLE_TYPE_CHANNEL);
				loginRoleData.setAccId(Destsp.currentSpId);
				loginRoleData.setUserId(user.getUserId());
				UsernamePasswordRoledataToken token = new UsernamePasswordRoledataToken(user.getUserLoginName(), MD5.encode(user.getUserLoginName()), loginRoleData); //山东移动登录名=密码

				Subject subject = SecurityUtils.getSubject();
				subject.login(token);
				view.addObject("userRoleDataId",getLoginUser(request).getRoleData().getUserRoleDataId());
			}
		}catch (Exception e)
		{
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}
}

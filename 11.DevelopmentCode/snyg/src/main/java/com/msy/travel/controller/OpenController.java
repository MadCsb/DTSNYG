package com.msy.travel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinamobile.sd.openapi.Common;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.LogicException;
import com.msy.travel.common.Result;
import com.msy.travel.pojo.City;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.pojo.User;
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
@RequestMapping(value = "/open/{spId}")
public class OpenController extends BaseController {
	public static final Log log = LogFactory.getLog(OpenController.class);

	@Resource(name = "cityServiceImpl")
	private ICityService cityService;

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;
	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(value = "/{priceCode}")
	public ModelAndView toAddCity(@PathVariable("spId") String spId,@PathVariable("priceCode") String priceCode, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {


			SellPrice sellPrice = new SellPrice();
			sellPrice.setPriceCode(priceCode);
			sellPrice = sellPriceService.displaySellPrice(sellPrice);

			if (sellPrice == null)
			{
				throw new LogicException("未找到销售产品");
			}

			view = new ModelAndView("open/displaySellPrice");
			view.addObject("sellPrice",sellPrice);
			view.addObject("spId",spId);


			//判断是否通过山东移动进入
			String sdToken = request.getParameter("token");
			if (sdToken != null && !sdToken.equals("")) //如果存在token，表示是山东进来的
			{
				User user = userService.getOrCreateBySdToken(sdToken);
				String userPwd = null;
				if(user.getUserLoginName().length()>6)
				{
					userPwd = user.getUserLoginName().substring(0,6);
				}else
				{
					userPwd = "123456";
				}
				UsernamePasswordToken token = new UsernamePasswordToken(user.getUserLoginName(), userPwd);
				Subject subject = SecurityUtils.getSubject();
				subject.login(token);

				//进入详情具体的页面类型
				view.addObject("detailPage","wap");
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

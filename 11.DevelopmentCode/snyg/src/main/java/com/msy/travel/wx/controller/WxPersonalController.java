package com.msy.travel.wx.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.EntityPage;
import com.msy.travel.pojo.CustomerCoupon;
import com.msy.travel.service.CustomerCouponService;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wxpersonal")
public class WxPersonalController extends BaseController {
	public static final Log log = LogFactory.getLog(WxPersonalController.class);

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Resource(name = "destspServiceImpl")
	private IDestspService destspService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Resource(name = "customerCouponServiceImpl")
	private CustomerCouponService customerCouponService;

	/**
	 * 获取当前微信用户通过OpenId
	 * 
	 * @param userId
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "method=getUserByUserId")
	public void getUserByUserId(String userId, HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = new User();
			user.setUserId(userId);
			user = userService.displayUser(user);
			response.setContentType("text/plain");
			response.setContentType("application/json");
			response.getWriter().write(net.sf.json.JSONObject.fromObject(user).toString());
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * 进入微信个人中心
	 * 
	 * @return
	 */
	@RequestMapping(params = "method=toPersonal")
	public ModelAndView toPersonal(HttpServletRequest request) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("wx/personal/personal");
			ServiceCode serviceCode = serviceCodeService.getServiceCodeBySpId(Destsp.currentSpId);
			wxSetViewObjects(view, request,serviceCode,userService);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}


	/**
	 * 进入我的红包
	 *
	 * @return
	 */
	@RequestMapping(params = "method=toCustomerCoupon")
	public ModelAndView toCustomerCoupon(HttpServletRequest request) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("wx/personal/customerCoupon");
			ServiceCode serviceCode = serviceCodeService.getServiceCodeBySpId(Destsp.currentSpId);
			wxSetViewObjects(view, request,serviceCode,userService);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 进入我的红包
	 *
	 * @return
	 */
	@RequestMapping(params = "method=ajaxCustomerCouponList")
	public void ajaxCustomerCouponList(HttpServletRequest request,String userId,int pageNum,int pageSize,HttpServletResponse response ,CustomerCoupon customerCoupon) {
		List<CustomerCoupon> customerCouponList = null;
		try {
			customerCoupon.setEntityPage(new EntityPage());
			customerCoupon.getEntityPage().setCurrentPage(pageNum);
			customerCoupon.getEntityPage().setRowsPerPage(pageSize);
			PageHelper.startPage(super.getPageNum(customerCoupon.getEntityPage()), super.getPageSize(customerCoupon.getEntityPage()));
			customerCoupon.setCustomerCode(userId);
			customerCouponList = customerCouponService.queryCustomerCouponListByUserIdAndPriceId(customerCoupon,"");
			PageInfo<CustomerCoupon> pageInfo = new PageInfo<CustomerCoupon>(customerCouponList);
		}catch (Exception e)
		{
			log.error(e);
		}finally {
			try
			{
				response.getWriter().write(JSON.toJSONString(customerCouponList));
			}catch (Exception e)
			{
				log.error(e);
			}
		}
	}

}

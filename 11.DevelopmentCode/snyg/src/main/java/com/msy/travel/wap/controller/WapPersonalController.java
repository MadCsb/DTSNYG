package com.msy.travel.wap.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.CustomerCoupon;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.Order;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.service.CustomerCouponService;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
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

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wappersonal")
public class WapPersonalController extends BaseController {
	public static final Log log = LogFactory.getLog(WapPersonalController.class);

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
	 * 进入微信个人中心
	 * 
	 * @return
	 */
	@RequestMapping(params = "method=toPersonal")
	public ModelAndView toPersonal(HttpServletRequest request) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("wap/personal/personal");
			view.addObject("user",getLoginUser(request));
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
			view = new ModelAndView("wap/personal/customerCoupon");
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
	public void ajaxCustomerCouponList(HttpServletRequest request,int pageNum,int pageSize,HttpServletResponse response ,CustomerCoupon customerCoupon) {
		List<CustomerCoupon> customerCouponList = null;
		try {
			customerCoupon.setEntityPage(new EntityPage());
			customerCoupon.getEntityPage().setCurrentPage(pageNum);
			customerCoupon.getEntityPage().setRowsPerPage(pageSize);
			PageHelper.startPage(super.getPageNum(customerCoupon.getEntityPage()), super.getPageSize(customerCoupon.getEntityPage()));
			customerCoupon.setCustomerCode(getLoginUser(request).getUserId());
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

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

import com.msy.travel.common.BaseController;
import com.msy.travel.pojo.Coupon;
import com.msy.travel.service.CouponService;
import com.msy.travel.service.SaleTypeService;

/**
 * wap端优惠券
 * 
 * @author Gengb
 * @date 2018年7月19日 上午10:57:02
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wapCoupon")
public class WapCouponController extends BaseController {
	public static final Log log = LogFactory.getLog(WapCouponController.class);

	@Resource(name = "couponServiceImpl")
	private CouponService couponService;

	@Resource(name = "saleTypeServiceImpl")
	private SaleTypeService saleTypeService;

	/**
	 * 获取优惠券列表
	 * 
	 * @author wzd
	 * @date 2020年3月24日 下午7:45:09
	 * @param coupon
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=queryCouponList")
	public void queryCouponList(HttpServletRequest request, HttpServletResponse response, String priceId) {
		try {
			List<Coupon> couponList = couponService.queryCouponListByPriceId(getLoginUser(request), priceId);
			response.getWriter().print(JSONArray.fromObject(couponList).toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

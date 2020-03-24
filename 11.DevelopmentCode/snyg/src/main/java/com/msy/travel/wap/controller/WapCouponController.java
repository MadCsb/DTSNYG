package com.msy.travel.wap.controller;

import java.util.ArrayList;
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
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.ResourceCommon;
import com.msy.travel.pojo.Coupon;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.SaleType;
import com.msy.travel.pojo.User;
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
	public void queryCouponList(Coupon coupon, HttpServletRequest request, HttpServletResponse response, String priceType, String priceId) {
		try {
			boolean isLogin = false;

			User user = new User();

			if (request.getSession().getAttribute(ResourceCommon.LOGIN_USER) != null) {
				isLogin = true;
				user = getLoginUser(request);
			}

			if (coupon == null) {
				coupon = new Coupon();
			}
			coupon.setDelFlag("0");
			coupon.setSpId(Destsp.currentSpId);
			coupon.setCouponTag("1");
			coupon.setCrrObtainDate(DateTimeUtil.getDateTime10());
			if (isLogin) {
				coupon.setUserId(user.getUserId());
			}

			List<String> useCouponIdList = new ArrayList<String>();
			// 全部商品渠道
			useCouponIdList.add(Destsp.currentSpId);
			// 销售Id
			useCouponIdList.add(priceId);
			// 活动id
			SaleType saleType = new SaleType();
			saleType.setSaleTypeKey(priceType);
			saleType.setStatus("1");
			List<SaleType> saleTypeList = saleTypeService.querySaleTypeList(saleType);
			if (saleTypeList != null && saleTypeList.size() > 0) {
				useCouponIdList.add(saleTypeList.get(0).getSaleTypeId());
			}

			List<Coupon> couponList = new ArrayList<Coupon>();
			if (isLogin) {
				couponList = couponService.queryCouponListForSellPriceLogin(coupon);
			} else {
				couponList = couponService.queryCouponListForSellPriceNoLogin(coupon);
			}
			response.getWriter().print(JSONArray.fromObject(couponList).toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

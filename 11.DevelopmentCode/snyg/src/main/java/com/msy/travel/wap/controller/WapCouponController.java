package com.msy.travel.wap.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msy.travel.common.BaseController;
import com.msy.travel.pojo.Coupon;
import com.msy.travel.pojo.CouponProduction;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.SaleType;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.service.CouponProductionService;
import com.msy.travel.service.CouponService;
import com.msy.travel.service.SaleTypeService;
import com.msy.travel.service.SellPriceService;

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

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;

	@Resource(name = "couponProductionServiceImpl")
	private CouponProductionService couponProductionService;

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

	/**
	 * 券使用规则
	 * 
	 * @author wzd
	 * @date 2020年3月25日 下午1:05:07
	 * @param couponId
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=couponRuleAjax")
	public void couponRuleAjax(String couponId, HttpServletRequest request, HttpServletResponse response) {
		try {

			// 检索优惠券信息
			Coupon coupon = new Coupon();
			coupon.setCouponId(couponId);
			coupon = couponService.displayCoupon(coupon);

			StringBuffer goodsName = new StringBuffer();

			if ("2".equals(coupon.getCouponType())) {
				SellPrice sellPrice = new SellPrice();
				sellPrice.setCouponId(couponId);
				List<SellPrice> sellPriceList = sellPriceService.querySellPriceListForCouponByCouponId(sellPrice);

				for (SellPrice s : sellPriceList) {
					if (!goodsName.equals("") && goodsName.length() > 0) {
						goodsName.append("，");
					}
					if (!s.getPriceType().equals("0")) {
						goodsName.append(s.getSaleTypeName()).append("中").append(s.getProductName()).append("[").append(s.getPriceName()).append("]");
					} else {
						goodsName.append(s.getProductName()).append("[").append(s.getPriceName()).append("]");
					}
				}
			} else {
				CouponProduction c = new CouponProduction();
				c.setCouponId(coupon.getCouponId());
				c.setCouponType("0");
				List<CouponProduction> couponProductionList = couponProductionService.queryCouponProductionList(c);
				for (CouponProduction cp : couponProductionList) {
					if (goodsName.equals("")) {
						goodsName.append(",");
					}
					if (cp.getUseCouponId().equals(Destsp.currentSpId)) {
						goodsName.append("全部商品");
					} else {
						SaleType saleType = new SaleType();
						saleType.setSaleTypeId(cp.getUseCouponId());
						saleType = saleTypeService.displaySaleType(saleType);
						goodsName.append(saleType.getSaleTypeName());
					}
				}
			}

			// 返回
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("coupon", coupon);
			map.put("goodsName", goodsName.toString());

			JSONObject json = JSONObject.fromObject(map);
			try {
				response.getWriter().print(json.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

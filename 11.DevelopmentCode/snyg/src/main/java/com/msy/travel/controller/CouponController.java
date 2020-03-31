package com.msy.travel.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.common.Result;
import com.msy.travel.pojo.Coupon;
import com.msy.travel.pojo.CouponProduction;
import com.msy.travel.pojo.SaleType;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.pojo.User;
import com.msy.travel.service.CouponProductionService;
import com.msy.travel.service.CouponService;
import com.msy.travel.service.SaleTypeService;
import com.msy.travel.service.SellPriceService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/coupon")
public class CouponController extends BaseController {
	public static final Log log = LogFactory.getLog(CouponController.class);

	@Resource(name = "couponServiceImpl")
	private CouponService couponService;

	@Resource(name = "saleTypeServiceImpl")
	private SaleTypeService saleTypeService;

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;

	@Resource(name = "couponProductionServiceImpl")
	private CouponProductionService couponProductionService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddCoupon(Coupon coupon, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			SaleType saleType = new SaleType();
			saleType.setSpId(getLoginUser(request).getAccId());
			saleType.setStatus("1");
			List<SaleType> saleTypeList = saleTypeService.querySaleTypeListForCoupon(saleType);
			saleType = new SaleType();
			saleType.setSaleTypeId(getLoginUser(request).getAccId());
			saleType.setSaleTypeName("全部商品");
			saleTypeList.add(0, saleType);

			view = new ModelAndView("coupon/addCoupon");
			view.addObject("saleTypeList", saleTypeService.querySaleTypeListOrChannel(null, getLoginUser(request).getAccId()));
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增Coupon
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addCoupon(Coupon coupon, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			couponService.createCoupon(coupon, getLoginUser(request), request.getParameter("sellPriceIdList"));
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 跳转到修改页面
	 */
	@RequestMapping(params = "method=toUpdate")
	public ModelAndView toUpdateCoupon(Coupon coupon, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {

			view = new ModelAndView("coupon/updateCoupon");

			Coupon objCoupon = couponService.displayCoupon(coupon);

			if ("2".equals(objCoupon.getCouponType())) {
				SellPrice sellPrice = new SellPrice();
				sellPrice.setEntityPage(new EntityPage());
				sellPrice.getEntityPage().setSortField("p.F_SORTNUM ASC,p.F_PRODUCTNAME ASC");
				sellPrice.getEntityPage().setSortOrder("");

				sellPrice.setDelFlag("0");
				sellPrice.setSpId(getLoginUser(request).getAccId());
				sellPrice.setCheckPdc("2");
				sellPrice.setCouponId(objCoupon.getCouponId());

				List<SellPrice> sellPriceList = sellPriceService.querySellPriceListForCoupon(sellPrice);
				view.addObject("sellPriceList", sellPriceList);
			} else {
				CouponProduction cp = new CouponProduction();
				cp.setCouponId(objCoupon.getCouponId());
				List<CouponProduction> couponProductionList = couponProductionService.queryCouponProductionList(cp);
				if (couponProductionList != null && couponProductionList.size() > 0) {
					cp = couponProductionList.get(0);
				}
				view.addObject("couponProduction", cp);
			}

			view.addObject("saleTypeList", saleTypeService.querySaleTypeListOrChannel(null, getLoginUser(request).getAccId()));

			view.addObject("coupon", objCoupon);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改Coupon
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateCoupon(Coupon coupon, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			couponService.updateCoupon(coupon, getLoginUser(request), request.getParameter("sellPriceIdList"));
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除Coupon
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteCoupon(Coupon coupon, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			couponService.deleteCoupon(coupon);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 批量删除
	 */
	@RequestMapping(params = "method=deleteBatch")
	public ModelAndView deleteBatchCoupon(Coupon coupon, String checkedCouponIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] couponIds = checkedCouponIds.split(",");
		List<String> couponIdList = new ArrayList<String>();
		Collections.addAll(couponIdList, couponIds);
		try {
			coupon.setCouponIdList(couponIdList);
			couponService.deleteBatchCoupon(coupon);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 分页查询
	 */
	@RequestMapping(params = "method=query")
	public ModelAndView queryCouponList(Coupon coupon, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (coupon.getEntityPage() == null) {
				coupon.setEntityPage(new EntityPage());
			}
			if (coupon.getEntityPage().getSortField() == null || coupon.getEntityPage().getSortField().equals("")) {
				coupon.getEntityPage().setSortField("t.F_UPDATETIME");
				coupon.getEntityPage().setSortOrder("DESC");
			}
			coupon.setDelFlag("0");
			coupon.setSpId(getLoginUser(request).getAccId());
			coupon.setCouponTag("1");

			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(coupon.getEntityPage()), super.getPageSize(coupon.getEntityPage()));
			List<Coupon> couponlist = couponService.queryCouponList(coupon);
			PageInfo<Coupon> pageInfo = new PageInfo<Coupon>(couponlist);

			view = new ModelAndView("coupon/queryCoupon");
			view.addObject("couponlist", couponlist);
			view.addObject("entityPage", coupon.getEntityPage());
			view.addObject("pageInfo", pageInfo);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 导出excel
	 */
	@RequestMapping(params = "method=export")
	public void exportCoupon(Coupon coupon, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "Coupon-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (coupon.getEntityPage() == null) {
				coupon.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(coupon.getEntityPage()), super.getPageSize(coupon.getEntityPage()));
			List<Coupon> exportlist = couponService.queryCouponList(coupon);

			PoiWriteExcel<Coupon> pwe = new PoiWriteExcel<Coupon>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(coupon.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 复制优惠券
	 * 
	 * @author wzd
	 * @date 2020年3月23日 下午3:58:53
	 * @param coupon
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=toCopyCoupon")
	public void toCopyCoupon(Coupon coupon, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			result = couponService.copyCoupon(coupon, getLoginUser(request));
		} catch (Exception e) {
			log.error(e, e);
			result.setResultCode("1");
			result.setResultMsg("程序错误，请稍后再试");
		}
		try {
			response.getWriter().print(JSONObject.fromObject(result).toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 修改优惠券状态
	 * 
	 * @author wzd
	 * @date 2020年3月23日 下午4:05:05
	 * @param coupon
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=toChangeCouponStatus")
	public void toChangeCouponStatus(Coupon coupon, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String status = coupon.getStatus();
			Coupon c = couponService.displayCoupon(coupon);

			User user = getLoginUser(request);
			c.setUpdateTime(DateTimeUtil.getDateTime19());
			c.setUpdater(user.getUserName());
			c.setUpdaterUid(user.getUserId());
			c.setStatus(status);
			couponService.updateCoupon(c);

			result.setResultCode("0");

		} catch (Exception e) {
			log.error(e, e);
			result.setResultCode("1");
			result.setResultMsg("程序错误，请稍后再试");
		}
		try {
			response.getWriter().print(JSONObject.fromObject(result).toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 详情
	 * 
	 * @author wzd
	 * @date 2020年3月24日 下午8:20:05
	 * @param coupon
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=toDetailCoupon")
	public ModelAndView toDetailCoupon(Coupon coupon, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {

			view = new ModelAndView("coupon/detailCoupon");

			Coupon objCoupon = couponService.displayCoupon(coupon);

			if ("2".equals(objCoupon.getCouponType())) {
				SellPrice sellPrice = new SellPrice();
				sellPrice.setEntityPage(new EntityPage());
				sellPrice.getEntityPage().setSortField("p.F_SORTNUM ASC,p.F_PRODUCTNAME ASC");
				sellPrice.getEntityPage().setSortOrder("");

				sellPrice.setDelFlag("0");
				sellPrice.setSpId(getLoginUser(request).getAccId());
				sellPrice.setCheckPdc("2");
				sellPrice.setCouponId(objCoupon.getCouponId());

				List<SellPrice> sellPriceList = sellPriceService.querySellPriceListForCoupon(sellPrice);
				view.addObject("sellPriceList", sellPriceList);
			} else {
				CouponProduction cp = new CouponProduction();
				cp.setCouponId(objCoupon.getCouponId());
				List<CouponProduction> couponProductionList = couponProductionService.queryCouponProductionList(cp);
				if (couponProductionList != null && couponProductionList.size() > 0) {
					cp = couponProductionList.get(0);
				}
				view.addObject("couponProduction", cp);
			}

			view.addObject("saleTypeList", saleTypeService.querySaleTypeListOrChannel(null, getLoginUser(request).getAccId()));

			view.addObject("coupon", objCoupon);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}
}

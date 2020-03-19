package com.msy.travel.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.pojo.Coupon;
import com.msy.travel.service.CouponService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/coupon")
public class CouponController extends BaseController {
	public static final Log log = LogFactory.getLog(CouponController.class);

	@Resource(name = "couponServiceImpl")
	private CouponService couponService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddCoupon(Coupon coupon, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("coupon/addCoupon");
		return view;
	}

	/**
	 * 新增Coupon
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addCoupon(Coupon coupon, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			couponService.createCoupon(coupon);
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
			Coupon objCoupon = couponService.displayCoupon(coupon);
			view = new ModelAndView("coupon/updateCoupon");
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
			couponService.updateCoupon(coupon);
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

}

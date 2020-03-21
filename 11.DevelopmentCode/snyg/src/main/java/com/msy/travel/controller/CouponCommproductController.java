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
import com.msy.travel.pojo.CouponCommproduct;
import com.msy.travel.service.CouponCommproductService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/couponCommproduct")
public class CouponCommproductController extends BaseController {
	public static final Log log = LogFactory.getLog(CouponCommproductController.class);

	@Resource(name = "couponCommproductServiceImpl")
	private CouponCommproductService couponCommproductService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddCouponCommproduct(CouponCommproduct couponCommproduct, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("CouponCommproduct/addCouponCommproduct");
		return view;
	}

	/**
	 * 新增CouponCommproduct
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addCouponCommproduct(CouponCommproduct couponCommproduct, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			couponCommproductService.createCouponCommproduct(couponCommproduct);
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
	public ModelAndView toUpdateCouponCommproduct(CouponCommproduct couponCommproduct, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			CouponCommproduct objCouponCommproduct = couponCommproductService.displayCouponCommproduct(couponCommproduct);
			view = new ModelAndView("CouponCommproduct/updateCouponCommproduct");
			view.addObject("couponCommproduct", objCouponCommproduct);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改CouponCommproduct
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateCouponCommproduct(CouponCommproduct couponCommproduct, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			couponCommproductService.updateCouponCommproduct(couponCommproduct);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除CouponCommproduct
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteCouponCommproduct(CouponCommproduct couponCommproduct, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			couponCommproductService.deleteCouponCommproduct(couponCommproduct);
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
	public ModelAndView deleteBatchCouponCommproduct(CouponCommproduct couponCommproduct, String checkedCouponCommproductIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] couponCommproductIds = checkedCouponCommproductIds.split(",");
		List<String> couponCommproductIdList = new ArrayList<String>();
		Collections.addAll(couponCommproductIdList, couponCommproductIds);
		try {
			couponCommproduct.setCouponCommproductIdList(couponCommproductIdList);
			couponCommproductService.deleteBatchCouponCommproduct(couponCommproduct);
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
	public ModelAndView queryCouponCommproductList(CouponCommproduct couponCommproduct, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (couponCommproduct.getEntityPage() == null) {
				couponCommproduct.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(couponCommproduct.getEntityPage()), super.getPageSize(couponCommproduct.getEntityPage()));
			List<CouponCommproduct> couponCommproductlist = couponCommproductService.queryCouponCommproductList(couponCommproduct);
			PageInfo<CouponCommproduct> pageInfo = new PageInfo<CouponCommproduct>(couponCommproductlist);

			view = new ModelAndView("CouponCommproduct/queryCouponCommproduct");
			view.addObject("couponCommproductlist", couponCommproductlist);
			view.addObject("entityPage", couponCommproduct.getEntityPage());
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
	public void exportCouponCommproduct(CouponCommproduct couponCommproduct, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "CouponCommproduct-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (couponCommproduct.getEntityPage() == null) {
				couponCommproduct.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(couponCommproduct.getEntityPage()), super.getPageSize(couponCommproduct.getEntityPage()));
			List<CouponCommproduct> exportlist = couponCommproductService.queryCouponCommproductList(couponCommproduct);

			PoiWriteExcel<CouponCommproduct> pwe = new PoiWriteExcel<CouponCommproduct>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(couponCommproduct.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 新建或更新
	 * 
	 * @author wzd
	 * @date 2020年3月21日 下午5:54:45
	 * @param couponCommproduct
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=createOrUpdateCouponCommproduct")
	public void createOrUpdateCouponCommproduct(CouponCommproduct couponCommproduct, HttpServletRequest request, HttpServletResponse response, String deleteOrUpdate) {
		Result result = new Result();
		try {

			result = couponCommproductService.createOrUpdateCouponCommproduct(couponCommproduct, deleteOrUpdate);

		} catch (Exception e) {
			log.error(e, e);
		}
		try {
			response.getWriter().print(JSONObject.fromObject(result).toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 删除临时数据
	 * 
	 * @author wzd
	 * @date 2020年3月21日 下午10:45:15
	 * @param couponId
	 * @return
	 * @throws Exception
	 * @return Result
	 */
	@RequestMapping(params = "method=deleteCouponCommproductTemp")
	public void deleteCouponCommproductTemp(String couponId, HttpServletResponse response, String deleteOrUpdate) {
		Result result = new Result();
		try {
			CouponCommproduct c = new CouponCommproduct();
			c.setCouponId(couponId);
			c.setSourceType("0");
			couponCommproductService.deleteCouponCommproduct(c);

			result.setResultCode("0");
		} catch (Exception e) {
			log.error(e, e);
		}
		try {
			response.getWriter().print(JSONObject.fromObject(result).toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

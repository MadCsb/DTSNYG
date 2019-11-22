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
import com.msy.travel.pojo.BannerType;
import com.msy.travel.service.BannerTypeService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/bannerType")
public class BannerTypeController extends BaseController {
	public static final Log log = LogFactory.getLog(BannerTypeController.class);

	@Resource(name = "bannerTypeServiceImpl")
	private BannerTypeService bannerTypeService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddBannerType(BannerType bannerType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("bannerType/addBannerType");
		return view;
	}

	/**
	 * 新增BannerType
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addBannerType(BannerType bannerType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			bannerTypeService.createBannerType(bannerType);
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
	public ModelAndView toUpdateBannerType(BannerType bannerType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			BannerType objBannerType = bannerTypeService.displayBannerType(bannerType);
			view = new ModelAndView("bannerType/updateBannerType");
			view.addObject("bannerType", objBannerType);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改BannerType
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateBannerType(BannerType bannerType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			bannerTypeService.updateBannerType(bannerType);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除BannerType
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteBannerType(BannerType bannerType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			bannerTypeService.deleteBannerType(bannerType);
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
	public ModelAndView deleteBatchBannerType(BannerType bannerType, String checkedBannerTypeIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] bannerTypeIds = checkedBannerTypeIds.split(",");
		List<String> bannerTypeIdList = new ArrayList<String>();
		Collections.addAll(bannerTypeIdList, bannerTypeIds);
		try {
			bannerType.setBannerTypeIdList(bannerTypeIdList);
			bannerTypeService.deleteBatchBannerType(bannerType);
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
	public ModelAndView queryBannerTypeList(BannerType bannerType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (bannerType.getEntityPage() == null) {
				bannerType.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(bannerType.getEntityPage()), super.getPageSize(bannerType.getEntityPage()));
			List<BannerType> bannerTypelist = bannerTypeService.queryBannerTypeList(bannerType);
			PageInfo<BannerType> pageInfo = new PageInfo<BannerType>(bannerTypelist);

			view = new ModelAndView("bannerType/queryBannerType");
			view.addObject("bannerTypelist", bannerTypelist);
			view.addObject("entityPage", bannerType.getEntityPage());
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
	public void exportBannerType(BannerType bannerType, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "BannerType-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (bannerType.getEntityPage() == null) {
				bannerType.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(bannerType.getEntityPage()), super.getPageSize(bannerType.getEntityPage()));
			List<BannerType> exportlist = bannerTypeService.queryBannerTypeList(bannerType);

			PoiWriteExcel<BannerType> pwe = new PoiWriteExcel<BannerType>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(bannerType.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

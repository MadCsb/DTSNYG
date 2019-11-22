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
import com.msy.travel.pojo.Banner;
import com.msy.travel.service.BannerService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/banner")
public class BannerController extends BaseController {
	public static final Log log = LogFactory.getLog(BannerController.class);

	@Resource(name = "bannerServiceImpl")
	private BannerService bannerService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddBanner(Banner banner, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("banner/addBanner");
		return view;
	}

	/**
	 * 新增Banner
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addBanner(Banner banner, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			bannerService.createBanner(banner);
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
	public ModelAndView toUpdateBanner(Banner banner, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Banner objBanner = bannerService.displayBanner(banner);
			view = new ModelAndView("banner/updateBanner");
			view.addObject("banner", objBanner);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改Banner
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateBanner(Banner banner, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			bannerService.updateBanner(banner);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除Banner
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteBanner(Banner banner, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			bannerService.deleteBanner(banner);
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
	public ModelAndView deleteBatchBanner(Banner banner, String checkedBannerIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] bannerIds = checkedBannerIds.split(",");
		List<String> bannerIdList = new ArrayList<String>();
		Collections.addAll(bannerIdList, bannerIds);
		try {
			banner.setBannerIdList(bannerIdList);
			bannerService.deleteBatchBanner(banner);
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
	public ModelAndView queryBannerList(Banner banner, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (banner.getEntityPage() == null) {
				banner.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(banner.getEntityPage()), super.getPageSize(banner.getEntityPage()));
			List<Banner> bannerlist = bannerService.queryBannerList(banner);
			PageInfo<Banner> pageInfo = new PageInfo<Banner>(bannerlist);

			view = new ModelAndView("banner/queryBanner");
			view.addObject("bannerlist", bannerlist);
			view.addObject("entityPage", banner.getEntityPage());
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
	public void exportBanner(Banner banner, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "Banner-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (banner.getEntityPage() == null) {
				banner.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(banner.getEntityPage()), super.getPageSize(banner.getEntityPage()));
			List<Banner> exportlist = bannerService.queryBannerList(banner);

			PoiWriteExcel<Banner> pwe = new PoiWriteExcel<Banner>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(banner.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

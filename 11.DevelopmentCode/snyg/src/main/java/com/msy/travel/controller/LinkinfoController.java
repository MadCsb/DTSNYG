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
import com.msy.travel.pojo.Linkinfo;
import com.msy.travel.service.ILinkinfoService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/linkinfo")
public class LinkinfoController extends BaseController {
	public static final Log log = LogFactory.getLog(LinkinfoController.class);

	@Resource(name = "linkinfoServiceImpl")
	private ILinkinfoService linkinfoService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddLinkinfo(Linkinfo linkinfo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("linkinfo/addLinkinfo");
		return view;
	}

	/**
	 * 新增Linkinfo
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addLinkinfo(Linkinfo linkinfo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			linkinfoService.createLinkinfo(linkinfo);
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
	public ModelAndView toUpdateLinkinfo(Linkinfo linkinfo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Linkinfo objLinkinfo = linkinfoService.displayLinkinfo(linkinfo);
			view = new ModelAndView("linkinfo/updateLinkinfo");
			view.addObject("linkinfo", objLinkinfo);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改Linkinfo
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateLinkinfo(Linkinfo linkinfo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			linkinfoService.updateLinkinfo(linkinfo);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除Linkinfo
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteLinkinfo(Linkinfo linkinfo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			linkinfoService.deleteLinkinfo(linkinfo);
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
	public ModelAndView deleteBatchLinkinfo(Linkinfo linkinfo, String checkedLinkinfoIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] linkinfoIds = checkedLinkinfoIds.split(",");
		List<String> linkinfoIdList = new ArrayList<String>();
		Collections.addAll(linkinfoIdList, linkinfoIds);
		try {
			linkinfo.setLinkinfoIdList(linkinfoIdList);
			linkinfoService.deleteBatchLinkinfo(linkinfo);
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
	public ModelAndView queryLinkinfoList(Linkinfo linkinfo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (linkinfo.getEntityPage() == null) {
				linkinfo.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(linkinfo.getEntityPage()), super.getPageSize(linkinfo.getEntityPage()));
			List<Linkinfo> linkinfolist = linkinfoService.queryLinkinfoList(linkinfo);
			PageInfo<Linkinfo> pageInfo = new PageInfo<Linkinfo>(linkinfolist);

			view = new ModelAndView("linkinfo/queryLinkinfo");
			view.addObject("linkinfolist", linkinfolist);
			view.addObject("entityPage", linkinfo.getEntityPage());
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
	public void exportLinkinfo(Linkinfo linkinfo, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			path = path + File.separator + "export";
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "Linkinfo-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (linkinfo.getEntityPage() == null) {
				linkinfo.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(linkinfo.getEntityPage()), super.getPageSize(linkinfo.getEntityPage()));
			List<Linkinfo> exportlist = linkinfoService.queryLinkinfoList(linkinfo);

			PoiWriteExcel<Linkinfo> pwe = new PoiWriteExcel<Linkinfo>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(linkinfo.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

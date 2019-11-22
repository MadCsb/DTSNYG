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
import com.msy.travel.pojo.Accessrecord;
import com.msy.travel.service.IAccessrecordService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/accessrecord")
public class AccessrecordController extends BaseController {
	public static final Log log = LogFactory.getLog(AccessrecordController.class);

	@Resource(name = "accessrecordServiceImpl")
	private IAccessrecordService accessrecordService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddAccessrecord(Accessrecord accessrecord, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("accessrecord/addAccessrecord");
		return view;
	}

	/**
	 * 新增Accessrecord
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addAccessrecord(Accessrecord accessrecord, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			accessrecordService.createAccessrecord(accessrecord);
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
	public ModelAndView toUpdateAccessrecord(Accessrecord accessrecord, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Accessrecord objAccessrecord = accessrecordService.displayAccessrecord(accessrecord);
			view = new ModelAndView("accessrecord/updateAccessrecord");
			view.addObject("accessrecord", objAccessrecord);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改Accessrecord
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateAccessrecord(Accessrecord accessrecord, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			accessrecordService.updateAccessrecord(accessrecord);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除Accessrecord
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteAccessrecord(Accessrecord accessrecord, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			accessrecordService.deleteAccessrecord(accessrecord);
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
	public ModelAndView deleteBatchAccessrecord(Accessrecord accessrecord, String checkedAccessrecordIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] accessrecordIds = checkedAccessrecordIds.split(",");
		List<String> accessrecordIdList = new ArrayList<String>();
		Collections.addAll(accessrecordIdList, accessrecordIds);
		try {
			accessrecord.setAccessrecordIdList(accessrecordIdList);
			accessrecordService.deleteBatchAccessrecord(accessrecord);
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
	public ModelAndView queryAccessrecordList(Accessrecord accessrecord, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (accessrecord.getEntityPage() == null) {
				accessrecord.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(accessrecord.getEntityPage()), super.getPageSize(accessrecord.getEntityPage()));
			List<Accessrecord> accessrecordlist = accessrecordService.queryAccessrecordList(accessrecord);
			PageInfo<Accessrecord> pageInfo = new PageInfo<Accessrecord>(accessrecordlist);

			view = new ModelAndView("accessrecord/queryAccessrecord");
			view.addObject("accessrecordlist", accessrecordlist);
			view.addObject("entityPage", accessrecord.getEntityPage());
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
	public void exportAccessrecord(Accessrecord accessrecord, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			path = path + File.separator + "export";
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "Accessrecord-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (accessrecord.getEntityPage() == null) {
				accessrecord.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(accessrecord.getEntityPage()), super.getPageSize(accessrecord.getEntityPage()));
			List<Accessrecord> exportlist = accessrecordService.queryAccessrecordList(accessrecord);

			PoiWriteExcel<Accessrecord> pwe = new PoiWriteExcel<Accessrecord>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(accessrecord.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

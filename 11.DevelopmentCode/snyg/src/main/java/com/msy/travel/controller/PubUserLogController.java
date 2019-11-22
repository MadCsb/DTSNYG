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
import com.msy.travel.pojo.PubUserLog;
import com.msy.travel.service.IPubUserLogService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/pubUserLog")
public class PubUserLogController extends BaseController {
	public static final Log log = LogFactory.getLog(PubUserLogController.class);

	@Resource(name = "pubUserLogServiceImpl")
	private IPubUserLogService pubUserLogService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddPubUserLog(PubUserLog pubUserLog, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("pubuserlog/addPubUserLog");
		return view;
	}

	/**
	 * 新增PubUserLog
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addPubUserLog(PubUserLog pubUserLog, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			pubUserLogService.createPubUserLog(pubUserLog);
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
	public ModelAndView toUpdatePubUserLog(PubUserLog pubUserLog, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			PubUserLog objPubUserLog = pubUserLogService.displayPubUserLog(pubUserLog);
			view = new ModelAndView("pubuserlog/updatePubUserLog");
			view.addObject("pubUserLog", objPubUserLog);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改PubUserLog
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updatePubUserLog(PubUserLog pubUserLog, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			pubUserLogService.updatePubUserLog(pubUserLog);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除PubUserLog
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deletePubUserLog(PubUserLog pubUserLog, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			pubUserLogService.deletePubUserLog(pubUserLog);
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
	public ModelAndView deleteBatchPubUserLog(PubUserLog pubUserLog, String checkedPubUserLogIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] pubUserLogIds = checkedPubUserLogIds.split(",");
		List<String> pubUserLogIdList = new ArrayList<String>();
		Collections.addAll(pubUserLogIdList, pubUserLogIds);
		try {
			pubUserLog.setPubUserLogIdList(pubUserLogIdList);
			pubUserLogService.deleteBatchPubUserLog(pubUserLog);
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
	// @RequiresPermissions({ "queryPubUserLog" })
	@RequestMapping(params = "method=query")
	public ModelAndView queryPubUserLogList(PubUserLog pubUserLog, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (pubUserLog.getEntityPage() == null) {
				EntityPage entityPage = new EntityPage();
				entityPage.setSortField("t.F_OPERATION_TIME");
				entityPage.setSortOrder("DESC");
				pubUserLog.setEntityPage(entityPage);
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(pubUserLog.getEntityPage()), super.getPageSize(pubUserLog.getEntityPage()));
			List<PubUserLog> pubUserLoglist = pubUserLogService.queryPubUserLogList(pubUserLog);
			PageInfo<PubUserLog> pageInfo = new PageInfo<PubUserLog>(pubUserLoglist);

			view = new ModelAndView("pubuserlog/queryPubUserLog");
			view.addObject("pubUserLoglist", pubUserLoglist);
			view.addObject("entityPage", pubUserLog.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("pubUserLog", pubUserLog);
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
	public void exportPubUserLog(PubUserLog pubUserLog, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "PubUserLog-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (pubUserLog.getEntityPage() == null) {
				pubUserLog.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(pubUserLog.getEntityPage()), super.getPageSize(pubUserLog.getEntityPage()));
			List<PubUserLog> exportlist = pubUserLogService.queryPubUserLogList(pubUserLog);

			PoiWriteExcel<PubUserLog> pwe = new PoiWriteExcel<PubUserLog>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			// pwe.setHeaders(pubUserLog.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 跳转到查看页面
	 */
	@RequestMapping(params = "method=toLookPubUserLogDetail")
	public ModelAndView toLookPubUserLogDetail(PubUserLog pubUserLog, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			PubUserLog objPubUserLog = pubUserLogService.displayPubUserLog(pubUserLog);
			view = new ModelAndView("pubuserlog/toLookPubUserLogDetail");

			view.addObject("pubUserLog", objPubUserLog);

		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}
}

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
import com.msy.travel.pojo.PrintInfo;
import com.msy.travel.service.IPrintInfoService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/printInfo")
public class PrintInfoController extends BaseController {
	public static final Log log = LogFactory.getLog(PrintInfoController.class);

	@Resource(name = "printInfoServiceImpl")
	private IPrintInfoService printInfoService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddPrintInfo(PrintInfo printInfo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("PrintInfo/addPrintInfo");
		return view;
	}

	/**
	 * 新增PrintInfo
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addPrintInfo(PrintInfo printInfo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			printInfoService.createPrintInfo(printInfo);
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
	public ModelAndView toUpdatePrintInfo(PrintInfo printInfo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			PrintInfo objPrintInfo = printInfoService.displayPrintInfo(printInfo);
			view = new ModelAndView("PrintInfo/updatePrintInfo");
			view.addObject("printInfo", objPrintInfo);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改PrintInfo
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updatePrintInfo(PrintInfo printInfo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			printInfoService.updatePrintInfo(printInfo);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除PrintInfo
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deletePrintInfo(PrintInfo printInfo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			printInfoService.deletePrintInfo(printInfo);
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
	public ModelAndView deleteBatchPrintInfo(PrintInfo printInfo, String checkedPrintInfoIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] printInfoIds = checkedPrintInfoIds.split(",");
		List<String> printInfoIdList = new ArrayList<String>();
		Collections.addAll(printInfoIdList, printInfoIds);
		try {
			printInfo.setPrintInfoIdList(printInfoIdList);
			printInfoService.deleteBatchPrintInfo(printInfo);
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
	public ModelAndView queryPrintInfoList(PrintInfo printInfo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (printInfo.getEntityPage() == null) {
				printInfo.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(printInfo.getEntityPage()), super.getPageSize(printInfo.getEntityPage()));
			List<PrintInfo> printInfolist = printInfoService.queryPrintInfoList(printInfo);
			PageInfo<PrintInfo> pageInfo = new PageInfo<PrintInfo>(printInfolist);

			view = new ModelAndView("PrintInfo/queryPrintInfo");
			view.addObject("printInfolist", printInfolist);
			view.addObject("entityPage", printInfo.getEntityPage());
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
	public void exportPrintInfo(PrintInfo printInfo, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "PrintInfo-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (printInfo.getEntityPage() == null) {
				printInfo.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(printInfo.getEntityPage()), super.getPageSize(printInfo.getEntityPage()));
			List<PrintInfo> exportlist = printInfoService.queryPrintInfoList(printInfo);

			PoiWriteExcel<PrintInfo> pwe = new PoiWriteExcel<PrintInfo>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(printInfo.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

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
import com.msy.travel.pojo.PrintPic;
import com.msy.travel.service.IPrintPicService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/printPic")
public class PrintPicController extends BaseController {
	public static final Log log = LogFactory.getLog(PrintPicController.class);

	@Resource(name = "printPicServiceImpl")
	private IPrintPicService printPicService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddPrintPic(PrintPic printPic, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("PrintPic/addPrintPic");
		return view;
	}

	/**
	 * 新增PrintPic
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addPrintPic(PrintPic printPic, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			printPicService.createPrintPic(printPic);
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
	public ModelAndView toUpdatePrintPic(PrintPic printPic, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			PrintPic objPrintPic = printPicService.displayPrintPic(printPic);
			view = new ModelAndView("PrintPic/updatePrintPic");
			view.addObject("printPic", objPrintPic);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改PrintPic
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updatePrintPic(PrintPic printPic, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			printPicService.updatePrintPic(printPic);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除PrintPic
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deletePrintPic(PrintPic printPic, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			printPicService.deletePrintPic(printPic);
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
	public ModelAndView deleteBatchPrintPic(PrintPic printPic, String checkedPrintPicIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] printPicIds = checkedPrintPicIds.split(",");
		List<String> printPicIdList = new ArrayList<String>();
		Collections.addAll(printPicIdList, printPicIds);
		try {
			printPic.setPrintPicIdList(printPicIdList);
			printPicService.deleteBatchPrintPic(printPic);
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
	public ModelAndView queryPrintPicList(PrintPic printPic, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (printPic.getEntityPage() == null) {
				printPic.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(printPic.getEntityPage()), super.getPageSize(printPic.getEntityPage()));
			List<PrintPic> printPiclist = printPicService.queryPrintPicList(printPic);
			PageInfo<PrintPic> pageInfo = new PageInfo<PrintPic>(printPiclist);

			view = new ModelAndView("PrintPic/queryPrintPic");
			view.addObject("printPiclist", printPiclist);
			view.addObject("entityPage", printPic.getEntityPage());
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
	public void exportPrintPic(PrintPic printPic, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "PrintPic-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (printPic.getEntityPage() == null) {
				printPic.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(printPic.getEntityPage()), super.getPageSize(printPic.getEntityPage()));
			List<PrintPic> exportlist = printPicService.queryPrintPicList(printPic);

			PoiWriteExcel<PrintPic> pwe = new PoiWriteExcel<PrintPic>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(printPic.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

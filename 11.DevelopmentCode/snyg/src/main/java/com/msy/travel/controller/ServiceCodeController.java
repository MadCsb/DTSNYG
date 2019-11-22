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
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.service.IServiceCodeService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/serviceCode")
public class ServiceCodeController extends BaseController {
	public static final Log log = LogFactory.getLog(ServiceCodeController.class);

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddServiceCode(ServiceCode serviceCode, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("ServiceCode/addServiceCode");
		return view;
	}

	/**
	 * 新增ServiceCode
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addServiceCode(ServiceCode serviceCode, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			serviceCodeService.createServiceCode(serviceCode);
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
	public ModelAndView toUpdateServiceCode(ServiceCode serviceCode, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			ServiceCode objServiceCode = serviceCodeService.displayServiceCode(serviceCode);
			view = new ModelAndView("ServiceCode/updateServiceCode");
			view.addObject("serviceCode", objServiceCode);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改ServiceCode
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateServiceCode(ServiceCode serviceCode, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			serviceCodeService.updateServiceCode(serviceCode);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除ServiceCode
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteServiceCode(ServiceCode serviceCode, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			serviceCodeService.deleteServiceCode(serviceCode);
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
	public ModelAndView deleteBatchServiceCode(ServiceCode serviceCode, String checkedServiceCodeIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] serviceCodeIds = checkedServiceCodeIds.split(",");
		List<String> serviceCodeIdList = new ArrayList<String>();
		Collections.addAll(serviceCodeIdList, serviceCodeIds);
		try {
			serviceCode.setServiceCodeIdList(serviceCodeIdList);
			serviceCodeService.deleteBatchServiceCode(serviceCode);
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
	public ModelAndView queryServiceCodeList(ServiceCode serviceCode, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (serviceCode.getEntityPage() == null) {
				serviceCode.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(serviceCode.getEntityPage()), super.getPageSize(serviceCode.getEntityPage()));
			List<ServiceCode> serviceCodelist = serviceCodeService.queryServiceCodeList(serviceCode);
			PageInfo<ServiceCode> pageInfo = new PageInfo<ServiceCode>(serviceCodelist);

			view = new ModelAndView("ServiceCode/queryServiceCode");
			view.addObject("serviceCodelist", serviceCodelist);
			view.addObject("entityPage", serviceCode.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("serviceCode", serviceCode);
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
	public void exportServiceCode(ServiceCode serviceCode, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			path = path + File.separator + "export";
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "ServiceCode-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (serviceCode.getEntityPage() == null) {
				serviceCode.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(serviceCode.getEntityPage()), super.getPageSize(serviceCode.getEntityPage()));
			List<ServiceCode> exportlist = serviceCodeService.queryServiceCodeList(serviceCode);

			PoiWriteExcel<ServiceCode> pwe = new PoiWriteExcel<ServiceCode>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(serviceCode.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

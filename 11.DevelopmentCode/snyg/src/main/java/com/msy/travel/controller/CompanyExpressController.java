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
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.pojo.Company;
import com.msy.travel.pojo.CompanyExpress;
import com.msy.travel.pojo.Pubmap;
import com.msy.travel.service.CompanyExpressService;
import com.msy.travel.service.CompanyService;
import com.msy.travel.service.IPubmapService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/companyExpress")
public class CompanyExpressController extends BaseController {
	public static final Log log = LogFactory.getLog(CompanyExpressController.class);

	@Resource(name = "companyExpressServiceImpl")
	private CompanyExpressService companyExpressService;

	@Resource(name = "companyServiceImpl")
	private CompanyService companyService;

	@Resource(name = "pubmapServiceImpl")
	private IPubmapService pubmapService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddCompanyExpress(CompanyExpress companyExpress, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {

			view = new ModelAndView("companyexpress/addCompanyExpress");

			Company c = new Company();
			c.setDelFlag("0");
			c.setSpId(getLoginUser(request).getAccId());
			List<Company> companyList = companyService.queryCompanyList(c);

			List<Pubmap> expressList = pubmapService.getPubmapListByType("EXPRESS");

			view.addObject("companyList", companyList);
			view.addObject("expressList", expressList);
		} catch (Exception e) {
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增CompanyExpress
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addCompanyExpress(CompanyExpress companyExpress, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			companyExpress.setCompanyExpressId(PrimaryKeyUtil.generateKey());
			companyExpress.setUpdateTime(DateTimeUtil.getDateTime19());
			companyExpress.setSpId(getLoginUser(request).getAccId());
			companyExpressService.createCompanyExpress(companyExpress);
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
	public ModelAndView toUpdateCompanyExpress(CompanyExpress companyExpress, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			CompanyExpress objCompanyExpress = companyExpressService.displayCompanyExpress(companyExpress);
			view = new ModelAndView("companyexpress/updateCompanyExpress");

			Company c = new Company();
			c.setDelFlag("0");
			c.setSpId(getLoginUser(request).getAccId());
			List<Company> companyList = companyService.queryCompanyList(c);

			List<Pubmap> expressList = pubmapService.getPubmapListByType("EXPRESS");

			view.addObject("companyList", companyList);
			view.addObject("companyExpress", objCompanyExpress);
			view.addObject("expressList", expressList);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改CompanyExpress
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateCompanyExpress(CompanyExpress companyExpress, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			companyExpress.setUpdateTime(DateTimeUtil.getDateTime19());
			companyExpressService.updateCompanyExpress(companyExpress);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除CompanyExpress
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteCompanyExpress(CompanyExpress companyExpress, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			companyExpressService.deleteCompanyExpress(companyExpress);
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
	public ModelAndView deleteBatchCompanyExpress(CompanyExpress companyExpress, String checkedCompanyExpressIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] companyExpressIds = checkedCompanyExpressIds.split(",");
		List<String> companyExpressIdList = new ArrayList<String>();
		Collections.addAll(companyExpressIdList, companyExpressIds);
		try {
			companyExpress.setCompanyExpressIdList(companyExpressIdList);
			companyExpressService.deleteBatchCompanyExpress(companyExpress);
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
	public ModelAndView queryCompanyExpressList(CompanyExpress companyExpress, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (companyExpress.getEntityPage() == null) {
				companyExpress.setEntityPage(new EntityPage());
			}

			companyExpress.getEntityPage().setSortField("t.F_UPDATETIME");
			companyExpress.getEntityPage().setSortOrder("DESC");

			companyExpress.setSpId(getLoginUser(request).getAccId());

			Company c = new Company();
			c.setDelFlag("0");
			c.setSpId(getLoginUser(request).getAccId());
			List<Company> companyList = companyService.queryCompanyList(c);

			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(companyExpress.getEntityPage()), super.getPageSize(companyExpress.getEntityPage()));
			List<CompanyExpress> companyExpresslist = companyExpressService.queryCompanyExpressList(companyExpress);
			PageInfo<CompanyExpress> pageInfo = new PageInfo<CompanyExpress>(companyExpresslist);

			view = new ModelAndView("companyexpress/queryCompanyExpress");

			view.addObject("companyExpresslist", companyExpresslist);
			view.addObject("entityPage", companyExpress.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("companyExpress", companyExpress);
			view.addObject("companyList", companyList);
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
	public void exportCompanyExpress(CompanyExpress companyExpress, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "CompanyExpress-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (companyExpress.getEntityPage() == null) {
				companyExpress.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(companyExpress.getEntityPage()), super.getPageSize(companyExpress.getEntityPage()));
			List<CompanyExpress> exportlist = companyExpressService.queryCompanyExpressList(companyExpress);

			PoiWriteExcel<CompanyExpress> pwe = new PoiWriteExcel<CompanyExpress>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(companyExpress.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

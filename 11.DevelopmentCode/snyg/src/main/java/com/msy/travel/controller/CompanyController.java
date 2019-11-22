package com.msy.travel.controller;

import java.io.File;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Company;
import com.msy.travel.pojo.Linkinfo;
import com.msy.travel.service.CompanyService;
import com.msy.travel.service.ILinkinfoService;
import com.msy.travel.service.IPubmapService;
import com.msy.travel.service.IRsPicService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/company")
public class CompanyController extends BaseController {
	public static final Log log = LogFactory.getLog(CompanyController.class);

	@Resource(name = "companyServiceImpl")
	private CompanyService companyService;

	@Resource(name = "pubmapServiceImpl")
	private IPubmapService pubmapService;

	@Resource(name = "linkinfoServiceImpl")
	private ILinkinfoService linkinfoService;

	@Resource(name = "rsPicServiceImpl")
	private IRsPicService rsPicService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	/**
	 * 跳转到详细页面
	 */
	@RequestMapping(params = "method=toDetail")
	public ModelAndView toDetailCompany(Company company, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {

			company = companyService.displayCompany(company);
			List<Linkinfo> linkinfoList = new ArrayList<Linkinfo>();
			Linkinfo linkinfo = new Linkinfo();
			linkinfo.setVenId(company.getVenId());
			linkinfoList = linkinfoService.queryLinkinfoList(linkinfo);
			view = new ModelAndView("company/detailCompany");
			// 得到照片
			if (company.getLogoUrl() != null && company.getLogoUrl() != "") {
				String dictory = configParameter.getPicUrl();
				String picurl = dictory + "/company/" + company.getLogoUrl();
				view.addObject("picurl", picurl);
			} else {
				view.addObject("picurl", null);
			}
			view.addObject("company", company);
			view.addObject("linkinfoList", linkinfoList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddCompany(Company company, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {

			view = new ModelAndView("company/addCompany");
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增Company
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addCompany(Company company, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "upload", required = false) MultipartFile logoFile) {
		ModelAndView view = null;
		try {
			// 创建路径
			String dictory = configParameter.getUploadPicUrl() + "/company";
			File dictoryFile = new File(dictory);
			if (!dictoryFile.isDirectory()) {
				dictoryFile.mkdirs();
			}
			// 得到图片信息
			if (logoFile.getSize() > 0) {// 是否添加了照片
				String realName = PrimaryKeyUtil.generateKey() + logoFile.getOriginalFilename().substring(logoFile.getOriginalFilename().lastIndexOf("."));
				File target = new File(dictory, realName);
				logoFile.transferTo(target);
				company.setLogoUrl(realName);// 将图片名字存入
			} else {
				company.setLogoUrl(null);// 将图片名字存入
			}
			company.setDelFlag("0");
			company.setSpId(getLoginUser(request).getAccId());
			company.setCreateTime(DateTimeUtil.getDateTime19());
			company.setCreator(getLoginUser(request).getUserName());
			company.setCreatorUid(getLoginUser(request).getUserId());

			companyService.createCompany(company, getLoginUser(request));

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
	public ModelAndView toUpdateCompany(Company company, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			company = companyService.displayCompany(company);

			List<Linkinfo> linkinfoList = new ArrayList<Linkinfo>();
			Linkinfo linkinfo = new Linkinfo();
			linkinfo.setVenId(company.getVenId());

			linkinfoList = linkinfoService.queryLinkinfoList(linkinfo);
			for (int i = 0; i < linkinfoList.size(); i++) {
				linkinfoList.get(i).setSize(i);
			}

			view = new ModelAndView("company/updateCompany");
			// 得到照片
			if (company.getLogoUrl() != null && company.getLogoUrl() != "") {
				String dictory = configParameter.getPicUrl();
				String picurl = dictory + "/company/" + company.getLogoUrl();
				view.addObject("picurl", picurl);
			} else {
				view.addObject("picurl", null);
			}

			view.addObject("company", company);
			view.addObject("linkinfoList", linkinfoList);
			view.addObject("size", linkinfoList.size());

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改Company
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateCompany(Company company, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "upload", required = false) MultipartFile logoFile) {
		ModelAndView view = null;
		try {
			// 创建路径
			String dictory = configParameter.getUploadPicUrl() + "/company";
			File dictoryFile = new File(dictory);
			if (!dictoryFile.isDirectory()) {
				dictoryFile.mkdirs();
			}
			// 得到图片信息
			if (logoFile.getSize() > 0) {// 是否添加了照片
				String realName = PrimaryKeyUtil.generateKey() + logoFile.getOriginalFilename().substring(logoFile.getOriginalFilename().lastIndexOf("."));
				File target = new File(dictory, realName);
				logoFile.transferTo(target);
				company.setLogoUrl(realName);// 将图片名字存入
			}
			company.setUpdateTime(DateTimeUtil.getDateTime19());
			company.setUpdater(getLoginUser(request).getUserName());
			company.setUpdaterUid(getLoginUser(request).getUserId());
			// 添加新联系人
			companyService.createCompany(company, getLoginUser(request));
			// 修改
			companyService.updateCompany(company, getLoginUser(request));
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除Company
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteCompany(Company company, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			company = companyService.displayCompany(company);
			company.setDelFlag("1");
			company.setUpdater(getLoginUser(request).getUserName());
			company.setUpdaterUid(getLoginUser(request).getUserId());
			company.setUpdateTime(DateTimeUtil.getDateTime19());
			companyService.deleteCompany(company);
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
	public ModelAndView deleteBatchCompany(Company company, String checkedCompanyIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] companyIds = checkedCompanyIds.split(",");
		List<String> companyIdList = new ArrayList<String>();
		Collections.addAll(companyIdList, companyIds);
		try {
			company.setCompanyIdList(companyIdList);
			companyService.deleteBatchCompany(company);
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
	public ModelAndView queryCompanyList(Company company, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (company.getEntityPage() == null) {
				EntityPage entityPage = new EntityPage();
				entityPage.setSortField("F_CREATETIME");
				entityPage.setSortOrder("desc");
				company.setEntityPage(entityPage);
			}
			company.setDelFlag("0");
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(company.getEntityPage()), super.getPageSize(company.getEntityPage()));
			// 过滤支撑商编号
			company.setSpId(getLoginUser(request).getAccId());
			List<Company> companylist = companyService.queryCompanyList(company);
			// for (int i = 0; i < companylist.size(); i++) {
			// companylist.get(i).setNum(String.valueOf(i + 1));
			// }
			PageInfo<Company> pageInfo = new PageInfo<Company>(companylist);

			view = new ModelAndView("company/queryCompany");
			view.addObject("company", company);
			view.addObject("companylist", companylist);
			view.addObject("entityPage", company.getEntityPage());
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
	public void exportCompany(Company company, String checkedCompanyIds, HttpServletRequest request, HttpServletResponse response) {

		try {
			String[] companyIds = checkedCompanyIds.split(",");
			String path = request.getSession().getServletContext().getRealPath("");
			path = path + File.separator + "export";
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "商家管理-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (company.getEntityPage() == null) {
				company.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(company.getEntityPage()), super.getPageSize(company.getEntityPage()));
			// 过滤支撑商编号
			company.setSpId(getLoginUser(request).getAccId());
			company.setDelFlag("0");
			List<Company> exportlist = new ArrayList<Company>();
			// 判断是否勾选
			if (companyIds.length > 0 && !companyIds[0].equals("")) {
				Company newCompany = new Company();
				for (int i = 0; i < companyIds.length; i++) {
					newCompany.setVenId(companyIds[i]);
					newCompany = companyService.displayCompany(newCompany);
					exportlist.add(newCompany);
				}
			} else {
				exportlist = companyService.queryCompanyList(company);
			}

			PoiWriteExcel<Company> pwe = new PoiWriteExcel<Company>();

			// 设置标题
			pwe.setFileTitle("商家管理");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(company.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 重名校验
	 * 
	 * @param production
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "method=checkVenName")
	public void checkVenName(Company company, HttpServletRequest request, HttpServletResponse response) {
		PrintWriter printWrite = null;
		try {
			printWrite = response.getWriter();

			company.setSpId(getLoginUser(request).getAccId());
			company.setDelFlag("0");

			// 相同名称的记录数
			int count = companyService.getCountByVenName(company);

			printWrite.print(count);
			printWrite.flush();
			printWrite.close();
		} catch (Exception e) {
			printWrite.flush();
			printWrite.close();
			log.error(e, e);
		}
	}
}

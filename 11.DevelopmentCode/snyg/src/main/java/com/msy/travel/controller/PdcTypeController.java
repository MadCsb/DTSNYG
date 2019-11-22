package com.msy.travel.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

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
import com.msy.travel.common.Consts;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.ResourceCommon;
import com.msy.travel.common.UploadFileCom;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Commproduct;
import com.msy.travel.pojo.PdcType;
import com.msy.travel.service.CommproductService;
import com.msy.travel.service.PdcTypeService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/pdcType")
public class PdcTypeController extends BaseController {
	public static final Log log = LogFactory.getLog(PdcTypeController.class);

	@Resource(name = "pdcTypeServiceImpl")
	private PdcTypeService pdcTypeService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Resource(name = "commproductServiceImpl")
	private CommproductService commproductService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddPdcType(PdcType pdcType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			PdcType parentPdcType = new PdcType();
			parentPdcType.setDelFlag("0");
			parentPdcType.setLevel("1");
			parentPdcType.setSpId(getLoginUser(request).getAccId());
			List<PdcType> parentPdcTypeList = pdcTypeService.queryPdcTypeList(parentPdcType);

			view = new ModelAndView("pdcType/addPdcType");
			view.addObject("parentPdcTypeList", parentPdcTypeList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增PdcType
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addPdcType(PdcType pdcType, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "upload1", required = false) MultipartFile multipartFile) {
		ModelAndView view = null;
		try {
			if (multipartFile != null && multipartFile.getSize() > 0) {
				String thumbPic = UploadFileCom.uploadFileByFolder(multipartFile, request, Consts.WX_PIC_FOLDER_NAME, configParameter.getUploadPicUrl());
				pdcType.setPicUrl(thumbPic);
			}
			if (pdcType.getPpdcTypeId() != null && !"".equals(pdcType.getPpdcTypeId())) {
				PdcType p = new PdcType();
				p.setPdcTypeId(pdcType.getPpdcTypeId());
				p = pdcTypeService.displayPdcType(p);
				int level = Integer.parseInt(p.getLevel()) + 1;
				pdcType.setLevel(level + "");
			} else {
				pdcType.setLevel("1");
			}
			pdcType.setPdcTypeId(PrimaryKeyUtil.generateKey());
			pdcType.setDelFlag("0");
			pdcType.setSpId(getLoginUser(request).getAccId());
			pdcTypeService.createPdcType(pdcType);
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
	public ModelAndView toUpdatePdcType(PdcType pdcType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			PdcType parentPdcType = new PdcType();
			parentPdcType.setDelFlag("0");
			parentPdcType.setLevel("1");
			parentPdcType.setSpId(getLoginUser(request).getAccId());
			List<PdcType> parentPdcTypeList = pdcTypeService.queryPdcTypeList(parentPdcType);

			PdcType objPdcType = pdcTypeService.displayPdcType(pdcType);
			view = new ModelAndView("pdcType/updatePdcType");
			view.addObject("pdcType", objPdcType);
			view.addObject("parentPdcTypeList", parentPdcTypeList);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改PdcType
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updatePdcType(PdcType pdcType, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "upload1", required = false) MultipartFile multipartFile) {
		ModelAndView view = null;
		try {
			String th = pdcType.getPicUrl();
			if (multipartFile != null && multipartFile.getSize() > 0) {
				th = UploadFileCom.uploadFileByFolder(multipartFile, request, Consts.WX_PIC_FOLDER_NAME, configParameter.getUploadPicUrl());
			}

			if (pdcType.getPpdcTypeId() != null && !"".equals(pdcType.getPpdcTypeId())) {
				PdcType p = new PdcType();
				p.setPdcTypeId(pdcType.getPpdcTypeId());
				p = pdcTypeService.displayPdcType(p);
				int level = Integer.parseInt(p.getLevel()) + 1;
				pdcType.setLevel(level + "");
			} else {
				pdcType.setLevel("1");
			}

			pdcType.setPicUrl(th);
			pdcType.setDelFlag("0");
			pdcTypeService.updatePdcType(pdcType);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除PdcType
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deletePdcType(PdcType pdcType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			pdcTypeService.deletePdcTypeAndSub(pdcType);
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
	public ModelAndView deleteBatchPdcType(PdcType pdcType, String checkedPdcTypeIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] pdcTypeIds = checkedPdcTypeIds.split(",");
		List<String> pdcTypeIdList = new ArrayList<String>();
		Collections.addAll(pdcTypeIdList, pdcTypeIds);
		try {
			pdcType.setPdcTypeIdList(pdcTypeIdList);
			pdcTypeService.deleteBatchPdcType(pdcType);
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
	public ModelAndView queryPdcTypeList(PdcType pdcType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (pdcType.getEntityPage() == null) {
				pdcType.setEntityPage(new EntityPage());
			}
			pdcType.setDelFlag("0");
			pdcType.setSpId(getLoginUser(request).getAccId());
			pdcType.setLevel("1");
			request.getSession().setAttribute("subTypeBack", "");
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(pdcType.getEntityPage()), super.getPageSize(pdcType.getEntityPage()));
			List<PdcType> pdcTypelist = pdcTypeService.queryPdcTypeList(pdcType);
			PageInfo<PdcType> pageInfo = new PageInfo<PdcType>(pdcTypelist);

			view = new ModelAndView("pdcType/queryPdcType");
			view.addObject("pdcTypelist", pdcTypelist);
			view.addObject("entityPage", pdcType.getEntityPage());
			view.addObject("pageInfo", pageInfo);
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
	@RequestMapping(params = "method=querySubPdcType")
	public ModelAndView querySubPdcTypeList(PdcType pdcType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (pdcType.getEntityPage() == null) {
				pdcType.setEntityPage(new EntityPage());
			}
			pdcType.setDelFlag("0");
			pdcType.setSpId(getLoginUser(request).getAccId());

			String backUrl = (String) request.getSession().getAttribute("subTypeBack");
			if ("".equals(backUrl)) {
				backUrl = (String) request.getSession().getAttribute(ResourceCommon.BACK_URL);
				request.getSession().setAttribute("subTypeBack", backUrl);
			}

			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(pdcType.getEntityPage()), super.getPageSize(pdcType.getEntityPage()));
			List<PdcType> pdcTypelist = pdcTypeService.queryPdcTypeList(pdcType);
			PageInfo<PdcType> pageInfo = new PageInfo<PdcType>(pdcTypelist);

			view = new ModelAndView("pdcType/querySubPdcType");
			view.addObject("pdcTypelist", pdcTypelist);
			view.addObject("entityPage", pdcType.getEntityPage());
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
	public void exportPdcType(PdcType pdcType, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "PdcType-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (pdcType.getEntityPage() == null) {
				pdcType.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(pdcType.getEntityPage()), super.getPageSize(pdcType.getEntityPage()));
			List<PdcType> exportlist = pdcTypeService.queryPdcTypeList(pdcType);

			PoiWriteExcel<PdcType> pwe = new PoiWriteExcel<PdcType>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(pdcType.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 获取json格式的pdcTypeList
	 * 
	 * @author wzd
	 * @date 2019年10月2日 下午1:36:43
	 * @param pdcType
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=getPdcTypeList")
	public void getPdcTypeList(PdcType pdcType, HttpServletRequest request, HttpServletResponse response) {
		try {
			pdcType.setDelFlag("0");
			pdcType.setSpId(getLoginUser(request).getAccId());
			List<PdcType> pdcTypelist = pdcTypeService.queryPdcTypeList(pdcType);
			JSONArray jsonArray = JSONArray.fromObject(pdcTypelist);
			response.getWriter().print(jsonArray.toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 判断名称是否存在
	 * 
	 * @author wzd
	 * @date 2019年10月13日 下午8:58:04
	 * @param pdcType
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=queryPdcTypeNameExis")
	public void queryPdcTypeNameExis(PdcType pdcType, HttpServletRequest request, HttpServletResponse response) {
		try {
			pdcType.setDelFlag("0");
			pdcType.setSpId(getLoginUser(request).getAccId());
			int count = pdcTypeService.queryPdcTypeNameExis(pdcType);
			if (count > 0) {
				response.getWriter().print("faild");
			} else {
				response.getWriter().print("success");
			}
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 判断是否有商品使用分类
	 * 
	 * @author wzd
	 * @date 2019年10月13日 下午8:58:04
	 * @param pdcType
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=queryPdcTypeProduct")
	public void queryPdcTypeProduct(PdcType pdcType, HttpServletRequest request, HttpServletResponse response) {
		try {
			PdcType sub = new PdcType();
			sub.setPpdcTypeId(pdcType.getPdcTypeId());
			sub.setDelFlag("0");
			sub.setSpId(getLoginUser(request).getAccId());
			List<PdcType> subli = pdcTypeService.queryPdcTypeList(sub);

			Commproduct c = new Commproduct();
			c.setType(pdcType.getPdcTypeId());
			c.setDelFlag("0");
			c.setSpId(getLoginUser(request).getAccId());
			List<Commproduct> cl = commproductService.queryCommproductList(c);

			if (subli != null && subli.size() > 0) {
				response.getWriter().print("1");
			} else if (cl != null && cl.size() > 0) {
				response.getWriter().print("2");
			} else {
				response.getWriter().print("3");
			}
		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

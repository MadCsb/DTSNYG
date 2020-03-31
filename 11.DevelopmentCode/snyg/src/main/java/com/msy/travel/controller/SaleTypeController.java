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

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.Result;
import com.msy.travel.pojo.SaleType;
import com.msy.travel.service.SaleTypeService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/saleType")
public class SaleTypeController extends BaseController {
	public static final Log log = LogFactory.getLog(SaleTypeController.class);

	@Resource(name = "saleTypeServiceImpl")
	private SaleTypeService saleTypeService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddSaleType(SaleType saleType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("saletype/addSaleType");
		return view;
	}

	/**
	 * 新增SaleType
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addSaleType(SaleType saleType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			saleType.setSaleTypeId(PrimaryKeyUtil.generateKey());
			saleType.setSpId(getLoginUser(request).getAccId());
			saleTypeService.createSaleType(saleType);
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
	public ModelAndView toUpdateSaleType(SaleType saleType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			SaleType objSaleType = saleTypeService.displaySaleType(saleType);
			view = new ModelAndView("saletype/updateSaleType");
			view.addObject("saleType", objSaleType);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改SaleType
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateSaleType(SaleType saleType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {

			saleTypeService.updateSaleType(saleType);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除SaleType
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteSaleType(SaleType saleType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			saleTypeService.deleteSaleType(saleType);
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
	public ModelAndView deleteBatchSaleType(SaleType saleType, String checkedSaleTypeIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] saleTypeIds = checkedSaleTypeIds.split(",");
		List<String> saleTypeIdList = new ArrayList<String>();
		Collections.addAll(saleTypeIdList, saleTypeIds);
		try {
			saleType.setSaleTypeIdList(saleTypeIdList);
			saleTypeService.deleteBatchSaleType(saleType);
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
	public ModelAndView querySaleTypeList(SaleType saleType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (saleType.getEntityPage() == null) {
				saleType.setEntityPage(new EntityPage());
			}
			saleType.setSpId(getLoginUser(request).getAccId());
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(saleType.getEntityPage()), super.getPageSize(saleType.getEntityPage()));
			List<SaleType> saleTypelist = saleTypeService.querySaleTypeList(saleType);
			PageInfo<SaleType> pageInfo = new PageInfo<SaleType>(saleTypelist);

			view = new ModelAndView("saletype/querySaleType");
			view.addObject("saleTypelist", saleTypelist);
			view.addObject("entityPage", saleType.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("saleType", saleType);
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
	public void exportSaleType(SaleType saleType, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "SaleType-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (saleType.getEntityPage() == null) {
				saleType.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(saleType.getEntityPage()), super.getPageSize(saleType.getEntityPage()));
			List<SaleType> exportlist = saleTypeService.querySaleTypeList(saleType);

			PoiWriteExcel<SaleType> pwe = new PoiWriteExcel<SaleType>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(saleType.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 修改状态
	 * 
	 * @author wzd
	 * @date 2020年3月31日 上午10:07:24
	 * @param saleType
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "method=updateSaleTypeStatus")
	public void updateSaleTypeStatus(SaleType saleType, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String status = saleType.getStatus();
			saleType = saleTypeService.displaySaleType(saleType);
			saleType.setStatus(status);

			saleTypeService.updateSaleType(saleType);

			result.setResultCode("0");
			result.setResultMsg("操作成功");

		} catch (Exception e) {
			result.setResultCode("1");
			result.setResultMsg("程序出错，请稍后再试");
			log.error(e, e);
		}
		try {
			response.getWriter().print(JSONObject.toJSON(result).toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 判断标识
	 * 
	 * @author wzd
	 * @date 2020年3月31日 上午10:10:22
	 * @param saleType
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=checkSaleTypeKey")
	public void checkSaleTypeKey(SaleType saleType, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			saleType.setSpId(getLoginUser(request).getAccId());
			int checkCount = saleTypeService.checkSaleTypeKeyExis(saleType);

			if (checkCount > 0) {
				result.setResultCode("1");
				result.setResultMsg("该活动标识已经存在");
			} else {
				result.setResultCode("0");
			}

		} catch (Exception e) {
			result.setResultCode("1");
			result.setResultMsg("程序出错，请稍后再试");
			log.error(e, e);
		}
		try {
			response.getWriter().print(JSONObject.toJSON(result).toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 绑定
	 * 
	 * @author wzd
	 * @date 2020年3月31日 下午2:03:56
	 * @param saleType
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=queryForBind")
	public ModelAndView queryForBind(SaleType saleType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (saleType.getEntityPage() == null) {
				saleType.setEntityPage(new EntityPage());
			}
			saleType.setSpId(getLoginUser(request).getAccId());

			List<SaleType> saleTypelist = saleTypeService.querySaleTypeList(saleType);

			view = new ModelAndView("saletype/querySaleTypeForBind");
			view.addObject("saleTypelist", saleTypelist);
			view.addObject("saleType", saleType);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

}

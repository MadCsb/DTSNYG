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
import com.msy.travel.common.UploadFileCom;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.RsPic;
import com.msy.travel.service.IRsPicService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/rspic")
public class RsPicController extends BaseController {
	public static final Log log = LogFactory.getLog(RsPicController.class);

	@Resource(name = "rsPicServiceImpl")
	private IRsPicService rsPicService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddRsPic(RsPic rsPic, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("rspic/addRsPic");
			String rsType = rsPic.getRsType();
			if (null == rsType || "".equals(rsType)) {
				view = new ModelAndView("error");
				return view;
			}
			String rsPicId = rsPic.getPicId();
			if (null != rsPicId && !"".equals(rsPicId)) {
				RsPic rp = rsPicService.displayRsPic(rsPic);
				if (null != rp) {
					rsPic = rp;
				}
			}
			view.addObject("rsPic", rsPic);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增RsPic
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addRsPic(RsPic rsPic, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			rsPicService.createRsPic(rsPic);
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
	public ModelAndView toUpdateRsPic(RsPic rsPic, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			RsPic objRsPic = rsPicService.displayRsPic(rsPic);
			view = new ModelAndView("rspic/updateRsPic");
			view.addObject("rsPic", objRsPic);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改RsPic
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateRsPic(RsPic rsPic, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			rsPicService.updateRsPic(rsPic);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除RsPic
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteRsPic(RsPic rsPic, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			rsPicService.deleteRsPic(rsPic);
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
	public ModelAndView deleteBatchRsPic(RsPic rsPic, String checkedRsPicIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] rsPicIds = checkedRsPicIds.split(",");
		List<String> rsPicIdList = new ArrayList<String>();
		Collections.addAll(rsPicIdList, rsPicIds);
		try {
			rsPic.setRsPicIdList(rsPicIdList);
			rsPicService.deleteBatchRsPic(rsPic);
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
	public ModelAndView queryRsPicList(RsPic rsPic, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (rsPic.getEntityPage() == null) {
				rsPic.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(rsPic.getEntityPage()), super.getPageSize(rsPic.getEntityPage()));
			List<RsPic> rsPiclist = rsPicService.queryRsPicList(rsPic);
			PageInfo<RsPic> pageInfo = new PageInfo<RsPic>(rsPiclist);

			view = new ModelAndView("rspic/queryRsPic");
			view.addObject("rsPiclist", rsPiclist);
			view.addObject("entityPage", rsPic.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("rsPic", rsPic);
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
	public void exportRsPic(RsPic rsPic, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "RsPic-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (rsPic.getEntityPage() == null) {
				rsPic.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(rsPic.getEntityPage()), super.getPageSize(rsPic.getEntityPage()));
			List<RsPic> exportlist = rsPicService.queryRsPicList(rsPic);

			PoiWriteExcel<RsPic> pwe = new PoiWriteExcel<RsPic>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(rsPic.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	@RequestMapping(params = "method=merge")
	public ModelAndView merge(@RequestParam(value = "picFile", required = false) MultipartFile multipartFile, HttpServletRequest request, RsPic rsPic) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("rspic/addRsPic");
			String picTitle = rsPic.getPicTitle();
			if (null == picTitle || "".equals(picTitle)) {
				view.addObject("code", "1");
				return view;
			}
			String realName = UploadFileCom.uploadFileByFolder(multipartFile, request, Consts.WX_PIC_FOLDER_NAME, configParameter.getUploadPicUrl());

			String rsPicId = rsPic.getPicId();
			if (null != rsPicId && !"".equals(rsPicId)) {
				// 修改
				RsPic dataRsPic = this.rsPicService.displayRsPic(rsPic);
				dataRsPic.setPicTitle(picTitle);
				if (null != realName && !"".equals(realName)) {
					dataRsPic.setPicFileName(realName);
				}
				this.rsPicService.updateRsPic(dataRsPic);
				view.addObject("rsPic", dataRsPic);
				view.addObject("code", "0");
			} else {
				// 新增
				if (null == realName || "".equals(realName)) {
					view.addObject("code", "2");
					return view;
				}
				rsPic.setPicFileName(realName);
				this.rsPicService.createRsPic(rsPic);
				view.addObject("rsPic", rsPic);
				view.addObject("code", "0");
			}
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

}

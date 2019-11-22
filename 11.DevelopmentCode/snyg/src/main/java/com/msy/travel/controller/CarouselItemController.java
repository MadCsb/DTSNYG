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
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.UploadFileCom;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Carousel;
import com.msy.travel.pojo.CarouselItem;
import com.msy.travel.service.CarouselItemService;
import com.msy.travel.service.CarouselService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/carouselItem")
public class CarouselItemController extends BaseController {
	public static final Log log = LogFactory.getLog(CarouselItemController.class);

	@Resource(name = "carouselItemServiceImpl")
	private CarouselItemService carouselItemService;

	@Resource(name = "carouselServiceImpl")
	private CarouselService carouselService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddCarouselItem(CarouselItem carouselItem, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("carouselItem/addCarouselItem");
		return view;
	}

	/**
	 * 新增CarouselItem
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addCarouselItem(@RequestParam(value = "picFile", required = false) MultipartFile multipartFile, CarouselItem carouselItem, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView view = null;
		try {
			// 上传缩略图
			String thumbPic = UploadFileCom.uploadFileByFolder(multipartFile, request, Consts.WX_PIC_FOLDER_NAME, configParameter.getUploadPicUrl());
			carouselItem.setItemId(PrimaryKeyUtil.generateKey());
			carouselItem.setPicUrl(thumbPic);

			carouselItemService.createCarouselItem(carouselItem);
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
	public ModelAndView toUpdateCarouselItem(CarouselItem carouselItem, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			CarouselItem objCarouselItem = carouselItemService.displayCarouselItem(carouselItem);
			view = new ModelAndView("carouselItem/updateCarouselItem");
			view.addObject("carouselItem", objCarouselItem);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改CarouselItem
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateCarouselItem(@RequestParam(value = "picFile", required = false) MultipartFile multipartFile, CarouselItem carouselItem, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView view = null;
		try {
			String th = carouselItem.getPicUrl();
			if (multipartFile != null && multipartFile.getSize() > 0) {
				th = UploadFileCom.uploadFileByFolder(multipartFile, request, Consts.WX_PIC_FOLDER_NAME, configParameter.getUploadPicUrl());
			}
			carouselItem.setPicUrl(th);
			carouselItemService.updateCarouselItem(carouselItem);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除CarouselItem
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteCarouselItem(CarouselItem carouselItem, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			carouselItemService.deleteCarouselItem(carouselItem);
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
	public ModelAndView deleteBatchCarouselItem(CarouselItem carouselItem, String checkedCarouselItemIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] carouselItemIds = checkedCarouselItemIds.split(",");
		List<String> carouselItemIdList = new ArrayList<String>();
		Collections.addAll(carouselItemIdList, carouselItemIds);
		try {
			carouselItem.setCarouselItemIdList(carouselItemIdList);
			carouselItemService.deleteBatchCarouselItem(carouselItem);
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
	public ModelAndView queryCarouselItemList(CarouselItem carouselItem, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (carouselItem.getEntityPage() == null) {
				carouselItem.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(carouselItem.getEntityPage()), super.getPageSize(carouselItem.getEntityPage()));
			List<CarouselItem> carouselItemlist = carouselItemService.queryCarouselItemList(carouselItem);
			PageInfo<CarouselItem> pageInfo = new PageInfo<CarouselItem>(carouselItemlist);

			Carousel carousel = new Carousel();
			carousel.setCarouselId(carouselItem.getCarouselId());
			carousel = carouselService.displayCarousel(carousel);

			view = new ModelAndView("carouselItem/queryCarouselItem");
			view.addObject("carouselItemlist", carouselItemlist);
			view.addObject("entityPage", carouselItem.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("carousel", carousel);
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
	public void exportCarouselItem(CarouselItem carouselItem, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "CarouselItem-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (carouselItem.getEntityPage() == null) {
				carouselItem.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(carouselItem.getEntityPage()), super.getPageSize(carouselItem.getEntityPage()));
			List<CarouselItem> exportlist = carouselItemService.queryCarouselItemList(carouselItem);

			PoiWriteExcel<CarouselItem> pwe = new PoiWriteExcel<CarouselItem>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(carouselItem.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

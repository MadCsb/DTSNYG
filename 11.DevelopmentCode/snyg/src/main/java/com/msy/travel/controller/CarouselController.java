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
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.pojo.Carousel;
import com.msy.travel.pojo.Pubmap;
import com.msy.travel.pojo.User;
import com.msy.travel.service.CarouselService;
import com.msy.travel.service.IPubmapService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/carousel")
public class CarouselController extends BaseController {
	public static final Log log = LogFactory.getLog(CarouselController.class);

	@Resource(name = "carouselServiceImpl")
	private CarouselService carouselService;

	@Resource(name = "pubmapServiceImpl")
	private IPubmapService pubmapService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddCarousel(Carousel carousel, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			List<Pubmap> lunboTypeList = this.pubmapService.getPubmapListByType("LUNBOTYPE");// 轮播图类型

			view = new ModelAndView("carousel/addCarousel");
			view.addObject("lunboTypeList", lunboTypeList);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增Carousel
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addCarousel(Carousel carousel, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			User user = this.getLoginUser(request);
			String current = DateTimeUtil.getDateTime19();

			carousel.setSpId(user.getAccId());
			carousel.setCreatourUid(user.getUserId());
			carousel.setCreator(user.getUserName());
			carousel.setCreateTime(current);
			carousel.setUpdaterUid(user.getUserId());
			carousel.setUpdater(user.getUserName());
			carousel.setUpdateTime(current);
			carousel.setDelFlag("0");
			carousel.setCarouselId(PrimaryKeyUtil.generateKey());
			carouselService.createCarousel(carousel);

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
	public ModelAndView toUpdateCarousel(Carousel carousel, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Carousel objCarousel = carouselService.displayCarousel(carousel);

			List<Pubmap> lunboTypeList = this.pubmapService.getPubmapListByType("LUNBOTYPE");// 轮播图类型

			view = new ModelAndView("carousel/updateCarousel");
			view.addObject("carousel", objCarousel);
			view.addObject("lunboTypeList", lunboTypeList);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改Carousel
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateCarousel(Carousel carousel, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			User user = this.getLoginUser(request);
			String current = DateTimeUtil.getDateTime19();

			carousel.setUpdaterUid(user.getUserId());
			carousel.setUpdater(user.getUserName());
			carousel.setUpdateTime(current);
			carousel.setDelFlag("0");
			carouselService.updateCarousel(carousel);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除Carousel
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteCarousel(Carousel carousel, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			carousel = carouselService.displayCarousel(carousel);
			carousel.setDelFlag("1");
			carouselService.updateCarousel(carousel);
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
	public ModelAndView deleteBatchCarousel(Carousel carousel, String checkedCarouselIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] carouselIds = checkedCarouselIds.split(",");
		List<String> carouselIdList = new ArrayList<String>();
		Collections.addAll(carouselIdList, carouselIds);
		try {
			carousel.setCarouselIdList(carouselIdList);
			carouselService.deleteBatchCarousel(carousel);
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
	public ModelAndView queryCarouselList(Carousel carousel, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			User user = this.getLoginUser(request);

			if (carousel.getEntityPage() == null) {
				carousel.setEntityPage(new EntityPage());
			}
			carousel.getEntityPage().setSortField("t.F_CREATETIME");
			carousel.getEntityPage().setSortOrder("DESC");
			carousel.setSpId(user.getAccId());
			carousel.setDelFlag("0");

			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(carousel.getEntityPage()), super.getPageSize(carousel.getEntityPage()));
			List<Carousel> carouselList = carouselService.queryCarouselList(carousel);
			PageInfo<Carousel> pageInfo = new PageInfo<Carousel>(carouselList);

			List<Pubmap> lunboTypeList = this.pubmapService.getPubmapListByType("LUNBOTYPE");// 轮播图类型

			view = new ModelAndView("carousel/queryCarousel");
			view.addObject("carouselList", carouselList);
			view.addObject("entityPage", carousel.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("carousel", carousel);
			view.addObject("lunboTypeList", lunboTypeList);
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
	public void exportCarousel(Carousel carousel, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			path = path + File.separator + "export";
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "Carousel-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (carousel.getEntityPage() == null) {
				carousel.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(carousel.getEntityPage()), super.getPageSize(carousel.getEntityPage()));
			List<Carousel> exportlist = carouselService.queryCarouselList(carousel);

			PoiWriteExcel<Carousel> pwe = new PoiWriteExcel<Carousel>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(carousel.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	@RequestMapping(params = "method=checkCarousel")
	public void checkCarousel(Carousel carousel, HttpServletRequest request, HttpServletResponse response) {
		PrintWriter printWrite = null;
		try {
			printWrite = response.getWriter();

			User user = this.getLoginUser(request);
			carousel.setSpId(user.getAccId());
			carousel.setDelFlag("0");

			// 相同名称的记录数
			int count = carouselService.checkCarousel(carousel);

			printWrite.print(count);
			printWrite.flush();
			printWrite.close();
		} catch (Exception e) {
			if (printWrite != null) {
				printWrite.flush();
				printWrite.close();
			}
			log.error(e, e);
		}
	}

}

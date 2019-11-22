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
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.MsgNews;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IMsgNewsService;
import com.msy.travel.service.IServiceCodeService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/msgNews")
public class MsgNewsController extends BaseController {
	public static final Log log = LogFactory.getLog(MsgNewsController.class);

	@Resource(name = "msgNewsServiceImpl")
	private IMsgNewsService msgNewsService;

	@Resource(name = "destspServiceImpl")
	private IDestspService destspService;

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;
	
	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddMsgNews(MsgNews msgNews,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;

		try {
			// 当前用户
			User user = this.getLoginUser(request);
			Destsp destsp = new Destsp();
			if (user != null) {
				destsp.setSpId(user.getAccId());
				destsp = destspService.displayDestsp(destsp);
			}

			ServiceCode serviceCode = new ServiceCode();
			serviceCode.setServiceId(destsp.getWxServiceId());
			serviceCode = serviceCodeService.displayServiceCode(serviceCode);
			String serviceCodeUrl = serviceCode.getUrl();

			if (msgNews != null && msgNews.getNewsId() != null
					&& !"".equals(msgNews.getNewsId())) {
				msgNews = msgNewsService.displayMsgNews(msgNews);
			}
			view = new ModelAndView("msgnews/addMsgNews");
			view.addObject("msgNews", msgNews);
			view.addObject("serviceCodeUrl", serviceCodeUrl);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增/修改
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addMsgNews(
			@RequestParam(value = "picFile", required = false) MultipartFile multipartFile,
			MsgNews msgNews, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView view = null;
		try {

			view = new ModelAndView("msgnews/addMsgNews");

			// 上传图片
			String picUrl = msgNews.getPicUrl();
			String reaName = UploadFileCom.uploadFileByFolder(multipartFile,
					request, Consts.WX_PIC_FOLDER_NAME,
					configParameter.getUploadPicUrl());
			if (reaName != null && !"".equals(reaName)) {
				picUrl = reaName;
			}

			// 保存数据
			msgNews.setPicUrl(picUrl);
			if (msgNews.getNewsId() == null || "".equals(msgNews.getNewsId())) {
				msgNews.setNewsId(PrimaryKeyUtil.generateKey());
				msgNewsService.createMsgNews(msgNews);
			} else {
				msgNewsService.updateMsgNews(msgNews);
			}

			view.addObject("code", "0");
			view.addObject("msgNews", msgNews);

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
	public ModelAndView toUpdateMsgNews(MsgNews msgNews,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			MsgNews objMsgNews = msgNewsService.displayMsgNews(msgNews);
			view = new ModelAndView("msgnews/updateMsgNews");
			view.addObject("msgNews", objMsgNews);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改MsgNews
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateMsgNews(MsgNews msgNews,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			msgNewsService.updateMsgNews(msgNews);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除MsgNews
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteMsgNews(MsgNews msgNews,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			msgNewsService.deleteMsgNews(msgNews);
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
	public ModelAndView deleteBatchMsgNews(MsgNews msgNews,
			String checkedMsgNewsIds, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView view = null;
		String[] msgNewsIds = checkedMsgNewsIds.split(",");
		List<String> msgNewsIdList = new ArrayList<String>();
		Collections.addAll(msgNewsIdList, msgNewsIds);
		try {
			msgNews.setMsgNewsIdList(msgNewsIdList);
			msgNewsService.deleteBatchMsgNews(msgNews);
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
	public ModelAndView queryMsgNewsList(MsgNews msgNews,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (msgNews.getEntityPage() == null) {
				msgNews.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(msgNews.getEntityPage()),
					super.getPageSize(msgNews.getEntityPage()));
			List<MsgNews> msgNewslist = msgNewsService
					.queryMsgNewsList(msgNews);
			PageInfo<MsgNews> pageInfo = new PageInfo<MsgNews>(msgNewslist);

			view = new ModelAndView("msgnews/queryMsgNews");
			view.addObject("msgNewslist", msgNewslist);
			view.addObject("entityPage", msgNews.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("msgNews", msgNews);
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
	public void exportMsgNews(MsgNews msgNews, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext()
					.getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "MsgNews-" + DateTimeUtil.getDateTime14()
					+ ".xls";
			path = path + File.separator + tempName;

			if (msgNews.getEntityPage() == null) {
				msgNews.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(msgNews.getEntityPage()),
					super.getPageSize(msgNews.getEntityPage()));
			List<MsgNews> exportlist = msgNewsService.queryMsgNewsList(msgNews);

			PoiWriteExcel<MsgNews> pwe = new PoiWriteExcel<MsgNews>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(msgNews.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

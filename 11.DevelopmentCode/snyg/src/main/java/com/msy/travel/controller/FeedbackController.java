package com.msy.travel.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

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
import com.msy.travel.pojo.Feedback;
import com.msy.travel.pojo.MsgNews;
import com.msy.travel.pojo.Pubmap;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.pojo.WxMenu;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IFeedbackService;
import com.msy.travel.service.IMsgNewsService;
import com.msy.travel.service.IPubmapService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IWxMenuService;
import com.msy.travel.wx.utils.WeixinService;
import com.msy.travel.wx.utils.WeixinUtil;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/feedback")
public class FeedbackController extends BaseController {
	public static final Log log = LogFactory.getLog(FeedbackController.class);

	@Resource(name = "feedbackServiceImpl")
	private IFeedbackService feedbackService;

	@Resource(name = "destspServiceImpl")
	private IDestspService destspService;

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "pubmapServiceImpl")
	private IPubmapService pubmapService;

	@Resource(name = "msgNewsServiceImpl")
	private IMsgNewsService msgNewsService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Resource(name = "wxMenuServiceImpl")
	private IWxMenuService wxMenuService;

	/**
	 * 跳转到新增页面
	 */
	// @RequiresPermissions({ "addWenben", "addTuwen", "addDuoTuwen",
	// "addLianjie", "addKefu" })
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddFeedback(Feedback feedback, HttpServletRequest request, HttpServletResponse response) {

		ModelAndView view = null;
		String msgType = feedback.getMsgType();
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
			feedback.setUrl(serviceCode.getUrl());
			feedback.setSpId(user.getAccId());

			List<Pubmap> pubmapList = new ArrayList<Pubmap>();

			// 文本
			if ("0".equals(msgType)) {
				view = new ModelAndView("feedback/addFeedbackWenben");
			} else if ("2".equals(msgType)) {// 单图文
				view = new ModelAndView("feedback/addFeedbackTuwen");
			} else if ("6".equals(msgType)) {// 多图文
				view = new ModelAndView("feedback/addFeedbackDuotuwen");
			} else if ("7".equals(msgType)) {// 链接
				view = new ModelAndView("feedback/addFeedbackLianjie");
			} else if ("8".equals(msgType)) {// 系统消息
				view = new ModelAndView("feedback/addFeedbackKefu");
				pubmapList = pubmapService.getPubmapListByType("SYSMSGTYPE");
			}

			view.addObject("feedback", feedback);
			view.addObject("pubmapList", pubmapList);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}

		return view;
	}

	/**
	 * 新增Feedback
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addFeedback(Feedback feedback, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Destsp destsp = new Destsp();

			// 当前用户
			User user = this.getLoginUser(request);
			if (user != null) {
				destsp.setSpId(user.getAccId());
				destsp = destspService.displayDestsp(destsp);
			}

			ServiceCode sc = new ServiceCode();
			sc.setServiceId(destsp.getWxServiceId());
			sc = serviceCodeService.displayServiceCode(sc);

			// 保存消息
			feedback.setFeedBackId(PrimaryKeyUtil.generateKey());
			feedback.setWxServiceId(destsp.getWxServiceId());
			feedback.setLastUpdate(DateTimeUtil.getDateTime19());
			feedback.setDelFlag("0");

			// 保存
			String msg = feedbackService.saveFeedbackByAdd(request, feedback, sc);
			if (msg == null || "".equals(msg)) {
				view = new ModelAndView("success");
			} else {
				view = new ModelAndView("error");
			}
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
	// @RequiresPermissions({ "modifyWenben", "modifyTuwen", "modifyDuoTuwen",
	// "modifyLianjie", "modifyKefu" })
	@RequestMapping(params = "method=toUpdate")
	public ModelAndView toUpdateFeedback(Feedback feedback, HttpServletRequest request, HttpServletResponse response) {

		ModelAndView view = null;

		try {
			feedback = feedbackService.displayFeedback(feedback);
			String feedbackId = feedback.getFeedBackId();
			String msgType = feedback.getMsgType();

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
			feedback.setUrl(serviceCode.getUrl());
			feedback.setSpId(user.getAccId());

			List<Pubmap> pubmapList = new ArrayList<Pubmap>();

			// 文本
			if ("0".equals(msgType)) {
				view = new ModelAndView("feedback/updateFeedbackWenben");
			} else if ("2".equals(msgType)) {// 单图文
				view = new ModelAndView("feedback/updateFeedbackTuwen");

				// 检索图片
				MsgNews msgNews = new MsgNews();
				MsgNews msgNewsSearch = new MsgNews();
				msgNewsSearch.setFeedbackId(feedbackId);
				List<MsgNews> msgNewsList = msgNewsService.getMsgNewsByFeedbackId(msgNewsSearch);
				if (msgNewsList != null && msgNewsList.size() > 0) {
					msgNews = msgNewsList.get(0);
				}

				view.addObject("msgNews", msgNews);

			} else if ("6".equals(msgType)) {// 多图文

				view = new ModelAndView("feedback/updateFeedbackDuotuwen");

				// 检索图片
				MsgNews msgNewsSearch = new MsgNews();
				msgNewsSearch.setFeedbackId(feedbackId);
				List<MsgNews> msgNewsList = msgNewsService.getMsgNewsByFeedbackId(msgNewsSearch);

				view.addObject("msgNewsList", msgNewsList);

			} else if ("7".equals(msgType)) {// 链接
				view = new ModelAndView("feedback/updateFeedbackLianjie");
			} else if ("8".equals(msgType)) {// 系统消息
				view = new ModelAndView("feedback/updateFeedbackKefu");
				pubmapList = pubmapService.getPubmapListByType("SYSMSGTYPE");
				view.addObject("pubmapList", pubmapList);
			}

			view.addObject("feedback", feedback);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}

		return view;
	}

	/**
	 * 修改Feedback
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateFeedback(Feedback feedback, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Destsp destsp = new Destsp();

			// 当前用户
			User user = this.getLoginUser(request);
			if (user != null) {
				destsp.setSpId(user.getAccId());
				destsp = destspService.displayDestsp(destsp);
			}

			ServiceCode sc = new ServiceCode();
			sc.setServiceId(destsp.getWxServiceId());
			sc = serviceCodeService.displayServiceCode(sc);

			// 保存消息
			feedback.setWxServiceId(destsp.getWxServiceId());
			feedback.setLastUpdate(DateTimeUtil.getDateTime19());

			// 保存
			String msg = feedbackService.saveFeedbackByUpdate(request, feedback, sc);
			if (msg == null || "".equals(msg)) {
				view = new ModelAndView("success");
			} else {
				view = new ModelAndView("error");
			}
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除Feedback
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteFeedback(Feedback feedback, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			feedbackService.deleteFeedback(feedback);
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
	public ModelAndView deleteBatchFeedback(Feedback feedback, String checkedFeedbackIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] feedbackIds = checkedFeedbackIds.split(",");
		List<String> feedbackIdList = new ArrayList<String>();
		Collections.addAll(feedbackIdList, feedbackIds);
		try {
			feedback.setFeedbackIdList(feedbackIdList);
			feedbackService.deleteBatchFeedback(feedback);
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
	// @RequiresPermissions({ "queryWxMsg" })
	@RequestMapping(params = "method=query")
	public ModelAndView queryFeedbackList(Feedback feedback, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (feedback.getEntityPage() == null) {
				EntityPage entityPage = new EntityPage();
				entityPage.setSortField("t.F_LASTUPDATE");
				entityPage.setSortOrder("DESC");
				feedback.setEntityPage(entityPage);
			}
			super.saveBackUrl(request);

			// 检索服务号ID
			String wxServiceId = "";
			String spId = this.getLoginUser(request).getAccId();
			Destsp destsp = new Destsp();
			destsp.setSpId(spId);
			destsp = destspService.displayDestsp(destsp);
			if (destsp != null) {
				wxServiceId = destsp.getWxServiceId();
			}

			feedback.setWxServiceId(wxServiceId);
			String msgType = feedback.getMsgType();

			// 其它
			if (msgType == null || "".equals(msgType)) {
				view = new ModelAndView("feedback/toBindSpFeedbackId");

				ServiceCode serviceCode = new ServiceCode();
				serviceCode.setServiceId(wxServiceId);
				serviceCode = serviceCodeService.displayServiceCode(serviceCode);

				List<Feedback> inMsgFeedbackList = new ArrayList<Feedback>();
				List<Feedback> unReadMsgFeedbackList = new ArrayList<Feedback>();

				// 检索用户关注时回复消息
				if (serviceCode.getInMsgType() != null && !"".equals(serviceCode.getInMsgType())) {
					feedback = new Feedback();

					// 排序
					EntityPage entityPage = new EntityPage();
					entityPage.setSortField("t.F_LASTUPDATE");
					entityPage.setSortOrder("DESC");
					feedback.setEntityPage(entityPage);

					feedback.setWxServiceId(destsp.getWxServiceId());
					feedback.setMsgType(serviceCode.getInMsgType());
					inMsgFeedbackList = feedbackService.queryFeedbackListByCustom(feedback);
				}

				// 检索无法识别时回复消息
				if (serviceCode.getUnReadMsgType() != null && !"".equals(serviceCode.getUnReadMsgType())) {

					feedback = new Feedback();

					// 排序
					EntityPage entityPage = new EntityPage();
					entityPage.setSortField("t.F_LASTUPDATE");
					entityPage.setSortOrder("DESC");
					feedback.setEntityPage(entityPage);

					feedback.setWxServiceId(destsp.getWxServiceId());
					feedback.setMsgType(serviceCode.getUnReadMsgType());
					unReadMsgFeedbackList = feedbackService.queryFeedbackListByCustom(feedback);
				}

				// 返回
				view.addObject("serviceCode", serviceCode);
				view.addObject("inMsgFeedbackList", inMsgFeedbackList);
				view.addObject("unReadMsgFeedbackList", unReadMsgFeedbackList);

			} else {

				// 设置分页
				PageHelper.startPage(super.getPageNum(feedback.getEntityPage()), super.getPageSize(feedback.getEntityPage()));

				List<Feedback> feedbacklist = feedbackService.queryFeedbackList(feedback);
				PageInfo<Feedback> pageInfo = new PageInfo<Feedback>(feedbacklist);

				// 文本
				if ("0".equals(msgType)) {
					view = new ModelAndView("feedback/queryFeedbackWenben");
				} else if ("2".equals(msgType)) {// 单图文
					view = new ModelAndView("feedback/queryFeedbackTuwen");
				} else if ("6".equals(msgType)) {// 多图文
					view = new ModelAndView("feedback/queryFeedbackDuotuwen");
				} else if ("7".equals(msgType)) {// 链接
					view = new ModelAndView("feedback/queryFeedbackLianjie");
				} else if ("8".equals(msgType)) {// 系统消息
					view = new ModelAndView("feedback/queryFeedbackKefu");
				}

				// 返回
				view.addObject("feedbacklist", feedbacklist);
				view.addObject("entityPage", feedback.getEntityPage());
				view.addObject("pageInfo", pageInfo);
			}

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
	public void exportFeedback(Feedback feedback, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "Feedback-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (feedback.getEntityPage() == null) {
				feedback.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(feedback.getEntityPage()), super.getPageSize(feedback.getEntityPage()));
			List<Feedback> exportlist = feedbackService.queryFeedbackList(feedback);

			PoiWriteExcel<Feedback> pwe = new PoiWriteExcel<Feedback>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(feedback.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 启用/停用
	 */
	// @RequiresPermissions({ "useWenben", "useTuwen", "useDuoTuwen",
	// "useLianjie", "useKefu" })
	@RequestMapping(params = "method=resetDelFlag")
	public void resetDelFlag(Feedback feedback, HttpServletRequest request, HttpServletResponse response) {

		// 0:失败 1：成功 2:已经在使用
		String resultCode = "0";
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();

			String feedbackId = feedback.getFeedBackId();
			String delFlag = feedback.getDelFlag();

			// 需要停用消息
			if ("1".equals(delFlag)) {

				// 判断微信菜单没有使用该消息
				if (!isUsed(feedback.getFeedBackId()) && !isUsed(feedback.getFeedBackId(), this.getLoginUser(request))) {

					// 更新删除标志
					updateSingle(feedbackId, delFlag);

					resultCode = "1";
				} else {
					resultCode = "2";
				}
			} else {

				// 更新删除标志
				updateSingle(feedbackId, delFlag);

				resultCode = "1";
			}

			out.print(resultCode);
			out.flush();
			out.close();
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 批量启用/停用
	 */
	// @RequiresPermissions({ "useWenben", "useTuwen", "useDuoTuwen",
	// "useLianjie", "useKefu" })
	@RequestMapping(params = "method=batchResetDelFlag")
	public void batchResetDelFlag(Feedback feedback, String checkedFeedbackIds, HttpServletRequest request, HttpServletResponse response) {

		// 0:失败 1：成功
		String resultCode = "0";

		// 成功的ID
		String successIds = "";

		// 失败的ID
		String errorIds = "";

		try {

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();

			String[] feedbackIds = checkedFeedbackIds.split(",");

			// 0:启用 1：停用
			String operateDelFlag = feedback.getDelFlag();
			String feedbackId = "";

			// 需要停用消息
			if ("1".equals(operateDelFlag)) {

				if (feedbackIds != null && feedbackIds.length > 0) {
					for (int i = 0; i < feedbackIds.length; i++) {
						feedbackId = feedbackIds[i];

						// 判断微信菜单没有使用该消息
						if (!isUsed(feedbackId) && !isUsed(feedbackId, this.getLoginUser(request))) {

							// 更新删除标志
							updateSingle(feedbackId, operateDelFlag);

							if ("".equals(successIds)) {
								successIds = feedbackId;
							} else {
								successIds = successIds + "," + feedbackId;
							}

						} else {

							// 已经使用，操作失败
							if ("".equals(errorIds)) {
								errorIds = feedbackId;
							} else {
								errorIds = errorIds + "," + feedbackId;
							}
						}
					}

					String alertContent = "<div style='width:400px;word-break:break-all;'>";

					if (!"".equals(successIds)) {
						alertContent = alertContent + "已停用以下消息：" + successIds + "。</br>";
					}

					if (!"".equals(errorIds)) {
						alertContent = alertContent + "以下消息已经被使用，不能停用：" + errorIds + "。";
					}
					alertContent = alertContent + "</div>";
					resultCode = alertContent;
				}
			} else {

				// 直接批量更新
				List<String> feedbackIdList = new ArrayList<String>();
				Collections.addAll(feedbackIdList, feedbackIds);
				feedback.setLastUpdate(DateTimeUtil.getDateTime19());
				feedback.setFeedbackIdList(feedbackIdList);
				feedbackService.batchResetDelFlag(feedback);

				String alertContent = "<div style='width:400px;word-break:break-all;'>";
				alertContent = alertContent + "已启用以下消息：" + checkedFeedbackIds + "。";
				alertContent = alertContent + "</div>";

				resultCode = alertContent;
			}

			out.print(resultCode);
			out.flush();
			out.close();

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 更新单个删除标志
	 * 
	 * @param feedbackId
	 * @param delFlag
	 * @throws Exception
	 */
	private void updateSingle(String feedbackId, String delFlag) throws Exception {

		// 更新删除标志
		Feedback feedback = new Feedback();
		feedback.setFeedBackId(feedbackId);
		feedback.setDelFlag(delFlag);
		feedback.setLastUpdate(DateTimeUtil.getDateTime19());
		feedbackService.deleteFeedback(feedback);
	}

	/**
	 * 判断微信菜单是否使用该消息
	 * 
	 * @param feedBackId
	 * @return true:使用；false:未使用
	 * @throws Exception
	 */
	private boolean isUsed(String feedBackId) throws Exception {
		boolean result = false;

		// 根据消息ID检索菜单
		WxMenu wxMenu = new WxMenu();
		wxMenu.setFeedBackId(feedBackId);
		List<WxMenu> list = wxMenuService.queryWxMenuList(wxMenu);
		if (list != null && list.size() > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * 判断关注或未识别消息是否绑定
	 * 
	 * @author Gengb
	 * @date 2018年5月15日 下午2:00:20
	 * @param feedBackId
	 * @param user
	 * @throws Exception
	 * @return boolean true:使用；false:未使用
	 */
	private boolean isUsed(String feedBackId, User user) throws Exception {
		boolean result = false;

		Destsp destsp = new Destsp();
		destsp.setSpId(user.getAccId());
		destsp = this.destspService.displayDestsp(destsp);

		if (destsp.getWxServiceId() != null && !"".equals(destsp.getWxServiceId())) {
			ServiceCode serviceCode = new ServiceCode();
			serviceCode.setServiceId(destsp.getWxServiceId());
			serviceCode = this.serviceCodeService.displayServiceCode(serviceCode);

			if (feedBackId.equals(serviceCode.getInMsgId()) || feedBackId.equals(serviceCode.getUnreadMsgId())) {
				result = true;
			}
		}

		return result;
	}

	/**
	 * 根据类型获取消息列表
	 * 
	 * @param feedback
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "method=getFeedbackListByType")
	public void getFeedbackListByType(Feedback feedback, HttpServletRequest request, HttpServletResponse response) {
		PrintWriter pw = null;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try {
			if (feedback.getEntityPage() == null) {
				EntityPage entityPage = new EntityPage();
				entityPage.setSortField("t.F_LASTUPDATE");
				entityPage.setSortOrder("DESC");
				feedback.setEntityPage(entityPage);
			}

			List<Feedback> feedbackList = feedbackService.queryFeedbackListByCustom(feedback);

			pw = response.getWriter();
			JSONObject json = new JSONObject();
			json.put("feedbackList", feedbackList);
			pw.write(json.toString());
			pw.flush();
			pw.close();
		} catch (Exception e) {
			if (pw != null) {
				pw.close();
			}
			log.error(e, e);
		}
		return;
	}

	/**
	 * 更新其它
	 * 
	 * @param serviceCode
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "method=updateServiceCode")
	public ModelAndView updateServiceCode(ServiceCode serviceCode, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			ServiceCode sc = serviceCodeService.displayServiceCode(serviceCode);
			sc.setInMsgId(serviceCode.getInMsgId());
			sc.setUnreadMsgId(serviceCode.getUnreadMsgId());
			serviceCodeService.updateServiceCode(sc);

			view = new ModelAndView("success");
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增图文
	 */
	@RequestMapping(params = "method=addFeedbackTuwen")
	public ModelAndView addFeedbackTuwen(@RequestParam(value = "picFile", required = false) MultipartFile multipartFile, Feedback feedback, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Destsp destsp = new Destsp();

			// 当前用户
			User user = this.getLoginUser(request);
			if (user != null) {
				destsp.setSpId(user.getAccId());
				destsp = destspService.displayDestsp(destsp);
			}

			ServiceCode sc = new ServiceCode();
			sc.setServiceId(destsp.getWxServiceId());
			sc = serviceCodeService.displayServiceCode(sc);

			// 上传图片
			String realName = UploadFileCom.uploadFileByFolder(multipartFile, request, Consts.WX_PIC_FOLDER_NAME, configParameter.getUploadPicUrl());

			// 保存消息
			feedback.setFeedBackId(PrimaryKeyUtil.generateKey());
			feedback.setWxServiceId(destsp.getWxServiceId());
			feedback.setLastUpdate(DateTimeUtil.getDateTime19());

			// 图片
			MsgNews msgNews = null;
			if (realName != null && !"".equals(realName)) {
				msgNews = new MsgNews();
				msgNews.setNewsId(PrimaryKeyUtil.generateKey());
				msgNews.setPicUrl(realName);
				msgNews.setIsMain("0");// 0：否
				msgNews.setFeedbackId(feedback.getFeedBackId());
			}

			// 保存
			String msg = feedbackService.addFeedbackTuwen(request, feedback, sc, msgNews);
			if (msg == null || "".equals(msg)) {
				view = new ModelAndView("success");
			} else {
				view = new ModelAndView("error");
			}
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改图文
	 */
	@RequestMapping(params = "method=updateFeedbackTuwen")
	public ModelAndView updateFeedbackTuwen(@RequestParam(value = "picFile", required = false) MultipartFile multipartFile, Feedback feedback, String picUrl, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Destsp destsp = new Destsp();

			// 当前用户
			User user = this.getLoginUser(request);
			if (user != null) {
				destsp.setSpId(user.getAccId());
				destsp = destspService.displayDestsp(destsp);
			}

			ServiceCode sc = new ServiceCode();
			sc.setServiceId(destsp.getWxServiceId());
			sc = serviceCodeService.displayServiceCode(sc);

			// 上传图片
			String realName = picUrl;
			String newRealName = UploadFileCom.uploadFileByFolder(multipartFile, request, Consts.WX_PIC_FOLDER_NAME, configParameter.getUploadPicUrl());
			if (newRealName != null && !"".equals(newRealName)) {
				realName = newRealName;
			}

			// 保存消息
			feedback.setWxServiceId(destsp.getWxServiceId());
			feedback.setLastUpdate(DateTimeUtil.getDateTime19());

			// 图片
			MsgNews msgNews = null;
			if (realName != null && !"".equals(realName)) {
				msgNews = new MsgNews();
				msgNews.setNewsId(PrimaryKeyUtil.generateKey());
				msgNews.setPicUrl(realName);
				msgNews.setIsMain("0");// 0：否
				msgNews.setFeedbackId(feedback.getFeedBackId());
			}

			// 保存
			String msg = feedbackService.updateFeedbackTuwen(request, feedback, sc, msgNews);
			if (msg == null || "".equals(msg)) {
				view = new ModelAndView("success");
			} else {
				view = new ModelAndView("error");
			}
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增多图文
	 */
	@RequestMapping(params = "method=addFeedbackDuotuwen")
	public ModelAndView addFeedbackDuotuwen(String newsIds, Feedback feedback, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Destsp destsp = new Destsp();

			// 当前用户
			User user = this.getLoginUser(request);
			if (user != null) {
				destsp.setSpId(user.getAccId());
				destsp = destspService.displayDestsp(destsp);
			}

			ServiceCode sc = new ServiceCode();
			sc.setServiceId(destsp.getWxServiceId());
			sc = serviceCodeService.displayServiceCode(sc);

			// 消息
			feedback.setFeedBackId(PrimaryKeyUtil.generateKey());
			feedback.setWxServiceId(destsp.getWxServiceId());
			feedback.setLastUpdate(DateTimeUtil.getDateTime19());

			// 保存
			String msg = feedbackService.addFeedbackDuotuwen(request, feedback, sc, newsIds);
			if (msg == null || "".equals(msg)) {
				view = new ModelAndView("success");
			} else {
				view = new ModelAndView("error");
			}
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改多图文
	 */
	@RequestMapping(params = "method=updateFeedbackDuotuwen")
	public ModelAndView updateFeedbackDuotuwen(String newsIds, Feedback feedback, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Destsp destsp = new Destsp();

			// 当前用户
			User user = this.getLoginUser(request);
			if (user != null) {
				destsp.setSpId(user.getAccId());
				destsp = destspService.displayDestsp(destsp);
			}

			ServiceCode sc = new ServiceCode();
			sc.setServiceId(destsp.getWxServiceId());
			sc = serviceCodeService.displayServiceCode(sc);

			// 消息
			feedback.setWxServiceId(destsp.getWxServiceId());
			feedback.setLastUpdate(DateTimeUtil.getDateTime19());

			// 保存
			String msg = feedbackService.updateFeedbackDuotuwen(request, feedback, sc, newsIds);
			if (msg == null || "".equals(msg)) {
				view = new ModelAndView("success");
			} else {
				view = new ModelAndView("error");
			}
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 微信发送群组消息预览接口
	 */
	public void previewSendMsg(Feedback feedback, HttpServletRequest request, HttpServletResponse response) {
		String res = "0";
		String msg = "";
		String mediaId = "";
		try {

			Destsp destsp = new Destsp();

			// 当前用户
			User user = this.getLoginUser(request);
			if (user != null) {
				destsp.setSpId(user.getAccId());
				destsp = destspService.displayDestsp(destsp);
			}

			ServiceCode sc = new ServiceCode();
			sc.setServiceId(destsp.getWxServiceId());
			sc = serviceCodeService.displayServiceCode(sc);

			if (feedback == null) {
				feedback = new Feedback();
			} else {
				feedback = feedbackService.displayFeedback(feedback);
			}

			String jsonstr = createMsgNewsJson(feedback, this.getLoginUser(request));

			JSONObject jsonObject = WeixinUtil.uploadWxNews(WeixinService.getAccessToken(sc), jsonstr);
			if (jsonObject == null) {

				res = "-1";
				msg = "上传图文素材失败";
				log.info("============jsonObject为null");
			} else {

				mediaId = jsonObject.optString("media_id", null);
				log.info("============mediaId为[" + mediaId + "]");
				if (mediaId != null && !"".equals(mediaId)) {

					String previewmsgstr = "{\"towxname\":\"WXNAME\",\"mpnews\":{\"media_id\":\"MEDIAID\"},\"msgtype\":\"mpnews\"}";
					previewmsgstr = previewmsgstr.replace("MEDIAID", mediaId).replace("WXNAME", feedback.getWxName());

					jsonObject = WeixinUtil.previewSendMsg(WeixinService.getAccessToken(sc), previewmsgstr);

					if (jsonObject != null) {

						res = jsonObject.getString("errcode");
						msg = jsonObject.getString("errmsg");
					} else {
						msg = "预览消息失败";
						res = "-1";
					}

				} else {
					msg = "图文素材MEDIAID获取失败";
					res = "-1";
				}

			}

		} catch (Exception e) {
			log.error(e, e);
		}

		try {
			response.getWriter().print("{\"res\":\"" + res + "\",\"msg\":\"" + msg + "\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String createMsgNewsJson(Feedback feedback, User user) throws Exception {

		MsgNews msgNewsSearch = new MsgNews();
		msgNewsSearch.setFeedbackId(feedback.getFeedBackId());
		List<MsgNews> msgNewsList = msgNewsService.getMsgNewsByFeedbackId(msgNewsSearch);

		Map<String, List<Map<String, String>>> articlesMap = new HashMap<String, List<Map<String, String>>>();

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> newsMap;

		for (MsgNews msgNews : msgNewsList) {
			newsMap = new HashMap<String, String>();
			newsMap.put("thumb_media_id", msgNews.getSortNum());
			newsMap.put("author", "");
			newsMap.put("title", msgNews.getNewsTitle());
			newsMap.put("content_source_url", msgNews.getLinkUrl());
			newsMap.put("content", msgNews.getNewsDesc());
			newsMap.put("digest", "");
			newsMap.put("show_cover_pic", "0");
			list.add(newsMap);
		}
		articlesMap.put("articles", list);

		JSONObject jsonObject = JSONObject.fromObject(articlesMap);

		log.info("上传图文素材jsonstr：" + jsonObject.toString());

		return jsonObject.toString();
	}

	/**
	 * 重名校验
	 * 
	 * @param feedback
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "method=checkName")
	public void checkScenic(Feedback feedback, HttpServletRequest request, HttpServletResponse response) {
		PrintWriter printWrite = null;
		try {
			printWrite = response.getWriter();

			// 相同名称的记录数
			int count = this.feedbackService.checkName(feedback);

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

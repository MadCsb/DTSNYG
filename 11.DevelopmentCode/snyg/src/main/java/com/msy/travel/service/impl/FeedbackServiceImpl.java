package com.msy.travel.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.FileUtil;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.dao.FeedbackDao;
import com.msy.travel.pojo.Feedback;
import com.msy.travel.pojo.MsgNews;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.service.IFeedbackService;
import com.msy.travel.service.IMsgNewsService;
import com.msy.travel.wx.resp.Article;
import com.msy.travel.wx.resp.NewsMessage;
import com.msy.travel.wx.resp.TextMessage;
import com.msy.travel.wx.utils.MessageUtil;

/**
 * FeedbackService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class FeedbackServiceImpl implements IFeedbackService {

	@Resource(name = "feedbackDao")
	private FeedbackDao feedbackDao;

	@Resource(name = "msgNewsServiceImpl")
	private IMsgNewsService msgNewsService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	/**
	 * 新增Feedback
	 * 
	 * @param feedback
	 *            Feedback对象
	 */
	public void createFeedback(Feedback feedback) throws Exception {
		feedbackDao.insertFeedback(feedback);
	}

	/**
	 * 检查Feedback
	 * 
	 * @param feedback
	 *            Feedback对象
	 */
	public void mergeFeedback(Feedback feedback) throws Exception {
		feedbackDao.mergeFeedback(feedback);
	}

	/**
	 * 删除Feedback
	 * 
	 * @param feedback
	 *            Feedback对象
	 */
	public void deleteFeedback(Feedback feedback) throws Exception {
		feedbackDao.deleteFeedback(feedback);
	}

	/**
	 * 修改Feedback
	 * 
	 * @param feedback
	 *            Feedback对象
	 */
	public void updateFeedback(Feedback feedback) throws Exception {
		feedbackDao.updateFeedback(feedback);
	}

	/**
	 * 批量删除Feedback
	 * 
	 * @param feedbackIdList
	 *            存放feedback主键的list
	 */
	public void deleteBatchFeedback(Feedback feedback) throws Exception {
		feedbackDao.deleteBatchFeedback(feedback);
	}

	/**
	 * 查询单个Feedback
	 * 
	 * @param feedback
	 *            Feedback对象
	 * 
	 * @return 成员实体对象
	 */
	public Feedback displayFeedback(Feedback feedback) throws Exception {
		return feedbackDao.queryFeedback(feedback);
	}

	/**
	 * 查询Feedback列表
	 * 
	 * @param feedback
	 *            Feedback对象
	 * 
	 * @return Feedback列表
	 */
	public List<Feedback> queryFeedbackList(Feedback feedback) throws Exception {
		return feedbackDao.queryFeedbackList(feedback);
	}

	/**
	 * 获取FeedbackID
	 */
	public String getFeedbackId() throws Exception {
		return feedbackDao.getFeedbackId();
	}

	public List<Feedback> queryFeedbackListByCustom(Feedback feedback)
			throws Exception {
		return feedbackDao.queryFeedbackListByCustom(feedback);
	}

	/**
	 * 添加消息
	 * 
	 * @param feedback
	 * @throws Exception
	 */
	public String saveFeedbackByAdd(HttpServletRequest request,
			Feedback feedback, ServiceCode sc) throws Exception {

		// 插入
		feedbackDao.insertFeedback(feedback);

		// 生成响应xml文件
		createNewsXmlFile(request, feedback, sc);

		return "";
	}

	/**
	 * 修改消息
	 * 
	 * @param feedback
	 * @throws Exception
	 */
	public String saveFeedbackByUpdate(HttpServletRequest request,
			Feedback feedback, ServiceCode sc) throws Exception {

		// 修改
		feedbackDao.updateFeedback(feedback);

		// 生成响应xml文件
		createNewsXmlFile(request, feedback, sc);

		return "";
	}

	/**
	 * 生成响应xml文件
	 * 
	 * @param fb
	 * @param serviceCode
	 * @throws Exception
	 */
	public void createNewsXmlFile(HttpServletRequest request, Feedback fb,
			ServiceCode serviceCode) throws Exception {
		String xmlstr = "";
		if (fb.getMsgType() != null) {
			
			// 单图文或者多图片
			if ("2".equals(fb.getMsgType()) || "6".equals(fb.getMsgType())) {
				NewsMessage message = new NewsMessage();
				message.setToUserName("%{TO_USER_NAME}");
				message.setFromUserName("%{FROM_USER_NAME}");
				message.setCreateTime(DateTimeUtil.convertDateTimeToLong());
				message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

				MsgNews msgNews = new MsgNews();
				msgNews.setFeedbackId(fb.getFeedBackId());
				List<MsgNews> msgNewsList = msgNewsService
						.getMsgNewsByFeedbackId(msgNews);
				List<Article> articleList = new ArrayList<Article>();
				if (msgNewsList.size() > 0) {
					message.setArticleCount(msgNewsList.size());
					for (MsgNews news : msgNewsList) {
						Article article = new Article();
						article.setTitle(nullToEmpty(news.getNewsTitle()));
						
						// 单图文显示内容、多图文暂时不显示内容（因为内容是富文本框实现，包含html标签）
						if ("2".equals(fb.getMsgType())) {
							article.setDescription(nullToEmpty(news.getNewsDesc()));
						}
						
						if (news.getPicUrl() == null
								|| "".equals(news.getPicUrl())) {
							article.setPicUrl("");
						} else {
							article.setPicUrl(serviceCode.getUrl()
									+ "/upload/wxpic/" + news.getPicUrl());
						}

						article.setUrl(nullToEmpty(news.getLinkUrl()));
						articleList.add(article);
					}
					message.setArticles(articleList);
					xmlstr = MessageUtil.newsMessageToXml(message);

				}

			} else if ("0".equals(fb.getMsgType())) {
				TextMessage message = new TextMessage();
				message.setToUserName("%{TO_USER_NAME}");
				message.setFromUserName("%{FROM_USER_NAME}");
				message.setCreateTime(DateTimeUtil.convertDateTimeToLong());
				message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				message.setContent(fb.getContext());
				xmlstr = MessageUtil.textMessageToXml(message);
			}

			String path = configParameter.getUploadPicUrl() + File.separator
					+ "feedback" + File.separator + fb.getFeedBackId() + ".txt";
			FileUtil.writeFile(path, xmlstr);
		}
	}

	/**
	 * null转空字符串
	 * 
	 * @param value
	 * @return
	 */
	private String nullToEmpty(String value) {
		String result = "";
		if (value != null && !"".equals(value)) {
			result = value;
		}
		return result;
	}

	/**
	 * 批量更新消息状态
	 * 
	 * @param feedback
	 * @throws Exception
	 */
	public void batchResetDelFlag(Feedback feedback) throws Exception {
		feedbackDao.batchResetDelFlag(feedback);
	}

	/**
	 * 添加单图文
	 * 
	 * @param request
	 * @param feedback
	 * @param sc
	 * @param msgNews
	 * @return
	 * @throws Exception
	 */
	public String addFeedbackTuwen(HttpServletRequest request,
			Feedback feedback, ServiceCode sc, MsgNews msgNews)
			throws Exception {

		// 插入消息
		feedbackDao.insertFeedback(feedback);

		if (msgNews != null) {

			// 插入图片
			setFeedbackToMsgNew(msgNews, feedback);
			msgNewsService.createMsgNews(msgNews);
		}

		// 生成响应xml文件
		createNewsXmlFile(request, feedback, sc);

		return "";
	}

	/**
	 * 修改单图文
	 * 
	 * @param request
	 * @param feedback
	 * @param sc
	 * @param msgNews
	 * @return
	 * @throws Exception
	 */
	public String updateFeedbackTuwen(HttpServletRequest request,
			Feedback feedback, ServiceCode sc, MsgNews msgNews)
			throws Exception {

		// 修改
		feedbackDao.updateFeedback(feedback);

		String feedbackId = feedback.getFeedBackId();

		// 检索原来的图片
		MsgNews msgNewsSearch = new MsgNews();
		msgNewsSearch.setFeedbackId(feedbackId);
		List<MsgNews> msgNewsList = msgNewsService
				.getMsgNewsByFeedbackId(msgNewsSearch);

		// 原来的图片存在
		if (msgNewsList != null && msgNewsList.size() > 0) {

			MsgNews oldMsgNews = msgNewsList.get(0);

			// 新图片已清除
			if (msgNews == null) {

				// 删除原来的图片
				msgNewsService.deleteMsgNews(oldMsgNews);
			} else {

				// 更新图片
				setFeedbackToMsgNew(oldMsgNews, feedback);
				oldMsgNews.setPicUrl(msgNews.getPicUrl());
				msgNewsService.updateMsgNews(oldMsgNews);
			}
		} else {

			if (msgNews != null) {

				// 插入图片
				setFeedbackToMsgNew(msgNews, feedback);
				msgNewsService.createMsgNews(msgNews);
			}
		}

		// 生成响应xml文件
		createNewsXmlFile(request, feedback, sc);

		return "";
	}

	/**
	 * 单图文时把消息的信息设置到图片信息中
	 * 
	 * @param msgNews
	 * @param feedback
	 */
	private void setFeedbackToMsgNew(MsgNews msgNews, Feedback feedback) {
		msgNews.setNewsTitle(feedback.getTitle());// 标题（微信显示用）
		msgNews.setNewsDesc(feedback.getSummary());// 描述（微信显示用）
		msgNews.setLinkUrl(feedback.getLinkUrl());// 链接（微信显示用）
	}

	/**
	 * 添加多图文
	 * 
	 * @param request
	 * @param feedback
	 * @param sc
	 * @param msgNews
	 * @return
	 * @throws Exception
	 */
	public String addFeedbackDuotuwen(HttpServletRequest request,
			Feedback feedback, ServiceCode sc, String newsIds) throws Exception {

		// 插入消息
		feedbackDao.insertFeedback(feedback);

		// 更新图片信息
		if (newsIds != null && !"".equals(newsIds)) {
			String[] ids = newsIds.split(",");
			int count = ids.length;
			for (int i = 0; i < count; i++) {
				MsgNews msgNews = new MsgNews();
				msgNews.setNewsId(ids[i]);
				msgNews = msgNewsService.displayMsgNews(msgNews);
				msgNews.setSortNum(String.valueOf(i));
				msgNews.setFeedbackId(feedback.getFeedBackId());
				msgNewsService.updateMsgNews(msgNews);
			}
		}

		// 生成响应xml文件
		createNewsXmlFile(request, feedback, sc);

		return "";
	}

	/**
	 * 修改多图文
	 * 
	 * @param request
	 * @param feedback
	 * @param sc
	 * @param msgNews
	 * @return
	 * @throws Exception
	 */
	public String updateFeedbackDuotuwen(HttpServletRequest request,
			Feedback feedback, ServiceCode sc, String newsIds) throws Exception {

		// 插入消息
		feedbackDao.updateFeedback(feedback);

		// 更新图片信息
		if (newsIds != null && !"".equals(newsIds)) {
			String[] ids = newsIds.split(",");
			int count = ids.length;
			for (int i = 0; i < count; i++) {
				MsgNews msgNews = new MsgNews();
				msgNews.setNewsId(ids[i]);
				msgNews = msgNewsService.displayMsgNews(msgNews);
				msgNews.setSortNum(String.valueOf(i));
				msgNews.setFeedbackId(feedback.getFeedBackId());
				msgNewsService.updateMsgNews(msgNews);
			}
		}

		// 生成响应xml文件
		createNewsXmlFile(request, feedback, sc);

		return "";
	}

	/**
	 * 按关键字查询
	 * 
	 * @param feedback
	 * @return
	 * @throws Exception
	 */
	public List<Feedback> getFeedbackByKey(Feedback feedback) throws Exception {
		return feedbackDao.getFeedbackByKey(feedback);
	}
	
	/**
	 * 检索重名
	 * @param feedback
	 * @return
	 * @throws Exception
	 */
	public int checkName(Feedback feedback) throws Exception {
		return feedbackDao.checkName(feedback);
	}
}

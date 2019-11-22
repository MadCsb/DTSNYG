/**   
 *  Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * @Title: MsgHandler.java 
 * @Package com.wootide.travel.weixin.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author WangHuan  
 * @date 2014-4-2 下午01:59:32 
 * @version V1.0   
 */
package com.msy.travel.wx.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.msy.travel.pojo.Feedback;
import com.msy.travel.pojo.MsgNews;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.service.IMsgNewsService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.wx.resp.Article;
import com.msy.travel.wx.resp.BaseMessage;
import com.msy.travel.wx.resp.Image;
import com.msy.travel.wx.resp.ImageMessage;
import com.msy.travel.wx.resp.KFMessage;
import com.msy.travel.wx.resp.Music;
import com.msy.travel.wx.resp.MusicMessage;
import com.msy.travel.wx.resp.NewsMessage;
import com.msy.travel.wx.resp.TextMessage;
import com.msy.travel.wx.resp.Video;
import com.msy.travel.wx.resp.VideoMessage;
import com.msy.travel.wx.resp.Voice;
import com.msy.travel.wx.resp.VoiceMessage;
import com.msy.travel.wx.utils.MessageUtil;

/**
 * @ClassName: MsgHandler
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author WangHuan
 * @date 2014-4-2 下午01:59:32
 * @version 1.0
 */
public abstract class AbstractMsgHandler {

	protected void setBaseParam(BaseMessage msg, BaseMessage basemessage) {
		msg.setToUserName(basemessage.getToUserName());
		msg.setFromUserName(basemessage.getFromUserName());
		msg.setCreateTime(basemessage.getCreateTime());
		msg.setFuncFlag(basemessage.getFuncFlag());
	}

	protected abstract String handle(Map<String, String> requestMap, BaseMessage msg, HttpServletRequest request);

	protected String getResponeMsg(Feedback feedback, BaseMessage msg, IServiceCodeService serviceCodeService, IMsgNewsService msgNewsService) {
		String xmlstr = "";
		try {
			if (feedback == null) {
				return xmlstr;
			}

			// 获取回复消息类型
			String feedbackType = feedback.getMsgType();

			if ("0".equals(feedbackType))// 文本
			{
				TextMessage message = new TextMessage();
				this.setBaseParam(message, msg);
				message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				message.setContent(feedback.getContext());
				xmlstr = MessageUtil.textMessageToXml(message);
			} else if ("1".equals(feedbackType))// 图片
			{
				ImageMessage message = new ImageMessage();
				this.setBaseParam(message, msg);
				message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_IMAGE);

				Image image = new Image();
				image.setMediaId(feedback.getMediaId());
				message.setImage(image);
				xmlstr = MessageUtil.imageMessageToXml(message);
			} else if ("2".equals(feedbackType) || "6".equals(feedbackType))// 图文
			{
				NewsMessage message = new NewsMessage();
				this.setBaseParam(message, msg);
				message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

				ServiceCode serviceCode = new ServiceCode();
				serviceCode.setCode(msg.getFromUserName());
				//serviceCode = serviceCodeService.displayServiceCode(serviceCode);
				serviceCode = serviceCodeService.queryServiceCodeList(serviceCode).get(0);

				MsgNews msgNews = new MsgNews();
				msgNews.setFeedbackId(feedback.getFeedBackId());
				List<MsgNews> msgNewsList = msgNewsService.getMsgNewsByFeedbackId(msgNews);
				List<Article> articleList = new ArrayList<Article>();
				if (msgNewsList.size() > 0) {
					message.setArticleCount(msgNewsList.size());
					for (MsgNews news : msgNewsList) {
						Article article = new Article();
						article.setTitle(news.getNewsTitle());
						
						// 单图文显示内容，多图文暂不显示内容
						if ("2".equals(feedbackType)) {
							article.setDescription(news.getNewsDesc());
						}
						
						if (news.getPicUrl() == null || "".equals(news.getPicUrl())) {
							article.setPicUrl("");
						} else {
							article.setPicUrl(serviceCode.getUrl() + "/upload/wxpic/" + news.getPicUrl());
						}

						article.setUrl(news.getLinkUrl());
						articleList.add(article);
					}
					message.setArticles(articleList);
					xmlstr = MessageUtil.newsMessageToXml(message);
				}

			} else if ("3".equals(feedbackType))// 语音
			{
				VoiceMessage message = new VoiceMessage();
				this.setBaseParam(message, msg);
				message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_VOICE);

				Voice voice = new Voice();
				voice.setMediaId(feedback.getMediaId());
				message.setVoice(voice);
				xmlstr = MessageUtil.voiceMessageToXml(message);

			} else if ("4".equals(feedbackType))// 视频
			{
				VideoMessage message = new VideoMessage();
				this.setBaseParam(message, msg);
				message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_VIDEO);

				Video video = new Video();
				video.setMediaId(feedback.getMediaId());
				video.setTitle(feedback.getTitle());
				video.setDescription(feedback.getContext());
				message.setVideo(video);
				xmlstr = MessageUtil.videoMessageToXml(message);
			} else if ("5".equals(feedbackType))// 音乐
			{
				MusicMessage message = new MusicMessage();
				this.setBaseParam(message, msg);
				message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);

				Music music = new Music();
				music.setTitle(feedback.getTitle());
				music.setDescription(feedback.getContext());
				music.setHQMusicUrl(feedback.getMediaUrl());
				music.setMusicUrl(feedback.getMediaUrl());
				music.setThumbMediaId(feedback.getThumbId());
				message.setMusic(music);
				xmlstr = MessageUtil.musicMessageToXml(message);
			} else if ("8".equals(feedbackType))// 客服消息
			{
				KFMessage message = new KFMessage();
				this.setBaseParam(message, msg);
				message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_SERVICE);
				xmlstr = MessageUtil.KFMessageToXml(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return xmlstr;
	}

}

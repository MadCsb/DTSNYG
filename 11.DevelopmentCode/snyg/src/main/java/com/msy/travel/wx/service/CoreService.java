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
 * @Title: CoreService.java 
 * @Package com.wootide.weixin.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author WangHuan  
 * @date 2014-3-31 上午09:34:01 
 * @version V1.0   
 */
package com.msy.travel.wx.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.wx.resp.BaseMessage;
import com.msy.travel.wx.utils.MessageUtil;

/**
 * 核心服务类
 * 
 */
@Service
@Transactional
public class CoreService {
	private final Log log = LogFactory.getLog(CoreService.class);

	@Resource
	public AbstractMsgHandler textMsgHandler;
	@Resource
	public AbstractMsgHandler imageMsgHandler;
	@Resource
	public AbstractMsgHandler locationMsgHandler;
	@Resource
	public AbstractMsgHandler linkMsgHandler;
	@Resource
	public AbstractMsgHandler subscribeMsgHandler;
	@Resource
	public AbstractMsgHandler unSubscribeMsgHandler;
	@Resource
	public AbstractMsgHandler voiceMsgHandler;
	@Resource
	public AbstractMsgHandler menuClickMsgHandler;
	@Resource
	public AbstractMsgHandler scanMsgHandler;
	@Resource
	public AbstractMsgHandler locationEventHandler;
	@Resource
	public AbstractMsgHandler videoMsgHandler;
	@Resource
	public AbstractMsgHandler shortVideoMsgHandler;
	@Resource
	public AbstractMsgHandler cardMsgHandler;
	@Resource
	public AbstractMsgHandler logMsgHandler;

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public String processRequest(HttpServletRequest request) {
		String respMessage = "success";
		try {
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// Map<String, String> requestMap = new HashMap<String, String>();

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			log.info("receive msg[fromUserName:" + fromUserName + ",toUserName:" + toUserName + ",msgType:" + msgType + "]");

			// 回复消息
			BaseMessage baseMessage = new BaseMessage();
			baseMessage.setToUserName(fromUserName);
			baseMessage.setFromUserName(toUserName);
			baseMessage.setCreateTime(new Date().getTime());
			baseMessage.setFuncFlag(0);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				respMessage = textMsgHandler.handle(requestMap, baseMessage, request);

			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respMessage = imageMsgHandler.handle(requestMap, baseMessage, request);
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respMessage = locationMsgHandler.handle(requestMap, baseMessage, request);
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respMessage = linkMsgHandler.handle(requestMap, baseMessage, request);
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respMessage = voiceMsgHandler.handle(requestMap, baseMessage, request);
			}
			// 视频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
				respMessage = videoMsgHandler.handle(requestMap, baseMessage, request);
			}
			// 小视频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)) {
				respMessage = shortVideoMsgHandler.handle(requestMap, baseMessage, request);
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respMessage = subscribeMsgHandler.handle(requestMap, baseMessage, request);
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
					unSubscribeMsgHandler.handle(requestMap, baseMessage, request);
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// 自定义菜单CLICK
					// String eventKey = requestMap.get("EventKey");
					respMessage = menuClickMsgHandler.handle(requestMap, baseMessage, request);
				}
				// 用户已关注时扫描事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
					respMessage = scanMsgHandler.handle(requestMap, baseMessage, request);
				}
				// 用户主动上报地理位置
				else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
					respMessage = locationEventHandler.handle(requestMap, baseMessage, request);
				}
				// 卡券领取事件
				else if (eventType.equals(MessageUtil.Card.EVENT_CARD_GET)) {
					respMessage = cardMsgHandler.handle(requestMap, baseMessage, request);
				}
				// 卡券删除事件
				else if (eventType.equals(MessageUtil.Card.EVENT_CARD_DEL)) {
					respMessage = cardMsgHandler.handle(requestMap, baseMessage, request);
				}
				// 卡券核销事件
				else if (eventType.equals(MessageUtil.Card.EVENT_CARD_CONSUME)) {
					respMessage = cardMsgHandler.handle(requestMap, baseMessage, request);
				}
			}

			// 加入微信消息日志表
			// logMsgHandler.handle(requestMap, baseMessage, request);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}

	/**
	 * emoji表情转换(hex -> utf-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}

	public AbstractMsgHandler getTextMsgHandler() {
		return textMsgHandler;
	}

	public void setTextMsgHandler(AbstractMsgHandler textMsgHandler) {
		this.textMsgHandler = textMsgHandler;
	}

	public AbstractMsgHandler getImageMsgHandler() {
		return imageMsgHandler;
	}

	public void setImageMsgHandler(AbstractMsgHandler imageMsgHandler) {
		this.imageMsgHandler = imageMsgHandler;
	}

	public AbstractMsgHandler getLocationMsgHandler() {
		return locationMsgHandler;
	}

	public void setLocationMsgHandler(AbstractMsgHandler locationMsgHandler) {
		this.locationMsgHandler = locationMsgHandler;
	}

	public AbstractMsgHandler getLinkMsgHandler() {
		return linkMsgHandler;
	}

	public void setLinkMsgHandler(AbstractMsgHandler linkMsgHandler) {
		this.linkMsgHandler = linkMsgHandler;
	}

	public AbstractMsgHandler getSubscribeMsgHandler() {
		return subscribeMsgHandler;
	}

	public void setSubscribeMsgHandler(AbstractMsgHandler subscribeMsgHandler) {
		this.subscribeMsgHandler = subscribeMsgHandler;
	}

	public AbstractMsgHandler getUnSubscribeMsgHandler() {
		return unSubscribeMsgHandler;
	}

	public void setUnSubscribeMsgHandler(AbstractMsgHandler unSubscribeMsgHandler) {
		this.unSubscribeMsgHandler = unSubscribeMsgHandler;
	}

	public AbstractMsgHandler getVoiceMsgHandler() {
		return voiceMsgHandler;
	}

	public void setVoiceMsgHandler(AbstractMsgHandler voiceMsgHandler) {
		this.voiceMsgHandler = voiceMsgHandler;
	}

	public AbstractMsgHandler getMenuClickMsgHandler() {
		return menuClickMsgHandler;
	}

	public void setMenuClickMsgHandler(AbstractMsgHandler menuClickMsgHandler) {
		this.menuClickMsgHandler = menuClickMsgHandler;
	}

	public AbstractMsgHandler getScanMsgHandler() {
		return scanMsgHandler;
	}

	public void setScanMsgHandler(AbstractMsgHandler scanMsgHandler) {
		this.scanMsgHandler = scanMsgHandler;
	}

	public AbstractMsgHandler getLocationEventHandler() {
		return locationEventHandler;
	}

	public void setLocationEventHandler(AbstractMsgHandler locationEventHandler) {
		this.locationEventHandler = locationEventHandler;
	}

	public AbstractMsgHandler getLogMsgHandler() {
		return logMsgHandler;
	}

	public void setLogMsgHandler(AbstractMsgHandler logMsgHandler) {
		this.logMsgHandler = logMsgHandler;
	}

	public AbstractMsgHandler getVideoMsgHandler() {
		return videoMsgHandler;
	}

	public void setVideoMsgHandler(AbstractMsgHandler videoMsgHandler) {
		this.videoMsgHandler = videoMsgHandler;
	}

	public AbstractMsgHandler getShortVideoMsgHandler() {
		return shortVideoMsgHandler;
	}

	public void setShortVideoMsgHandler(AbstractMsgHandler shortVideoMsgHandler) {
		this.shortVideoMsgHandler = shortVideoMsgHandler;
	}

	public AbstractMsgHandler getCardMsgHandler() {
		return cardMsgHandler;
	}

	public void setCardMsgHandler(AbstractMsgHandler cardMsgHandler) {
		this.cardMsgHandler = cardMsgHandler;
	}

}

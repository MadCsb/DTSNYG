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
 * @Title: LogMsgHandler.java 
 * @Package com.wootide.travel.weixin.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author WangHuan  
 * @date 2014-5-21 下午05:21:31 
 * @version V1.0   
 */
package com.msy.travel.wx.service;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.pojo.MessageLog;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IMessageLogService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
import com.msy.travel.wx.resp.BaseMessage;
import com.msy.travel.wx.utils.MessageUtil;

/**
 * @ClassName: LogMsgHandler
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author WangHuan
 * @date 2014-5-21 下午05:21:31
 * @version 1.0
 */
@Service
@Transactional
public class LogMsgHandler extends AbstractMsgHandler {

	private static final Log log = LogFactory.getLog(LogMsgHandler.class);

	@Resource(name = "messageLogServiceImpl")
	private IMessageLogService messageLogService;

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Override
	protected String handle(Map<String, String> requestMap, BaseMessage msg, HttpServletRequest request) {

		String msgType = requestMap.get("MsgType");

		try {

			// 根据微信服务号查找
			ServiceCode serviceCode = new ServiceCode();
			serviceCode.setCode(msg.getFromUserName());
			serviceCode = serviceCodeService.queryServiceCodeByCustom(serviceCode);

			// 根据serviceId和openId查找fans
			User user = new User();
			user.setWxServiceId(serviceCode.getServiceId());
			user.setUserLoginName(msg.getToUserName());
			user = userService.getUserByUserLoginName(user);

			if (user != null) {
				MessageLog messageLog = new MessageLog();
				messageLog.setWxServiceId(serviceCode.getServiceId());
				messageLog.setOpenId(msg.getToUserName());
				messageLog.setFansId(user.getUserId());
				messageLog.setFromType("0");
				messageLog.setDirect("0");
				messageLog.setDate(DateTimeUtil.getDateTime19());

				if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
					messageLog.setMsgType("2");
					messageLog.setContext("TEXT:" + requestMap.get("Content"));
				}
				// 图片消息
				else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
					messageLog.setMsgType("2");
					messageLog.setContext("IMAGE:" + requestMap.get("PicUrl"));
				}
				// 地理位置消息
				else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
					messageLog.setMsgType("2");
					messageLog.setContext("LOCATION:" + requestMap.get("Location_X") + "," + requestMap.get("Location_Y"));
				}
				// 链接消息
				else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
					messageLog.setMsgType("2");
					messageLog.setContext("LINK:" + requestMap.get("Url"));
				}
				// 音频消息
				else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
					messageLog.setMsgType("2");
					messageLog.setContext("VOICE:" + requestMap.get("MediaId"));
				}
				// 事件推送
				else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
					// 事件类型
					String eventType = requestMap.get("Event");
					// 订阅
					if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
						messageLog.setMsgType("0");
						messageLog.setContext("SUBSCRIBE");
					}
					// 取消订阅
					else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
						messageLog.setMsgType("1");
						messageLog.setContext("UNSUBSCRIBE");
					}
					// 自定义菜单点击事件
					else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
						messageLog.setMsgType("2");
						messageLog.setContext("EVENT_CLICK:" + requestMap.get("EventKey"));
					}
					// 点击VIEW事件
					else if (eventType.equals(MessageUtil.EVENT_TYPE_VIEW)) {
						messageLog.setMsgType("2");
						messageLog.setContext("EVENT_VIEW:" + requestMap.get("EventKey"));
					}
					// 用户已关注时扫描事件
					else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
						messageLog.setMsgType("2");
						messageLog.setContext("EVENT_SCAN:" + requestMap.get("EventKey"));
					}
					// 用户主动上报地理位置
					else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
						messageLog.setMsgType("2");
						messageLog.setContext("EVENT_LOCATION:" + requestMap.get("Latitude") + "," + requestMap.get("Longitude"));
					}

				}
				messageLogService.createMessageLog(messageLog);
			}
		} catch (Exception e) {
			log.error(e, e);
		}
		return "";
	}
}

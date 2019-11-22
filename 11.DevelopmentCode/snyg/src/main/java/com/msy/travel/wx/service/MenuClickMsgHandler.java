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
 * @Title: MenuClickMsgHandler.java 
 * @Package com.wootide.travel.weixin.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author WangHuan  
 * @date 2014-4-2 下午03:06:56 
 * @version V1.0   
 */
package com.msy.travel.wx.service;

import java.io.File;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.FileUtil;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Feedback;
import com.msy.travel.service.IFeedbackService;
import com.msy.travel.service.IMsgNewsService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.wx.resp.BaseMessage;

/**
 * @ClassName: MenuClickMsgHandler
 * @Description: 菜单点击事件处理类
 * @author WangHuan
 * @date 2014-4-2 下午03:06:56
 * @version 1.0
 */
@Service
@Transactional
public class MenuClickMsgHandler extends AbstractMsgHandler {
	private final Log log = LogFactory.getLog(MenuClickMsgHandler.class);

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "feedbackServiceImpl")
	private IFeedbackService feedbackService;

	@Resource(name = "msgNewsServiceImpl")
	private IMsgNewsService msgNewsService;
	
	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Override
	protected String handle(Map<String, String> requestMap, BaseMessage msg,
			HttpServletRequest request) {
		String xmlstr = "";
		
		// 获取点击菜单的key值
		String eventKey = requestMap.get("EventKey");

		try {

			// 根据key值查找回复消息对象
			Feedback feedbackSearch = new Feedback();
			feedbackSearch.setFeedBackId(eventKey);
			Feedback feedback = feedbackService.displayFeedback(feedbackSearch);

			if (feedback != null) {

				String msgType = feedback.getMsgType();
				if ("8".equals(msgType)) {

					String con = feedback.getContext();
					if (con != null && !"".equals(con)) {
						switch (Integer.parseInt(con)) {
						case 1:
							xmlstr = super.getResponeMsg(feedback, msg,
									serviceCodeService, msgNewsService);
							break;

						default:
							break;
						}
					}

				} else {

					String path = configParameter.getUploadPicUrl()
							+ File.separator
							+ "feedback"
							+ File.separator
							+ eventKey + ".txt";
					xmlstr = FileUtil.readFile(path);
					if (!"".equals(xmlstr)) {
						xmlstr = xmlstr
								.replace("%{TO_USER_NAME}", msg.getToUserName())
								.replace("%{FROM_USER_NAME}",
										msg.getFromUserName())
								.replace("99999999",
										String.valueOf(msg.getCreateTime()));

					}
					log.info("newsMsg xml:" + xmlstr);

				}

			}
		} catch (Exception e) {

		}

		return xmlstr;
	}

}

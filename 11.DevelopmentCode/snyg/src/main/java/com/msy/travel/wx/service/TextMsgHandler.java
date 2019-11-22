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
 * @Title: TextMsgHandler.java 
 * @Package com.wootide.travel.weixin.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author WangHuan  
 * @date 2014-4-2 下午02:19:14 
 * @version V1.0   
 */
package com.msy.travel.wx.service;

import java.io.File;
import java.util.List;
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
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.service.IFeedbackService;
import com.msy.travel.service.IMsgNewsService;
import com.msy.travel.service.IPrintInfoService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.wx.resp.BaseMessage;

/**
 * @ClassName: TextMsgHandler
 * @Description: 文本消息处理类
 * @author WangHuan
 * @date 2014-4-2 下午02:19:14
 * @version 1.0
 */
@Service
@Transactional
public class TextMsgHandler extends AbstractMsgHandler {
	private static final Log log = LogFactory.getLog(TextMsgHandler.class);

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "feedbackServiceImpl")
	private IFeedbackService feedbackService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Resource(name = "msgNewsServiceImpl")
	private IMsgNewsService msgNewsService;

	@Resource(name = "printInfoServiceImpl")
	private IPrintInfoService printInfoService;

	@Override
	protected String handle(Map<String, String> requestMap, BaseMessage msg,
			HttpServletRequest request) {
		String xmlstr = "";
		try {
			String content = requestMap.get("Content");

			// 根据微信服务号查找
			ServiceCode serviceCode = new ServiceCode();
			serviceCode.setCode(msg.getFromUserName());
			serviceCode = serviceCodeService.queryServiceCodeList(serviceCode)
					.get(0);

			// 根据key值查找回复消息对象
			Feedback feedback = new Feedback();
			feedback.setWxServiceId(serviceCode.getServiceId());
			feedback.setKeyWord(content);
			feedback.setDelFlag("0");// 0:启用
			List<Feedback> list = feedbackService.getFeedbackByKey(feedback);

			if (list.size() > 0) {

				// 单图文、多图文消息
				if ("2".equals(list.get(0).getMsgType())
						|| "6".equals(list.get(0).getMsgType())) {

					String path = configParameter.getUploadPicUrl()
							+ File.separator + "feedback" + File.separator
							+ list.get(0).getFeedBackId() + ".txt";

					xmlstr = FileUtil.readFile(path);
					if (xmlstr != null && !"".equals(xmlstr)) {
						xmlstr = xmlstr
								.replace("%{TO_USER_NAME}", msg.getToUserName())
								.replace("%{FROM_USER_NAME}",
										msg.getFromUserName())
								.replace("99999999",
										String.valueOf(msg.getCreateTime()));

					}

				}
				// 客服消息
				else if ("8".equals(list.get(0).getMsgType())) {
					String con = list.get(0).getMsgType();
					if (con != null && !"".equals(con)) {
						switch (Integer.parseInt(con)) {
						case 1:
							xmlstr = super.getResponeMsg(list.get(0), msg,
									serviceCodeService, msgNewsService);
							break;

						default:
							break;
						}
					}

				} else {

					xmlstr = super.getResponeMsg(list.get(0), msg,
							serviceCodeService, msgNewsService);
				}
			} else {

				if (serviceCode != null
						&& !"321".equals(serviceCode.getServiceId())) {

					feedback = new Feedback();
					feedback.setFeedBackId(serviceCode.getUnreadMsgId());
					feedback = feedbackService.displayFeedback(feedback);

					if (feedback == null) {
						feedback = new Feedback();
					}

					if ("2".equals(feedback.getMsgType())
							|| "6".equals(feedback.getMsgType())) {

						String path = configParameter.getUploadPicUrl()
								+ File.separator + "feedback" + File.separator
								+ feedback.getFeedBackId() + ".txt";
						xmlstr = FileUtil.readFile(path);
						if (xmlstr != null && !"".equals(xmlstr)) {
							xmlstr = xmlstr
									.replace("%{TO_USER_NAME}",
											msg.getToUserName())
									.replace("%{FROM_USER_NAME}",
											msg.getFromUserName())
									.replace("99999999",
											String.valueOf(msg.getCreateTime()));

						}

					} else {
						xmlstr = super.getResponeMsg(feedback, msg,
								serviceCodeService, msgNewsService);

					}
				}
			}

		} catch (Exception e) {
			log.error("处理文本格式错误", e);
		}
		return xmlstr;
	}
}

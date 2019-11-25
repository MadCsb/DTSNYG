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
 * @Title: SubscribeMsgHandler.java 
 * @Package com.wootide.travel.weixin.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author WangHuan  
 * @date 2014-4-2 下午02:30:54 
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
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.Feedback;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IFeedbackService;
import com.msy.travel.service.IMsgNewsService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
import com.msy.travel.wx.pojo.WxUser;
import com.msy.travel.wx.resp.BaseMessage;
import com.msy.travel.wx.resp.TextMessage;
import com.msy.travel.wx.utils.MessageUtil;
import com.msy.travel.wx.utils.WeixinService;
import com.msy.travel.wx.utils.WeixinUtil;

/**
 * @ClassName: SubscribeMsgHandler
 * @Description: 订阅消息处理类
 * @author WangHuan
 * @date 2014-4-2 下午02:30:54
 * @version 1.0
 */
@Service
@Transactional
public class SubscribeMsgHandler extends AbstractMsgHandler {
	private static final Log log = LogFactory.getLog(SubscribeMsgHandler.class);

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "feedbackServiceImpl")
	private IFeedbackService feedbackService;

	@Resource(name = "msgNewsServiceImpl")
	private IMsgNewsService msgNewsService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Override
	protected String handle(Map<String, String> requestMap, BaseMessage msg, HttpServletRequest request) {

		log.info("进入用户关注消息处理......FROM[" + msg.getToUserName() + "]" + ",TO[" + msg.getFromUserName() + "]....QRCODEID[" + requestMap.get("EventKey") + "]");

		String xmlstr = "";
		boolean flag = false;
		String fansfrom = "";
		try {
			// 根据微信服务号查找
			ServiceCode serviceCode = new ServiceCode();
			serviceCode.setCode(msg.getFromUserName());
			serviceCode = serviceCodeService.queryServiceCodeList(serviceCode).get(0);

			if (serviceCode != null) {

				User user = new User();
				user.setWxServiceId(serviceCode.getServiceId());
				user.setUserLoginName(msg.getToUserName());
				user = userService.getUserByUserLoginName(user);

				if (user == null) {
					user = new User();
					user.setUserId(PrimaryKeyUtil.generateKey());
					user.setUserLoginName(msg.getToUserName());
					user.setType("0");
					user.setUserState("1");
					user.setWxServiceId(serviceCode.getServiceId());
					user.setAccId(Destsp.currentSpId);
					user.setUnitId(Destsp.currentSpId);
					userService.createUser(user);
				} else {
					user.setUserState("-2");
					userService.updateUser(user);
				}

				log.info("关注serviceid[" + serviceCode.getServiceId() + "]---fakeId[" + msg.getToUserName() + "]---userId[" + user.getUserId() + "]");

				WxUser wxuser = WeixinUtil.getUserDeatil(WeixinService.getAccessToken(serviceCode), msg.getToUserName());
				log.info("用户关注获取用户信息详情wxuser[" + wxuser + "]");
				// 值为0时，代表此用户没有关注该公众号，拉取不到其余信息
				if (wxuser != null && !"0".equals(wxuser.getSubscribe())) {
					fansfrom = requestMap.get("EventKey");
					if (fansfrom != null && !"".equals(fansfrom)) {
						fansfrom = fansfrom.split("_")[1];
						try {
							Integer.parseInt(fansfrom);
						} catch (Exception e) {
							fansfrom = null;
						}
					}

					user.setWxServiceId(serviceCode.getServiceId());
					user.setUserLoginName(msg.getToUserName());
					user.setType("0");
					user.setUserName(wxuser.getNickname());
					user.setUserState("1");
					user.setCountry(wxuser.getCountry());
					user.setProvince(wxuser.getProvince());
					user.setCity(wxuser.getCity());
					user.setSex(wxuser.getSex());// 1男 2女 3未知
					user.setUpdateTime(DateTimeUtil.getDateTime19());
					user.setHeadPic(wxuser.getHeadimgurl());
					userService.updateUser(user);

					log.info("用户关注消息 来源场景ID[" + fansfrom + "]");

					// flag = true;

				}

				if (!flag) {
					Feedback feedback = new Feedback();
					if (serviceCode.getInMsgId() != null && !"".equals(serviceCode.getInMsgId())) {
						feedback.setFeedBackId(serviceCode.getInMsgId());
						feedback = feedbackService.displayFeedback(feedback);

						xmlstr = super.getResponeMsg(feedback, msg, serviceCodeService, msgNewsService);
					} else {// 默认消息
						TextMessage message = new TextMessage();
						super.setBaseParam(message, msg);
						message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
						message.setContent("感谢您的关注!");
						xmlstr = MessageUtil.textMessageToXml(message);
					}
				}

			}
		} catch (Exception e) {
			log.error("用户关注时serviceCode异常,wxid[" + msg.getFromUserName() + "]");
			log.error(e, e);
		}

		return xmlstr;

	}

}

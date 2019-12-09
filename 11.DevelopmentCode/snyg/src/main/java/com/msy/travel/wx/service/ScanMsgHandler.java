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
 * @Title: ScanMsgHandler.java 
 * @Package com.wootide.travel.weixin.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author WangHuan  
 * @date 2014-5-12 下午01:53:17 
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
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
import com.msy.travel.wx.pojo.WxUser;
import com.msy.travel.wx.resp.BaseMessage;
import com.msy.travel.wx.utils.WeixinService;
import com.msy.travel.wx.utils.WeixinUtil;

/**
 * @ClassName: ScanMsgHandler
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author WangHuan
 * @date 2014-5-12 下午01:53:17
 * @version 1.0
 */
@Service
@Transactional
public class ScanMsgHandler extends AbstractMsgHandler {
	private static final Log log = LogFactory.getLog(ScanMsgHandler.class);

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Override
	protected String handle(Map<String, String> requestMap, BaseMessage msg, HttpServletRequest request) {
		String xmlstr = "";
		try {

			String fansfrom = "";

			// 根据微信服务号查找
			ServiceCode serviceCode = new ServiceCode();
			serviceCode.setCode(msg.getFromUserName());
			serviceCode = serviceCodeService.queryServiceCodeList(serviceCode).get(0);

			if (serviceCode != null) {

				// 服务号ID
				String serviceId = serviceCode.getServiceId();

				WxUser wxuser = WeixinUtil.getUserDeatil(WeixinService.getAccessToken(serviceCode), msg.getToUserName());

				if (wxuser != null && !"0".equals(wxuser.getSubscribe())) {
					fansfrom = requestMap.get("EventKey");

					try {
						Integer.parseInt(fansfrom);
					} catch (Exception e) {
						fansfrom = null;
					}

					User user = new User();
					user.setWxServiceId(serviceCode.getServiceId());
					user.setUserLoginName(msg.getToUserName());
					user = userService.getUserByUserLoginName(user);

					if (user != null) {

						user.setWxServiceId(serviceCode.getServiceId());
						user.setUserLoginName(msg.getToUserName());
						user.setType("0");
						try {
							user.setUserName(wxuser.getNickname());
						} catch (Exception e) {
							user.setUserName(PrimaryKeyUtil.getDefaultWxUserName());
						}
						user.setUserState("1");
						user.setCountry(wxuser.getCountry());
						user.setProvince(wxuser.getCountry());
						user.setCity(wxuser.getCity());
						user.setSex(wxuser.getSex());// 1男 2女 3未知
						user.setUpdateTime(DateTimeUtil.getDateTime19());
						userService.updateUser(user);

					}
				}
			}

		} catch (Exception e) {
			log.error("处理微信扫码消息错误", e);
		}

		return xmlstr;
	}

}

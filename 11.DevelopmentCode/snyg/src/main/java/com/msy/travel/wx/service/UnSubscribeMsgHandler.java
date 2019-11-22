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
 * @Title: UnSubscribeMsgHandler.java 
 * @Package com.wootide.travel.weixin.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author WangHuan  
 * @date 2014-4-2 下午02:32:17 
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

import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
import com.msy.travel.wx.resp.BaseMessage;

/**
 * @ClassName: UnSubscribeMsgHandler
 * @Description: 取消订阅处理类
 * @author WangHuan
 * @date 2014-4-2 下午02:32:17
 * @version 1.0
 */
@Service
@Transactional
public class UnSubscribeMsgHandler extends AbstractMsgHandler {
	private static final Log log = LogFactory.getLog(UnSubscribeMsgHandler.class);

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Override
	protected String handle(Map<String, String> requestMap, BaseMessage msg, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			ServiceCode serviceCode = new ServiceCode();
			serviceCode.setCode(msg.getFromUserName());
			serviceCode = serviceCodeService.queryServiceCodeList(serviceCode).get(0);

			// 根据serviceId和openId查找fans
			User user = new User();
			user.setWxServiceId(serviceCode.getServiceId());
			user.setUserLoginName(msg.getToUserName());
			user = userService.getUserByUserLoginName(user);
			user.setUserState("-2");
			userService.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e, e);
		}

		return "";
	}

}

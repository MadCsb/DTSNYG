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
 * @Title: ImageMsgHandler.java 
 * @Package com.wootide.travel.weixin.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author WangHuan  
 * @date 2014-4-2 下午02:20:29 
 * @version V1.0   
 */
package com.msy.travel.wx.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.pojo.PrintInfo;
import com.msy.travel.pojo.PrintPic;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.service.IPrintInfoService;
import com.msy.travel.service.IPrintPicService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.wx.resp.BaseMessage;
import com.msy.travel.wx.resp.TextMessage;
import com.msy.travel.wx.utils.MessageUtil;

/**
 * @ClassName: ImageMsgHandler
 * @Description: 图片消息处理类
 * @author WangHuan
 * @date 2014-4-2 下午02:20:29
 * @version 1.0
 */
@Service
@Transactional
public class ImageMsgHandler extends AbstractMsgHandler {
	private static final Log log = LogFactory.getLog(ImageMsgHandler.class);

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "printPicServiceImpl")
	private IPrintPicService printPicService;

	@Resource(name = "printInfoServiceImpl")
	private IPrintInfoService printInfoService;

	@Override
	protected String handle(Map<String, String> requestMap, BaseMessage msg, HttpServletRequest request) {
		String xmlstr = "";
		try {
			// 根据微信服务号查找
			ServiceCode serviceCode = new ServiceCode();
			serviceCode.setCode(msg.getFromUserName());
			serviceCode = serviceCodeService.queryServiceCodeList(serviceCode).get(0);

			PrintPic printPic = new PrintPic();
			printPic.setPicUrl(requestMap.get("PicUrl"));
			printPic.setWxServiceId(serviceCode.getServiceId());
			printPic.setOpenId(msg.getToUserName());
			printPicService.createPrintPic(printPic);

			PrintInfo printInfo = new PrintInfo();
			printInfo.setWxServiceId(serviceCode.getServiceId());
			List<PrintInfo> list = printInfoService.queryPrintInfoList(printInfo);

			TextMessage message = new TextMessage();
			super.setBaseParam(message, msg);
			message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			if (list.size() > 0) {
				message.setContent(list.get(0).getPicText());
			} else {
				message.setContent("图片已成功加入图片库!");
			}
			xmlstr = MessageUtil.textMessageToXml(message);
		} catch (Exception e) {
			log.error("处理微信图片错误", e);
		}
		return xmlstr;
	}

}

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
 * @Title: MobileMessageUtil.java 
 * @Package com.wootide.travel.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author WangHuan  
 * @date 2014-7-24 上午11:03:17 
 * @version V1.0   
 */
package com.msy.travel.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @ClassName: MobileMessageUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author WangHuan
 * @date 2014-7-24 上午11:03:17
 * @version 1.0
 */
public class MobileMessageUtil {

	private static final Log log = LogFactory.getLog(MobileMessageUtil.class);

	// private static String SpCode = "227043"; // 公司联通短信平台 企业编号
	private static String SpCode = PropertyUtil.getPropertyByKey("sms.SpCode");

	// private static String LoginName = "zjmsy_fx"; // 公司联通短信平台 用户名称
	private static String LoginName = PropertyUtil.getPropertyByKey("sms.LoginName");

	// private static String Password = "msyFX0511zj";// 公司联通短信平台 用户密码
	private static String Password = PropertyUtil.getPropertyByKey("sms.Password");

	/**
	 * 短信发送 多个号码逗号分隔 成功返回0
	 *
	 * @Title: sendMsg
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param mobilenum
	 * @param @param content
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String sendMsg(String mobilenum, String content) {
		// String res = "1";
		// String sendUrl = ""; //
		// // "http://ets.izouzou.com:8081/ets/order/sendGroupMsg.do";
		// try {
		// Map<String, String> parammap = new HashMap<String, String>();
		// parammap.put("groupPhones", mobilenum);
		// parammap.put("groupMsg", new String(content.getBytes("utf-8"),
		// "iso8859-1"));
		// System.out.println("发送短信成功:" + mobilenum + "[" + content + "]");
		// // res = MobileMessageUtil.sendRequset(sendUrl, parammap);
		// // if (res == null || "".equals(res)) {
		// //
		// // res = "0";
		// // }
		//
		// } catch (Exception e) {
		// res = "-1";
		// log.error("发送短信失败.num[" + mobilenum + "],content[" + mobilenum +
		// "]");
		// }
		//
		// return res;
		return sendMobileMsg(mobilenum, content);
	}

	/**
	 * 
	 * @author whn
	 * @date 2015年9月24日 上午10:45:04
	 * @param mobilenum
	 *            多个号码逗号分隔
	 * @param content
	 *            短信内容
	 * @return
	 * @return String
	 */
	public static String sendMobileMsg(String mobilenum, String content) {
		String res = "-1";
		try {
			log.info("发送短信内容：" + content);

			String serverUrl = "http://sms.api.ums86.com:8899/sms/Api/Send.do";
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("SpCode", MobileMessageUtil.SpCode); // 企业编号
			paramMap.put("LoginName", MobileMessageUtil.LoginName); // 用户名称
			paramMap.put("Password", MobileMessageUtil.Password); // 用户密码
			paramMap.put("MessageContent", content); // 短信内容
			paramMap.put("UserNumber", mobilenum); // 手机号码
			paramMap.put("SerialNumber", System.currentTimeMillis() + ""); // 流水号
			paramMap.put("ScheduleTime", ""); // 预约发送时间
			paramMap.put("ExtendAccessNum", ""); // 接入号扩展号
			paramMap.put("f", "1"); // 提交时检测方式

			String isSend = PropertyUtil.getPropertyByKey("sms.isSend", "false");
			if (isSend.equals("true")) {
				res = HttpUtils.sendRequset(serverUrl, paramMap, "gbk");
			}
			res = new String(res.getBytes("iso8859-1"), "gbk");
			log.info("发送短信响应消息：" + res);

			res = res.split("&")[0].split("=")[1];

		} catch (Exception e) {
			e.printStackTrace();
			res = "-1";
		}

		return res;

	}

	public static void main(String[] args) {

		try {
			// 公司联通短信平台发送模板
			// 您的验证码是{xxxxxxxxxx}请不要把验证码泄露给其他人{x}
			//
			String content = "您的验证码是123456请不要把验证码泄露给其他人！";

			MobileMessageUtil.sendMobileMsg("13405589260", content);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

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
 * @Title: TokenService.java 
 * @Package com.wootide.travel.weixin.utils 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author WangHuan  
 * @date 2014-4-11 下午02:48:07 
 * @version V1.0   
 */
package com.msy.travel.wx.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.msy.travel.common.ResourceCommon;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.wx.pojo.AccessToken;
import com.msy.travel.wx.pojo.JsApiTicket;
import com.msy.travel.wx.pojo.WxUser;

/**
 * @ClassName: TokenService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author WangHuan
 * @date 2014-4-11 下午02:48:07
 * @version 1.0
 */
@Service
public class WeixinService {
	public static final Log log = LogFactory.getLog(WeixinService.class);

	public static Map<String, AccessToken> tokenMap = new HashMap<String, AccessToken>();

	public static Map<String, JsApiTicket> jsApiTicketMap = new HashMap<String, JsApiTicket>();

	public static Map<String, WxUser> codeWxUserMap = new HashMap<String, WxUser>();

	/**
	 * 授权scope类型
	 */
	public static String OAUTH_SCOPE_TYPE_BASE = "snsapi_base";

	public static String OAUTH_SCOPE_TYPE_USERINFO = "snsapi_userinfo";

	/**
	 * 获取微信token
	 *
	 * @Title: getAccessToken
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param serviceId
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String getAccessToken(ServiceCode serviceCode) {
		AccessToken token = tokenMap.get(serviceCode.getServiceId());

		String ret = "";
		if (token == null || System.currentTimeMillis() >= token.getUntildate()) {
			if (serviceCode != null && serviceCode.getAppId() != null && serviceCode.getAppSecret() != null) {
				token = WeixinUtil.getAccessToken(serviceCode.getAppId(), serviceCode.getAppSecret());
			} else {
				log.error("获取TOKEN-----未找到serviceId:" + serviceCode.getServiceId() + "相关数据");
			}
			if (token != null) {
				token.setUntildate(System.currentTimeMillis() + token.getExpiresIn() * 900);
				tokenMap.put(serviceCode.getServiceId(), token);
				ret = token.getToken();
			}
		} else {
			ret = token.getToken();
		}

		return ret;
	}

	/**
	 * 发送客服消息
	 *
	 * @Title: sendServiceMsg
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param serviceCode
	 * @param @param openId
	 * @param @param msgContent
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public static int sendServiceMsg(ServiceCode serviceCode, String openId, String msgContent, String msgType) {
		int ret = 0;
		String tmp = "";
		String jsonstr = "";
		try {
			// 文本
			if ("text".equals(msgType)) {

				tmp = "{\"touser\":\"OPENID\",\"msgtype\":\"text\",\"text\":{\"content\":\"CONTENTMSG\"}}";
				jsonstr = tmp.replace("OPENID", openId).replace("CONTENTMSG", msgContent);
			}// 图片
			else if ("image".equals(msgType)) {
				tmp = "{\"touser\":\"OPENID\",\"msgtype\":\"image\",\"image\":{\"media_id\":\"MEDIA_ID\"}}";
				jsonstr = tmp.replace("OPENID", openId).replace("MEDIA_ID", msgContent);

			}// 语音
			else if ("voice".equals(msgType)) {
				tmp = "{\"touser\":\"OPENID\",\"msgtype\":\"voice\",\"voice\":{\"media_id\":\"MEDIA_ID\"}}";
				jsonstr = tmp.replace("OPENID", openId).replace("MEDIA_ID", msgContent);

			}// 视频||小视频
			else if ("video".equals(msgType) || "shortvideo".equals(msgType)) {
				tmp = "{\"touser\":\"OPENID\",\"msgtype\":\"video\",\"video\":{\"media_id\":\"MEDIA_ID\", \"thumb_media_id\":\"THUMBMID\"}}";
				jsonstr = tmp.replace("OPENID", openId).replace("MEDIA_ID", msgContent.split(",")[0]).replace("THUMBMID", msgContent.split(",")[1]);

			}
			log.info("发送客服消息jsonstr[" + jsonstr + "]");
			ret = WeixinUtil.sendMsg(getAccessToken(serviceCode), jsonstr);
		} catch (Exception e) {
			log.error("发送客服消息失败", e);
			ret = -1;
		}
		return ret;
	}

	/**
	 * 发送客服消息
	 *
	 * @Title: sendServiceMsg
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param serviceCode
	 * @param @param openId
	 * @param @param msgContent
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public static int sendServiceMsg(ServiceCode serviceCode, String openId, String msgContent) {
		int ret = 0;
		String textTmp = "{\"touser\":\"OPENID\",\"msgtype\":\"text\",\"text\":{\"content\":\"CONTENTMSG\"}}";
		String jsonstr = "";
		try {
			jsonstr = textTmp.replace("OPENID", openId).replace("CONTENTMSG", msgContent);

			ret = WeixinUtil.sendMsg(getAccessToken(serviceCode), jsonstr);
		} catch (Exception e) {
			log.error("发送客服消息失败", e);
			ret = -1;
		}
		return ret;
	}

	/**
	 * 微信支付发货通知消息
	 *
	 * @Title: sendNotifyMsg
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param serviceCode
	 * @param @param jsonStr
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String sendNotifyMsg(ServiceCode serviceCode, String jsonStr) {
		String ret = null;
		try {
			ret = WeixinUtil.deliverNotify(getAccessToken(serviceCode), jsonStr);
		} catch (Exception e) {
			log.error("发送发货通知消息失败", e);
			ret = "-1";
		}
		return ret;

	}

	/**
	 *
	 * 获取微信token
	 *
	 * @Title: getAccessToken
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param serviceId
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String getAccessToken(IServiceCodeService serviceCodeService, IDestspService destspService, HttpServletRequest request) {
		Destsp destsp = new Destsp();

		User user = (User) request.getSession().getAttribute(ResourceCommon.LOGIN_USER);

		destsp.setSpId(user.getAccId());
		try {
			destsp = destspService.displayDestsp(destsp);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		ServiceCode serviceCode = new ServiceCode();
		serviceCode.setServiceId(destsp.getWxServiceId());
		try {
			serviceCode = serviceCodeService.displayServiceCode(serviceCode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return getAccessToken(serviceCode);
	}

	/**
	 * 获取登陆用户的微信服务号ID
	 *
	 * @Title: getWxServiceId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String getBackWxServiceId(IDestspService destspService, HttpServletRequest request) {
		Destsp destsp = new Destsp();
		User user = (User) request.getSession().getAttribute(ResourceCommon.LOGIN_USER);

		destsp.setSpId(user.getAccId());
		try {
			destsp = destspService.displayDestsp(destsp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (destsp.getWxServiceId() == null) {

			return "0";
		} else {
			return destsp.getWxServiceId();
		}

	}

	/**
	 * 根据SPID获取SERVICECODE
	 *
	 * @Title: getServiceCodeBySpId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param spId
	 * @param @return 设定文件
	 * @return ServiceCode 返回类型
	 * @throws
	 */
	public static ServiceCode getServiceCodeBySpId(String spId, IServiceCodeService serviceCodeService, IDestspService destspService) {
		ServiceCode serviceCode = new ServiceCode();
		try {
			Destsp destsp = new Destsp();
			destsp.setSpId(spId);
			destsp = destspService.displayDestsp(destsp);

			serviceCode.setServiceId(destsp.getWxServiceId());
			serviceCode = serviceCodeService.displayServiceCode(serviceCode);
		} catch (Exception e) {
			log.error("根据spId获取serviceCode失败", e);
			serviceCode = null;
		}

		return serviceCode;
	}

	/**
	 * 获取当前登陆用户的ServiceCode对象
	 *
	 * @Title: getCurrentServiceCode
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return ServiceCode 返回类型
	 * @throws
	 */
	public static ServiceCode getBackCurrentServiceCode(IServiceCodeService serviceCodeService, IDestspService destspService, HttpServletRequest request) {
		ServiceCode serviceCode = new ServiceCode();
		serviceCode.setServiceId(getBackWxServiceId(destspService, request));
		try {
			serviceCode = serviceCodeService.displayServiceCode(serviceCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceCode;
	}

	/**
	 * 获取jsapiticket
	 *
	 * @return
	 */
	public static String getJsApiTicket(ServiceCode serviceCode) throws Exception {

		JsApiTicket jsticket = jsApiTicketMap.get(serviceCode.getServiceId());

		String ret = "";
		if (jsticket == null || System.currentTimeMillis() >= jsticket.getUntildate()) {
			jsticket = WeixinUtil.getJsapiTicket(getAccessToken(serviceCode), null);
			if (jsticket != null) {
				jsticket.setUntildate(System.currentTimeMillis() + jsticket.getExpiresIn() * 900);
				jsApiTicketMap.put(serviceCode.getServiceId(), jsticket);
				ret = jsticket.getTicket();
			}
		} else {
			ret = jsticket.getTicket();
		}

		return ret;
	}

	/**
	 * 获取授权用户信息
	 *
	 * @param serviceCode
	 * @param code
	 * @param oauthType
	 *            OAUTH_SCOPE_TYPE_BASE或者OAUTH_SCOPE_TYPE_USERINFO
	 * @return
	 */
	public static WxUser getOauthUserInfo(ServiceCode serviceCode, String code, String oauthType) {

		WxUser wxUser = null;
		JSONObject jsonObject = null;
		try {

			if (WeixinService.codeWxUserMap.get(code) != null) {

				return WeixinService.codeWxUserMap.get(code);
			}

			jsonObject = WeixinUtil.getOauthAccessToken(serviceCode.getAppId(), serviceCode.getAppSecret(), code);

			if (jsonObject != null) {
				wxUser = new WxUser();
				if (WeixinService.OAUTH_SCOPE_TYPE_BASE.equals(oauthType)) {

					wxUser.setOpenid(jsonObject.getString("openid"));

					WeixinService.codeWxUserMap.put(code, wxUser);

				} else if (WeixinService.OAUTH_SCOPE_TYPE_USERINFO.equals(oauthType)) {

					wxUser = WeixinUtil.getScopeUserDeatil(jsonObject.getString("access_token"), jsonObject.getString("openid"));

					WeixinService.codeWxUserMap.put(code, wxUser);

				} else {

					wxUser = null;
				}
			}

		} catch (Exception e) {
			wxUser = null;
			log.error(e, e);
		}
		return wxUser;

	}

}

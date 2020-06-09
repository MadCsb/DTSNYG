package com.qq.weixin.open;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.msy.travel.common.HttpClientTool;
import com.msy.travel.pojo.WeixinOpenApplication;
public class WebsiteApp {
	public static final Log log = LogFactory.getLog(WebsiteApp.class);
	/**
	 * 微信登录，获取code的请求连接，通过在pc端打开连接
	 * @param param 参数
	 * param.appId 应用ID
	 * param.redirectUri 微信用户授权后，返回第三方网站地址||返回第三方应用
	 * param.state （非必填） 授权请求后，原样返回给第三方。可用于防止跨站请求伪造攻击
	 *
	 * @return https://open.weixin.qq.com/connect/qrconnect?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
	 */
	public static String getRequestCodeUrl(JSONObject param)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("https://")
		.append(OpenResource.WX_OPEN_SERVICE_DOMAIN)
		.append("/connect/qrconnect?")
		.append("appid=").append(param.getString("appId"))
		.append("&redirect_uri=").append(param.getString("redirectUri"))
		.append("&response_type=code")
		.append("&scope=snsapi_login")
		.append("&state=");
		if(param.containsKey("state"))
		{
			sb.append(param.getString("state"));
		}
		sb.append("#wechat_redirect");
		return sb.toString();
	}
	
	/**
	 * 用户登录，通过code获取access_token，目前access_token有效期7200s，可用refreshAccessToken方法刷新
	 * 调用频次:1万/分钟
	 * @param param 参数
	 * param.appid 应用唯一标识，在微信开放平台提交应用审核通过后获得
	 * param.secret 应用密钥AppSecret，在微信开放平台提交应用审核通过后获得
	 * param.code 浏览器打开getRequestCodeUrl返回的url,微信用户授权后，微信服务器主动调用我服务器接口的参数
	 *
	 * @return 如果null，表示出现异常，如果非null，则返回正确请求结果
	 * {
	 * "access_token":"ACCESS_TOKEN",
	 * "expires_in":7200,
	 * "refresh_token":"REFRESH_TOKEN",
	 * "openid":"OPENID",
	 * "scope":"SCOPE",
	 * "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
	 * }
	 * 
	 * 
	 */
	public static JSONObject accessToken(JSONObject param)
	{
		HttpGet httpGet = new HttpGet();
		try {
			URI uri = new URIBuilder()
					.setScheme("https")
					.setHost(OpenResource.WX_API_SERVICE_DOMAIN)
					.setPath("/sns/oauth2/access_token")
					.setParameter("appid", param.getString("appId"))
					.setParameter("secret", param.getString("appSecret"))
					.setParameter("code", param.getString("code"))
					.setParameter("grant_type", "authorization_code")
					.build();
			httpGet.setURI(uri);
		} catch (URISyntaxException e) {
			log.error(e);
			return null;
		}
		String result = HttpClientTool.doHttpGet(httpGet);
		JSONObject object = JSON.parseObject(result);
		if(object.containsKey("errcode"))
		{
			log.error("getAccessToken error:"+result+";URI="+httpGet.getURI());
			return null;
		}
		return object;
	}
	
	/**
	 * 用户登录授权后，刷新access_token有效期。
	 * 若access_token已超时，进行refresh_token会获取一个新的access_token，新的超时时间；
	 * 若access_token未超时，那么进行refresh_token不会改变access_token，但超时时间会刷新，相当于续期access_token。
	 * refresh_token拥有较长的有效期（30天），当refresh_token失效的后，需要用户重新授权。
	 * 调用频次:5万/分钟
	 * @param application.appid 应用唯一标识，在微信开放平台提交应用审核通过后获得
	 * @param refreshToken 方法getAccessToken、refreshAccessToken获得refresh_token
	 * @return 如果null，表示出现异常，如果非null，则返回正确请求结果
	 * {
	 * "access_token":"ACCESS_TOKEN",
	 * "expires_in":7200,
	 * "refresh_token":"REFRESH_TOKEN",
	 * "openid":"OPENID",
	 * "scope":"SCOPE"
	 * }
	 */
	public static JSONObject refreshAccessToken(WeixinOpenApplication application,String refreshToken)
	{
		HttpGet httpGet = new HttpGet();
		try {
			URI uri = new URIBuilder()
					.setScheme("https")
					.setHost(OpenResource.WX_API_SERVICE_DOMAIN)
					.setPath("/sns/oauth2/refresh_token")
					.setParameter("appid", application.getAppId())
					.setParameter("grant_type", "refresh_token")
					.setParameter("refresh_token", refreshToken)
					.build();
			httpGet.setURI(uri);
		} catch (URISyntaxException e) {
			log.error(e);
			return null;
		}
		String result = HttpClientTool.doHttpGet(httpGet);
		JSONObject object = JSON.parseObject(result);
		if(object.containsKey("errcode"))
		{
			log.error("refreshAccessToken error:"+result+";URI="+httpGet.getURI());
			return null;
		}
		return object;
	}
	
	
	/**
	 * 检验授权凭证（access_token）是否有效
	 * 有效结果，{"errcode":0,"errmsg":"ok"}
	 * 无效结果示例，{"errcode":40003,"errmsg":"invalid openid"}
	 * @param accessToken 调用接口凭证
	 * @param openId 普通用户标识，对该公众账号唯一
	 * @return 如果null，表示出现异常，如果非null，则返回是否有效结果
	 */
	public static JSONObject authAccessToken(String accessToken,String openId)
	{
		HttpGet httpGet = new HttpGet();
		try {
			URI uri = new URIBuilder()
					.setScheme("https")
					.setHost(OpenResource.WX_API_SERVICE_DOMAIN)
					.setPath("/sns/auth")
					.setParameter("access_token", accessToken)
					.setParameter("openId", openId)
					.build();
			httpGet.setURI(uri);
		} catch (URISyntaxException e) {
			log.error(e);
			return null;
		}
		String result = HttpClientTool.doHttpGet(httpGet);
		JSONObject object = JSON.parseObject(result);
		return object;
	}
	
	/**
	 * 获取用户个人信息（UnionID机制）
	 * 同一用户，对同一个微信开放平台下的不同应用，unionid是相同的
	 * 调用频次:5万/分钟
	 * @param accessToken 用户授权token
	 * @param openId 用户在应用中的id
	 * @return 如果null，表示出现异常，如果非null，则返回正确请求结果
	 * {
	 * "openid":"OPENID",  //普通用户的标识，对当前开发者账号唯一
	 * "nickname":"NICKNAME", //普通用户昵称
	 * "sex":1, //普通用户性别，1为男性，2为女性
	 * "province":"PROVINCE", //普通用户个人资料填写的省份
	 * "city":"CITY", //普通用户个人资料填写的城市
	 * "country":"COUNTRY", //国家，如中国为CN
	 * "headimgurl": "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0", 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
	 * "privilege":["PRIVILEGE1","PRIVILEGE2"], //用户特权信息，json数组，如微信沃卡用户为（chinaunicom）
	 * "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL" //用户统一标识。针对一个微信开放平台账号下的应用，同一用户的unionid是唯一的。
	 * }
	 * @return
	 */
	public static JSONObject userinfo(String accessToken,String openId)
	{
		//https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID
		HttpGet httpGet = new HttpGet();
		try {
			URI uri = new URIBuilder()
					.setScheme("https")
					.setHost(OpenResource.WX_API_SERVICE_DOMAIN)
					.setPath("/sns/userinfo")
					.setParameter("access_token", accessToken)
					.setParameter("openid", openId)
					.build();
			httpGet.setURI(uri);
		} catch (URISyntaxException e) {
			log.error(e);
			return null;
		}
		String result = HttpClientTool.doHttpGet(httpGet);
		JSONObject object = JSON.parseObject(result);
		if(object.containsKey("errcode"))
		{
			log.error("getUserinfo error:"+result+";URI="+httpGet.getURI());
			return null;
		}
		return object;
		
	}
}

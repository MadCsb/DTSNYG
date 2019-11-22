package com.msy.travel.common.wx;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.WTConvert;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 公众平台通用接口工具类
 * 
 * @author liuyq
 * @date 2013-08-09
 */
public class WeixinUtil {
	private static final Log log = LogFactory.getLog(WeixinUtil.class);

	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	// 菜单创建（POST） 限100（次/天）
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	// 菜单删除（GET） 限1000（次/天）
	public static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	// 获取用户基本信息（GET） 限 5000000（次/天）
	public static String user_info_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	// 获取关注者列表（GET） 限 500（次/天）
	public static String user_get_url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";

	// 创建二维码ticket（POST）
	public static String qrcode_create_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";

	// 根据code获取openId
	public static String oauth2_openid_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

	// 发送客服消息URL (POST)
	public static String send_servicemsg_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

	// 微信支付发货通知(POST)
	public static String send_deliver_notify_url = " https://api.weixin.qq.com/pay/delivernotify?access_token=ACCESS_TOKEN";

	// 创建卡券二维码接口(POST)
	public static String card_qrcode_create_url = "https://api.weixin.qq.com/card/qrcode/create?access_token=ACCESS_TOKEN";

	// 查询卡券CODE接口(POST)
	public static String card_code_get_url = "https://api.weixin.qq.com/card/code/get?access_token=ACCESS_TOKEN";

	// 核销卡券接口(POST)
	public static String card_code_consume_url = "https://api.weixin.qq.com/card/code/consume?access_token=ACCESS_TOKEN";

	// 删除永久素材(POST)
	public static String del_material_media_url = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";

	// 上传图文消息素材(POST)
	public static String upload_news_url = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";

	// 群发消息接口(POST)
	public static String sendall_msg_url = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";

	// 群发消息预览接口(POST)
	public static String sendall_msg_preview_url = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";

	// jsapi_ticket(GET)
	public static String jsapi_ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

	// 拉取用户信息(需scope为 snsapi_userinfo)(GET)
	public static String scope_get_userinfo_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	//获取临时素材文件
	public static String cgi_media_url="https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();

			log.info("https请求结果：[" + buffer.toString() + "]");
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}
		return jsonObject;
	}

	/**

	 * 发起https请求并获取字节数组结果

	 * @param requestUrl

	 * @param requestMethod

	 * @param data

	 * @return

	 */
	public static byte[] httpRequest_byte(String requestUrl, String requestMethod, byte[] data) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			if (requestMethod.equals("GET") && data != null && data.length > 0) {
				if (requestUrl.indexOf('?') > 0) {
					requestUrl += '&';
				} else {
					requestUrl += '?';
				}
				requestUrl += new String(data);
			}
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			if (httpUrlConn instanceof HttpsURLConnection) {
				// 创建SSLContext对象，并使用我们指定的信任管理器初始化

				TrustManager[] tm = { new MyX509TrustManager() };
				SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
				sslContext.init(null, tm, new SecureRandom());
				// 从上述SSLContext对象中得到SSLSocketFactory对象

				SSLSocketFactory ssf = sslContext.getSocketFactory();
				((HttpsURLConnection) httpUrlConn).setSSLSocketFactory(ssf);
			}
			boolean truePost = requestMethod.equals("POST") && data != null && data.length > 0;
			httpUrlConn.setDoOutput(truePost);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）

			httpUrlConn.setRequestMethod(requestMethod);

			if (requestMethod.equals("GET")) {
				httpUrlConn.connect();
			} else if (truePost) {
				// 提交数据

				OutputStream outputStream = httpUrlConn.getOutputStream();
				outputStream.write(data);
				outputStream.close();
			}

			// 读取返回数据

			InputStream inputStream = httpUrlConn.getInputStream();
			byte[] buf = new byte[1024 * 2];
			int len;
			while ((len = inputStream.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			// 释放资源

			out.close();
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
		} catch (ConnectException ce) {
		} catch (Exception e) {
		}
		return out.toByteArray();
	}

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param filePath
	 *            文件路径
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl, String filePath) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod("POST");

			// 当有数据需要提交时
			if (null != filePath) {
				OutputStream outputStream = httpUrlConn.getOutputStream();

				File file = new File(filePath);
				DataInputStream dataInputStream = new DataInputStream(
						new FileInputStream(file));

				int bytes = 0;
				byte[] bufferOut = new byte[1024];
				while ((bytes = dataInputStream.read(bufferOut)) != -1) {

					outputStream.write(bufferOut, 0, bytes);
				}
				dataInputStream.close();
				outputStream.flush();
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();

			log.info("https请求结果：[" + buffer.toString() + "]");
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}
		return jsonObject;
	}

	/**
	 * 获取access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @return
	 */
	public static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;

		String requestUrl = access_token_url.replace("APPID", appid).replace(
				"APPSECRET", appsecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
				log.info("获取token成功 :access_token=" + accessToken.getToken()
						+ ";expires_in=" + accessToken.getExpiresIn());
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} errmsg:{}", e);
			}
		}
		return accessToken;
	}

	/**
	 * 创建菜单
	 * 
	 * @param menu
	 *            菜单实例
	 * @param accessToken
	 *            有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public static int createMenu(WxMenu menu, String accessToken) {
		int result = 0;

		// 拼装创建菜单的url
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();

		/** 新增emoji表情 代码处理 形如<[[1F340]]> ***/
		Pattern pattern = Pattern.compile("(?s)<\\[\\[(.*?)\\]\\]>");
		Matcher matcher = pattern.matcher(jsonMenu);

		while (matcher.find()) {
			String reStr = matcher.group();
			String emojiStr = matcher.group(1);
			jsonMenu = jsonMenu.replace(reStr, String.valueOf(Character
					.toChars(Integer.parseInt(emojiStr, 16))));
		}
		/** end */

		log.info("生成菜单JSON串：" + jsonMenu);
		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);

		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				log.error("创建菜单失败 errcode:{} errmsg:{}---"
						+ jsonObject.getInt("errcode") + ","
						+ jsonObject.getString("errmsg"));
			} else {
				log.info("成功生成菜单!!");

			}
		}

		return result;
	}

	/**
	 * 获取用户信息详情
	 * 
	 * @Title: getUserDeatil
	 * @Description:
	 * @param @param accessToken
	 * @param @param openId
	 * @param @return 设定文件
	 * @return WxUser 返回类型
	 * @throws
	 */
	public static WxUser getUserDeatil(String accessToken, String openId) {
		WxUser wxUser = null;

		JSONObject jsonObject = null;

		try {
			String url = user_info_url.replace("ACCESS_TOKEN", accessToken)
					.replace("OPENID", openId);

			jsonObject = httpRequest(url, "GET", null);

			wxUser = (WxUser) JSONObject.toBean(jsonObject, WxUser.class);

			log.info("openid=[" + wxUser.getOpenid() + "]----unionid["
					+ wxUser.getUnionid() + "]");

		} catch (Exception e) {
			wxUser = null;
			log.error("获取微信用户详情错误errcode：" + e.getMessage());
		}

		return wxUser;
	}

	/**
	 * 根据CODE查找用户openId
	 * 
	 * @Title: getUserOpenId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param appId
	 * @param @param secret
	 * @param @param code
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String getUserOpenId(String appId, String secret, String code) {
		String openId = null;

		JSONObject jsonObject = null;
		try {
			String url = oauth2_openid_url.replace("APPID", appId)
					.replace("SECRET", secret).replace("CODE", code);
			jsonObject = httpRequest(url, "POST", null);

			openId = jsonObject.getString("openid");

		} catch (Exception e) {
			openId = null;
			log.error("根据CODE查找用户OPENID错误errcode：" + e.getMessage());
		}
		return openId;
	}

	/**
	 * 获取用户授权ACCESSTOKEN
	 * 
	 * @param appId
	 * @param secret
	 * @param code
	 * @return
	 */
	public static JSONObject getOauthAccessToken(String appId, String secret,
			String code) {

		JSONObject jsonObject = null;
		try {
			String url = oauth2_openid_url.replace("APPID", appId)
					.replace("SECRET", secret).replace("CODE", code);
			jsonObject = httpRequest(url, "POST", null);

		} catch (Exception e) {
			jsonObject = null;
			log.error("根据CODE查找OauthAccessToken错误errcode：" + e.getMessage());
		}
		return jsonObject;
	}

	/**
	 * 获取关注者列表
	 * 
	 * @Title: getUserList
	 * @Description: OPENID不填默认从头开始拉取
	 * @param @param accessToken
	 * @param @param newtOpenId
	 * @param @return 设定文件
	 * @return WxUser 返回类型
	 * @throws
	 */
	public static Map<String, Object> getUserList(String accessToken,
			String nextOpenId) {
		Map<String, Object> map = null;

		JSONObject jsonObject = null;

		try {
			String url = user_get_url.replace("ACCESS_TOKEN", accessToken)
					.replace("NEXT_OPENID", nextOpenId);

			jsonObject = httpRequest(url, "GET", null);

			map = new HashMap<String, Object>();
			map.put("total", jsonObject.getString("total"));
			map.put("count", jsonObject.getString("count"));
			map.put("next_openid", jsonObject.getString("next_openid"));
			map.put("openid_list", JSONArray.toList((jsonObject
					.getJSONObject("data")).getJSONArray("openid")));

		} catch (Exception e) {
			log.error("获取微信用户列表错误errcode：" + e.getMessage());
		}

		return map;
	}

	/**
	 * 自定义菜单删除
	 * 
	 * @Title: getUserList
	 * @Description: 返回0 表示删除成功
	 * @param @param accessToken
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public static int deleteMenu(String accessToken) {
		int result = -1;

		try {
			String url = menu_delete_url.replace("ACCESS_TOKEN", accessToken);

			JSONObject jsonObject = httpRequest(url, "GET", null);

			if (jsonObject.getInt("errcode") == 0) {
				result = 0;
			} else {
				log.error("删除自定义菜单错误errcode：["
						+ jsonObject.getString("errcode") + "]" + ",errmsg：["
						+ jsonObject.getString("errmsg") + "]");
			}
		} catch (Exception e) {
			log.error("删除自定义菜单失败", e);
		}

		return result;
	}

	/**
	 * 生成带参数的二维码
	 * 
	 * @Title: createQrcode
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param limit:是否是永久二维码(0是1不是) expire：二维码的有效时间最大不超过1800秒
	 *        sceneid：场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String createQrcode(String accessToken, int limit,
			int expire, int sceneid) {
		String ticket = "";
		String qrcodeparam = "";
		String tempQrcode = "{\"expire_seconds\":EXPRIE_SEC, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\":SCENEID}}}";
		String limitQrcode = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\":SCENEID}}}";
		JSONObject jsonObject = null;
		try {
			if (limit == 0) {
				qrcodeparam = limitQrcode.replace("SCENEID",
						String.valueOf(sceneid));
			} else if (limit == 1) {
				qrcodeparam = tempQrcode.replace("QR_LIMIT_SCEN",
						String.valueOf(expire)).replace("SCENEID",
								String.valueOf(sceneid));
			}
			String url = qrcode_create_url.replace("ACCESS_TOKEN", accessToken);

			jsonObject = httpRequest(url, "POST", qrcodeparam);

			ticket = jsonObject.getString("ticket");

		} catch (Exception e) {
			log.error("生成带参数的二维码错误errcode：" + e.getMessage());
		}

		return ticket;
	}

	/**
	 * 
	 * 
	 * @Title: sendMsg
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param accessToken
	 * @param @param jsonstr
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public static int sendMsg(String accessToken, String jsonstr) {
		int result = 0;
		try {
			// 拼装创建菜单的url
			String url = send_servicemsg_url.replace("ACCESS_TOKEN",
					accessToken);

			// 调用接口创建菜单
			JSONObject jsonObject = httpRequest(url, "POST", jsonstr);

			if (null != jsonObject) {
				if (0 != jsonObject.getInt("errcode")) {
					result = jsonObject.getInt("errcode");
					log.error("发送客服消息失败 errcode:{} errmsg:{}---"
							+ jsonObject.getInt("errcode") + ","
							+ jsonObject.getString("errmsg"));
				} else {
					log.info("发送客服消息成功:[" + accessToken + "][" + jsonstr + "]");

				}
			}
		} catch (Exception e) {
			log.error("发送客服消息失败", e);
			result = -1;
		}
		return result;
	}

	/**
	 * 发送发货通知
	 * 
	 * @Title: deliverNotify
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String deliverNotify(String accessToken, String jsonStr) {
		String result = null;
		try {

			// 拼装创建菜单的url
			String url = send_deliver_notify_url.replace("ACCESS_TOKEN",
					accessToken);

			log.info("发货通知JSON串：" + jsonStr);
			// 调用接口创建菜单
			JSONObject jsonObject = httpRequest(url, "POST", jsonStr);

			if (null != jsonObject) {
				if (0 != jsonObject.getInt("errcode")) {
					result = jsonObject.getString("errcode");
					log.error("发送发货通知失败 errcode:{} errmsg:{}---"
							+ jsonObject.getString("errcode") + ","
							+ jsonObject.getString("errmsg"));
				} else {
					log.info("成功发送发货通知!!");

				}
			}
		} catch (Exception e) {
			log.error("发送发货通知消息失败", e);
		}

		return result;
	}

	/**
	 * 上传文件到微信端
	 * 
	 * @Title: send
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param accessToken
	 * @param @param fileType
	 * @param @param filePath
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return JSONObject 返回类型
	 * @throws
	 */
	public static JSONObject send(String accessToken, String fileType,
			String filePath) throws Exception {
		String result = null;
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}
		/**
		 * 第一部分
		 */
		URL urlObj = new URL(
				"http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="
						+ accessToken + "&type=" + fileType + "");
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
		con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false); // post方式不能使用缓存
		// 设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");
		// 设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary="
				+ BOUNDARY);
		// 请求正文信息
		// 第一部分：
		StringBuilder sb = new StringBuilder();
		sb.append("--"); // 必须多两道线
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
				+ file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");
		byte[] head = sb.toString().getBytes("utf-8");
		// 获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		// 输出表头
		out.write(head);
		// 文件正文部分
		// 把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();
		// 结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
		out.write(foot);
		out.flush();
		out.close();
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		try {
			// 定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("数据读取异常");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		JSONObject jsonObj = JSONObject.fromObject(result);
		return jsonObj;
	}

	/**
	 * 获取卡卷二维码
	 * 
	 * @param accessToken
	 * @param jsonStr
	 * @return
	 */
	public static JSONObject getCardQrcodeCreateData(String accessToken,
			String jsonStr) {
		JSONObject jsonObject = null;
		try {

			String url = card_qrcode_create_url.replace("ACCESS_TOKEN",
					accessToken);

			jsonObject = httpRequest(url, "POST", jsonStr);

			if (jsonObject != null) {

				log.info("调用卡券二维码接口返回数据:" + jsonObject.toString());
			}

		} catch (Exception e) {
			jsonObject = null;
			log.error("调用卡券二维码接口错误", e);
		}

		return jsonObject;
	}

	/**
	 * 查询code接口
	 * 
	 * @param accessToken
	 * @param jsonStr
	 * @return
	 */
	public static JSONObject getCardCodeData(String accessToken, String jsonStr) {
		JSONObject jsonObject = null;
		try {

			String url = card_code_get_url.replace("ACCESS_TOKEN", accessToken);

			jsonObject = httpRequest(url, "POST", jsonStr);

			if (jsonObject != null) {

				log.info("查询卡券CODE接口返回数据:" + jsonObject.toString());
			}

		} catch (Exception e) {
			jsonObject = null;
			log.error("查询卡券CODE接口错误", e);
		}

		return jsonObject;
	}

	/**
	 * 核销卡券CODE
	 * 
	 * @param accessToken
	 * @param jsonStr
	 * @return
	 */
	public static JSONObject consumeCardCode(String accessToken, String jsonStr) {
		JSONObject jsonObject = null;
		try {

			String url = card_code_consume_url.replace("ACCESS_TOKEN",
					accessToken);

			jsonObject = httpRequest(url, "POST", jsonStr);

			if (jsonObject != null) {

				log.info("核销卡券CODE接口返回数据:" + jsonObject.toString());
			}

		} catch (Exception e) {
			jsonObject = null;
			log.error("核销卡券CODE接口错误", e);
		}

		return jsonObject;
	}

	/**
	 * 删除永久素材
	 * 
	 * @param accessToken
	 * @param jsonStr
	 * @return
	 */
	public static JSONObject delMaterialMedia(String accessToken, String jsonStr) {
		JSONObject jsonObject = null;
		try {

			String url = del_material_media_url.replace("ACCESS_TOKEN",
					accessToken);

			jsonObject = httpRequest(url, "POST", jsonStr);

			if (jsonObject != null) {

				log.info("删除永久素材接口返回数据:" + jsonObject.toString());
			}

		} catch (Exception e) {
			jsonObject = null;
			log.error("删除永久素材接口错误", e);
		}

		return jsonObject;
	}

	/**
	 * 上传图文素材
	 * 
	 * @param accessToken
	 * @param jsonStr
	 * @return
	 */
	public static JSONObject uploadWxNews(String accessToken, String jsonStr) {
		JSONObject jsonObject = null;
		try {

			String url = upload_news_url.replace("ACCESS_TOKEN", accessToken);

			jsonObject = httpRequest(url, "POST", jsonStr);

			if (jsonObject != null) {

				log.info("上传图文素材返回数据:" + jsonObject.toString());
			}

		} catch (Exception e) {
			jsonObject = null;
			log.error("上传图文素材接口错误", e);
		}

		return jsonObject;
	}

	/**
	 * 群发消息
	 * 
	 * @param accessToken
	 * @param jsonStr
	 * @return
	 */
	public static JSONObject sendAllMsg(String accessToken, String jsonStr) {
		JSONObject jsonObject = null;
		try {

			String url = sendall_msg_url.replace("ACCESS_TOKEN", accessToken);

			jsonObject = httpRequest(url, "POST", jsonStr);

			if (jsonObject != null) {

				log.info("群发消息返回数据:" + jsonObject.toString());
			}

		} catch (Exception e) {
			jsonObject = null;
			log.error("群发消息接口错误", e);
		}

		return jsonObject;
	}

	/**
	 * 群发预览接口
	 * 
	 * @param accessToken
	 * @param jsonStr
	 * @return
	 */
	public static JSONObject previewSendMsg(String accessToken, String jsonStr) {
		JSONObject jsonObject = null;
		try {

			String url = sendall_msg_preview_url.replace("ACCESS_TOKEN",
					accessToken);

			jsonObject = httpRequest(url, "POST", jsonStr);

			if (jsonObject != null) {

				log.info("群发预览接口返回数据:" + jsonObject.toString());
			}

		} catch (Exception e) {
			jsonObject = null;
			log.error("群发预览接口错误", e);
		}

		return jsonObject;
	}

	/**
	 * 通过media_id获取图片、语音、视频等文件，协议和普通的http文件下载完全相同。
	 * @author savePath (保存路径，含文件名)
	 * @param accessToken
	 * @param mediaId
	 */
	public static String getCgiMedia(String savePath,String accessToken,String mediaId)
	{
		String url = cgi_media_url.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);
		url = url.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);
		byte[] data = httpRequest_byte(url, "GET", null);
		if (data.length < 100) {
			String s = new String(data);
			if (s.startsWith("{") && s.endsWith("}")) {
				return s;
			}
		}
		try {
			FileOutputStream os = new FileOutputStream(savePath);
			os.write(data);
			os.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("assn_err_msg", "Download Exception:" + e.toString());
			return jsonObject.toString();
		}
	}

	/**
	 *
	 * @param accessToken
	 * @param mediaId
	 * @param savePath
	 * @return fileName
	 * @throws UnsupportedEncodingException
	 */
	public static String getTempMaterial(String accessToken,String mediaId,String savePath) throws UnsupportedEncodingException{
		String fileName = null;
		//1.拼接请求url
		String url = cgi_media_url.replace("ACCESS_TOKEN", accessToken)
				.replace("MEDIA_ID", mediaId);
		//2.调用接口，发送请求，获取临时素材
		String result = downLoadFile(url,savePath,mediaId);
		if(null == result)
		{
			log.info("获取微信临时图片失败:"+url);
		}else
		{
			log.info("获取微信临时图片成功:"+url);
		}
		return result;
	}

	/**
	 * * 根据url下载文件，保存到filepath中
	 * @param url 请求连接
	 * @param filepath 保存路径
	 * @param preFileName 保存文件前缀
	 * @return
	 */
	public static String downLoadFile(String url, String filepath,String preFileName){
		InputStream is = null;
		FileOutputStream fileout = null;
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = client.execute(httpget);
			int resultCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			if (resultCode >= 200 && resultCode < 300) //如果成功，读取文件
			{
				is = entity.getContent();
				Header[] allHeader = response.getAllHeaders();
				String ext = getExt(response.getHeaders("Content-Type"));
				if(ext == null)
				{
					String content = EntityUtils.toString(entity);
					log.error("内容："+content);
					//System.out.println(content);
				}
				else
				{
					File file = new File(filepath + preFileName + ext);
					fileout = new FileOutputStream(file);
					int cache = 10 * 1024;
					byte[] buffer = new byte[cache];
					int ch = 0;
					while ((ch = is.read(buffer)) != -1) {
						fileout.write(buffer, 0, ch);
					}
					return preFileName + ext;
				}
			} else {
				log.error("下载图片失败"+ EntityUtils.toString(response.getEntity(), "utf-8"));
			}
		} catch (Exception e1) {
			log.error(e1);
		}
		finally
		{
			try
			{
				if(is != null)
				{
					is.close();
				}
			}catch (Exception e)
			{
				log.error(e);
			}

			try
			{
				if(fileout != null)
				{
					fileout.flush();
				}
			}catch (Exception e)
			{
				log.error(e);
			}

			try
			{
				if(fileout != null)
				{
					fileout.close();
				}
			}catch (Exception e)
			{
				log.error(e);
			}
		}
		return null;
	}

	private static String getExt(Header[] contentType){
		for(Header header: contentType)
		{
			String headerName=WTConvert.ToString(header.getValue()).toLowerCase();
			
			if("image/jpeg".equals(headerName)||"image/jpg".equals(headerName))
			{
				return ".jpg";
			}
			else if("image/bmp".equals(headerName))
			{
				return ".bmp";
			}
			else if("image/png".equals(headerName))
			{
				return ".png";
			}
			else if("image/gif".equals(headerName))
			{
				return ".gif";
			}
			
			log.error("头文件："+header.getValue());
		}
		return null;
	}


	/**
	 * 获取jsapiticket
	 * 
	 * @param accessToken
	 * @param jsonStr
	 * @return
	 */
	public static JsApiTicket getJsapiTicket(String accessToken, String jsonStr) {
		JsApiTicket apiTicket = null;
		JSONObject jsonObject = null;
		try {

			String url = jsapi_ticket_url.replace("ACCESS_TOKEN", accessToken);

			jsonObject = httpRequest(url, "GET", null);

			if (jsonObject != null) {

				apiTicket = new JsApiTicket();
				apiTicket.setTicket(jsonObject.getString("ticket"));
				apiTicket.setExpiresIn(jsonObject.getInt("expires_in"));
				log.info("获取jsapiticket返回数据:" + jsonObject.toString());
			}

		} catch (Exception e) {
			apiTicket = null;
			log.error("获取jsapiticket接口错误", e);
		}

		return apiTicket;
	}

	/**
	 * 拉取用户信息(需scope为 snsapi_userinfo)
	 * 
	 * @param accessToken
	 * @param openId
	 * @return
	 */
	public static WxUser getScopeUserDeatil(String accessToken, String openId) {
		WxUser wxUser = null;

		JSONObject jsonObject = null;

		try {
			String url = scope_get_userinfo_url.replace("ACCESS_TOKEN",
					accessToken).replace("OPENID", openId);

			jsonObject = httpRequest(url, "GET", null);

			wxUser = (WxUser) JSONObject.toBean(jsonObject, WxUser.class);

			log.info("openid=[" + wxUser.getOpenid() + "]----unionid["
					+ wxUser.getUnionid() + "]");

		} catch (Exception e) {
			wxUser = null;
			log.error("scope-snsapi_userinfo拉取用户信息错误errcode：" + e.getMessage());
		}

		return wxUser;
	}

}
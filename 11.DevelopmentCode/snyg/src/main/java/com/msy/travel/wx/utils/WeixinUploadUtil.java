package com.msy.travel.wx.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WeixinUploadUtil {

	public static Log logger = LogFactory.getLog(WeixinUploadUtil.class);

	// 多图文素材THUMB_MEDIA_ID上传URL
	public static final String THUMB_MEDIA_ID_URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload";

	// 上传图文消息内的图片获取URL
	public static final String GROUPSEND_MEDIA_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadimg";

	// 上传永久素材 ---- 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	public static final String MATERIAL_MEDIA_URL = "https://api.weixin.qq.com/cgi-bin/material/add_material";

	// 上传临时素材
	public static final String TEMP_MEDIA_URL = "https://api.weixin.qq.com/cgi-bin/media/upload";

	public static final String MEDIA_TYPE_IMAGE = "image";

	public static final String MEDIA_TYPE_VOICE = "voice";

	public static final String MEDIA_TYPE_VIDEO = "video";

	public static final String MEDIA_TYPE_THUMB = "thumb";

	/**
	 * 微信服务器素材上传
	 * 
	 * @param file
	 *            表单名称media
	 * @param token
	 *            access_token
	 * @param type
	 *            type只支持四种类型素材(video/image/voice/thumb)
	 */
	public static String uploadMedia(String url, File file, String token, String type) {
		if (file == null || token == null || type == null) {
			return null;
		}

		if (!file.exists()) {
			logger.info("上传文件不存在,请检查!");
			return null;
		}

		String res = null;
		FilePart media = null;
		HttpClient httpClient = new HttpClient();

		// 信任任何类型的证书
		Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);
		Protocol.registerProtocol("https", myhttps);

		PostMethod post = new PostMethod(url);
		post.setRequestHeader("Connection", "Keep-Alive");
		post.setRequestHeader("Cache-Control", "no-cache");

		try {
			media = new FilePart("media", file);
			Part[] parts = new Part[] { new StringPart("access_token", token), new StringPart("type", type), media };
			MultipartRequestEntity entity = new MultipartRequestEntity(parts, post.getParams());
			post.setRequestEntity(entity);
			int status = httpClient.executeMethod(post);
			if (status == HttpStatus.SC_OK) {
				res = post.getResponseBodyAsString();
				logger.info("微信上传素材响应:" + res);
			} else {
				logger.info("upload Media failure status is:" + status);
			}
		} catch (Exception execption) {
			logger.error(execption);
		}
		return res;
	}

	/**
	 * 多媒体下载接口
	 * 
	 * @comment 不支持视频文件的下载
	 * @param fileName
	 *            素材存储文件路径
	 * @param token
	 *            认证token
	 * @param mediaId
	 *            素材ID（对应上传后获取到的ID）
	 * @return 素材文件
	 */
	public static File downloadMedia(String url, String fileName, String token, String mediaId) {

		return httpRequestToFile(fileName, url, "GET", null);
	}

	/**
	 * 以http方式发送请求,并将请求响应内容输出到文件
	 * 
	 * @param path
	 *            请求路径
	 * @param method
	 *            请求方法
	 * @param body
	 *            请求数据
	 * @return 返回响应的存储到文件
	 */
	public static File httpRequestToFile(String fileName, String path, String method, String body) {
		if (fileName == null || path == null || method == null) {
			return null;
		}

		File file = null;
		HttpURLConnection conn = null;
		InputStream inputStream = null;
		FileOutputStream fileOut = null;
		try {
			URL url = new URL(path);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod(method);
			if (null != body) {
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(body.getBytes("UTF-8"));
				outputStream.close();
			}

			inputStream = conn.getInputStream();
			if (inputStream != null) {
				file = new File(fileName);
			} else {
				return file;
			}

			// 写入到文件
			fileOut = new FileOutputStream(file);
			if (fileOut != null) {
				int c = inputStream.read();
				while (c != -1) {
					fileOut.write(c);
					c = inputStream.read();
				}
			}
		} catch (Exception e) {
			logger.error(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}

			/*
			 * 必须关闭文件流 否则JDK运行时，文件被占用其他进程无法访问
			 */
			try {
				inputStream.close();
				fileOut.close();
			} catch (IOException execption) {
				logger.error(execption);
			}
		}
		return file;
	}

	/**
	 * 发送请求以https方式发送请求并将请求响应内容以String方式返回
	 * 
	 * @param path
	 *            请求路径
	 * @param method
	 *            请求方法
	 * @param body
	 *            请求数据体
	 * @return 请求响应内容转换成字符串信息
	 */
	public static String httpsRequestToString(String path, String method, String body) {
		if (path == null || method == null) {
			return null;
		}

		String response = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		HttpsURLConnection conn = null;
		try {
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(path);
			conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod(method);
			if (null != body) {
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(body.getBytes("UTF-8"));
				outputStream.close();
			}

			inputStream = conn.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			response = buffer.toString();
		} catch (Exception e) {
			logger.error(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
			try {
				bufferedReader.close();
				inputStreamReader.close();
				inputStream.close();
			} catch (IOException execption) {
				logger.error(execption);
			}
		}
		return response;
	}

	/**
	 * 上传永久视频文件 （在上传视频素材时需要POST另一个表单，id为description，包含素材的描述信息，内容格式为JSON）
	 * 
	 * @param url
	 *            请求地址
	 * @param file
	 *            视频文件
	 * @param token
	 *            token
	 * @param title
	 *            视频素材的标题
	 * @param introduction
	 *            视频素材的描述
	 * @return
	 */
	public static String uploadVideoFile(String url, File file, String token, String title, String introduction) {

		if (url == null || file == null || token == null) {
			return null;
		}
		if (!file.exists()) {
			logger.info("上传文件不存在,请检查!");
			return null;
		}
		url += "?type=video&access_token=" + token;
		String result = null;
		try {
			URL url1 = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(30000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Cache-Control", "no-cache");
			String boundary = "-----------------------------" + System.currentTimeMillis();
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

			OutputStream output = conn.getOutputStream();
			output.write(("--" + boundary + "\r\n").getBytes("utf-8"));
			output.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\"%s\"\r\n", file.getName()).getBytes());
			output.write("Content-Type: video/mp4 \r\n\r\n".getBytes("utf-8"));
			byte[] data = new byte[1024];
			int len = 0;
			FileInputStream input = new FileInputStream(file);
			while ((len = input.read(data)) > -1) {
				output.write(data, 0, len);
			}
			output.write(("--" + boundary + "\r\n").getBytes());
			output.write("Content-Disposition: form-data; name=\"description\";\r\n\r\n".getBytes("utf-8"));
			output.write(String.format("{\"title\":\"%s\", \"introduction\":\"%s\"}", title, introduction).getBytes("utf-8"));
			output.write(("\r\n--" + boundary + "--\r\n\r\n").getBytes());
			output.flush();
			output.close();
			input.close();
			InputStream resp = conn.getInputStream();
			StringBuffer sb = new StringBuffer();
			while ((len = resp.read(data)) > -1)
				sb.append(new String(data, 0, len, "utf-8"));
			resp.close();
			result = sb.toString();
			logger.info("上传永久视频素材响应:" + result);
		} catch (Exception e) {
			logger.error("postFile数据传输失败", e);
		}

		return result;
	}

	public static void main(String[] args) {

		// String url =
		// "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token="
		// + "U_0AIUrkfmVk0LXlaGu0lx5CXx-_4&type=video";
		// uploadVideoFile(url, "/Users/jlusoft/Desktop/test.mp4", "test",
		// "dfd");
		//
		// File f = new File("D:/test.png");
		//
		// JSONObject o = WeixinUploadUtil.uploadMedia(f,
		// token.getAccessToken(), "image");
		//
		// System.out.println(o.toString());
		//
		// // 下载刚刚上传的图片以id命名
		// String media_id = o.getString("media_id");
		// File t = WeixinUploadUtil.downloadMedia("D:/" + media_id + ".png",
		// token.getAccessToken(), media_id);

	}

}

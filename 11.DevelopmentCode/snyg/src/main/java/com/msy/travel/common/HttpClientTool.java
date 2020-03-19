package com.msy.travel.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientTool {
	public static final Log log = LogFactory.getLog(HttpClientTool.class);

	/**
	 * 获取文件后缀或者ContentType(fileSuffix=文件后缀；ContentType=文件内容类型)
	 * @param paramIFileSuffix 当true，则根据param=fileSuffix获取文件ContentType;当false，则根据param=ContentType获取fileSuffix
	 * @return 
	 */
	public static String getFileSuffixOrContentType(Boolean paramIFileSuffix,String param) {
		param = param.toLowerCase();
		Map<String,String> map = new HashMap<String,String>();
		map.put("png", "image/png");
		map.put("jpg", "image/jpeg");
		map.put("jpe", "image/jpeg");
		map.put("jpeg", "image/jpeg");
		map.put("gif", "image/gif");
		map.put("amr", "audio/amr");
		map.put("mp3", "audio/mpeg");
		map.put("mp4", "video/mp4;video/mpeg4");
		map.put("bmp", "image/bmp");
		map.put("cod", "image/cis-cod");
		map.put("ief", "image/ief");
		map.put("jfif", "image/pipeg");
		map.put("svg", "image/svg+xml");
		map.put("tif", "image/tiff");
		map.put("ras", "image/x-cmu-raster");
		map.put("cmx", "image/x-cmx");
		map.put("ico", "image/x-icon");
		map.put("pnm", "image/x-portable-anymap");
		map.put("pbm", "image/x-portable-bitmap");
		map.put("pgm", "image/x-portable-graymap");
		map.put("ppm", "image/x-portable-pixmap");
		map.put("rgb", "image/x-rgb");
		map.put("xbm", "image/x-xbitmap");
		map.put("xpm", "image/x-xpixmap");
		map.put("xwd", "image/x-xwindowdump");
		Set<String> allKey = map.keySet();
		if(paramIFileSuffix) //通过后缀找ContentType
		{
			return map.get(param);
		}else //通过contntType找后缀
		{
			for(String key : allKey)
			{
				String[] values = map.get(key).split(";");
				for(String value:values)
				{
					if(param.equals(value))
					{
						return key;
					}
				}
			}
		}
		
		return null;
	}
	/**
	 * 执行Http的get请求,字节型
	 * 
	 * @param httpGet
	 * @return null:未请求成功,字符串：请求结果body
	 */
	public static String doHttpGet(HttpGet httpGet) {
		String result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpGet);
			Header[] allHeader = httpResponse.getAllHeaders();
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8);
				EntityUtils.consume(httpResponse.getEntity());
			} else {
				log.error(httpGet.getURI().toString() + ":" + httpResponse.getStatusLine().getStatusCode() + ":" + httpResponse.getStatusLine().getReasonPhrase());
			}
		} catch (IOException e) {
			log.error(e);
		} finally {
			try {
				if (httpResponse != null) {
					httpResponse.close();
				}
			} catch (IOException e) {
				log.error("httpResponse.close false:" + e.getMessage());
			}
			try {
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				log.error("httpClient.close false:" + e.getMessage());
			}
		}
		return result;
	}

	/**
	 * 执行Http的get请求,流型
	 * 
	 * @param httpGet
	 * @param filePath
	 *            文件保存路径,如/home/xxx/
	 * @return null:未请求成功,File：请求结果
	 */
	public static File doHttpGetForFile(HttpGet httpGet, String filePath) {
		File path = new File(filePath);
		if (!path.exists()) {
			path.mkdirs();
		}
		File file = null;
		InputStream is = null;
		FileOutputStream fileout = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				is = httpResponse.getEntity().getContent();
				String fileSuffix = null;// 保存文件的后缀
				Header[] headers = httpResponse.getHeaders("Content-Type");
				for (Header header : headers) {
					// System.out.println(header.getName() + ":" +
					// header.getValue());
				}
				for (Header header : headers) {
					/** 常用 **/
					if (header.getValue().contains("image/png")) {// 待测试png的mime类型
						fileSuffix = "png";
					} else if (header.getValue().contains("image/jpeg")) {
						fileSuffix = "jpg";// jpe||jpeg||jpg
					} else if (header.getValue().contains("image/gif")) {
						fileSuffix = "gif";
					} else if (header.getValue().contains("audio/amr")) {
						fileSuffix = "amr";
					} else if (header.getValue().contains("audio/mpeg")) {
						fileSuffix = "mp3";
					} else if (header.getValue().contains("video/mp4") || header.getValue().contains("video/mpeg4")) {
						fileSuffix = "mp4";
					}
					/** 常用 end **/
					else if (header.getValue().contains("image/bmp")) {
						fileSuffix = "bmp";
					} else if (header.getValue().contains("image/cis-cod")) {
						fileSuffix = "cod";
					} else if (header.getValue().contains("image/ief")) {
						fileSuffix = "ief";
					} else if (header.getValue().contains("image/pipeg")) {
						fileSuffix = "jfif";
					} else if (header.getValue().contains("image/svg+xml")) {
						fileSuffix = "svg";
					} else if (header.getValue().contains("image/tiff")) {
						fileSuffix = "tif"; // tif||tiff
					} else if (header.getValue().contains("image/x-cmu-raster")) {
						fileSuffix = "ras";
					} else if (header.getValue().contains("image/x-cmx")) {
						fileSuffix = "cmx";
					} else if (header.getValue().contains("image/x-icon")) {
						fileSuffix = "ico";
					} else if (header.getValue().contains("image/x-portable-anymap")) {
						fileSuffix = "pnm";
					} else if (header.getValue().contains("image/x-portable-bitmap")) {
						fileSuffix = "pbm";
					} else if (header.getValue().contains("image/x-portable-graymap")) {
						fileSuffix = "pgm";
					} else if (header.getValue().contains("image/x-portable-pixmap")) {
						fileSuffix = "ppm";
					} else if (header.getValue().contains("image/x-rgb")) {
						fileSuffix = "rgb";
					} else if (header.getValue().contains("image/x-xbitmap")) {
						fileSuffix = "xbm";
					} else if (header.getValue().contains("image/x-xpixmap")) {
						fileSuffix = "xpm";
					} else if (header.getValue().contains("image/x-xwindowdump")) {
						fileSuffix = "xwd";
					}
					if (fileSuffix != null) {
						break;
					}
				}
				if (fileSuffix == null)// 不支持的格式或者不是文件格式
				{
					log.error("不支持的格式或者不能使用流读取");
					return null;
				}
				file = new File(filePath + PrimaryKeyUtil.generateKey() + "." + fileSuffix);
				fileout = new FileOutputStream(file);
				// 读取流并保存内容到file中
				int cache = 10 * 1024;
				byte[] buffer = new byte[cache];
				int ch = 0;
				while ((ch = is.read(buffer)) != -1) {
					fileout.write(buffer, 0, ch);
				}
			} else {
				log.error(httpGet.getURI().toString() + ":" + httpResponse.getStatusLine().getStatusCode() + ":" + httpResponse.getStatusLine().getReasonPhrase());
				return null;
			}
		} catch (IOException e) {
			log.error(e);
			return null;
		} finally {
			try {
				if (httpResponse != null) {
					httpResponse.close();
				}
			} catch (IOException e) {
				log.error("httpResponse.close false:" + e.getMessage());
				return null;
			}
			try {
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				log.error("httpClient.close false:" + e.getMessage());
				return null;
			}
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				log.error("InputStream.close false:" + e.getMessage());
				return null;
			}
			try {
				if (fileout != null) {
					fileout.close();
				}
			} catch (IOException e) {
				log.error("FileOutputStream.close false:" + e.getMessage());
				return null;
			}
		}
		return file;
	}

	/**
	 * 执行Http的post请求
	 * 
	 * @param httpPost
	 * @return null:未请求成功,字符串：请求结果body
	 */
	public static Result doHttpPost(HttpPost httpPost) {
		Result result = new Result();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpPost);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				String resultStr = EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8);
				EntityUtils.consume(httpResponse.getEntity());
				result.setResultCode("0");
				result.setResultMsg(resultStr);
			} else {
				log.error(httpPost.getURI().toString() + ":" + httpResponse.getStatusLine().getStatusCode() + ":" + httpResponse.getStatusLine().getReasonPhrase());
				result.setResultCode("1");
				result.setResultMsg("Http Post StatusCode is " + httpResponse.getStatusLine().getStatusCode());
			}
		} catch (IOException e) {
			log.error(e);
			result.setResultCode("1");
			result.setResultMsg("Http Post IOException");
		} finally {
			try {
				if (httpResponse != null) {
					httpResponse.close();
				}
			} catch (IOException e) {
				log.error("httpResponse.close false:" + e.getMessage());
				result.setResultCode("1");
				result.setResultMsg("Http Post httpResponse.close false");
			}
			try {
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				log.error("httpClient.close false:" + e.getMessage());
				result.setResultCode("1");
				result.setResultMsg("Http Post httpClient.close false");
			}
		}
		return result;
	}

	/**
	 * 执行Http的get请求,流型
	 * 
	 * @param httpPost
	 * @param filePath
	 *            文件保存路径,如/home/xxx/
	 * @param defaultFileSuffix 指定文件保存后缀，null则根据内容自动生成
	 * @return null:未请求成功,File：请求结果
	 */
	public static File doHttpPostForFile(HttpPost httpPost, String filePath) {
		File path = new File(filePath);
		if (!path.exists()) {
			path.mkdirs();
		}
		File file = null;
		InputStream is = null;
		FileOutputStream fileout = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpPost);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				is = httpResponse.getEntity().getContent();
				String fileSuffix = null;
				Header[] allHeaders = httpResponse.getAllHeaders();
				for (Header header : allHeaders) {
					log.error(header.getName()+"====="+header.getValue());
				}
				//常规获取后缀方式，Content-Type
				Header[] headers = httpResponse.getHeaders("Content-Type");
				for (Header header : headers) {
					fileSuffix = getFileSuffixOrContentType(false,header.getValue());
					if (fileSuffix != null) {
						break;
					}
				}
				if (fileSuffix == null)//如果常规方式不能获取，在微信中 Content-disposition=attachment; filename="ec5080d0d2464841b45dbc38d67dc796.jpg"
				{
					headers = httpResponse.getHeaders("Content-disposition");
					for (Header header : headers) {
						if(header.getValue().indexOf("filename")>-1)
						{
							fileSuffix = header.getValue().replaceAll("\"", "").split("\\.")[1];
						}
					}
				}
				
				if (fileSuffix == null)// 不支持的格式或者不是文件格式
				{
					log.error("不支持的格式或者不能使用流读取");
					return null;
				}
				file = new File(filePath + UUID.randomUUID() + "." + fileSuffix);
				fileout = new FileOutputStream(file);
				// 读取流并保存内容到file中
				int cache = 10 * 1024;
				byte[] buffer = new byte[cache];
				int ch = 0;
				while ((ch = is.read(buffer)) != -1) {
					fileout.write(buffer, 0, ch);
				}
			} else {
				log.error(httpPost.getURI().toString() + ":" + httpResponse.getStatusLine().getStatusCode() + ":" + httpResponse.getStatusLine().getReasonPhrase());
				return null;
			}
		} catch (IOException e) {
			log.error(e);
		} finally {
			try {
				if (httpResponse != null) {
					httpResponse.close();
				}
			} catch (IOException e) {
				log.error("httpResponse.close false:" + e.getMessage());
			}
			try {
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				log.error("httpClient.close false:" + e.getMessage());
			}
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				log.error("InputStream.close false:" + e.getMessage());
			}
			try {
				if (fileout != null) {
					fileout.close();
				}
			} catch (IOException e) {
				log.error("FileOutputStream.close false:" + e.getMessage());
			}
		}
		return file;
	}
}

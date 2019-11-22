package com.msy.travel.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpUtils {

	private static Log log = LogFactory.getLog(HttpUtils.class);

	public static String sendRequset(String ServerUrl, Map<String, String> paramMap) {
		String o = null;
		try {
			o = sendRequset(ServerUrl, paramMap, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}

	public static String sendRequset(String ServerUrl, Map<String, String> paramMap, String encode) {
		String o = null;
		try {
			PostMethod postMethod = new PostMethod(ServerUrl);
			postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + encode);

			for (Entry<String, String> entry : paramMap.entrySet()) {
				postMethod.addParameter(entry.getKey(), entry.getValue());
			}
			HttpClient httpClient = new HttpClient();
			int statusCode = httpClient.executeMethod(postMethod);
			log.info("HttpUtils - sendRequset - statusCode = " + statusCode);
			o = postMethod.getResponseBodyAsString();

			postMethod.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}

	public static Map<String, Object> sendRequsetReturnMap(String serverUrl, Map<String, Object> paramMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		PostMethod postMethod = new PostMethod(serverUrl);
		HttpClient httpClient = new HttpClient();
		int statusCode = 0;
		try {
			postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			for (Entry<String, Object> entry : paramMap.entrySet()) {
				postMethod.addParameter(entry.getKey(), entry.getValue().toString());
			}
			// 设置连接时间
			httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
			httpClient.getHttpConnectionManager().getParams().setSoTimeout(30000);
			statusCode = httpClient.executeMethod(postMethod);
			map.put("statusCode", statusCode);
			map.put("soapResponseData", postMethod.getResponseBodyAsString());
			// map.put("", value);
		} catch (Exception e) {
			map.put("statusCode", statusCode);
		} finally {
			postMethod.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		return map;
	}

}

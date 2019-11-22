package com.msy.travel.common;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * URL短地址转换类
 * 
 * @author whn
 * @date 2015年9月23日 上午9:23:03
 */
public class ShortUrlUtils {

	private static String baiduServerUrl = "http://dwz.cn/create.php";

	private static String Server980Url="http://980.so/api.php";
	
	/**
	 * 长地址换成短地址
	 * 
	 * @author whn
	 * @date 2015年9月23日 上午9:23:30
	 * @param url
	 * @return
	 * @return String 如果转换成功返回短地址 转换失败则返回长地址
	 */
	public static String translatUrl(String url) {

		String respurl = url;
		try {

			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("url", url);
			String res = HttpUtils.sendRequset(baiduServerUrl, paramMap);
			if (res != null) {
				JSONObject jsonObject = JSONObject.fromObject(res);
				if (jsonObject.getString("status") != null && "0".equals(jsonObject.getString("status"))) {
					if (jsonObject.getString("tinyurl") != null && !"".equals(jsonObject.getString("tinyurl"))) {
						respurl = jsonObject.getString("tinyurl");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			respurl = url;
		}
		return respurl;
	}

	/**
	 * 长地址换成短地址 980.so
	 * 
	 * @author whn
	 * @date 2015年9月23日 上午9:23:30
	 * @param url
	 * @return
	 * @return String 如果转换成功返回短地址 转换失败则返回长地址
	 */
	public static String translat980Url(String url) {

		String respurl = url;
		try {

			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("url", url);
			String res = HttpUtils.sendRequset(Server980Url, paramMap);
			if (res != null) {
				respurl=res;
			}
		} catch (Exception e) {
			e.printStackTrace();
			respurl = url;
		}
		return respurl;
	}
	
	
	public static void main(String[] args) {

		//String res = ShortUrlUtils.translatUrl("http://piao.ibaotuan.net/travelpdp/qr/121212.do");
		String res=ShortUrlUtils.translat980Url("http://pdp.xzlyfw.com/travelpdp/qr/254772.do");
		System.out.println(res);
	}
}

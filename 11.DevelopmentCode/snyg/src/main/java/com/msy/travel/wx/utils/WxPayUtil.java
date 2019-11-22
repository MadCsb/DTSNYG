package com.msy.travel.wx.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.msy.travel.wx.utils.MD5Util;
import com.msy.travel.wx.utils.MyX509TrustManager;
import com.msy.travel.wx.utils.Sha1Util;

public class WxPayUtil {

	public static final Log log = LogFactory.getLog(WxPayUtil.class);
	/**
	 * 微信统一支付URL
	 */
	public static String WX_PAY_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	/**
	 * 微信发红包URL
	 */
	public static String WX_SENDREDPACK_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";

	/**
	 * https证书请求url
	 *
	 * @Title: sslHttpRequest
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param requestUrl
	 * @param @param requestMethod
	 * @param @param outputStr
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String sslHttpRequest(String requestUrl, String requestMethod, String outputStr, String caPath, String caPwd) {
		StringBuffer buffer = new StringBuffer();
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			FileInputStream instream = new FileInputStream(new File(caPath));
			try {
				keyStore.load(instream, caPwd.toCharArray());
			} finally {
				instream.close();
			}

			// Trust own CA and all self-signed certs
			SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, caPwd.toCharArray()).build();
			// Allow TLSv1 protocol only
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			try {

				HttpPost httppost = new HttpPost(requestUrl);
				StringEntity outentity = new StringEntity(outputStr, "utf-8");
				httppost.setEntity(outentity);

				CloseableHttpResponse response = httpclient.execute(httppost);
				try {
					HttpEntity entity = response.getEntity();

					if (entity != null) {
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(), "utf-8"));
						String text;
						while ((text = bufferedReader.readLine()) != null) {
							buffer.append(text);
						}
					}
					EntityUtils.consume(entity);
				} finally {
					response.close();
				}
			} finally {
				httpclient.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	/**
	 * HTTP请求方法
	 * 
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @return
	 */
	public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
		String res = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
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
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

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
			res = buffer.toString();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 生成签名 自动调整如下： 1.参数名ASCII码从小到大排序（字典序） 2.如果参数的值为空不参与签名； 3.参数名区分大小写；
	 * 
	 * @param paramMap
	 * @param key
	 * @return
	 */
	public static String createSign(Map<String, String> paramMap, String key) {
		StringBuffer parmaStr = new StringBuffer();
		List<String> paramNameList = new ArrayList<String>(paramMap.keySet());
		Collections.sort(paramNameList);
		for (String paramName : paramNameList) {
			parmaStr.append(paramName).append("=").append(paramMap.get(paramName)).append("&");
		}
		parmaStr.append("key=");
		parmaStr.append(key);

		log.info("微信支付 params:" + parmaStr.toString());

		// 参数含有中文时，必须使用UTF8编码进行MD5加密 否则会出现“签名错误”
		return MD5Util.MD5Encode(parmaStr.toString(), "utf-8").toUpperCase();
	}

	/**
	 * 获取微信支付结果
	 * 
	 * @return
	 * @throws DocumentException
	 */
	public static Map<String, String> getPayNotifyResult(InputStream inputStream) throws DocumentException {
		Map<String, String> resultMap = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		try {
			reader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
			reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		} catch (Exception e) {
			log.error("获取微信支付结果失败" + e.toString());
		}
		Document xmldoc = reader.read(inputStream);
		Element root = xmldoc.getRootElement();
		List<Element> xlist = root.elements();
		for (int i = 0; i < xlist.size(); i++) {
			Element element = xlist.get(i);
			resultMap.put(element.getName(), element.getText());
		}
		return resultMap;
	}

	/**
	 * 获取微信扫码预支付码
	 */
	public static String getQrcodePreCode(Map<String, String> paramMap) {
		try {
			paramMap.put("nonce_str", Sha1Util.getNonceStr());// 随机字符串，不长于32位
			paramMap.put("notify_url", "");// 暂时未用，调试的人根据具体情况设置
			// 生成签名
			String key = paramMap.get("key");
			paramMap.remove("key");
			String sign = WxPayUtil.createSign(paramMap, key);
			paramMap.put("sign", sign);
			// 生成请求XML
			Document document = DocumentHelper.createDocument();
			Element elementXml = document.addElement("xml");
			for (Entry<String, String> entry : paramMap.entrySet()) {
				elementXml.addElement(entry.getKey()).addCDATA(entry.getValue());
			}
			log.info("微信支付 params xml:" + document.asXML());
			String res = WxPayUtil.httpRequest(WxPayUtil.WX_PAY_URL, "POST", document.asXML());
			log.info("微信支付统一支付接口响应:" + res);

			Map<String, String> resMap = new HashMap<String, String>();
			SAXReader reader = new SAXReader();
			try {
				reader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
				reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
				reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
			} catch (Exception e) {
				log.error("获取微信支付结果失败" + e.toString());
			}
			Document xmldoc = reader.read(new ByteArrayInputStream(res.getBytes("UTF-8")));
			Element root = (Element) xmldoc.selectSingleNode("xml");
			List<Element> list = root.elements();
			for (int i = 0; i < list.size(); i++) {
				Element element = list.get(i);
				resMap.put(element.getName(), element.getText());
			}

			if (resMap.get("return_code") != null && resMap.get("result_code") != null && "SUCCESS".equals(resMap.get("return_code").toUpperCase())
					&& "SUCCESS".equals(resMap.get("result_code").toUpperCase())) {
				return resMap.get("code_url").toString();
			}
		} catch (Exception e) {
			log.error("微信支付获取二维码地址错误");
			return "";
		}
		return "";
	}

	public static void main(String[] args) {

		// String xml = "<xml><appid>wx2421b1c4370ec43b</appid>"+
		// "<attach><![CDATA[att1]]></attach>"+
		// "<body>JSAPI支付测试</body>"+
		// "<device_info>1000</device_info>"+
		// "<mch_id>10000100</mch_id>"+
		// "<nonce_str>b927722419c52622651a871d1d9ed8b2</nonce_str>"+
		// "<notify_url>http://wxpay.weixin.qq.com/pub_v2/pay/notify.php</notify_url>"+
		// "<out_trade_no>1405713376</out_trade_no>"+
		// "<spbill_create_ip>127.0.0.1</spbill_create_ip>"+
		// "<total_fee>1</total_fee>"+
		// "<trade_type>JSAPI</trade_type>"+
		// "<sign>3CA89B5870F944736C657979192E1CF4</sign>"+
		// "</xml>";
		//
		//
		// <xml>
		// <sign><![CDATA[FCF9EBD345001C64601485F867D3DD77]]></sign>
		// <body><![CDATA[测试支付]]></body>
		// <mch_id><![CDATA[10028834]]></mch_id>
		// <product_id><![CDATA[111]]></product_id>
		// <spbill_create_ip><![CDATA[test1.wootide.net]]></spbill_create_ip>
		// <total_fee><![CDATA[0.01]]></total_fee>
		// <notify_url><![CDATA[]]></notify_url>
		// <appid><![CDATA[wx1015e7c2c8e4ecda]]></appid>
		// <nonce_str><![CDATA[fa47a8afc054461b702dacbbcd204818]]></nonce_str>
		// <out_trade_no><![CDATA[chengsb001]]></out_trade_no>
		// <trade_type><![CDATA[NATIVE]]></trade_type>
		// </xml>

		// System.out.println(WxPayUtil.httpRequest("https://api.mch.weixin.qq.com/pay/unifiedorder",
		// "POST", xml));
		Map<String, String> map = new HashMap<String, String>();
		map.put("appid", "wx1015e7c2c8e4ecda");
		map.put("mch_id", "10028834");
		map.put("body", "测试支付");
		map.put("out_trade_no", "chengsb001");
		// ？？？？元该分，不带小树
		map.put("total_fee", "0.01");
		map.put("spbill_create_ip", "test1.wootide.net");
		map.put("trade_type", "NATIVE");
		map.put("product_id", "111");
		map.put("key", "ll6dzmj0chev5hrl6vrjk0ozerkhmwec");

		String url = WxPayUtil.getQrcodePreCode(map);
		System.out.println(url);
	}
}

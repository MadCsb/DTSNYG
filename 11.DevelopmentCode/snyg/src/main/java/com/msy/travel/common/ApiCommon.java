package com.msy.travel.common;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.crypto.Cipher;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;

public class ApiCommon {

	public static String getRequsetParamMapToString(Map<String, Object> paramMap) {
		String param = "";
		try {
			List<String> list = new ArrayList<String>();
			for (Entry<String, Object> entry : paramMap.entrySet()) {
				list.add(entry.getKey());
			}
			Collections.sort(list); // 首字母排序

			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					param += list.get(i) + "=" + paramMap.get(list.get(i));
				} else {
					param += "&" + list.get(i) + "=" + paramMap.get(list.get(i));
				}
			}
		} catch (Exception ex) {

		}
		return param;
	}

	public static String getResponseParamMapToString(Map<String, Object> paramMap) {
		String jsonStr = "";
		try {
			JSONObject json = JSONObject.fromObject(paramMap);
			jsonStr = json.toString();
		} catch (Exception ex) {

		}
		return jsonStr;
	}

	/**
	 * RSA公钥加密
	 * 
	 * @param str
	 *            加密字符串
	 * @param publicKey
	 *            公钥
	 * @return 密文
	 * @throws Exception
	 *             加密过程中的异常信息
	 */
	public static String encrypt(String str, String publicKey) throws Exception {
		String outStr = str;
		try {
			// base64编码的公钥
			byte[] decoded = Base64.decodeBase64(publicKey);
			RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
			// RSA加密
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
		} catch (Exception ex) {

		}

		return outStr;
	}

	/**
	 * RSA私钥解密
	 * 
	 * @param str
	 *            加密字符串
	 * @param privateKey
	 *            私钥
	 * @return 铭文
	 * @throws Exception
	 *             解密过程中的异常信息
	 */
	public static String decrypt(String str, String privateKey) {
		String outStr = str;
		try {
			// 64位解码加密后的字符串
			byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
			// base64编码的私钥
			byte[] decoded = Base64.decodeBase64(privateKey);
			RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
			// RSA解密
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, priKey);
			outStr = new String(cipher.doFinal(inputByte));

		} catch (Exception ex) {

		}
		return outStr;
	}
}

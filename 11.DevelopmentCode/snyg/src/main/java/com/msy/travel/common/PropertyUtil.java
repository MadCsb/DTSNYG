package com.msy.travel.common;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertyUtil {
	private static final String DEFAULT_PROPERTY = "jdbc_config.properties";

	private static final Log log = LogFactory.getLog(PropertyUtil.class);

	/**
	 * 获取指定配置文件属性值
	 * 
	 * @author Gengb
	 * @date 2016年7月1日 上午8:43:29
	 * @param key
	 * @param propertyfile
	 * @param defaultValue
	 *            默认值
	 * @return
	 * @return String
	 */
	public static String getPropertyByKey(String key, String propertyfile, String defaultValue) {
		log.debug("PropertyFile : " + propertyfile);
		Properties prop = new Properties();
		String value = "";

		try {
			prop.load(PropertyUtil.class.getClassLoader().getResourceAsStream(propertyfile));

			if (defaultValue != null && !defaultValue.equals("")) {
				value = prop.getProperty(key, defaultValue);
			} else {
				value = prop.getProperty(key);
			}

			value = new String(value.getBytes("ISO8859-1"), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 获取默认配置文件jdbc_config.properties属性值
	 * 
	 * @author Gengb
	 * @date 2016年6月27日 上午10:06:05
	 * @param key
	 * @return
	 * @return String
	 */
	public static String getPropertyByKey(String key) {
		return getPropertyByKey(key, DEFAULT_PROPERTY, null);
	}

	/**
	 * 获取默认配置文件jdbc_config.properties属性值
	 * 
	 * @author Gengb
	 * @date 2016年7月1日 上午9:02:43
	 * @param key
	 * @param defaultValue
	 *            默认值
	 * @return
	 * @return String
	 */
	public static String getPropertyByKey(String key, String defaultValue) {
		return getPropertyByKey(key, DEFAULT_PROPERTY, defaultValue);
	}

	public static void main(String[] args) {
		System.out.println(PropertyUtil.getPropertyByKey("email.address"));
		System.out.println(PropertyUtil.getPropertyByKey("email.password"));
		System.out.println(PropertyUtil.getPropertyByKey("email.nickName"));
		System.out.println(PropertyUtil.getPropertyByKey("email.mail.smtp.host"));
		System.out.println(PropertyUtil.getPropertyByKey("email.mail.smtp.port"));
		System.out.println(PropertyUtil.getPropertyByKey("email.mail.smtp.auth"));
		System.out.println("******");

		System.out.println(PropertyUtil.getPropertyByKey("email.address", "jdbc_config.properties", null));
		System.out.println(PropertyUtil.getPropertyByKey("email.password", "jdbc_config.properties", null));
		System.out.println(PropertyUtil.getPropertyByKey("email.nickName", "jdbc_config.properties", null));
		System.out.println(PropertyUtil.getPropertyByKey("email.mail.smtp.host", "jdbc_config.properties", null));
		System.out.println(PropertyUtil.getPropertyByKey("email.mail.smtp.port", "jdbc_config.properties", null));
		System.out.println(PropertyUtil.getPropertyByKey("email.mail.smtp.auth", "jdbc_config.properties", null));
		System.out.println("******");

		System.out.println(PropertyUtil.getPropertyByKey("sms.isSend", "false"));
		System.out.println(PropertyUtil.getPropertyByKey("sms.SpCode"));
		System.out.println(PropertyUtil.getPropertyByKey("sms.LoginName"));
		System.out.println(PropertyUtil.getPropertyByKey("sms.Password"));
	}
}

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
 * @Title: WTConvert.java 
 * @Package com.wootide.lmsrv.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Administrator  
 * @date 2012-2-22 下午01:20:13 
 * @version V1.0   
 */
package com.msy.travel.common;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @ClassName: WTConvert
 * @Description: TODO(本类用于类型转换)
 * @author jy
 * @date 2012-2-22 下午01:20:13
 * @version 1.0
 */
public final class WTConvert {

	/**
	 * 
	 *
	 * @Title: ToString
	 * @Description: TODO(将Object对象转换为字符串)
	 * @param @param aValue
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String ToString(Object val) {
		String result = "";
		try {
			if (val != null) {
				result = val.toString();
			}
		} catch (Exception ex) {

		}
		return result;
	}

	/**
	 * 过滤非法字符
	 * 
	 * @param str
	 * @return
	 * @throws PatternSyntaxException
	 */
	public static String StringFilter(String str) throws PatternSyntaxException {
		if (str != null && !"".equals(str)) {
			String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(str);
			return m.replaceAll("").trim();
		} else {
			return str;
		}
	}

	public static boolean StringFilterCheck(String str) throws PatternSyntaxException {
		if (str != null && !"".equals(str)) {
			String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(str);
			return m.find();
		} else {
			return false;
		}
	}

	/**
	 * 
	 *
	 * @Title: ToDouble
	 * @Description: TODO(将Object转换成Double型)
	 * @param @param value
	 * @param @return 设定文件
	 * @return double 返回类型
	 * @throws
	 */
	public static double ToDouble(Object value) {
		double result = 0.00;
		try {
			result = Double.parseDouble(ToString(value));
		} catch (NumberFormatException ex) {

		}
		return result;
	}

	/**
	 * 
	 *
	 * @Title: ToFloat
	 * @Description: TODO(将Object类型转换为Float)
	 * @param @param value
	 * @param @return 设定文件
	 * @return double 返回类型
	 * @throws
	 */
	public static float ToFloat(Object value) {
		float result = 0.00f;
		try {
			result = Float.parseFloat(ToString(value));
		} catch (NumberFormatException ex) {

		}
		return result;
	}

	/**
	 * 
	 *
	 * @Title: ToByte
	 * @Description: TODO(将Object类型转换为Byte)
	 * @param @param value
	 * @param @return 设定文件
	 * @return double 返回类型
	 * @throws
	 */
	public static byte ToByte(Object value) {
		byte result = 0;
		try {
			result = Byte.parseByte(ToString(value));
		} catch (NumberFormatException ex) {

		}
		return result;
	}

	/**
	 * 
	 *
	 * @Title: ToShort
	 * @Description: TODO(将Object类型转换为short)
	 * @param @param value
	 * @param @return 设定文件
	 * @return double 返回类型
	 * @throws
	 */
	public static short ToShort(Object value) {
		short result = 0;
		try {
			result = Short.parseShort(ToString(value));
		} catch (NumberFormatException ex) {

		}
		return result;
	}

	/**
	 * 
	 *
	 * @Title: ToInteger
	 * @Description: TODO(将Object类型转换为Integer)
	 * @param @param value
	 * @param @return 设定文件
	 * @return double 返回类型
	 * @throws
	 */
	public static int ToInteger(Object value) {
		int result = 0;
		try {
			result = Integer.parseInt(ToString(value));
		} catch (NumberFormatException ex) {

		}
		return result;
	}

	// //跨站攻击 漏洞修复
	public static String ToIntegerE(Object value) {
		String retResult = null;
		int result = 0;
		try {
			result = Integer.parseInt(ToString(value));
			retResult = String.valueOf(result);
		} catch (NumberFormatException ex) {

		}
		return retResult;
	}

	/**
	 * 
	 *
	 * @Title: StrtoIntDef
	 * @Description: TODO(将字符串转换为整形 如果出现异常以默认值取代)
	 * @param @param sValue 字符串
	 * @param @param iDefault 默认
	 * @param @return 设定文件
	 * @return Integer 返回类型
	 * @throws
	 */
	public static Integer StrtoIntDef(String val, int def) {

		int result = def;
		try {
			result = Integer.parseInt(val);
		} catch (NumberFormatException ex) {

			result = def;
		}
		return result;
	}

	public static void WriteShort(DataOutputStream dos, Object val) {
		String sValue = ToString(val);

		byte[] b = sValue.getBytes();

		try {
			dos.write(b, 0, 2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);

		// WriteShort(dos, "");
		dos.writeShort(12);

		byte cmdData[] = bos.toByteArray();
		bos.close();

		System.out.println(new String(cmdData));
	}

	/**
	 * 
	 *
	 * @Title: IsEmpty
	 * @Description: TODO(判断一个object是否为空或空字符串)
	 * @param @param aValue
	 * @param @return 设定文件
	 * @return bool 返回类型
	 * @throws
	 */
	public static Boolean IsEmpty(Object val) {
		if (val == null) {
			return true;
		}
		return "".equals(val.toString().trim());
	}

	/**
	 * 保留小数点
	 */
	public static String saveDouble(Object value, String num) {
		String backValue = null;
		if (!IsEmpty(value)) {
			try {
				Double d = ToDouble(value);
				java.text.DecimalFormat df = new java.text.DecimalFormat(num);
				backValue = df.format(d);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return backValue;
	}

	public static String transferMonth(int month) {
		String transMonth = "0";

		if (month < 10) {
			transMonth = "0" + String.valueOf(month);
		} else {
			transMonth = String.valueOf(month);
		}

		return transMonth;
	}

	public static String getSign(Map<String, Object> parammap, String key) {
		String sign = "";
		try {
			List<String> list = new ArrayList<String>();
			for (Map.Entry<String, Object> entry : parammap.entrySet()) {
				list.add(entry.getKey());
			}
			Collections.sort(list);// 升序

			String param = "";
			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					param += list.get(i) + "=" + parammap.get(list.get(i));
				} else {
					param += "&" + list.get(i) + "=" + parammap.get(list.get(i));
				}
			}
			sign = MD5.encode(MD5.encode(param, "utf-8") + key, "utf-8").toUpperCase();
		} catch (Exception e) {
		}
		return sign;
	}
}

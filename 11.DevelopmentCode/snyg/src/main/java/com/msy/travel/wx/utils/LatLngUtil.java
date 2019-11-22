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
 * @Title: LatLngUtil.java 
 * @Package com.wootide.travel.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author WangHuan  
 * @date 2014-4-29 下午06:29:50 
 * @version V1.0   
 */
package com.msy.travel.wx.utils;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * @ClassName: LatLngUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author WangHuan
 * @date 2014-4-29 下午06:29:50
 * @version 1.0
 */
public class LatLngUtil {
	/**
	 * 计算两点之间距离
	 * 
	 * @param _lat1
	 *            - start纬度
	 * @param _lon1
	 *            - start经度
	 * @param _lat2
	 *            - end纬度
	 * @param _lon2
	 *            - end经度
	 * @return km(四舍五入)
	 */
	public static double getDistance(double _lat1, double _lon1, double _lat2,
			double _lon2) {
		double lat1 = (Math.PI / 180) * _lat1;
		double lat2 = (Math.PI / 180) * _lat2;

		double lon1 = (Math.PI / 180) * _lon1;
		double lon2 = (Math.PI / 180) * _lon2;

		// 地球半径
		double R = 6378.1;

		double d = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1)
				* Math.cos(lat2) * Math.cos(lon2 - lon1))
				* R;

		return new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}

	/**
	 * 根据经纬度及半径长度计算范围
	 * 
	 * @param raidus
	 *            单位米 return minLat,minLng,maxLat,maxLng
	 */
	public static double[] getAround(double lat, double lon, int raidus) {

		Double latitude = lat;
		Double longitude = lon;

		Double degree = (24901 * 1609) / 360.0;
		double raidusMile = raidus;

		Double dpmLat = 1 / degree;
		Double radiusLat = dpmLat * raidusMile;
		Double minLat = latitude - radiusLat;
		Double maxLat = latitude + radiusLat;

		Double mpdLng = degree * Math.cos(latitude * (Math.PI / 180));
		Double dpmLng = 1 / mpdLng;
		Double radiusLng = dpmLng * raidusMile;
		Double minLng = longitude - radiusLng;
		Double maxLng = longitude + radiusLng;
		return new double[] { minLat, minLng, maxLat, maxLng };
	}

	/**
	 * 将gps坐标点转换成百度坐标
	 *
	 * @Title: translateGpsPointToBaiduPoint
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param lng
	 * @param @param lat
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String translateGpsPointToBaiduPoint(String lng, String lat) {
		String res = "";
		try {
			String url = "http://api.map.baidu.com/geoconv/v1/?coords=" + lng
					+ "," + lat + "&from=1&to=5&ak=nxcpVTD7kSh6FoPnHZtOGwuL";

			HttpClient httpClient = new HttpClient();
			PostMethod method = new PostMethod(url);
			httpClient.executeMethod(method);
			JSONObject jsonbean = JSONObject.fromObject(method
					.getResponseBodyAsString());
			if (((Integer) jsonbean.get("status")) == 0) {

				res = JSONObject.fromObject(
						jsonbean.getJSONArray("result").get(0)).get("x")
						+ ","
						+ JSONObject.fromObject(
								jsonbean.getJSONArray("result").get(0))
								.get("y");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res = "";
		}
		return res;

	}

	/**
	 * 根据ip地址获取城市
	 *
	 * @Title: getCityFromIp
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param ip
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String getCityByIp(String ip) {
		String res = "";
		try {
			String url = "http://api.map.baidu.com/location/ip?ak=nxcpVTD7kSh6FoPnHZtOGwuL&ip="
					+ ip;

			HttpClient httpClient = new HttpClient();
			PostMethod method = new PostMethod(url);
			httpClient.executeMethod(method);
			JSONObject jsonbean = JSONObject.fromObject(method
					.getResponseBodyAsString());
			if (((Integer) jsonbean.get("status")) == 0) {

				res = JSONObject.fromObject(
						JSONObject.fromObject(jsonbean.get("content")).get(
								"address_detail")).getString("city");

			}

		} catch (Exception e) {
			res = "";
			e.printStackTrace();

		}
		return res;
	}

	/**
	 * 获取远端ip地址
	 *
	 * @Title: getRemortIP
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param request
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String getRemortIP(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		} else {
			return request.getHeader("x-forwarded-for");
		}
	}

}

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
 * @Title: MessageUtil.java 
 * @Package com.wootide.weixin.utils 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author WangHuan  
 * @date 2014-3-28 下午03:43:00 
 * @version V1.0   
 */
package com.msy.travel.wx.utils;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.msy.travel.wx.resp.Article;
import com.msy.travel.wx.resp.ImageMessage;
import com.msy.travel.wx.resp.KFMessage;
import com.msy.travel.wx.resp.MusicMessage;
import com.msy.travel.wx.resp.NewsMessage;
import com.msy.travel.wx.resp.TextMessage;
import com.msy.travel.wx.resp.VideoMessage;
import com.msy.travel.wx.resp.VoiceMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 消息工具类
 * 
 * @author liufeng
 * @date 2013-05-19
 */
public class MessageUtil {

	/**
	 * 返回消息类型：文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 返回消息类型：音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * 返回消息类型：图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	/**
	 * 返回消息类型：图片
	 */
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 返回消息类型：音频
	 */
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 返回消息类型：视频
	 */
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";

	/**
	 * 返回消息类型：小视频
	 */
	public static final String RESP_MESSAGE_TYPE_SHORTVIDEO = "shortvideo";

	/**
	 * 返回消息类型：多客服
	 */
	public static final String RESP_MESSAGE_TYPE_SERVICE = "transfer_customer_service";

	/**
	 * 请求消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 请求消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型：链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * 请求消息类型：音频
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 请求消息类型：推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 请求消息类型：视频
	 */
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";

	/**
	 * 请求消息类型：小视频
	 */
	public static final String REQ_MESSAGE_TYPE_SHORTVIDEO = "shortvideo";

	/**
	 * 事件类型：subscribe(订阅)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型：CLICK(自定义菜单点击事件)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";

	/**
	 * 事件类型：VIEW(自定义菜单点击事件)
	 */
	public static final String EVENT_TYPE_VIEW = "VIEW";

	/**
	 * 事件类型：SCAN(用户已关注时事件)
	 */
	public static final String EVENT_TYPE_SCAN = "SCAN";

	/**
	 * 事件类型：LOCATION(用户上报地理位置)
	 */
	public static final String EVENT_TYPE_LOCATION = "LOCATION";

	/**
	 * 卡券事件
	 * 
	 * @author whn
	 * 
	 */
	public class Card {

		/**
		 * 领用事件
		 */
		public static final String EVENT_CARD_GET = "user_get_card";

		/**
		 * 删除事件
		 */
		public static final String EVENT_CARD_DEL = "user_del_card";

		/**
		 * 核销事件
		 */
		public static final String EVENT_CARD_CONSUME = "user_consume_card";

	}

	/**
	 * 解析微信发来的请求（XML）
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();

		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList)
			map.put(e.getName(), e.getText());

		// 释放资源
		inputStream.close();
		inputStream = null;

		return map;
	}

	/**
	 * 文本消息对象转换成xml
	 * 
	 * @param textMessage
	 *            文本消息对象
	 * @return xml
	 */
	public static String textMessageToXml(TextMessage textMessage) {
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	/**
	 * 图片消息对象转换成xml
	 * 
	 * @param imageMessage
	 *            图片消息对象
	 * @return xml
	 */
	public static String imageMessageToXml(ImageMessage imageMessage) {
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}

	/**
	 * 音乐消息对象转换成xml
	 * 
	 * @param musicMessage
	 *            音乐消息对象
	 * @return xml
	 */
	public static String musicMessageToXml(MusicMessage musicMessage) {
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}

	/**
	 * 音频消息对象转换成xml
	 * 
	 * @param voiceMessage
	 *            音频消息对象
	 * @return xml
	 */
	public static String voiceMessageToXml(VoiceMessage voiceMessage) {
		xstream.alias("xml", voiceMessage.getClass());
		return xstream.toXML(voiceMessage);
	}

	/**
	 * 视频消息对象转换成xml
	 * 
	 * @param videoMessage
	 *            音频消息对象
	 * @return xml
	 */
	public static String videoMessageToXml(VideoMessage videoMessage) {
		xstream.alias("xml", videoMessage.getClass());
		return xstream.toXML(videoMessage);
	}

	/**
	 * 
	 * 客服消息对象转换成xml
	 * 
	 * @Title: KFMessageToXml
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param kfMessage
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String KFMessageToXml(KFMessage kfMessage) {
		xstream.alias("xml", kfMessage.getClass());
		return xstream.toXML(kfMessage);
	}

	/**
	 * 图文消息对象转换成xml
	 * 
	 * @param newsMessage
	 *            图文消息对象
	 * @return xml
	 */
	public static String newsMessageToXml(NewsMessage newsMessage) {
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}

	/**
	 * 扩展xstream，使其支持CDATA块
	 * 
	 * @date 2013-05-19
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		@Override
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@Override
				@SuppressWarnings("unchecked")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				@Override
				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
}

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

import com.alibaba.fastjson.JSONObject;
import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
import org.dom4j.DocumentException;

/**
 * @ClassName: XmlTool
 * @Description: TODO(本类用于类型转换)
 * @author jy
 * @date 2012-2-22 下午01:20:13
 * @version 1.0
 */
public final class XmlJsonTool {
	
    public static String xml2json(String xmlString) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        JSON json = xmlSerializer.read(xmlString);
        return json.toString(1).replaceAll("\\[\\]", "\"\"");//当<![CDATA[]]>，会变成[]，需转换成""
    }
    
    public static String json2xml(String jsonString) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        return xmlSerializer.write(JSONSerializer.toJSON(jsonString));
    }

	
	public static void main(String[] args) throws DocumentException {
		String xmlString = "<xml><ToUserName><![CDATA[gh_ccc30fb1005c]]></ToUserName><FromUserName><![CDATA[o-nW9tyVmuz1kDUTDlBGpXuzgm6g]]></FromUserName><CreateTime>1554802855</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[unsubscribe]]></Event><EventKey><![CDATA[]]></EventKey></xml>";
//		String xmlString = "<xml><ToUserName><![CDATA[gh_4d00ed8d6399]]></ToUserName><NeedReplaceContent>1</NeedReplaceContent></xml>";
		String jsonString = XmlJsonTool.xml2json(xmlString);
		System.out.println(jsonString);
		jsonString = jsonString.replaceAll("\\[\\]", "\"\"");
		System.out.println(jsonString);
		JSONObject object = JSONObject.parseObject(jsonString);
		System.out.println(object.getString("ToUserName"));
}
}

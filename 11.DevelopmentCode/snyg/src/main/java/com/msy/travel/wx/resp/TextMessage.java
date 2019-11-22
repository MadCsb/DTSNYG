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
* @Title: TextMessage.java 
* @Package com.wootide.weixin.resp 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WangHuan  
* @date 2014-3-28 下午03:03:16 
* @version V1.0   
*/
package com.msy.travel.wx.resp;

/** 
 * 文本消息 
 *  
 */
public class TextMessage extends BaseMessage
{
    // 回复的消息内容  
    private String Content;

    public String getContent()
    {
        return Content;
    }

    public void setContent(String content)
    {
        Content = content;
    }
}

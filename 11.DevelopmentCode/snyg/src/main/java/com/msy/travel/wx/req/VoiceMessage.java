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
* @Title: VoiceMessage.java 
* @Package com.wootide.weixin.req 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WangHuan  
* @date 2014-3-28 下午02:58:33 
* @version V1.0   
*/
package com.msy.travel.wx.req;

/** 
 * 音频消息 
 *  
 */
public class VoiceMessage extends BaseMessage
{
    // 媒体ID  
    private String MediaId;

    // 语音格式  
    private String Format;

    public String getMediaId()
    {
        return MediaId;
    }

    public void setMediaId(String mediaId)
    {
        MediaId = mediaId;
    }

    public String getFormat()
    {
        return Format;
    }

    public void setFormat(String format)
    {
        Format = format;
    }
}
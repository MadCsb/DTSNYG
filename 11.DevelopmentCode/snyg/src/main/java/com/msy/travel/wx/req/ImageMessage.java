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
* @Title: ImageMessage.java 
* @Package com.wootide.weixin.req 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WangHuan  
* @date 2014-3-28 下午02:57:43 
* @version V1.0   
*/
package com.msy.travel.wx.req;

/** 
 * 图片消息 
 *  
 */
public class ImageMessage extends BaseMessage
{
    // 图片链接  
    private String PicUrl;

    public String getPicUrl()
    {
        return PicUrl;
    }

    public void setPicUrl(String picUrl)
    {
        PicUrl = picUrl;
    }
}

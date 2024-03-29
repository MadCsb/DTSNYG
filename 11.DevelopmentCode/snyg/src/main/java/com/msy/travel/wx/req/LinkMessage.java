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
* @Title: LinkMessage.java 
* @Package com.wootide.weixin.req 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WangHuan  
* @date 2014-3-28 下午02:58:14 
* @version V1.0   
*/
package com.msy.travel.wx.req;

/** 
 * 链接消息 
 */
public class LinkMessage extends BaseMessage
{
    // 消息标题  
    private String Title;

    // 消息描述  
    private String Description;

    // 消息链接  
    private String Url;

    public String getTitle()
    {
        return Title;
    }

    public void setTitle(String title)
    {
        Title = title;
    }

    public String getDescription()
    {
        return Description;
    }

    public void setDescription(String description)
    {
        Description = description;
    }

    public String getUrl()
    {
        return Url;
    }

    public void setUrl(String url)
    {
        Url = url;
    }
}

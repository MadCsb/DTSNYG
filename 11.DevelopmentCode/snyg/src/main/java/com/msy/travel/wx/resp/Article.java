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
* @Title: Article.java 
* @Package com.wootide.weixin.resp 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WangHuan  
* @date 2014-3-28 下午03:06:35 
* @version V1.0   
*/
package com.msy.travel.wx.resp;

/** 
 * 图文model 
 */
public class Article
{
    // 图文消息名称  
    private String Title;

    // 图文消息描述  
    private String Description;

    // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致  
    private String PicUrl;

    // 点击图文消息跳转链接  
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
        return null == Description ? "" : Description;
    }

    public void setDescription(String description)
    {
        Description = description;
    }

    public String getPicUrl()
    {
        return null == PicUrl ? "" : PicUrl;
    }

    public void setPicUrl(String picUrl)
    {
        PicUrl = picUrl;
    }

    public String getUrl()
    {
        return null == Url ? "" : Url;
    }

    public void setUrl(String url)
    {
        Url = url;
    }

}

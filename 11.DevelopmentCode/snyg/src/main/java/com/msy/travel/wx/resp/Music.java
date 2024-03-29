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
* @Title: Music.java 
* @Package com.wootide.weixin.resp 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WangHuan  
* @date 2014-3-28 下午03:05:19 
* @version V1.0   
*/
package com.msy.travel.wx.resp;

/** 
 * 音乐model 
 *  
 */
public class Music
{
    // 音乐名称  
    private String Title;

    // 音乐描述  
    private String Description;

    // 音乐链接  
    private String MusicUrl;

    // 高质量音乐链接，WIFI环境优先使用该链接播放音乐  
    private String HQMusicUrl;

    //缩略图的媒体ID
    private String ThumbMediaId;

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

    public String getMusicUrl()
    {
        return MusicUrl;
    }

    public void setMusicUrl(String musicUrl)
    {
        MusicUrl = musicUrl;
    }

    public String getHQMusicUrl()
    {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String musicUrl)
    {
        HQMusicUrl = musicUrl;
    }

    public String getThumbMediaId()
    {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId)
    {
        ThumbMediaId = thumbMediaId;
    }

}

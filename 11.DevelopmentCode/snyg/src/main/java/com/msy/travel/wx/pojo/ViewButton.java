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
* @Title: ViewButton.java 
* @Package com.wootide.travel.weixin.pojo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WangHuan  
* @date 2014-4-12 上午09:40:26 
* @version V1.0   
*/
package com.msy.travel.wx.pojo;

/** 
* @ClassName: ViewButton 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author WangHuan 
* @date 2014-4-12 上午09:40:26 
* @version 1.0 
*/
public class ViewButton extends Button
{
    private String type;

    private String url;

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

}

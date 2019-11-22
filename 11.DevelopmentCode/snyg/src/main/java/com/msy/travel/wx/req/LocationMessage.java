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
* @Title: LocationMessage.java 
* @Package com.wootide.weixin.req 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WangHuan  
* @date 2014-3-28 下午02:57:57 
* @version V1.0   
*/
package com.msy.travel.wx.req;

/** 
 * 地理位置消息 
 *  
 */
public class LocationMessage extends BaseMessage
{
    // 地理位置维度  
    private String Location_X;

    // 地理位置经度  
    private String Location_Y;

    // 地图缩放大小  
    private String Scale;

    // 地理位置信息  
    private String Label;

    public String getLocation_X()
    {
        return Location_X;
    }

    public void setLocation_X(String location_X)
    {
        Location_X = location_X;
    }

    public String getLocation_Y()
    {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y)
    {
        Location_Y = location_Y;
    }

    public String getScale()
    {
        return Scale;
    }

    public void setScale(String scale)
    {
        Scale = scale;
    }

    public String getLabel()
    {
        return Label;
    }

    public void setLabel(String label)
    {
        Label = label;
    }
}

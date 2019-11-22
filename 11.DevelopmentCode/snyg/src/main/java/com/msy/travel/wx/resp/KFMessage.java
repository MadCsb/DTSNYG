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
* @Title: KFMessage.java 
* @Package com.wootide.travel.weixin.resp 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WangHuan  
* @date 2014-8-11 上午11:03:32 
* @version V1.0   
*/
package com.msy.travel.wx.resp;

/** 
* @ClassName: KFMessage 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author WangHuan 
* @date 2014-8-11 上午11:03:32 
* @version 1.0 
*/
public class KFMessage extends BaseMessage
{
    // 接收方帐号（收到的OpenID）  
    private String ToUserName;

    // 开发者微信号  
    private String FromUserName;

    // 消息创建时间 （整型）  
    private long CreateTime;

    // 消息类型（text/music/news）  
    private String MsgType;

    @Override
    public String getToUserName()
    {
        return ToUserName;
    }

    @Override
    public void setToUserName(String toUserName)
    {
        ToUserName = toUserName;
    }

    @Override
    public String getFromUserName()
    {
        return FromUserName;
    }

    @Override
    public void setFromUserName(String fromUserName)
    {
        FromUserName = fromUserName;
    }

    @Override
    public long getCreateTime()
    {
        return CreateTime;
    }

    @Override
    public void setCreateTime(long createTime)
    {
        CreateTime = createTime;
    }

    @Override
    public String getMsgType()
    {
        return MsgType;
    }

    @Override
    public void setMsgType(String msgType)
    {
        MsgType = msgType;
    }

}

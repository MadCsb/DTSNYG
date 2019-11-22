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
* @Title: BaseMessage.java 
* @Package com.wootide.weixin.req 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WangHuan  
* @date 2014-3-28 下午02:56:38 
* @version V1.0   
*/
package com.msy.travel.wx.req;

/** 
 * 消息基类（普通用户 -> 公众帐号） 
 */
public class BaseMessage
{
    // 开发者微信号  
    private String ToUserName;

    // 发送方帐号（一个OpenID）  
    private String FromUserName;

    // 消息创建时间 （整型）  
    private long CreateTime;

    // 消息类型（text/image/location/link）  
    private String MsgType;

    // 消息id，64位整型  
    private long MsgId;

    public String getToUserName()
    {
        return ToUserName;
    }

    public void setToUserName(String toUserName)
    {
        ToUserName = toUserName;
    }

    public String getFromUserName()
    {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName)
    {
        FromUserName = fromUserName;
    }

    public long getCreateTime()
    {
        return CreateTime;
    }

    public void setCreateTime(long createTime)
    {
        CreateTime = createTime;
    }

    public String getMsgType()
    {
        return MsgType;
    }

    public void setMsgType(String msgType)
    {
        MsgType = msgType;
    }

    public long getMsgId()
    {
        return MsgId;
    }

    public void setMsgId(long msgId)
    {
        MsgId = msgId;
    }
}

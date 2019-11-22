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
* @Title: Button.java 
* @Package com.wootide.weixin.pojo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WangHuan  
* @date 2014-4-1 下午01:36:57 
* @version V1.0   
*/
package com.msy.travel.wx.pojo;

/** 
 * 按钮的基类 
 *  
 */
public class Button
{

    public static final String BUTTON_TYPE_CLICK = "click";

    public static final String BUTTON_TYPE_VIEW = "view";

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

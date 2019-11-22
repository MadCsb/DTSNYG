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
* @Title: ComplexButton.java 
* @Package com.wootide.weixin.pojo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WangHuan  
* @date 2014-4-1 下午01:37:38 
* @version V1.0   
*/
package com.msy.travel.wx.pojo;

import java.util.List;

/** 
 * 复杂按钮（父按钮） 
 *  
 */
public class ComplexButton extends Button
{
    private List<Button> sub_button;

    public List<Button> getSub_button()
    {
        return sub_button;
    }

    public void setSub_button(List<Button> sub_button)
    {
        this.sub_button = sub_button;
    }

}

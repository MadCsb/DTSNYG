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
* @Title: NewsMessage.java 
* @Package com.wootide.weixin.resp 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WangHuan  
* @date 2014-3-28 下午03:06:00 
* @version V1.0   
*/
package com.msy.travel.wx.resp;

import java.util.List;

/** 
 * 文本消息 
 */
public class NewsMessage extends BaseMessage
{
    // 图文消息个数，限制为10条以内  
    private int ArticleCount;

    // 多条图文消息信息，默认第一个item为大图  
    private List<Article> Articles;

    public int getArticleCount()
    {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount)
    {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles()
    {
        return Articles;
    }

    public void setArticles(List<Article> articles)
    {
        Articles = articles;
    }
}
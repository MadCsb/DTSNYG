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
 * @Title: ExportSupport.java 
 * @Package com.wootide.moduleproject.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Administrator  
 * @date 2012-2-14 上午09:21:58 
 * @version V1.0   
 */
package com.msy.travel.common;

import java.util.Collection;

/**
 * @ClassName: ExportSupport
 * @Description: TODO(导出文件的父级类)
 * @author jy
 * @date 2012-2-14 上午09:21:58
 * @version 1.0
 */
public abstract class ExportSupport<T> {
	/**
	 * 表格的标题
	 */
	protected String fileTitle;

	/**
	 * 导出的文件名称
	 */
	protected String exportFileName;

	/**
	 * 字段及字段标题，以“{字段名1:标题名1},{字段2:标题2}”形式保存
	 */
	protected String[] headers;

	/**
	 * 需要导出的数据集LIST<字段对象> 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
	 * javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 */
	protected Collection<T> dataset;

	/**
	 * 
	 *
	 * @Title: export
	 * @Description: TODO(导出文件)
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */

	@SuppressWarnings("unchecked")
	protected boolean export() {
		if ("".equals(exportFileName.trim())) {
			return false;
		}
		// 判断文件及路径是否存在
		return true;
	}

	/**
	 * @param exportFileName
	 *            the exportFileName to set
	 */
	public void setExportFileName(String exportFileName) {
		this.exportFileName = exportFileName;
	}

	/**
	 * @return exportFileName
	 */
	public String getExportFileName() {
		return exportFileName;
	}

	/**
	 * @param fileTitle
	 *            the fileTitle to set
	 */
	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}

	/**
	 * @return fileTitle
	 */
	public String getFileTitle() {
		return fileTitle;
	}

	/**
	 * @param headers
	 *            the headers to set
	 */
	public void setHeaders(String[] headers) {
		this.headers = headers;
	}

	/**
	 * @return headers
	 */
	public String[] getHeaders() {
		return headers;
	}

	/**
	 * @param dataset
	 *            the dataset to set
	 */
	public void setDataset(Collection<T> dataset) {
		this.dataset = dataset;
	}

	/**
	 * @return dataset
	 */
	public Collection<T> getDataset() {
		return dataset;
	}
}

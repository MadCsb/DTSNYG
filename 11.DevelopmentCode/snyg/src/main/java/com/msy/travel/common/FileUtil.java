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
 * @Title: FileUtil.java 
 * @Package com.wootide.travel.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author WangHuan  
 * @date 2014-5-30 下午02:49:10 
 * @version V1.0   
 */
package com.msy.travel.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @ClassName: FileUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author WangHuan
 * @date 2014-5-30 下午02:49:10
 * @version 1.0
 */
public class FileUtil {

	// private static final Log log = LogFactory.getLog(TextMsgHandler.class);

	/**
	 * 写文件
	 * 
	 * @param path
	 * @param content
	 * @return
	 */
	public static String writeFile(String path, String content) {

		// 创建文件夹
		int lastIndex = path.lastIndexOf(File.separator);
		String subFolder = path.substring(0, lastIndex);
		File folder = new File(subFolder);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		File file = new File(path);
		if (file.exists()) {
			delete(path);
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				// log.error(e, e);
			}
		}
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path)), "utf-8"));
			out.write(content);
			out.flush(); // 把缓存区内容压入文件
			out.close(); // 最后记得关闭文件
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// log.error(e, e);
		}
		return "";
	}

	/**
	 * 读取文件内容
	 * 
	 * @param path
	 * @return
	 */
	public static String readFile(String path) {
		String content = "";
		StringBuffer bos = null;
		try {
			File file = new File(path);
			if (file.exists()) {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8")); // 用这个方法读取，并指定编码

				bos = new StringBuffer();

				String line = null;
				while ((line = br.readLine()) != null) {
					bos.append(line);
				}
				br.close();
				content = bos.toString();
			}

		} catch (Exception e) {
			content = "";
			e.printStackTrace();
		}
		return content;
	}

	/**
	 * 删除文件，可以是单个文件或文件夹
	 * 
	 * @param fileName
	 *            待删除的文件名
	 * @return 文件删除成功返回true,否则返回false
	 */
	public static boolean delete(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			// System.out.println("删除文件失败："+fileName+"文件不存在");
			return false;
		} else {
			if (file.isFile()) {
				return deleteFile(fileName);
			} else {
				return deleteDirectory(fileName);
			}
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param fileName
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true,否则返回false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
			// System.out.println("删除单个文件"+fileName+"成功！");
		}
		return true;
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param dir
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true,否则返回false
	 */
	public static boolean deleteDirectory(String dir) {
		// 如果dir不以文件分隔符结尾，自动添加文件分隔符
		if (!dir.endsWith(File.separator)) {
			dir = dir + File.separator;
		}
		File dirFile = new File(dir);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			// System.out.println("删除目录失败"+dir+"目录不存在！");
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		if (files == null) {

			return true;
		}
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
			// 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
		}

		if (!flag) {
			// System.out.println("删除目录失败");
			return false;
		}

		// 删除当前目录
		if (dirFile.delete()) {
			// System.out.println("删除目录"+dir+"成功！");
			return true;
		} else {
			// System.out.println("删除目录"+dir+"失败！");
			return false;
		}
	}

	public static String getFileexpandedName(String contentType) {
		String fileEndWitsh = "";
		if ("image/jpeg".equals(contentType))
			fileEndWitsh = ".jpg";
		else if ("image/png".equals(contentType))
			fileEndWitsh = ".png";
		else if ("audio/mpeg".equals(contentType))
			fileEndWitsh = ".mp3";
		else if ("audio/amr".equals(contentType))
			fileEndWitsh = ".amr";
		else if ("video/mp4".equals(contentType))
			fileEndWitsh = ".mp4";
		else if ("video/mpeg4".equals(contentType))
			fileEndWitsh = ".mp4";
		return fileEndWitsh;
	}

	public static void main(String[] args) {
		// String fileName = "g:/temp/xwz.txt";
		// DeleteFileUtil.deleteFile(fileName);
		String fileDir = "G:/temp/temp0/temp1";
		// DeleteFileUtil.deleteDirectory(fileDir);
		delete(fileDir);

	}
}

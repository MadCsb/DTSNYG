package com.msy.travel.common;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileCom {

	/**
	 * 上传文件(指定文件夹)
	 * 
	 * @param multipartFile
	 * @param request
	 * @param folderName
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static final String uploadFileByFolder(MultipartFile multipartFile,
			HttpServletRequest request, String folderName, String uploadPicUrl)
			throws IllegalStateException, IOException {

		String realName = "";
		if (multipartFile != null && multipartFile.getSize() > 0) {
			String dictory = uploadPicUrl + folderName;
			File dictoryFile = new File(dictory);
			if (!dictoryFile.isDirectory()) {
				dictoryFile.mkdirs();
			}
			realName = PrimaryKeyUtil.generateKey()
					+ multipartFile.getOriginalFilename().substring(
							multipartFile.getOriginalFilename()
									.lastIndexOf("."));
			File target = new File(dictory, realName);
			multipartFile.transferTo(target);
		}

		return realName;
	}

	/**
	 * 上传文件(指定文件夹)
	 * 
	 * @param multipartFile
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static final UploadFilePojo getFileByFolder(
			MultipartFile multipartFile, HttpServletRequest request,
			String folderName, String uploadPicUrl)
			throws IllegalStateException, IOException {
		UploadFilePojo pojo = new UploadFilePojo();
		String realName = "";

		if (multipartFile != null && multipartFile.getSize() > 0) {
			String dictory = uploadPicUrl + folderName;
			File dictoryFile = new File(dictory);
			if (!dictoryFile.isDirectory()) {
				dictoryFile.mkdirs();
			}
			realName = PrimaryKeyUtil.generateKey()
					+ multipartFile.getOriginalFilename().substring(
							multipartFile.getOriginalFilename()
									.lastIndexOf("."));
			File target = new File(dictory, realName);
			multipartFile.transferTo(target);

			// 赋值
			pojo.setRealName(realName);
			pojo.setFile(target);
		}

		return pojo;
	}
}

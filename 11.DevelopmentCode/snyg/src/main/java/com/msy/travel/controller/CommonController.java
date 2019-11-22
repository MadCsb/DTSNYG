package com.msy.travel.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.msy.travel.common.Base64ToPic;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.Result;
import com.msy.travel.common.WTConvert;
import com.msy.travel.common.config.ConfigParameter;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/common")
public class CommonController extends BaseController {

	public static final Log log = LogFactory.getLog(CommonController.class);

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	/**
	 * CKEDITOR控件图片上传
	 * 
	 * @param request
	 * @param response
	 * @param type
	 * @param upload
	 */
	@RequestMapping(value = "/ckeditorUpload")
	public void ckeditorUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "type") String type, @RequestParam(value = "upload") MultipartFile upload) {
		try {
			Date date = new Date();

			// 保存路径
			String path = configParameter.getUploadPicUrl();
			String picUrl = "";
			if (path == null || "".equals(path)) {
				path = request.getSession().getServletContext().getRealPath("/ckImage");
			} else {
				path = path + "/ckImage";
				picUrl = configParameter.getPicUrl();
			}

			// 日期文件夹
			String datePath = new SimpleDateFormat("yyyyMM").format(date);
			File fileFolder = new File(path, datePath);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdirs();
			}

			if ("Images".equals(type)) {

				if (upload != null) {
					String uploadFileName = upload.getOriginalFilename();
					String suffix = uploadFileName.substring(uploadFileName.lastIndexOf("."));

					response.setContentType("text/html; charset=UTF-8");
					response.setHeader("Cache-Control", "no-cache");
					PrintWriter out = response.getWriter();
					StringBuilder buffer = new StringBuilder();
					buffer.append("<script type=\"text/javascript\">");

					// CKEditorFuncNum是回调时显示的位置，这个参数必须有
					String callback = request.getParameter("CKEditorFuncNum");

					if (".jpg".equals(suffix.toLowerCase()) || ".jpeg".equals(suffix.toLowerCase()) || ".gif".equals(suffix.toLowerCase()) || ".bmp".equals(suffix.toLowerCase())
							|| ".png".equals(suffix.toLowerCase())) {

						String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date) + suffix;
						File target = new File(fileFolder, newFileName);

						upload.transferTo(target);

						buffer.append("alert('上传成功！');");
						buffer.append("window.parent.CKEDITOR.tools.callFunction(");
						buffer.append(callback + ",");
						// buffer.append("'" + request.getScheme() + "://" +
						// request.getServerName() + ":" +
						// request.getServerPort() + request.getContextPath() +
						// "/ckImage/" + datePath + "/"
						// + newFileName + "',''" + ")");

						buffer.append("'" + configParameter.getPreviewUrl() + picUrl + "/ckImage/" + datePath + "/" + newFileName + "',''" + ")");

					} else {
						buffer.append("alert('服务器禁止上传此类文件！');");
						buffer.append("window.parent.CKEDITOR.tools.callFunction(");
						buffer.append(callback + ",");
						buffer.append("'',''" + ")");

					}
					buffer.append("</script>");

					out.write(buffer.toString());
					out.flush();
					out.close();
				}
			}

		} catch (Exception e) {
			log.error("upload photo failed: ", e);
		}

	}

	/**
	 * 多图片上传
	 * 
	 * @author Gengb
	 * @date 2018年11月22日 上午9:48:24
	 * @param request
	 * @param response
	 * @param type
	 * @param upload
	 * @return void
	 */
	@RequestMapping(value = "/ckeditorUploadMulti")
	public void ckeditorUploadMulti(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "type") String type, @RequestParam(value = "upload") MultipartFile upload) {
		try {
			Date date = new Date();

			// 保存路径
			String path = configParameter.getUploadPicUrl();
			String picUrl = "";
			if (path == null || "".equals(path)) {
				path = request.getSession().getServletContext().getRealPath("/ckImage");
			} else {
				path = path + "/ckImage";
				picUrl = configParameter.getPicUrl();
			}

			// 日期文件夹
			String datePath = new SimpleDateFormat("yyyyMM").format(date);
			File fileFolder = new File(path, datePath);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdirs();
			}

			if ("Images".equals(type)) {

				if (upload != null) {
					String uploadFileName = upload.getOriginalFilename();
					String suffix = uploadFileName.substring(uploadFileName.lastIndexOf("."));

					response.setContentType("text/html; charset=UTF-8");
					response.setHeader("Cache-Control", "no-cache");
					PrintWriter out = response.getWriter();

					StringBuilder buffer = new StringBuilder();

					if (".jpg".equals(suffix.toLowerCase()) || ".jpeg".equals(suffix.toLowerCase()) || ".gif".equals(suffix.toLowerCase()) || ".bmp".equals(suffix.toLowerCase())
							|| ".png".equals(suffix.toLowerCase())) {

						int no = new Random().nextInt(100);

						String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date) + "-" + no + suffix;
						File target = new File(fileFolder, newFileName);

						upload.transferTo(target);
						buffer.append("{\"result\":200,\"msg\":\"上传成功\",\"imgurl\":\"" + configParameter.getPreviewUrl() + picUrl + "/ckImage/" + datePath + "/" + newFileName + "\"}");

					} else {
						buffer.append("{\"result\":400,\"msg\":\"服务器禁止上传此类文件\"}");
					}

					out.write(buffer.toString());
					out.flush();
					out.close();
				}
			}

		} catch (Exception e) {
			log.error("upload photo failed: ", e);
		}

	}

	/***
	 * @Author zhaogang
	 * @Description 多图片上传(Base64转码)
	 * @Date 16:22 2019/6/3
	 * @Param [uploadPicList, request, response]
	 * @return void
	 **/
	@RequestMapping(value = "/testUploadPics")
	public void testUploadPics(String[] uploadPicList, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<String> picUrl = new ArrayList<>();
			String path = configParameter.getWebsite() + configParameter.getPicUrl() + "/";
			for (String pic : uploadPicList) {
				if (null != pic && !"".equals(pic)) {
					String ext = Base64ToPic.SubStringBetween(pic, "data:image/", ";");// 图片后缀
					if ("jpeg".equalsIgnoreCase(ext)) {
						ext = "jpg";
					}
					String fileName = System.currentTimeMillis() + "";
					if (Base64ToPic.GenerateImage(pic, configParameter.getUploadPicUrl(), fileName)) {
						picUrl.add(path + WTConvert.ToString(fileName + "." + ext));
					}
				}
			}
			System.out.println(picUrl);
		} catch (Exception e) {
			log.error(e, e);
		}

		try {
			response.getWriter().write(JSONObject.fromObject(result).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

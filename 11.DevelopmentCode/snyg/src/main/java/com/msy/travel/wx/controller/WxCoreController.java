package com.msy.travel.wx.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msy.travel.common.BaseController;
import com.msy.travel.wx.service.CoreService;
import com.msy.travel.wx.utils.SignUtil;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wx")
public class WxCoreController extends BaseController {
	public static final Log log = LogFactory.getLog(WxCoreController.class);

	@Resource(name = "coreService")
	private CoreService coreService;

	@RequestMapping(value = "/core", method = RequestMethod.GET)
	public void wxMsgGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 微信加密签名
			String signature = request.getParameter("signature");
			// 时间戳
			String timestamp = request.getParameter("timestamp");
			// 随机数
			String nonce = request.getParameter("nonce");
			// 随机字符串
			String echostr = request.getParameter("echostr");

			PrintWriter out = response.getWriter();
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				log.error(echostr);
				out.print(echostr);
			} else {
				log.error("前面不通过");
			}
			out.close();
			out = null;

		} catch (Exception e) {
			log.error("微信接入错误", e);
		}

	}

	@RequestMapping(value = "/core", method = RequestMethod.POST)
	public void wxMsgPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			log.info("receive msg......");

			// 调用核心业务类接收消息、处理消息
			String respMessage = coreService.processRequest(request);

			// 响应消息
			PrintWriter out = response.getWriter();
			out.print(respMessage);
			out.close();

		} catch (Exception e) {
			log.error("微信接收消息错误", e);
		}

	}

}

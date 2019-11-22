package com.msy.travel.wx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.msy.travel.common.BaseController;
import com.msy.travel.common.Consts;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Article;
import com.msy.travel.service.IArticleService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wx")
public class WxController extends BaseController {
	public static final Log log = LogFactory.getLog(WxController.class);

	@Resource(name = "articleServiceImpl")
	private IArticleService articleService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@RequestMapping(params = "method=showArticle")
	public String toShareArticle(Article article, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		Article objArticle = null;
		try {
			objArticle = articleService.displayArticle(article);
			// view = new ModelAndView("forward:/article/" +
			// objArticle.getFileName());

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		// return view;
		return "forward:" + configParameter.getPicUrl() + "/" + Consts.WX_ARTICLE_FOLDER_NAME + "/" + objArticle.getFileName();
	}

}

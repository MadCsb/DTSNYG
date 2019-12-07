package com.msy.travel.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msy.travel.common.BaseController;
import com.msy.travel.common.EntityPage;
import com.msy.travel.pojo.Article;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.service.IArticleService;

/**
 * 微信首页
 * 
 * @author Gengb
 * @date 2018年7月19日 上午10:57:02
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/webArticle")
public class WebArticleController extends BaseController {
	public static final Log log = LogFactory.getLog(WebArticleController.class);

	@Resource(name = "articleServiceImpl")
	private IArticleService articleService;

	@RequestMapping(params = "method=getArticleWeb")
	public void getArticleWeb(Article article, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (article == null) {
				article = new Article();
			}
			if (article.getEntityPage() == null) {
				article.setEntityPage(new EntityPage());
			}

			article.setSpId(Destsp.currentSpId);
			article.setDelFlag("0");
			article.getEntityPage().setSortField("t.F_PUBLISHDATE");
			article.getEntityPage().setSortOrder("DESC");

			List<Article> articleList = articleService.queryArticleList(article);
			JSONArray jsonArray = JSONArray.fromObject(articleList);
			response.getWriter().print(jsonArray.toString());

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

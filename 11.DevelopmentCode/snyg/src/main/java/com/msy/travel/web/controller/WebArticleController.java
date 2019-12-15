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
import org.springframework.web.servlet.ModelAndView;

import com.msy.travel.common.BaseController;
import com.msy.travel.common.EntityPage;
import com.msy.travel.pojo.Article;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.Pubmap;
import com.msy.travel.service.IArticleService;
import com.msy.travel.service.IPubmapService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/webArticle")
public class WebArticleController extends BaseController {
	public static final Log log = LogFactory.getLog(WebArticleController.class);

	@Resource(name = "articleServiceImpl")
	private IArticleService articleService;

	@Resource(name = "pubmapServiceImpl")
	private IPubmapService pubmapService;

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

	/**
	 * 文章
	 * 
	 * @author wzd
	 * @date 2019年12月15日 下午5:03:14
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=toArticleList")
	public ModelAndView toArticleList(Article article, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (article.getType() != null && !"".equals(article.getType())) {
				String articleId = article.getArticleId();
				article.setArticleId("");
				List<Article> articleList = articleService.queryArticleList(article);

				List<Pubmap> artTypeList = this.pubmapService.getPubmapListByType("ARTTYPE");

				article.setArticleId(articleId);
				view = new ModelAndView("web/article/queryArticleList");
				view.addObject("articleList", articleList);
				view.addObject("artTypeList", artTypeList);
				view.addObject("article", article);
			}

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}
}

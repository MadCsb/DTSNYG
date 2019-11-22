package com.msy.travel.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.Consts;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.SysConsts;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Article;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.Pubmap;
import com.msy.travel.pojo.RsPic;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IArticleService;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IPubmapService;
import com.msy.travel.service.IRsPicService;
import com.msy.travel.service.IServiceCodeService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/article")
public class ArticleController extends BaseController {
	public static final Log log = LogFactory.getLog(ArticleController.class);

	@Resource(name = "articleServiceImpl")
	private IArticleService articleService;

	@Resource(name = "pubmapServiceImpl")
	private IPubmapService pubmapService;

	@Resource(name = "rsPicServiceImpl")
	private IRsPicService rsPicService;

	@Resource(name = "destspServiceImpl")
	private IDestspService destspService;

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	/**
	 * 跳转到新增页面
	 */
	// @RequiresPermissions({ "addArticle" })
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddArticle(Article article, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;

		try {
			List<Pubmap> artTypeList = this.pubmapService.getPubmapListByType("ARTTYPE");// 文章类型

			view = new ModelAndView("article/addArticle");
			view.addObject("artTypeList", artTypeList);
			view.addObject("rsType", SysConsts.RSTYPE_ARTICLE);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}

		return view;
	}

	/**
	 * 新增Article
	 */
	// @RequiresPermissions({ "addArticle" })
	@RequestMapping(params = "method=add")
	public ModelAndView addArticle(Article article, String[] picIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			User user = this.getLoginUser(request);

			article.setArticleId(PrimaryKeyUtil.generateKey());
			article.setSpId(user.getAccId());
			article.setUserId(user.getUserId());
			article.setUserName(user.getUserName());
			article.setPublishDate(DateTimeUtil.getDateTime19());
			article.setDelFlag("0");

			if (picIds != null && picIds.length > 0) {
				article.setPicUrl(picIds[0]);
			} else {
				article.setPicUrl(null);
			}

			article.setFileName(this.writeFile(article, request, response));
			article.setTitle(article.getTitle().trim());

			articleService.createArticle(article, picIds);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 跳转到修改页面
	 */
	// @RequiresPermissions({ "modifyArticle" })
	@RequestMapping(params = "method=toUpdate")
	public ModelAndView toUpdateArticle(Article article, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Article objArticle = articleService.displayArticle(article);

			List<Pubmap> artTypeList = this.pubmapService.getPubmapListByType("ARTTYPE");// 文章类型

			RsPic rsPic = new RsPic();
			rsPic.setRsId(objArticle.getArticleId());
			rsPic.setRsType(SysConsts.RSTYPE_ARTICLE);
			if (rsPic.getEntityPage() == null) {
				rsPic.setEntityPage(new EntityPage());
			}
			rsPic.getEntityPage().setSortField("t.F_ORDER");
			rsPic.getEntityPage().setSortOrder("ASC");
			List<RsPic> rsPicList = this.rsPicService.queryRsPicList(rsPic);

			view = new ModelAndView("article/updateArticle");
			view.addObject("article", objArticle);
			view.addObject("artTypeList", artTypeList);
			view.addObject("rsType", SysConsts.RSTYPE_ARTICLE);
			view.addObject("rsPicList", rsPicList);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改Article
	 */
	// @RequiresPermissions({ "modifyArticle" })
	@RequestMapping(params = "method=update")
	public ModelAndView updateArticle(Article article, String[] picIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			User user = this.getLoginUser(request);
			article.setSpId(user.getAccId());
			article.setUserId(user.getUserId());
			article.setUserName(user.getUserName());
			article.setPublishDate(DateTimeUtil.getDateTime19());

			if (picIds != null && picIds.length > 0) {
				article.setPicUrl(picIds[0]);
			} else {
				article.setPicUrl(null);
			}

			article.setFileName(this.writeFile(article, request, response));
			article.setTitle(article.getTitle().trim());

			articleService.updateArticle(article, picIds);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除Article
	 */
	// @RequiresPermissions({ "delArticle" })
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteArticle(Article article, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			// articleService.deleteArticle(article);
			article.setDelFlag("1");// 逻辑删除
			this.articleService.setArticleDelFlag(article);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 批量删除
	 */
	// @RequiresPermissions({ "delArticle" })
	@RequestMapping(params = "method=deleteBatch")
	public ModelAndView deleteBatchArticle(Article article, String checkedArticleIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] articleIds = checkedArticleIds.split(",");
		List<String> articleIdList = new ArrayList<String>();
		Collections.addAll(articleIdList, articleIds);
		try {
			/*
			 * article.setArticleIdList(articleIdList);
			 * articleService.deleteBatchArticle(article);
			 */
			for (String id : articleIdList) {
				Article tempArticle = new Article();
				tempArticle.setDelFlag("1");// 逻辑删除
				tempArticle.setArticleId(id);
				this.articleService.setArticleDelFlag(tempArticle);
			}
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 分页查询
	 */
	// @RequiresPermissions({ "queryArticle" })
	@RequestMapping(params = "method=query")
	public ModelAndView queryArticleList(Article article, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (article.getEntityPage() == null) {
				article.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);

			User user = this.getLoginUser(request);
			article.setSpId(user.getAccId());
			article.setDelFlag("0");
			article.getEntityPage().setSortField("t.F_PUBLISHDATE");
			article.getEntityPage().setSortOrder("DESC");

			// 设置分页
			PageHelper.startPage(super.getPageNum(article.getEntityPage()), super.getPageSize(article.getEntityPage()));
			List<Article> articleList = articleService.queryArticleList(article);
			PageInfo<Article> pageInfo = new PageInfo<Article>(articleList);

			List<Pubmap> artTypeList = this.pubmapService.getPubmapListByType("ARTTYPE");// 文章类型

			view = new ModelAndView("article/queryArticle");
			view.addObject("articleList", articleList);
			view.addObject("entityPage", article.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("article", article);
			view.addObject("artTypeList", artTypeList);
			view.addObject("domainName", configParameter.getPreviewUrl());
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 导出excel
	 */
	@RequestMapping(params = "method=export")
	public void exportArticle(Article article, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			path = path + File.separator + "export";
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "Article-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (article.getEntityPage() == null) {
				article.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(article.getEntityPage()), super.getPageSize(article.getEntityPage()));
			List<Article> exportlist = articleService.queryArticleList(article);

			PoiWriteExcel<Article> pwe = new PoiWriteExcel<Article>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(article.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	private String writeFile(Article article, HttpServletRequest request, HttpServletResponse response) {
		String name = "article" + article.getArticleId() + ".html";
		String path = configParameter.getUploadPicUrl() + Consts.WX_ARTICLE_FOLDER_NAME;

		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		path = path + File.separator + name;
		File file = new File(path);
		if (file.exists()) {
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path)), "utf-8"));

			// out.write("<%@ page language=\"java\" import=\"java.util.*\" pageEncoding=\"UTF-8\"%>");
			out.write("<!DOCTYPE HTML>");
			out.write("<html>");
			out.write("<head>");
			out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
			out.write("<meta name=\"baidu-site-verification\" content=\"XFQucHwK8v\" />");
			out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0;\"/>");
			out.write("<meta name=\"format-detection\" content=\"telephone=no\" />");
			out.write("<meta name=\"keywords\" content=\"马上游\" />");
			out.write("<meta name=\"description\" content=\"马上游最好玩的旅游在这里\" />");
			out.write("<title>");
			out.write(article.getTitle());
			out.write("</title>");
			out.write("<style type=\"text/css\">");
			out.write("<!--");
			out.write("body{ -webkit-text-size-adjust:none; font:14px \"Helvetica Neue\", HelveticaNeue, \"Helvetica-Neue\", Helvetica, \"微软雅黑\"; color:#000000;}");
			out.write("body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td,aside,article,figcaption,figure,header,hgroup,menu,nav,section{ margin:0; padding:0;}");
			out.write("body{min-width:320px; width:100%;}");
			out.write("img{ border:none;}");
			out.write(".headdiv{height:50px; background:#00a0e9; margin:0; }");
			out.write(".headdiv h2{padding:4px 5px 3px 0;font-size:1.6em;line-height:50px;overflow:hidden;text-align:center;color:#FFF;padding:0px 50px;}");
			out.write(".divlist{margin:10px auto;padding:0px 10px;}");
			out.write(".divlist h2{color:#F60;}");
			out.write(".tablist{margin:10px auto;border:1px solid #ccc;font-size:14px;border-collapse:collapse;background:#f9f9f9;padding:5px 15px;color:#f90;line-height:28px;}");
			out.write(".tablistbt{text-align:left;font-size:1.0em;font-weight:bold;color:#666;}");
			out.write(".tablist b{color:#C06;padding-left:20px;}");
			out.write(".tablist p{color:#000000;}");
			out.write(".tablist img{width:100%;}");
			out.write(".tablist span{color:#000000;}");
			out.write(".ft-tool{ position:relative; height:40px; padding:0 10px; background:#efefef; border-top:1px solid #d7d7d7; line-height:40px;}");
			out.write(".ft-tool a{ display:inline-block; padding-left:24px; color:#666; font-size:1.5em; height:100%;line-height:40px!important;text-decoration:none;}");
			out.write(".ft-tool .go-top{ float:right;background-size:20px;}");
			out.write("-->");
			out.write("</style></head>");
			out.write("<body>");
			// out.write("<jsp:include page=\"/wxpages/article/incArticle.jsp\"></jsp:include>");
			out.write("<script type=\"text/javascript\">");
			if (article.getProLink() != null && !"".equals(article.getProLink())) {
				out.write("var browser={ie6:function(){return((window.XMLHttpRequest==undefined)&&(ActiveXObject!=undefined))},getWindow:function(){var myHeight=0;var myWidth=0;if(typeof(window.innerWidth)=='number'){myHeight=window.innerHeight;myWidth=window.innerWidth}else if(document.documentElement){myHeight=document.documentElement.clientHeight;myWidth=document.documentElement.clientWidth}else if(document.body){myHeight=document.body.clientHeight;myWidth=document.body.clientWidth}return{'height':myHeight,'width':myWidth}},getScroll:function(){var myHeight=0;var myWidth=0;if(typeof(window.pageYOffset)=='number'){myHeight=window.pageYOffset;myWidth=window.pageXOffset}else if(document.documentElement){myHeight=document.documentElement.scrollTop;myWidth=document.documentElement.scrollLeft}else if(document.body){myHeight=document.body.scrollTop;myWidth=document.body.scrollLeft}return{'height':myHeight,'width':myWidth}},getDocWidth:function(D){if(!D)var D=document;return Math.max(Math.max(D.body.scrollWidth,D.documentElement.scrollWidth),Math.max(D.body.offsetWidth,D.documentElement.offsetWidth),Math.max(D.body.clientWidth,D.documentElement.clientWidth))},getDocHeight:function(D){if(!D)var D=document;return Math.max(Math.max(D.body.scrollHeight,D.documentElement.scrollHeight),Math.max(D.body.offsetHeight,D.documentElement.offsetHeight),Math.max(D.body.clientHeight,D.documentElement.clientHeight))}};var dom={ID:function(id){var type=typeof(id);if(type=='object')return id;if(type=='string')return document.getElementById(id);return null},insertHtml:function(html){var frag=document.createDocumentFragment();var div=document.createElement(\"div\");div.innerHTML=html;for(var i=0,ii=div.childNodes.length;i<ii;i++){frag.appendChild(div.childNodes[i])}document.body.insertBefore(frag,document.body.firstChild)}};var myEvent={add:function(element,type,handler){var ele=dom.ID(element);if(!ele)return;if(ele.addEventListener)ele.addEventListener(type,handler,false);else if(ele.attachEvent)ele.attachEvent(\"on\"+type,handler);else ele[\"on\"+type]=handler},remove:function(element,type,handler){var ele=dom.ID(element);if(!ele)return;if(ele.removeEventListener)ele.removeEventListener(type,handler,false);else if(ele.detachEvent)ele.detachEvent(\"on\"+type,handler);else ele[\"on\"+type]=null}};var position={rightCenter:function(id){var id=dom.ID(id);var ie6=browser.ie6();var win=browser.getWindow();var ele={'height':id.clientHeight,'width':id.clientWidth};if(ie6){var scrollBar=browser.getScroll()}else{var scrollBar={'height':0,'width':0};id.style.position='fixed'}ele.top=parseInt((win.height-ele.height)/2+scrollBar.height);id.style.top=ele.top+'px';id.style.right='3px'},floatRightCenter:function(id){position.rightCenter(id);var fun=function(){position.rightCenter(id)};if(browser.ie6()){myEvent.add(window,'scroll',fun);myEvent.add(window,'resize',fun)}else{myEvent.add(window,'resize',fun)}},leftCenter:function(id){var id=dom.ID(id);var ie6=browser.ie6();var win=browser.getWindow();var ele={'height':id.clientHeight,'width':id.clientWidth};if(ie6){var scrollBar=browser.getScroll()}else{var scrollBar={'height':0,'width':0};id.style.position='fixed'}ele.top=parseInt((win.height-ele.height)/2+scrollBar.height);id.style.top=ele.top+'px';id.style.left='3px'},floatLeftCenter:function(id){position.leftCenter(id);var fun=function(){position.leftCenter(id)};if(browser.ie6()){myEvent.add(window,'scroll',fun);myEvent.add(window,'resize',fun)}else{myEvent.add(window,'resize',fun)}}};");
				out.write("function ad_left(){var html; html = '<div id=\"ad_left\" style=\"position:absolute;width:130px;height:35px;z-index:10001\"><a href=\"" + article.getProLink()
						+ "\"><img src=\"" + request.getContextPath()
						+ "/images/gg.png\" width=\"40\" height=\"130\" /></a></div>';dom.insertHtml(html);position.floatLeftCenter('ad_left');}myEvent.add(window,'load',ad_left);");
			}
			out.write("</script>");

			out.write("<div class=\"wrapper\">");
			out.write("<div class=\"divlist\" id=\"\">");
			out.write("<h2>");
			out.write(article.getTitle());
			out.write("</h2>");
			out.write("<div class=\"tablist\">");
			out.write(article.getContext().replaceAll("	", "").replaceAll("\r\n", "").trim());
			out.write("</div>");
			out.write("</div>");
			out.write("<div class=\"ft-tool\"><a href=\"#\" class=\"go-top\">返回顶部</a></div>");
			out.write("</div>");
			out.write("</body></html>");
			out.flush(); // 把缓存区内容压入文件
			out.close(); // 最后记得关闭文件
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}

	/**
	 * 打开文章选择窗口
	 */
	@RequestMapping(params = "method=toBindArticle")
	public ModelAndView toBindArticle(Article article, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (article.getEntityPage() == null) {
				article.setEntityPage(new EntityPage());
			}

			User user = this.getLoginUser(request);
			article.setSpId(user.getAccId());
			article.setDelFlag("0");
			article.getEntityPage().setSortField("t.F_PUBLISHDATE");
			article.getEntityPage().setSortOrder("DESC");

			// 设置分页
			PageHelper.startPage(super.getPageNum(article.getEntityPage()), super.getPageSize(article.getEntityPage()));
			List<Article> articleList = articleService.queryArticleList(article);
			PageInfo<Article> pageInfo = new PageInfo<Article>(articleList);

			List<Pubmap> artTypeList = this.pubmapService.getPubmapListByType("ARTTYPE");// 文章类型

			view = new ModelAndView("article/bindArticle");
			view.addObject("articleList", articleList);
			view.addObject("entityPage", article.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("article", article);
			view.addObject("artTypeList", artTypeList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 打开文章链接
	 */
	@RequestMapping(params = "method=toShareArticle")
	public ModelAndView toShareArticle(Article article, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			User user = this.getLoginUser(request);
			Destsp destsp = new Destsp();
			destsp.setSpId(user.getAccId());
			destsp = destspService.displayDestsp(destsp);

			ServiceCode serviceCode = new ServiceCode();
			serviceCode.setServiceId(destsp.getWxServiceId());
			serviceCode = serviceCodeService.displayServiceCode(serviceCode);

			view = new ModelAndView("article/toShareArticle");
			view.addObject("sOpenId", request.getAttribute("sOpenId"));
			view.addObject("article", article);
			view.addObject("destsp", destsp);
			view.addObject("serviceCode", serviceCode);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	@RequestMapping(params = "method=checkArticle")
	public void checkArticle(Article article, HttpServletRequest request, HttpServletResponse response) {
		PrintWriter printWrite = null;
		try {
			printWrite = response.getWriter();

			article.setDelFlag("0");
			article.setTitle(article.getTitle().trim());
			// 相同名称的记录数
			int count = this.articleService.checkArticle(article);

			printWrite.print(count);
			printWrite.flush();
			printWrite.close();
		} catch (Exception e) {
			printWrite.flush();
			printWrite.close();
			log.error(e, e);
		}
	}

	@RequestMapping(params = "method=toShareArticleSec")
	public ModelAndView toShareArticleSec(Article article, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Article objArticle = articleService.displayArticle(article);
			view = new ModelAndView("redirect:/article/" + objArticle.getFileName());

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

}

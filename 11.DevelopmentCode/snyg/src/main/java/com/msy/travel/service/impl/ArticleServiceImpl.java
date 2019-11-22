package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.dao.ArticleDao;
import com.msy.travel.pojo.Article;
import com.msy.travel.service.IArticleService;
import com.msy.travel.service.IRsPicService;

/**
 * ArticleService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

	@Resource(name = "articleDao")
	private ArticleDao articleDao;

	@Resource(name = "rsPicServiceImpl")
	private IRsPicService rsPicService;

	/**
	 * 新增Article
	 * 
	 * @param article
	 *            Article对象
	 */
	public void createArticle(Article article, String[] picIds) throws Exception {
		// 主键在Controller中生成
		articleDao.insertArticle(article);

		this.rsPicService.saveRsPic(picIds, article.getArticleId());
	}

	/**
	 * 检查Article
	 * 
	 * @param article
	 *            Article对象
	 */
	public void mergeArticle(Article article) throws Exception {
		articleDao.mergeArticle(article);
	}

	/**
	 * 删除Article
	 * 
	 * @param article
	 *            Article对象
	 */
	public void deleteArticle(Article article) throws Exception {
		articleDao.deleteArticle(article);
	}

	/**
	 * 修改Article
	 * 
	 * @param article
	 *            Article对象
	 */
	public void updateArticle(Article article, String[] picIds) throws Exception {
		articleDao.updateArticle(article);

		this.rsPicService.saveRsPic(picIds, article.getArticleId());
	}

	/**
	 * 批量删除Article
	 * 
	 * @param articleIdList
	 *            存放article主键的list
	 */
	public void deleteBatchArticle(Article article) throws Exception {
		articleDao.deleteBatchArticle(article);
	}

	/**
	 * 查询单个Article
	 * 
	 * @param article
	 *            Article对象
	 * 
	 * @return 成员实体对象
	 */
	public Article displayArticle(Article article) throws Exception {
		return articleDao.queryArticle(article);
	}

	/**
	 * 查询Article列表
	 * 
	 * @param article
	 *            Article对象
	 * 
	 * @return Article列表
	 */
	public List<Article> queryArticleList(Article article) throws Exception {
		return articleDao.queryArticleList(article);
	}

	/**
	 * 获取ArticleID
	 */
	public String getArticleId() throws Exception {
		return articleDao.getArticleId();
	}

	@Override
	public void setArticleDelFlag(Article article) throws Exception {
		// TODO Auto-generated method stub
		this.articleDao.setArticleDelFlag(article);
	}

	@Override
	public int checkArticle(Article article) throws Exception {
		// TODO Auto-generated method stub
		return this.articleDao.checkArticle(article);
	}
}

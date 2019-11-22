package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.Article;

/**
 * ArticleService接口
 * 
 * @author wootide
 * 
 */
public interface IArticleService {
	/**
	 * 新增Article
	 * 
	 * @param article
	 *            Article对象
	 */
	public void createArticle(Article article, String[] picIds) throws Exception;

	/**
	 * 检查Article
	 * 
	 * @param article
	 *            Article对象
	 */
	public void mergeArticle(Article article) throws Exception;

	/**
	 * 删除Article
	 * 
	 * @param article
	 *            Article对象
	 */
	public void deleteArticle(Article article) throws Exception;

	/**
	 * 批量删除Article
	 * 
	 * @param articleIdList
	 *            存放article主键的list
	 */
	public void deleteBatchArticle(Article article) throws Exception;

	/**
	 * 修改Article
	 * 
	 * @param article
	 *            Article对象
	 */
	public void updateArticle(Article article, String[] picIds) throws Exception;

	/**
	 * 查询单个Article
	 * 
	 * @param article
	 *            Article对象
	 * 
	 * @return Article实体对象
	 */
	public Article displayArticle(Article article) throws Exception;

	/**
	 * 查询Article列表
	 * 
	 * @param article
	 *            Article对象
	 * 
	 * @return Article列表
	 */
	public List<Article> queryArticleList(Article article) throws Exception;

	/**
	 * 获取Article主键ID
	 */
	public String getArticleId() throws Exception;

	/**
	 * 设置删除标识
	 * 
	 * @author Gengb
	 * @date 2018年4月12日 下午3:36:44
	 * @param article
	 * @throws Exception
	 * @return void
	 */
	void setArticleDelFlag(Article article) throws Exception;

	/**
	 * 检查重名
	 * 
	 * @author Gengb
	 * @date 2018年4月16日 上午9:28:43
	 * @param article
	 * @throws Exception
	 * @return int
	 */
	int checkArticle(Article article) throws Exception;
}

package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.Article;

/**
 * ArticleDao接口
 * 
 * @author wootide
 * 
 */
public interface ArticleDao {
	/**
	 * 增加Article
	 * 
	 * @param article
	 *            Article对象
	 */
	void insertArticle(Article article) throws Exception;

	/**
	 * 检查Article
	 * 
	 * @param article
	 *            Article对象
	 */
	void mergeArticle(Article article) throws Exception;

	/**
	 * 删除Article
	 * 
	 * @param article
	 *            成语对象
	 */
	void deleteArticle(Article article) throws Exception;

	/**
	 * 批量删除Article
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchArticle(Article article) throws Exception;

	/**
	 * 修改Article
	 * 
	 * @param article
	 *            Article对象
	 */
	void updateArticle(Article article) throws Exception;

	/**
	 * 查询单个Article信息
	 * 
	 * @param article
	 *            Article对象
	 * 
	 * @return Article实体对象
	 */
	Article queryArticle(Article article) throws Exception;

	/**
	 * 查询Article列表信息
	 * 
	 * @param article
	 *            Article对象
	 * 
	 * @return Article列表
	 */
	List<Article> queryArticleList(Article article) throws Exception;

	/**
	 * 获取ArticleID
	 */
	String getArticleId() throws Exception;

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

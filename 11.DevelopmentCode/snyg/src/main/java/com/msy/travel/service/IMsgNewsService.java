package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.MsgNews;

/**
 * MsgNewsService接口
 * 
 * @author wootide
 * 
 */
public interface IMsgNewsService {
	/**
	 * 新增MsgNews
	 * 
	 * @param msgNews
	 *            MsgNews对象
	 */
	public void createMsgNews(MsgNews msgNews) throws Exception;

	/**
	 * 检查MsgNews
	 * 
	 * @param msgNews
	 *            MsgNews对象
	 */
	public void mergeMsgNews(MsgNews msgNews) throws Exception;

	/**
	 * 删除MsgNews
	 * 
	 * @param msgNews
	 *            MsgNews对象
	 */
	public void deleteMsgNews(MsgNews msgNews) throws Exception;

	/**
	 * 批量删除MsgNews
	 * 
	 * @param msgNewsIdList
	 *            存放msgNews主键的list
	 */
	public void deleteBatchMsgNews(MsgNews msgNews) throws Exception;

	/**
	 * 修改MsgNews
	 * 
	 * @param msgNews
	 *            MsgNews对象
	 */
	public void updateMsgNews(MsgNews msgNews) throws Exception;

	/**
	 * 查询单个MsgNews
	 * 
	 * @param msgNews
	 *            MsgNews对象
	 * 
	 * @return MsgNews实体对象
	 */
	public MsgNews displayMsgNews(MsgNews msgNews) throws Exception;

	/**
	 * 查询MsgNews列表
	 * 
	 * @param msgNews
	 *            MsgNews对象
	 * 
	 * @return MsgNews列表
	 */
	public List<MsgNews> queryMsgNewsList(MsgNews msgNews) throws Exception;

	/**
	 * 获取MsgNews主键ID
	 */
	public String getMsgNewsId() throws Exception;

	/**
	 * 根据FeedbackId查找图文消息
	 * 
	 * @param msgNews
	 * @return
	 * @throws Exception
	 */
	public List<MsgNews> getMsgNewsByFeedbackId(MsgNews msgNews)
			throws Exception;
}

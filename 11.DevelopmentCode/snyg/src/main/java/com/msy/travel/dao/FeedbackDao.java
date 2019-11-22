package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.Feedback;

/**
 * FeedbackDao接口
 * 
 * @author wootide
 * 
 */
public interface FeedbackDao {
	/**
	 * 增加Feedback
	 * 
	 * @param feedback
	 *            Feedback对象
	 */
	void insertFeedback(Feedback feedback) throws Exception;

	/**
	 * 检查Feedback
	 * 
	 * @param feedback
	 *            Feedback对象
	 */
	void mergeFeedback(Feedback feedback) throws Exception;

	/**
	 * 删除Feedback
	 * 
	 * @param feedback
	 *            成语对象
	 */
	void deleteFeedback(Feedback feedback) throws Exception;

	/**
	 * 批量删除Feedback
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchFeedback(Feedback feedback) throws Exception;

	/**
	 * 修改Feedback
	 * 
	 * @param feedback
	 *            Feedback对象
	 */
	void updateFeedback(Feedback feedback) throws Exception;

	/**
	 * 查询单个Feedback信息
	 * 
	 * @param feedback
	 *            Feedback对象
	 * 
	 * @return Feedback实体对象
	 */
	Feedback queryFeedback(Feedback feedback) throws Exception;

	/**
	 * 查询Feedback列表信息
	 * 
	 * @param feedback
	 *            Feedback对象
	 * 
	 * @return Feedback列表
	 */
	List<Feedback> queryFeedbackList(Feedback feedback) throws Exception;

	/**
	 * 获取FeedbackID
	 */
	String getFeedbackId() throws Exception;

	List<Feedback> queryFeedbackListByCustom(Feedback feedback)
			throws Exception;

	/**
	 * 批量更新消息状态
	 * 
	 * @param feedback
	 * @throws Exception
	 */
	void batchResetDelFlag(Feedback feedback) throws Exception;

	/**
	 * 按关键字查询
	 * 
	 * @param feedback
	 * @return
	 * @throws Exception
	 */
	List<Feedback> getFeedbackByKey(Feedback feedback) throws Exception;
	
	/**
	 * 检索重名
	 * @param feedback
	 * @return
	 * @throws Exception
	 */
	int checkName(Feedback feedback) throws Exception;
}

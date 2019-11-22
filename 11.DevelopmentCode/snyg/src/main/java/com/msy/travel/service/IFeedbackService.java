package com.msy.travel.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.msy.travel.pojo.Feedback;
import com.msy.travel.pojo.MsgNews;
import com.msy.travel.pojo.ServiceCode;

/**
 * FeedbackService接口
 * 
 * @author wootide
 * 
 */
public interface IFeedbackService {
	/**
	 * 新增Feedback
	 * 
	 * @param feedback
	 *            Feedback对象
	 */
	public void createFeedback(Feedback feedback) throws Exception;

	/**
	 * 检查Feedback
	 * 
	 * @param feedback
	 *            Feedback对象
	 */
	public void mergeFeedback(Feedback feedback) throws Exception;

	/**
	 * 删除Feedback
	 * 
	 * @param feedback
	 *            Feedback对象
	 */
	public void deleteFeedback(Feedback feedback) throws Exception;

	/**
	 * 批量删除Feedback
	 * 
	 * @param feedbackIdList
	 *            存放feedback主键的list
	 */
	public void deleteBatchFeedback(Feedback feedback) throws Exception;

	/**
	 * 修改Feedback
	 * 
	 * @param feedback
	 *            Feedback对象
	 */
	public void updateFeedback(Feedback feedback) throws Exception;

	/**
	 * 查询单个Feedback
	 * 
	 * @param feedback
	 *            Feedback对象
	 * 
	 * @return Feedback实体对象
	 */
	public Feedback displayFeedback(Feedback feedback) throws Exception;

	/**
	 * 查询Feedback列表
	 * 
	 * @param feedback
	 *            Feedback对象
	 * 
	 * @return Feedback列表
	 */
	public List<Feedback> queryFeedbackList(Feedback feedback) throws Exception;

	/**
	 * 获取Feedback主键ID
	 */
	public String getFeedbackId() throws Exception;

	public List<Feedback> queryFeedbackListByCustom(Feedback feedback)
			throws Exception;

	/**
	 * 添加消息
	 * 
	 * @param request
	 * @param feedback
	 * @param sc
	 * @return
	 * @throws Exception
	 */
	public String saveFeedbackByAdd(HttpServletRequest request,
			Feedback feedback, ServiceCode sc) throws Exception;

	/**
	 * 修改消息
	 * 
	 * @param request
	 * @param feedback
	 * @param sc
	 * @return
	 * @throws Exception
	 */
	public String saveFeedbackByUpdate(HttpServletRequest request,
			Feedback feedback, ServiceCode sc) throws Exception;

	/**
	 * 批量更新消息状态
	 * 
	 * @param feedback
	 * @throws Exception
	 */
	public void batchResetDelFlag(Feedback feedback) throws Exception;

	/**
	 * 添加单图文
	 * 
	 * @param request
	 * @param feedback
	 * @param sc
	 * @param msgNews
	 * @return
	 * @throws Exception
	 */
	public String addFeedbackTuwen(HttpServletRequest request,
			Feedback feedback, ServiceCode sc, MsgNews msgNews)
			throws Exception;

	/**
	 * 修改单图文
	 * 
	 * @param request
	 * @param feedback
	 * @param sc
	 * @param msgNews
	 * @return
	 * @throws Exception
	 */
	public String updateFeedbackTuwen(HttpServletRequest request,
			Feedback feedback, ServiceCode sc, MsgNews msgNews)
			throws Exception;

	/**
	 * 添加多图文
	 * 
	 * @param request
	 * @param feedback
	 * @param sc
	 * @param msgNews
	 * @return
	 * @throws Exception
	 */
	public String addFeedbackDuotuwen(HttpServletRequest request,
			Feedback feedback, ServiceCode sc, String newsIds) throws Exception;

	/**
	 * 修改多图文
	 * 
	 * @param request
	 * @param feedback
	 * @param sc
	 * @param msgNews
	 * @return
	 * @throws Exception
	 */
	public String updateFeedbackDuotuwen(HttpServletRequest request,
			Feedback feedback, ServiceCode sc, String newsIds) throws Exception;

	/**
	 * 按关键字查询
	 * 
	 * @param feedback
	 * @return
	 * @throws Exception
	 */
	public List<Feedback> getFeedbackByKey(Feedback feedback) throws Exception;
	
	/**
	 * 检索重名
	 * @param feedback
	 * @return
	 * @throws Exception
	 */
	public int checkName(Feedback feedback) throws Exception;
}

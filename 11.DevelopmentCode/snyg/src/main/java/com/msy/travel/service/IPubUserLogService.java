package com.msy.travel.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.msy.travel.pojo.PubUserLog;

/**
 * PubUserLogService接口
 * 
 * @author wootide
 * 
 */
public interface IPubUserLogService {
	/**
	 * 新增PubUserLog
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 */
	public void createPubUserLog(PubUserLog pubUserLog) throws Exception;

	/**
	 * 检查PubUserLog
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 */
	public void mergePubUserLog(PubUserLog pubUserLog) throws Exception;

	/**
	 * 删除PubUserLog
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 */
	public void deletePubUserLog(PubUserLog pubUserLog) throws Exception;

	/**
	 * 批量删除PubUserLog
	 * 
	 * @param pubUserLogIdList
	 *            存放pubUserLog主键的list
	 */
	public void deleteBatchPubUserLog(PubUserLog pubUserLog) throws Exception;

	/**
	 * 修改PubUserLog
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 */
	public void updatePubUserLog(PubUserLog pubUserLog) throws Exception;

	/**
	 * 查询单个PubUserLog
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 * 
	 * @return PubUserLog实体对象
	 */
	public PubUserLog displayPubUserLog(PubUserLog pubUserLog) throws Exception;

	/**
	 * 查询PubUserLog列表
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 * 
	 * @return PubUserLog列表
	 */
	public List<PubUserLog> queryPubUserLogList(PubUserLog pubUserLog) throws Exception;

	/**
	 * 获取PubUserLog主键ID
	 */
	public String getPubUserLogId() throws Exception;

	/**
	 * 插入用户操作日志
	 */
	public void createUserLog(HttpServletRequest request, String operationName, String operationResult, String operationContext) throws Exception;

	public List<PubUserLog> getUserLogListForApi(PubUserLog pubUserLog) throws Exception;

	public void updateIsSyn(PubUserLog pubUserLog) throws Exception;
}

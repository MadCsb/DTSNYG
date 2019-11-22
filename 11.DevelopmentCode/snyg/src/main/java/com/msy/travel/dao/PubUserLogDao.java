package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.PubUserLog;

/**
 * PubUserLogDao接口
 * 
 * @author wootide
 * 
 */
public interface PubUserLogDao {
	/**
	 * 增加PubUserLog
	 *
	 * @param pubUserLog
	 *            PubUserLog对象
	 */
	void insertPubUserLog(PubUserLog pubUserLog) throws Exception;

	/**
	 * 检查PubUserLog
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 */
	void mergePubUserLog(PubUserLog pubUserLog) throws Exception;

	/**
	 * 删除PubUserLog
	 * 
	 * @param pubUserLog
	 *            成语对象
	 */
	void deletePubUserLog(PubUserLog pubUserLog) throws Exception;

	/**
	 * 批量删除PubUserLog
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchPubUserLog(PubUserLog pubUserLog) throws Exception;

	/**
	 * 修改PubUserLog
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 */
	void updatePubUserLog(PubUserLog pubUserLog) throws Exception;

	/**
	 * 查询单个PubUserLog信息
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 * 
	 * @return PubUserLog实体对象
	 */
	PubUserLog queryPubUserLog(PubUserLog pubUserLog) throws Exception;

	/**
	 * 查询PubUserLog列表信息
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 * 
	 * @return PubUserLog列表
	 */
	List<PubUserLog> queryPubUserLogList(PubUserLog pubUserLog) throws Exception;

	/**
	 * 获取PubUserLogID
	 */
	String getPubUserLogId() throws Exception;

	List<PubUserLog> getUserLogListForApi(PubUserLog pubUserLog) throws Exception;

	void updateIsSyn(PubUserLog pubUserLog) throws Exception;
}

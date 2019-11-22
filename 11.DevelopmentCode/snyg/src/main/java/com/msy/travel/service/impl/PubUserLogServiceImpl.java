package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.ResourceCommon;
import com.msy.travel.dao.PubUserLogDao;
import com.msy.travel.pojo.PubUserLog;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IPubUserLogService;

/**
 * PubUserLogService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class PubUserLogServiceImpl implements IPubUserLogService {

	@Resource(name = "pubUserLogDao")
	private PubUserLogDao pubUserLogDao;

	/**
	 * 新增PubUserLog
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 */
	public void createPubUserLog(PubUserLog pubUserLog) throws Exception {
		pubUserLogDao.insertPubUserLog(pubUserLog);
	}

	/**
	 * 检查PubUserLog
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 */
	public void mergePubUserLog(PubUserLog pubUserLog) throws Exception {
		pubUserLogDao.mergePubUserLog(pubUserLog);
	}

	/**
	 * 删除PubUserLog
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 */
	public void deletePubUserLog(PubUserLog pubUserLog) throws Exception {
		pubUserLogDao.deletePubUserLog(pubUserLog);
	}

	/**
	 * 修改PubUserLog
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 */
	public void updatePubUserLog(PubUserLog pubUserLog) throws Exception {
		pubUserLogDao.updatePubUserLog(pubUserLog);
	}

	/**
	 * 批量删除PubUserLog
	 * 
	 * @param pubUserLogIdList
	 *            存放pubUserLog主键的list
	 */
	public void deleteBatchPubUserLog(PubUserLog pubUserLog) throws Exception {
		pubUserLogDao.deleteBatchPubUserLog(pubUserLog);
	}

	/**
	 * 查询单个PubUserLog
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 * 
	 * @return 成员实体对象
	 */
	public PubUserLog displayPubUserLog(PubUserLog pubUserLog) throws Exception {
		return pubUserLogDao.queryPubUserLog(pubUserLog);
	}

	/**
	 * 查询PubUserLog列表
	 * 
	 * @param pubUserLog
	 *            PubUserLog对象
	 * 
	 * @return PubUserLog列表
	 */
	public List<PubUserLog> queryPubUserLogList(PubUserLog pubUserLog) throws Exception {
		return pubUserLogDao.queryPubUserLogList(pubUserLog);
	}

	/**
	 * 获取PubUserLogID
	 */
	public String getPubUserLogId() throws Exception {
		return pubUserLogDao.getPubUserLogId();
	}

	/**
	 * 插入用户操作日志
	 */
	@Override
	public void createUserLog(HttpServletRequest request, String operationName, String operationResult, String operationContext) throws Exception {
		User user = (User) request.getSession().getAttribute(ResourceCommon.LOGIN_USER);
		PubUserLog pubUserLog = new PubUserLog();
		if (user != null) {
			pubUserLog.setUserId(user.getUserId()); // 用户ID
			pubUserLog.setUserName(user.getUserLoginName()); // 用户登陆名
		}
		pubUserLog.setOperationTime(DateTimeUtil.getDateTime19()); // 操作时间
		pubUserLog.setSessionId(request.getSession().getId()); // SessionId
		pubUserLog.setUserIP(request.getRemoteAddr()); // IP地址
		pubUserLog.setOperationName(operationName); // 操作名称
		pubUserLog.setOperationResult(operationResult); // 操作结果 成功 或 失败
		pubUserLog.setOperationContext(operationContext); // 操作详情
		pubUserLog.setLogId(PrimaryKeyUtil.generateKey());// 主键
		pubUserLogDao.insertPubUserLog(pubUserLog);
	}

	public List<PubUserLog> getUserLogListForApi(PubUserLog pubUserLog) throws Exception {
		return pubUserLogDao.getUserLogListForApi(pubUserLog);
	}

	public void updateIsSyn(PubUserLog pubUserLog) throws Exception {
		pubUserLogDao.updateIsSyn(pubUserLog);
	}
}

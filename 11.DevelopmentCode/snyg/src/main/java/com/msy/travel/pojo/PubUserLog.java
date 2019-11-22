package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "pubuserlog")
public class PubUserLog extends BaseEntity implements java.io.Serializable {

	// columns START
	/**
	 * 操作ID db_column: F_LOG_ID
	 */
	private String logId;
	/**
	 * 用户ID db_column: F_USER_ID
	 */
	private String userId;
	/**
	 * 登录名 db_column: F_USER_NAME
	 */
	private String userName;
	/**
	 * 操作时间(yyyy-MM-dd HH:mm:ss:SSS) db_column: F_OPERATION_TIME
	 */
	private String operationTime;
	/**
	 * 会话编号 db_column: F_SESSION_ID
	 */
	private String sessionId;
	/**
	 * 用户IP db_column: F_IP
	 */
	private String userIP;
	/**
	 * 操作名称 db_column: F_OPERATION_NAME
	 */
	private String operationName;

	private String operationTime2;
	/**
	 * 操作结果；0：操作失败；1：操作成功 db_column: F_OPERATION_RESULT
	 */
	private String operationResult;
	/**
	 * 操作描述 db_column: F_OPERATION_CONTEXT
	 */
	private String operationContext;
	/**
	 * 操作时长 db_column: F_DURING
	 */
	private String during;

	/**
	 * F_LOG_MENU
	 */
	private String logMenu;

	private List<String> pubUserLogIdList;

	private String spId;

	private String isNotIsSyn;

	private String thirdUserId;

	private String isSyn;

	// columns END

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getLogId() {
		return this.logId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}

	public String getOperationTime() {
		return this.operationTime;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}

	public String getUserIP() {
		return this.userIP;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getOperationName() {
		return this.operationName;
	}

	public void setOperationResult(String operationResult) {
		this.operationResult = operationResult;
	}

	public String getOperationResult() {
		return this.operationResult;
	}

	public void setOperationContext(String operationContext) {
		this.operationContext = operationContext;
	}

	public String getOperationContext() {
		return this.operationContext;
	}

	public void setDuring(String during) {
		this.during = during;
	}

	public String getDuring() {
		return this.during;
	}

	public String getOperationTime2() {
		return operationTime2;
	}

	public void setOperationTime2(String operationTime2) {
		this.operationTime2 = operationTime2;
	}

	public String getLogMenu() {
		return logMenu;
	}

	public void setLogMenu(String logMenu) {
		this.logMenu = logMenu;
	}

	public List<String> getPubUserLogIdList() {
		return pubUserLogIdList;
	}

	public void setPubUserLogIdList(List<String> pubUserLogIdList) {
		this.pubUserLogIdList = pubUserLogIdList;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getIsNotIsSyn() {
		return isNotIsSyn;
	}

	public void setIsNotIsSyn(String isNotIsSyn) {
		this.isNotIsSyn = isNotIsSyn;
	}

	public String getThirdUserId() {
		return thirdUserId;
	}

	public void setThirdUserId(String thirdUserId) {
		this.thirdUserId = thirdUserId;
	}

	public String getIsSyn() {
		return isSyn;
	}

	public void setIsSyn(String isSyn) {
		this.isSyn = isSyn;
	}

}

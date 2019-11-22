package com.msy.travel.common;

/**
 * spring对checked
 * Exception（比如Exception,IOException的子类）是不回滚事务的，对应RuntimeException回滚事务
 * 所以继承RuntimeException 而不是 Exception
 * 
 * @author whn
 * @date 2015年9月22日 下午3:18:16
 */
public class LogicException extends RuntimeException {
	public LogicException(String exceptionMsg) {
		super(exceptionMsg);
	}
}

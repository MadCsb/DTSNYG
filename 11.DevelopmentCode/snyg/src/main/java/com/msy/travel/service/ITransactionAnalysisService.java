package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.TransactionAnalysis;

/**
 * AccessrecordService接口
 * 
 * @author wootide
 * 
 */
public interface ITransactionAnalysisService {

	/**
	 * 获取基础信息 访问量 下单量 成交量
	 * 
	 * @author wzd
	 * @date 2018年10月17日 下午1:02:42
	 * @param transactionAnalysis
	 * @return
	 * @return TransactionAnalysis
	 */
	public TransactionAnalysis getTransactionAnalysisInfo(TransactionAnalysis transactionAnalysis) throws Exception;

	/**
	 * 获取订单的信息
	 * 
	 * @author wzd
	 * @date 2018年10月18日 下午2:19:40
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 * @return TransactionAnalysis
	 */
	public TransactionAnalysis getTransactionAnalysisOrderInfo(TransactionAnalysis transactionAnalysis) throws Exception;

	
	/**
	 * 获取交易额列表
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 */
	public List<TransactionAnalysis> getOrderMoneyList(TransactionAnalysis transactionAnalysis) throws Exception;
	
	/**
	 * 查询成交客户量列表
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 */
	public List<TransactionAnalysis> getOrderCustomerList(TransactionAnalysis transactionAnalysis) throws Exception;
	
	/**
	 * 查询访问量列表
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 */
	public List<TransactionAnalysis> getAccessList(TransactionAnalysis transactionAnalysis) throws Exception;
	
	/**
	 * 查询退款订单列表
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 */
	public List<TransactionAnalysis> getOrderBackList(TransactionAnalysis transactionAnalysis) throws Exception;
	
	/**
	 * 查询成功支付订单列表
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 */
	public List<TransactionAnalysis> getOrderPayList(TransactionAnalysis transactionAnalysis) throws Exception;
}

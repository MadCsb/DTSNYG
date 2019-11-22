package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.TransactionAnalysis;

/**
 * 交易分析
 * 
 * @author wzd
 *
 */
public interface TransactionAnalysisDao {

	/**
	 * 获取基础信息 访问量 下单量 成交量
	 * 
	 * @author wzd
	 * @date 2018年10月17日 下午1:02:42
	 * @param transactionAnalysis
	 * @return
	 * @return TransactionAnalysis
	 */
	TransactionAnalysis getTransactionAnalysisInfo(TransactionAnalysis transactionAnalysis) throws Exception;

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
	TransactionAnalysis getTransactionAnalysisOrderInfo(TransactionAnalysis transactionAnalysis) throws Exception;
	
	/**
	 * 获取交易额列表
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 */
	List<TransactionAnalysis> getOrderMoneyList(TransactionAnalysis transactionAnalysis) throws Exception;
	
	/**
	 * 查询成交客户量列表
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 */
	List<TransactionAnalysis> getOrderCustomerList(TransactionAnalysis transactionAnalysis) throws Exception;
	
	/**
	 * 查询访问量列表
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 */
	List<TransactionAnalysis> getAccessList(TransactionAnalysis transactionAnalysis) throws Exception;
	
	/**
	 * 查询退款订单列表
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 */
	List<TransactionAnalysis> getOrderBackList(TransactionAnalysis transactionAnalysis) throws Exception;
	
	/**
	 * 查询成功支付订单列表
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 */
	List<TransactionAnalysis> getOrderPayList(TransactionAnalysis transactionAnalysis) throws Exception;
	
}

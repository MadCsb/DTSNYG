package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.dao.TransactionAnalysisDao;
import com.msy.travel.pojo.TransactionAnalysis;
import com.msy.travel.service.ITransactionAnalysisService;

/**
 * AccessrecordService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class TransactionAnalysisServiceImpl implements ITransactionAnalysisService {

	@Resource(name = "transactionAnalysisDao")
	private TransactionAnalysisDao transactionAnalysisDao;

	/**
	 * 获取基础信息 访问量 下单量 成交量
	 * 
	 * @author wzd
	 * @date 2018年10月17日 下午1:02:42
	 * @param transactionAnalysis
	 * @return
	 * @return TransactionAnalysis
	 */
	@Override
	public TransactionAnalysis getTransactionAnalysisInfo(TransactionAnalysis transactionAnalysis) throws Exception {
		return transactionAnalysisDao.getTransactionAnalysisInfo(transactionAnalysis);
	}

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
	@Override
	public TransactionAnalysis getTransactionAnalysisOrderInfo(TransactionAnalysis transactionAnalysis) throws Exception {
		return transactionAnalysisDao.getTransactionAnalysisOrderInfo(transactionAnalysis);
	}

	@Override
	public List<TransactionAnalysis> getOrderMoneyList(TransactionAnalysis transactionAnalysis) throws Exception {
		return transactionAnalysisDao.getOrderMoneyList(transactionAnalysis);
	}

	/**
	 * 查询成交客户量列表
	 * 
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 */
	public List<TransactionAnalysis> getOrderCustomerList(TransactionAnalysis transactionAnalysis) throws Exception {
		return transactionAnalysisDao.getOrderCustomerList(transactionAnalysis);
	}

	/**
	 * 查询访问量列表
	 * 
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 */
	public List<TransactionAnalysis> getAccessList(TransactionAnalysis transactionAnalysis) throws Exception {
		return transactionAnalysisDao.getAccessList(transactionAnalysis);
	}

	/**
	 * 查询退款订单列表
	 * 
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 */
	public List<TransactionAnalysis> getOrderBackList(TransactionAnalysis transactionAnalysis) throws Exception {
		return transactionAnalysisDao.getOrderBackList(transactionAnalysis);
	}

	/**
	 * 查询成功支付订单列表
	 * 
	 * @param transactionAnalysis
	 * @return
	 * @throws Exception
	 */
	public List<TransactionAnalysis> getOrderPayList(TransactionAnalysis transactionAnalysis) throws Exception {
		return transactionAnalysisDao.getOrderPayList(transactionAnalysis);
	}
}

package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.ExpressPrice;

/**
 * ExpressPriceDao接口
 * 
 * @author wootide
 * 
 */
public interface ExpressPriceDao {
	/**
	 * 增加ExpressPrice
	 * 
	 * @param expressPrice
	 *            ExpressPrice对象
	 */
	void insertExpressPrice(ExpressPrice expressPrice) throws Exception;

	/**
	 * 检查ExpressPrice
	 * 
	 * @param expressPrice
	 *            ExpressPrice对象
	 */
	void mergeExpressPrice(ExpressPrice expressPrice) throws Exception;

	/**
	 * 删除ExpressPrice
	 * 
	 * @param expressPrice
	 *            成语对象
	 */
	void deleteExpressPrice(ExpressPrice expressPrice) throws Exception;

	/**
	 * 批量删除ExpressPrice
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchExpressPrice(ExpressPrice expressPrice) throws Exception;

	/**
	 * 修改ExpressPrice
	 * 
	 * @param expressPrice
	 *            ExpressPrice对象
	 */
	void updateExpressPrice(ExpressPrice expressPrice) throws Exception;

	/**
	 * 查询单个ExpressPrice信息
	 * 
	 * @param expressPrice
	 *            ExpressPrice对象
	 * 
	 * @return ExpressPrice实体对象
	 */
	ExpressPrice queryExpressPrice(ExpressPrice expressPrice) throws Exception;

	/**
	 * 查询ExpressPrice列表信息
	 * 
	 * @param expressPrice
	 *            ExpressPrice对象
	 * 
	 * @return ExpressPrice列表
	 */
	List<ExpressPrice> queryExpressPriceList(ExpressPrice expressPrice) throws Exception;

	/**
	 * 获取ExpressPriceID
	 */
	String getExpressPriceId() throws Exception;

	/**
	 * 分组查询
	 * 
	 * @author wzd
	 * @date 2019年11月26日 下午1:00:21
	 * @param expressPrice
	 * @return
	 * @throws Exception
	 * @return List<ExpressPrice>
	 */
	List<ExpressPrice> queryExpressPriceListGroup(ExpressPrice expressPrice) throws Exception;
}

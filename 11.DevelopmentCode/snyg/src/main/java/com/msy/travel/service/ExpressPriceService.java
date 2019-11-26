package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.ExpressPrice;

/**
 * ExpressPriceService接口
 * 
 * @author wootide
 * 
 */
public interface ExpressPriceService {
	/**
	 * 新增ExpressPrice
	 * 
	 * @param expressPrice
	 *            ExpressPrice对象
	 */
	public void createExpressPrice(ExpressPrice expressPrice) throws Exception;

	/**
	 * 检查ExpressPrice
	 * 
	 * @param expressPrice
	 *            ExpressPrice对象
	 */
	public void mergeExpressPrice(ExpressPrice expressPrice) throws Exception;

	/**
	 * 删除ExpressPrice
	 * 
	 * @param expressPrice
	 *            ExpressPrice对象
	 */
	public void deleteExpressPrice(ExpressPrice expressPrice) throws Exception;

	/**
	 * 批量删除ExpressPrice
	 * 
	 * @param expressPriceIdList
	 *            存放expressPrice主键的list
	 */
	public void deleteBatchExpressPrice(ExpressPrice expressPrice) throws Exception;

	/**
	 * 修改ExpressPrice
	 * 
	 * @param expressPrice
	 *            ExpressPrice对象
	 */
	public void updateExpressPrice(ExpressPrice expressPrice) throws Exception;

	/**
	 * 查询单个ExpressPrice
	 * 
	 * @param expressPrice
	 *            ExpressPrice对象
	 * 
	 * @return ExpressPrice实体对象
	 */
	public ExpressPrice displayExpressPrice(ExpressPrice expressPrice) throws Exception;

	/**
	 * 查询ExpressPrice列表
	 * 
	 * @param expressPrice
	 *            ExpressPrice对象
	 * 
	 * @return ExpressPrice列表
	 */
	public List<ExpressPrice> queryExpressPriceList(ExpressPrice expressPrice) throws Exception;

	/**
	 * 获取ExpressPrice主键ID
	 */
	public String getExpressPriceId() throws Exception;

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
	public List<ExpressPrice> queryExpressPriceListGroup(ExpressPrice expressPrice) throws Exception;
}

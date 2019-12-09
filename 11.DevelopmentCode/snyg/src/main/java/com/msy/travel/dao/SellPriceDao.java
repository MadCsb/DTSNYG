package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.SellPrice;

/**
 * SellPriceDao接口
 * 
 * @author wootide
 * 
 */
public interface SellPriceDao {
	/**
	 * 增加SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 */
	void insertSellPrice(SellPrice sellPrice) throws Exception;

	/**
	 * 检查SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 */
	void mergeSellPrice(SellPrice sellPrice) throws Exception;

	/**
	 * 删除SellPrice
	 * 
	 * @param sellPrice
	 *            成语对象
	 */
	void deleteSellPrice(SellPrice sellPrice) throws Exception;

	/**
	 * 批量删除SellPrice
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchSellPrice(SellPrice sellPrice) throws Exception;

	/**
	 * 修改SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 */
	void updateSellPrice(SellPrice sellPrice) throws Exception;

	/**
	 * 查询单个SellPrice信息
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 * 
	 * @return SellPrice实体对象
	 */
	SellPrice querySellPrice(SellPrice sellPrice) throws Exception;

	/**
	 * 查询SellPrice列表信息
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 * 
	 * @return SellPrice列表
	 */
	List<SellPrice> querySellPriceList(SellPrice sellPrice) throws Exception;

	/**
	 * 获取SellPriceID
	 */
	String getSellPriceId() throws Exception;

	/**
	 * 查询SellPrice列表信息
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 * 
	 * @return SellPrice列表
	 */
	List<SellPrice> querySellPriceListForWx(SellPrice sellPrice) throws Exception;

	/**
	 * 微信端查询规格
	 * 
	 * @author wzd
	 * @date 2019年10月6日 下午7:38:11
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	List<SellPrice> queryGoodsPriceListForWx(SellPrice sellPrice) throws Exception;

	/**
	 * 活动商品管理列表
	 * 
	 * @author wzd
	 * @date 2019年10月21日 下午8:40:26
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	List<SellPrice> queryGoodsPriceListForAdd(SellPrice sellPrice) throws Exception;

	/**
	 * 按浏览量排序
	 * 
	 * @author wzd
	 * @date 2019年12月9日 下午8:46:47
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	List<SellPrice> querySellPriceListOrderByAccess(SellPrice sellPrice) throws Exception;

	/**
	 * 销量
	 * 
	 * @author wzd
	 * @date 2019年12月9日 下午9:45:54
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	List<SellPrice> querySellPriceListOrderByOrderCount(SellPrice sellPrice) throws Exception;

}

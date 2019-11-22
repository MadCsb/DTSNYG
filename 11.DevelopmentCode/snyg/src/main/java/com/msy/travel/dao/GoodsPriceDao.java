package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.GoodsPrice;

/**
 * GoodsPriceDao接口
 * 
 * @author wootide
 * 
 */
public interface GoodsPriceDao {
	/**
	 * 增加GoodsPrice
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 */
	void insertGoodsPrice(GoodsPrice goodsPrice) throws Exception;

	/**
	 * 检查GoodsPrice
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 */
	void mergeGoodsPrice(GoodsPrice goodsPrice) throws Exception;

	/**
	 * 删除GoodsPrice
	 * 
	 * @param goodsPrice
	 *            成语对象
	 */
	void deleteGoodsPrice(GoodsPrice goodsPrice) throws Exception;

	/**
	 * 批量删除GoodsPrice
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchGoodsPrice(GoodsPrice goodsPrice) throws Exception;

	/**
	 * 修改GoodsPrice
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 */
	void updateGoodsPrice(GoodsPrice goodsPrice) throws Exception;

	/**
	 * 查询单个GoodsPrice信息
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 * 
	 * @return GoodsPrice实体对象
	 */
	GoodsPrice queryGoodsPrice(GoodsPrice goodsPrice) throws Exception;

	/**
	 * 查询GoodsPrice列表信息
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 * 
	 * @return GoodsPrice列表
	 */
	List<GoodsPrice> queryGoodsPriceList(GoodsPrice goodsPrice) throws Exception;

	/**
	 * 获取GoodsPriceID
	 */
	String getGoodsPriceId() throws Exception;

	/**
	 * 通过priceId查询详情
	 * 
	 * @author wzd
	 * @date 2019年11月16日 上午10:10:53
	 * @param goodsPrice
	 * @return
	 * @throws Exception
	 * @return GoodsPrice
	 */
	GoodsPrice queryGoodsPriceByPriceId(GoodsPrice goodsPrice) throws Exception;

}

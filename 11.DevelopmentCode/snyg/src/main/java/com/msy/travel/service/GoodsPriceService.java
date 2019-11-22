package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.GoodsPrice;

/**
 * GoodsPriceService接口
 * 
 * @author wootide
 * 
 */
public interface GoodsPriceService {
	/**
	 * 新增GoodsPrice
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 */
	public void createGoodsPrice(GoodsPrice goodsPrice) throws Exception;

	/**
	 * 检查GoodsPrice
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 */
	public void mergeGoodsPrice(GoodsPrice goodsPrice) throws Exception;

	/**
	 * 删除GoodsPrice
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 */
	public void deleteGoodsPrice(GoodsPrice goodsPrice) throws Exception;

	/**
	 * 批量删除GoodsPrice
	 * 
	 * @param goodsPriceIdList
	 *            存放goodsPrice主键的list
	 */
	public void deleteBatchGoodsPrice(GoodsPrice goodsPrice) throws Exception;

	/**
	 * 修改GoodsPrice
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 */
	public void updateGoodsPrice(GoodsPrice goodsPrice) throws Exception;

	/**
	 * 查询单个GoodsPrice
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 * 
	 * @return GoodsPrice实体对象
	 */
	public GoodsPrice displayGoodsPrice(GoodsPrice goodsPrice) throws Exception;

	/**
	 * 查询GoodsPrice列表
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 * 
	 * @return GoodsPrice列表
	 */
	public List<GoodsPrice> queryGoodsPriceList(GoodsPrice goodsPrice) throws Exception;

	/**
	 * 获取GoodsPrice主键ID
	 */
	public String getGoodsPriceId() throws Exception;

	/**
	 * 新增销售规格以及销售价格
	 * 
	 * @author wzd
	 * @date 2019年10月2日 下午10:32:24
	 * @param thumbPic
	 * @param goodsPrice
	 * @throws Exception
	 * @return void
	 */
	public void createGoodsPriceAndSellPrice(String thumbPic, GoodsPrice goodsPrice) throws Exception;

	/**
	 * 修改销售规格以及销售价格
	 * 
	 * @author wzd
	 * @date 2019年10月3日 下午10:13:42
	 * @param thumbPic
	 * @param goodsPrice
	 * @throws Exception
	 * @return void
	 */
	public void updateGoodsPriceAndSellPrice(String thumbPic, GoodsPrice goodsPrice) throws Exception;

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
	public GoodsPrice queryGoodsPriceByPriceId(GoodsPrice goodsPrice) throws Exception;

}

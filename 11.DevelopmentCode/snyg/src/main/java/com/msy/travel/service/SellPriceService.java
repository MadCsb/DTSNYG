package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.SellPrice;

/**
 * SellPriceService接口
 * 
 * @author wootide
 * 
 */
public interface SellPriceService {
	/**
	 * 新增SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 */
	public void createSellPrice(SellPrice sellPrice) throws Exception;

	/**
	 * 检查SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 */
	public void mergeSellPrice(SellPrice sellPrice) throws Exception;

	/**
	 * 删除SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 */
	public void deleteSellPrice(SellPrice sellPrice) throws Exception;

	/**
	 * 批量删除SellPrice
	 * 
	 * @param sellPriceIdList
	 *            存放sellPrice主键的list
	 */
	public void deleteBatchSellPrice(SellPrice sellPrice) throws Exception;

	/**
	 * 修改SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 */
	public void updateSellPrice(SellPrice sellPrice) throws Exception;

	/**
	 * 查询单个SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 * 
	 * @return SellPrice实体对象
	 */
	public SellPrice displaySellPrice(SellPrice sellPrice) throws Exception;

	/**
	 * 查询SellPrice列表
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 * 
	 * @return SellPrice列表
	 */
	public List<SellPrice> querySellPriceList(SellPrice sellPrice) throws Exception;

	/**
	 * 获取SellPrice主键ID
	 */
	public String getSellPriceId() throws Exception;

	/**
	 * 微信端获取商品列表
	 * 
	 * @author wzd
	 * @date 2019年10月5日 下午5:16:53
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	public List<SellPrice> querySellPriceListForWx(SellPrice sellPrice) throws Exception;

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
	public List<SellPrice> queryGoodsPriceListForWx(SellPrice sellPrice) throws Exception;

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
	public List<SellPrice> queryGoodsPriceListForAdd(SellPrice sellPrice) throws Exception;

	/**
	 * 新增或修改SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 */
	public void createOrUpdateSellPrice(SellPrice sellPrice) throws Exception;

	/**
	 * 按浏览量排序
	 * 
	 * @author wzd
	 * @date 2019年12月9日 下午8:49:00
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	public List<SellPrice> querySellPriceListOrderByAccess(SellPrice sellPrice) throws Exception;

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
	public List<SellPrice> querySellPriceListOrderByOrderCount(SellPrice sellPrice) throws Exception;

	/**
	 * 优惠券选择商品
	 * 
	 * @author wzd
	 * @date 2020年3月22日 下午5:57:11
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	public List<SellPrice> querySellPriceListForCoupon(SellPrice sellPrice) throws Exception;

	/**
	 * 优惠券可使用商品
	 * 
	 * @author wzd
	 * @date 2020年3月25日 下午1:44:30
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	public List<SellPrice> querySellPriceListForCouponByCouponId(SellPrice sellPrice) throws Exception;

	/**
	 * 获取规格
	 * 
	 * @author wzd
	 * @date 2020年7月6日 下午4:54:15
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	public List<SellPrice> querySellPriceListForPriceType(SellPrice sellPrice, String userId) throws Exception;
}

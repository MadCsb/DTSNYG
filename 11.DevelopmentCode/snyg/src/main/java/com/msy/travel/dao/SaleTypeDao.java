package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.SaleType;

/**
 * SaleTypeDao接口
 * 
 * @author wootide
 * 
 */
public interface SaleTypeDao {
	/**
	 * 增加SaleType
	 * 
	 * @param saleType
	 *            SaleType对象
	 */
	void insertSaleType(SaleType saleType) throws Exception;

	/**
	 * 检查SaleType
	 * 
	 * @param saleType
	 *            SaleType对象
	 */
	void mergeSaleType(SaleType saleType) throws Exception;

	/**
	 * 删除SaleType
	 * 
	 * @param saleType
	 *            成语对象
	 */
	void deleteSaleType(SaleType saleType) throws Exception;

	/**
	 * 批量删除SaleType
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchSaleType(SaleType saleType) throws Exception;

	/**
	 * 修改SaleType
	 * 
	 * @param saleType
	 *            SaleType对象
	 */
	void updateSaleType(SaleType saleType) throws Exception;

	/**
	 * 查询单个SaleType信息
	 * 
	 * @param saleType
	 *            SaleType对象
	 * 
	 * @return SaleType实体对象
	 */
	SaleType querySaleType(SaleType saleType) throws Exception;

	/**
	 * 查询SaleType列表信息
	 * 
	 * @param saleType
	 *            SaleType对象
	 * 
	 * @return SaleType列表
	 */
	List<SaleType> querySaleTypeList(SaleType saleType) throws Exception;

	/**
	 * 获取SaleTypeID
	 */
	String getSaleTypeId() throws Exception;

	/**
	 * 优惠券选择范围
	 * 
	 * @author wzd
	 * @date 2020年3月23日 上午9:20:17
	 * @param saleType
	 * @return
	 * @throws Exception
	 * @return List<SaleType>
	 */
	List<SaleType> querySaleTypeListForCoupon(SaleType saleType) throws Exception;
}

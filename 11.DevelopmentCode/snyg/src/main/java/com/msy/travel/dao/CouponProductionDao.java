package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.CouponProduction;

/**
 * CouponProductionDao接口
 * 
 * @author wootide
 * 
 */
public interface CouponProductionDao {
	/**
	 * 增加CouponProduction
	 * 
	 * @param couponProduction
	 *            CouponProduction对象
	 */
	void insertCouponProduction(CouponProduction couponProduction) throws Exception;

	/**
	 * 检查CouponProduction
	 * 
	 * @param couponProduction
	 *            CouponProduction对象
	 */
	void mergeCouponProduction(CouponProduction couponProduction) throws Exception;

	/**
	 * 删除CouponProduction
	 * 
	 * @param couponProduction
	 *            成语对象
	 */
	void deleteCouponProduction(CouponProduction couponProduction) throws Exception;

	/**
	 * 批量删除CouponProduction
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchCouponProduction(CouponProduction couponProduction) throws Exception;

	/**
	 * 修改CouponProduction
	 * 
	 * @param couponProduction
	 *            CouponProduction对象
	 */
	void updateCouponProduction(CouponProduction couponProduction) throws Exception;

	/**
	 * 查询单个CouponProduction信息
	 * 
	 * @param couponProduction
	 *            CouponProduction对象
	 * 
	 * @return CouponProduction实体对象
	 */
	CouponProduction queryCouponProduction(CouponProduction couponProduction) throws Exception;

	/**
	 * 查询CouponProduction列表信息
	 * 
	 * @param couponProduction
	 *            CouponProduction对象
	 * 
	 * @return CouponProduction列表
	 */
	List<CouponProduction> queryCouponProductionList(CouponProduction couponProduction) throws Exception;

	/**
	 * 获取CouponProductionID
	 */
	String getCouponProductionId() throws Exception;

	/**
	 * 能使用优惠券的 产品Id
	 * 
	 * @author wzd
	 * @date 2020年3月28日 下午3:54:50
	 * @param couponProduction
	 * @return
	 * @throws Exception
	 * @return List<String>
	 */
	List<String> queryCouponProductionIdList(CouponProduction couponProduction) throws Exception;
}

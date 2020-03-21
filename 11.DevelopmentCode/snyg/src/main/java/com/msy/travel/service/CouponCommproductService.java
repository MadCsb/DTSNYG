package com.msy.travel.service;

import java.util.List;

import com.msy.travel.common.Result;
import com.msy.travel.pojo.CouponCommproduct;

/**
 * CouponCommproductService接口
 * 
 * @author wootide
 * 
 */
public interface CouponCommproductService {
	/**
	 * 新增CouponCommproduct
	 * 
	 * @param couponCommproduct
	 *            CouponCommproduct对象
	 */
	public void createCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception;

	/**
	 * 检查CouponCommproduct
	 * 
	 * @param couponCommproduct
	 *            CouponCommproduct对象
	 */
	public void mergeCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception;

	/**
	 * 删除CouponCommproduct
	 * 
	 * @param couponCommproduct
	 *            CouponCommproduct对象
	 */
	public void deleteCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception;

	/**
	 * 批量删除CouponCommproduct
	 * 
	 * @param couponCommproductIdList
	 *            存放couponCommproduct主键的list
	 */
	public void deleteBatchCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception;

	/**
	 * 修改CouponCommproduct
	 * 
	 * @param couponCommproduct
	 *            CouponCommproduct对象
	 */
	public void updateCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception;

	/**
	 * 查询单个CouponCommproduct
	 * 
	 * @param couponCommproduct
	 *            CouponCommproduct对象
	 * 
	 * @return CouponCommproduct实体对象
	 */
	public CouponCommproduct displayCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception;

	/**
	 * 查询CouponCommproduct列表
	 * 
	 * @param couponCommproduct
	 *            CouponCommproduct对象
	 * 
	 * @return CouponCommproduct列表
	 */
	public List<CouponCommproduct> queryCouponCommproductList(CouponCommproduct couponCommproduct) throws Exception;

	/**
	 * 获取CouponCommproduct主键ID
	 */
	public String getCouponCommproductId() throws Exception;

	/**
	 * 新建或更新
	 * 
	 * @author wzd
	 * @date 2020年3月21日 下午5:55:31
	 * @param couponCommproduct
	 * @return
	 * @throws Exception
	 * @return Result
	 */
	public Result createOrUpdateCouponCommproduct(CouponCommproduct couponCommproduct, String deleteOrUpdate) throws Exception;

	/**
	 * 更新sourceType 临时变更正式
	 * 
	 * @author wzd
	 * @date 2020年3月21日 下午11:07:52
	 * @param couponCommproduct
	 * @throws Exception
	 * @return void
	 */
	public void updateCouponCommproductSourceType(CouponCommproduct couponCommproduct) throws Exception;
}

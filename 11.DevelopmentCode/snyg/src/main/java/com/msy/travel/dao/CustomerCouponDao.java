package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.CustomerCoupon;

/**
 * CustomerCouponDao接口
 * 
 * @author wootide
 * 
 */
public interface CustomerCouponDao {
	/**
	 * 增加CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	void insertCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 检查CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	void mergeCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 删除CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            成语对象
	 */
	void deleteCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 批量删除CustomerCoupon
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 修改CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	void updateCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 查询单个CustomerCoupon信息
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 * 
	 * @return CustomerCoupon实体对象
	 */
	CustomerCoupon queryCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 查询CustomerCoupon列表信息
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 * 
	 * @return CustomerCoupon列表
	 */
	List<CustomerCoupon> queryCustomerCouponList(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 获取CustomerCouponID
	 */
	String getCustomerCouponId() throws Exception;

	/**
	 * 获取优惠券总数
	 * 
	 * @author wzd
	 * @date 2020年3月25日 下午4:21:01
	 * @param customerCoupon
	 * @return
	 * @throws Exception
	 * @return Long
	 */
	Long getCustomerCouponCount(CustomerCoupon customerCoupon) throws Exception;
}

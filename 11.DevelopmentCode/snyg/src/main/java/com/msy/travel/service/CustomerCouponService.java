package com.msy.travel.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.msy.travel.common.Result;
import com.msy.travel.pojo.Coupon;
import com.msy.travel.pojo.CustomerCoupon;

/**
 * CustomerCouponService接口
 * 
 * @author wootide
 * 
 */
public interface CustomerCouponService {
	/**
	 * 新增CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	public void createCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 检查CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	public void mergeCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 删除CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	public void deleteCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 批量删除CustomerCoupon
	 * 
	 * @param customerCouponIdList
	 *            存放customerCoupon主键的list
	 */
	public void deleteBatchCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 修改CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	public void updateCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 查询单个CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 * 
	 * @return CustomerCoupon实体对象
	 */
	public CustomerCoupon displayCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 查询CustomerCoupon列表
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 * 
	 * @return CustomerCoupon列表
	 */
	public List<CustomerCoupon> queryCustomerCouponList(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 获取CustomerCoupon主键ID
	 */
	public String getCustomerCouponId() throws Exception;

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
	public Long getCustomerCouponCount(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 用户领取优惠券
	 * 
	 * @author wzd
	 * @date 2020年3月25日 下午4:25:27
	 * @param fansId
	 * @param coupon
	 * @return
	 * @throws Exception
	 * @return String
	 */
	public String receiveCoupon(String userId, Coupon coupon) throws Exception;

	/**
	 * 判断是否可以优惠券
	 * 
	 * @author wzd
	 * @date 2020年3月28日 下午2:46:05
	 * @param user
	 * @param couponId
	 * @param jsonArray
	 * @return
	 * @throws Exception
	 * @return String
	 */
	public Result canUseCoupon(JSONObject jsonObject) throws Exception;

	/**
	 * 获取用户优惠券
	 * 
	 * @author wzd
	 * @date 2020年3月28日 下午4:29:42
	 * @param customerCoupon
	 * @return
	 * @throws Exception
	 * @return List<CustomerCoupon>
	 */
	public List<CustomerCoupon> queryCustomerCouponListByUserId(CustomerCoupon customerCoupon) throws Exception;

	/**
	 * 获取用户优惠券
	 * 
	 * @author wzd
	 * @date 2020年3月28日 下午4:29:42
	 * @param customerCoupon
	 * @return
	 * @throws Exception
	 * @return List<CustomerCoupon>
	 */
	public List<CustomerCoupon> queryCustomerCouponListByUserIdAndPriceId(CustomerCoupon customerCoupon, String priceId) throws Exception;
}

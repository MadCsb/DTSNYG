package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.dao.CustomerCouponDao;
import com.msy.travel.pojo.Coupon;
import com.msy.travel.pojo.CustomerCoupon;
import com.msy.travel.service.CustomerCouponService;

/**
 * CustomerCouponService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class CustomerCouponServiceImpl implements CustomerCouponService {

	@Resource(name = "customerCouponDao")
	private CustomerCouponDao customerCouponDao;

	/**
	 * 新增CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	public void createCustomerCoupon(CustomerCoupon customerCoupon) throws Exception {
		customerCouponDao.insertCustomerCoupon(customerCoupon);
	}

	/**
	 * 检查CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	public void mergeCustomerCoupon(CustomerCoupon customerCoupon) throws Exception {
		customerCouponDao.mergeCustomerCoupon(customerCoupon);
	}

	/**
	 * 删除CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	public void deleteCustomerCoupon(CustomerCoupon customerCoupon) throws Exception {
		customerCouponDao.deleteCustomerCoupon(customerCoupon);
	}

	/**
	 * 修改CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	public void updateCustomerCoupon(CustomerCoupon customerCoupon) throws Exception {
		customerCouponDao.updateCustomerCoupon(customerCoupon);
	}

	/**
	 * 批量删除CustomerCoupon
	 * 
	 * @param customerCouponIdList
	 *            存放customerCoupon主键的list
	 */
	public void deleteBatchCustomerCoupon(CustomerCoupon customerCoupon) throws Exception {
		customerCouponDao.deleteBatchCustomerCoupon(customerCoupon);
	}

	/**
	 * 查询单个CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 * 
	 * @return 成员实体对象
	 */
	public CustomerCoupon displayCustomerCoupon(CustomerCoupon customerCoupon) throws Exception {
		return customerCouponDao.queryCustomerCoupon(customerCoupon);
	}

	/**
	 * 查询CustomerCoupon列表
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 * 
	 * @return CustomerCoupon列表
	 */
	public List<CustomerCoupon> queryCustomerCouponList(CustomerCoupon customerCoupon) throws Exception {
		return customerCouponDao.queryCustomerCouponList(customerCoupon);
	}

	/**
	 * 获取CustomerCouponID
	 */
	public String getCustomerCouponId() throws Exception {
		return customerCouponDao.getCustomerCouponId();
	}

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
	public Long getCustomerCouponCount(CustomerCoupon customerCoupon) throws Exception {
		return customerCouponDao.getCustomerCouponCount(customerCoupon);
	}

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
	public String receiveCoupon(String userId, Coupon coupon) throws Exception {

		// 插入客户优惠券关联表
		String customerCouponId = PrimaryKeyUtil.generateKey();
		CustomerCoupon customerCoupon = new CustomerCoupon();
		customerCoupon.setCustomerCouponId(customerCouponId);
		customerCoupon.setCustomerCode(userId);
		customerCoupon.setCouponId(coupon.getCouponId());
		customerCoupon.setUseType(coupon.getUseType());
		customerCoupon.setUseLimit(coupon.getUseLimit());
		customerCoupon.setDiscount(coupon.getDiscount());
		customerCoupon.setCouponType(coupon.getCouponType());
		customerCoupon.setValidBegin(coupon.getValidBegin());
		customerCoupon.setValidEnd(coupon.getValidEnd());
		customerCoupon.setObtainTime(DateTimeUtil.getDateTime10());
		customerCoupon.setStatus("0"); // 使用状态:0未使用
		customerCoupon.setDelFlag("0"); // 是否删除0-未删除
		customerCouponDao.insertCustomerCoupon(customerCoupon);

		return "";
	}
}

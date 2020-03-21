package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.WTConvert;
import com.msy.travel.dao.CouponDao;
import com.msy.travel.pojo.Coupon;
import com.msy.travel.pojo.User;
import com.msy.travel.service.CouponService;

/**
 * CouponService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class CouponServiceImpl implements CouponService {

	@Resource(name = "couponDao")
	private CouponDao couponDao;

	/**
	 * 新增Coupon
	 * 
	 * @param coupon
	 *            Coupon对象
	 */
	public void createCoupon(Coupon coupon) throws Exception {
		couponDao.insertCoupon(coupon);
	}

	/**
	 * 检查Coupon
	 * 
	 * @param coupon
	 *            Coupon对象
	 */
	public void mergeCoupon(Coupon coupon) throws Exception {
		couponDao.mergeCoupon(coupon);
	}

	/**
	 * 删除Coupon
	 * 
	 * @param coupon
	 *            Coupon对象
	 */
	public void deleteCoupon(Coupon coupon) throws Exception {
		couponDao.deleteCoupon(coupon);
	}

	/**
	 * 修改Coupon
	 * 
	 * @param coupon
	 *            Coupon对象
	 */
	public void updateCoupon(Coupon coupon) throws Exception {
		couponDao.updateCoupon(coupon);
	}

	/**
	 * 批量删除Coupon
	 * 
	 * @param couponIdList
	 *            存放coupon主键的list
	 */
	public void deleteBatchCoupon(Coupon coupon) throws Exception {
		couponDao.deleteBatchCoupon(coupon);
	}

	/**
	 * 查询单个Coupon
	 * 
	 * @param coupon
	 *            Coupon对象
	 * 
	 * @return 成员实体对象
	 */
	public Coupon displayCoupon(Coupon coupon) throws Exception {
		return couponDao.queryCoupon(coupon);
	}

	/**
	 * 查询Coupon列表
	 * 
	 * @param coupon
	 *            Coupon对象
	 * 
	 * @return Coupon列表
	 */
	public List<Coupon> queryCouponList(Coupon coupon) throws Exception {
		return couponDao.queryCouponList(coupon);
	}

	/**
	 * 获取CouponID
	 */
	public String getCouponId() throws Exception {
		return couponDao.getCouponId();
	}

	/**
	 * 新建
	 * 
	 * @author wzd
	 * @date 2020年3月19日 下午9:04:38
	 * @param coupon
	 * @param user
	 * @throws Exception
	 * @return void
	 */
	public void createCoupon(Coupon coupon, User user) throws Exception {
		coupon.setCreateTime(DateTimeUtil.getDateTime19());
		coupon.setCreatorUid(user.getUserId());
		coupon.setCreator(user.getUserName());
		coupon.setSpId(user.getAccId());
		coupon.setDelFlag("0");
		coupon.setCouponTag("1");
		coupon.setPcouponId(coupon.getCouponId());
		coupon.setUpdater(user.getUserName());
		coupon.setUpdaterUid(user.getUserId());
		coupon.setUpdateTime(DateTimeUtil.getDateTime19());
		coupon.setObtainDateSpan(WTConvert.emptyToNull(coupon.getObtainDateSpan()));

		couponDao.insertCoupon(coupon);
	}
}

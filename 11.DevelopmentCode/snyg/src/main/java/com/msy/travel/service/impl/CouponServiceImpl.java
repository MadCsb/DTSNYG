package com.msy.travel.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.WTConvert;
import com.msy.travel.dao.CouponDao;
import com.msy.travel.pojo.Coupon;
import com.msy.travel.pojo.CouponProduction;
import com.msy.travel.pojo.User;
import com.msy.travel.service.CouponProductionService;
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

	@Resource(name = "couponProductionServiceImpl")
	private CouponProductionService couponProductionService;

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
	public void createCoupon(Coupon coupon, User user, String sellPriceIdList) throws Exception {
		coupon.setCouponId(PrimaryKeyUtil.generateKey());
		coupon.setSpId(user.getAccId());
		coupon.setCreateTime(DateTimeUtil.getDateTime19());
		coupon.setUpdateTime(DateTimeUtil.getDateTime19());
		coupon.setCreatorUid(user.getUserId());
		coupon.setCreator(user.getUserName());
		coupon.setUpdater(user.getUserName());
		coupon.setUpdaterUid(user.getUserId());
		coupon.setDelFlag("0");
		coupon.setObtainDateSpan(WTConvert.emptyToNull(coupon.getObtainDateSpan()));
		coupon.setDayNum(WTConvert.emptyToNull(coupon.getDayNum()));
		coupon.setCouponTag("1");

		if (coupon.getObtainDateType().equals("2")) {
			coupon.setObtainDateBegin(coupon.getValidBegin());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			// 结束日期
			Date validEnd = sdf.parse(coupon.getValidEnd());
			Calendar end = Calendar.getInstance();
			end.setTime(validEnd);

			// 开始日期 +结束时长
			Date validBegin = sdf.parse(coupon.getValidBegin());
			Calendar obtainDateEnd = Calendar.getInstance();
			obtainDateEnd.setTime(validBegin);
			obtainDateEnd.add(Calendar.DATE, (Integer.parseInt(coupon.getObtainDateSpan()) - 1));

			if (obtainDateEnd.before(end)) {
				coupon.setObtainDateEnd(sdf.format(obtainDateEnd.getTime()));
			} else {
				coupon.setObtainDateEnd(coupon.getValidEnd());
			}

		}

		// 指定商品
		if (coupon.getCouponType().equals("2")) {
			if (sellPriceIdList != null && !sellPriceIdList.equals("")) {
				String[] checkPdcList = sellPriceIdList.split(",");
				if (checkPdcList != null && checkPdcList.length > 0) {
					for (int i = 0; i < checkPdcList.length; i++) {
						CouponProduction c = new CouponProduction();
						c.setCouponPdcId(PrimaryKeyUtil.generateKey());
						c.setCouponId(coupon.getCouponId());
						c.setUseCouponId(checkPdcList[i]);
						c.setCouponType("1");
						couponProductionService.createCouponProduction(c);
					}
				}
			}
		} else if (coupon.getCouponType().equals("1")) {
			CouponProduction c = new CouponProduction();
			c.setCouponPdcId(PrimaryKeyUtil.generateKey());
			c.setCouponId(coupon.getCouponId());
			c.setUseCouponId(coupon.getUseCouponId());
			c.setCouponType("0");
			couponProductionService.createCouponProduction(c);
		}

		couponDao.insertCoupon(coupon);
	}
}
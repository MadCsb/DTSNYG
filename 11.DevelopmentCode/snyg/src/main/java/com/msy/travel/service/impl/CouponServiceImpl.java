package com.msy.travel.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.Result;
import com.msy.travel.common.WTConvert;
import com.msy.travel.dao.CouponDao;
import com.msy.travel.pojo.Coupon;
import com.msy.travel.pojo.CouponProduction;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.SaleType;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.pojo.User;
import com.msy.travel.service.CouponProductionService;
import com.msy.travel.service.CouponService;
import com.msy.travel.service.SaleTypeService;
import com.msy.travel.service.SellPriceService;

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

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;

	@Resource(name = "saleTypeServiceImpl")
	private SaleTypeService saleTypeService;

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
		coupon.setPcouponId(coupon.getCouponId());

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
		couponDao.insertCoupon(coupon);

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

	}

	/**
	 * 更新
	 * 
	 * @author wzd
	 * @date 2020年3月23日 下午2:14:30
	 * @param coupon
	 * @param user
	 * @param sellPriceIdList
	 * @throws Exception
	 * @return void
	 */
	public void updateCoupon(Coupon coupon, User user, String sellPriceIdList) throws Exception {
		Coupon oldCoupon = couponDao.queryCoupon(coupon);
		// 如果上一次是草稿 则更新
		if (oldCoupon.getStatus().equals("0")) {
			coupon.setUpdateTime(DateTimeUtil.getDateTime19());
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
			coupon.setPcouponId(oldCoupon.getPcouponId());
			couponDao.updateCoupon(coupon);

			CouponProduction cp = new CouponProduction();
			cp.setCouponId(coupon.getCouponId());
			couponProductionService.deleteCouponProduction(cp);

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
		} else {
			oldCoupon.setCouponTag("0");
			couponDao.updateCoupon(oldCoupon);

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
			coupon.setPcouponId(oldCoupon.getPcouponId());
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
			couponDao.insertCoupon(coupon);

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
		}
	}

	/**
	 * 复制优惠券
	 * 
	 * @author wzd
	 * @date 2020年3月23日 下午3:59:28
	 * @param coupon
	 * @param user
	 * @return
	 * @throws Exception
	 * @return Result
	 */
	public Result copyCoupon(Coupon coupon, User user) throws Exception {
		Result result = new Result();
		String oldCouponId = coupon.getCouponId();
		Coupon oldCoupon = couponDao.queryCoupon(coupon);
		oldCoupon.setCouponId(PrimaryKeyUtil.generateKey());
		oldCoupon.setSpId(user.getAccId());
		oldCoupon.setCreateTime(DateTimeUtil.getDateTime19());
		oldCoupon.setUpdateTime(DateTimeUtil.getDateTime19());
		oldCoupon.setCreatorUid(user.getUserId());
		oldCoupon.setCreator(user.getUserName());
		oldCoupon.setUpdater(user.getUserName());
		oldCoupon.setUpdaterUid(user.getUserId());
		oldCoupon.setDelFlag("0");
		oldCoupon.setStatus("0");
		oldCoupon.setCouponTag("1");
		oldCoupon.setPcouponId(oldCoupon.getCouponId());
		couponDao.insertCoupon(oldCoupon);

		CouponProduction c = new CouponProduction();
		c.setCouponId(oldCouponId);
		List<CouponProduction> couponProduction = couponProductionService.queryCouponProductionList(c);
		if (couponProduction != null && couponProduction.size() > 0) {
			for (int i = 0; i < couponProduction.size(); i++) {
				CouponProduction newCouponProduction = couponProduction.get(i);
				newCouponProduction.setCouponId(oldCoupon.getCouponId());
				newCouponProduction.setCouponPdcId(PrimaryKeyUtil.generateKey());
				couponProductionService.createCouponProduction(newCouponProduction);

			}
		}

		result.setResultCode("0");
		return result;
	}

	/**
	 * 用户登录商品页领取商品
	 * 
	 * @author wzd
	 * @date 2020年3月24日 下午8:59:32
	 * @param coupon
	 * @return
	 * @throws Exception
	 * @return List<Coupon>
	 */
	public List<Coupon> queryCouponListForSellPriceLogin(Coupon coupon) throws Exception {
		return couponDao.queryCouponListForSellPriceLogin(coupon);
	}

	/**
	 * 用户未登录商品页领取商品
	 * 
	 * @author wzd
	 * @date 2020年3月24日 下午8:59:32
	 * @param coupon
	 * @return
	 * @throws Exception
	 * @return List<Coupon>
	 */
	public List<Coupon> queryCouponListForSellPriceNoLogin(Coupon coupon) throws Exception {
		return couponDao.queryCouponListForSellPriceNoLogin(coupon);
	}

	/**
	 * 根据销售id获取优惠券信息
	 * 
	 * @author wzd
	 * @date 2020年3月25日 上午11:06:42
	 * @param coupon
	 * @return
	 * @throws Exception
	 * @return List<Coupon>
	 */
	public List<Coupon> queryCouponListByPriceId(User user, String priceId) throws Exception {
		boolean isLogin = false;

		if (user != null && user.getUserId() != null && !user.getUserId().equals("")) {
			isLogin = true;
		}
		Coupon coupon = new Coupon();

		coupon.setDelFlag("0");
		coupon.setSpId(Destsp.currentSpId);
		coupon.setCouponTag("1");
		coupon.setCrrObtainDate(DateTimeUtil.getDateTime10());
		if (isLogin) {
			coupon.setUserId(user.getUserId());
		}

		List<String> useCouponIdList = new ArrayList<String>();
		// 全部商品渠道
		useCouponIdList.add(Destsp.currentSpId);
		// 销售Id
		useCouponIdList.add(priceId);

		SellPrice sellPrice = new SellPrice();
		sellPrice.setPriceId(priceId);
		sellPrice = sellPriceService.displaySellPrice(sellPrice);

		// 活动id
		SaleType saleType = new SaleType();
		saleType.setSaleTypeKey(sellPrice.getPriceType());
		saleType.setStatus("1");
		List<SaleType> saleTypeList = saleTypeService.querySaleTypeList(saleType);
		if (saleTypeList != null && saleTypeList.size() > 0) {
			useCouponIdList.add(saleTypeList.get(0).getSaleTypeId());
		}
		coupon.setUseCouponIdList(useCouponIdList);

		List<Coupon> couponList = new ArrayList<Coupon>();
		if (isLogin) {
			couponList = couponDao.queryCouponListForSellPriceLogin(coupon);
		} else {
			couponList = couponDao.queryCouponListForSellPriceNoLogin(coupon);
		}

		return couponList;
	}

	/**
	 * 活动页优惠券检索 未登录
	 * 
	 * @author wzd
	 * @date 2020年3月25日 下午4:45:25
	 * @param coupon
	 * @return
	 * @throws Exception
	 * @return List<Coupon>
	 */
	public List<Coupon> queryCouponListBySquareNoLogin(Coupon coupon) throws Exception {
		return couponDao.queryCouponListBySquareNoLogin(coupon);
	}

	/**
	 * 活动页优惠券检索 登录
	 * 
	 * @author wzd
	 * @date 2020年3月25日 下午4:45:25
	 * @param coupon
	 * @return
	 * @throws Exception
	 * @return List<Coupon>
	 */
	public List<Coupon> queryCouponListBySquareLogin(Coupon coupon) throws Exception {
		return couponDao.queryCouponListBySquareLogin(coupon);
	}
}

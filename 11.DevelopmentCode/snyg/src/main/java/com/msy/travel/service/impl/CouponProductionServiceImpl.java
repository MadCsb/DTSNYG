package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.dao.CouponProductionDao;
import com.msy.travel.pojo.CouponProduction;
import com.msy.travel.service.CouponProductionService;

/**
 * CouponProductionService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class CouponProductionServiceImpl implements CouponProductionService {

	@Resource(name = "couponProductionDao")
	private CouponProductionDao couponProductionDao;

	/**
	 * 新增CouponProduction
	 * 
	 * @param couponProduction
	 *            CouponProduction对象
	 */
	public void createCouponProduction(CouponProduction couponProduction) throws Exception {
		couponProductionDao.insertCouponProduction(couponProduction);
	}

	/**
	 * 检查CouponProduction
	 * 
	 * @param couponProduction
	 *            CouponProduction对象
	 */
	public void mergeCouponProduction(CouponProduction couponProduction) throws Exception {
		couponProductionDao.mergeCouponProduction(couponProduction);
	}

	/**
	 * 删除CouponProduction
	 * 
	 * @param couponProduction
	 *            CouponProduction对象
	 */
	public void deleteCouponProduction(CouponProduction couponProduction) throws Exception {
		couponProductionDao.deleteCouponProduction(couponProduction);
	}

	/**
	 * 修改CouponProduction
	 * 
	 * @param couponProduction
	 *            CouponProduction对象
	 */
	public void updateCouponProduction(CouponProduction couponProduction) throws Exception {
		couponProductionDao.updateCouponProduction(couponProduction);
	}

	/**
	 * 批量删除CouponProduction
	 * 
	 * @param couponProductionIdList
	 *            存放couponProduction主键的list
	 */
	public void deleteBatchCouponProduction(CouponProduction couponProduction) throws Exception {
		couponProductionDao.deleteBatchCouponProduction(couponProduction);
	}

	/**
	 * 查询单个CouponProduction
	 * 
	 * @param couponProduction
	 *            CouponProduction对象
	 * 
	 * @return 成员实体对象
	 */
	public CouponProduction displayCouponProduction(CouponProduction couponProduction) throws Exception {
		return couponProductionDao.queryCouponProduction(couponProduction);
	}

	/**
	 * 查询CouponProduction列表
	 * 
	 * @param couponProduction
	 *            CouponProduction对象
	 * 
	 * @return CouponProduction列表
	 */
	public List<CouponProduction> queryCouponProductionList(CouponProduction couponProduction) throws Exception {
		return couponProductionDao.queryCouponProductionList(couponProduction);
	}

	/**
	 * 获取CouponProductionID
	 */
	public String getCouponProductionId() throws Exception {
		return couponProductionDao.getCouponProductionId();
	}

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
	public List<String> queryCouponProductionIdList(CouponProduction couponProduction) throws Exception {
		return couponProductionDao.queryCouponProductionIdList(couponProduction);
	}
}

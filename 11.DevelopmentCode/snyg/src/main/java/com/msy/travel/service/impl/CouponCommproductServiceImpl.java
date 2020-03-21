package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.Result;
import com.msy.travel.dao.CouponCommproductDao;
import com.msy.travel.pojo.CouponCommproduct;
import com.msy.travel.service.CouponCommproductService;

/**
 * CouponCommproductService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class CouponCommproductServiceImpl implements CouponCommproductService {

	@Resource(name = "couponCommproductDao")
	private CouponCommproductDao couponCommproductDao;

	/**
	 * 新增CouponCommproduct
	 * 
	 * @param couponCommproduct
	 *            CouponCommproduct对象
	 */
	public void createCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception {
		couponCommproductDao.insertCouponCommproduct(couponCommproduct);
	}

	/**
	 * 检查CouponCommproduct
	 * 
	 * @param couponCommproduct
	 *            CouponCommproduct对象
	 */
	public void mergeCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception {
		couponCommproductDao.mergeCouponCommproduct(couponCommproduct);
	}

	/**
	 * 删除CouponCommproduct
	 * 
	 * @param couponCommproduct
	 *            CouponCommproduct对象
	 */
	public void deleteCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception {
		couponCommproductDao.deleteCouponCommproduct(couponCommproduct);
	}

	/**
	 * 修改CouponCommproduct
	 * 
	 * @param couponCommproduct
	 *            CouponCommproduct对象
	 */
	public void updateCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception {
		couponCommproductDao.updateCouponCommproduct(couponCommproduct);
	}

	/**
	 * 批量删除CouponCommproduct
	 * 
	 * @param couponCommproductIdList
	 *            存放couponCommproduct主键的list
	 */
	public void deleteBatchCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception {
		couponCommproductDao.deleteBatchCouponCommproduct(couponCommproduct);
	}

	/**
	 * 查询单个CouponCommproduct
	 * 
	 * @param couponCommproduct
	 *            CouponCommproduct对象
	 * 
	 * @return 成员实体对象
	 */
	public CouponCommproduct displayCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception {
		return couponCommproductDao.queryCouponCommproduct(couponCommproduct);
	}

	/**
	 * 查询CouponCommproduct列表
	 * 
	 * @param couponCommproduct
	 *            CouponCommproduct对象
	 * 
	 * @return CouponCommproduct列表
	 */
	public List<CouponCommproduct> queryCouponCommproductList(CouponCommproduct couponCommproduct) throws Exception {
		return couponCommproductDao.queryCouponCommproductList(couponCommproduct);
	}

	/**
	 * 获取CouponCommproductID
	 */
	public String getCouponCommproductId() throws Exception {
		return couponCommproductDao.getCouponCommproductId();
	}

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
	public Result createOrUpdateCouponCommproduct(CouponCommproduct couponCommproduct, String deleteOrUpdate) throws Exception {
		Result result = new Result();

		if (deleteOrUpdate.equals("delete")) {
			if (couponCommproduct.getUseCouponPdcIdString() != null && !"".equals(couponCommproduct.getUseCouponPdcIdString())) {
				String[] str = couponCommproduct.getUseCouponPdcIdString().split(",");
				for (String s : str) {
					CouponCommproduct c = new CouponCommproduct();
					c.setCouponId(couponCommproduct.getCouponId());
					c.setUseCouponPdcId(s);
					c = couponCommproductDao.queryCouponCommproduct(c);

					couponCommproductDao.deleteCouponCommproduct(c);
				}
			}
		} else {

			CouponCommproduct c = new CouponCommproduct();
			c.setCouponId(couponCommproduct.getCouponId());
			c.setUseCouponPdcId(couponCommproduct.getUseCouponPdcId());
			c = couponCommproductDao.queryCouponCommproduct(c);

			if (c == null) {
				couponCommproduct.setCouponCommId(PrimaryKeyUtil.generateKey());
				couponCommproduct.setCreateTime(DateTimeUtil.getDateTime19());
				couponCommproduct.setSourceType("0");
				couponCommproductDao.insertCouponCommproduct(couponCommproduct);
			} else {
				c.setIsCommon(couponCommproduct.getIsCommon());
				c.setIsGroupPro(couponCommproduct.getIsGroupPro());
				c.setIsSeckill(couponCommproduct.getIsSeckill());
				c.setCreateTime(DateTimeUtil.getDateTime19());
				c.setSourceType("0");
				couponCommproductDao.updateCouponCommproduct(c);
			}
		}

		CouponCommproduct cc = new CouponCommproduct();
		cc.setCouponId(couponCommproduct.getCouponId());
		List<CouponCommproduct> couponCommproductList = couponCommproductDao.queryCouponCommproductList(cc);

		result.setResultCode("0");
		result.setResultMsg((couponCommproductList == null || couponCommproductList.size() == 0 ? 0 : couponCommproductList.size()) + "");
		return result;
	}

}

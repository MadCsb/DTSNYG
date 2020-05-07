package com.msy.travel.service;

import java.util.List;
import java.util.Map;

import com.msy.travel.common.Result;
import com.msy.travel.pojo.Coupon;
import com.msy.travel.pojo.User;

/**
 * CouponService接口
 * 
 * @author wootide
 * 
 */
public interface CouponService {
	/**
	 * 新增Coupon
	 * 
	 * @param coupon
	 *            Coupon对象
	 */
	public void createCoupon(Coupon coupon) throws Exception;

	/**
	 * 检查Coupon
	 * 
	 * @param coupon
	 *            Coupon对象
	 */
	public void mergeCoupon(Coupon coupon) throws Exception;

	/**
	 * 删除Coupon
	 * 
	 * @param coupon
	 *            Coupon对象
	 */
	public void deleteCoupon(Coupon coupon) throws Exception;

	/**
	 * 批量删除Coupon
	 * 
	 * @param couponIdList
	 *            存放coupon主键的list
	 */
	public void deleteBatchCoupon(Coupon coupon) throws Exception;

	/**
	 * 修改Coupon
	 * 
	 * @param coupon
	 *            Coupon对象
	 */
	public void updateCoupon(Coupon coupon) throws Exception;

	/**
	 * 查询单个Coupon
	 * 
	 * @param coupon
	 *            Coupon对象
	 * 
	 * @return Coupon实体对象
	 */
	public Coupon displayCoupon(Coupon coupon) throws Exception;

	/**
	 * 查询Coupon列表
	 * 
	 * @param coupon
	 *            Coupon对象
	 * 
	 * @return Coupon列表
	 */
	public List<Coupon> queryCouponList(Coupon coupon) throws Exception;

	/**
	 * 获取Coupon主键ID
	 */
	public String getCouponId() throws Exception;

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
	public void createCoupon(Coupon coupon, User user, String sellPriceIdList) throws Exception;

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
	public void updateCoupon(Coupon coupon, User user, String sellPriceIdList) throws Exception;

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
	public Result copyCoupon(Coupon coupon, User user) throws Exception;

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
	public List<Coupon> queryCouponListForSellPriceLogin(Coupon coupon) throws Exception;

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
	public List<Coupon> queryCouponListForSellPriceNoLogin(Coupon coupon) throws Exception;

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
	public List<Coupon> queryCouponListByPriceId(User user, String priceId) throws Exception;

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
	public List<Coupon> queryCouponListBySquareNoLogin(Coupon coupon) throws Exception;

	/**
	 * 活动页优惠券检索 已登录
	 * 
	 * @author wzd
	 * @date 2020年3月25日 下午4:45:25
	 * @param coupon
	 * @return
	 * @throws Exception
	 * @return List<Coupon>
	 */
	public List<Coupon> queryCouponListBySquareLogin(Coupon coupon) throws Exception;

	/**
	 * 判断能否领取（返回提示信息）
	 * 
	 * @author wzd
	 * @date 2020年5月7日 下午2:56:59
	 * @param coupon
	 * @param userId
	 * @return
	 * @throws Exception
	 * @return Result
	 */
	public Result canReceiveMsg(Coupon coupon, String userId) throws Exception;

	/**
	 * 执行发放优惠券事件
	 * 
	 * @author wzd
	 * @date 2020年5月7日 下午5:16:23
	 * @param params
	 * @return
	 * @throws Exception
	 * @return Result
	 */
	public Result implementEventCoupon(Map<String, String> params) throws Exception;

}

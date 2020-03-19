package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.Coupon;

/**
 * CouponService接口
 * 
 * @author wootide
 * 
 */
public interface CouponService
{
    /**
     * 新增Coupon
     * 
     * @param coupon Coupon对象
     */
    public void createCoupon(Coupon coupon) throws Exception;
    
    /**
     * 检查Coupon
     * 
     * @param coupon Coupon对象
     */
    public void mergeCoupon(Coupon coupon) throws Exception;
  
    /**
     * 删除Coupon
     * 
     * @param coupon Coupon对象
     */
    public void deleteCoupon(Coupon coupon) throws Exception;
   
    /**
     * 批量删除Coupon
     * 
     * @param couponIdList  存放coupon主键的list
     */
    public void deleteBatchCoupon(Coupon coupon) throws Exception;  
    
    /**
     * 修改Coupon
     * 
     * @param coupon Coupon对象
     */
    public void updateCoupon(Coupon coupon) throws Exception;
    
    /**
     * 查询单个Coupon
     * 
     * @param coupon Coupon对象
     * 
     * @return Coupon实体对象
     */
    public Coupon displayCoupon(Coupon coupon) throws Exception;
  
   /**
     * 查询Coupon列表
     * 
     * @param coupon Coupon对象
     * 
     * @return Coupon列表
     */
    public List<Coupon> queryCouponList(Coupon coupon) throws Exception;

    /**
     * 获取Coupon主键ID
     */
    public String getCouponId() throws Exception;
}


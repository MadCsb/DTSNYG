package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.Coupon;
/**
 * CouponDao接口
 * 
 * @author wootide
 * 
 */
public interface CouponDao
{
    /**
     * 增加Coupon
     * 
     * @param coupon Coupon对象
     */
    void insertCoupon(Coupon coupon) throws Exception;
   
    /**
     * 检查Coupon
     * 
     * @param coupon Coupon对象
     */
    void mergeCoupon(Coupon coupon) throws Exception;
   
    /**
     * 删除Coupon
     * 
     * @param coupon 成语对象
     */
    void deleteCoupon(Coupon coupon) throws Exception;
    
    /**
     * 批量删除Coupon
     * 
     * @param ids ids
     */
    void deleteBatchCoupon(Coupon coupon) throws Exception;  
    
    /**
     * 修改Coupon
     * 
     * @param coupon Coupon对象
     */
    void updateCoupon(Coupon coupon) throws Exception;  
   
    /**
     * 查询单个Coupon信息
     * 
     * @param coupon Coupon对象
     * 
     * @return Coupon实体对象
     */
    Coupon queryCoupon(Coupon coupon) throws Exception;
    
    /**
     * 查询Coupon列表信息
     * 
     * @param coupon Coupon对象
     * 
     * @return Coupon列表
     */
    List<Coupon> queryCouponList(Coupon coupon) throws Exception;

    /**
     * 获取CouponID
     */
    String getCouponId() throws Exception;
}

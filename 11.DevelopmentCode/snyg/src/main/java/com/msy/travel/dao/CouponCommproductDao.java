package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.CouponCommproduct;
/**
 * CouponCommproductDao接口
 * 
 * @author wootide
 * 
 */
public interface CouponCommproductDao
{
    /**
     * 增加CouponCommproduct
     * 
     * @param couponCommproduct CouponCommproduct对象
     */
    void insertCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception;
   
    /**
     * 检查CouponCommproduct
     * 
     * @param couponCommproduct CouponCommproduct对象
     */
    void mergeCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception;
   
    /**
     * 删除CouponCommproduct
     * 
     * @param couponCommproduct 成语对象
     */
    void deleteCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception;
    
    /**
     * 批量删除CouponCommproduct
     * 
     * @param ids ids
     */
    void deleteBatchCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception;  
    
    /**
     * 修改CouponCommproduct
     * 
     * @param couponCommproduct CouponCommproduct对象
     */
    void updateCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception;  
   
    /**
     * 查询单个CouponCommproduct信息
     * 
     * @param couponCommproduct CouponCommproduct对象
     * 
     * @return CouponCommproduct实体对象
     */
    CouponCommproduct queryCouponCommproduct(CouponCommproduct couponCommproduct) throws Exception;
    
    /**
     * 查询CouponCommproduct列表信息
     * 
     * @param couponCommproduct CouponCommproduct对象
     * 
     * @return CouponCommproduct列表
     */
    List<CouponCommproduct> queryCouponCommproductList(CouponCommproduct couponCommproduct) throws Exception;

    /**
     * 获取CouponCommproductID
     */
    String getCouponCommproductId() throws Exception;
}

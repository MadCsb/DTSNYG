package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.CouponProduction;

/**
 * CouponProductionService接口
 * 
 * @author wootide
 * 
 */
public interface CouponProductionService
{
    /**
     * 新增CouponProduction
     * 
     * @param couponProduction CouponProduction对象
     */
    public void createCouponProduction(CouponProduction couponProduction) throws Exception;
    
    /**
     * 检查CouponProduction
     * 
     * @param couponProduction CouponProduction对象
     */
    public void mergeCouponProduction(CouponProduction couponProduction) throws Exception;
  
    /**
     * 删除CouponProduction
     * 
     * @param couponProduction CouponProduction对象
     */
    public void deleteCouponProduction(CouponProduction couponProduction) throws Exception;
   
    /**
     * 批量删除CouponProduction
     * 
     * @param couponProductionIdList  存放couponProduction主键的list
     */
    public void deleteBatchCouponProduction(CouponProduction couponProduction) throws Exception;  
    
    /**
     * 修改CouponProduction
     * 
     * @param couponProduction CouponProduction对象
     */
    public void updateCouponProduction(CouponProduction couponProduction) throws Exception;
    
    /**
     * 查询单个CouponProduction
     * 
     * @param couponProduction CouponProduction对象
     * 
     * @return CouponProduction实体对象
     */
    public CouponProduction displayCouponProduction(CouponProduction couponProduction) throws Exception;
  
   /**
     * 查询CouponProduction列表
     * 
     * @param couponProduction CouponProduction对象
     * 
     * @return CouponProduction列表
     */
    public List<CouponProduction> queryCouponProductionList(CouponProduction couponProduction) throws Exception;

    /**
     * 获取CouponProduction主键ID
     */
    public String getCouponProductionId() throws Exception;
}


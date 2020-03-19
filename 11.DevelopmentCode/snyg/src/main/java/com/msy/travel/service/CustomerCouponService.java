package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.CustomerCoupon;

/**
 * CustomerCouponService接口
 * 
 * @author wootide
 * 
 */
public interface CustomerCouponService
{
    /**
     * 新增CustomerCoupon
     * 
     * @param customerCoupon CustomerCoupon对象
     */
    public void createCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;
    
    /**
     * 检查CustomerCoupon
     * 
     * @param customerCoupon CustomerCoupon对象
     */
    public void mergeCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;
  
    /**
     * 删除CustomerCoupon
     * 
     * @param customerCoupon CustomerCoupon对象
     */
    public void deleteCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;
   
    /**
     * 批量删除CustomerCoupon
     * 
     * @param customerCouponIdList  存放customerCoupon主键的list
     */
    public void deleteBatchCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;  
    
    /**
     * 修改CustomerCoupon
     * 
     * @param customerCoupon CustomerCoupon对象
     */
    public void updateCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;
    
    /**
     * 查询单个CustomerCoupon
     * 
     * @param customerCoupon CustomerCoupon对象
     * 
     * @return CustomerCoupon实体对象
     */
    public CustomerCoupon displayCustomerCoupon(CustomerCoupon customerCoupon) throws Exception;
  
   /**
     * 查询CustomerCoupon列表
     * 
     * @param customerCoupon CustomerCoupon对象
     * 
     * @return CustomerCoupon列表
     */
    public List<CustomerCoupon> queryCustomerCouponList(CustomerCoupon customerCoupon) throws Exception;

    /**
     * 获取CustomerCoupon主键ID
     */
    public String getCustomerCouponId() throws Exception;
}


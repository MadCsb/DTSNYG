package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.OrderCustomer;

/**
 * OrderCustomerService接口
 * 
 * @author wootide
 * 
 */
public interface OrderCustomerService
{
    /**
     * 新增OrderCustomer
     * 
     * @param orderCustomer OrderCustomer对象
     */
    public void createOrderCustomer(OrderCustomer orderCustomer) throws Exception;
    
    /**
     * 检查OrderCustomer
     * 
     * @param orderCustomer OrderCustomer对象
     */
    public void mergeOrderCustomer(OrderCustomer orderCustomer) throws Exception;
  
    /**
     * 删除OrderCustomer
     * 
     * @param orderCustomer OrderCustomer对象
     */
    public void deleteOrderCustomer(OrderCustomer orderCustomer) throws Exception;
   
    /**
     * 批量删除OrderCustomer
     * 
     * @param orderCustomerIdList  存放orderCustomer主键的list
     */
    public void deleteBatchOrderCustomer(OrderCustomer orderCustomer) throws Exception;  
    
    /**
     * 修改OrderCustomer
     * 
     * @param orderCustomer OrderCustomer对象
     */
    public void updateOrderCustomer(OrderCustomer orderCustomer) throws Exception;
    
    /**
     * 查询单个OrderCustomer
     * 
     * @param orderCustomer OrderCustomer对象
     * 
     * @return OrderCustomer实体对象
     */
    public OrderCustomer displayOrderCustomer(OrderCustomer orderCustomer) throws Exception;
  
   /**
     * 查询OrderCustomer列表
     * 
     * @param orderCustomer OrderCustomer对象
     * 
     * @return OrderCustomer列表
     */
    public List<OrderCustomer> queryOrderCustomerList(OrderCustomer orderCustomer) throws Exception;

    /**
     * 获取OrderCustomer主键ID
     */
    public String getOrderCustomerId() throws Exception;
}


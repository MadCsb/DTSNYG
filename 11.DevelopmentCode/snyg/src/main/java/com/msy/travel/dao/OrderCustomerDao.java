package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.OrderCustomer;
/**
 * OrderCustomerDao接口
 * 
 * @author wootide
 * 
 */
public interface OrderCustomerDao
{
    /**
     * 增加OrderCustomer
     * 
     * @param orderCustomer OrderCustomer对象
     */
    void insertOrderCustomer(OrderCustomer orderCustomer) throws Exception;
   
    /**
     * 检查OrderCustomer
     * 
     * @param orderCustomer OrderCustomer对象
     */
    void mergeOrderCustomer(OrderCustomer orderCustomer) throws Exception;
   
    /**
     * 删除OrderCustomer
     * 
     * @param orderCustomer 成语对象
     */
    void deleteOrderCustomer(OrderCustomer orderCustomer) throws Exception;
    
    /**
     * 批量删除OrderCustomer
     * 
     * @param ids ids
     */
    void deleteBatchOrderCustomer(OrderCustomer orderCustomer) throws Exception;  
    
    /**
     * 修改OrderCustomer
     * 
     * @param orderCustomer OrderCustomer对象
     */
    void updateOrderCustomer(OrderCustomer orderCustomer) throws Exception;  
   
    /**
     * 查询单个OrderCustomer信息
     * 
     * @param orderCustomer OrderCustomer对象
     * 
     * @return OrderCustomer实体对象
     */
    OrderCustomer queryOrderCustomer(OrderCustomer orderCustomer) throws Exception;
    
    /**
     * 查询OrderCustomer列表信息
     * 
     * @param orderCustomer OrderCustomer对象
     * 
     * @return OrderCustomer列表
     */
    List<OrderCustomer> queryOrderCustomerList(OrderCustomer orderCustomer) throws Exception;

    /**
     * 获取OrderCustomerID
     */
    String getOrderCustomerId() throws Exception;
}

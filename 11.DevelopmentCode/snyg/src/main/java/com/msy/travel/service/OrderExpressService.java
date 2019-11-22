package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.OrderExpress;

/**
 * OrderExpressService接口
 * 
 * @author wootide
 * 
 */
public interface OrderExpressService
{
    /**
     * 新增OrderExpress
     * 
     * @param orderExpress OrderExpress对象
     */
    public void createOrderExpress(OrderExpress orderExpress) throws Exception;
    
    /**
     * 检查OrderExpress
     * 
     * @param orderExpress OrderExpress对象
     */
    public void mergeOrderExpress(OrderExpress orderExpress) throws Exception;
  
    /**
     * 删除OrderExpress
     * 
     * @param orderExpress OrderExpress对象
     */
    public void deleteOrderExpress(OrderExpress orderExpress) throws Exception;
   
    /**
     * 批量删除OrderExpress
     * 
     * @param orderExpressIdList  存放orderExpress主键的list
     */
    public void deleteBatchOrderExpress(OrderExpress orderExpress) throws Exception;  
    
    /**
     * 修改OrderExpress
     * 
     * @param orderExpress OrderExpress对象
     */
    public void updateOrderExpress(OrderExpress orderExpress) throws Exception;
    
    /**
     * 查询单个OrderExpress
     * 
     * @param orderExpress OrderExpress对象
     * 
     * @return OrderExpress实体对象
     */
    public OrderExpress displayOrderExpress(OrderExpress orderExpress) throws Exception;
  
   /**
     * 查询OrderExpress列表
     * 
     * @param orderExpress OrderExpress对象
     * 
     * @return OrderExpress列表
     */
    public List<OrderExpress> queryOrderExpressList(OrderExpress orderExpress) throws Exception;

    /**
     * 获取OrderExpress主键ID
     */
    public String getOrderExpressId() throws Exception;
}


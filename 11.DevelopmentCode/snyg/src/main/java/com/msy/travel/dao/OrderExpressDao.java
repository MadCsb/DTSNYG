package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.OrderExpress;
/**
 * OrderExpressDao接口
 * 
 * @author wootide
 * 
 */
public interface OrderExpressDao
{
    /**
     * 增加OrderExpress
     * 
     * @param orderExpress OrderExpress对象
     */
    void insertOrderExpress(OrderExpress orderExpress) throws Exception;
   
    /**
     * 检查OrderExpress
     * 
     * @param orderExpress OrderExpress对象
     */
    void mergeOrderExpress(OrderExpress orderExpress) throws Exception;
   
    /**
     * 删除OrderExpress
     * 
     * @param orderExpress 成语对象
     */
    void deleteOrderExpress(OrderExpress orderExpress) throws Exception;
    
    /**
     * 批量删除OrderExpress
     * 
     * @param ids ids
     */
    void deleteBatchOrderExpress(OrderExpress orderExpress) throws Exception;  
    
    /**
     * 修改OrderExpress
     * 
     * @param orderExpress OrderExpress对象
     */
    void updateOrderExpress(OrderExpress orderExpress) throws Exception;  
   
    /**
     * 查询单个OrderExpress信息
     * 
     * @param orderExpress OrderExpress对象
     * 
     * @return OrderExpress实体对象
     */
    OrderExpress queryOrderExpress(OrderExpress orderExpress) throws Exception;
    
    /**
     * 查询OrderExpress列表信息
     * 
     * @param orderExpress OrderExpress对象
     * 
     * @return OrderExpress列表
     */
    List<OrderExpress> queryOrderExpressList(OrderExpress orderExpress) throws Exception;

    /**
     * 获取OrderExpressID
     */
    String getOrderExpressId() throws Exception;
}

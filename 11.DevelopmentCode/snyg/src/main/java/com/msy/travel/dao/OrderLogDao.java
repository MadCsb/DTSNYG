package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.OrderLog;
/**
 * OrderLogDao接口
 * 
 * @author wootide
 * 
 */
public interface OrderLogDao
{
    /**
     * 增加OrderLog
     * 
     * @param orderLog OrderLog对象
     */
    void insertOrderLog(OrderLog orderLog) throws Exception;
   
    /**
     * 检查OrderLog
     * 
     * @param orderLog OrderLog对象
     */
    void mergeOrderLog(OrderLog orderLog) throws Exception;
   
    /**
     * 删除OrderLog
     * 
     * @param orderLog 成语对象
     */
    void deleteOrderLog(OrderLog orderLog) throws Exception;
    
    /**
     * 批量删除OrderLog
     * 
     * @param ids ids
     */
    void deleteBatchOrderLog(OrderLog orderLog) throws Exception;  
    
    /**
     * 修改OrderLog
     * 
     * @param orderLog OrderLog对象
     */
    void updateOrderLog(OrderLog orderLog) throws Exception;  
   
    /**
     * 查询单个OrderLog信息
     * 
     * @param orderLog OrderLog对象
     * 
     * @return OrderLog实体对象
     */
    OrderLog queryOrderLog(OrderLog orderLog) throws Exception;
    
    /**
     * 查询OrderLog列表信息
     * 
     * @param orderLog OrderLog对象
     * 
     * @return OrderLog列表
     */
    List<OrderLog> queryOrderLogList(OrderLog orderLog) throws Exception;

    /**
     * 获取OrderLogID
     */
    String getOrderLogId() throws Exception;
}

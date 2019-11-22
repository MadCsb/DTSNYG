package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.OrderLog;

/**
 * OrderLogService接口
 * 
 * @author wootide
 * 
 */
public interface OrderLogService
{
    /**
     * 新增OrderLog
     * 
     * @param orderLog OrderLog对象
     */
    public void createOrderLog(OrderLog orderLog) throws Exception;
    
    /**
     * 检查OrderLog
     * 
     * @param orderLog OrderLog对象
     */
    public void mergeOrderLog(OrderLog orderLog) throws Exception;
  
    /**
     * 删除OrderLog
     * 
     * @param orderLog OrderLog对象
     */
    public void deleteOrderLog(OrderLog orderLog) throws Exception;
   
    /**
     * 批量删除OrderLog
     * 
     * @param orderLogIdList  存放orderLog主键的list
     */
    public void deleteBatchOrderLog(OrderLog orderLog) throws Exception;  
    
    /**
     * 修改OrderLog
     * 
     * @param orderLog OrderLog对象
     */
    public void updateOrderLog(OrderLog orderLog) throws Exception;
    
    /**
     * 查询单个OrderLog
     * 
     * @param orderLog OrderLog对象
     * 
     * @return OrderLog实体对象
     */
    public OrderLog displayOrderLog(OrderLog orderLog) throws Exception;
  
   /**
     * 查询OrderLog列表
     * 
     * @param orderLog OrderLog对象
     * 
     * @return OrderLog列表
     */
    public List<OrderLog> queryOrderLogList(OrderLog orderLog) throws Exception;

    /**
     * 获取OrderLog主键ID
     */
    public String getOrderLogId() throws Exception;
}


package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.OrderBack;
/**
 * OrderBackDao接口
 * 
 * @author wootide
 * 
 */
public interface OrderBackDao
{
    /**
     * 增加OrderBack
     * 
     * @param orderBack OrderBack对象
     */
    void insertOrderBack(OrderBack orderBack) throws Exception;
   
    /**
     * 检查OrderBack
     * 
     * @param orderBack OrderBack对象
     */
    void mergeOrderBack(OrderBack orderBack) throws Exception;
   
    /**
     * 删除OrderBack
     * 
     * @param orderBack 成语对象
     */
    void deleteOrderBack(OrderBack orderBack) throws Exception;
    
    /**
     * 批量删除OrderBack
     * 
     * @param ids ids
     */
    void deleteBatchOrderBack(OrderBack orderBack) throws Exception;  
    
    /**
     * 修改OrderBack
     * 
     * @param orderBack OrderBack对象
     */
    void updateOrderBack(OrderBack orderBack) throws Exception;  
   
    /**
     * 查询单个OrderBack信息
     * 
     * @param orderBack OrderBack对象
     * 
     * @return OrderBack实体对象
     */
    OrderBack queryOrderBack(OrderBack orderBack) throws Exception;
    
    /**
     * 查询OrderBack列表信息
     * 
     * @param orderBack OrderBack对象
     * 
     * @return OrderBack列表
     */
    List<OrderBack> queryOrderBackList(OrderBack orderBack) throws Exception;

    /**
     * 查询OrderBack统计信息
     *
     * @param orderBack OrderBack对象
     *
     * @return OrderBack列表
     */
    OrderBack queryOrderBackListStatic(OrderBack orderBack) throws Exception;


    /**
     * 获取OrderBackID
     */
    String getOrderBackId() throws Exception;
}

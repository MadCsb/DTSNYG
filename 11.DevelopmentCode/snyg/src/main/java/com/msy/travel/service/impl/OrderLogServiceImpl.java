package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.OrderLog;
import com.msy.travel.dao.OrderLogDao;
import com.msy.travel.service.OrderLogService;

/**
 * OrderLogService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class OrderLogServiceImpl implements OrderLogService
{

	@Resource(name="orderLogDao")
    private OrderLogDao orderLogDao;
    
    /**
     * 新增OrderLog
     * 
     * @param orderLog OrderLog对象
     */
    public void createOrderLog(OrderLog orderLog) throws Exception
    {
        orderLogDao.insertOrderLog(orderLog);
    }
    /**
     * 检查OrderLog
     * 
     * @param orderLog OrderLog对象
     */
    public void mergeOrderLog(OrderLog orderLog) throws Exception
    {
    	orderLogDao.mergeOrderLog(orderLog);
    }
    /**
     * 删除OrderLog
     * 
     * @param orderLog OrderLog对象
     */
    public void deleteOrderLog(OrderLog orderLog) throws Exception
    {
        orderLogDao.deleteOrderLog(orderLog);
    }
   
    /**
     * 修改OrderLog
     * 
     * @param orderLog OrderLog对象
     */
    public void updateOrderLog(OrderLog orderLog) throws Exception
    {
        orderLogDao.updateOrderLog(orderLog);
    }
    /**
     * 批量删除OrderLog
     * 
     * @param orderLogIdList 存放orderLog主键的list
     */
    public void deleteBatchOrderLog(OrderLog orderLog) throws Exception
    {
    	orderLogDao.deleteBatchOrderLog(orderLog);
    }  
    /**
     * 查询单个OrderLog
     * 
     * @param orderLog OrderLog对象
     * 
     * @return 成员实体对象
     */
    public OrderLog displayOrderLog(OrderLog orderLog) throws Exception
    {
        return orderLogDao.queryOrderLog(orderLog);
    }

    /**
     * 查询OrderLog列表
     * 
     * @param orderLog OrderLog对象
     * 
     * @return OrderLog列表
     */
    public List<OrderLog> queryOrderLogList(OrderLog orderLog) throws Exception
    {
        return orderLogDao.queryOrderLogList(orderLog);
    }

    /**
     * 获取OrderLogID
     */
    public String getOrderLogId() throws Exception
    {
    	return orderLogDao.getOrderLogId();
    }
}

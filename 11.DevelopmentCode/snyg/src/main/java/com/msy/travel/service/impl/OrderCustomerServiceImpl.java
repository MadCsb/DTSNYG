package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.OrderCustomer;
import com.msy.travel.dao.OrderCustomerDao;
import com.msy.travel.service.OrderCustomerService;

/**
 * OrderCustomerService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class OrderCustomerServiceImpl implements OrderCustomerService
{

	@Resource(name="orderCustomerDao")
    private OrderCustomerDao orderCustomerDao;
    
    /**
     * 新增OrderCustomer
     * 
     * @param orderCustomer OrderCustomer对象
     */
    public void createOrderCustomer(OrderCustomer orderCustomer) throws Exception
    {
        orderCustomerDao.insertOrderCustomer(orderCustomer);
    }
    /**
     * 检查OrderCustomer
     * 
     * @param orderCustomer OrderCustomer对象
     */
    public void mergeOrderCustomer(OrderCustomer orderCustomer) throws Exception
    {
    	orderCustomerDao.mergeOrderCustomer(orderCustomer);
    }
    /**
     * 删除OrderCustomer
     * 
     * @param orderCustomer OrderCustomer对象
     */
    public void deleteOrderCustomer(OrderCustomer orderCustomer) throws Exception
    {
        orderCustomerDao.deleteOrderCustomer(orderCustomer);
    }
   
    /**
     * 修改OrderCustomer
     * 
     * @param orderCustomer OrderCustomer对象
     */
    public void updateOrderCustomer(OrderCustomer orderCustomer) throws Exception
    {
        orderCustomerDao.updateOrderCustomer(orderCustomer);
    }
    /**
     * 批量删除OrderCustomer
     * 
     * @param orderCustomerIdList 存放orderCustomer主键的list
     */
    public void deleteBatchOrderCustomer(OrderCustomer orderCustomer) throws Exception
    {
    	orderCustomerDao.deleteBatchOrderCustomer(orderCustomer);
    }  
    /**
     * 查询单个OrderCustomer
     * 
     * @param orderCustomer OrderCustomer对象
     * 
     * @return 成员实体对象
     */
    public OrderCustomer displayOrderCustomer(OrderCustomer orderCustomer) throws Exception
    {
        return orderCustomerDao.queryOrderCustomer(orderCustomer);
    }

    /**
     * 查询OrderCustomer列表
     * 
     * @param orderCustomer OrderCustomer对象
     * 
     * @return OrderCustomer列表
     */
    public List<OrderCustomer> queryOrderCustomerList(OrderCustomer orderCustomer) throws Exception
    {
        return orderCustomerDao.queryOrderCustomerList(orderCustomer);
    }

    /**
     * 获取OrderCustomerID
     */
    public String getOrderCustomerId() throws Exception
    {
    	return orderCustomerDao.getOrderCustomerId();
    }
}

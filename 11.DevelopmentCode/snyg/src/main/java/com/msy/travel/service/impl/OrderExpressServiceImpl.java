package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.OrderExpress;
import com.msy.travel.dao.OrderExpressDao;
import com.msy.travel.service.OrderExpressService;

/**
 * OrderExpressService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class OrderExpressServiceImpl implements OrderExpressService
{

	@Resource(name="orderExpressDao")
    private OrderExpressDao orderExpressDao;
    
    /**
     * 新增OrderExpress
     * 
     * @param orderExpress OrderExpress对象
     */
    public void createOrderExpress(OrderExpress orderExpress) throws Exception
    {
        orderExpressDao.insertOrderExpress(orderExpress);
    }
    /**
     * 检查OrderExpress
     * 
     * @param orderExpress OrderExpress对象
     */
    public void mergeOrderExpress(OrderExpress orderExpress) throws Exception
    {
    	orderExpressDao.mergeOrderExpress(orderExpress);
    }
    /**
     * 删除OrderExpress
     * 
     * @param orderExpress OrderExpress对象
     */
    public void deleteOrderExpress(OrderExpress orderExpress) throws Exception
    {
        orderExpressDao.deleteOrderExpress(orderExpress);
    }
   
    /**
     * 修改OrderExpress
     * 
     * @param orderExpress OrderExpress对象
     */
    public void updateOrderExpress(OrderExpress orderExpress) throws Exception
    {
        orderExpressDao.updateOrderExpress(orderExpress);
    }
    /**
     * 批量删除OrderExpress
     * 
     * @param orderExpressIdList 存放orderExpress主键的list
     */
    public void deleteBatchOrderExpress(OrderExpress orderExpress) throws Exception
    {
    	orderExpressDao.deleteBatchOrderExpress(orderExpress);
    }  
    /**
     * 查询单个OrderExpress
     * 
     * @param orderExpress OrderExpress对象
     * 
     * @return 成员实体对象
     */
    public OrderExpress displayOrderExpress(OrderExpress orderExpress) throws Exception
    {
        return orderExpressDao.queryOrderExpress(orderExpress);
    }

    /**
     * 查询OrderExpress列表
     * 
     * @param orderExpress OrderExpress对象
     * 
     * @return OrderExpress列表
     */
    public List<OrderExpress> queryOrderExpressList(OrderExpress orderExpress) throws Exception
    {
        return orderExpressDao.queryOrderExpressList(orderExpress);
    }

    /**
     * 获取OrderExpressID
     */
    public String getOrderExpressId() throws Exception
    {
    	return orderExpressDao.getOrderExpressId();
    }
}

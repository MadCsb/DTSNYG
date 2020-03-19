package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.CustomerCoupon;
import com.msy.travel.dao.CustomerCouponDao;
import com.msy.travel.service.CustomerCouponService;

/**
 * CustomerCouponService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class CustomerCouponServiceImpl implements CustomerCouponService
{

	@Resource(name="customerCouponDao")
    private CustomerCouponDao customerCouponDao;
    
    /**
     * 新增CustomerCoupon
     * 
     * @param customerCoupon CustomerCoupon对象
     */
    public void createCustomerCoupon(CustomerCoupon customerCoupon) throws Exception
    {
        customerCouponDao.insertCustomerCoupon(customerCoupon);
    }
    /**
     * 检查CustomerCoupon
     * 
     * @param customerCoupon CustomerCoupon对象
     */
    public void mergeCustomerCoupon(CustomerCoupon customerCoupon) throws Exception
    {
    	customerCouponDao.mergeCustomerCoupon(customerCoupon);
    }
    /**
     * 删除CustomerCoupon
     * 
     * @param customerCoupon CustomerCoupon对象
     */
    public void deleteCustomerCoupon(CustomerCoupon customerCoupon) throws Exception
    {
        customerCouponDao.deleteCustomerCoupon(customerCoupon);
    }
   
    /**
     * 修改CustomerCoupon
     * 
     * @param customerCoupon CustomerCoupon对象
     */
    public void updateCustomerCoupon(CustomerCoupon customerCoupon) throws Exception
    {
        customerCouponDao.updateCustomerCoupon(customerCoupon);
    }
    /**
     * 批量删除CustomerCoupon
     * 
     * @param customerCouponIdList 存放customerCoupon主键的list
     */
    public void deleteBatchCustomerCoupon(CustomerCoupon customerCoupon) throws Exception
    {
    	customerCouponDao.deleteBatchCustomerCoupon(customerCoupon);
    }  
    /**
     * 查询单个CustomerCoupon
     * 
     * @param customerCoupon CustomerCoupon对象
     * 
     * @return 成员实体对象
     */
    public CustomerCoupon displayCustomerCoupon(CustomerCoupon customerCoupon) throws Exception
    {
        return customerCouponDao.queryCustomerCoupon(customerCoupon);
    }

    /**
     * 查询CustomerCoupon列表
     * 
     * @param customerCoupon CustomerCoupon对象
     * 
     * @return CustomerCoupon列表
     */
    public List<CustomerCoupon> queryCustomerCouponList(CustomerCoupon customerCoupon) throws Exception
    {
        return customerCouponDao.queryCustomerCouponList(customerCoupon);
    }

    /**
     * 获取CustomerCouponID
     */
    public String getCustomerCouponId() throws Exception
    {
    	return customerCouponDao.getCustomerCouponId();
    }
}

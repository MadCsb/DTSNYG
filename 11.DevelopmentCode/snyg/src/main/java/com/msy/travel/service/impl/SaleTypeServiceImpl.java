package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.SaleType;
import com.msy.travel.dao.SaleTypeDao;
import com.msy.travel.service.SaleTypeService;

/**
 * SaleTypeService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class SaleTypeServiceImpl implements SaleTypeService
{

	@Resource(name="saleTypeDao")
    private SaleTypeDao saleTypeDao;
    
    /**
     * 新增SaleType
     * 
     * @param saleType SaleType对象
     */
    public void createSaleType(SaleType saleType) throws Exception
    {
        saleTypeDao.insertSaleType(saleType);
    }
    /**
     * 检查SaleType
     * 
     * @param saleType SaleType对象
     */
    public void mergeSaleType(SaleType saleType) throws Exception
    {
    	saleTypeDao.mergeSaleType(saleType);
    }
    /**
     * 删除SaleType
     * 
     * @param saleType SaleType对象
     */
    public void deleteSaleType(SaleType saleType) throws Exception
    {
        saleTypeDao.deleteSaleType(saleType);
    }
   
    /**
     * 修改SaleType
     * 
     * @param saleType SaleType对象
     */
    public void updateSaleType(SaleType saleType) throws Exception
    {
        saleTypeDao.updateSaleType(saleType);
    }
    /**
     * 批量删除SaleType
     * 
     * @param saleTypeIdList 存放saleType主键的list
     */
    public void deleteBatchSaleType(SaleType saleType) throws Exception
    {
    	saleTypeDao.deleteBatchSaleType(saleType);
    }  
    /**
     * 查询单个SaleType
     * 
     * @param saleType SaleType对象
     * 
     * @return 成员实体对象
     */
    public SaleType displaySaleType(SaleType saleType) throws Exception
    {
        return saleTypeDao.querySaleType(saleType);
    }

    /**
     * 查询SaleType列表
     * 
     * @param saleType SaleType对象
     * 
     * @return SaleType列表
     */
    public List<SaleType> querySaleTypeList(SaleType saleType) throws Exception
    {
        return saleTypeDao.querySaleTypeList(saleType);
    }

    /**
     * 获取SaleTypeID
     */
    public String getSaleTypeId() throws Exception
    {
    	return saleTypeDao.getSaleTypeId();
    }
}

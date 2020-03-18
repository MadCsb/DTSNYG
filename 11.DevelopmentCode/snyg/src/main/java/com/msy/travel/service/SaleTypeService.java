package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.SaleType;

/**
 * SaleTypeService接口
 * 
 * @author wootide
 * 
 */
public interface SaleTypeService
{
    /**
     * 新增SaleType
     * 
     * @param saleType SaleType对象
     */
    public void createSaleType(SaleType saleType) throws Exception;
    
    /**
     * 检查SaleType
     * 
     * @param saleType SaleType对象
     */
    public void mergeSaleType(SaleType saleType) throws Exception;
  
    /**
     * 删除SaleType
     * 
     * @param saleType SaleType对象
     */
    public void deleteSaleType(SaleType saleType) throws Exception;
   
    /**
     * 批量删除SaleType
     * 
     * @param saleTypeIdList  存放saleType主键的list
     */
    public void deleteBatchSaleType(SaleType saleType) throws Exception;  
    
    /**
     * 修改SaleType
     * 
     * @param saleType SaleType对象
     */
    public void updateSaleType(SaleType saleType) throws Exception;
    
    /**
     * 查询单个SaleType
     * 
     * @param saleType SaleType对象
     * 
     * @return SaleType实体对象
     */
    public SaleType displaySaleType(SaleType saleType) throws Exception;
  
   /**
     * 查询SaleType列表
     * 
     * @param saleType SaleType对象
     * 
     * @return SaleType列表
     */
    public List<SaleType> querySaleTypeList(SaleType saleType) throws Exception;

    /**
     * 获取SaleType主键ID
     */
    public String getSaleTypeId() throws Exception;
}


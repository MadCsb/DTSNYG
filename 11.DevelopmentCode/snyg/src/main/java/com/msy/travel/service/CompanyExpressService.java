package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.CompanyExpress;

/**
 * CompanyExpressService接口
 * 
 * @author wootide
 * 
 */
public interface CompanyExpressService
{
    /**
     * 新增CompanyExpress
     * 
     * @param companyExpress CompanyExpress对象
     */
    public void createCompanyExpress(CompanyExpress companyExpress) throws Exception;
    
    /**
     * 检查CompanyExpress
     * 
     * @param companyExpress CompanyExpress对象
     */
    public void mergeCompanyExpress(CompanyExpress companyExpress) throws Exception;
  
    /**
     * 删除CompanyExpress
     * 
     * @param companyExpress CompanyExpress对象
     */
    public void deleteCompanyExpress(CompanyExpress companyExpress) throws Exception;
   
    /**
     * 批量删除CompanyExpress
     * 
     * @param companyExpressIdList  存放companyExpress主键的list
     */
    public void deleteBatchCompanyExpress(CompanyExpress companyExpress) throws Exception;  
    
    /**
     * 修改CompanyExpress
     * 
     * @param companyExpress CompanyExpress对象
     */
    public void updateCompanyExpress(CompanyExpress companyExpress) throws Exception;
    
    /**
     * 查询单个CompanyExpress
     * 
     * @param companyExpress CompanyExpress对象
     * 
     * @return CompanyExpress实体对象
     */
    public CompanyExpress displayCompanyExpress(CompanyExpress companyExpress) throws Exception;
  
   /**
     * 查询CompanyExpress列表
     * 
     * @param companyExpress CompanyExpress对象
     * 
     * @return CompanyExpress列表
     */
    public List<CompanyExpress> queryCompanyExpressList(CompanyExpress companyExpress) throws Exception;

    /**
     * 获取CompanyExpress主键ID
     */
    public String getCompanyExpressId() throws Exception;
}


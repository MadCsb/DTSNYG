package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.CompanyExpress;
import com.msy.travel.dao.CompanyExpressDao;
import com.msy.travel.service.CompanyExpressService;

/**
 * CompanyExpressService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class CompanyExpressServiceImpl implements CompanyExpressService
{

	@Resource(name="companyExpressDao")
    private CompanyExpressDao companyExpressDao;
    
    /**
     * 新增CompanyExpress
     * 
     * @param companyExpress CompanyExpress对象
     */
    public void createCompanyExpress(CompanyExpress companyExpress) throws Exception
    {
        companyExpressDao.insertCompanyExpress(companyExpress);
    }
    /**
     * 检查CompanyExpress
     * 
     * @param companyExpress CompanyExpress对象
     */
    public void mergeCompanyExpress(CompanyExpress companyExpress) throws Exception
    {
    	companyExpressDao.mergeCompanyExpress(companyExpress);
    }
    /**
     * 删除CompanyExpress
     * 
     * @param companyExpress CompanyExpress对象
     */
    public void deleteCompanyExpress(CompanyExpress companyExpress) throws Exception
    {
        companyExpressDao.deleteCompanyExpress(companyExpress);
    }
   
    /**
     * 修改CompanyExpress
     * 
     * @param companyExpress CompanyExpress对象
     */
    public void updateCompanyExpress(CompanyExpress companyExpress) throws Exception
    {
        companyExpressDao.updateCompanyExpress(companyExpress);
    }
    /**
     * 批量删除CompanyExpress
     * 
     * @param companyExpressIdList 存放companyExpress主键的list
     */
    public void deleteBatchCompanyExpress(CompanyExpress companyExpress) throws Exception
    {
    	companyExpressDao.deleteBatchCompanyExpress(companyExpress);
    }  
    /**
     * 查询单个CompanyExpress
     * 
     * @param companyExpress CompanyExpress对象
     * 
     * @return 成员实体对象
     */
    public CompanyExpress displayCompanyExpress(CompanyExpress companyExpress) throws Exception
    {
        return companyExpressDao.queryCompanyExpress(companyExpress);
    }

    /**
     * 查询CompanyExpress列表
     * 
     * @param companyExpress CompanyExpress对象
     * 
     * @return CompanyExpress列表
     */
    public List<CompanyExpress> queryCompanyExpressList(CompanyExpress companyExpress) throws Exception
    {
        return companyExpressDao.queryCompanyExpressList(companyExpress);
    }

    /**
     * 获取CompanyExpressID
     */
    public String getCompanyExpressId() throws Exception
    {
    	return companyExpressDao.getCompanyExpressId();
    }
}

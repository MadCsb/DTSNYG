package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.Company;
import com.msy.travel.pojo.User;

/**
 * CompanyService接口
 * 
 * @author wootide
 * 
 */
public interface CompanyService {
	/**
	 * 新增Company
	 * 
	 * @param company
	 *            Company对象
	 */
	public void createCompany(Company company, User user) throws Exception;

	/**
	 * 检查Company
	 * 
	 * @param company
	 *            Company对象
	 */
	public void mergeCompany(Company company) throws Exception;

	/**
	 * 删除Company
	 * 
	 * @param company
	 *            Company对象
	 */
	public void deleteCompany(Company company) throws Exception;

	/**
	 * 批量删除Company
	 * 
	 * @param companyIdList
	 *            存放company主键的list
	 */
	public void deleteBatchCompany(Company company) throws Exception;

	/**
	 * 修改Company
	 * 
	 * @param company
	 *            Company对象
	 */
	public void updateCompany(Company company, User user) throws Exception;

	/**
	 * 查询单个Company
	 * 
	 * @param company
	 *            Company对象
	 * 
	 * @return Company实体对象
	 */
	public Company displayCompany(Company company) throws Exception;

	/**
	 * 查询Company列表
	 * 
	 * @param company
	 *            Company对象
	 * 
	 * @return Company列表
	 */
	public List<Company> queryCompanyList(Company company) throws Exception;

	/**
	 * 获取Company主键ID
	 */
	public String getCompanyId() throws Exception;

	/**
	 * 根据商家名称检索条数
	 * 
	 * @param company
	 * @return
	 * @throws Exception
	 */
	public int getCountByVenName(Company company) throws Exception;

	/**
	 * 根据COMPANYID列表查Company
	 * 
	 * @author Gengb
	 * @date 2019年2月27日 下午3:04:06
	 * @param company
	 * @throws Exception
	 * @return List<Company>
	 */
	List<Company> queryCompanyListByIdList(Company company) throws Exception;

	/**
	 * 修改Company
	 * 
	 * @param company
	 *            Company对象
	 */
	public void updateCompany(Company company) throws Exception;
}

package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.Company;

/**
 * CompanyDao接口
 * 
 * @author wootide
 * 
 */
public interface CompanyDao {
	/**
	 * 增加Company
	 * 
	 * @param company
	 *            Company对象
	 */
	void insertCompany(Company company) throws Exception;

	/**
	 * 检查Company
	 * 
	 * @param company
	 *            Company对象
	 */
	void mergeCompany(Company company) throws Exception;

	/**
	 * 删除Company
	 * 
	 * @param company
	 *            成语对象
	 */
	void deleteCompany(Company company) throws Exception;

	/**
	 * 批量删除Company
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchCompany(Company company) throws Exception;

	/**
	 * 修改Company
	 * 
	 * @param company
	 *            Company对象
	 */
	void updateCompany(Company company) throws Exception;

	/**
	 * 查询单个Company信息
	 * 
	 * @param company
	 *            Company对象
	 * 
	 * @return Company实体对象
	 */
	Company queryCompany(Company company) throws Exception;

	/**
	 * 查询Company列表信息
	 * 
	 * @param company
	 *            Company对象
	 * 
	 * @return Company列表
	 */
	List<Company> queryCompanyList(Company company) throws Exception;

	/**
	 * 获取CompanyID
	 */
	String getCompanyId() throws Exception;

	/**
	 * 根据商家名称检索条数
	 * 
	 * @param company
	 * @return
	 * @throws Exception
	 */
	int getCountByVenName(Company company) throws Exception;

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
}

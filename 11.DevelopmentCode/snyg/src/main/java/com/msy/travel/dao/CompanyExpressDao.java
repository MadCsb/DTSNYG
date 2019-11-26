package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.CompanyExpress;

/**
 * CompanyExpressDao接口
 * 
 * @author wootide
 * 
 */
public interface CompanyExpressDao {
	/**
	 * 增加CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 */
	void insertCompanyExpress(CompanyExpress companyExpress) throws Exception;

	/**
	 * 检查CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 */
	void mergeCompanyExpress(CompanyExpress companyExpress) throws Exception;

	/**
	 * 删除CompanyExpress
	 * 
	 * @param companyExpress
	 *            成语对象
	 */
	void deleteCompanyExpress(CompanyExpress companyExpress) throws Exception;

	/**
	 * 批量删除CompanyExpress
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchCompanyExpress(CompanyExpress companyExpress) throws Exception;

	/**
	 * 修改CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 */
	void updateCompanyExpress(CompanyExpress companyExpress) throws Exception;

	/**
	 * 查询单个CompanyExpress信息
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 * 
	 * @return CompanyExpress实体对象
	 */
	CompanyExpress queryCompanyExpress(CompanyExpress companyExpress) throws Exception;

	/**
	 * 查询CompanyExpress列表信息
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 * 
	 * @return CompanyExpress列表
	 */
	List<CompanyExpress> queryCompanyExpressList(CompanyExpress companyExpress) throws Exception;

	/**
	 * 获取CompanyExpressID
	 */
	String getCompanyExpressId() throws Exception;

	/**
	 * 获取重名
	 * 
	 * @author wzd
	 * @date 2019年11月26日 下午3:42:35
	 * @param companyExpress
	 * @return
	 * @throws Exception
	 * @return int
	 */
	int queryCompanyExpressExis(CompanyExpress companyExpress) throws Exception;
}

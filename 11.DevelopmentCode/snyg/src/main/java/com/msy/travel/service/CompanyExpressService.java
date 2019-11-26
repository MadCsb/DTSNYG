package com.msy.travel.service;

import java.util.List;

import com.msy.travel.common.Result;
import com.msy.travel.pojo.CompanyExpress;
import com.msy.travel.pojo.ExpressPrice;

/**
 * CompanyExpressService接口
 * 
 * @author wootide
 * 
 */
public interface CompanyExpressService {
	/**
	 * 新增CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 */
	public void createCompanyExpress(CompanyExpress companyExpress) throws Exception;

	/**
	 * 检查CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 */
	public void mergeCompanyExpress(CompanyExpress companyExpress) throws Exception;

	/**
	 * 删除CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 */
	public void deleteCompanyExpress(CompanyExpress companyExpress) throws Exception;

	/**
	 * 批量删除CompanyExpress
	 * 
	 * @param companyExpressIdList
	 *            存放companyExpress主键的list
	 */
	public void deleteBatchCompanyExpress(CompanyExpress companyExpress) throws Exception;

	/**
	 * 修改CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 */
	public void updateCompanyExpress(CompanyExpress companyExpress) throws Exception;

	/**
	 * 查询单个CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 * 
	 * @return CompanyExpress实体对象
	 */
	public CompanyExpress displayCompanyExpress(CompanyExpress companyExpress) throws Exception;

	/**
	 * 查询CompanyExpress列表
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 * 
	 * @return CompanyExpress列表
	 */
	public List<CompanyExpress> queryCompanyExpressList(CompanyExpress companyExpress) throws Exception;

	/**
	 * 获取CompanyExpress主键ID
	 */
	public String getCompanyExpressId() throws Exception;

	/**
	 * 新增CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 */
	public void createCompanyExpressAndExpressPrice(CompanyExpress companyExpress, ExpressPrice expressPrice) throws Exception;

	/**
	 * 修改
	 * 
	 * @author wzd
	 * @date 2019年11月26日 下午3:34:30
	 * @param companyExpress
	 * @param expressPrice
	 * @throws Exception
	 * @return void
	 */
	public void updateCompanyExpressAndExpressPrice(CompanyExpress companyExpress, ExpressPrice expressPrice) throws Exception;

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
	public int queryCompanyExpressExis(CompanyExpress companyExpress) throws Exception;

	/**
	 * 获得商品价格
	 * 
	 * @author wzd
	 * @date 2019年11月26日 下午4:34:46
	 * @param sellpriceId
	 * @param num
	 * @return
	 * @throws Exception
	 * @return String
	 */
	public Result getCompanyPrice(String priceId, String num, String province);
}

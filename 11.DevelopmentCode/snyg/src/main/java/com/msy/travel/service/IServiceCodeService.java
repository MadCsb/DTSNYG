package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.ServiceCode;

/**
 * ServiceCodeService接口
 * 
 * @author wootide
 * 
 */
public interface IServiceCodeService {
	/**
	 * 新增ServiceCode
	 * 
	 * @param serviceCode
	 *            ServiceCode对象
	 */
	public void createServiceCode(ServiceCode serviceCode) throws Exception;

	/**
	 * 检查ServiceCode
	 * 
	 * @param serviceCode
	 *            ServiceCode对象
	 */
	public void mergeServiceCode(ServiceCode serviceCode) throws Exception;

	/**
	 * 删除ServiceCode
	 * 
	 * @param serviceCode
	 *            ServiceCode对象
	 */
	public void deleteServiceCode(ServiceCode serviceCode) throws Exception;

	/**
	 * 批量删除ServiceCode
	 * 
	 * @param serviceCodeIdList
	 *            存放serviceCode主键的list
	 */
	public void deleteBatchServiceCode(ServiceCode serviceCode) throws Exception;

	/**
	 * 修改ServiceCode
	 * 
	 * @param serviceCode
	 *            ServiceCode对象
	 */
	public void updateServiceCode(ServiceCode serviceCode) throws Exception;

	/**
	 * 查询单个ServiceCode
	 * 
	 * @param serviceCode
	 *            ServiceCode对象
	 * 
	 * @return ServiceCode实体对象
	 */
	public ServiceCode displayServiceCode(ServiceCode serviceCode) throws Exception;

	/**
	 * 查询ServiceCode列表
	 * 
	 * @param serviceCode
	 *            ServiceCode对象
	 * 
	 * @return ServiceCode列表
	 */
	public List<ServiceCode> queryServiceCodeList(ServiceCode serviceCode) throws Exception;

	/**
	 * 获取ServiceCode主键ID
	 */
	public String getServiceCodeId() throws Exception;

	public ServiceCode queryServiceCodeByCustom(ServiceCode serviceCode);

	/**
	 * 根据SPID获取服务号信息
	 * 
	 * @param spId
	 * @return
	 * @throws Exception
	 */
	public ServiceCode getServiceCodeBySpId(String spId) throws Exception;

}

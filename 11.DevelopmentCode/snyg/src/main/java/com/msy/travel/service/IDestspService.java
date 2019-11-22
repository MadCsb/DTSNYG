package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.Destsp;

/**
 * DestspService接口
 * 
 * @author wootide
 * 
 */
public interface IDestspService {
	/**
	 * 新增Destsp
	 * 
	 * @param destsp
	 *            Destsp对象
	 */
	public void createDestsp(Destsp destsp) throws Exception;

	/**
	 * 检查Destsp
	 * 
	 * @param destsp
	 *            Destsp对象
	 */
	public void mergeDestsp(Destsp destsp) throws Exception;

	/**
	 * 删除Destsp
	 * 
	 * @param destsp
	 *            Destsp对象
	 */
	public void deleteDestsp(Destsp destsp) throws Exception;

	/**
	 * 批量删除Destsp
	 * 
	 * @param destspIdList
	 *            存放destsp主键的list
	 */
	public void deleteBatchDestsp(Destsp destsp) throws Exception;

	/**
	 * 修改Destsp
	 * 
	 * @param destsp
	 *            Destsp对象
	 */
	public void updateDestsp(Destsp destsp) throws Exception;

	/**
	 * 查询单个Destsp
	 * 
	 * @param destsp
	 *            Destsp对象
	 * 
	 * @return Destsp实体对象
	 */
	public Destsp displayDestsp(Destsp destsp) throws Exception;

	/**
	 * 查询Destsp列表
	 * 
	 * @param destsp
	 *            Destsp对象
	 * 
	 * @return Destsp列表
	 */
	public List<Destsp> queryDestspList(Destsp destsp) throws Exception;

	/**
	 * 获取Destsp主键ID
	 */
	public String getDestspId() throws Exception;

	/**
	 * 根据支撑商ID获取微信服务号
	 * 
	 * @param spId
	 * @return
	 * @throws Exception
	 */
	public String getWxServiceIdBySpId(String spId) throws Exception;
	
	/**
	 * 根据微信服务号获取支撑商ID
	 * 
	 * @param spId
	 * @return
	 * @throws Exception
	 */
	public String getSpIdByWxServiceId(String wxServiceId) throws Exception;
}

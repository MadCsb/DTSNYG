package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.Price1Ref;

/**
 * Price1RefService接口
 * 
 * @author wootide
 * 
 */
public interface Price1RefService {
	/**
	 * 新增Price1Ref
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 */
	public void createPrice1Ref(Price1Ref price1Ref) throws Exception;

	/**
	 * 检查Price1Ref
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 */
	public void mergePrice1Ref(Price1Ref price1Ref) throws Exception;

	/**
	 * 删除Price1Ref
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 */
	public void deletePrice1Ref(Price1Ref price1Ref) throws Exception;

	/**
	 * 批量删除Price1Ref
	 * 
	 * @param price1RefIdList
	 *            存放price1Ref主键的list
	 */
	public void deleteBatchPrice1Ref(Price1Ref price1Ref) throws Exception;

	/**
	 * 修改Price1Ref
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 */
	public void updatePrice1Ref(Price1Ref price1Ref) throws Exception;

	/**
	 * 查询单个Price1Ref
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 * 
	 * @return Price1Ref实体对象
	 */
	public Price1Ref displayPrice1Ref(Price1Ref price1Ref) throws Exception;

	/**
	 * 查询Price1Ref列表
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 * 
	 * @return Price1Ref列表
	 */
	public List<Price1Ref> queryPrice1RefList(Price1Ref price1Ref) throws Exception;

	/**
	 * 获取Price1Ref主键ID
	 */
	public String getPrice1RefId() throws Exception;

	/**
	 * 查询Price1Ref列表信息
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 * 
	 * @return Price1Ref列表
	 */
	public List<Price1Ref> queryPrice1RefListFowWx(Price1Ref price1Ref) throws Exception;
}

package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.Price1Ref;

/**
 * Price1RefDao接口
 * 
 * @author wootide
 * 
 */
public interface Price1RefDao {
	/**
	 * 增加Price1Ref
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 */
	void insertPrice1Ref(Price1Ref price1Ref) throws Exception;

	/**
	 * 检查Price1Ref
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 */
	void mergePrice1Ref(Price1Ref price1Ref) throws Exception;

	/**
	 * 删除Price1Ref
	 * 
	 * @param price1Ref
	 *            成语对象
	 */
	void deletePrice1Ref(Price1Ref price1Ref) throws Exception;

	/**
	 * 批量删除Price1Ref
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchPrice1Ref(Price1Ref price1Ref) throws Exception;

	/**
	 * 修改Price1Ref
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 */
	void updatePrice1Ref(Price1Ref price1Ref) throws Exception;

	/**
	 * 查询单个Price1Ref信息
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 * 
	 * @return Price1Ref实体对象
	 */
	Price1Ref queryPrice1Ref(Price1Ref price1Ref) throws Exception;

	/**
	 * 查询Price1Ref列表信息
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 * 
	 * @return Price1Ref列表
	 */
	List<Price1Ref> queryPrice1RefList(Price1Ref price1Ref) throws Exception;

	/**
	 * 获取Price1RefID
	 */
	String getPrice1RefId() throws Exception;

	/**
	 * 查询Price1Ref列表信息
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 * 
	 * @return Price1Ref列表
	 */
	List<Price1Ref> queryPrice1RefListFowWx(Price1Ref price1Ref) throws Exception;
}

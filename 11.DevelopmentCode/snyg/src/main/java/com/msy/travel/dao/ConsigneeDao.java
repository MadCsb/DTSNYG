package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.Consignee;

/**
 * ConsigneeDao接口
 * 
 * @author wootide
 * 
 */
public interface ConsigneeDao {
	/**
	 * 增加Consignee
	 * 
	 * @param consignee
	 *            Consignee对象
	 */
	void insertConsignee(Consignee consignee) throws Exception;

	/**
	 * 检查Consignee
	 * 
	 * @param consignee
	 *            Consignee对象
	 */
	void mergeConsignee(Consignee consignee) throws Exception;

	/**
	 * 删除Consignee
	 * 
	 * @param consignee
	 *            成语对象
	 */
	void deleteConsignee(Consignee consignee) throws Exception;

	/**
	 * 批量删除Consignee
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchConsignee(Consignee consignee) throws Exception;

	/**
	 * 修改Consignee
	 * 
	 * @param consignee
	 *            Consignee对象
	 */
	void updateConsignee(Consignee consignee) throws Exception;

	/**
	 * 查询单个Consignee信息
	 * 
	 * @param consignee
	 *            Consignee对象
	 * 
	 * @return Consignee实体对象
	 */
	Consignee queryConsignee(Consignee consignee) throws Exception;

	/**
	 * 查询Consignee列表信息
	 * 
	 * @param consignee
	 *            Consignee对象
	 * 
	 * @return Consignee列表
	 */
	List<Consignee> queryConsigneeList(Consignee consignee) throws Exception;

	/**
	 * 获取ConsigneeID
	 */
	String getConsigneeId() throws Exception;

	void updateConsigneeIsDefault(Consignee consignee) throws Exception;
}

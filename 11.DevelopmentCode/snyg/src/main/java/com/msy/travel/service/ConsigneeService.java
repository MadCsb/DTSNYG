package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.Consignee;

/**
 * ConsigneeService接口
 * 
 * @author wootide
 * 
 */
public interface ConsigneeService {
	/**
	 * 新增Consignee
	 * 
	 * @param consignee
	 *            Consignee对象
	 */
	public void createConsignee(Consignee consignee) throws Exception;

	/**
	 * 检查Consignee
	 * 
	 * @param consignee
	 *            Consignee对象
	 */
	public void mergeConsignee(Consignee consignee) throws Exception;

	/**
	 * 删除Consignee
	 * 
	 * @param consignee
	 *            Consignee对象
	 */
	public void deleteConsignee(Consignee consignee) throws Exception;

	/**
	 * 批量删除Consignee
	 * 
	 * @param consigneeIdList
	 *            存放consignee主键的list
	 */
	public void deleteBatchConsignee(Consignee consignee) throws Exception;

	/**
	 * 修改Consignee
	 * 
	 * @param consignee
	 *            Consignee对象
	 */
	public void updateConsignee(Consignee consignee) throws Exception;

	/**
	 * 查询单个Consignee
	 * 
	 * @param consignee
	 *            Consignee对象
	 * 
	 * @return Consignee实体对象
	 */
	public Consignee displayConsignee(Consignee consignee) throws Exception;

	/**
	 * 查询Consignee列表
	 * 
	 * @param consignee
	 *            Consignee对象
	 * 
	 * @return Consignee列表
	 */
	public List<Consignee> queryConsigneeList(Consignee consignee) throws Exception;

	/**
	 * 获取Consignee主键ID
	 */
	public String getConsigneeId() throws Exception;

	/**
	 * 更新默认信息
	 * 
	 * @author wzd
	 * @date 2019年10月15日 下午7:27:25
	 * @param consignee
	 * @throws Exception
	 * @return void
	 */
	public void updateConsigneeIsDefault(Consignee consignee) throws Exception;

	/**
	 * 微信端新建地址
	 * 
	 * @author wzd
	 * @date 2019年10月18日 下午1:27:48
	 * @param consignee
	 * @throws Exception
	 * @return void
	 */
	public void createConsigneeWx(Consignee consignee) throws Exception;
}

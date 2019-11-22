package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.Shopcart;

/**
 * ShopcartService接口
 * 
 * @author wootide
 * 
 */
public interface ShopcartService {
	/**
	 * 新增Shopcart
	 * 
	 * @param shopcart
	 *            Shopcart对象
	 */
	public void createShopcart(Shopcart shopcart) throws Exception;

	/**
	 * 检查Shopcart
	 * 
	 * @param shopcart
	 *            Shopcart对象
	 */
	public void mergeShopcart(Shopcart shopcart) throws Exception;

	/**
	 * 删除Shopcart
	 * 
	 * @param shopcart
	 *            Shopcart对象
	 */
	public void deleteShopcart(Shopcart shopcart) throws Exception;

	/**
	 * 批量删除Shopcart
	 * 
	 * @param shopcartIdList
	 *            存放shopcart主键的list
	 */
	public void deleteBatchShopcart(Shopcart shopcart) throws Exception;

	/**
	 * 修改Shopcart
	 * 
	 * @param shopcart
	 *            Shopcart对象
	 */
	public void updateShopcart(Shopcart shopcart) throws Exception;

	/**
	 * 查询单个Shopcart
	 * 
	 * @param shopcart
	 *            Shopcart对象
	 * 
	 * @return Shopcart实体对象
	 */
	public Shopcart displayShopcart(Shopcart shopcart) throws Exception;

	/**
	 * 查询Shopcart列表
	 * 
	 * @param shopcart
	 *            Shopcart对象
	 * 
	 * @return Shopcart列表
	 */
	public List<Shopcart> queryShopcartList(Shopcart shopcart) throws Exception;

	/**
	 * 获取Shopcart主键ID
	 */
	public String getShopcartId() throws Exception;

	/**
	 * 新增或修改购物车
	 * 
	 * @author wzd
	 * @date 2019年10月15日 下午2:41:35
	 * @param shopcart
	 * @throws Exception
	 * @return void
	 */
	public void createOrUpdateShopcart(Shopcart shopcart) throws Exception;
}

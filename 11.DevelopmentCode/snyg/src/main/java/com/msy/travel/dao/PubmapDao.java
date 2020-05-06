package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.Pubmap;

/**
 * PubmapDao接口
 * 
 * @author wootide
 * 
 */
public interface PubmapDao {
	/**
	 * 根据类型获得所有的pubmap
	 * 
	 * @param mapType
	 * @return
	 */
	List<Pubmap> getPubmapListByType(String mapType) throws Exception;

	/**
	 * 增加Pubmap
	 *
	 * @param pubmap
	 *
	 */
	void insertPubmap(Pubmap pubmap) throws Exception;

	/**
	 * 修改Pubmap
	 *
	 * @param
	 *
	 */
	void updatePubmap(Pubmap pubmap) throws Exception;

	/**
	 * 删除Pubmap
	 *
	 * @param
	 *
	 */
	void deletePubmap(Pubmap pubmap) throws Exception;

	/**
	 * 批量删除Pubmap
	 *
	 * @param
	 *
	 */
	void deleteBatchPubmap(Pubmap pubmap) throws Exception;

	/**
	 * 查询单个Pubmap信息
	 *
	 * @param pubmap
	 *            Pubmap对象
	 *
	 * @return Pubmap实体对象
	 */
	Pubmap queryPubmap(Pubmap pubmap) throws Exception;

	/**
	 * 查询Pubmap列表信息
	 *
	 * @param pubmap
	 *            Pubmap对象
	 *
	 * @return Pubmap列表
	 */
	List<Pubmap> queryPubmapList(Pubmap pubmap) throws Exception;

	List<Pubmap> getAllDesc();
}

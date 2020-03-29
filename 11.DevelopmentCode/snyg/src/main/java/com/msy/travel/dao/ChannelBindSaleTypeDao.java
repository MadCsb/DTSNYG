package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.ChannelBindSaleType;

/**
 * ChannelBindSaleTypeDao接口
 * 
 * @author wootide
 * 
 */
public interface ChannelBindSaleTypeDao {
	/**
	 * 增加ChannelBindSaleType
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 */
	void insertChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 检查ChannelBindSaleType
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 */
	void mergeChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 删除ChannelBindSaleType
	 * 
	 * @param channelBindSaleType
	 *            成语对象
	 */
	void deleteChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 批量删除ChannelBindSaleType
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 修改ChannelBindSaleType
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 */
	void updateChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 查询单个ChannelBindSaleType信息
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 * 
	 * @return ChannelBindSaleType实体对象
	 */
	ChannelBindSaleType queryChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 查询ChannelBindSaleType列表信息
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 * 
	 * @return ChannelBindSaleType列表
	 */
	List<ChannelBindSaleType> queryChannelBindSaleTypeList(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 获取ChannelBindSaleTypeID
	 */
	String getChannelBindSaleTypeId() throws Exception;

	/**
	 * 通过渠道判断可购买商品范围
	 * 
	 * @author wzd
	 * @date 2020年3月29日 下午4:36:52
	 * @param channelBindSaleType
	 * @return
	 * @throws Exception
	 * @return List<ChannelBindSaleType>
	 */
	List<String> queryChannelBindSaleTypeListByUserId(ChannelBindSaleType channelBindSaleType) throws Exception;
}

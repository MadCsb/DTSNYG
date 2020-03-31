package com.msy.travel.service;

import java.util.List;

import com.msy.travel.common.Result;
import com.msy.travel.pojo.ChannelBindSaleType;
import com.msy.travel.pojo.User;

/**
 * ChannelBindSaleTypeService接口
 * 
 * @author wootide
 * 
 */
public interface ChannelBindSaleTypeService {
	/**
	 * 新增ChannelBindSaleType
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 */
	public void createChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 检查ChannelBindSaleType
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 */
	public void mergeChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 删除ChannelBindSaleType
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 */
	public void deleteChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 批量删除ChannelBindSaleType
	 * 
	 * @param channelBindSaleTypeIdList
	 *            存放channelBindSaleType主键的list
	 */
	public void deleteBatchChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 修改ChannelBindSaleType
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 */
	public void updateChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 查询单个ChannelBindSaleType
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 * 
	 * @return ChannelBindSaleType实体对象
	 */
	public ChannelBindSaleType displayChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 查询ChannelBindSaleType列表
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 * 
	 * @return ChannelBindSaleType列表
	 */
	public List<ChannelBindSaleType> queryChannelBindSaleTypeList(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 获取ChannelBindSaleType主键ID
	 */
	public String getChannelBindSaleTypeId() throws Exception;

	/**
	 * 通过用户判断可 哪些渠道商品
	 * 
	 * @author wzd
	 * @date 2020年3月29日 下午4:28:00
	 * @param user
	 * @return
	 * @throws Exception
	 * @return List<ChannelBindSaleType>
	 */
	public List<String> querySaleTypeByUser(User user) throws Exception;

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
	public List<String> queryChannelBindSaleTypeListByUserId(ChannelBindSaleType channelBindSaleType) throws Exception;

	/**
	 * 保存
	 * 
	 * @author wzd
	 * @date 2020年3月31日 下午3:00:53
	 * @param channelId
	 * @param saleTypeId
	 * @return
	 * @throws Exception
	 * @return Result
	 */
	public Result createChannelBindSaleType(String channelId, String saleTypeId) throws Exception;
}

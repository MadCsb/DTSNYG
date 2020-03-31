package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.channel;

/**
 * channelDao接口
 * 
 * @author wootide
 * 
 */
public interface channelDao {
	/**
	 * 增加channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	void insertchannel(channel channel) throws Exception;

	/**
	 * 检查channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	void mergechannel(channel channel) throws Exception;

	/**
	 * 删除channel
	 * 
	 * @param channel
	 *            成语对象
	 */
	void deletechannel(channel channel) throws Exception;

	/**
	 * 批量删除channel
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchchannel(channel channel) throws Exception;

	/**
	 * 修改channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	void updatechannel(channel channel) throws Exception;

	/**
	 * 查询单个channel信息
	 * 
	 * @param channel
	 *            channel对象
	 * 
	 * @return channel实体对象
	 */
	channel querychannel(channel channel) throws Exception;

	/**
	 * 查询channel列表信息
	 * 
	 * @param channel
	 *            channel对象
	 * 
	 * @return channel列表
	 */
	List<channel> querychannelList(channel channel) throws Exception;

	/**
	 * 获取channelID
	 */
	String getchannelId() throws Exception;

	/**
	 * 判断渠道key
	 * 
	 * @author wzd
	 * @date 2020年3月31日 上午11:10:53
	 * @param channel
	 * @return
	 * @throws Exception
	 * @return int
	 */
	int checkChannelKeyExis(channel channel) throws Exception;
}

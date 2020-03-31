package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.Channel;

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
	void insertchannel(Channel channel) throws Exception;

	/**
	 * 检查channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	void mergechannel(Channel channel) throws Exception;

	/**
	 * 删除channel
	 * 
	 * @param channel
	 *            成语对象
	 */
	void deletechannel(Channel channel) throws Exception;

	/**
	 * 批量删除channel
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchchannel(Channel channel) throws Exception;

	/**
	 * 修改channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	void updatechannel(Channel channel) throws Exception;

	/**
	 * 查询单个channel信息
	 * 
	 * @param channel
	 *            channel对象
	 * 
	 * @return channel实体对象
	 */
	Channel querychannel(Channel channel) throws Exception;

	/**
	 * 查询channel列表信息
	 * 
	 * @param channel
	 *            channel对象
	 * 
	 * @return channel列表
	 */
	List<Channel> querychannelList(Channel channel) throws Exception;

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
	int checkChannelKeyExis(Channel channel) throws Exception;
}

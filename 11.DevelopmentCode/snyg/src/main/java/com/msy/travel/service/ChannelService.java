package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.Channel;

/**
 * channelService接口
 * 
 * @author wootide
 * 
 */
public interface ChannelService {
	/**
	 * 新增channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	public void createchannel(Channel channel) throws Exception;

	/**
	 * 检查channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	public void mergechannel(Channel channel) throws Exception;

	/**
	 * 删除channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	public void deletechannel(Channel channel) throws Exception;

	/**
	 * 批量删除channel
	 * 
	 * @param channelIdList
	 *            存放channel主键的list
	 */
	public void deleteBatchchannel(Channel channel) throws Exception;

	/**
	 * 修改channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	public void updatechannel(Channel channel) throws Exception;

	/**
	 * 查询单个channel
	 * 
	 * @param channel
	 *            channel对象
	 * 
	 * @return channel实体对象
	 */
	public Channel displaychannel(Channel channel) throws Exception;

	/**
	 * 查询channel列表
	 * 
	 * @param channel
	 *            channel对象
	 * 
	 * @return channel列表
	 */
	public List<Channel> querychannelList(Channel channel) throws Exception;

	/**
	 * 获取channel主键ID
	 */
	public String getchannelId() throws Exception;

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
	public int checkChannelKeyExis(Channel channel) throws Exception;

	/**
	 * 通过标识获取渠道
	 * 
	 * @author wzd
	 * @date 2020年4月10日 下午12:59:08
	 * @param channel
	 * @return
	 * @throws Exception
	 * @return Channel
	 */
	public Channel getChannelByChannelKey(String channelKey) throws Exception;

	/**
	 * 获取所有渠道
	 * 
	 * @author wzd
	 * @date 2020年4月12日 下午7:37:13
	 * @param channel
	 * @return
	 * @throws Exception
	 * @return List<Channel>
	 */
	public List<Channel> querychannelListAll() throws Exception;
}

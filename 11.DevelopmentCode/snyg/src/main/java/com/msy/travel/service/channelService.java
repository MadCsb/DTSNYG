package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.channel;

/**
 * channelService接口
 * 
 * @author wootide
 * 
 */
public interface channelService {
	/**
	 * 新增channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	public void createchannel(channel channel) throws Exception;

	/**
	 * 检查channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	public void mergechannel(channel channel) throws Exception;

	/**
	 * 删除channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	public void deletechannel(channel channel) throws Exception;

	/**
	 * 批量删除channel
	 * 
	 * @param channelIdList
	 *            存放channel主键的list
	 */
	public void deleteBatchchannel(channel channel) throws Exception;

	/**
	 * 修改channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	public void updatechannel(channel channel) throws Exception;

	/**
	 * 查询单个channel
	 * 
	 * @param channel
	 *            channel对象
	 * 
	 * @return channel实体对象
	 */
	public channel displaychannel(channel channel) throws Exception;

	/**
	 * 查询channel列表
	 * 
	 * @param channel
	 *            channel对象
	 * 
	 * @return channel列表
	 */
	public List<channel> querychannelList(channel channel) throws Exception;

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
	public int checkChannelKeyExis(channel channel) throws Exception;
}

package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.dao.channelDao;
import com.msy.travel.pojo.Channel;
import com.msy.travel.service.channelService;

/**
 * channelService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class channelServiceImpl implements channelService {

	@Resource(name = "channelDao")
	private channelDao channelDao;

	/**
	 * 新增channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	public void createchannel(Channel channel) throws Exception {
		channelDao.insertchannel(channel);
	}

	/**
	 * 检查channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	public void mergechannel(Channel channel) throws Exception {
		channelDao.mergechannel(channel);
	}

	/**
	 * 删除channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	public void deletechannel(Channel channel) throws Exception {
		channelDao.deletechannel(channel);
	}

	/**
	 * 修改channel
	 * 
	 * @param channel
	 *            channel对象
	 */
	public void updatechannel(Channel channel) throws Exception {
		channelDao.updatechannel(channel);
	}

	/**
	 * 批量删除channel
	 * 
	 * @param channelIdList
	 *            存放channel主键的list
	 */
	public void deleteBatchchannel(Channel channel) throws Exception {
		channelDao.deleteBatchchannel(channel);
	}

	/**
	 * 查询单个channel
	 * 
	 * @param channel
	 *            channel对象
	 * 
	 * @return 成员实体对象
	 */
	public Channel displaychannel(Channel channel) throws Exception {
		return channelDao.querychannel(channel);
	}

	/**
	 * 查询channel列表
	 * 
	 * @param channel
	 *            channel对象
	 * 
	 * @return channel列表
	 */
	public List<Channel> querychannelList(Channel channel) throws Exception {
		return channelDao.querychannelList(channel);
	}

	/**
	 * 获取channelID
	 */
	public String getchannelId() throws Exception {
		return channelDao.getchannelId();
	}

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
	public int checkChannelKeyExis(Channel channel) throws Exception {
		return channelDao.checkChannelKeyExis(channel);
	}
}

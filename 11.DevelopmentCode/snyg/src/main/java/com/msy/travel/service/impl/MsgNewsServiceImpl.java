package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.pojo.MsgNews;
import com.msy.travel.dao.MsgNewsDao;
import com.msy.travel.service.IMsgNewsService;

/**
 * MsgNewsService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class MsgNewsServiceImpl implements IMsgNewsService {

	@Resource(name = "msgNewsDao")
	private MsgNewsDao msgNewsDao;

	/**
	 * 新增MsgNews
	 * 
	 * @param msgNews
	 *            MsgNews对象
	 */
	public void createMsgNews(MsgNews msgNews) throws Exception {
		msgNewsDao.insertMsgNews(msgNews);
	}

	/**
	 * 检查MsgNews
	 * 
	 * @param msgNews
	 *            MsgNews对象
	 */
	public void mergeMsgNews(MsgNews msgNews) throws Exception {
		msgNewsDao.mergeMsgNews(msgNews);
	}

	/**
	 * 删除MsgNews
	 * 
	 * @param msgNews
	 *            MsgNews对象
	 */
	public void deleteMsgNews(MsgNews msgNews) throws Exception {
		msgNewsDao.deleteMsgNews(msgNews);
	}

	/**
	 * 修改MsgNews
	 * 
	 * @param msgNews
	 *            MsgNews对象
	 */
	public void updateMsgNews(MsgNews msgNews) throws Exception {
		msgNewsDao.updateMsgNews(msgNews);
	}

	/**
	 * 批量删除MsgNews
	 * 
	 * @param msgNewsIdList
	 *            存放msgNews主键的list
	 */
	public void deleteBatchMsgNews(MsgNews msgNews) throws Exception {
		msgNewsDao.deleteBatchMsgNews(msgNews);
	}

	/**
	 * 查询单个MsgNews
	 * 
	 * @param msgNews
	 *            MsgNews对象
	 * 
	 * @return 成员实体对象
	 */
	public MsgNews displayMsgNews(MsgNews msgNews) throws Exception {
		return msgNewsDao.queryMsgNews(msgNews);
	}

	/**
	 * 查询MsgNews列表
	 * 
	 * @param msgNews
	 *            MsgNews对象
	 * 
	 * @return MsgNews列表
	 */
	public List<MsgNews> queryMsgNewsList(MsgNews msgNews) throws Exception {
		return msgNewsDao.queryMsgNewsList(msgNews);
	}

	/**
	 * 获取MsgNewsID
	 */
	public String getMsgNewsId() throws Exception {
		return msgNewsDao.getMsgNewsId();
	}

	/**
	 * 根据FeedbackId查找图文消息
	 * 
	 * @param msgNews
	 * @return
	 * @throws Exception
	 */
	public List<MsgNews> getMsgNewsByFeedbackId(MsgNews msgNews)
			throws Exception {
		return msgNewsDao.getMsgNewsByFeedbackId(msgNews);
	}
}

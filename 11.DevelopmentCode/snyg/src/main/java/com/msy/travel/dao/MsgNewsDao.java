package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.MsgNews;
/**
 * MsgNewsDao接口
 * 
 * @author wootide
 * 
 */
public interface MsgNewsDao
{
    /**
     * 增加MsgNews
     * 
     * @param msgNews MsgNews对象
     */
    void insertMsgNews(MsgNews msgNews) throws Exception;
   
    /**
     * 检查MsgNews
     * 
     * @param msgNews MsgNews对象
     */
    void mergeMsgNews(MsgNews msgNews) throws Exception;
   
    /**
     * 删除MsgNews
     * 
     * @param msgNews 成语对象
     */
    void deleteMsgNews(MsgNews msgNews) throws Exception;
    
    /**
     * 批量删除MsgNews
     * 
     * @param ids ids
     */
    void deleteBatchMsgNews(MsgNews msgNews) throws Exception;  
    
    /**
     * 修改MsgNews
     * 
     * @param msgNews MsgNews对象
     */
    void updateMsgNews(MsgNews msgNews) throws Exception;  
   
    /**
     * 查询单个MsgNews信息
     * 
     * @param msgNews MsgNews对象
     * 
     * @return MsgNews实体对象
     */
    MsgNews queryMsgNews(MsgNews msgNews) throws Exception;
    
    /**
     * 查询MsgNews列表信息
     * 
     * @param msgNews MsgNews对象
     * 
     * @return MsgNews列表
     */
    List<MsgNews> queryMsgNewsList(MsgNews msgNews) throws Exception;

    /**
     * 获取MsgNewsID
     */
    String getMsgNewsId() throws Exception;
    
    /**
     * 根据FeedbackId查找图文消息
     * @param msgNews
     * @return
     * @throws Exception
     */
    List<MsgNews> getMsgNewsByFeedbackId(MsgNews msgNews) throws Exception;
}

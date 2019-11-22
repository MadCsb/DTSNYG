package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.MessageLog;
/**
 * MessageLogDao接口
 * 
 * @author wootide
 * 
 */
public interface MessageLogDao
{
    /**
     * 增加MessageLog
     * 
     * @param messageLog MessageLog对象
     */
    void insertMessageLog(MessageLog messageLog) throws Exception;
   
    /**
     * 检查MessageLog
     * 
     * @param messageLog MessageLog对象
     */
    void mergeMessageLog(MessageLog messageLog) throws Exception;
   
    /**
     * 删除MessageLog
     * 
     * @param messageLog 成语对象
     */
    void deleteMessageLog(MessageLog messageLog) throws Exception;
    
    /**
     * 批量删除MessageLog
     * 
     * @param ids ids
     */
    void deleteBatchMessageLog(MessageLog messageLog) throws Exception;  
    
    /**
     * 修改MessageLog
     * 
     * @param messageLog MessageLog对象
     */
    void updateMessageLog(MessageLog messageLog) throws Exception;  
   
    /**
     * 查询单个MessageLog信息
     * 
     * @param messageLog MessageLog对象
     * 
     * @return MessageLog实体对象
     */
    MessageLog queryMessageLog(MessageLog messageLog) throws Exception;
    
    /**
     * 查询MessageLog列表信息
     * 
     * @param messageLog MessageLog对象
     * 
     * @return MessageLog列表
     */
    List<MessageLog> queryMessageLogList(MessageLog messageLog) throws Exception;

    /**
     * 获取MessageLogID
     */
    String getMessageLogId() throws Exception;
}

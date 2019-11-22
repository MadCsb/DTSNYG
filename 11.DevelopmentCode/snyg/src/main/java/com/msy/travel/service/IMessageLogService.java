package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.MessageLog;

/**
 * MessageLogService接口
 * 
 * @author wootide
 * 
 */
public interface IMessageLogService
{
    /**
     * 新增MessageLog
     * 
     * @param messageLog MessageLog对象
     */
    public void createMessageLog(MessageLog messageLog) throws Exception;
    
    /**
     * 检查MessageLog
     * 
     * @param messageLog MessageLog对象
     */
    public void mergeMessageLog(MessageLog messageLog) throws Exception;
  
    /**
     * 删除MessageLog
     * 
     * @param messageLog MessageLog对象
     */
    public void deleteMessageLog(MessageLog messageLog) throws Exception;
   
    /**
     * 批量删除MessageLog
     * 
     * @param messageLogIdList  存放messageLog主键的list
     */
    public void deleteBatchMessageLog(MessageLog messageLog) throws Exception;  
    
    /**
     * 修改MessageLog
     * 
     * @param messageLog MessageLog对象
     */
    public void updateMessageLog(MessageLog messageLog) throws Exception;
    
    /**
     * 查询单个MessageLog
     * 
     * @param messageLog MessageLog对象
     * 
     * @return MessageLog实体对象
     */
    public MessageLog displayMessageLog(MessageLog messageLog) throws Exception;
  
   /**
     * 查询MessageLog列表
     * 
     * @param messageLog MessageLog对象
     * 
     * @return MessageLog列表
     */
    public List<MessageLog> queryMessageLogList(MessageLog messageLog) throws Exception;

    /**
     * 获取MessageLog主键ID
     */
    public String getMessageLogId() throws Exception;
}


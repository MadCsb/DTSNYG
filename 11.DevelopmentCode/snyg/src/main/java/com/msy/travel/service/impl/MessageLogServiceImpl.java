package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.MessageLog;
import com.msy.travel.dao.MessageLogDao;
import com.msy.travel.service.IMessageLogService;

/**
 * MessageLogService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class MessageLogServiceImpl implements IMessageLogService
{

	@Resource(name="messageLogDao")
    private MessageLogDao messageLogDao;
    
    /**
     * 新增MessageLog
     * 
     * @param messageLog MessageLog对象
     */
    public void createMessageLog(MessageLog messageLog) throws Exception
    {
        messageLogDao.insertMessageLog(messageLog);
    }
    /**
     * 检查MessageLog
     * 
     * @param messageLog MessageLog对象
     */
    public void mergeMessageLog(MessageLog messageLog) throws Exception
    {
    	messageLogDao.mergeMessageLog(messageLog);
    }
    /**
     * 删除MessageLog
     * 
     * @param messageLog MessageLog对象
     */
    public void deleteMessageLog(MessageLog messageLog) throws Exception
    {
        messageLogDao.deleteMessageLog(messageLog);
    }
   
    /**
     * 修改MessageLog
     * 
     * @param messageLog MessageLog对象
     */
    public void updateMessageLog(MessageLog messageLog) throws Exception
    {
        messageLogDao.updateMessageLog(messageLog);
    }
    /**
     * 批量删除MessageLog
     * 
     * @param messageLogIdList 存放messageLog主键的list
     */
    public void deleteBatchMessageLog(MessageLog messageLog) throws Exception
    {
    	messageLogDao.deleteBatchMessageLog(messageLog);
    }  
    /**
     * 查询单个MessageLog
     * 
     * @param messageLog MessageLog对象
     * 
     * @return 成员实体对象
     */
    public MessageLog displayMessageLog(MessageLog messageLog) throws Exception
    {
        return messageLogDao.queryMessageLog(messageLog);
    }

    /**
     * 查询MessageLog列表
     * 
     * @param messageLog MessageLog对象
     * 
     * @return MessageLog列表
     */
    public List<MessageLog> queryMessageLogList(MessageLog messageLog) throws Exception
    {
        return messageLogDao.queryMessageLogList(messageLog);
    }

    /**
     * 获取MessageLogID
     */
    public String getMessageLogId() throws Exception
    {
    	return messageLogDao.getMessageLogId();
    }
}

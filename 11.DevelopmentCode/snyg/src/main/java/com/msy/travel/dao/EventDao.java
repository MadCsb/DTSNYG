package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.Event;
/**
 * EventDao接口
 * 
 * @author wootide
 * 
 */
public interface EventDao
{
    /**
     * 增加Event
     * 
     * @param event Event对象
     */
    void insertEvent(Event event) throws Exception;
   
    /**
     * 检查Event
     * 
     * @param event Event对象
     */
    void mergeEvent(Event event) throws Exception;
   
    /**
     * 删除Event
     * 
     * @param event 成语对象
     */
    void deleteEvent(Event event) throws Exception;
    
    /**
     * 批量删除Event
     * 
     * @param ids ids
     */
    void deleteBatchEvent(Event event) throws Exception;  
    
    /**
     * 修改Event
     * 
     * @param event Event对象
     */
    void updateEvent(Event event) throws Exception;  
   
    /**
     * 查询单个Event信息
     * 
     * @param event Event对象
     * 
     * @return Event实体对象
     */
    Event queryEvent(Event event) throws Exception;
    
    /**
     * 查询Event列表信息
     * 
     * @param event Event对象
     * 
     * @return Event列表
     */
    List<Event> queryEventList(Event event) throws Exception;

    /**
     * 获取EventID
     */
    String getEventId() throws Exception;
}

package com.msy.travel.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.msy.travel.common.Result;
import com.msy.travel.pojo.Event;

/**
 * EventService接口
 * 
 * @author wootide
 * 
 */
public interface EventService {
	/**
	 * 新增Event
	 * 
	 * @param event
	 *            Event对象
	 */
	public void createEvent(Event event) throws Exception;

	/**
	 * 检查Event
	 * 
	 * @param event
	 *            Event对象
	 */
	public void mergeEvent(Event event) throws Exception;

	/**
	 * 删除Event
	 * 
	 * @param event
	 *            Event对象
	 */
	public void deleteEvent(Event event) throws Exception;

	/**
	 * 批量删除Event
	 * 
	 * @param eventIdList
	 *            存放event主键的list
	 */
	public void deleteBatchEvent(Event event) throws Exception;

	/**
	 * 修改Event
	 * 
	 * @param event
	 *            Event对象
	 */
	public void updateEvent(Event event) throws Exception;

	/**
	 * 查询单个Event
	 * 
	 * @param event
	 *            Event对象
	 * 
	 * @return Event实体对象
	 */
	public Event displayEvent(Event event) throws Exception;

	/**
	 * 查询Event列表
	 * 
	 * @param event
	 *            Event对象
	 * 
	 * @return Event列表
	 */
	public List<Event> queryEventList(Event event) throws Exception;

	/**
	 * 获取Event主键ID
	 */
	public String getEventId() throws Exception;

	/**
	 * 新增事件
	 * 
	 * @author wzd
	 * @date 2020年5月10日 下午3:19:20
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 * @return Result
	 */
	public Result createNewEvent(JSONObject jsonObject) throws Exception;
}

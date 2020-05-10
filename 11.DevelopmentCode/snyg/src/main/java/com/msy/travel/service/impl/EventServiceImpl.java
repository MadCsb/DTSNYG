package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.Result;
import com.msy.travel.dao.EventDao;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.Event;
import com.msy.travel.service.EventService;

/**
 * EventService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Resource(name = "eventDao")
	private EventDao eventDao;

	/**
	 * 新增Event
	 * 
	 * @param event
	 *            Event对象
	 */
	public void createEvent(Event event) throws Exception {
		eventDao.insertEvent(event);
	}

	/**
	 * 检查Event
	 * 
	 * @param event
	 *            Event对象
	 */
	public void mergeEvent(Event event) throws Exception {
		eventDao.mergeEvent(event);
	}

	/**
	 * 删除Event
	 * 
	 * @param event
	 *            Event对象
	 */
	public void deleteEvent(Event event) throws Exception {
		eventDao.deleteEvent(event);
	}

	/**
	 * 修改Event
	 * 
	 * @param event
	 *            Event对象
	 */
	public void updateEvent(Event event) throws Exception {
		eventDao.updateEvent(event);
	}

	/**
	 * 批量删除Event
	 * 
	 * @param eventIdList
	 *            存放event主键的list
	 */
	public void deleteBatchEvent(Event event) throws Exception {
		eventDao.deleteBatchEvent(event);
	}

	/**
	 * 查询单个Event
	 * 
	 * @param event
	 *            Event对象
	 * 
	 * @return 成员实体对象
	 */
	public Event displayEvent(Event event) throws Exception {
		return eventDao.queryEvent(event);
	}

	/**
	 * 查询Event列表
	 * 
	 * @param event
	 *            Event对象
	 * 
	 * @return Event列表
	 */
	public List<Event> queryEventList(Event event) throws Exception {
		return eventDao.queryEventList(event);
	}

	/**
	 * 获取EventID
	 */
	public String getEventId() throws Exception {
		return eventDao.getEventId();
	}

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
	public Result createNewEvent(JSONObject jsonObject) throws Exception {
		Result result = new Result();
		result.setResultCode("0");

		Event event = new Event();
		event.setEventId(PrimaryKeyUtil.generateKey());
		event.setSpId(Destsp.currentSpId);
		event.setEventKey(jsonObject.getString("eventKey"));
		event.setEventStatus("0");
		event.setCreateTime(DateTimeUtil.getDateTime19());
		event.setTriggerUid(jsonObject.getString("triggerUid"));
		eventDao.insertEvent(event);

		return result;
	}
}

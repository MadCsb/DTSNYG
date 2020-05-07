package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "event")
public class Event extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"eventId:事件ID", "spId:fspid", "eventKey:事件标识", "eventStatus:事件状态0:未完成 1已完成", "createTime:创建时间", "triggerUid:触发人", "feventjson:事件参数"

	};

	/**
	 * 发送指定用户优惠券
	 */
	public static final String EVENT_SEND_COUPON = "EVENT_SEND_COUPON";

	/**
	 * 活动页领取优惠券
	 */
	public static final String EVNET_PAGE_COUPON = "EVNET_PAGE_COUPON";

	/**
	 * 商品页领取优惠券
	 */
	public static final String EVNET_PDC_COUPON = "EVNET_PDC_COUPON";

	/**
	 * 新用户
	 */
	public static final String EVENT_NEWUSER = "EVENT_NEWUSER";

	/**
	 * 支付
	 */
	public static final String EVENT_PAYSUCCESS = "EVENT_PAYSUCCESS";

	// columns START
	/**
	 * 事件ID db_column: F_EVENTID
	 */
	private String eventId;
	/**
	 * fspid db_column: F_SPID
	 */
	private String spId;
	/**
	 * 事件标识 db_column: F_EVENTKEY
	 */
	private String eventKey;
	/**
	 * 事件状态0:未完成 1已完成 db_column: F_EVENTSTATUS
	 */
	private String eventStatus;
	/**
	 * 创建时间 db_column: F_CREATETIME
	 */
	private String createTime;
	/**
	 * 触发人 db_column: F_TRIGGERUID
	 */
	private String triggerUid;
	/**
	 * 事件参数 db_column: F_EVENTJSON
	 */
	private java.lang.String feventjson;
	// columns END
	private List<String> eventIdList;

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventId() {
		return this.eventId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getSpId() {
		return this.spId;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getEventKey() {
		return this.eventKey;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public String getEventStatus() {
		return this.eventStatus;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setTriggerUid(String triggerUid) {
		this.triggerUid = triggerUid;
	}

	public String getTriggerUid() {
		return this.triggerUid;
	}

	public void setFeventjson(java.lang.String feventjson) {
		this.feventjson = feventjson;
	}

	public java.lang.String getFeventjson() {
		return this.feventjson;
	}

	public void setEventIdList(List<String> eventIdList) {
		this.eventIdList = eventIdList;
	}

	public List<String> getEventIdList() {
		return this.eventIdList;
	}

}

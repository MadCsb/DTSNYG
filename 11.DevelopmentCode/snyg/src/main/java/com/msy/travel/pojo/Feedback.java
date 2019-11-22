package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "feedback")
public class Feedback extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"wxServiceId:fwxserviceid", "feedBackId:ffeedbackid",
			"msgName:fmsgname", "title:视频文件标题",
			"magType:0文本、1-图片、2-图文、3-语音、4-视频、5-音乐 7-链接 8-客服消息", "keyWord:以,分隔",
			"keyWord2:以,分隔", "context:fcontext", "mediaId:fmediaid",
			"summary:fsummary", "linkUrl:flinkurl",
			"mediaFileName:fmediafilename", "mediaUrl:fmediaurl",
			"hqMediaUrl:fhqmediaurl", "thumbId:fthumbid", "delFlag:fdelflag",
			"lastUpdate:flastupdate", "fxml:fxml"

	};

	// columns START
	/**
	 * fwxserviceid db_column: F_WXSERVICEID
	 */
	private String wxServiceId;
	/**
	 * ffeedbackid db_column: F_FEEDBACKID
	 */
	private String feedBackId;
	/**
	 * fmsgname db_column: F_MSGNAME
	 */
	private String msgName;
	/**
	 * 视频文件标题 db_column: F_TITLE
	 */
	private String title;
	/**
	 * 0文本、1-图片、2-图文、3-语音、4-视频、5-音乐 7-链接 8-客服消息 db_column: F_MSGTYPE
	 */
	private String msgType;
	/**
	 * 以,分隔 db_column: F_KEYWORD
	 */
	private String keyWord;
	/**
	 * 以,分隔 db_column: F_KEYWORD2
	 */
	private String keyWord2;
	/**
	 * fcontext db_column: F_CONTEXT
	 */
	private String context;
	/**
	 * fmediaid db_column: F_MEDIAID
	 */
	private String mediaId;
	/**
	 * fsummary db_column: F_SUMMARY
	 */
	private String summary;
	/**
	 * flinkurl db_column: F_LINKURL
	 */
	private String linkUrl;
	/**
	 * fmediafilename db_column: F_MEDIAFILENAME
	 */
	private String mediaFileName;
	/**
	 * fmediaurl db_column: F_MEDIAURL
	 */
	private String mediaUrl;
	/**
	 * fhqmediaurl db_column: F_HQMEDIAURL
	 */
	private String hqMediaUrl;
	/**
	 * fthumbid db_column: F_THUMBID
	 */
	private String thumbId;
	/**
	 * fdelflag db_column: F_DELFLAG
	 */
	private String delFlag;
	/**
	 * flastupdate db_column: F_LASTUPDATE
	 */
	private String lastUpdate;
	/**
	 * fxml db_column: F_XML
	 */
	private String fxml;

	private String url;

	private String spId;

	private String newsId;

	private String wxName;

	// columns END
	private List<String> feedbackIdList;

	public void setWxServiceId(String wxServiceId) {
		this.wxServiceId = wxServiceId;
	}

	public String getWxServiceId() {
		return this.wxServiceId;
	}

	public void setFeedBackId(String feedBackId) {
		this.feedBackId = feedBackId;
	}

	public String getFeedBackId() {
		return this.feedBackId;
	}

	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}

	public String getMsgName() {
		return this.msgName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getKeyWord() {
		return this.keyWord;
	}

	public void setKeyWord2(String keyWord2) {
		this.keyWord2 = keyWord2;
	}

	public String getKeyWord2() {
		return this.keyWord2;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getContext() {
		return this.context;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getMediaId() {
		return this.mediaId;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setMediaFileName(String mediaFileName) {
		this.mediaFileName = mediaFileName;
	}

	public String getMediaFileName() {
		return this.mediaFileName;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public String getMediaUrl() {
		return this.mediaUrl;
	}

	public void setHqMediaUrl(String hqMediaUrl) {
		this.hqMediaUrl = hqMediaUrl;
	}

	public String getHqMediaUrl() {
		return this.hqMediaUrl;
	}

	public void setThumbId(String thumbId) {
		this.thumbId = thumbId;
	}

	public String getThumbId() {
		return this.thumbId;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getDelFlag() {
		return this.delFlag;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdate() {
		return this.lastUpdate;
	}

	public void setFxml(String fxml) {
		this.fxml = fxml;
	}

	public String getFxml() {
		return this.fxml;
	}

	public void setFeedbackIdList(List<String> feedbackIdList) {
		this.feedbackIdList = feedbackIdList;
	}

	public List<String> getFeedbackIdList() {
		return this.feedbackIdList;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getWxName() {
		return wxName;
	}

	public void setWxName(String wxName) {
		this.wxName = wxName;
	}
}

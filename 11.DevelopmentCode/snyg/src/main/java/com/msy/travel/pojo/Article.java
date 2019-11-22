package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "article")
public class Article extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"articleId:farticleid", "spId:fspid", "userId:用户ID", "userName:fusername", "type:pub_map             0-旅游咨询1-景点介绍", "title:ftitle", "publishDate:fpublishdate", "context:fcontext",
			"fileName:ffilename", "proLink:fprolink", "picUrl:fpicurl", "isShowApp:是否移动端显示   0否（默认）  1是 "

	};

	// columns START
	/**
	 * farticleid db_column: F_ARTICLEID
	 */
	private String articleId;
	/**
	 * fspid db_column: F_SPID
	 */
	private String spId;
	/**
	 * 用户ID db_column: F_USER_ID
	 */
	private String userId;
	/**
	 * fusername db_column: F_USERNAME
	 */
	private String userName;
	/**
	 * pub_map 0-旅游咨询1-景点介绍 db_column: F_TYPE
	 */
	private String type;
	/**
	 * ftitle db_column: F_TITLE
	 */
	private String title;
	/**
	 * fpublishdate db_column: F_PUBLISHDATE
	 */
	private String publishDate;
	/**
	 * fcontext db_column: F_CONTEXT
	 */
	private String context;
	/**
	 * ffilename db_column: F_FILENAME
	 */
	private String fileName;
	/**
	 * fprolink db_column: F_PROLINK
	 */
	private String proLink;
	/**
	 * fpicurl db_column: F_PICURL
	 */
	private String picUrl;
	/**
	 * 是否移动端显示 0否（默认） 1是 db_column: F_ISSHOWAPP
	 */
	private String isShowApp;
	/**
	 * 删除标识：0未删除；1删除 db_column: F_DELFLAG
	 */
	private String delFlag;
	// columns END
	private List<String> articleIdList;

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getArticleId() {
		return this.articleId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getSpId() {
		return this.spId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublishDate() {
		return this.publishDate;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getContext() {
		return this.context;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setProLink(String proLink) {
		this.proLink = proLink;
	}

	public String getProLink() {
		return this.proLink;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setIsShowApp(String isShowApp) {
		this.isShowApp = isShowApp;
	}

	public String getIsShowApp() {
		return this.isShowApp;
	}

	public void setArticleIdList(List<String> articleIdList) {
		this.articleIdList = articleIdList;
	}

	public List<String> getArticleIdList() {
		return this.articleIdList;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}

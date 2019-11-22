
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "subject")
public class Subject extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "subjectId:主题ID"
          ,
          "subject:主题名称"
          ,
          "spId:运营商ID"
          
        };
	
	//columns START
    /**
     * 主题ID       db_column: F_SUBJECTID 
     */	
	private String subjectId;
    /**
     * 主题名称       db_column: F_SUBJECT 
     */	
	private String subject;
    /**
     * 运营商ID       db_column: F_SPID 
     */	
	private String spId;
	//columns END
	private List<String> subjectIdList;
	public void setSubjectId(String subjectId) {
		this.subjectId =subjectId;
	}
	
	public String getSubjectId() {
		return this.subjectId;
	}
	public void setSubject(String subject) {
		this.subject =subject;
	}
	
	public String getSubject() {
		return this.subject;
	}
	public void setSpId(String spId) {
		this.spId =spId;
	}
	
	public String getSpId() {
		return this.spId;
	}
	public void setSubjectIdList(List<String> subjectIdList) {
		this.subjectIdList = subjectIdList;
	}
	
	public List<String> getSubjectIdList() {
		return this.subjectIdList;
	}

}


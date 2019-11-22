
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "orderLog")
public class OrderLog extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "orderLogId:订单操作日志ID"
          ,
          "linkId:关联表ID：类型为订单则订单ID，类型为退订则问退订记录ID"
          ,
          "opTime:操作时间"
          ,
          "oper:操作人"
          ,
          "opContent:操作内容"
          ,
          "type:日志类型:1订单日志，2退订日志"
          ,
          "result:操作结果:0失败，1成功"
          
        };
	
	//columns START
    /**
     * 订单操作日志ID       db_column: F_ORDERLOGID 
     */	
	private String orderLogId;
    /**
     * 关联表ID：类型为订单则订单ID，类型为退订则问退订记录ID       db_column: F_LINKID 
     */	
	private String linkId;
    /**
     * 操作时间       db_column: F_OPTIME 
     */	
	private String opTime;
    /**
     * 操作人       db_column: F_OPER 
     */	
	private String oper;
    /**
     * 操作内容       db_column: F_OPCONTENT 
     */	
	private String opContent;
    /**
     * 日志类型:1订单日志，2退订日志       db_column: F_TYPE 
     */	
	private String type;
    /**
     * 操作结果:0失败，1成功       db_column: F_RESULT 
     */	
	private String result;
	//columns END
	private List<String> orderLogIdList;
	public void setOrderLogId(String orderLogId) {
		this.orderLogId =orderLogId;
	}
	
	public String getOrderLogId() {
		return this.orderLogId;
	}
	public void setLinkId(String linkId) {
		this.linkId =linkId;
	}
	
	public String getLinkId() {
		return this.linkId;
	}
	public void setOpTime(String opTime) {
		this.opTime =opTime;
	}
	
	public String getOpTime() {
		return this.opTime;
	}
	public void setOper(String oper) {
		this.oper =oper;
	}
	
	public String getOper() {
		return this.oper;
	}
	public void setOpContent(String opContent) {
		this.opContent =opContent;
	}
	
	public String getOpContent() {
		return this.opContent;
	}
	public void setType(String type) {
		this.type =type;
	}
	
	public String getType() {
		return this.type;
	}
	public void setResult(String result) {
		this.result =result;
	}
	
	public String getResult() {
		return this.result;
	}
	public void setOrderLogIdList(List<String> orderLogIdList) {
		this.orderLogIdList = orderLogIdList;
	}
	
	public List<String> getOrderLogIdList() {
		return this.orderLogIdList;
	}

}


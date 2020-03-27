
package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "thirdPayFlow")
public class ThirdPayFlow extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "flowId:流水ID"
          ,
          "platformFlowCode:我方批次流水号"
          ,
          "createTime:我方流水时间"
          ,
          "thirdFlowCode:对方支付回执编号"
          ,
          "thirdCreateTime:接收到支付回执的时间"
          ,
          "flowState:0-申请，1-流水成功，2-流水失败，3，流水终止"
          ,
          "flowMoney:流水金额"
          ,
          "platformOrders:订单1,订单2,订单3"
          
        };
	
	//columns START
	/**
	 * 流水类型-微信0
	 */
	public static String THIRD_TYPE_WX="0";
	/**
	 * 流水类型-支付宝1
	 */
	public static String THIRD_TYPE_ZFB="1";
    /**
     * 流水ID       db_column: F_FLOWID 
     */	
	private String flowId;
    /**
     * 我方批次流水号       db_column: F_PLATFORM_FLOW_CODE 
     */	
	private String platformFlowCode;
    /**
     * 我方流水时间       db_column: F_CREATETIME 
     */	
	private String createTime;
	/**
	 * 对方类型       db_column: F_THIRD_TYPE (0微信，1支付宝)
	 */
	private String thirdType;
    /**
     * 对方支付回执编号       db_column: F_THIRD_FLOW_CODE 
     */	
	private String thirdFlowCode;
    /**
     * 接收到支付回执的时间       db_column: F_THIRD_CREATETIME 
     */	
	private String thirdCreateTime;
    /**
     * 0-申请，1-流水成功，2-流水失败，3，流水终止       db_column: F_FLOW_STATE 
     */	
	private String flowState;
    /**
     * 流水金额       db_column: F_FLOW_MONEY 
     */	
	private String flowMoney;
    /**
     * 订单1,订单2,订单3       db_column: F_PLATFORM_ORDERS 
     */	
	private String platformOrders;
	/**
	 * 运营商       db_column: F_SPID
	 */
	private String spId;
	//columns END
	private List<String> thirdPayFlowIdList;
	public void setFlowId(String flowId) {
		this.flowId =flowId;
	}
	
	public String getFlowId() {
		return this.flowId;
	}
	public void setPlatformFlowCode(String platformFlowCode) {
		this.platformFlowCode =platformFlowCode;
	}
	
	public String getPlatformFlowCode() {
		return this.platformFlowCode;
	}
	public void setCreateTime(String createTime) {
		this.createTime =createTime;
	}
	
	public String getCreateTime() {
		return this.createTime;
	}
	public void setThirdFlowCode(String thirdFlowCode) {
		this.thirdFlowCode =thirdFlowCode;
	}
	
	public String getThirdFlowCode() {
		return this.thirdFlowCode;
	}
	public void setThirdCreateTime(String thirdCreateTime) {
		this.thirdCreateTime =thirdCreateTime;
	}
	
	public String getThirdCreateTime() {
		return this.thirdCreateTime;
	}
	public void setFlowState(String flowState) {
		this.flowState =flowState;
	}
	
	public String getFlowState() {
		return this.flowState;
	}
	public void setFlowMoney(String flowMoney) {
		this.flowMoney =flowMoney;
	}
	
	public String getFlowMoney() {
		return this.flowMoney;
	}
	public void setPlatformOrders(String platformOrders) {
		this.platformOrders =platformOrders;
	}
	
	public String getPlatformOrders() {
		return this.platformOrders;
	}
	public void setThirdPayFlowIdList(List<String> thirdPayFlowIdList) {
		this.thirdPayFlowIdList = thirdPayFlowIdList;
	}
	
	public List<String> getThirdPayFlowIdList() {
		return this.thirdPayFlowIdList;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getThirdType() {
		return thirdType;
	}

	public void setThirdType(String thirdType) {
		this.thirdType = thirdType;
	}
}



package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "orderExpress")
public class OrderExpress extends BaseEntity implements java.io.Serializable
{

	 /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
			 		"orderExpressId:快递记录ID"
			    ,
          "orderId:订单ID"
          ,
          "orderListId:订单产品明细编号"
          ,
          "spId:运营商编号：前端下单时根据产品关联出来"
          ,
          "venId:供应商编号"
          ,
          "epmeCompany:快递公司"
          ,
          "epmeOrdCode:快递单号"
          ,
          "delTag:删除标志：0-否1-是"
          ,
          "createTime:创建时间"
          ,
          "creatorUID:创建人"
          ,
          "creator:创建人姓名"
          ,
          "updateTime:修改时间"
          ,
          "updateUID:修改人"
          ,
          "updater:修改人姓名"
          
        };
	
	//columns START
	/**
	 * 快递记录ID       db_column: F_ORDEREXPRESSID
	 */
	private String orderExpressId;
    /**
     * 订单ID       db_column: F_ORDERID 
     */	
	private String orderId;
    /**
     * 订单产品明细编号       db_column: F_ORDERLISTID 
     */	
	private String orderListId;
    /**
     * 运营商编号：前端下单时根据产品关联出来       db_column: F_SPID 
     */	
	private String spId;
    /**
     * 供应商编号       db_column: F_VENID 
     */	
	private String venId;
    /**
     * 快递公司       db_column: F_EPMECOMPANY 
     */	
	private String epmeCompany;
	private String epmeCompanyValue;
    /**
     * 快递单号       db_column: F_EPMEORDCODE 
     */	
	private String epmeOrdCode;
    /**
     * 删除标志：0-否1-是       db_column: F_DELTAG 
     */	
	private String delTag;
    /**
     * 创建时间       db_column: F_CREATETIME 
     */	
	private String createTime;
    /**
     * 创建人       db_column: F_CREATORUID 
     */	
	private String creatorUID;
    /**
     * 创建人姓名       db_column: F_CREATOR 
     */	
	private String creator;
    /**
     * 修改时间       db_column: F_UPDATETIME 
     */	
	private String updateTime;
    /**
     * 修改人       db_column: F_UPDATERUID 
     */	
	private String updateUID;
    /**
     * 修改人姓名       db_column: F_UPDATER 
     */	
	private String updater;

	/**
	 * 快递状态 0:已收货,1:已发货 db_column: F_STATUS
	 */
	private String status;
	/**
	 * 通过oneOrderListId 查询 orderListId 里的内容
	 */
	private String oneOrderListId;

	private String createTimeS;
	private String createTimeE;
	//columns END
	private List<String> orderExpressIdList;
	public void setOrderId(String orderId) {
		this.orderId =orderId;
	}
	
	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderListId(String orderListId) {
		this.orderListId =orderListId;
	}
	
	public String getOrderListId() {
		return this.orderListId;
	}
	public void setSpId(String spId) {
		this.spId =spId;
	}
	
	public String getSpId() {
		return this.spId;
	}
	public void setVenId(String venId) {
		this.venId =venId;
	}
	
	public String getVenId() {
		return this.venId;
	}
	public void setEpmeCompany(String epmeCompany) {
		this.epmeCompany =epmeCompany;
	}
	
	public String getEpmeCompany() {
		return this.epmeCompany;
	}
	public void setEpmeOrdCode(String epmeOrdCode) {
		this.epmeOrdCode =epmeOrdCode;
	}
	
	public String getEpmeOrdCode() {
		return this.epmeOrdCode;
	}
	public void setDelTag(String delTag) {
		this.delTag =delTag;
	}
	
	public String getDelTag() {
		return this.delTag;
	}
	public void setCreateTime(String createTime) {
		this.createTime =createTime;
	}
	
	public String getCreateTime() {
		return this.createTime;
	}
	public void setCreatorUID(String creatorUID) {
		this.creatorUID =creatorUID;
	}
	
	public String getCreatorUID() {
		return this.creatorUID;
	}
	public void setCreator(String creator) {
		this.creator =creator;
	}
	
	public String getCreator() {
		return this.creator;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime =updateTime;
	}
	
	public String getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdateUID(String updateUID) {
		this.updateUID =updateUID;
	}
	
	public String getUpdateUID() {
		return this.updateUID;
	}
	public void setUpdater(String updater) {
		this.updater =updater;
	}
	
	public String getUpdater() {
		return this.updater;
	}
	public void setOrderExpressIdList(List<String> orderExpressIdList) {
		this.orderExpressIdList = orderExpressIdList;
	}
	
	public List<String> getOrderExpressIdList() {
		return this.orderExpressIdList;
	}

	public String getEpmeCompanyValue() {
		return epmeCompanyValue;
	}

	public void setEpmeCompanyValue(String epmeCompanyValue) {
		this.epmeCompanyValue = epmeCompanyValue;
	}

	public String getOneOrderListId() {
		return oneOrderListId;
	}

	public void setOneOrderListId(String oneOrderListId) {
		this.oneOrderListId = oneOrderListId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTimeS() {
		return createTimeS;
	}

	public void setCreateTimeS(String createTimeS) {
		this.createTimeS = createTimeS;
	}

	public String getCreateTimeE() {
		return createTimeE;
	}

	public void setCreateTimeE(String createTimeE) {
		this.createTimeE = createTimeE;
	}

	public String getOrderExpressId() {
		return orderExpressId;
	}

	public void setOrderExpressId(String orderExpressId) {
		this.orderExpressId = orderExpressId;
	}
}


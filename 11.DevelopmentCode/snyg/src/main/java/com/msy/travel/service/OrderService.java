package com.msy.travel.service;

import com.alibaba.fastjson.JSONObject;
import com.msy.travel.common.LogicException;
import com.msy.travel.common.Result;
import com.msy.travel.pojo.OrderExpress;
import com.msy.travel.pojo.ThirdPayFlow;
import com.msy.travel.pojo.User;
import java.util.List;
import com.msy.travel.pojo.Order;
import java.util.Map;

/**
 * OrderService接口
 * 
 * @author wootide
 * 
 */
public interface OrderService
{
    
    /**
     * 查询单个Order
     * 
     * @param order Order对象
     * 
     * @return Order实体对象
     */
    public Order displayOrder(Order order) throws Exception;
  
   /**
     * 查询Order列表
     * 
     * @param order Order对象
     * 
     * @return Order列表
     */
    public List<Order> queryOrderList(Order order) throws Exception;

  /**
   * 查询Order列表信息统计信息
   *
   * @param order Order对象
   *
   * @return Order列表
   */
  public Order queryOrderListStatic(Order order) throws Exception;

  /**
   * 创建订单前验证
   * @param {consigneeId:收货地址Id,userId:用户Id,memo:备注,price:{priceType:销售类型,其他字段},orderListList[{priceId:销售id,num:数量,cartId:购物车Id}]}
   * @return
   * @throws Exception
   */
  public Result validateCreateOrder(JSONObject param) throws Exception;
  /**
   * 创建订单
   * @param param
   */
  public List<Order> createOrder(JSONObject param) throws LogicException,Exception;

  /**
   * 支付订单
   * @param thirdPayFlow
   */
  public void payOrder(ThirdPayFlow thirdPayFlow) throws Exception;

  /**
   * 修改订单商户备注
   * @param orderId 订单Id
   * @param companyRemark 商户备注内容
   * @param opUser 操作人
   */
  public void updateOrderCompanyRemark(String orderId, String companyRemark,User opUser) throws Exception;

  /**
   * 关闭未支付订单
   * @param orderId
   */
  public void closeUnPayOrder(String orderId, User opUser) throws Exception;

  /**
   * 发货
   * @param  orderExpress
   * @param  operator 操作人
   * orderExpress.
   */
  public void addExpress(OrderExpress orderExpress, User operator) throws Exception;

  /**
   * 快递收货
   * @param  orderExpress
   * @param  operator 操作人
   * orderExpress.
   */
  public void closeExpress(OrderExpress orderExpress, User operator) throws Exception;

  /**
   * 修改订单status
   * @param orderId 订单ID
   * @param status 计划修改订单的状态
   * @param opUser 操作人
   */
  public Result changeOrderStatus(String orderId, String status, User opUser) throws Exception;


  /**
   * 退订订单剩余所有
   * param 参数
   *         orderId 订单ID
   *         backReason 退订原因
   *         backReasonType 退订原因类型
   * opUser 操作人
   */
  public Result refuseOrder(Map<String,String> param,User opUser) throws Exception;

  /**
   * 退订订单剩余所有
   * param 参数
   *         backId 退订单Id
   * opUser 操作人
   */
  public Result orderBackSuccess(Map<String,String> param,User opUser) throws Exception;

  /**
   * 验证山东移动是否能预订
   * param 参数
   * opUser 操作人
   */
  public Result sdMobileCanOrder(Map<String,String> param,User opUser) throws Exception;

  /**
   * 验证山东移动同步订单
   * param 参数
   * opUser 操作人
   */
  public Result sdMobileSyncOrder(Map<String,String> param,User opUser) throws Exception;

}


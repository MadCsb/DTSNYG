package com.msy.travel.service;

import com.msy.travel.common.Result;
import com.msy.travel.pojo.User;
import java.util.List;
import com.msy.travel.pojo.OrderBack;
import java.util.Map;

/**
 * OrderBackService接口
 * 
 * @author wootide
 * 
 */
public interface OrderBackService
{
  /**
   * 退订订单剩余所有
   * param 参数
   *         orderId 订单ID
   *         wxImgServiceIds 微信上传的图片Ids
   *         backReason 退订原因
   *         backReasonType 退订原因类型
   * opUser 操作人
   */
  public void orderAllBack(Map<String,String> param,User opUser) throws Exception;

    /**
     * 查询单个OrderBack
     * 
     * @param orderBack OrderBack对象
     * 
     * @return OrderBack实体对象
     */
    public OrderBack displayOrderBack(OrderBack orderBack) throws Exception;
  
   /**
     * 查询OrderBack列表
     * 
     * @param orderBack OrderBack对象
     * 
     * @return OrderBack列表
     */
    public List<OrderBack> queryOrderBackList(OrderBack orderBack) throws Exception;

    /**
     * 查询OrderBack统计信息
     *
     * @param orderBack OrderBack对象
     *
     * @return OrderBack列表
     */
    public OrderBack queryOrderBackListStatic(OrderBack orderBack) throws Exception;

    /**
     * 修改退订status
     * @param backId 退订ID
     * @param status 计划修改退订单的状态
     * @param opUser 操作人
     */
    public Result changeOrderBackStatus(String backId, String status, User opUser) throws Exception;

    /**
     * 拒绝退订申请
     * @param param
     *          backId 退订记录ID
     *          refuseReason 不受理原因
     * @param opUser 操作人
     * @return Result
     * @throws Exception
     */
    public Result refuseOrderBack(Map<String,String> param,User opUser) throws Exception;

    /**
     * 受理退订申请
     * @param param
     *          backId 退订记录ID
     *          backGoodsName 退货快递接收人
     *          backGoodsPhone 退货快递接收人电话
     *          backGoodsAddr 退货快递接收地址
     * @param opUser 操作人
     * @return Result
     * @throws Exception
     */
    public Result agressOrderBack(Map<String,String> param,User opUser) throws Exception;

    /**
     * 发送退货
     * @param param
     * @param opUser 操作人
     * @return Result
     * @throws Exception
     */
    public Result sendGoods(Map<String,String> param,User opUser) throws Exception;

    /**
     * 接收退货
     * @param param
     * @param opUser 操作人
     * @return Result
     * @throws Exception
     */
    public Result receiveGoods(Map<String,String> param,User opUser) throws Exception;

  /**
   * 接收退款
   * @param param
   * @param opUser 操作人
   * @return Result
   * @throws Exception
   */
  public Result receiveMoney(Map<String,String> param,User opUser) throws Exception;

}


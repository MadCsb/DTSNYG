package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.WeixinOpenApplication;

/**
 * WeixinOpenApplicationService接口
 * 
 * @author wootide
 * 
 */
public interface WeixinOpenApplicationService
{
    /**
     * 新增WeixinOpenApplication
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     */
    public void createWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception;
    
    /**
     * 检查WeixinOpenApplication
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     */
    public void mergeWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception;
  
    /**
     * 删除WeixinOpenApplication
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     */
    public void deleteWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception;
   
    /**
     * 批量删除WeixinOpenApplication
     * 
     * @param weixinOpenApplicationIdList  存放weixinOpenApplication主键的list
     */
    public void deleteBatchWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception;  
    
    /**
     * 修改WeixinOpenApplication
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     */
    public void updateWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception;
    
    /**
     * 查询单个WeixinOpenApplication
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     * 
     * @return WeixinOpenApplication实体对象
     */
    public WeixinOpenApplication displayWeixinOpenApplication(
        WeixinOpenApplication weixinOpenApplication) throws Exception;
  
   /**
     * 查询WeixinOpenApplication列表
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     * 
     * @return WeixinOpenApplication列表
     */
    public List<WeixinOpenApplication> queryWeixinOpenApplicationList(
        WeixinOpenApplication weixinOpenApplication) throws Exception;

    /**
     * 获取WeixinOpenApplication主键ID
     */
    public String getWeixinOpenApplicationId() throws Exception;
}


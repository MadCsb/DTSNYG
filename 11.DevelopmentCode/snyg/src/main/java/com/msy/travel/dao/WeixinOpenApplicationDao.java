package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.WeixinOpenApplication;
/**
 * WeixinOpenApplicationDao接口
 * 
 * @author wootide
 * 
 */
public interface WeixinOpenApplicationDao
{
    /**
     * 增加WeixinOpenApplication
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     */
    void insertWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception;
   
    /**
     * 检查WeixinOpenApplication
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     */
    void mergeWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception;
   
    /**
     * 删除WeixinOpenApplication
     * 
     * @param weixinOpenApplication 成语对象
     */
    void deleteWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception;
    
    /**
     * 批量删除WeixinOpenApplication
     * 
     * @param ids ids
     */
    void deleteBatchWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception;  
    
    /**
     * 修改WeixinOpenApplication
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     */
    void updateWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception;  
   
    /**
     * 查询单个WeixinOpenApplication信息
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     * 
     * @return WeixinOpenApplication实体对象
     */
    WeixinOpenApplication queryWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception;
    
    /**
     * 查询WeixinOpenApplication列表信息
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     * 
     * @return WeixinOpenApplication列表
     */
    List<WeixinOpenApplication> queryWeixinOpenApplicationList(
        WeixinOpenApplication weixinOpenApplication) throws Exception;

    /**
     * 获取WeixinOpenApplicationID
     */
    String getWeixinOpenApplicationId() throws Exception;
}

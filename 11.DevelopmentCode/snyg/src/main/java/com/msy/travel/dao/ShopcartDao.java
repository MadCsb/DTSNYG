package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.Shopcart;
/**
 * ShopcartDao接口
 * 
 * @author wootide
 * 
 */
public interface ShopcartDao
{
    /**
     * 增加Shopcart
     * 
     * @param shopcart Shopcart对象
     */
    void insertShopcart(Shopcart shopcart) throws Exception;
   
    /**
     * 检查Shopcart
     * 
     * @param shopcart Shopcart对象
     */
    void mergeShopcart(Shopcart shopcart) throws Exception;
   
    /**
     * 删除Shopcart
     * 
     * @param shopcart 成语对象
     */
    void deleteShopcart(Shopcart shopcart) throws Exception;
    
    /**
     * 批量删除Shopcart
     * 
     * @param ids ids
     */
    void deleteBatchShopcart(Shopcart shopcart) throws Exception;  
    
    /**
     * 修改Shopcart
     * 
     * @param shopcart Shopcart对象
     */
    void updateShopcart(Shopcart shopcart) throws Exception;  
   
    /**
     * 查询单个Shopcart信息
     * 
     * @param shopcart Shopcart对象
     * 
     * @return Shopcart实体对象
     */
    Shopcart queryShopcart(Shopcart shopcart) throws Exception;
    
    /**
     * 查询Shopcart列表信息
     * 
     * @param shopcart Shopcart对象
     * 
     * @return Shopcart列表
     */
    List<Shopcart> queryShopcartList(Shopcart shopcart) throws Exception;

    /**
     * 获取ShopcartID
     */
    String getShopcartId() throws Exception;
}

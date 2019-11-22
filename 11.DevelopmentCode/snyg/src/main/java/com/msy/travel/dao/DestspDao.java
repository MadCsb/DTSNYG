package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.Destsp;
/**
 * DestspDao接口
 * 
 * @author wootide
 * 
 */
public interface DestspDao
{
    /**
     * 增加Destsp
     * 
     * @param destsp Destsp对象
     */
    void insertDestsp(Destsp destsp) throws Exception;
   
    /**
     * 检查Destsp
     * 
     * @param destsp Destsp对象
     */
    void mergeDestsp(Destsp destsp) throws Exception;
   
    /**
     * 删除Destsp
     * 
     * @param destsp 成语对象
     */
    void deleteDestsp(Destsp destsp) throws Exception;
    
    /**
     * 批量删除Destsp
     * 
     * @param ids ids
     */
    void deleteBatchDestsp(Destsp destsp) throws Exception;  
    
    /**
     * 修改Destsp
     * 
     * @param destsp Destsp对象
     */
    void updateDestsp(Destsp destsp) throws Exception;  
   
    /**
     * 查询单个Destsp信息
     * 
     * @param destsp Destsp对象
     * 
     * @return Destsp实体对象
     */
    Destsp queryDestsp(Destsp destsp) throws Exception;
    
    /**
     * 查询Destsp列表信息
     * 
     * @param destsp Destsp对象
     * 
     * @return Destsp列表
     */
    List<Destsp> queryDestspList(Destsp destsp) throws Exception;

    /**
     * 获取DestspID
     */
    String getDestspId() throws Exception;
}

package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.ThirdPayFlow;
/**
 * ThirdPayFlowDao接口
 * 
 * @author wootide
 * 
 */
public interface ThirdPayFlowDao
{
    /**
     * 增加ThirdPayFlow
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     */
    void insertThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception;
   
    /**
     * 检查ThirdPayFlow
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     */
    void mergeThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception;
   
    /**
     * 删除ThirdPayFlow
     * 
     * @param thirdPayFlow 成语对象
     */
    void deleteThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception;
    
    /**
     * 批量删除ThirdPayFlow
     * 
     * @param ids ids
     */
    void deleteBatchThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception;  
    
    /**
     * 修改ThirdPayFlow
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     */
    void updateThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception;  
   
    /**
     * 查询单个ThirdPayFlow信息
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     * 
     * @return ThirdPayFlow实体对象
     */
    ThirdPayFlow queryThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception;
    
    /**
     * 查询ThirdPayFlow列表信息
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     * 
     * @return ThirdPayFlow列表
     */
    List<ThirdPayFlow> queryThirdPayFlowList(ThirdPayFlow thirdPayFlow) throws Exception;

    /**
     * 获取ThirdPayFlowID
     */
    String getThirdPayFlowId() throws Exception;
}

package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.ThirdPayFlow;

/**
 * ThirdPayFlowService接口
 * 
 * @author wootide
 * 
 */
public interface ThirdPayFlowService
{
    /**
     * 新增ThirdPayFlow
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     */
    public void createThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception;
    
    /**
     * 检查ThirdPayFlow
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     */
    public void mergeThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception;
  
    /**
     * 删除ThirdPayFlow
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     */
    public void deleteThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception;
   
    /**
     * 批量删除ThirdPayFlow
     * 
     * @param thirdPayFlowIdList  存放thirdPayFlow主键的list
     */
    public void deleteBatchThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception;  
    
    /**
     * 修改ThirdPayFlow
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     */
    public void updateThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception;
    
    /**
     * 查询单个ThirdPayFlow
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     * 
     * @return ThirdPayFlow实体对象
     */
    public ThirdPayFlow displayThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception;
  
   /**
     * 查询ThirdPayFlow列表
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     * 
     * @return ThirdPayFlow列表
     */
    public List<ThirdPayFlow> queryThirdPayFlowList(ThirdPayFlow thirdPayFlow) throws Exception;

    /**
     * 获取ThirdPayFlow主键ID
     */
    public String getThirdPayFlowId() throws Exception;

  /**
   * 流水响应护理
   */
  public void flowReturn(ThirdPayFlow thirdPayFlow) throws Exception;
}


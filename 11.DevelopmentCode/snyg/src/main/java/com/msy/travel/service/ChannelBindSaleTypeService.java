package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.ChannelBindSaleType;

/**
 * ChannelBindSaleTypeService接口
 * 
 * @author wootide
 * 
 */
public interface ChannelBindSaleTypeService
{
    /**
     * 新增ChannelBindSaleType
     * 
     * @param channelBindSaleType ChannelBindSaleType对象
     */
    public void createChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;
    
    /**
     * 检查ChannelBindSaleType
     * 
     * @param channelBindSaleType ChannelBindSaleType对象
     */
    public void mergeChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;
  
    /**
     * 删除ChannelBindSaleType
     * 
     * @param channelBindSaleType ChannelBindSaleType对象
     */
    public void deleteChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;
   
    /**
     * 批量删除ChannelBindSaleType
     * 
     * @param channelBindSaleTypeIdList  存放channelBindSaleType主键的list
     */
    public void deleteBatchChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;  
    
    /**
     * 修改ChannelBindSaleType
     * 
     * @param channelBindSaleType ChannelBindSaleType对象
     */
    public void updateChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;
    
    /**
     * 查询单个ChannelBindSaleType
     * 
     * @param channelBindSaleType ChannelBindSaleType对象
     * 
     * @return ChannelBindSaleType实体对象
     */
    public ChannelBindSaleType displayChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception;
  
   /**
     * 查询ChannelBindSaleType列表
     * 
     * @param channelBindSaleType ChannelBindSaleType对象
     * 
     * @return ChannelBindSaleType列表
     */
    public List<ChannelBindSaleType> queryChannelBindSaleTypeList(ChannelBindSaleType channelBindSaleType) throws Exception;

    /**
     * 获取ChannelBindSaleType主键ID
     */
    public String getChannelBindSaleTypeId() throws Exception;
}


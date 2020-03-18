package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.UserBindChannel;

/**
 * UserBindChannelService接口
 * 
 * @author wootide
 * 
 */
public interface UserBindChannelService
{
    /**
     * 新增UserBindChannel
     * 
     * @param userBindChannel UserBindChannel对象
     */
    public void createUserBindChannel(UserBindChannel userBindChannel) throws Exception;
    
    /**
     * 检查UserBindChannel
     * 
     * @param userBindChannel UserBindChannel对象
     */
    public void mergeUserBindChannel(UserBindChannel userBindChannel) throws Exception;
  
    /**
     * 删除UserBindChannel
     * 
     * @param userBindChannel UserBindChannel对象
     */
    public void deleteUserBindChannel(UserBindChannel userBindChannel) throws Exception;
   
    /**
     * 批量删除UserBindChannel
     * 
     * @param userBindChannelIdList  存放userBindChannel主键的list
     */
    public void deleteBatchUserBindChannel(UserBindChannel userBindChannel) throws Exception;  
    
    /**
     * 修改UserBindChannel
     * 
     * @param userBindChannel UserBindChannel对象
     */
    public void updateUserBindChannel(UserBindChannel userBindChannel) throws Exception;
    
    /**
     * 查询单个UserBindChannel
     * 
     * @param userBindChannel UserBindChannel对象
     * 
     * @return UserBindChannel实体对象
     */
    public UserBindChannel displayUserBindChannel(UserBindChannel userBindChannel) throws Exception;
  
   /**
     * 查询UserBindChannel列表
     * 
     * @param userBindChannel UserBindChannel对象
     * 
     * @return UserBindChannel列表
     */
    public List<UserBindChannel> queryUserBindChannelList(UserBindChannel userBindChannel) throws Exception;

    /**
     * 获取UserBindChannel主键ID
     */
    public String getUserBindChannelId() throws Exception;
}


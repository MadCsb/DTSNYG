package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.UserBindChannel;
/**
 * UserBindChannelDao接口
 * 
 * @author wootide
 * 
 */
public interface UserBindChannelDao
{
    /**
     * 增加UserBindChannel
     * 
     * @param userBindChannel UserBindChannel对象
     */
    void insertUserBindChannel(UserBindChannel userBindChannel) throws Exception;
   
    /**
     * 检查UserBindChannel
     * 
     * @param userBindChannel UserBindChannel对象
     */
    void mergeUserBindChannel(UserBindChannel userBindChannel) throws Exception;
   
    /**
     * 删除UserBindChannel
     * 
     * @param userBindChannel 成语对象
     */
    void deleteUserBindChannel(UserBindChannel userBindChannel) throws Exception;
    
    /**
     * 批量删除UserBindChannel
     * 
     * @param ids ids
     */
    void deleteBatchUserBindChannel(UserBindChannel userBindChannel) throws Exception;  
    
    /**
     * 修改UserBindChannel
     * 
     * @param userBindChannel UserBindChannel对象
     */
    void updateUserBindChannel(UserBindChannel userBindChannel) throws Exception;  
   
    /**
     * 查询单个UserBindChannel信息
     * 
     * @param userBindChannel UserBindChannel对象
     * 
     * @return UserBindChannel实体对象
     */
    UserBindChannel queryUserBindChannel(UserBindChannel userBindChannel) throws Exception;
    
    /**
     * 查询UserBindChannel列表信息
     * 
     * @param userBindChannel UserBindChannel对象
     * 
     * @return UserBindChannel列表
     */
    List<UserBindChannel> queryUserBindChannelList(UserBindChannel userBindChannel) throws Exception;

    /**
     * 获取UserBindChannelID
     */
    String getUserBindChannelId() throws Exception;
}

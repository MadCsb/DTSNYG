package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.UserBindChannel;
import com.msy.travel.dao.UserBindChannelDao;
import com.msy.travel.service.UserBindChannelService;

/**
 * UserBindChannelService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class UserBindChannelServiceImpl implements UserBindChannelService
{

	@Resource(name="userBindChannelDao")
    private UserBindChannelDao userBindChannelDao;
    
    /**
     * 新增UserBindChannel
     * 
     * @param userBindChannel UserBindChannel对象
     */
    public void createUserBindChannel(UserBindChannel userBindChannel) throws Exception
    {
        userBindChannelDao.insertUserBindChannel(userBindChannel);
    }
    /**
     * 检查UserBindChannel
     * 
     * @param userBindChannel UserBindChannel对象
     */
    public void mergeUserBindChannel(UserBindChannel userBindChannel) throws Exception
    {
    	userBindChannelDao.mergeUserBindChannel(userBindChannel);
    }
    /**
     * 删除UserBindChannel
     * 
     * @param userBindChannel UserBindChannel对象
     */
    public void deleteUserBindChannel(UserBindChannel userBindChannel) throws Exception
    {
        userBindChannelDao.deleteUserBindChannel(userBindChannel);
    }
   
    /**
     * 修改UserBindChannel
     * 
     * @param userBindChannel UserBindChannel对象
     */
    public void updateUserBindChannel(UserBindChannel userBindChannel) throws Exception
    {
        userBindChannelDao.updateUserBindChannel(userBindChannel);
    }
    /**
     * 批量删除UserBindChannel
     * 
     * @param userBindChannelIdList 存放userBindChannel主键的list
     */
    public void deleteBatchUserBindChannel(UserBindChannel userBindChannel) throws Exception
    {
    	userBindChannelDao.deleteBatchUserBindChannel(userBindChannel);
    }  
    /**
     * 查询单个UserBindChannel
     * 
     * @param userBindChannel UserBindChannel对象
     * 
     * @return 成员实体对象
     */
    public UserBindChannel displayUserBindChannel(UserBindChannel userBindChannel) throws Exception
    {
        return userBindChannelDao.queryUserBindChannel(userBindChannel);
    }

    /**
     * 查询UserBindChannel列表
     * 
     * @param userBindChannel UserBindChannel对象
     * 
     * @return UserBindChannel列表
     */
    public List<UserBindChannel> queryUserBindChannelList(UserBindChannel userBindChannel) throws Exception
    {
        return userBindChannelDao.queryUserBindChannelList(userBindChannel);
    }

    /**
     * 获取UserBindChannelID
     */
    public String getUserBindChannelId() throws Exception
    {
    	return userBindChannelDao.getUserBindChannelId();
    }
}

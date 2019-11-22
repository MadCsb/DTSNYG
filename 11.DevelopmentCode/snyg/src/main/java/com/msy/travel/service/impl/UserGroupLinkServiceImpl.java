package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.UserGroupLink;
import com.msy.travel.dao.UserGroupLinkDao;
import com.msy.travel.service.UserGroupLinkService;

/**
 * UserGroupLinkService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class UserGroupLinkServiceImpl implements UserGroupLinkService
{

	@Resource(name="userGroupLinkDao")
    private UserGroupLinkDao userGroupLinkDao;
    
    /**
     * 新增UserGroupLink
     * 
     * @param userGroupLink UserGroupLink对象
     */
    public void createUserGroupLink(UserGroupLink userGroupLink) throws Exception
    {
        userGroupLinkDao.insertUserGroupLink(userGroupLink);
    }
    /**
     * 检查UserGroupLink
     * 
     * @param userGroupLink UserGroupLink对象
     */
    public void mergeUserGroupLink(UserGroupLink userGroupLink) throws Exception
    {
    	userGroupLinkDao.mergeUserGroupLink(userGroupLink);
    }
    /**
     * 删除UserGroupLink
     * 
     * @param userGroupLink UserGroupLink对象
     */
    public void deleteUserGroupLink(UserGroupLink userGroupLink) throws Exception
    {
        userGroupLinkDao.deleteUserGroupLink(userGroupLink);
    }
   
    /**
     * 修改UserGroupLink
     * 
     * @param userGroupLink UserGroupLink对象
     */
    public void updateUserGroupLink(UserGroupLink userGroupLink) throws Exception
    {
        userGroupLinkDao.updateUserGroupLink(userGroupLink);
    }
    /**
     * 批量删除UserGroupLink
     * 
     * @param userGroupLinkIdList 存放userGroupLink主键的list
     */
    public void deleteBatchUserGroupLink(UserGroupLink userGroupLink) throws Exception
    {
    	userGroupLinkDao.deleteBatchUserGroupLink(userGroupLink);
    }  
    /**
     * 查询单个UserGroupLink
     * 
     * @param userGroupLink UserGroupLink对象
     * 
     * @return 成员实体对象
     */
    public UserGroupLink displayUserGroupLink(UserGroupLink userGroupLink) throws Exception
    {
        return userGroupLinkDao.queryUserGroupLink(userGroupLink);
    }

    /**
     * 查询UserGroupLink列表
     * 
     * @param userGroupLink UserGroupLink对象
     * 
     * @return UserGroupLink列表
     */
    public List<UserGroupLink> queryUserGroupLinkList(UserGroupLink userGroupLink) throws Exception
    {
        return userGroupLinkDao.queryUserGroupLinkList(userGroupLink);
    }

    /**
     * 获取UserGroupLinkID
     */
    public String getUserGroupLinkId() throws Exception
    {
    	return userGroupLinkDao.getUserGroupLinkId();
    }
}

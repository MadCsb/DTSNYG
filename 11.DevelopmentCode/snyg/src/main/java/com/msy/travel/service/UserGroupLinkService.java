package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.UserGroupLink;

/**
 * UserGroupLinkService接口
 * 
 * @author wootide
 * 
 */
public interface UserGroupLinkService
{
    /**
     * 新增UserGroupLink
     * 
     * @param userGroupLink UserGroupLink对象
     */
    public void createUserGroupLink(UserGroupLink userGroupLink) throws Exception;
    
    /**
     * 检查UserGroupLink
     * 
     * @param userGroupLink UserGroupLink对象
     */
    public void mergeUserGroupLink(UserGroupLink userGroupLink) throws Exception;
  
    /**
     * 删除UserGroupLink
     * 
     * @param userGroupLink UserGroupLink对象
     */
    public void deleteUserGroupLink(UserGroupLink userGroupLink) throws Exception;
   
    /**
     * 批量删除UserGroupLink
     * 
     * @param userGroupLinkIdList  存放userGroupLink主键的list
     */
    public void deleteBatchUserGroupLink(UserGroupLink userGroupLink) throws Exception;  
    
    /**
     * 修改UserGroupLink
     * 
     * @param userGroupLink UserGroupLink对象
     */
    public void updateUserGroupLink(UserGroupLink userGroupLink) throws Exception;
    
    /**
     * 查询单个UserGroupLink
     * 
     * @param userGroupLink UserGroupLink对象
     * 
     * @return UserGroupLink实体对象
     */
    public UserGroupLink displayUserGroupLink(UserGroupLink userGroupLink) throws Exception;
  
   /**
     * 查询UserGroupLink列表
     * 
     * @param userGroupLink UserGroupLink对象
     * 
     * @return UserGroupLink列表
     */
    public List<UserGroupLink> queryUserGroupLinkList(UserGroupLink userGroupLink) throws Exception;

    /**
     * 获取UserGroupLink主键ID
     */
    public String getUserGroupLinkId() throws Exception;
}


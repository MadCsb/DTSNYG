package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.UserGroupLink;
/**
 * UserGroupLinkDao接口
 * 
 * @author wootide
 * 
 */
public interface UserGroupLinkDao
{
    /**
     * 增加UserGroupLink
     * 
     * @param userGroupLink UserGroupLink对象
     */
    void insertUserGroupLink(UserGroupLink userGroupLink) throws Exception;
   
    /**
     * 检查UserGroupLink
     * 
     * @param userGroupLink UserGroupLink对象
     */
    void mergeUserGroupLink(UserGroupLink userGroupLink) throws Exception;
   
    /**
     * 删除UserGroupLink
     * 
     * @param userGroupLink 成语对象
     */
    void deleteUserGroupLink(UserGroupLink userGroupLink) throws Exception;
    
    /**
     * 批量删除UserGroupLink
     * 
     * @param ids ids
     */
    void deleteBatchUserGroupLink(UserGroupLink userGroupLink) throws Exception;  
    
    /**
     * 修改UserGroupLink
     * 
     * @param userGroupLink UserGroupLink对象
     */
    void updateUserGroupLink(UserGroupLink userGroupLink) throws Exception;  
   
    /**
     * 查询单个UserGroupLink信息
     * 
     * @param userGroupLink UserGroupLink对象
     * 
     * @return UserGroupLink实体对象
     */
    UserGroupLink queryUserGroupLink(UserGroupLink userGroupLink) throws Exception;
    
    /**
     * 查询UserGroupLink列表信息
     * 
     * @param userGroupLink UserGroupLink对象
     * 
     * @return UserGroupLink列表
     */
    List<UserGroupLink> queryUserGroupLinkList(UserGroupLink userGroupLink) throws Exception;

    /**
     * 获取UserGroupLinkID
     */
    String getUserGroupLinkId() throws Exception;
}

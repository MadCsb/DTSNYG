package com.msy.travel.dao;

import com.msy.travel.pojo.UserGroup;

import java.util.List;
import java.util.Map;

/**
 * UserGroupDao接口
 * 
 * @author wootide
 * 
 */
public interface UserGroupDao
{
    /**
     * 增加UserGroup
     *
     * @param userGroup UserGroup对象
     */
    void insertUserGroup(UserGroup userGroup) throws Exception;

    /**
     * 删除UserGroup
     *
     * @param userGroup 成语对象
     */
    void deleteUserGroup(UserGroup userGroup) throws Exception;

    /**
     * 修改UserGroup
     *
     * @param userGroup UserGroup对象
     */
    void updateUserGroup(UserGroup userGroup) throws Exception;

    /**
     * 查询单个UserGroup信息
     *
     * @param userGroup UserGroup对象
     *
     * @return UserGroup实体对象
     */
    UserGroup queryUserGroup(UserGroup userGroup) throws Exception;

    /**
     * 获取满足查询条件总行数
     *
     * @param userGroup UserGroup实体对象
     *
     * @return 行数
     */
    int getTotalCount(UserGroup userGroup) throws Exception;

    /**
     * 查询UserGroup列表信息
     *
     * @param userGroup UserGroup对象
     *
     * @return UserGroup列表
     */
    List<UserGroup> queryUserGroupList(UserGroup userGroup) throws Exception;

    /**
     * 分页查询UserGroup列表信息
     *
     * @param userGroup UserGroup对象
     *
     * @return UserGroup列表
     */
    List<UserGroup> queryUserGroupListByPage(UserGroup userGroup) throws Exception;
    /**
     *
     * @Title: deleteUsergoupMenuAndButton
     * @Description: 根据用户组id删除用户组所有的菜单和用户组关联
     * @param: @param userId
     * @return void
     * @throws
     */
    public void deleteUsergoupMenu(String usergroupId) throws Exception;

    /**
     *
     * @Title: deleteUsergoupMenuAndButton
     * @Description: 根据用户组id删除用户组所有的菜单按钮和用户组关联
     * @param: @param userId
     * @return void
     * @throws
     */
    public void deleteUsergoupMenuButton(String usergroupId) throws Exception;

    /**
     *
     * @Title: insertUsergoupMenu
     * @Description: 插入用户组和关联菜单
     * @return void
     * @throws
     */
    public void insertUsergoupMenu(Map<String,Object> map);

    /**
     *
     * @Title: insertUsergourpMenubutton
     * @Description: 插入用户组和功能键关联
     * @param: @param usergroupId
     * @param: @param strings
     * @return void
     * @throws
     */
    public void insertUsergourpMenubutton(Map<String,Object> map);

    /**
     * 增加User_Group关系数据
     *
     * @param userGroup UserGroup对象
     */
    void insertUserGroupLink(UserGroup userGroup) throws Exception;

	/**
	 * 全域通系统删除用户用户组关系表
	 * @param userGroup 用户ID
	 * @throws Exception
	 */
	void deleteUserGroupLink(UserGroup userGroup) throws Exception;

    /**
     * 全域通系统查询User_Group列表信息
     *
     * @param userGroup UserGroup对象
     *
     * @return UserGroup列表
     */
    List<UserGroup> queryUserGroupLinkList(UserGroup userGroup) throws Exception;
}

package com.msy.travel.service;

import com.msy.travel.pojo.UserGroup;

import java.util.List;

/**
 * UserGroupService接口
 * 
 * @author wootide
 * 
 */
public interface IUserGroupService
{
    /**
     * 新增UserGroup
     *
     * @param userGroup UserGroup对象
     */
    public void createUserGroup(UserGroup userGroup) throws Exception;

    /**
     * 删除UserGroup
     *
     * @param userGroup UserGroup对象
     */
    public void deleteUserGroup(UserGroup userGroup) throws Exception;

    /**
     * 修改UserGroup
     *
     * @param userGroup UserGroup对象
     */
    public void updateUserGroup(UserGroup userGroup) throws Exception;

    /**
     * 查询单个UserGroup
     *
     * @param userGroup UserGroup对象
     *
     * @return UserGroup实体对象
     */
    public UserGroup displayUserGroup(UserGroup userGroup) throws Exception;

    /**
     * 获取总行数
     *
     * @return 总行数
     */
    public int getTotalCount(UserGroup userGroup)throws Exception;

    /**
     * 查询UserGroup列表
     *
     * @param userGroup UserGroup对象
     *
     * @return UserGroup列表
     */
    public List<UserGroup> queryUserGroupList(UserGroup userGroup) throws Exception;

    /**
     * 分页查询UserGroup列表
     *
     * @param userGroup UserGroup对象
     *
     * @return UserGroup列表
     */
    public List<UserGroup> queryUserGroupListByPage(UserGroup userGroup) throws Exception;

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
     * @param: @param usergroupId
     * @param: @param menuIds
     * @return void
     * @throws
     */
    public void insertUsergoupMenu(String usergroupId, String... menuIds);

    /**
     *
     * @Title: insertUsergourpMenubutton
     * @Description: 插入用户组和功能键关联
     * @param: @param usergroupId
     * @param: @param strings
     * @return void
     * @throws
     */
    public void insertUsergourpMenubutton(String usergroupId, String... menubuttonIds);

    /**
     * 增加User_Group关系数据
     *
     * @param userGroup UserGroup对象
     */
    public void insertUserGroupLink(UserGroup userGroup) throws Exception;

	/**
	 * 全域通删除用户用户组关系表
	 * @param userGroup 用户ID
	 * @throws Exception
	 */
	public void deleteUserGroupLink(UserGroup userGroup) throws Exception;

	/**
     * 全域通系统查询User_Group列表信息
     *
     * @param userGroup UserGroup对象
     *
     * @return UserGroup列表
     */
    public List<UserGroup> queryUserGroupLinkList(UserGroup userGroup) throws Exception;
}


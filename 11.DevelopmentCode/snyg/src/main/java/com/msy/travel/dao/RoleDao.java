package com.msy.travel.dao;

import com.msy.travel.pojo.Role;

import java.util.List;

/**
 * RoleDao接口
 * 
 * @author wootide
 * 
 */
public interface RoleDao
{

    /**
     * 查询Role列表信息
     *
     * @param role Role对象
     *
     * @return Role列表
     */
    List<Role> queryRoleList(Role role) throws Exception;


    List<Role> queryRoleLinkUnitList(Role role) throws Exception;

    /**
     * 查询角色类型查询可以编辑的角色类型
     * @return
     * @throws Exception
     */
    List<Role> queryRoleByRoleType(String roleType) throws Exception;
}

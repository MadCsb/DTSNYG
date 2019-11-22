package com.msy.travel.service;

import com.msy.travel.pojo.Role;

import java.util.List;

/**
 * RoleService接口
 * 
 * @author wootide
 * 
 */
public interface IRoleService
{

    /**
     * 查询Role列表
     *
     * @param role Role对象
     *
     * @return Role列表
     */
    public List<Role> queryRoleList(Role role) throws Exception;


    public List<Role> queryRoleLinkUnitList(Role role) throws Exception;


    /**
     * 查询角色类型查询可以编辑的角色类型
     * @return
     * @throws Exception
     */
    public List<Role> queryRoleByRoleType(String roleType) throws Exception;
}


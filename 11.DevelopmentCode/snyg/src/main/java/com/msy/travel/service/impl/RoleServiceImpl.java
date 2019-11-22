package com.msy.travel.service.impl;

import com.msy.travel.dao.RoleDao;
import com.msy.travel.pojo.Role;
import com.msy.travel.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * RoleService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService
{

	@Resource(name="roleDao")
    private RoleDao roleDao;

    /**
     * 查询Role列表
     *
     * @param role Role对象
     *
     * @return Role列表
     */
    public List<Role> queryRoleList(Role role) throws Exception
    {
        return roleDao.queryRoleList(role);
    }
	@Override
	public List<Role> queryRoleLinkUnitList(Role role) throws Exception {
		// TODO Auto-generated method stub
		return roleDao.queryRoleLinkUnitList(role);
	}

    /**
     * 查询角色类型查询可以编辑的角色类型
     * @return
     * @throws Exception
     */
    public List<Role> queryRoleByRoleType(String roleType) throws Exception
    {
        return roleDao.queryRoleByRoleType(roleType);
    }
}

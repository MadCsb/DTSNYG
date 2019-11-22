package com.msy.travel.service.impl;

import com.msy.travel.dao.UserGroupDao;
import com.msy.travel.pojo.UserGroup;
import com.msy.travel.service.IUserGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserGroupService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class UserGroupServiceImpl implements IUserGroupService
{

	@Resource(name="userGroupDao")
    private UserGroupDao userGroupDao;
    
    /**
     * 新增UserGroup
     *
     * @param userGroup UserGroup对象
     */
    public void createUserGroup(UserGroup userGroup) throws Exception
    {
        userGroupDao.insertUserGroup(userGroup);
    }
    /**
     * 删除UserGroup
     *
     * @param userGroup UserGroup对象
     */
    public void deleteUserGroup(UserGroup userGroup) throws Exception
    {
        userGroupDao.deleteUserGroup(userGroup);
    }

    /**
     * 修改UserGroup
     *
     * @param userGroup UserGroup对象
     */
    public void updateUserGroup(UserGroup userGroup) throws Exception
    {
        userGroupDao.updateUserGroup(userGroup);
    }
    /**
     * 查询单个UserGroup
     *
     * @param userGroup UserGroup对象
     *
     * @return 成员实体对象
     */
    public UserGroup displayUserGroup(UserGroup userGroup) throws Exception
    {
        return userGroupDao.queryUserGroup(userGroup);
    }
    /**
     * 通过条件获取总行数
     *
     * @param userGroup UserGroup实体对象
     *
     * @return 总行数
     */
    public int getTotalCount(UserGroup userGroup) throws Exception
    {
        int total = 0;

        total = userGroupDao.getTotalCount(userGroup);

        return total;
    }
    /**
     * 查询UserGroup列表
     *
     * @param userGroup UserGroup对象
     *
     * @return UserGroup列表
     */
    public List<UserGroup> queryUserGroupList(UserGroup userGroup) throws Exception
    {
        return userGroupDao.queryUserGroupList(userGroup);
    }
    /**
     * 分页查询UserGroup列表
     *
     * @param userGroup UserGroup对象
     *
     * @return UserGroup列表
     */
    public List<UserGroup> queryUserGroupListByPage(UserGroup userGroup) throws Exception
    {
        return userGroupDao.queryUserGroupListByPage(userGroup);
    }
    /**
     *
     * @Title: deleteUsergoupMenuAndButton
     * @Description: 根据用户组id删除用户组所有的菜单和用户组关联
     * @param: @param userId
     * @return void
     * @throws
     */
    public void deleteUsergoupMenu(String usergroupId) throws Exception
    {
        userGroupDao.deleteUsergoupMenu(usergroupId);
    }

    /**
     *
     * @Title: deleteUsergoupMenuAndButton
     * @Description: 根据用户组id删除用户组所有的菜单按钮和用户组关联
     * @param: @param userId
     * @return void
     * @throws
     */
    public void deleteUsergoupMenuButton(String usergroupId) throws Exception
    {
        userGroupDao.deleteUsergoupMenuButton(usergroupId);
    }

    /**
     *
     * @Title: insertUsergoupMenu
     * @Description: 插入用户组和关联菜单
     * @param: @param usergroupId
     * @param: @param menuIds
     * @return void
     * @throws
     */
    public void insertUsergoupMenu(String usergroupId,String... menuIds)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        for(int i=0;i<menuIds.length;i++)
        {
            map.put("ugid", usergroupId);
            map.put("menuid", menuIds[i]);
            userGroupDao.insertUsergoupMenu(map);
        }
    }

    /**
     *
     * @Title: insertUsergourpMenubutton
     * @Description: 插入用户组和功能键关联
     * @param: @param usergroupId
     * @param: @param strings
     * @return void
     * @throws
     */
	public void insertUsergourpMenubutton(String usergroupId,
			String... menubuttonIds) {

		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < menubuttonIds.length; i++) {
			map.put("ugid", usergroupId);
			map.put("menubutton", menubuttonIds[i]);
			userGroupDao.insertUsergourpMenubutton(map);
		}
	}

	@Override
	public void insertUserGroupLink(UserGroup userGroup) throws Exception {
		userGroupDao.insertUserGroupLink(userGroup);
	}
	@Override
	public void deleteUserGroupLink(UserGroup userGroup) throws Exception {
		userGroupDao.deleteUserGroupLink(userGroup);
	}
	@Override
	public List<UserGroup> queryUserGroupLinkList(UserGroup userGroup)throws Exception {
		return userGroupDao.queryUserGroupLinkList(userGroup);
	}
}

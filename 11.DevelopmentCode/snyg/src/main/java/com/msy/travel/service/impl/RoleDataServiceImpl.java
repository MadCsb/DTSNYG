package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.RoleData;
import com.msy.travel.dao.RoleDataDao;
import com.msy.travel.service.RoleDataService;

/**
 * RoleDataService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class RoleDataServiceImpl implements RoleDataService
{

	@Resource(name="roleDataDao")
    private RoleDataDao roleDataDao;
    
    /**
     * 新增RoleData
     * 
     * @param roleData RoleData对象
     */
    public void createRoleData(RoleData roleData) throws Exception
    {
        roleDataDao.insertRoleData(roleData);
    }
    /**
     * 检查RoleData
     * 
     * @param roleData RoleData对象
     */
    public void mergeRoleData(RoleData roleData) throws Exception
    {
    	roleDataDao.mergeRoleData(roleData);
    }
    /**
     * 删除RoleData
     * 
     * @param roleData RoleData对象
     */
    public void deleteRoleData(RoleData roleData) throws Exception
    {
        roleDataDao.deleteRoleData(roleData);
    }
   
    /**
     * 修改RoleData
     * 
     * @param roleData RoleData对象
     */
    public void updateRoleData(RoleData roleData) throws Exception
    {
        roleDataDao.updateRoleData(roleData);
    }
    /**
     * 批量删除RoleData
     * 
     * @param roleDataIdList 存放roleData主键的list
     */
    public void deleteBatchRoleData(RoleData roleData) throws Exception
    {
    	roleDataDao.deleteBatchRoleData(roleData);
    }  
    /**
     * 查询单个RoleData
     * 
     * @param roleData RoleData对象
     * 
     * @return 成员实体对象
     */
    public RoleData displayRoleData(RoleData roleData) throws Exception
    {
        return roleDataDao.queryRoleData(roleData);
    }

    /**
     * 查询RoleData列表
     * 
     * @param roleData RoleData对象
     * 
     * @return RoleData列表
     */
    public List<RoleData> queryRoleDataList(RoleData roleData) throws Exception
    {
        return roleDataDao.queryRoleDataList(roleData);
    }

    /**
     * 获取RoleDataID
     */
    public String getRoleDataId() throws Exception
    {
    	return roleDataDao.getRoleDataId();
    }
}

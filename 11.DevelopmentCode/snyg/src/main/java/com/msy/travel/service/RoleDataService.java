package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.RoleData;

/**
 * RoleDataService接口
 * 
 * @author wootide
 * 
 */
public interface RoleDataService
{
    /**
     * 新增RoleData
     * 
     * @param roleData RoleData对象
     */
    public void createRoleData(RoleData roleData) throws Exception;
    
    /**
     * 检查RoleData
     * 
     * @param roleData RoleData对象
     */
    public void mergeRoleData(RoleData roleData) throws Exception;
  
    /**
     * 删除RoleData
     * 
     * @param roleData RoleData对象
     */
    public void deleteRoleData(RoleData roleData) throws Exception;
   
    /**
     * 批量删除RoleData
     * 
     * @param roleDataIdList  存放roleData主键的list
     */
    public void deleteBatchRoleData(RoleData roleData) throws Exception;  
    
    /**
     * 修改RoleData
     * 
     * @param roleData RoleData对象
     */
    public void updateRoleData(RoleData roleData) throws Exception;
    
    /**
     * 查询单个RoleData
     * 
     * @param roleData RoleData对象
     * 
     * @return RoleData实体对象
     */
    public RoleData displayRoleData(RoleData roleData) throws Exception;
  
   /**
     * 查询RoleData列表
     * 
     * @param roleData RoleData对象
     * 
     * @return RoleData列表
     */
    public List<RoleData> queryRoleDataList(RoleData roleData) throws Exception;

    /**
     * 获取RoleData主键ID
     */
    public String getRoleDataId() throws Exception;
}


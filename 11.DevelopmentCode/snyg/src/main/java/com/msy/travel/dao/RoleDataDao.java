package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.RoleData;
/**
 * RoleDataDao接口
 * 
 * @author wootide
 * 
 */
public interface RoleDataDao
{
    /**
     * 增加RoleData
     * 
     * @param roleData RoleData对象
     */
    void insertRoleData(RoleData roleData) throws Exception;
   
    /**
     * 检查RoleData
     * 
     * @param roleData RoleData对象
     */
    void mergeRoleData(RoleData roleData) throws Exception;
   
    /**
     * 删除RoleData
     * 
     * @param roleData 成语对象
     */
    void deleteRoleData(RoleData roleData) throws Exception;
    
    /**
     * 批量删除RoleData
     * 
     * @param ids ids
     */
    void deleteBatchRoleData(RoleData roleData) throws Exception;  
    
    /**
     * 修改RoleData
     * 
     * @param roleData RoleData对象
     */
    void updateRoleData(RoleData roleData) throws Exception;  
   
    /**
     * 查询单个RoleData信息
     * 
     * @param roleData RoleData对象
     * 
     * @return RoleData实体对象
     */
    RoleData queryRoleData(RoleData roleData) throws Exception;
    
    /**
     * 查询RoleData列表信息
     * 
     * @param roleData RoleData对象
     * 
     * @return RoleData列表
     */
    List<RoleData> queryRoleDataList(RoleData roleData) throws Exception;

    /**
     * 获取RoleDataID
     */
    String getRoleDataId() throws Exception;
}

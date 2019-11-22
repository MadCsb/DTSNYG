package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.ServiceCode;
/**
 * ServiceCodeDao接口
 * 
 * @author wootide
 * 
 */
public interface ServiceCodeDao
{
    /**
     * 增加ServiceCode
     * 
     * @param serviceCode ServiceCode对象
     */
    void insertServiceCode(ServiceCode serviceCode) throws Exception;
   
    /**
     * 检查ServiceCode
     * 
     * @param serviceCode ServiceCode对象
     */
    void mergeServiceCode(ServiceCode serviceCode) throws Exception;
   
    /**
     * 删除ServiceCode
     * 
     * @param serviceCode 成语对象
     */
    void deleteServiceCode(ServiceCode serviceCode) throws Exception;
    
    /**
     * 批量删除ServiceCode
     * 
     * @param ids ids
     */
    void deleteBatchServiceCode(ServiceCode serviceCode) throws Exception;  
    
    /**
     * 修改ServiceCode
     * 
     * @param serviceCode ServiceCode对象
     */
    void updateServiceCode(ServiceCode serviceCode) throws Exception;  
   
    /**
     * 查询单个ServiceCode信息
     * 
     * @param serviceCode ServiceCode对象
     * 
     * @return ServiceCode实体对象
     */
    ServiceCode queryServiceCode(ServiceCode serviceCode) throws Exception;
    
    /**
     * 查询ServiceCode列表信息
     * 
     * @param serviceCode ServiceCode对象
     * 
     * @return ServiceCode列表
     */
    List<ServiceCode> queryServiceCodeList(ServiceCode serviceCode) throws Exception;

    /**
     * 获取ServiceCodeID
     */
    String getServiceCodeId() throws Exception;
    
    ServiceCode queryServiceCodeByCustom(ServiceCode serviceCode);
}

package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.Accessrecord;
/**
 * AccessrecordDao接口
 * 
 * @author wootide
 * 
 */
public interface AccessrecordDao
{
    /**
     * 增加Accessrecord
     * 
     * @param accessrecord Accessrecord对象
     */
    void insertAccessrecord(Accessrecord accessrecord) throws Exception;
   
    /**
     * 检查Accessrecord
     * 
     * @param accessrecord Accessrecord对象
     */
    void mergeAccessrecord(Accessrecord accessrecord) throws Exception;
   
    /**
     * 删除Accessrecord
     * 
     * @param accessrecord 成语对象
     */
    void deleteAccessrecord(Accessrecord accessrecord) throws Exception;
    
    /**
     * 批量删除Accessrecord
     * 
     * @param ids ids
     */
    void deleteBatchAccessrecord(Accessrecord accessrecord) throws Exception;  
    
    /**
     * 修改Accessrecord
     * 
     * @param accessrecord Accessrecord对象
     */
    void updateAccessrecord(Accessrecord accessrecord) throws Exception;  
   
    /**
     * 查询单个Accessrecord信息
     * 
     * @param accessrecord Accessrecord对象
     * 
     * @return Accessrecord实体对象
     */
    Accessrecord queryAccessrecord(Accessrecord accessrecord) throws Exception;
    
    /**
     * 查询Accessrecord列表信息
     * 
     * @param accessrecord Accessrecord对象
     * 
     * @return Accessrecord列表
     */
    List<Accessrecord> queryAccessrecordList(Accessrecord accessrecord) throws Exception;

    /**
     * 获取AccessrecordID
     */
    String getAccessrecordId() throws Exception;
}

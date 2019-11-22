package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.Accessrecord;

/**
 * AccessrecordService接口
 * 
 * @author wootide
 * 
 */
public interface IAccessrecordService
{
    /**
     * 新增Accessrecord
     * 
     * @param accessrecord Accessrecord对象
     */
    public void createAccessrecord(Accessrecord accessrecord) throws Exception;
    
    /**
     * 检查Accessrecord
     * 
     * @param accessrecord Accessrecord对象
     */
    public void mergeAccessrecord(Accessrecord accessrecord) throws Exception;
  
    /**
     * 删除Accessrecord
     * 
     * @param accessrecord Accessrecord对象
     */
    public void deleteAccessrecord(Accessrecord accessrecord) throws Exception;
   
    /**
     * 批量删除Accessrecord
     * 
     * @param accessrecordIdList  存放accessrecord主键的list
     */
    public void deleteBatchAccessrecord(Accessrecord accessrecord) throws Exception;  
    
    /**
     * 修改Accessrecord
     * 
     * @param accessrecord Accessrecord对象
     */
    public void updateAccessrecord(Accessrecord accessrecord) throws Exception;
    
    /**
     * 查询单个Accessrecord
     * 
     * @param accessrecord Accessrecord对象
     * 
     * @return Accessrecord实体对象
     */
    public Accessrecord displayAccessrecord(Accessrecord accessrecord) throws Exception;
  
   /**
     * 查询Accessrecord列表
     * 
     * @param accessrecord Accessrecord对象
     * 
     * @return Accessrecord列表
     */
    public List<Accessrecord> queryAccessrecordList(Accessrecord accessrecord) throws Exception;

    /**
     * 获取Accessrecord主键ID
     */
    public String getAccessrecordId() throws Exception;
}


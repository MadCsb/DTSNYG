package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.UgMenuLink;

/**
 * UgMenuLinkService接口
 * 
 * @author wootide
 * 
 */
public interface UgMenuLinkService
{
    /**
     * 新增UgMenuLink
     * 
     * @param ugMenuLink UgMenuLink对象
     */
    public void createUgMenuLink(UgMenuLink ugMenuLink) throws Exception;
    
    /**
     * 检查UgMenuLink
     * 
     * @param ugMenuLink UgMenuLink对象
     */
    public void mergeUgMenuLink(UgMenuLink ugMenuLink) throws Exception;
  
    /**
     * 删除UgMenuLink
     * 
     * @param ugMenuLink UgMenuLink对象
     */
    public void deleteUgMenuLink(UgMenuLink ugMenuLink) throws Exception;
   
    /**
     * 批量删除UgMenuLink
     * 
     * @param ugMenuLinkIdList  存放ugMenuLink主键的list
     */
    public void deleteBatchUgMenuLink(UgMenuLink ugMenuLink) throws Exception;  
    
    /**
     * 修改UgMenuLink
     * 
     * @param ugMenuLink UgMenuLink对象
     */
    public void updateUgMenuLink(UgMenuLink ugMenuLink) throws Exception;
    
    /**
     * 查询单个UgMenuLink
     * 
     * @param ugMenuLink UgMenuLink对象
     * 
     * @return UgMenuLink实体对象
     */
    public UgMenuLink displayUgMenuLink(UgMenuLink ugMenuLink) throws Exception;
  
   /**
     * 查询UgMenuLink列表
     * 
     * @param ugMenuLink UgMenuLink对象
     * 
     * @return UgMenuLink列表
     */
    public List<UgMenuLink> queryUgMenuLinkList(UgMenuLink ugMenuLink) throws Exception;

    /**
     * 获取UgMenuLink主键ID
     */
    public String getUgMenuLinkId() throws Exception;

	public void deleteUgMenuLinkByGroupId(UgMenuLink ugMenuLink)throws Exception;
}


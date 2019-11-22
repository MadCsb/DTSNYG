package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.UgMenuLink;
/**
 * UgMenuLinkDao接口
 * 
 * @author wootide
 * 
 */
public interface UgMenuLinkDao
{
    /**
     * 增加UgMenuLink
     * 
     * @param ugMenuLink UgMenuLink对象
     */
    void insertUgMenuLink(UgMenuLink ugMenuLink) throws Exception;
   
    /**
     * 检查UgMenuLink
     * 
     * @param ugMenuLink UgMenuLink对象
     */
    void mergeUgMenuLink(UgMenuLink ugMenuLink) throws Exception;
   
    /**
     * 删除UgMenuLink
     * 
     * @param ugMenuLink 成语对象
     */
    void deleteUgMenuLink(UgMenuLink ugMenuLink) throws Exception;
    
    /**
     * 批量删除UgMenuLink
     * 
     * @param ids ids
     */
    void deleteBatchUgMenuLink(UgMenuLink ugMenuLink) throws Exception;  
    
    /**
     * 修改UgMenuLink
     * 
     * @param ugMenuLink UgMenuLink对象
     */
    void updateUgMenuLink(UgMenuLink ugMenuLink) throws Exception;  
   
    /**
     * 查询单个UgMenuLink信息
     * 
     * @param ugMenuLink UgMenuLink对象
     * 
     * @return UgMenuLink实体对象
     */
    UgMenuLink queryUgMenuLink(UgMenuLink ugMenuLink) throws Exception;
    
    /**
     * 查询UgMenuLink列表信息
     * 
     * @param ugMenuLink UgMenuLink对象
     * 
     * @return UgMenuLink列表
     */
    List<UgMenuLink> queryUgMenuLinkList(UgMenuLink ugMenuLink) throws Exception;

    /**
     * 获取UgMenuLinkID
     */
    String getUgMenuLinkId() throws Exception;

	void deleteUgMenuLinkByGroupId(UgMenuLink ugMenuLink)throws Exception;
}

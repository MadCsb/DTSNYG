package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.UgMenuButtonLlink;

/**
 * UgMenuButtonLlinkService接口
 * 
 * @author wootide
 * 
 */
public interface UgMenuButtonLlinkService
{
    /**
     * 新增UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     */
    public void createUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;
    
    /**
     * 检查UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     */
    public void mergeUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;
  
    /**
     * 删除UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     */
    public void deleteUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;
   
    /**
     * 批量删除UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlinkIdList  存放ugMenuButtonLlink主键的list
     */
    public void deleteBatchUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;  
    
    /**
     * 修改UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     */
    public void updateUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;
    
    /**
     * 查询单个UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     * 
     * @return UgMenuButtonLlink实体对象
     */
    public UgMenuButtonLlink displayUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;
  
   /**
     * 查询UgMenuButtonLlink列表
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     * 
     * @return UgMenuButtonLlink列表
     */
    public List<UgMenuButtonLlink> queryUgMenuButtonLlinkList(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;

    /**
     * 获取UgMenuButtonLlink主键ID
     */
    public String getUgMenuButtonLlinkId() throws Exception;

	public void deleteUgMenuButtonLlinkByGroupId(UgMenuButtonLlink ugMenuButtonLlink)throws Exception;
}


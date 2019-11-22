package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.UgMenuButtonLlink;
/**
 * UgMenuButtonLlinkDao接口
 * 
 * @author wootide
 * 
 */
public interface UgMenuButtonLlinkDao
{
    /**
     * 增加UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     */
    void insertUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;
   
    /**
     * 检查UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     */
    void mergeUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;
   
    /**
     * 删除UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlink 成语对象
     */
    void deleteUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;
    
    /**
     * 批量删除UgMenuButtonLlink
     * 
     * @param ids ids
     */
    void deleteBatchUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;  
    
    /**
     * 修改UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     */
    void updateUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;  
   
    /**
     * 查询单个UgMenuButtonLlink信息
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     * 
     * @return UgMenuButtonLlink实体对象
     */
    UgMenuButtonLlink queryUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;
    
    /**
     * 查询UgMenuButtonLlink列表信息
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     * 
     * @return UgMenuButtonLlink列表
     */
    List<UgMenuButtonLlink> queryUgMenuButtonLlinkList(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;

    /**
     * 获取UgMenuButtonLlinkID
     */
    String getUgMenuButtonLlinkId() throws Exception;

	void deleteUgMenuButtonLlinkByGroupId(UgMenuButtonLlink ugMenuButtonLlink) throws Exception;
}

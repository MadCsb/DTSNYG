package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.Linkinfo;
/**
 * LinkinfoDao接口
 * 
 * @author wootide
 * 
 */
public interface LinkinfoDao
{
    /**
     * 增加Linkinfo
     * 
     * @param linkinfo Linkinfo对象
     */
    void insertLinkinfo(Linkinfo linkinfo) throws Exception;
   
    /**
     * 检查Linkinfo
     * 
     * @param linkinfo Linkinfo对象
     */
    void mergeLinkinfo(Linkinfo linkinfo) throws Exception;
   
    /**
     * 删除Linkinfo
     * 
     * @param linkinfo 成语对象
     */
    void deleteLinkinfo(Linkinfo linkinfo) throws Exception;
    
    /**
     * 批量删除Linkinfo
     * 
     * @param ids ids
     */
    void deleteBatchLinkinfo(Linkinfo linkinfo) throws Exception;  
    
    /**
     * 修改Linkinfo
     * 
     * @param linkinfo Linkinfo对象
     */
    void updateLinkinfo(Linkinfo linkinfo) throws Exception;  
   
    /**
     * 查询单个Linkinfo信息
     * 
     * @param linkinfo Linkinfo对象
     * 
     * @return Linkinfo实体对象
     */
    Linkinfo queryLinkinfo(Linkinfo linkinfo) throws Exception;
    
    /**
     * 查询Linkinfo列表信息
     * 
     * @param linkinfo Linkinfo对象
     * 
     * @return Linkinfo列表
     */
    List<Linkinfo> queryLinkinfoList(Linkinfo linkinfo) throws Exception;

    /**
     * 获取LinkinfoID
     */
    String getLinkinfoId() throws Exception;
}

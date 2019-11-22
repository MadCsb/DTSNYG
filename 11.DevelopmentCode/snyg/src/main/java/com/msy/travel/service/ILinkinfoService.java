package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.Linkinfo;

/**
 * LinkinfoService接口
 * 
 * @author wootide
 * 
 */
public interface ILinkinfoService
{
    /**
     * 新增Linkinfo
     * 
     * @param linkinfo Linkinfo对象
     */
    public void createLinkinfo(Linkinfo linkinfo) throws Exception;
    
    /**
     * 检查Linkinfo
     * 
     * @param linkinfo Linkinfo对象
     */
    public void mergeLinkinfo(Linkinfo linkinfo) throws Exception;
  
    /**
     * 删除Linkinfo
     * 
     * @param linkinfo Linkinfo对象
     */
    public void deleteLinkinfo(Linkinfo linkinfo) throws Exception;
   
    /**
     * 批量删除Linkinfo
     * 
     * @param linkinfoIdList  存放linkinfo主键的list
     */
    public void deleteBatchLinkinfo(Linkinfo linkinfo) throws Exception;  
    
    /**
     * 修改Linkinfo
     * 
     * @param linkinfo Linkinfo对象
     */
    public void updateLinkinfo(Linkinfo linkinfo) throws Exception;
    
    /**
     * 查询单个Linkinfo
     * 
     * @param linkinfo Linkinfo对象
     * 
     * @return Linkinfo实体对象
     */
    public Linkinfo displayLinkinfo(Linkinfo linkinfo) throws Exception;
  
   /**
     * 查询Linkinfo列表
     * 
     * @param linkinfo Linkinfo对象
     * 
     * @return Linkinfo列表
     */
    public List<Linkinfo> queryLinkinfoList(Linkinfo linkinfo) throws Exception;

    /**
     * 获取Linkinfo主键ID
     */
    public String getLinkinfoId() throws Exception;
}


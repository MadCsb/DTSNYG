package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.BannerType;

/**
 * BannerTypeService接口
 * 
 * @author wootide
 * 
 */
public interface BannerTypeService
{
    /**
     * 新增BannerType
     * 
     * @param bannerType BannerType对象
     */
    public void createBannerType(BannerType bannerType) throws Exception;
    
    /**
     * 检查BannerType
     * 
     * @param bannerType BannerType对象
     */
    public void mergeBannerType(BannerType bannerType) throws Exception;
  
    /**
     * 删除BannerType
     * 
     * @param bannerType BannerType对象
     */
    public void deleteBannerType(BannerType bannerType) throws Exception;
   
    /**
     * 批量删除BannerType
     * 
     * @param bannerTypeIdList  存放bannerType主键的list
     */
    public void deleteBatchBannerType(BannerType bannerType) throws Exception;  
    
    /**
     * 修改BannerType
     * 
     * @param bannerType BannerType对象
     */
    public void updateBannerType(BannerType bannerType) throws Exception;
    
    /**
     * 查询单个BannerType
     * 
     * @param bannerType BannerType对象
     * 
     * @return BannerType实体对象
     */
    public BannerType displayBannerType(BannerType bannerType) throws Exception;
  
   /**
     * 查询BannerType列表
     * 
     * @param bannerType BannerType对象
     * 
     * @return BannerType列表
     */
    public List<BannerType> queryBannerTypeList(BannerType bannerType) throws Exception;

    /**
     * 获取BannerType主键ID
     */
    public String getBannerTypeId() throws Exception;
}


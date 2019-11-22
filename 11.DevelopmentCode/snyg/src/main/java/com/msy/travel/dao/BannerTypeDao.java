package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.BannerType;
/**
 * BannerTypeDao接口
 * 
 * @author wootide
 * 
 */
public interface BannerTypeDao
{
    /**
     * 增加BannerType
     * 
     * @param bannerType BannerType对象
     */
    void insertBannerType(BannerType bannerType) throws Exception;
   
    /**
     * 检查BannerType
     * 
     * @param bannerType BannerType对象
     */
    void mergeBannerType(BannerType bannerType) throws Exception;
   
    /**
     * 删除BannerType
     * 
     * @param bannerType 成语对象
     */
    void deleteBannerType(BannerType bannerType) throws Exception;
    
    /**
     * 批量删除BannerType
     * 
     * @param ids ids
     */
    void deleteBatchBannerType(BannerType bannerType) throws Exception;  
    
    /**
     * 修改BannerType
     * 
     * @param bannerType BannerType对象
     */
    void updateBannerType(BannerType bannerType) throws Exception;  
   
    /**
     * 查询单个BannerType信息
     * 
     * @param bannerType BannerType对象
     * 
     * @return BannerType实体对象
     */
    BannerType queryBannerType(BannerType bannerType) throws Exception;
    
    /**
     * 查询BannerType列表信息
     * 
     * @param bannerType BannerType对象
     * 
     * @return BannerType列表
     */
    List<BannerType> queryBannerTypeList(BannerType bannerType) throws Exception;

    /**
     * 获取BannerTypeID
     */
    String getBannerTypeId() throws Exception;
}

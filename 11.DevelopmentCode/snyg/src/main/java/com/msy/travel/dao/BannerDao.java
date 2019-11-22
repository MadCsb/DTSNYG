package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.Banner;
/**
 * BannerDao接口
 * 
 * @author wootide
 * 
 */
public interface BannerDao
{
    /**
     * 增加Banner
     * 
     * @param banner Banner对象
     */
    void insertBanner(Banner banner) throws Exception;
   
    /**
     * 检查Banner
     * 
     * @param banner Banner对象
     */
    void mergeBanner(Banner banner) throws Exception;
   
    /**
     * 删除Banner
     * 
     * @param banner 成语对象
     */
    void deleteBanner(Banner banner) throws Exception;
    
    /**
     * 批量删除Banner
     * 
     * @param ids ids
     */
    void deleteBatchBanner(Banner banner) throws Exception;  
    
    /**
     * 修改Banner
     * 
     * @param banner Banner对象
     */
    void updateBanner(Banner banner) throws Exception;  
   
    /**
     * 查询单个Banner信息
     * 
     * @param banner Banner对象
     * 
     * @return Banner实体对象
     */
    Banner queryBanner(Banner banner) throws Exception;
    
    /**
     * 查询Banner列表信息
     * 
     * @param banner Banner对象
     * 
     * @return Banner列表
     */
    List<Banner> queryBannerList(Banner banner) throws Exception;

    /**
     * 获取BannerID
     */
    String getBannerId() throws Exception;
}

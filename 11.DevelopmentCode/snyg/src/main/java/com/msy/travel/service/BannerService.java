package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.Banner;

/**
 * BannerService接口
 * 
 * @author wootide
 * 
 */
public interface BannerService
{
    /**
     * 新增Banner
     * 
     * @param banner Banner对象
     */
    public void createBanner(Banner banner) throws Exception;
    
    /**
     * 检查Banner
     * 
     * @param banner Banner对象
     */
    public void mergeBanner(Banner banner) throws Exception;
  
    /**
     * 删除Banner
     * 
     * @param banner Banner对象
     */
    public void deleteBanner(Banner banner) throws Exception;
   
    /**
     * 批量删除Banner
     * 
     * @param bannerIdList  存放banner主键的list
     */
    public void deleteBatchBanner(Banner banner) throws Exception;  
    
    /**
     * 修改Banner
     * 
     * @param banner Banner对象
     */
    public void updateBanner(Banner banner) throws Exception;
    
    /**
     * 查询单个Banner
     * 
     * @param banner Banner对象
     * 
     * @return Banner实体对象
     */
    public Banner displayBanner(Banner banner) throws Exception;
  
   /**
     * 查询Banner列表
     * 
     * @param banner Banner对象
     * 
     * @return Banner列表
     */
    public List<Banner> queryBannerList(Banner banner) throws Exception;

    /**
     * 获取Banner主键ID
     */
    public String getBannerId() throws Exception;
}


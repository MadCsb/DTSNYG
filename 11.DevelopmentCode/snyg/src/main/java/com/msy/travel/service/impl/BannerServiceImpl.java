package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.Banner;
import com.msy.travel.dao.BannerDao;
import com.msy.travel.service.BannerService;

/**
 * BannerService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class BannerServiceImpl implements BannerService
{

	@Resource(name="bannerDao")
    private BannerDao bannerDao;
    
    /**
     * 新增Banner
     * 
     * @param banner Banner对象
     */
    public void createBanner(Banner banner) throws Exception
    {
        bannerDao.insertBanner(banner);
    }
    /**
     * 检查Banner
     * 
     * @param banner Banner对象
     */
    public void mergeBanner(Banner banner) throws Exception
    {
    	bannerDao.mergeBanner(banner);
    }
    /**
     * 删除Banner
     * 
     * @param banner Banner对象
     */
    public void deleteBanner(Banner banner) throws Exception
    {
        bannerDao.deleteBanner(banner);
    }
   
    /**
     * 修改Banner
     * 
     * @param banner Banner对象
     */
    public void updateBanner(Banner banner) throws Exception
    {
        bannerDao.updateBanner(banner);
    }
    /**
     * 批量删除Banner
     * 
     * @param bannerIdList 存放banner主键的list
     */
    public void deleteBatchBanner(Banner banner) throws Exception
    {
    	bannerDao.deleteBatchBanner(banner);
    }  
    /**
     * 查询单个Banner
     * 
     * @param banner Banner对象
     * 
     * @return 成员实体对象
     */
    public Banner displayBanner(Banner banner) throws Exception
    {
        return bannerDao.queryBanner(banner);
    }

    /**
     * 查询Banner列表
     * 
     * @param banner Banner对象
     * 
     * @return Banner列表
     */
    public List<Banner> queryBannerList(Banner banner) throws Exception
    {
        return bannerDao.queryBannerList(banner);
    }

    /**
     * 获取BannerID
     */
    public String getBannerId() throws Exception
    {
    	return bannerDao.getBannerId();
    }
}

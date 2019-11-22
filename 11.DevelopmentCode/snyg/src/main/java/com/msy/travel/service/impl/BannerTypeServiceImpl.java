package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.BannerType;
import com.msy.travel.dao.BannerTypeDao;
import com.msy.travel.service.BannerTypeService;

/**
 * BannerTypeService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class BannerTypeServiceImpl implements BannerTypeService
{

	@Resource(name="bannerTypeDao")
    private BannerTypeDao bannerTypeDao;
    
    /**
     * 新增BannerType
     * 
     * @param bannerType BannerType对象
     */
    public void createBannerType(BannerType bannerType) throws Exception
    {
        bannerTypeDao.insertBannerType(bannerType);
    }
    /**
     * 检查BannerType
     * 
     * @param bannerType BannerType对象
     */
    public void mergeBannerType(BannerType bannerType) throws Exception
    {
    	bannerTypeDao.mergeBannerType(bannerType);
    }
    /**
     * 删除BannerType
     * 
     * @param bannerType BannerType对象
     */
    public void deleteBannerType(BannerType bannerType) throws Exception
    {
        bannerTypeDao.deleteBannerType(bannerType);
    }
   
    /**
     * 修改BannerType
     * 
     * @param bannerType BannerType对象
     */
    public void updateBannerType(BannerType bannerType) throws Exception
    {
        bannerTypeDao.updateBannerType(bannerType);
    }
    /**
     * 批量删除BannerType
     * 
     * @param bannerTypeIdList 存放bannerType主键的list
     */
    public void deleteBatchBannerType(BannerType bannerType) throws Exception
    {
    	bannerTypeDao.deleteBatchBannerType(bannerType);
    }  
    /**
     * 查询单个BannerType
     * 
     * @param bannerType BannerType对象
     * 
     * @return 成员实体对象
     */
    public BannerType displayBannerType(BannerType bannerType) throws Exception
    {
        return bannerTypeDao.queryBannerType(bannerType);
    }

    /**
     * 查询BannerType列表
     * 
     * @param bannerType BannerType对象
     * 
     * @return BannerType列表
     */
    public List<BannerType> queryBannerTypeList(BannerType bannerType) throws Exception
    {
        return bannerTypeDao.queryBannerTypeList(bannerType);
    }

    /**
     * 获取BannerTypeID
     */
    public String getBannerTypeId() throws Exception
    {
    	return bannerTypeDao.getBannerTypeId();
    }
}

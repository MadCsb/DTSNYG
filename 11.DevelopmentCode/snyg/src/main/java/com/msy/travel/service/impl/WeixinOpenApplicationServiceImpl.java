package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.WeixinOpenApplication;
import com.msy.travel.dao.WeixinOpenApplicationDao;
import com.msy.travel.service.WeixinOpenApplicationService;

/**
 * WeixinOpenApplicationService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class WeixinOpenApplicationServiceImpl implements WeixinOpenApplicationService
{

	@Resource(name="weixinOpenApplicationDao")
    private WeixinOpenApplicationDao weixinOpenApplicationDao;
    
    /**
     * 新增WeixinOpenApplication
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     */
    public void createWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception
    {
        weixinOpenApplicationDao.insertWeixinOpenApplication(weixinOpenApplication);
    }
    /**
     * 检查WeixinOpenApplication
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     */
    public void mergeWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception
    {
    	weixinOpenApplicationDao.mergeWeixinOpenApplication(weixinOpenApplication);
    }
    /**
     * 删除WeixinOpenApplication
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     */
    public void deleteWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception
    {
        weixinOpenApplicationDao.deleteWeixinOpenApplication(weixinOpenApplication);
    }
   
    /**
     * 修改WeixinOpenApplication
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     */
    public void updateWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception
    {
        weixinOpenApplicationDao.updateWeixinOpenApplication(weixinOpenApplication);
    }
    /**
     * 批量删除WeixinOpenApplication
     * 
     * @param weixinOpenApplicationIdList 存放weixinOpenApplication主键的list
     */
    public void deleteBatchWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception
    {
    	weixinOpenApplicationDao.deleteBatchWeixinOpenApplication(weixinOpenApplication);
    }  
    /**
     * 查询单个WeixinOpenApplication
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     * 
     * @return 成员实体对象
     */
    public WeixinOpenApplication displayWeixinOpenApplication(WeixinOpenApplication weixinOpenApplication) throws Exception
    {
        return weixinOpenApplicationDao.queryWeixinOpenApplication(weixinOpenApplication);
    }

    /**
     * 查询WeixinOpenApplication列表
     * 
     * @param weixinOpenApplication WeixinOpenApplication对象
     * 
     * @return WeixinOpenApplication列表
     */
    public List<WeixinOpenApplication> queryWeixinOpenApplicationList(WeixinOpenApplication weixinOpenApplication) throws Exception
    {
        return weixinOpenApplicationDao.queryWeixinOpenApplicationList(weixinOpenApplication);
    }

    /**
     * 获取WeixinOpenApplicationID
     */
    public String getWeixinOpenApplicationId() throws Exception
    {
    	return weixinOpenApplicationDao.getWeixinOpenApplicationId();
    }
}

package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.pojo.Linkinfo;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.dao.LinkinfoDao;
import com.msy.travel.service.ILinkinfoService;

/**
 * LinkinfoService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class LinkinfoServiceImpl implements ILinkinfoService
{

	@Resource(name="linkinfoDao")
    private LinkinfoDao linkinfoDao;
    
    /**
     * 新增Linkinfo
     * 
     * @param linkinfo Linkinfo对象
     */
    public void createLinkinfo(Linkinfo linkinfo) throws Exception
    {
    	linkinfo.setLinkId(PrimaryKeyUtil.generateKey());
        linkinfoDao.insertLinkinfo(linkinfo);
    }
    /**
     * 检查Linkinfo
     * 
     * @param linkinfo Linkinfo对象
     */
    public void mergeLinkinfo(Linkinfo linkinfo) throws Exception
    {
    	linkinfoDao.mergeLinkinfo(linkinfo);
    }
    /**
     * 删除Linkinfo
     * 
     * @param linkinfo Linkinfo对象
     */
    public void deleteLinkinfo(Linkinfo linkinfo) throws Exception
    {
        linkinfoDao.deleteLinkinfo(linkinfo);
    }
   
    /**
     * 修改Linkinfo
     * 
     * @param linkinfo Linkinfo对象
     */
    public void updateLinkinfo(Linkinfo linkinfo) throws Exception
    {
        linkinfoDao.updateLinkinfo(linkinfo);
    }
    /**
     * 批量删除Linkinfo
     * 
     * @param linkinfoIdList 存放linkinfo主键的list
     */
    public void deleteBatchLinkinfo(Linkinfo linkinfo) throws Exception
    {
    	linkinfoDao.deleteBatchLinkinfo(linkinfo);
    }  
    /**
     * 查询单个Linkinfo
     * 
     * @param linkinfo Linkinfo对象
     * 
     * @return 成员实体对象
     */
    public Linkinfo displayLinkinfo(Linkinfo linkinfo) throws Exception
    {
        return linkinfoDao.queryLinkinfo(linkinfo);
    }

    /**
     * 查询Linkinfo列表
     * 
     * @param linkinfo Linkinfo对象
     * 
     * @return Linkinfo列表
     */
    public List<Linkinfo> queryLinkinfoList(Linkinfo linkinfo) throws Exception
    {
        return linkinfoDao.queryLinkinfoList(linkinfo);
    }

    /**
     * 获取LinkinfoID
     */
    public String getLinkinfoId() throws Exception
    {
    	return linkinfoDao.getLinkinfoId();
    }
}

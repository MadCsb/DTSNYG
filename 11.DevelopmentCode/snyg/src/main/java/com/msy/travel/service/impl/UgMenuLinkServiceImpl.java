package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.pojo.UgMenuLink;
import com.msy.travel.dao.UgMenuLinkDao;
import com.msy.travel.service.UgMenuLinkService;

/**
 * UgMenuLinkService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class UgMenuLinkServiceImpl implements UgMenuLinkService
{

	@Resource(name="ugMenuLinkDao")
    private UgMenuLinkDao ugMenuLinkDao;
    
    /**
     * 新增UgMenuLink
     * 
     * @param ugMenuLink UgMenuLink对象
     */
    public void createUgMenuLink(UgMenuLink ugMenuLink) throws Exception
    {
        ugMenuLinkDao.insertUgMenuLink(ugMenuLink);
    }
    /**
     * 检查UgMenuLink
     * 
     * @param ugMenuLink UgMenuLink对象
     */
    public void mergeUgMenuLink(UgMenuLink ugMenuLink) throws Exception
    {
    	ugMenuLinkDao.mergeUgMenuLink(ugMenuLink);
    }
    /**
     * 删除UgMenuLink
     * 
     * @param ugMenuLink UgMenuLink对象
     */
    public void deleteUgMenuLink(UgMenuLink ugMenuLink) throws Exception
    {
        ugMenuLinkDao.deleteUgMenuLink(ugMenuLink);
    }
   
    /**
     * 修改UgMenuLink
     * 
     * @param ugMenuLink UgMenuLink对象
     */
    public void updateUgMenuLink(UgMenuLink ugMenuLink) throws Exception
    {
        ugMenuLinkDao.updateUgMenuLink(ugMenuLink);
    }
    /**
     * 批量删除UgMenuLink
     * 
     * @param ugMenuLinkIdList 存放ugMenuLink主键的list
     */
    public void deleteBatchUgMenuLink(UgMenuLink ugMenuLink) throws Exception
    {
    	ugMenuLinkDao.deleteBatchUgMenuLink(ugMenuLink);
    }  
    /**
     * 查询单个UgMenuLink
     * 
     * @param ugMenuLink UgMenuLink对象
     * 
     * @return 成员实体对象
     */
    public UgMenuLink displayUgMenuLink(UgMenuLink ugMenuLink) throws Exception
    {
        return ugMenuLinkDao.queryUgMenuLink(ugMenuLink);
    }

    /**
     * 查询UgMenuLink列表
     * 
     * @param ugMenuLink UgMenuLink对象
     * 
     * @return UgMenuLink列表
     */
    public List<UgMenuLink> queryUgMenuLinkList(UgMenuLink ugMenuLink) throws Exception
    {
        return ugMenuLinkDao.queryUgMenuLinkList(ugMenuLink);
    }

    /**
     * 获取UgMenuLinkID
     */
    public String getUgMenuLinkId() throws Exception
    {
    	return ugMenuLinkDao.getUgMenuLinkId();
    }
	@Override
	public void deleteUgMenuLinkByGroupId(UgMenuLink ugMenuLink)throws Exception 
	{
		ugMenuLinkDao.deleteUgMenuLinkByGroupId(ugMenuLink);
	}
}

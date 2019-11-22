package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.pojo.UgMenuButtonLlink;
import com.msy.travel.dao.UgMenuButtonLlinkDao;
import com.msy.travel.service.UgMenuButtonLlinkService;

/**
 * UgMenuButtonLlinkService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class UgMenuButtonLlinkServiceImpl implements UgMenuButtonLlinkService
{

	@Resource(name="ugMenuButtonLlinkDao")
    private UgMenuButtonLlinkDao ugMenuButtonLlinkDao;
    
    /**
     * 新增UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     */
    public void createUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception
    {
        ugMenuButtonLlinkDao.insertUgMenuButtonLlink(ugMenuButtonLlink);
    }
    /**
     * 检查UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     */
    public void mergeUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception
    {
    	ugMenuButtonLlinkDao.mergeUgMenuButtonLlink(ugMenuButtonLlink);
    }
    /**
     * 删除UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     */
    public void deleteUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception
    {
        ugMenuButtonLlinkDao.deleteUgMenuButtonLlink(ugMenuButtonLlink);
    }
   
    /**
     * 修改UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     */
    public void updateUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception
    {
        ugMenuButtonLlinkDao.updateUgMenuButtonLlink(ugMenuButtonLlink);
    }
    /**
     * 批量删除UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlinkIdList 存放ugMenuButtonLlink主键的list
     */
    public void deleteBatchUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception
    {
    	ugMenuButtonLlinkDao.deleteBatchUgMenuButtonLlink(ugMenuButtonLlink);
    }  
    /**
     * 查询单个UgMenuButtonLlink
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     * 
     * @return 成员实体对象
     */
    public UgMenuButtonLlink displayUgMenuButtonLlink(UgMenuButtonLlink ugMenuButtonLlink) throws Exception
    {
        return ugMenuButtonLlinkDao.queryUgMenuButtonLlink(ugMenuButtonLlink);
    }

    /**
     * 查询UgMenuButtonLlink列表
     * 
     * @param ugMenuButtonLlink UgMenuButtonLlink对象
     * 
     * @return UgMenuButtonLlink列表
     */
    public List<UgMenuButtonLlink> queryUgMenuButtonLlinkList(UgMenuButtonLlink ugMenuButtonLlink) throws Exception
    {
        return ugMenuButtonLlinkDao.queryUgMenuButtonLlinkList(ugMenuButtonLlink);
    }

    /**
     * 获取UgMenuButtonLlinkID
     */
    public String getUgMenuButtonLlinkId() throws Exception
    {
    	return ugMenuButtonLlinkDao.getUgMenuButtonLlinkId();
    }
	@Override
	public void deleteUgMenuButtonLlinkByGroupId(UgMenuButtonLlink ugMenuButtonLlink) throws Exception {
		ugMenuButtonLlinkDao.deleteUgMenuButtonLlinkByGroupId(ugMenuButtonLlink);
		
	}
}

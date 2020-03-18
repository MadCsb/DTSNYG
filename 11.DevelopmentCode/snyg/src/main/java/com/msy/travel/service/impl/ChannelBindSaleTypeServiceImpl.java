package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.ChannelBindSaleType;
import com.msy.travel.dao.ChannelBindSaleTypeDao;
import com.msy.travel.service.ChannelBindSaleTypeService;

/**
 * ChannelBindSaleTypeService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class ChannelBindSaleTypeServiceImpl implements ChannelBindSaleTypeService
{

	@Resource(name="channelBindSaleTypeDao")
    private ChannelBindSaleTypeDao channelBindSaleTypeDao;
    
    /**
     * 新增ChannelBindSaleType
     * 
     * @param channelBindSaleType ChannelBindSaleType对象
     */
    public void createChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception
    {
        channelBindSaleTypeDao.insertChannelBindSaleType(channelBindSaleType);
    }
    /**
     * 检查ChannelBindSaleType
     * 
     * @param channelBindSaleType ChannelBindSaleType对象
     */
    public void mergeChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception
    {
    	channelBindSaleTypeDao.mergeChannelBindSaleType(channelBindSaleType);
    }
    /**
     * 删除ChannelBindSaleType
     * 
     * @param channelBindSaleType ChannelBindSaleType对象
     */
    public void deleteChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception
    {
        channelBindSaleTypeDao.deleteChannelBindSaleType(channelBindSaleType);
    }
   
    /**
     * 修改ChannelBindSaleType
     * 
     * @param channelBindSaleType ChannelBindSaleType对象
     */
    public void updateChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception
    {
        channelBindSaleTypeDao.updateChannelBindSaleType(channelBindSaleType);
    }
    /**
     * 批量删除ChannelBindSaleType
     * 
     * @param channelBindSaleTypeIdList 存放channelBindSaleType主键的list
     */
    public void deleteBatchChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception
    {
    	channelBindSaleTypeDao.deleteBatchChannelBindSaleType(channelBindSaleType);
    }  
    /**
     * 查询单个ChannelBindSaleType
     * 
     * @param channelBindSaleType ChannelBindSaleType对象
     * 
     * @return 成员实体对象
     */
    public ChannelBindSaleType displayChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception
    {
        return channelBindSaleTypeDao.queryChannelBindSaleType(channelBindSaleType);
    }

    /**
     * 查询ChannelBindSaleType列表
     * 
     * @param channelBindSaleType ChannelBindSaleType对象
     * 
     * @return ChannelBindSaleType列表
     */
    public List<ChannelBindSaleType> queryChannelBindSaleTypeList(ChannelBindSaleType channelBindSaleType) throws Exception
    {
        return channelBindSaleTypeDao.queryChannelBindSaleTypeList(channelBindSaleType);
    }

    /**
     * 获取ChannelBindSaleTypeID
     */
    public String getChannelBindSaleTypeId() throws Exception
    {
    	return channelBindSaleTypeDao.getChannelBindSaleTypeId();
    }
}

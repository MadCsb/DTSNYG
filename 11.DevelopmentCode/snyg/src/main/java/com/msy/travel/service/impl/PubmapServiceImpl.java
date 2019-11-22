package com.msy.travel.service.impl;

import com.msy.travel.dao.PubmapDao;
import com.msy.travel.pojo.Pubmap;
import com.msy.travel.service.IPubmapService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * PubmapService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class PubmapServiceImpl implements IPubmapService
{

	@Resource(name="pubmapDao")
    private PubmapDao pubmapDao;

    /**
     * 根据类型获得所有的pubmap
     * @param mapType
     * @return
     */
    public List<Pubmap> getPubmapListByType(String mapType) throws Exception{
    	return pubmapDao.getPubmapListByType(mapType);
    }
}

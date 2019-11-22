package com.msy.travel.dao;

import com.msy.travel.pojo.Pubmap;

import java.util.List;

/**
 * PubmapDao接口
 * 
 * @author wootide
 * 
 */
public interface PubmapDao
{
    /**
     * 根据类型获得所有的pubmap
     * @param mapType
     * @return
     */
    List<Pubmap> getPubmapListByType(String mapType) throws Exception;
}

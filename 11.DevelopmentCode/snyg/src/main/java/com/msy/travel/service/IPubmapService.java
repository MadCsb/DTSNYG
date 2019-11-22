package com.msy.travel.service;

import com.msy.travel.pojo.Pubmap;

import java.util.List;

/**
 * PubmapService接口
 * 
 * @author wootide
 * 
 */
public interface IPubmapService
{

    /**
     * 根据类型获得所有的pubmap
     * @param mapType
     * @return
     */
    public List<Pubmap> getPubmapListByType(String mapType) throws Exception;
}


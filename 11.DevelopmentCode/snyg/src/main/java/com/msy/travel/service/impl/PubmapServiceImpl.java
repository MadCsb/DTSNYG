package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.dao.PubmapDao;
import com.msy.travel.pojo.Pubmap;
import com.msy.travel.service.IPubmapService;

/**
 * PubmapService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class PubmapServiceImpl implements IPubmapService {

	@Resource(name = "pubmapDao")
	private PubmapDao pubmapDao;

	/**
	 * 根据类型获得所有的pubmap
	 * 
	 * @param mapType
	 * @return
	 */
	public List<Pubmap> getPubmapListByType(String mapType) throws Exception {
		return pubmapDao.getPubmapListByType(mapType);
	}

	@Override
	public void insertPubmap(Pubmap pubmap) throws Exception {
		pubmap.setMapId(PrimaryKeyUtil.generateKey());
		pubmapDao.insertPubmap(pubmap);
	}

	@Override
	public void updatePubmap(Pubmap pubmap) throws Exception {
		pubmapDao.updatePubmap(pubmap);
	}

	@Override
	public void deletePubmap(Pubmap pubmap) throws Exception {
		pubmapDao.deletePubmap(pubmap);
	}

	@Override
	public void deleteBatchPubmap(Pubmap pubmap) throws Exception {
		pubmapDao.deleteBatchPubmap(pubmap);
	}

	@Override
	public Pubmap displayPubmap(Pubmap pubmap) throws Exception {
		return pubmapDao.queryPubmap(pubmap);
	}

	@Override
	public List<Pubmap> queryPubmapList(Pubmap pubmap) throws Exception {
		return pubmapDao.queryPubmapList(pubmap);
	}

	@Override
	public List<Pubmap> getAllDesc() {
		return pubmapDao.getAllDesc();
	}
}

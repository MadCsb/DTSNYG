package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.pojo.Destsp;
import com.msy.travel.dao.DestspDao;
import com.msy.travel.service.IDestspService;

/**
 * DestspService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class DestspServiceImpl implements IDestspService {

	@Resource(name = "destspDao")
	private DestspDao destspDao;

	/**
	 * 新增Destsp
	 * 
	 * @param destsp
	 *            Destsp对象
	 */
	public void createDestsp(Destsp destsp) throws Exception {
		destspDao.insertDestsp(destsp);
	}

	/**
	 * 检查Destsp
	 * 
	 * @param destsp
	 *            Destsp对象
	 */
	public void mergeDestsp(Destsp destsp) throws Exception {
		destspDao.mergeDestsp(destsp);
	}

	/**
	 * 删除Destsp
	 * 
	 * @param destsp
	 *            Destsp对象
	 */
	public void deleteDestsp(Destsp destsp) throws Exception {
		destspDao.deleteDestsp(destsp);
	}

	/**
	 * 修改Destsp
	 * 
	 * @param destsp
	 *            Destsp对象
	 */
	public void updateDestsp(Destsp destsp) throws Exception {
		destspDao.updateDestsp(destsp);
	}

	/**
	 * 批量删除Destsp
	 * 
	 * @param destspIdList
	 *            存放destsp主键的list
	 */
	public void deleteBatchDestsp(Destsp destsp) throws Exception {
		destspDao.deleteBatchDestsp(destsp);
	}

	/**
	 * 查询单个Destsp
	 * 
	 * @param destsp
	 *            Destsp对象
	 * 
	 * @return 成员实体对象
	 */
	public Destsp displayDestsp(Destsp destsp) throws Exception {
		return destspDao.queryDestsp(destsp);
	}

	/**
	 * 查询Destsp列表
	 * 
	 * @param destsp
	 *            Destsp对象
	 * 
	 * @return Destsp列表
	 */
	public List<Destsp> queryDestspList(Destsp destsp) throws Exception {
		return destspDao.queryDestspList(destsp);
	}

	/**
	 * 获取DestspID
	 */
	public String getDestspId() throws Exception {
		return destspDao.getDestspId();
	}

	/**
	 * 根据支撑商ID获取微信服务号
	 * 
	 * @param spId
	 * @return
	 * @throws Exception
	 */
	public String getWxServiceIdBySpId(String spId) throws Exception {

		String wxServiceId = "";

		Destsp destsp = new Destsp();
		destsp.setSpId(spId);
		destsp = destspDao.queryDestsp(destsp);

		if (destsp != null) {
			wxServiceId = destsp.getWxServiceId();
		}

		return wxServiceId;
	}

	/**
	 * 根据微信服务号获取支撑商ID
	 * 
	 * @param spId
	 * @return
	 * @throws Exception
	 */
	public String getSpIdByWxServiceId(String wxServiceId) throws Exception {

		String spId = "";

		Destsp destsp = new Destsp();
		destsp.setWxServiceId(wxServiceId);
		List<Destsp> destspList = destspDao.queryDestspList(destsp);

		if (destspList != null && destspList.size() > 0) {
			spId = destspList.get(0).getSpId();
		}

		return spId;
	}
}

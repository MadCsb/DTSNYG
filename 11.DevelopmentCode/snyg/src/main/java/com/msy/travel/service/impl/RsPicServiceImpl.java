package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.dao.RsPicDao;
import com.msy.travel.pojo.RsPic;
import com.msy.travel.service.IRsPicService;

/**
 * RsPicService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class RsPicServiceImpl implements IRsPicService {

	@Resource(name = "rsPicDao")
	private RsPicDao rsPicDao;

	/**
	 * 新增RsPic
	 * 
	 * @param rsPic
	 *            RsPic对象
	 */
	public void createRsPic(RsPic rsPic) throws Exception {
		rsPic.setPicId(PrimaryKeyUtil.generateKey());
		rsPicDao.insertRsPic(rsPic);
	}

	/**
	 * 检查RsPic
	 * 
	 * @param rsPic
	 *            RsPic对象
	 */
	public void mergeRsPic(RsPic rsPic) throws Exception {
		rsPicDao.mergeRsPic(rsPic);
	}

	/**
	 * 删除RsPic
	 * 
	 * @param rsPic
	 *            RsPic对象
	 */
	public void deleteRsPic(RsPic rsPic) throws Exception {
		rsPicDao.deleteRsPic(rsPic);
	}

	/**
	 * 修改RsPic
	 * 
	 * @param rsPic
	 *            RsPic对象
	 */
	public void updateRsPic(RsPic rsPic) throws Exception {
		rsPicDao.updateRsPic(rsPic);
	}

	/**
	 * 批量删除RsPic
	 * 
	 * @param rsPicIdList
	 *            存放rsPic主键的list
	 */
	public void deleteBatchRsPic(RsPic rsPic) throws Exception {
		rsPicDao.deleteBatchRsPic(rsPic);
	}

	/**
	 * 查询单个RsPic
	 * 
	 * @param rsPic
	 *            RsPic对象
	 * 
	 * @return 成员实体对象
	 */
	public RsPic displayRsPic(RsPic rsPic) throws Exception {
		return rsPicDao.queryRsPic(rsPic);
	}

	/**
	 * 查询RsPic列表
	 * 
	 * @param rsPic
	 *            RsPic对象
	 * 
	 * @return RsPic列表
	 */
	public List<RsPic> queryRsPicList(RsPic rsPic) throws Exception {
		return rsPicDao.queryRsPicList(rsPic);
	}

	/**
	 * 获取RsPicID
	 */
	public String getRsPicId() throws Exception {
		return rsPicDao.getRsPicId();
	}

	@Override
	public void saveRsPic(String[] picIds, String rsId) throws Exception {
		// TODO Auto-generated method stub
		if (picIds != null) {
			int length = picIds.length;
			for (int i = 0; i < length; i++) {
				RsPic rsPic = new RsPic();
				rsPic.setPicId(picIds[i]);
				rsPic = this.rsPicDao.queryRsPic(rsPic);
				rsPic.setRsId(rsId);
				rsPic.setPicOrder((i + 1) + "");
				this.rsPicDao.updateRsPic(rsPic);
			}
		}
	}
}

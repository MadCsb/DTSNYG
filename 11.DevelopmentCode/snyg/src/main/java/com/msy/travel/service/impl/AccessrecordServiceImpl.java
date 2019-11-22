package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.dao.AccessrecordDao;
import com.msy.travel.pojo.Accessrecord;
import com.msy.travel.service.IAccessrecordService;

/**
 * AccessrecordService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class AccessrecordServiceImpl implements IAccessrecordService {

	@Resource(name = "accessrecordDao")
	private AccessrecordDao accessrecordDao;

	/**
	 * 新增Accessrecord
	 * 
	 * @param accessrecord
	 *            Accessrecord对象
	 */
	public void createAccessrecord(Accessrecord accessrecord) throws Exception {
		accessrecord.setRecordId(PrimaryKeyUtil.generateKey());
		accessrecordDao.insertAccessrecord(accessrecord);
	}

	/**
	 * 检查Accessrecord
	 * 
	 * @param accessrecord
	 *            Accessrecord对象
	 */
	public void mergeAccessrecord(Accessrecord accessrecord) throws Exception {
		accessrecordDao.mergeAccessrecord(accessrecord);
	}

	/**
	 * 删除Accessrecord
	 * 
	 * @param accessrecord
	 *            Accessrecord对象
	 */
	public void deleteAccessrecord(Accessrecord accessrecord) throws Exception {
		accessrecordDao.deleteAccessrecord(accessrecord);
	}

	/**
	 * 修改Accessrecord
	 * 
	 * @param accessrecord
	 *            Accessrecord对象
	 */
	public void updateAccessrecord(Accessrecord accessrecord) throws Exception {
		accessrecordDao.updateAccessrecord(accessrecord);
	}

	/**
	 * 批量删除Accessrecord
	 * 
	 * @param accessrecordIdList
	 *            存放accessrecord主键的list
	 */
	public void deleteBatchAccessrecord(Accessrecord accessrecord) throws Exception {
		accessrecordDao.deleteBatchAccessrecord(accessrecord);
	}

	/**
	 * 查询单个Accessrecord
	 * 
	 * @param accessrecord
	 *            Accessrecord对象
	 * 
	 * @return 成员实体对象
	 */
	public Accessrecord displayAccessrecord(Accessrecord accessrecord) throws Exception {
		return accessrecordDao.queryAccessrecord(accessrecord);
	}

	/**
	 * 查询Accessrecord列表
	 * 
	 * @param accessrecord
	 *            Accessrecord对象
	 * 
	 * @return Accessrecord列表
	 */
	public List<Accessrecord> queryAccessrecordList(Accessrecord accessrecord) throws Exception {
		return accessrecordDao.queryAccessrecordList(accessrecord);
	}

	/**
	 * 获取AccessrecordID
	 */
	public String getAccessrecordId() throws Exception {
		return accessrecordDao.getAccessrecordId();
	}
}

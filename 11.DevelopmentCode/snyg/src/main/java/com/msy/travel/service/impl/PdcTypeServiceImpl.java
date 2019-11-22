package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.dao.PdcTypeDao;
import com.msy.travel.pojo.PdcType;
import com.msy.travel.service.PdcTypeService;

/**
 * PdcTypeService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class PdcTypeServiceImpl implements PdcTypeService {

	@Resource(name = "pdcTypeDao")
	private PdcTypeDao pdcTypeDao;

	/**
	 * 新增PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 */
	public void createPdcType(PdcType pdcType) throws Exception {
		pdcTypeDao.insertPdcType(pdcType);
	}

	/**
	 * 检查PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 */
	public void mergePdcType(PdcType pdcType) throws Exception {
		pdcTypeDao.mergePdcType(pdcType);
	}

	/**
	 * 删除PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 */
	public void deletePdcType(PdcType pdcType) throws Exception {
		pdcTypeDao.deletePdcType(pdcType);
	}

	/**
	 * 修改PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 */
	public void updatePdcType(PdcType pdcType) throws Exception {
		pdcTypeDao.updatePdcType(pdcType);
	}

	/**
	 * 批量删除PdcType
	 * 
	 * @param pdcTypeIdList
	 *            存放pdcType主键的list
	 */
	public void deleteBatchPdcType(PdcType pdcType) throws Exception {
		pdcTypeDao.deleteBatchPdcType(pdcType);
	}

	/**
	 * 查询单个PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 * 
	 * @return 成员实体对象
	 */
	public PdcType displayPdcType(PdcType pdcType) throws Exception {
		return pdcTypeDao.queryPdcType(pdcType);
	}

	/**
	 * 查询PdcType列表
	 * 
	 * @param pdcType
	 *            PdcType对象
	 * 
	 * @return PdcType列表
	 */
	public List<PdcType> queryPdcTypeList(PdcType pdcType) throws Exception {
		return pdcTypeDao.queryPdcTypeList(pdcType);
	}

	/**
	 * 获取PdcTypeID
	 */
	public String getPdcTypeId() throws Exception {
		return pdcTypeDao.getPdcTypeId();
	}

	/**
	 * 删除PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 */
	public void deletePdcTypeAndSub(PdcType pdcType) throws Exception {
		PdcType p = new PdcType();
		p.setDelFlag("1");
		p.setPpdcTypeId(pdcType.getPdcTypeId());
		pdcTypeDao.deletePdcType(pdcType);

		pdcType.setDelFlag("1");
		pdcTypeDao.deletePdcType(pdcType);

	}

	/**
	 * 判断名称是否存在
	 * 
	 * @author wzd
	 * @date 2019年10月13日 下午8:56:36
	 * @param pdcType
	 * @return
	 * @throws Exception
	 * @return int
	 */
	public int queryPdcTypeNameExis(PdcType pdcType) throws Exception {
		return pdcTypeDao.queryPdcTypeNameExis(pdcType);
	}
}

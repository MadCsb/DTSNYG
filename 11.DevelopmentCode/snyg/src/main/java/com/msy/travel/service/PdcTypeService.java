package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.PdcType;

/**
 * PdcTypeService接口
 * 
 * @author wootide
 * 
 */
public interface PdcTypeService {
	/**
	 * 新增PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 */
	public void createPdcType(PdcType pdcType) throws Exception;

	/**
	 * 检查PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 */
	public void mergePdcType(PdcType pdcType) throws Exception;

	/**
	 * 删除PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 */
	public void deletePdcType(PdcType pdcType) throws Exception;

	/**
	 * 批量删除PdcType
	 * 
	 * @param pdcTypeIdList
	 *            存放pdcType主键的list
	 */
	public void deleteBatchPdcType(PdcType pdcType) throws Exception;

	/**
	 * 修改PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 */
	public void updatePdcType(PdcType pdcType) throws Exception;

	/**
	 * 查询单个PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 * 
	 * @return PdcType实体对象
	 */
	public PdcType displayPdcType(PdcType pdcType) throws Exception;

	/**
	 * 查询PdcType列表
	 * 
	 * @param pdcType
	 *            PdcType对象
	 * 
	 * @return PdcType列表
	 */
	public List<PdcType> queryPdcTypeList(PdcType pdcType) throws Exception;

	/**
	 * 获取PdcType主键ID
	 */
	public String getPdcTypeId() throws Exception;

	/**
	 * 删除PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 */
	public void deletePdcTypeAndSub(PdcType pdcType) throws Exception;

	/**
	 * 
	 * @author wzd
	 * @date 2019年10月13日 下午8:56:36
	 * @param pdcType
	 * @return
	 * @throws Exception
	 * @return int
	 */
	int queryPdcTypeNameExis(PdcType pdcType) throws Exception;
}

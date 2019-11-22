package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.PdcType;

/**
 * PdcTypeDao接口
 * 
 * @author wootide
 * 
 */
public interface PdcTypeDao {
	/**
	 * 增加PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 */
	void insertPdcType(PdcType pdcType) throws Exception;

	/**
	 * 检查PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 */
	void mergePdcType(PdcType pdcType) throws Exception;

	/**
	 * 删除PdcType
	 * 
	 * @param pdcType
	 *            成语对象
	 */
	void deletePdcType(PdcType pdcType) throws Exception;

	/**
	 * 批量删除PdcType
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchPdcType(PdcType pdcType) throws Exception;

	/**
	 * 修改PdcType
	 * 
	 * @param pdcType
	 *            PdcType对象
	 */
	void updatePdcType(PdcType pdcType) throws Exception;

	/**
	 * 查询单个PdcType信息
	 * 
	 * @param pdcType
	 *            PdcType对象
	 * 
	 * @return PdcType实体对象
	 */
	PdcType queryPdcType(PdcType pdcType) throws Exception;

	/**
	 * 查询PdcType列表信息
	 * 
	 * @param pdcType
	 *            PdcType对象
	 * 
	 * @return PdcType列表
	 */
	List<PdcType> queryPdcTypeList(PdcType pdcType) throws Exception;

	/**
	 * 获取PdcTypeID
	 */
	String getPdcTypeId() throws Exception;

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

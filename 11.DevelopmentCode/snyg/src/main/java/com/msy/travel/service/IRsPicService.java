package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.RsPic;

/**
 * RsPicService接口
 * 
 * @author wootide
 * 
 */
public interface IRsPicService {
	/**
	 * 新增RsPic
	 * 
	 * @param rsPic
	 *            RsPic对象
	 */
	public void createRsPic(RsPic rsPic) throws Exception;

	/**
	 * 检查RsPic
	 * 
	 * @param rsPic
	 *            RsPic对象
	 */
	public void mergeRsPic(RsPic rsPic) throws Exception;

	/**
	 * 删除RsPic
	 * 
	 * @param rsPic
	 *            RsPic对象
	 */
	public void deleteRsPic(RsPic rsPic) throws Exception;

	/**
	 * 批量删除RsPic
	 * 
	 * @param rsPicIdList
	 *            存放rsPic主键的list
	 */
	public void deleteBatchRsPic(RsPic rsPic) throws Exception;

	/**
	 * 修改RsPic
	 * 
	 * @param rsPic
	 *            RsPic对象
	 */
	public void updateRsPic(RsPic rsPic) throws Exception;

	/**
	 * 查询单个RsPic
	 * 
	 * @param rsPic
	 *            RsPic对象
	 * 
	 * @return RsPic实体对象
	 */
	public RsPic displayRsPic(RsPic rsPic) throws Exception;

	/**
	 * 查询RsPic列表
	 * 
	 * @param rsPic
	 *            RsPic对象
	 * 
	 * @return RsPic列表
	 */
	public List<RsPic> queryRsPicList(RsPic rsPic) throws Exception;

	/**
	 * 获取RsPic主键ID
	 */
	public String getRsPicId() throws Exception;

	/**
	 * 按顺序保存图片
	 * 
	 * @author Gengb
	 * @date 2017年9月6日 上午8:41:52
	 * @param picIds
	 *            图片IDs
	 * @param rsId
	 *            资源ID
	 * @throws Exception
	 * @return void
	 */
	public void saveRsPic(String[] picIds, String rsId) throws Exception;
}

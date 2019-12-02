package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.Commproduct;

/**
 * CommproductDao接口
 * 
 * @author wootide
 * 
 */
public interface CommproductDao {
	/**
	 * 增加Commproduct
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 */
	void insertCommproduct(Commproduct commproduct) throws Exception;

	/**
	 * 检查Commproduct
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 */
	void mergeCommproduct(Commproduct commproduct) throws Exception;

	/**
	 * 删除Commproduct
	 * 
	 * @param commproduct
	 *            成语对象
	 */
	void deleteCommproduct(Commproduct commproduct) throws Exception;

	/**
	 * 批量删除Commproduct
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchCommproduct(Commproduct commproduct) throws Exception;

	/**
	 * 修改Commproduct
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 */
	void updateCommproduct(Commproduct commproduct) throws Exception;

	/**
	 * 查询单个Commproduct信息
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 * 
	 * @return Commproduct实体对象
	 */
	Commproduct queryCommproduct(Commproduct commproduct) throws Exception;

	/**
	 * 查询Commproduct列表信息
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 * 
	 * @return Commproduct列表
	 */
	List<Commproduct> queryCommproductList(Commproduct commproduct) throws Exception;

	/**
	 * 获取CommproductID
	 */
	String getCommproductId() throws Exception;

	/**
	 * 微信端查看单个详情
	 * 
	 * @author wzd
	 * @date 2019年10月6日 下午6:06:48
	 * @param commproduct
	 * @return
	 * @throws Exception
	 * @return Commproduct
	 */
	Commproduct queryCommproductForWx(Commproduct commproduct) throws Exception;

	/**
	 * 后台查询，为了复制功能添加priceId
	 * 
	 * @author wzd
	 * @date 2019年12月2日 上午10:54:39
	 * @param commproduct
	 * @return
	 * @throws Exception
	 * @return List<Commproduct>
	 */
	List<Commproduct> queryCommproductListAndPriceId(Commproduct commproduct) throws Exception;
}

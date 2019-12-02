package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.Commproduct;
import com.msy.travel.pojo.User;

/**
 * CommproductService接口
 * 
 * @author wootide
 * 
 */
public interface CommproductService {
	/**
	 * 新增Commproduct
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 */
	public void createCommproduct(Commproduct commproduct) throws Exception;

	/**
	 * 检查Commproduct
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 */
	public void mergeCommproduct(Commproduct commproduct) throws Exception;

	/**
	 * 删除Commproduct
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 */
	public void deleteCommproduct(Commproduct commproduct) throws Exception;

	/**
	 * 批量删除Commproduct
	 * 
	 * @param commproductIdList
	 *            存放commproduct主键的list
	 */
	public void deleteBatchCommproduct(Commproduct commproduct) throws Exception;

	/**
	 * 修改Commproduct
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 */
	public void updateCommproduct(Commproduct commproduct) throws Exception;

	/**
	 * 查询单个Commproduct
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 * 
	 * @return Commproduct实体对象
	 */
	public Commproduct displayCommproduct(Commproduct commproduct) throws Exception;

	/**
	 * 查询Commproduct列表
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 * 
	 * @return Commproduct列表
	 */
	public List<Commproduct> queryCommproductList(Commproduct commproduct) throws Exception;

	/**
	 * 获取Commproduct主键ID
	 */
	public String getCommproductId() throws Exception;

	/**
	 * 新增商品
	 * 
	 * @author wzd
	 * @date 2019年10月2日 上午10:43:10
	 * @param thumbPic
	 * @param picIds
	 * @param commproduct
	 * @param user
	 * @throws Exception
	 * @return void
	 */
	public void createCommproduct(String thumbPic, String[] picIds, Commproduct commproduct, User user) throws Exception;

	/**
	 * 修改
	 * 
	 * @author wzd
	 * @date 2019年10月4日 下午2:33:08
	 * @param thumbPic
	 * @param picIds
	 * @param commproduct
	 * @param user
	 * @throws Exception
	 * @return void
	 */
	public void updateCommproduct(String thumbPic, String[] picIds, Commproduct commproduct, User user) throws Exception;

	/**
	 * 上下架
	 * 
	 * @author wzd
	 * @date 2019年10月4日 下午4:14:57
	 * @param commproduct
	 * @param user
	 * @throws Exception
	 * @return void
	 */
	public void changeState(Commproduct commproduct, User user) throws Exception;

	/**
	 * 微信端查看详情
	 * 
	 * @author wzd
	 * @date 2019年10月6日 下午6:07:06
	 * @param commproduct
	 * @return
	 * @throws Exception
	 * @return Commproduct
	 */
	public Commproduct queryCommproductForWx(Commproduct commproduct) throws Exception;

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
	public List<Commproduct> queryCommproductListAndPriceId(Commproduct commproduct) throws Exception;
}

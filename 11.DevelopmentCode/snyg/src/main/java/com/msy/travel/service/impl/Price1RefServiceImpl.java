package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.dao.Price1RefDao;
import com.msy.travel.pojo.Price1Ref;
import com.msy.travel.service.Price1RefService;

/**
 * Price1RefService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class Price1RefServiceImpl implements Price1RefService {

	@Resource(name = "price1RefDao")
	private Price1RefDao price1RefDao;

	/**
	 * 新增Price1Ref
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 */
	public void createPrice1Ref(Price1Ref price1Ref) throws Exception {
		price1RefDao.insertPrice1Ref(price1Ref);
	}

	/**
	 * 检查Price1Ref
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 */
	public void mergePrice1Ref(Price1Ref price1Ref) throws Exception {
		price1RefDao.mergePrice1Ref(price1Ref);
	}

	/**
	 * 删除Price1Ref
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 */
	public void deletePrice1Ref(Price1Ref price1Ref) throws Exception {
		price1RefDao.deletePrice1Ref(price1Ref);
	}

	/**
	 * 修改Price1Ref
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 */
	public void updatePrice1Ref(Price1Ref price1Ref) throws Exception {
		price1RefDao.updatePrice1Ref(price1Ref);
	}

	/**
	 * 批量删除Price1Ref
	 * 
	 * @param price1RefIdList
	 *            存放price1Ref主键的list
	 */
	public void deleteBatchPrice1Ref(Price1Ref price1Ref) throws Exception {
		price1RefDao.deleteBatchPrice1Ref(price1Ref);
	}

	/**
	 * 查询单个Price1Ref
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 * 
	 * @return 成员实体对象
	 */
	public Price1Ref displayPrice1Ref(Price1Ref price1Ref) throws Exception {
		return price1RefDao.queryPrice1Ref(price1Ref);
	}

	/**
	 * 查询Price1Ref列表
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 * 
	 * @return Price1Ref列表
	 */
	public List<Price1Ref> queryPrice1RefList(Price1Ref price1Ref) throws Exception {
		return price1RefDao.queryPrice1RefList(price1Ref);
	}

	/**
	 * 获取Price1RefID
	 */
	public String getPrice1RefId() throws Exception {
		return price1RefDao.getPrice1RefId();
	}

	/**
	 * 查询Price1Ref列表信息
	 * 
	 * @param price1Ref
	 *            Price1Ref对象
	 * 
	 * @return Price1Ref列表
	 */
	public List<Price1Ref> queryPrice1RefListFowWx(Price1Ref price1Ref) throws Exception {
		return price1RefDao.queryPrice1RefListFowWx(price1Ref);
	}
}

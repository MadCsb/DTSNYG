package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.dao.ShopcartDao;
import com.msy.travel.pojo.Shopcart;
import com.msy.travel.service.ShopcartService;

/**
 * ShopcartService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class ShopcartServiceImpl implements ShopcartService {

	@Resource(name = "shopcartDao")
	private ShopcartDao shopcartDao;

	/**
	 * 新增Shopcart
	 * 
	 * @param shopcart
	 *            Shopcart对象
	 */
	public void createShopcart(Shopcart shopcart) throws Exception {
		shopcartDao.insertShopcart(shopcart);
	}

	/**
	 * 检查Shopcart
	 * 
	 * @param shopcart
	 *            Shopcart对象
	 */
	public void mergeShopcart(Shopcart shopcart) throws Exception {
		shopcartDao.mergeShopcart(shopcart);
	}

	/**
	 * 删除Shopcart
	 * 
	 * @param shopcart
	 *            Shopcart对象
	 */
	public void deleteShopcart(Shopcart shopcart) throws Exception {
		shopcartDao.deleteShopcart(shopcart);
	}

	/**
	 * 修改Shopcart
	 * 
	 * @param shopcart
	 *            Shopcart对象
	 */
	public void updateShopcart(Shopcart shopcart) throws Exception {
		shopcartDao.updateShopcart(shopcart);
	}

	/**
	 * 批量删除Shopcart
	 * 
	 * @param shopcartIdList
	 *            存放shopcart主键的list
	 */
	public void deleteBatchShopcart(Shopcart shopcart) throws Exception {
		shopcartDao.deleteBatchShopcart(shopcart);
	}

	/**
	 * 查询单个Shopcart
	 * 
	 * @param shopcart
	 *            Shopcart对象
	 * 
	 * @return 成员实体对象
	 */
	public Shopcart displayShopcart(Shopcart shopcart) throws Exception {
		return shopcartDao.queryShopcart(shopcart);
	}

	/**
	 * 查询Shopcart列表
	 * 
	 * @param shopcart
	 *            Shopcart对象
	 * 
	 * @return Shopcart列表
	 */
	public List<Shopcart> queryShopcartList(Shopcart shopcart) throws Exception {
		return shopcartDao.queryShopcartList(shopcart);
	}

	/**
	 * 获取ShopcartID
	 */
	public String getShopcartId() throws Exception {
		return shopcartDao.getShopcartId();
	}

	/**
	 * 新增或修改购物车
	 * 
	 * @author wzd
	 * @date 2019年10月15日 下午2:41:35
	 * @param shopcart
	 * @throws Exception
	 * @return void
	 */
	public void createOrUpdateShopcart(Shopcart shopcart) throws Exception {
		Shopcart o = new Shopcart();
		o.setPriceId(shopcart.getPriceId());
		o.setUserId(shopcart.getUserId());
		o = shopcartDao.queryShopcart(o);
		if (o != null && o.getCartId() != null && !"".equals(o.getCartId())) {
			int num = Integer.parseInt(o.getNum()) + Integer.parseInt(shopcart.getNum());
			o.setNum(num + "");
			o.setUpdateTime(DateTimeUtil.getDateTime19());
			shopcartDao.updateShopcart(o);
		} else {
			shopcart.setCartId(PrimaryKeyUtil.generateKey());
			shopcart.setCreateTime(DateTimeUtil.getDateTime19());
			shopcart.setUpdateTime(DateTimeUtil.getDateTime19());
			shopcartDao.insertShopcart(shopcart);
		}
	}
}

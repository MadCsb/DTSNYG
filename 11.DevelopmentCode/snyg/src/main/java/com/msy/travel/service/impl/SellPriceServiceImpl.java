package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.Result;
import com.msy.travel.dao.SellPriceDao;
import com.msy.travel.pojo.Consignee;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.service.CompanyExpressService;
import com.msy.travel.service.ConsigneeService;
import com.msy.travel.service.SellPriceService;

/**
 * SellPriceService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class SellPriceServiceImpl implements SellPriceService {

	@Resource(name = "sellPriceDao")
	private SellPriceDao sellPriceDao;

	@Resource(name = "consigneeServiceImpl")
	private ConsigneeService consigneeService;

	@Resource(name = "companyExpressServiceImpl")
	private CompanyExpressService companyExpressService;

	/**
	 * 新增SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 */
	public void createSellPrice(SellPrice sellPrice) throws Exception {
		sellPriceDao.insertSellPrice(sellPrice);
	}

	/**
	 * 检查SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 */
	public void mergeSellPrice(SellPrice sellPrice) throws Exception {
		sellPriceDao.mergeSellPrice(sellPrice);
	}

	/**
	 * 删除SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 */
	public void deleteSellPrice(SellPrice sellPrice) throws Exception {
		sellPriceDao.deleteSellPrice(sellPrice);
	}

	/**
	 * 修改SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 */
	public void updateSellPrice(SellPrice sellPrice) throws Exception {
		sellPriceDao.updateSellPrice(sellPrice);
	}

	/**
	 * 批量删除SellPrice
	 * 
	 * @param sellPriceIdList
	 *            存放sellPrice主键的list
	 */
	public void deleteBatchSellPrice(SellPrice sellPrice) throws Exception {
		sellPriceDao.deleteBatchSellPrice(sellPrice);
	}

	/**
	 * 查询单个SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 * 
	 * @return 成员实体对象
	 */
	public SellPrice displaySellPrice(SellPrice sellPrice) throws Exception {
		return sellPriceDao.querySellPrice(sellPrice);
	}

	/**
	 * 查询SellPrice列表
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 * 
	 * @return SellPrice列表
	 */
	public List<SellPrice> querySellPriceList(SellPrice sellPrice) throws Exception {
		return sellPriceDao.querySellPriceList(sellPrice);
	}

	/**
	 * 获取SellPriceID
	 */
	public String getSellPriceId() throws Exception {
		return sellPriceDao.getSellPriceId();
	}

	/**
	 * 微信端获取商品列表
	 * 
	 * @author wzd
	 * @date 2019年10月5日 下午5:16:53
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	public List<SellPrice> querySellPriceListForWx(SellPrice sellPrice) throws Exception {
		return sellPriceDao.querySellPriceListForWx(sellPrice);
	}

	/**
	 * 微信端查询规格
	 * 
	 * @author wzd
	 * @date 2019年10月6日 下午7:38:11
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	public List<SellPrice> queryGoodsPriceListForWx(SellPrice sellPrice) throws Exception {
		return sellPriceDao.queryGoodsPriceListForWx(sellPrice);
	}

	/**
	 * 活动商品管理列表
	 * 
	 * @author wzd
	 * @date 2019年10月21日 下午8:40:26
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	public List<SellPrice> queryGoodsPriceListForAdd(SellPrice sellPrice) throws Exception {
		return sellPriceDao.queryGoodsPriceListForAdd(sellPrice);
	}

	/**
	 * 新增或修改SellPrice
	 * 
	 * @param sellPrice
	 *            SellPrice对象
	 */
	public void createOrUpdateSellPrice(SellPrice sellPrice) throws Exception {
		List<SellPrice> sellPriceList = sellPrice.getSellPriceList();
		if (sellPriceList != null && sellPriceList.size() > 0) {
			for (int i = 0; i < sellPriceList.size(); i++) {
				SellPrice newSellPrice = sellPriceList.get(i);
				if (newSellPrice != null && newSellPrice.getGoodsPriceId() != null && !"".equals(newSellPrice.getGoodsPriceId())) {

					if (!"".equals(newSellPrice.getPriceStartDate())) {
						newSellPrice.setPriceStartDate(newSellPrice.getPriceStartDate());
					} else {
						newSellPrice.setPriceStartDate(null);
					}
					if (!"".equals(newSellPrice.getPriceEndDate())) {
						newSellPrice.setPriceEndDate(newSellPrice.getPriceEndDate());
					} else {
						newSellPrice.setPriceEndDate(null);
					}
					// 如果为空 购买数量不限
					if (newSellPrice.getPeopleNum() == null || "".equals(newSellPrice.getPeopleNum())) {
						newSellPrice.setPeopleNum(null);
					} else {
						newSellPrice.setPeopleNum(newSellPrice.getPeopleNum());
					}

					// 如果为空 购买数量不限
					if (newSellPrice.getMaxBuyCount() == null || "".equals(newSellPrice.getMaxBuyCount())) {
						newSellPrice.setMaxBuyCount(null);
					} else {
						newSellPrice.setMaxBuyCount(newSellPrice.getMaxBuyCount());
					}
					// 如果为空 购买数量不限
					if (newSellPrice.getLimitBuyCount() == null || "".equals(newSellPrice.getLimitBuyCount())) {
						newSellPrice.setLimitBuyCount(null);
					} else {
						newSellPrice.setLimitBuyCount(newSellPrice.getLimitBuyCount());
					}

					newSellPrice.setUpdateTime(DateTimeUtil.getDateTime19());
					newSellPrice.setDelFlag("0");

					if (newSellPrice.getPriceId() != null && !"".equals(newSellPrice.getPriceId())) {
						newSellPrice.setPriceType(sellPrice.getPriceType());
						sellPriceDao.updateSellPrice(newSellPrice);
					} else {
						newSellPrice.setPriceType(sellPrice.getPriceType());
						newSellPrice.setPriceId(PrimaryKeyUtil.generateKey());
						sellPriceDao.insertSellPrice(newSellPrice);
					}
				}
			}
		}
	}

	/**
	 * 按浏览量排序
	 * 
	 * @author wzd
	 * @date 2019年12月9日 下午8:49:00
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	public List<SellPrice> querySellPriceListOrderByAccess(SellPrice sellPrice) throws Exception {
		return sellPriceDao.querySellPriceListOrderByAccess(sellPrice);
	}

	/**
	 * 销量
	 * 
	 * @author wzd
	 * @date 2019年12月9日 下午9:45:54
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	public List<SellPrice> querySellPriceListOrderByOrderCount(SellPrice sellPrice) throws Exception {
		return sellPriceDao.querySellPriceListOrderByOrderCount(sellPrice);
	}

	/**
	 * 优惠券选择商品
	 * 
	 * @author wzd
	 * @date 2020年3月22日 下午5:57:11
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	public List<SellPrice> querySellPriceListForCoupon(SellPrice sellPrice) throws Exception {
		return sellPriceDao.querySellPriceListForCoupon(sellPrice);
	}

	/**
	 * 优惠券可使用商品
	 * 
	 * @author wzd
	 * @date 2020年3月25日 下午1:44:30
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	public List<SellPrice> querySellPriceListForCouponByCouponId(SellPrice sellPrice) throws Exception {
		return sellPriceDao.querySellPriceListForCouponByCouponId(sellPrice);
	}

	/**
	 * 获取规格
	 * 
	 * @author wzd
	 * @date 2020年7月6日 下午4:54:15
	 * @param sellPrice
	 * @return
	 * @throws Exception
	 * @return List<SellPrice>
	 */
	public List<SellPrice> querySellPriceListForPriceType(SellPrice sellPrice, String userId) throws Exception {

		if (!"0".equals(sellPrice.getPriceType())) {
			sellPrice.setPriceDate(DateTimeUtil.getDateTime19());
		}
		List<SellPrice> sellPricelist = sellPriceDao.queryGoodsPriceListForWx(sellPrice);

		if (sellPricelist != null && sellPricelist.size() > 0 && userId != null && !"".equals(userId)) {
			Consignee c = new Consignee();
			c.setUserId(userId);
			c.setEntityPage(new EntityPage());
			c.getEntityPage().setSortField("t.F_ISDEFAULT");
			c.getEntityPage().setSortOrder("DESC");
			List<Consignee> cList = consigneeService.queryConsigneeList(c);

			if (cList != null && cList.size() > 0) {
				c = cList.get(0);
				for (int i = 0; i < sellPricelist.size(); i++) {
					Result result = companyExpressService.getCompanyPrice(sellPricelist.get(i).getPriceId(), "1", c.getPcx().substring(0, c.getPcx().indexOf(" ")));
					if (result.getResultCode().equals("0")) {
						com.alibaba.fastjson.JSONObject json = (com.alibaba.fastjson.JSONObject) result.getResultPojo();
						sellPricelist.get(i).setFreight(json.getString("expressFee"));
					}
				}
			}
		}
		return sellPricelist;
	}
}

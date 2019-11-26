package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.dao.GoodsPriceDao;
import com.msy.travel.pojo.GoodsPrice;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.service.GoodsPriceService;
import com.msy.travel.service.SellPriceService;

/**
 * GoodsPriceService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class GoodsPriceServiceImpl implements GoodsPriceService {

	@Resource(name = "goodsPriceDao")
	private GoodsPriceDao goodsPriceDao;

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;

	/**
	 * 新增GoodsPrice
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 */
	public void createGoodsPrice(GoodsPrice goodsPrice) throws Exception {
		goodsPriceDao.insertGoodsPrice(goodsPrice);
	}

	/**
	 * 检查GoodsPrice
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 */
	public void mergeGoodsPrice(GoodsPrice goodsPrice) throws Exception {
		goodsPriceDao.mergeGoodsPrice(goodsPrice);
	}

	/**
	 * 删除GoodsPrice
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 */
	public void deleteGoodsPrice(GoodsPrice goodsPrice) throws Exception {
		goodsPriceDao.deleteGoodsPrice(goodsPrice);
	}

	/**
	 * 修改GoodsPrice
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 */
	public void updateGoodsPrice(GoodsPrice goodsPrice) throws Exception {
		goodsPriceDao.updateGoodsPrice(goodsPrice);
	}

	/**
	 * 批量删除GoodsPrice
	 * 
	 * @param goodsPriceIdList
	 *            存放goodsPrice主键的list
	 */
	public void deleteBatchGoodsPrice(GoodsPrice goodsPrice) throws Exception {
		goodsPriceDao.deleteBatchGoodsPrice(goodsPrice);
	}

	/**
	 * 查询单个GoodsPrice
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 * 
	 * @return 成员实体对象
	 */
	public GoodsPrice displayGoodsPrice(GoodsPrice goodsPrice) throws Exception {
		return goodsPriceDao.queryGoodsPrice(goodsPrice);
	}

	/**
	 * 查询GoodsPrice列表
	 * 
	 * @param goodsPrice
	 *            GoodsPrice对象
	 * 
	 * @return GoodsPrice列表
	 */
	public List<GoodsPrice> queryGoodsPriceList(GoodsPrice goodsPrice) throws Exception {
		return goodsPriceDao.queryGoodsPriceList(goodsPrice);
	}

	/**
	 * 获取GoodsPriceID
	 */
	public String getGoodsPriceId() throws Exception {
		return goodsPriceDao.getGoodsPriceId();
	}

	/**
	 * 新增销售规格以及销售价格
	 * 
	 * @author wzd
	 * @date 2019年10月2日 下午10:32:24
	 * @param thumbPic
	 * @param goodsPrice
	 * @throws Exception
	 * @return void
	 */
	public void createGoodsPriceAndSellPrice(String thumbPic, GoodsPrice goodsPrice) throws Exception {
		GoodsPrice g = new GoodsPrice();
		g.setGoodsPriceId(PrimaryKeyUtil.generateKey());
		g.setProductId(goodsPrice.getProductId());
		g.setPriceName(goodsPrice.getPriceName());
		// 如果为空 数量不限
		if (goodsPrice.getMaxBuyCount() == null || "".equals(goodsPrice.getMaxBuyCount())) {
			g.setStoreCount(null);
		} else {
			g.setStoreCount(goodsPrice.getStoreCount());
		}
		g.setThumbPic(thumbPic);
		g.setCreateTime(DateTimeUtil.getDateTime19());
		g.setDelFlag("0");
		if (goodsPrice.getFreight() == null || "".equals(goodsPrice.getFreight())) {
			g.setFreight(null);
		} else {
			g.setFreight(goodsPrice.getFreight());
		}
		g.setCompanyExpressId(goodsPrice.getCompanyExpressId());

		goodsPriceDao.insertGoodsPrice(g);

		SellPrice sellPrice = new SellPrice();
		sellPrice.setPriceId(PrimaryKeyUtil.generateKey());
		sellPrice.setGoodsPriceId(g.getGoodsPriceId());
		sellPrice.setProductId(goodsPrice.getProductId());
		sellPrice.setPrice(goodsPrice.getPrice());
		sellPrice.setPriceType(goodsPrice.getPriceType());
		sellPrice.setUpdateTime(DateTimeUtil.getDateTime19());
		if (!"".equals(goodsPrice.getPriceStartDate())) {
			sellPrice.setPriceStartDate(goodsPrice.getPriceStartDate());
		}
		if (!"".equals(goodsPrice.getPriceEndDate())) {
			sellPrice.setPriceEndDate(goodsPrice.getPriceEndDate());
		}
		// 如果为空 购买数量不限
		if (goodsPrice.getMaxBuyCount() == null || "".equals(goodsPrice.getMaxBuyCount())) {
			sellPrice.setMaxBuyCount(null);
		} else {
			sellPrice.setMaxBuyCount(goodsPrice.getMaxBuyCount());
		}
		// 如果为空 购买数量不限
		if (goodsPrice.getLimitBuyCount() == null || "".equals(goodsPrice.getLimitBuyCount())) {
			sellPrice.setLimitBuyCount(null);
		} else {
			sellPrice.setLimitBuyCount(goodsPrice.getLimitBuyCount());
		}
		// 如果为空 购买数量不限
		if (goodsPrice.getPeopleNum() == null || "".equals(goodsPrice.getPeopleNum())) {
			sellPrice.setPeopleNum(null);
		} else {
			sellPrice.setPeopleNum(goodsPrice.getPeopleNum());
		}
		sellPrice.setDelFlag("0");
		sellPriceService.createSellPrice(sellPrice);
		goodsPrice.setGoodsPriceId(g.getGoodsPriceId());
	}

	/**
	 * 修改销售规格以及销售价格
	 * 
	 * @author wzd
	 * @date 2019年10月3日 下午10:13:42
	 * @param thumbPic
	 * @param goodsPrice
	 * @throws Exception
	 * @return void
	 */
	public void updateGoodsPriceAndSellPrice(String thumbPic, GoodsPrice goodsPrice) throws Exception {
		GoodsPrice g = new GoodsPrice();
		g.setGoodsPriceId(goodsPrice.getGoodsPriceId());
		g = goodsPriceDao.queryGoodsPrice(goodsPrice);
		g.setPriceName(goodsPrice.getPriceName());
		// 如果为空 数量不限
		if (goodsPrice.getMaxBuyCount() == null || "".equals(goodsPrice.getMaxBuyCount())) {
			g.setStoreCount(null);
		} else {
			g.setStoreCount(goodsPrice.getStoreCount());
		}
		g.setThumbPic(thumbPic);
		g.setDelFlag("0");
		if (goodsPrice.getFreight() == null || "".equals(goodsPrice.getFreight())) {
			g.setFreight(null);
		} else {
			g.setFreight(goodsPrice.getFreight());
		}
		g.setCompanyExpressId(goodsPrice.getCompanyExpressId());
		goodsPriceDao.updateGoodsPrice(g);

		SellPrice sellPrice = new SellPrice();
		sellPrice.setPriceType(goodsPrice.getPriceType());
		sellPrice.setGoodsPriceId(goodsPrice.getGoodsPriceId());
		sellPrice = sellPriceService.displaySellPrice(sellPrice);
		sellPrice.setPrice(goodsPrice.getPrice());
		sellPrice.setUpdateTime(DateTimeUtil.getDateTime19());
		if (!"".equals(goodsPrice.getPriceStartDate())) {
			sellPrice.setPriceStartDate(goodsPrice.getPriceStartDate());
		}
		if (!"".equals(goodsPrice.getPriceEndDate())) {
			sellPrice.setPriceEndDate(goodsPrice.getPriceEndDate());
		}
		// 如果为空 购买数量不限
		if (goodsPrice.getMaxBuyCount() == null || "".equals(goodsPrice.getMaxBuyCount())) {
			sellPrice.setMaxBuyCount(null);
		} else {
			sellPrice.setMaxBuyCount(goodsPrice.getMaxBuyCount());
		}
		// 如果为空 购买数量不限
		if (goodsPrice.getLimitBuyCount() == null || "".equals(goodsPrice.getLimitBuyCount())) {
			sellPrice.setLimitBuyCount(null);
		} else {
			sellPrice.setLimitBuyCount(goodsPrice.getLimitBuyCount());
		}
		// 如果为空 购买数量不限
		if (goodsPrice.getPeopleNum() == null || "".equals(goodsPrice.getPeopleNum())) {
			sellPrice.setPeopleNum(null);
		} else {
			sellPrice.setPeopleNum(goodsPrice.getPeopleNum());
		}
		sellPrice.setDelFlag("0");
		sellPriceService.updateSellPrice(sellPrice);
	}

	/**
	 * 通过priceId查询详情
	 * 
	 * @author wzd
	 * @date 2019年11月16日 上午10:10:53
	 * @param goodsPrice
	 * @return
	 * @throws Exception
	 * @return GoodsPrice
	 */
	public GoodsPrice queryGoodsPriceByPriceId(GoodsPrice goodsPrice) throws Exception {
		return goodsPriceDao.queryGoodsPriceByPriceId(goodsPrice);
	}
}

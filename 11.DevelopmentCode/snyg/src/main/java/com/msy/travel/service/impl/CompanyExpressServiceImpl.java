package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.BigDecimalUtil;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.dao.CompanyExpressDao;
import com.msy.travel.dao.ExpressPriceDao;
import com.msy.travel.dao.SellPriceDao;
import com.msy.travel.pojo.CompanyExpress;
import com.msy.travel.pojo.ExpressPrice;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.service.CompanyExpressService;

/**
 * CompanyExpressService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class CompanyExpressServiceImpl implements CompanyExpressService {

	@Resource(name = "companyExpressDao")
	private CompanyExpressDao companyExpressDao;

	@Resource(name = "expressPriceDao")
	private ExpressPriceDao expressPriceDao;

	@Resource(name = "sellPriceDao")
	private SellPriceDao sellPriceDao;

	/**
	 * 新增CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 */
	public void createCompanyExpress(CompanyExpress companyExpress) throws Exception {
		companyExpressDao.insertCompanyExpress(companyExpress);
	}

	/**
	 * 检查CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 */
	public void mergeCompanyExpress(CompanyExpress companyExpress) throws Exception {
		companyExpressDao.mergeCompanyExpress(companyExpress);
	}

	/**
	 * 删除CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 */
	public void deleteCompanyExpress(CompanyExpress companyExpress) throws Exception {
		ExpressPrice ep = new ExpressPrice();
		ep.setCompanyExpressId(companyExpress.getCompanyExpressId());
		expressPriceDao.deleteExpressPrice(ep);
		companyExpressDao.deleteCompanyExpress(companyExpress);
	}

	/**
	 * 修改CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 */
	public void updateCompanyExpress(CompanyExpress companyExpress) throws Exception {
		companyExpressDao.updateCompanyExpress(companyExpress);
	}

	/**
	 * 批量删除CompanyExpress
	 * 
	 * @param companyExpressIdList
	 *            存放companyExpress主键的list
	 */
	public void deleteBatchCompanyExpress(CompanyExpress companyExpress) throws Exception {
		companyExpressDao.deleteBatchCompanyExpress(companyExpress);
	}

	/**
	 * 查询单个CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 * 
	 * @return 成员实体对象
	 */
	public CompanyExpress displayCompanyExpress(CompanyExpress companyExpress) throws Exception {
		return companyExpressDao.queryCompanyExpress(companyExpress);
	}

	/**
	 * 查询CompanyExpress列表
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 * 
	 * @return CompanyExpress列表
	 */
	public List<CompanyExpress> queryCompanyExpressList(CompanyExpress companyExpress) throws Exception {
		return companyExpressDao.queryCompanyExpressList(companyExpress);
	}

	/**
	 * 获取CompanyExpressID
	 */
	public String getCompanyExpressId() throws Exception {
		return companyExpressDao.getCompanyExpressId();
	}

	/**
	 * 新增CompanyExpress
	 * 
	 * @param companyExpress
	 *            CompanyExpress对象
	 */
	public void createCompanyExpressAndExpressPrice(CompanyExpress companyExpress, ExpressPrice expressPrice) throws Exception {

		List<ExpressPrice> expressPriceList = expressPrice.getExpressPriceList();
		if (expressPriceList != null && expressPriceList.size() > 0) {
			for (int i = 0; i < expressPriceList.size(); i++) {
				ExpressPrice e = expressPriceList.get(i);
				if (e.getProvinceId() != null && !"".equals(e.getProvinceId())) {
					String[] provinceIds = e.getProvinceId().split(",");
					String[] provinceNames = e.getProvince().split(",");

					String groupNum = PrimaryKeyUtil.generateNumCode();

					for (int j = 0; j < provinceIds.length; j++) {
						ExpressPrice newExpressPrice = new ExpressPrice();
						newExpressPrice.setExpressPriceId(PrimaryKeyUtil.generateKey());
						newExpressPrice.setCompanyExpressId(companyExpress.getCompanyExpressId());
						newExpressPrice.setProvince(provinceNames[j]);
						newExpressPrice.setProvinceId(provinceIds[j]);
						newExpressPrice.setExpressNum(e.getExpressNum());
						newExpressPrice.setExpressPrice(e.getExpressPrice());
						newExpressPrice.setExpressNumAdd(e.getExpressNumAdd());
						newExpressPrice.setExpressPriceAdd(e.getExpressPriceAdd());
						newExpressPrice.setGroupNum(groupNum);
						expressPriceDao.insertExpressPrice(newExpressPrice);
					}
				}
			}
		}
		companyExpressDao.insertCompanyExpress(companyExpress);
	}

	/**
	 * 修改
	 * 
	 * @author wzd
	 * @date 2019年11月26日 下午3:34:30
	 * @param companyExpress
	 * @param expressPrice
	 * @throws Exception
	 * @return void
	 */
	public void updateCompanyExpressAndExpressPrice(CompanyExpress companyExpress, ExpressPrice expressPrice) throws Exception {
		ExpressPrice oldEP = new ExpressPrice();
		oldEP.setCompanyExpressId(expressPrice.getCompanyExpressId());
		expressPriceDao.deleteExpressPrice(oldEP);

		List<ExpressPrice> expressPriceList = expressPrice.getExpressPriceList();
		if (expressPriceList != null && expressPriceList.size() > 0) {
			for (int i = 0; i < expressPriceList.size(); i++) {
				ExpressPrice e = expressPriceList.get(i);
				if (e.getProvinceId() != null && !"".equals(e.getProvinceId())) {
					String[] provinceIds = e.getProvinceId().split(",");
					String[] provinceNames = e.getProvince().split(",");

					String groupNum = PrimaryKeyUtil.generateNumCode();

					for (int j = 0; j < provinceIds.length; j++) {
						ExpressPrice newExpressPrice = new ExpressPrice();
						newExpressPrice.setExpressPriceId(PrimaryKeyUtil.generateKey());
						newExpressPrice.setCompanyExpressId(companyExpress.getCompanyExpressId());
						newExpressPrice.setProvince(provinceNames[j]);
						newExpressPrice.setProvinceId(provinceIds[j]);
						newExpressPrice.setExpressNum(e.getExpressNum());
						newExpressPrice.setExpressPrice(e.getExpressPrice());
						newExpressPrice.setExpressNumAdd(e.getExpressNumAdd());
						newExpressPrice.setExpressPriceAdd(e.getExpressPriceAdd());
						newExpressPrice.setGroupNum(groupNum);
						expressPriceDao.insertExpressPrice(newExpressPrice);
					}
				}
			}
		}
		companyExpressDao.updateCompanyExpress(companyExpress);
	}

	/**
	 * 获取重名
	 * 
	 * @author wzd
	 * @date 2019年11月26日 下午3:42:35
	 * @param companyExpress
	 * @return
	 * @throws Exception
	 * @return int
	 */
	public int queryCompanyExpressExis(CompanyExpress companyExpress) throws Exception {
		return companyExpressDao.queryCompanyExpressExis(companyExpress);
	}

	/**
	 * 获得商品价格
	 * 
	 * @author wzd
	 * @date 2019年11月26日 下午4:34:46
	 * @param sellpriceId
	 * @param num
	 * @return
	 * @throws Exception
	 * @return String
	 */
	public String getCompanyPrice(String priceId, String num, String province) throws Exception {
		String money = "0.00";
		SellPrice sellPrice = new SellPrice();
		sellPrice.setPriceId(priceId);
		sellPrice = sellPriceDao.querySellPrice(sellPrice);

		if (sellPrice.getCompanyExpressId() == null || "".equals(sellPrice.getCompanyExpressId())) {
			return money;
		} else {
			ExpressPrice ex = new ExpressPrice();
			ex.setCompanyExpressId(sellPrice.getCompanyExpressId());
			ex.setProvince(province);
			List<ExpressPrice> expressPriceList = expressPriceDao.queryExpressPriceList(ex);

			if (expressPriceList != null && expressPriceList.size() > 0) {
				ex = expressPriceList.get(0);
				int expressNum = Integer.parseInt(ex.getExpressNum());
				// 如果数量少于首件 返回首件价格
				if (Integer.parseInt(num) <= expressNum) {
					money = ex.getExpressPrice();
					return money;
				} else {
					// 首重价格
					String expressPrice = ex.getExpressPrice();
					// 续重数量
					String numAdd = BigDecimalUtil.subtract(ex.getExpressNum(), num);
					// 续重数量/续重件数
					String numAddForPrice = BigDecimalUtil.divide(numAdd, ex.getExpressNumAdd());
					// 续重需要计算的数量*续重价格
					String moneyAddPrice = BigDecimalUtil.multiply(numAddForPrice, ex.getExpressPriceAdd());

					money = BigDecimalUtil.add(expressPrice, moneyAddPrice);
				}
			} else {
				return money;
			}
		}

		return money;
	}
}

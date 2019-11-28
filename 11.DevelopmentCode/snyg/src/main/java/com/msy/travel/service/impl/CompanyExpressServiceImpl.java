package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.BigDecimalUtil;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.Result;
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

	public static final Log log = LogFactory.getLog(CompanyExpressService.class);

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
	public Result getCompanyPrice(String priceId, String num, String province) {
		Result result = new Result();
		try {
			if (priceId == null || "".equals(priceId)) {
				result.setResultCode("1");
				result.setResultMsg("商品priceId为空");
				result.setResultPojo("");
			} else if (province == null || "".equals(province)) {
				result.setResultCode("1");
				result.setResultMsg("省份province为空");
				result.setResultPojo("");
			} else if (num == null || "".equals(num)) {
				result.setResultCode("1");
				result.setResultMsg("数量num为空");
				result.setResultPojo("");
			} else {
				SellPrice sellPrice = new SellPrice();
				sellPrice.setPriceId(priceId);
				sellPrice.setDelFlag("0");
				sellPrice.setState("1");
				sellPrice = sellPriceDao.querySellPrice(sellPrice);

				if (sellPrice == null || sellPrice.getPriceId() == null || "".equals(sellPrice.getPriceId())) {
					result.setResultCode("1");
					result.setResultMsg("商品已下架或者已删除");
					result.setResultPojo("");
				} else {
					JSONObject jsonObject = new JSONObject();
					if (sellPrice.getCompanyExpressId() == null || "".equals(sellPrice.getCompanyExpressId())) {
						result.setResultCode("0");
						result.setResultMsg("");
						jsonObject.put("expressFee", "0.00");
						jsonObject.put("expressCode", "");
						result.setResultPojo(jsonObject.toString());
					} else {
						CompanyExpress companyExpress = new CompanyExpress();
						companyExpress.setCompanyExpressId(sellPrice.getCompanyExpressId());
						companyExpress = companyExpressDao.queryCompanyExpress(companyExpress);

						ExpressPrice ex = new ExpressPrice();
						ex.setCompanyExpressId(sellPrice.getCompanyExpressId());
						ex.setProvince(province);
						List<ExpressPrice> expressPriceList = expressPriceDao.queryExpressPriceList(ex);

						if (expressPriceList != null && expressPriceList.size() > 0) {
							ex = expressPriceList.get(0);
							int expressNum = Integer.parseInt(ex.getExpressNum());
							// 如果数量少于首件 返回首件价格
							if (Integer.parseInt(num) <= expressNum) {
								result.setResultCode("0");
								result.setResultMsg("");
								jsonObject.put("expressFee", ex.getExpressPrice());
								jsonObject.put("expressCode", companyExpress.getEpmeCompany());
								result.setResultPojo(jsonObject.toString());
							} else {
								// 首重价格
								String expressPrice = ex.getExpressPrice();
								// 续重数量
								String numAdd = BigDecimalUtil.subtract(ex.getExpressNum(), num);
								// 续重数量/续重件数
								String numAddForPrice = (int) Math.ceil(Double.parseDouble(BigDecimalUtil.divide(numAdd, ex.getExpressNumAdd()))) + "";
								// 续重需要计算的数量*续重价格
								String moneyAddPrice = BigDecimalUtil.multiply(numAddForPrice, ex.getExpressPriceAdd());

								String money = BigDecimalUtil.add(expressPrice, moneyAddPrice);

								result.setResultCode("0");
								result.setResultMsg("");
								jsonObject.put("expressFee", money);
								jsonObject.put("expressCode", companyExpress.getEpmeCompany());
								result.setResultPojo(jsonObject.toString());
							}
						} else {
							result.setResultCode("0");
							result.setResultMsg("");
							jsonObject.put("expressFee", "0.00");
							jsonObject.put("expressCode", "");
							result.setResultPojo(jsonObject.toString());
						}
					}
				}

			}
		} catch (Exception e) {
			log.error(e, e);
			result.setResultCode("1");
			result.setResultMsg("获取运费出错");
			result.setResultPojo("");
		}
		return result;
	}
}

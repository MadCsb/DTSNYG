package com.msy.travel.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.msy.travel.common.BigDecimalUtil;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.Result;
import com.msy.travel.dao.CustomerCouponDao;
import com.msy.travel.pojo.Coupon;
import com.msy.travel.pojo.CouponProduction;
import com.msy.travel.pojo.CustomerCoupon;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.SaleType;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.service.CouponProductionService;
import com.msy.travel.service.CouponService;
import com.msy.travel.service.CustomerCouponService;
import com.msy.travel.service.SaleTypeService;
import com.msy.travel.service.SellPriceService;

/**
 * CustomerCouponService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class CustomerCouponServiceImpl implements CustomerCouponService {

	@Resource(name = "customerCouponDao")
	private CustomerCouponDao customerCouponDao;

	@Resource(name = "couponServiceImpl")
	private CouponService couponService;

	@Resource(name = "couponProductionServiceImpl")
	private CouponProductionService couponProductionService;

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;

	@Resource(name = "saleTypeServiceImpl")
	private SaleTypeService saleTypeService;

	/**
	 * 新增CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	public void createCustomerCoupon(CustomerCoupon customerCoupon) throws Exception {
		customerCouponDao.insertCustomerCoupon(customerCoupon);
	}

	/**
	 * 检查CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	public void mergeCustomerCoupon(CustomerCoupon customerCoupon) throws Exception {
		customerCouponDao.mergeCustomerCoupon(customerCoupon);
	}

	/**
	 * 删除CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	public void deleteCustomerCoupon(CustomerCoupon customerCoupon) throws Exception {
		customerCouponDao.deleteCustomerCoupon(customerCoupon);
	}

	/**
	 * 修改CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 */
	public void updateCustomerCoupon(CustomerCoupon customerCoupon) throws Exception {
		customerCouponDao.updateCustomerCoupon(customerCoupon);
	}

	/**
	 * 批量删除CustomerCoupon
	 * 
	 * @param customerCouponIdList
	 *            存放customerCoupon主键的list
	 */
	public void deleteBatchCustomerCoupon(CustomerCoupon customerCoupon) throws Exception {
		customerCouponDao.deleteBatchCustomerCoupon(customerCoupon);
	}

	/**
	 * 查询单个CustomerCoupon
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 * 
	 * @return 成员实体对象
	 */
	public CustomerCoupon displayCustomerCoupon(CustomerCoupon customerCoupon) throws Exception {
		return customerCouponDao.queryCustomerCoupon(customerCoupon);
	}

	/**
	 * 查询CustomerCoupon列表
	 * 
	 * @param customerCoupon
	 *            CustomerCoupon对象
	 * 
	 * @return CustomerCoupon列表
	 */
	public List<CustomerCoupon> queryCustomerCouponList(CustomerCoupon customerCoupon) throws Exception {
		return customerCouponDao.queryCustomerCouponList(customerCoupon);
	}

	/**
	 * 获取CustomerCouponID
	 */
	public String getCustomerCouponId() throws Exception {
		return customerCouponDao.getCustomerCouponId();
	}

	/**
	 * 获取优惠券总数
	 * 
	 * @author wzd
	 * @date 2020年3月25日 下午4:21:01
	 * @param customerCoupon
	 * @return
	 * @throws Exception
	 * @return Long
	 */
	public Long getCustomerCouponCount(CustomerCoupon customerCoupon) throws Exception {
		return customerCouponDao.getCustomerCouponCount(customerCoupon);
	}

	/**
	 * 用户领取优惠券
	 * 
	 * @author wzd
	 * @date 2020年3月25日 下午4:25:27
	 * @param fansId
	 * @param coupon
	 * @return
	 * @throws Exception
	 * @return String
	 */
	public String receiveCoupon(String userId, Coupon coupon) throws Exception {

		// 插入客户优惠券关联表
		String customerCouponId = PrimaryKeyUtil.generateKey();
		CustomerCoupon customerCoupon = new CustomerCoupon();
		customerCoupon.setCustomerCouponId(customerCouponId);
		customerCoupon.setCustomerCode(userId);
		customerCoupon.setCouponId(coupon.getCouponId());
		customerCoupon.setUseType(coupon.getUseType());
		customerCoupon.setUseLimit(coupon.getUseLimit());
		customerCoupon.setDiscount(coupon.getDiscount());
		customerCoupon.setCouponType(coupon.getCouponType());
		customerCoupon.setValidBegin(coupon.getValidBegin());
		customerCoupon.setValidEnd(coupon.getValidEnd());
		customerCoupon.setObtainTime(DateTimeUtil.getDateTime10());
		customerCoupon.setStatus("0"); // 使用状态:0未使用
		customerCoupon.setDelFlag("0"); // 是否删除0-未删除
		customerCouponDao.insertCustomerCoupon(customerCoupon);

		return "";
	}

	/**
	 * 判断是否可以优惠券
	 * 
	 * @author wzd
	 * @date 2020年3月28日 下午2:46:05
	 * @param user
	 * @param couponId
	 * @param jsonObject
	 *            {customerCouponId:
	 *            '',userId:'',sellPrice:[{priceId:'',num:''},{priceId:'',num:''
	 *            } ] }
	 * @return {customerCouponId:
	 *         '',userId:'',sellPrice:[{priceId:'',num:'',isUse:'0不能使用'},{priceId:'',num:'',isUse:
	 *         ' 1 能 使 用 ' } ] }
	 * @throws Exception
	 * @return String
	 */
	public Result canUseCoupon(JSONObject jsonObject) throws Exception {
		Result result = new Result();
		String customerCouponId = jsonObject.getString("customerCouponId");
		String userId = jsonObject.getString("userId");

		CustomerCoupon customerCoupon = new CustomerCoupon();
		customerCoupon.setCustomerCouponId(customerCouponId);
		customerCoupon = customerCouponDao.queryCustomerCoupon(customerCoupon);

		String crrDate = DateTimeUtil.getDateTime10();

		if (!userId.equals(customerCoupon.getCustomerCode())) {
			result.setResultCode("1");
			result.setResultMsg("优惠券未领取");
		} else if ("1".equals(customerCoupon.getDelFlag())) {
			result.setResultCode("1");
			result.setResultMsg("优惠券已删除");
		} else if ("1".equals(customerCoupon.getStatus())) {
			result.setResultCode("1");
			result.setResultMsg("优惠券已使用");
		} else if (crrDate.compareTo(customerCoupon.getValidBegin()) < 0 || crrDate.compareTo(customerCoupon.getValidEnd()) > 0) {
			// 有效期不对
			result.setResultCode("1");
			result.setResultMsg("优惠券不在有效期内");
		}

		CouponProduction couponProduction = new CouponProduction();
		couponProduction.setCouponId(customerCoupon.getCouponId());
		List<String> couponProductionList = couponProductionService.queryCouponProductionIdList(couponProduction);

		// 当归属某个活动的时候
		if (couponProductionList.size() == 0) {
			String userCouponId = couponProductionList.get(0);
			// 全部商品
			if (userCouponId.equals(Destsp.currentSpId)) {
				String priceAll = "";

				result.setResultCode("0");
				JSONArray jsonArray = jsonObject.getJSONArray("sellPrice");
				if (jsonArray != null && jsonArray.size() > 0) {
					for (int i = 0; i < jsonArray.size(); i++) {
						JSONObject job = jsonArray.getJSONObject(i);

						SellPrice sellPrice = new SellPrice();
						sellPrice.setPriceId(job.getString("priceId"));
						sellPrice = sellPriceService.displaySellPrice(sellPrice);

						String price = BigDecimalUtil.multiply(job.getString("num"), sellPrice.getPrice());
						priceAll = BigDecimalUtil.add(priceAll, price);

						job.put("isUse", "1");

					}
					result.setResultPojo(jsonArray);

					double limitMoney = Double.parseDouble(BigDecimalUtil.subtract(customerCoupon.getUseLimit(), priceAll));
					if (limitMoney > 0) {
						result.setResultCode("1");
						result.setResultMsg("还需要购买" + customerCoupon.getUseLimit() + "元才能使用该优惠券");
					}
				}
			} else {
				// 活动
				SaleType saleType = new SaleType();
				saleType.setSaleTypeId(userCouponId);
				saleType = saleTypeService.displaySaleType(saleType);

				String priceAll = "";

				// 判断销售商品是否属于活动
				JSONArray jsonArray = jsonObject.getJSONArray("sellPrice");
				if (jsonArray != null && jsonArray.size() > 0) {
					for (int i = 0; i < jsonArray.size(); i++) {
						JSONObject job = jsonArray.getJSONObject(i);

						SellPrice sellPrice = new SellPrice();
						sellPrice.setPriceId(job.getString("priceId"));
						sellPrice = sellPriceService.displaySellPrice(sellPrice);

						if (sellPrice.getPriceType().equals(saleType.getSaleTypeKey())) {
							String price = BigDecimalUtil.multiply(job.getString("num"), sellPrice.getPrice());

							priceAll = BigDecimalUtil.add(priceAll, price);
							job.put("isUse", "1");
						} else {
							job.put("isUse", "0");
						}
					}
					result.setResultPojo(jsonArray);

					double limitMoney = Double.parseDouble(BigDecimalUtil.subtract(customerCoupon.getUseLimit(), priceAll));
					if (limitMoney > 0) {
						result.setResultCode("1");
						result.setResultMsg("还需要购买" + customerCoupon.getUseLimit() + "元才能使用该优惠券");
					}
				}

			}
		} else { // 部分商品
			// 判断销售商品是否属于部分商品
			JSONArray jsonArray = jsonObject.getJSONArray("sellPrice");
			if (jsonArray != null && jsonArray.size() > 0) {
				String priceAll = "";

				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject job = jsonArray.getJSONObject(i);

					SellPrice sellPrice = new SellPrice();
					sellPrice.setPriceId(job.getString("priceId"));
					sellPrice = sellPriceService.displaySellPrice(sellPrice);

					if (couponProductionList.contains(sellPrice.getPriceId())) {
						String price = BigDecimalUtil.multiply(job.getString("num"), sellPrice.getPrice());

						priceAll = BigDecimalUtil.add(priceAll, price);
						job.put("isUse", "1");
					} else {
						job.put("isUse", "0");
					}
				}
				result.setResultPojo(jsonArray);

				double limitMoney = Double.parseDouble(BigDecimalUtil.subtract(customerCoupon.getUseLimit(), priceAll));
				if (limitMoney > 0) {
					result.setResultCode("1");
					result.setResultMsg("还需要购买" + customerCoupon.getUseLimit() + "元才能使用该优惠券");
				}
			}
		}

		return result;
	}

	/**
	 * 获取用户优惠券
	 * 
	 * @author wzd
	 * @date 2020年3月28日 下午4:29:42
	 * @param customerCoupon
	 * @return
	 * @throws Exception
	 * @return List<CustomerCoupon>
	 */
	public List<CustomerCoupon> queryCustomerCouponListByUserId(CustomerCoupon customerCoupon) throws Exception {
		return customerCouponDao.queryCustomerCouponListByUserId(customerCoupon);
	}

	/**
	 * 获取用户优惠券
	 * 
	 * @author wzd
	 * @date 2020年3月28日 下午4:29:42
	 * @param customerCoupon
	 * @return
	 * @throws Exception
	 * @return List<CustomerCoupon>
	 */
	public List<CustomerCoupon> queryCustomerCouponListByUserIdAndPriceId(CustomerCoupon customerCoupon, String priceId) throws Exception {

		customerCoupon.setDelFlag("0");

		List<String> useCouponIdList = new ArrayList<String>();
		// 全部商品渠道
		useCouponIdList.add(Destsp.currentSpId);

		if (priceId != null && priceId.length() > 0) {
			String[] priceIds = priceId.split(",");
			for (String p : priceIds) {
				// 销售Id
				useCouponIdList.add(p);

				SellPrice sellPrice = new SellPrice();
				sellPrice.setPriceId(p);
				sellPrice = sellPriceService.displaySellPrice(sellPrice);

				// 活动id
				SaleType saleType = new SaleType();
				saleType.setSaleTypeKey(sellPrice.getPriceType());
				saleType.setStatus("1");
				List<SaleType> saleTypeList = saleTypeService.querySaleTypeList(saleType);
				if (saleTypeList != null && saleTypeList.size() > 0) {
					if (!useCouponIdList.contains(saleTypeList.get(0).getSaleTypeId())) {
						useCouponIdList.add(saleTypeList.get(0).getSaleTypeId());
					}
				}

			}

		}

		customerCoupon.setUseCouponIdList(useCouponIdList);

		List<CustomerCoupon> customerCouponList = customerCouponDao.queryCustomerCouponListByUserId(customerCoupon);

		return customerCouponList;

	}
}

package com.msy.travel.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinamobile.sd.openapi.Common;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.LogicException;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.Result;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.dao.OrderDao;
import com.msy.travel.pojo.Commproduct;
import com.msy.travel.pojo.Consignee;
import com.msy.travel.pojo.CustomerCoupon;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.GoodsPrice;
import com.msy.travel.pojo.Order;
import com.msy.travel.pojo.OrderBack;
import com.msy.travel.pojo.OrderCustomer;
import com.msy.travel.pojo.OrderExpress;
import com.msy.travel.pojo.OrderList;
import com.msy.travel.pojo.OrderLog;
import com.msy.travel.pojo.Price1Ref;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.pojo.Shopcart;
import com.msy.travel.pojo.ThirdPayFlow;
import com.msy.travel.pojo.User;
import com.msy.travel.service.CommproductService;
import com.msy.travel.service.CompanyExpressService;
import com.msy.travel.service.ConsigneeService;
import com.msy.travel.service.CustomerCouponService;
import com.msy.travel.service.GoodsPriceService;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.OrderBackService;
import com.msy.travel.service.OrderCustomerService;
import com.msy.travel.service.OrderExpressService;
import com.msy.travel.service.OrderListService;
import com.msy.travel.service.OrderLogService;
import com.msy.travel.service.OrderService;
import com.msy.travel.service.Price1RefService;
import com.msy.travel.service.RoleDataService;
import com.msy.travel.service.SellPriceService;
import com.msy.travel.service.ShopcartService;

/**
 * OrderService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	public static final Log log = LogFactory.getLog(OrderServiceImpl.class);

	@Resource(name = "roleDataServiceImpl")
	private RoleDataService roleDataService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Resource(name = "consigneeServiceImpl")
	private ConsigneeService consigneeService;

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;

	@Resource(name = "goodsPriceServiceImpl")
	private GoodsPriceService goodsPriceService;

	@Resource(name = "commproductServiceImpl")
	private CommproductService commproductService;

	@Resource(name = "orderListServiceImpl")
	private OrderListService orderListService;

	@Resource(name = "orderCustomerServiceImpl")
	private OrderCustomerService orderCustomerService;

	@Resource(name = "orderExpressServiceImpl")
	private OrderExpressService orderExpressService;

	@Resource(name = "price1RefServiceImpl")
	private Price1RefService price1RefService;

	@Resource(name = "shopcartServiceImpl")
	private ShopcartService shopcartService;

	@Resource(name = "orderLogServiceImpl")
	private OrderLogService orderLogService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Resource(name = "orderBackServiceImpl")
	private OrderBackService orderBackService;

	@Resource(name = "companyExpressServiceImpl")
	private CompanyExpressService companyExpressService;

	@Resource(name = "customerCouponServiceImpl")
	private CustomerCouponService customerCouponService;

	@Resource(name = "orderDao")
	private OrderDao orderDao;

	/**
	 * 系统锁
	 */
	private static final Lock lock = new ReentrantLock();

	/**
	 * 查询单个Order
	 * 
	 * @param order
	 *            Order对象
	 * 
	 * @return 成员实体对象
	 */
	public Order displayOrder(Order order) throws Exception {
		return orderDao.queryOrder(order);
	}

	/**
	 * 查询Order列表
	 * 
	 * @param order
	 *            Order对象
	 * 
	 * @return Order列表
	 */
	public List<Order> queryOrderList(Order order) throws Exception {
		return orderDao.queryOrderList(order);
	}

	/**
	 * 查询Order列表信息统计信息
	 *
	 * @param order
	 *            Order对象
	 *
	 * @return Order列表
	 */
	public Order queryOrderListStatic(Order order) throws Exception {
		return orderDao.queryOrderListStatic(order);
	}

	/**
	 * 创建订单前验证
	 * 
	 * @param param
	 *            {consigneeId:收货地址Id,userId:用户Id,channelId:渠道ID,memo:备注,price:{
	 *            priceType
	 *            :销售类型,其他字段},orderListList[{priceId:销售id,num:数量,cartId:
	 *            购物车Id}],customerCouponId:优惠券ID}
	 * @return
	 * @throws Exception
	 */
	public Result validateCreateOrder(JSONObject param) throws Exception {
		Result result = new Result();
		result.setResultCode("0");

		// 当前时间
		String now = DateTimeUtil.getDateTime19();

		Consignee consignee = new Consignee();
		consignee.setConsigneeId(param.getString("consigneeId"));
		consignee = consigneeService.displayConsignee(consignee);
		if (consignee == null) {
			result.setResultCode("1");
			result.setResultMsg("收货地址不存在");
			return result;
		}

		// 操作用户=下单用户
		User user = new User();
		user.setUserId(param.getString("userId"));
		user = userService.displayUser(user);
		if (user == null) {
			result.setResultCode("1");
			result.setResultMsg("当前用户不存在");
			return result;
		}

		// 需删除的购物车
		List<Shopcart> deleteShopcartList = new ArrayList<>();
		JSONArray orderListListJSONArray = param.getJSONArray("orderListList");
		for (int i = 0; i < orderListListJSONArray.size(); i++) {
			JSONObject orderListJSONObject = orderListListJSONArray.getJSONObject(i);
			String priceId = orderListJSONObject.getString("priceId");
			int num = orderListJSONObject.getIntValue("num");
			String cartId = orderListJSONObject.getString("cartId");

			SellPrice sellPrice = new SellPrice();
			sellPrice.setPriceId(priceId);
			sellPrice = sellPriceService.displaySellPrice(sellPrice);

			GoodsPrice goodsPrice = new GoodsPrice();// 规格
			goodsPrice.setGoodsPriceId(sellPrice.getGoodsPriceId());
			goodsPrice = goodsPriceService.displayGoodsPrice(goodsPrice);

			Commproduct commproduct = new Commproduct();
			commproduct.setProductId(goodsPrice.getProductId());
			commproduct = commproductService.displayCommproduct(commproduct);

			// 商品删除验证
			if ("1".equals(commproduct.getDelFlag())) {
				result.setResultCode("1");
				result.setResultMsg("【" + commproduct.getProductName() + "】已删除，不能预订");
				return result;
			}
			// 商品下架验证
			if ("0".equals(commproduct.getState())) {
				result.setResultCode("1");
				result.setResultMsg("【" + commproduct.getProductName() + "】已下架，不能预订");
				return result;
			}

			// 商品规格删除验证
			if ("1".equals(goodsPrice.getDelFlag())) {
				result.setResultCode("1");
				result.setResultMsg("【" + commproduct.getProductName() + "  " + goodsPrice.getPriceName() + "】已删除，不能预订");
				return result;
			}

			// 销售删除验证
			if ("1".equals(sellPrice.getDelFlag())) {
				result.setResultCode("1");
				result.setResultMsg("【" + commproduct.getProductName() + "  " + goodsPrice.getPriceName() + "】活动已下架，不能预订");
				return result;
			}

			if (sellPrice.getPriceStartDate() != null && !sellPrice.getPriceStartDate().equals("") && now.compareTo(sellPrice.getPriceStartDate()) < 0) {
				result.setResultCode("1");
				result.setResultMsg("【" + commproduct.getProductName() + "  " + goodsPrice.getPriceName() + "】活动还未开始，不能预订");
				return result;
			}

			if (sellPrice.getPriceEndDate() != null && !sellPrice.getPriceEndDate().equals("") && now.compareTo(sellPrice.getPriceEndDate()) > 0) {
				result.setResultCode("1");
				result.setResultMsg("【" + commproduct.getProductName() + "  " + goodsPrice.getPriceName() + "】活动已经结束，不能预订");
				return result;
			}

			if (sellPrice.getMaxBuyCount() != null && !sellPrice.getMaxBuyCount().equals("")) {
				if (num > Integer.valueOf(sellPrice.getMaxBuyCount())) {
					result.setResultCode("1");
					result.setResultMsg("【" + commproduct.getProductName() + "  " + goodsPrice.getPriceName() + "】购买数量超过最大限制，不能预订");
					return result;
				}
			}

			if (sellPrice.getLimitBuyCount() != null && !sellPrice.getLimitBuyCount().equals("")) {
				if (num < Integer.valueOf(sellPrice.getLimitBuyCount())) {
					result.setResultCode("1");
					result.setResultMsg("【" + commproduct.getProductName() + "  " + goodsPrice.getPriceName() + "】购买数量小于最小限制，不能预订");
					return result;
				}
			}

			if (cartId != null && !"".equals(cartId.trim())) {
				// 购物车删除
				Shopcart shopcart = new Shopcart();
				shopcart.setCartId(cartId);
				deleteShopcartList.add(shopcart);
			}
		}

		// 验证优惠券
		String customerCouponId = param.getString("customerCouponId");
		if (customerCouponId != null && !customerCouponId.equals("")) {
			JSONObject customerCouponParam = new JSONObject();
			customerCouponParam.put("customerCouponId", customerCouponId); //
			customerCouponParam.put("userId", user.getUserId()); //
			JSONArray sellPriceJSONArray = new JSONArray();
			for (int i = 0; i < orderListListJSONArray.size(); i++) {
				JSONObject sellPriceJSONObject = new JSONObject();
				sellPriceJSONObject.put("priceId", orderListListJSONArray.getJSONObject(i).getString("priceId"));
				sellPriceJSONObject.put("num", orderListListJSONArray.getJSONObject(i).getString("num"));
				sellPriceJSONArray.add(sellPriceJSONObject);
			}
			customerCouponParam.put("sellPrice", sellPriceJSONArray); //
			Result customerCouponResult = customerCouponService.canUseCoupon(customerCouponParam);
			if (!customerCouponResult.getResultCode().equals("0")) {
				result.setResultCode("1");
				result.setResultMsg("当前红包不可用");
				log.error(JSON.toJSONString(customerCouponResult));
				return result;
			} else {
				param.put("customerCoupon", customerCouponResult.getResultPojo());
				param.remove("customerCouponId");
			}
		}

		/************************* 保存订单前，不得新增/修改数据库内容 **********************************/
		List<Order> orderList = createOrder(param);
		result.setResultPojo(orderList);

		if (param.containsKey("price")) {
			JSONObject price = param.getJSONObject("price");
			String priceType = price.getString("priceType");

			for (int i = 0; i < orderList.size(); i++) {
				OrderList orderListTmp = new OrderList();
				orderListTmp.setOrderId(orderList.get(i).getOrderId());
				List<OrderList> orderListList = orderListService.queryOrderListList(orderListTmp);
				for (int j = 0; j < orderListList.size(); j++) {
					/**
					 * 团购活动 1.创建 Price1Ref , 如果是发起人 IsBegin=1， refPatchCode=new,
					 * priceStartDate=现在，
					 * priceEndDate=priceStartDate+ConfigParameter
					 * .price1PatchCode分钟 如果不是发起人 IsBegin=0，
					 * refPatchCode=发起人refPatchCode,
					 * priceStartDate=发起人priceStartDate，
					 * priceEndDate=发起人priceEndDate 1,修改订单orderDate 如果是发起人
					 * orderDate=priceEndDate 如果不是发起人
					 * orderDate=priceEndDate=发起人订单的orderDate
					 */
					if ("1".equals(priceType)) {
						String isBegin = price.getString("isBegin");
						Price1Ref ref = new Price1Ref();
						ref.setRefId(PrimaryKeyUtil.generateKey());
						ref.setPriceId(orderListList.get(j).getPriceId());
						ref.setUserId(orderList.get(i).getUserId());
						ref.setOrderListId(orderListList.get(i).getOrderListId());
						ref.setCreateTime(orderList.get(i).getCreateTime());
						String priceStartDate = null; // 团购批次开始时间
						String priceEndDate = null; // 团购批次截止时间
						String refPatchCode = null; // 团购批次号
						if ("1".equals(isBegin)) // 发起人
						{
							SimpleDateFormat sdf = new SimpleDateFormat(DateTimeUtil.sdf19);
							Calendar calendar = Calendar.getInstance();

							priceStartDate = sdf.format(calendar.getTime()); // 发起人保存-效期开始日期
							calendar.add(Calendar.MINUTE, Integer.valueOf(configParameter.getPrice1PatchTime())); // 30分钟成团有效期
							priceEndDate = sdf.format(calendar.getTime()); // 发起人保存-效期结束日期

							refPatchCode = PrimaryKeyUtil.getOnlyPrice1PatchCode();
							ref.setIsBegin("1");
						} else {
							refPatchCode = price.getString("refPatchCode");
							Price1Ref refTmp = new Price1Ref();
							refTmp.setRefPatchCode(refPatchCode);
							refTmp.setIsBegin("1");
							List<Price1Ref> price1RefList = price1RefService.queryPrice1RefList(refTmp);

							priceStartDate = price1RefList.get(0).getPriceStartDate(); // 发起人保存-效期开始日期
							priceEndDate = price1RefList.get(0).getPriceEndDate(); // 发起人保存-效期结束日期

							ref.setIsBegin("0");
						}
						ref.setRefPatchCode(refPatchCode);
						ref.setPriceStartDate(priceStartDate);
						ref.setPriceEndDate(priceEndDate);
						price1RefService.createPrice1Ref(ref);

						// 更新订单预定时间=之后的团购
						Order tmpOrder = new Order();
						tmpOrder.setOrderId(orderList.get(i).getOrderId());
						tmpOrder.setOrderDate(priceEndDate);
						orderDao.updateOrder(tmpOrder);
					}
				}
			}
		}

		// 如果有购物车，需删除
		for (int i = 0; i < deleteShopcartList.size(); i++) {
			shopcartService.deleteShopcart(deleteShopcartList.get(i));
		}
		return result;
	}

	/**
	 * 创建订单
	 * 
	 * @param 
	 *        {consigneeId:收货地址Id,userId:用户Id,channelId:渠道ID,memo:备注,orderListList
	 *        [{priceId:销售id,num:数量,cartId:购物车Id}],
	 *        customerCoupon:{customerCouponId
	 *        :使用优惠券ID,couponMoney:优惠券金额,userId:优惠券使用人,sellPrice:[{priceId:
	 *        '',num:'',isUse:'0不能使用'},{priceId:'',num:'',isUse:'1能使用'}] } }
	 * @return Order
	 */
	public List<Order> createOrder(JSONObject param) throws LogicException, Exception {
		List<Order> orderResult = new ArrayList<>();
		// 操作用户=下单用户
		User operatorUser = new User();
		operatorUser.setUserId(param.getString("userId"));
		operatorUser = userService.displayUser(operatorUser);

		// 收货地址
		Consignee consignee = new Consignee();
		consignee.setConsigneeId(param.getString("consigneeId"));
		consignee = consigneeService.displayConsignee(consignee);

		// 备注
		String memo = param.getString("memo");
		// 创建日期
		String createTime = DateTimeUtil.getDateTime19();
		// 数字格式化
		DecimalFormat df = new DecimalFormat("#.##");

		// 优惠券JSONObject
		JSONObject customerCouponJSONObject = param.getJSONObject("customerCoupon");
		// 使用优惠券临时保存Array
		JSONArray useCustomerCouponJSONArray = new JSONArray();
		BigDecimal useCustomerCouponTotalMoney = new BigDecimal("0");// 总共使用优惠券的订单明细总产品价格

		// 根据orderListList分订单，目前一个orderList=一个订单
		JSONArray orders = separateOrder(param.getJSONArray("orderListList"));
		for (int i = 0; i < orders.size(); i++) {
			JSONArray orderListListJSONArray = orders.getJSONObject(i).getJSONArray("orderListList");

			// 新增订单
			Order order = new Order();
			order.setOrderId(PrimaryKeyUtil.generateKey());
			order.setOrderCode(PrimaryKeyUtil.getOnlyOrderCode());
			order.setSpId(Destsp.currentSpId);
			order.setUserId(operatorUser.getUserId());
			order.setBackNum("0");
			BigInteger giftNum = new BigInteger("0");
			BigInteger num =  new BigInteger("0");
			BigDecimal money = new BigDecimal("0");
			BigDecimal productPrice = new BigDecimal("0");
			BigDecimal transFee = new BigDecimal("0");
			StringBuffer productNameStringBuffer = new StringBuffer();
			order.setOrderDate(createTime); // 默认下单时间=创建时间
			order.setMemo(memo);
			order.setStatus(null);
			order.setBeforePayStatus("0");
			order.setPayTag("0");
			order.setDelFlag("0");
			order.setCreateTime(createTime);
			order.setCreatorUid(operatorUser.getUserId());
			order.setCreator(operatorUser.getUserName());
			order.setUpdateTime(createTime);
			order.setUpdater(operatorUser.getUserName());
			order.setUpdateUid(operatorUser.getUserId());
			order.setChannelId(param.getString("channelId"));

			// 新增订单明细
			for (int j = 0; j < orderListListJSONArray.size(); j++) {
				int orderListNum = orderListListJSONArray.getJSONObject(j).getIntValue("num");

				String priceId = orderListListJSONArray.getJSONObject(j).getString("priceId");
				SellPrice sellPrice = new SellPrice();
				sellPrice.setPriceId(priceId);
				sellPrice = sellPriceService.displaySellPrice(sellPrice);

				GoodsPrice goodsPrice = new GoodsPrice();
				goodsPrice.setGoodsPriceId(sellPrice.getGoodsPriceId());
				Commproduct commproduct = new Commproduct();

				lock.lock();
				goodsPrice = goodsPriceService.displayGoodsPrice(goodsPrice);
				commproduct.setProductId(goodsPrice.getProductId());
				commproduct = commproductService.displayCommproduct(commproduct);
				// 商品库存判断，并扣减库存
				if (goodsPrice.getStoreCount() != null && !goodsPrice.getStoreCount().trim().equals("")) {
					if (Integer.valueOf(goodsPrice.getStoreCount()) < orderListNum) {
						throw new LogicException("【" + commproduct.getProductName() + "  " + goodsPrice.getPriceName() + "】库存不足，不能预订");
					} else {
						goodsPrice.setStoreCount(String.valueOf(Integer.valueOf(goodsPrice.getStoreCount()) - orderListNum));
						goodsPriceService.updateGoodsPrice(goodsPrice);
					}
				}
				lock.unlock();

				productNameStringBuffer.append(commproduct.getProductName()).append(" ").append(goodsPrice.getPriceName()).append(" ");
				OrderList orderList = new OrderList();
				orderList.setOrderListId(PrimaryKeyUtil.generateKey());
				orderList.setOrderId(order.getOrderId());
				orderList.setSpId(order.getSpId());
				orderList.setVenId(null);
				orderList.setVenName(null);
				orderList.setPriceId(priceId);
				orderList.setProductId(commproduct.getProductId());
				orderList.setProductName(commproduct.getProductName());
				orderList.setPrice(sellPrice.getPrice());
				orderList.setNum(String.valueOf(orderListNum));

				orderList.setPayMoney(null);
				orderList.setBackNum("0");
				orderList.setGoodsPriceId(goodsPrice.getGoodsPriceId());
				orderList.setChildName(goodsPrice.getPriceName());

				Result expressResult = companyExpressService.getCompanyPrice(priceId, String.valueOf(orderListNum), consignee.getPcx().split(" ")[0]);
				if (expressResult.getResultCode().equals("1")) // 获取运费失败
				{
					throw new LogicException("获取运费失败【" + expressResult.getResultMsg() + "】");
				}
				Double orderListTransFee = 0.0;
				JSONObject expressResultPojo = (JSONObject) expressResult.getResultPojo();
				orderListTransFee = Double.valueOf(expressResultPojo.getString("expressFee"));
				orderList.setTransFee(df.format(orderListTransFee));

				BigDecimal price = new BigDecimal(sellPrice.getPrice());
				BigDecimal orderListProductPrice = new BigDecimal(orderListNum).multiply(price);
				BigDecimal orderListMoney = orderListProductPrice.add(new BigDecimal(orderListTransFee));
				orderList.setMoney(df.format(orderListMoney));
				orderList.setDelFlag("0");
				orderList.setOrderListType("0");
				orderList.setVenId(commproduct.getVenId());
				orderList.setVenName(commproduct.getVenName());
				orderListService.createOrderList(orderList);

				// 修改订单费用信息
				productPrice = productPrice.add(orderListProductPrice);
				num = num.add(new BigInteger(String.valueOf(orderListNum)));
				transFee = transFee.add(new BigDecimal(orderListTransFee));
				money = money.add(productPrice).add(transFee);
				if (customerCouponJSONObject != null) // 如果存在优惠券
				{
					for (int m = 0; m < customerCouponJSONObject.getJSONArray("sellPrice").size(); m++) {
						JSONObject sellPriceJSONObject = customerCouponJSONObject.getJSONArray("sellPrice").getJSONObject(m);
						if (sellPriceJSONObject.getString("priceId").equals(priceId)) {
							if (sellPriceJSONObject.getString("isUse").equals("1")) // 可以使用优惠券
							{
								JSONObject useCustomerCouponJSONObject = new JSONObject();
								useCustomerCouponJSONObject.put("priceId", priceId);
								useCustomerCouponJSONObject.put("orderListId", orderList.getOrderListId());
								useCustomerCouponJSONObject.put("orderId", orderList.getOrderId());
								useCustomerCouponJSONObject.put("orderListProductPrice", orderListProductPrice);
								useCustomerCouponJSONArray.add(useCustomerCouponJSONObject);
								useCustomerCouponTotalMoney = useCustomerCouponTotalMoney.add(orderListProductPrice);
							}
							break;
						}
					}
				}
			}
			if (productNameStringBuffer.length() > 299) {
				order.setProductName(productNameStringBuffer.substring(0, 299));
			} else {
				order.setProductName(productNameStringBuffer.toString());
			}

			order.setGiftNum(giftNum.toString());
			order.setNum(num.toString());
			order.setMoney(String.valueOf(money.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()));
			order.setProductPrice(String.valueOf(productPrice.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()));
			order.setTransFee(String.valueOf(transFee.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()));
			orderDao.insertOrder(order);

			// 新增订单收货地址
			OrderCustomer orderCustomer = new OrderCustomer();
			orderCustomer.setOrderId(order.getOrderId());
			orderCustomer.setOrderListId(null);
			orderCustomer.setCustName(consignee.getCustName());
			orderCustomer.setCustPhone(consignee.getCustPhone());
			orderCustomer.setRecAddress(consignee.getPcx() + consignee.getRecAddress());
			orderCustomer.setCustCard(consignee.getCustCard());
			orderCustomer.setCardType(consignee.getCardType());
			orderCustomerService.createOrderCustomer(orderCustomer);

			// 新增订单日志
			OrderLog orderLog = new OrderLog();
			orderLog.setOrderLogId(PrimaryKeyUtil.generateKey());
			orderLog.setLinkId(order.getOrderId());
			orderLog.setOpTime(order.getCreateTime());
			orderLog.setOper(order.getCreator());
			orderLog.setOpContent("创建订单");
			orderLog.setType("1");
			orderLog.setResult("1");
			orderLogService.createOrderLog(orderLog);

			// 新增订单操作日志

			orderResult.add(order);
		}
		// 如果有使用优惠券，需要更新优惠券的金额
		// {customerCouponId:使用优惠券ID,couponMoney:优惠券金额,userId:优惠券使用人,sellPrice:[{priceId:'',num:'',isUse:'0不能使用'},{priceId:'',num:'',isUse:'1能使用'}]
		// }
		if (customerCouponJSONObject != null) // 如果存在优惠券
		{
			double couponMoney = customerCouponJSONObject.getDoubleValue("couponMoney");// 总优惠金额
			double reCouponMoney = couponMoney;// 剩余优惠金额
			for (int i = 0; i < customerCouponJSONObject.getJSONArray("sellPrice").size(); i++) {
				JSONObject sellPrice = customerCouponJSONObject.getJSONArray("sellPrice").getJSONObject(i);
				if (sellPrice.getString("isUse").equals("1")) // 可以使用
				{
					// 判断是否最后一个可以使用
					boolean isLast = true;
					for (int j = i + 1; j < customerCouponJSONObject.getJSONArray("sellPrice").size(); j++) {
						if (customerCouponJSONObject.getJSONArray("sellPrice").getJSONObject(j).getString("isUse").equals("1")) // 可以使用
						{
							isLast = false;
							break;
						}
					}

					for (int j = 0; j < useCustomerCouponJSONArray.size(); j++) {
						JSONObject useCustomerCouponJSONObject = useCustomerCouponJSONArray.getJSONObject(j);
						if (useCustomerCouponJSONObject.getString("priceId").equals(sellPrice.getString("priceId"))) {
							String orderListId = useCustomerCouponJSONObject.getString("orderListId");
							String orderId = useCustomerCouponJSONObject.getString("orderId");
							// 当前订单明细 产品金额
							double orderListProductPrice = Double.parseDouble(useCustomerCouponJSONObject.getString("orderListProductPrice"));
							double orderListCouponMoney = 0;// 订单应该优惠的金额
							if (isLast) // 如果是最后一个,则订单明细优惠金额，等于剩余优惠金额
							{
								orderListCouponMoney = reCouponMoney;
							} else // 如果不是最后一个,则订单明细优惠金额
									// 当前订单明细产品金额/所有优惠产品的产品总金额*总优惠金额
							{
								orderListCouponMoney = orderListProductPrice / useCustomerCouponTotalMoney.doubleValue() * couponMoney;
							}
							String orderListCouponMoneyDf = df.format(orderListCouponMoney);
							reCouponMoney = reCouponMoney - Double.parseDouble(orderListCouponMoneyDf);
							// 更新订单明细表
							OrderList orderList = new OrderList();
							orderList.setOrderListId(orderListId);
							orderList = orderListService.displayOrderList(orderList);
							// 订单金额 = （产品金额+运费） - 优惠金额
							double orderListMoney = Double.parseDouble(orderList.getMoney()) - Double.valueOf(orderListCouponMoneyDf);
							orderList = new OrderList();
							orderList.setOrderListId(orderListId);
							orderList.setCouponMoney(orderListCouponMoneyDf);
							orderList.setMoney(df.format(orderListMoney));
							orderList.setCustomerCouponId(customerCouponJSONObject.getString("customerCouponId"));
							orderListService.updateOrderList(orderList);
							// 更新订单表
							Order order = new Order();
							order.setOrderId(orderId);
							order = orderDao.queryOrder(order);
							// 订单金额 = （产品金额+运费） - 优惠金额
							double orderMoney = Double.parseDouble(order.getMoney()) - Double.valueOf(orderListCouponMoneyDf);
							order.setMoney(df.format(orderMoney));
							double orderCouponMoney = 0;
							if (order.getCouponMoney() == null) {

							} else {
								orderCouponMoney = orderCouponMoney + Double.parseDouble(order.getCouponMoney());
							}
							order.setCouponMoney(df.format(orderCouponMoney));
							orderDao.updateOrder(order);
							for (int k = 0; k < orderResult.size(); k++) {
								if (orderResult.get(k).getOrderId().equals(order.getOrderId())) {
									orderResult.set(k, order);
									break;
								}
							}
							break;
						}
					}
				}
			}
			CustomerCoupon customerCoupon = new CustomerCoupon();
			customerCoupon.setCustomerCouponId(customerCouponJSONObject.getString("customerCouponId"));
			customerCoupon = customerCouponService.displayCustomerCoupon(customerCoupon);
			customerCoupon.setStatus("1");
			customerCouponService.updateCustomerCoupon(customerCoupon);
		}

		return orderResult;
	}

	/**
	 * 所有orderList划分成多个order，目前每个订单，包含一个orderList orderListListJSONArray =
	 * [{priceId:销售id,num:数量}]
	 * 
	 * @param orderListListJSONArray
	 *            [{orderListList:[{priceId:销售id,num:数量}]}]
	 * @return
	 */
	private JSONArray separateOrder(JSONArray orderListListJSONArray) {
		JSONArray resultArray = new JSONArray(); // 结果order arry
		for (int i = 0; i < orderListListJSONArray.size(); i++) {
			JSONObject order = new JSONObject(); // order
			JSONArray orderListList = new JSONArray(); // orderListList array
			orderListList.add(orderListListJSONArray.get(i));
			order.put("orderListList", orderListList);
			resultArray.add(order);
		}
		return resultArray;
	}

	/**
	 * 支付订单
	 * 
	 * @param thirdPayFlow
	 * @return Order
	 */
	public void payOrder(ThirdPayFlow thirdPayFlow) throws Exception {
		String[] orders = thirdPayFlow.getPlatformOrders().split(",");
		for (int i = 0; i < orders.length; i++) {
			Order order = new Order();
			order.setOrderId(orders[i]);
			order = orderDao.queryOrder(order);

			Order orderDb = new Order();
			orderDb.setOrderId(order.getOrderId());
			orderDb.setPayMoney(order.getMoney());
			orderDb.setPayTag("1");
			orderDb.setStatus("0");
			orderDb.setPayDate(thirdPayFlow.getThirdCreateTime());
			orderDb.setPayTag("1"); // 目前默认支付
			orderDb.setPayType("0");
			orderDb.setPlatformFlowCode(thirdPayFlow.getPlatformFlowCode());
			orderDao.updateOrder(orderDb);

			OrderList orderList = new OrderList();
			orderList.setOrderId(order.getOrderId());
			orderList.setDelFlag("0");
			orderList.setOrderListType("0"); // 下单
			List<OrderList> orderListList = orderListService.queryOrderListList(orderList);
			orderList.setOrderListType("2"); // 赠送
			orderListList.addAll(orderListService.queryOrderListList(orderList));
			for (int j = 0; j < orderListList.size(); j++) {
				OrderList orderListDb = new OrderList();
				orderListDb.setOrderListId(orderListList.get(j).getOrderListId());
				orderListDb.setPayMoney(orderListList.get(j).getMoney());
				orderListService.updateOrderList(orderListDb);
			}
			// 新增订单日志
			OrderLog orderLog = new OrderLog();
			orderLog.setOrderLogId(PrimaryKeyUtil.generateKey());
			orderLog.setLinkId(order.getOrderId());
			orderLog.setOpTime(orderDb.getPayDate());
			orderLog.setOper(order.getCreator());
			orderLog.setOpContent("支付订单");
			orderLog.setType("1");
			orderLog.setResult("1");
			orderLogService.createOrderLog(orderLog);
		}
	}

	/**
	 * 更新商户备注
	 * 
	 * @param orderId
	 *            订单Id
	 * @param companyRemark
	 *            商户备注内容
	 * @param opUser
	 *            操作人
	 * @throws Exception
	 */
	@Override
	public void updateOrderCompanyRemark(String orderId, String companyRemark, User opUser) throws Exception {
		Order order = new Order();
		order.setOrderId(orderId);
		order.setCompanyRemark(companyRemark);
		orderDao.updateOrder(order);

		OrderLog orderLog = new OrderLog();
		orderLog.setOrderLogId(PrimaryKeyUtil.generateKey());
		orderLog.setLinkId(order.getOrderId());
		orderLog.setOpTime(DateTimeUtil.getDateTime19());
		if (opUser == null) {
			orderLog.setOper("平台机器人");
		} else {
			orderLog.setOper(opUser.getUserName());
		}
		orderLog.setOpContent("编辑平台备注【" + companyRemark + "】");
		orderLog.setType("1");
		orderLog.setResult("1");
		orderLogService.createOrderLog(orderLog);
	}

	/**
	 * 关闭未支付订单
	 * 
	 * @param orderId
	 */
	public void closeUnPayOrder(String orderId, User opUser) throws Exception {
		Order order = new Order();
		order.setOrderId(orderId);
		order = orderDao.queryOrder(order);
		if (order.getPayTag().equals("0") && order.getBeforePayStatus().equals("0")) {
			Order orderDb = new Order();
			orderDb.setOrderId(order.getOrderId());
			orderDb.setBeforePayStatus("2"); // 系统取消
			orderDao.updateOrder(orderDb);

			// 还原商品库存
			OrderList orderList = new OrderList();
			orderList.setOrderId(order.getOrderId());
			List<OrderList> orderListList = orderListService.queryOrderListList(orderList);
			for (int i = 0; i < orderListList.size(); i++) {
				GoodsPrice goodsPrice = new GoodsPrice();
				goodsPrice.setGoodsPriceId(orderListList.get(i).getGoodsPriceId());
				goodsPrice = goodsPriceService.displayGoodsPrice(goodsPrice);
				if (goodsPrice.getStoreCount() != null && !goodsPrice.getStoreCount().trim().equals("")) {
					goodsPrice.setStoreCount(String.valueOf(Integer.valueOf(goodsPrice.getStoreCount()) + Integer.valueOf(orderListList.get(i).getNum())));
					goodsPriceService.updateGoodsPrice(goodsPrice);
				}
			}

			OrderLog orderLog = new OrderLog();
			orderLog.setOrderLogId(PrimaryKeyUtil.generateKey());
			orderLog.setLinkId(order.getOrderId());
			orderLog.setOpTime(DateTimeUtil.getDateTime19());
			if (opUser == null) {
				orderLog.setOper("平台机器人");
			} else {
				orderLog.setOper(opUser.getUserName());
			}
			orderLog.setOpContent("关闭未支付订单");
			orderLog.setType("1");
			orderLog.setResult("1");
			orderLogService.createOrderLog(orderLog);
		} else {
			throw new LogicException("订单不是未支付正常状态");
		}
	}

	/**
	 * 发货
	 * 
	 * @param orderExpress
	 * @param operator
	 *            操作人 orderExpress.
	 */
	public void addExpress(OrderExpress orderExpress, User operator) throws Exception {
		orderExpressService.createOrderExpress(orderExpress);
		Order order = new Order();
		order.setOrderId(orderExpress.getOrderId());
		order.setStatus("1");// 订单设置已发货
		orderDao.updateOrder(order);

		OrderLog orderLog = new OrderLog();
		orderLog.setOrderLogId(PrimaryKeyUtil.generateKey());
		orderLog.setLinkId(orderExpress.getOrderId());
		orderLog.setOpTime(DateTimeUtil.getDateTime19());
		if (operator == null) {
			orderLog.setOper("平台机器人");
		} else {
			orderLog.setOper(operator.getUserName());
		}
		orderLog.setOpContent("快递单发货");
		orderLog.setType("1");
		orderLog.setResult("1");
		orderLogService.createOrderLog(orderLog);
	}

	/**
	 * 快递收货
	 * 
	 * @param orderExpress
	 * @param operator
	 *            操作人 orderExpress.
	 */
	public void closeExpress(OrderExpress orderExpress, User operator) throws Exception {
		if (orderExpress.getOrderExpressId() == null || "".equals(orderExpress.getOrderExpressId())) {
			throw new Exception("请输入快递记录ID");
		}
		orderExpress = orderExpressService.displayOrderExpress(orderExpress);

		OrderExpress orderExpressDb = new OrderExpress();
		orderExpressDb.setOrderExpressId(orderExpress.getOrderExpressId());
		orderExpressDb.setStatus("0");
		orderExpressService.updateOrderExpress(orderExpressDb);

		OrderLog orderLog = new OrderLog();
		orderLog.setOrderLogId(PrimaryKeyUtil.generateKey());
		orderLog.setLinkId(orderExpress.getOrderId());
		orderLog.setOpTime(DateTimeUtil.getDateTime19());
		if (operator == null) {
			orderLog.setOper("平台机器人");
		} else {
			orderLog.setOper(operator.getUserName());
		}
		orderLog.setOpContent("接收快递");
		orderLog.setType("1");
		orderLog.setResult("1");
		orderLogService.createOrderLog(orderLog);

		changeOrderStatus(orderExpress.getOrderId(), "2", operator);
	}

	/**
	 * 修改订单status
	 * 
	 * @param orderId
	 *            订单ID
	 * @param status
	 *            计划修改订单的状态
	 * @param opUser
	 *            操作人
	 */
	public Result changeOrderStatus(String orderId, String status, User opUser) throws Exception {
		Result result = new Result();
		result.setResultCode("0");
		result.setResultMsg("操作成功");
		Order order = new Order();
		order.setOrderId(orderId);
		order = orderDao.queryOrder(order);

		if (order.getStatus().equals(status)) {
			return result;
		}

		// status:订单状态：0-未确认 1-已发货2-已收货3-已取消（商户拒绝）4-发货失败5-订单关闭（定时、后台）
		if ("0".equals(status)) // 支付后-未确认
		{
			// 如果订单已支付,且未设置status，才可以设置0，则报错误
			if (!("1".equals(order.getPayTag()) && (order.getStatus() == null || order.getStatus().equals("")))) {
				result.setResultCode("1");
				result.setResultMsg("订单未支付或已经设置状态，无法设置0");
			}
		} else if ("1".equals(status)) // 已发货
		{
			// 如果订单未确认或未已发货，则可以继续发货
			if (order.getStatus() == null || !(order.getStatus().equals("0") || order.getStatus().equals("1"))) {
				result.setResultCode("1");
				result.setResultMsg("订单支付后状态错误，无法设置1");
			}
		} else if ("2".equals(status)) // 已收货
		{
			// 订单所有的快递
			OrderExpress orderExpressTmp = new OrderExpress();
			orderExpressTmp.setDelTag("0");
			orderExpressTmp.setOrderId(orderId);
			List<OrderExpress> orderAllExpress = orderExpressService.queryOrderExpressList(orderExpressTmp);
			boolean isAllClose = true; // 订单是否所有快递都已收货
			for (int i = 0; i < orderAllExpress.size(); i++) {
				if (!"0".equals(orderAllExpress.get(i).getStatus())) {
					isAllClose = false;
					break;
				}
			}
			if (!isAllClose) {
				result.setResultCode("1");
				result.setResultMsg("快递还未全部收货，无法设置2");
			}
		} else if ("3".equals(status)) // 确定拒绝
		{
			if (!"0".equals(order.getStatus())) // 未确认的订单才能拒绝
			{
				result.setResultCode("1");
				result.setResultMsg("未确认的订单才能拒绝，无法设置3");
			}
		} else if ("5".equals(status)) // 关闭订单
		{
			if (!"2".equals(order.getStatus())) // 已收货的订单才能关闭订单
			{
				result.setResultCode("1");
				result.setResultMsg("快递还未全部收货，无法设置5");
			}
		}
		if ("0".equals(result.getResultCode())) {
			order.setStatus(status);
			orderDao.updateOrder(order);

			OrderLog orderLog = new OrderLog();
			orderLog.setOrderLogId(PrimaryKeyUtil.generateKey());
			orderLog.setLinkId(order.getOrderId());
			orderLog.setOpTime(DateTimeUtil.getDateTime19());
			if (opUser == null) {
				orderLog.setOper("平台机器人");
			} else {
				orderLog.setOper(opUser.getUserName());
			}
			if (status != null && status.trim().equals("0")) {
				orderLog.setOpContent("订单未确认");
			} else if (status != null && status.trim().equals("1")) {
				orderLog.setOpContent("订单已发货");
			}

			else if (status != null && status.trim().equals("2")) {
				orderLog.setOpContent("订单已收货");
			}

			else if (status != null && status.trim().equals("3")) {
				orderLog.setOpContent("订单已拒绝");
			} else if (status != null && status.trim().equals("4")) {
				orderLog.setOpContent("订单发货失败");
			} else if (status != null && status.trim().equals("5")) {
				orderLog.setOpContent("订单已关闭");
			}
			orderLog.setType("1");
			orderLog.setResult("1");
			orderLogService.createOrderLog(orderLog);
		}
		return result;
	}

	/**
	 * 退订订单剩余所有 param 参数 orderId 订单ID backReason 退订原因 backReasonType 退订原因类型
	 * opUser 操作人
	 */
	public Result refuseOrder(Map<String, String> param, User opUser) throws Exception {
		changeOrderStatus(param.get("orderId"), "3", opUser);
		orderBackService.orderAllBack(param, opUser);
		OrderBack orderBack = new OrderBack();
		orderBack.setOrderId(param.get("orderId"));
		List<OrderBack> orderBackList = orderBackService.queryOrderBackList(orderBack);

		Map<String, String> paramAgree = new HashMap<>();
		paramAgree.put("backId", orderBackList.get(0).getBackId());
		return orderBackService.agressOrderBack(paramAgree, opUser);
	}

	/**
	 * 退订订单剩余所有 param 参数 backId 退订单Id opUser 操作人
	 */
	public Result orderBackSuccess(Map<String, String> param, User opUser) throws Exception {
		Result result = new Result();
		result.setResultCode("0");
		result.setResultMsg("退订更新订单成功");
		OrderBack orderBack = new OrderBack();
		orderBack.setBackId(param.get("backId"));
		orderBack = orderBackService.displayOrderBack(orderBack);
		if (!"6".equals(orderBack.getStatus())) {
			result.setResultCode("1");
			result.setResultMsg("退订单为关闭");
			return result;
		}
		JSONArray backData = JSON.parseArray(orderBack.getBackData());
		for (int i = 0; i < backData.size(); i++) {
			String orderListId = backData.getJSONObject(i).getString("orderListId");
			int num = backData.getJSONObject(i).getIntValue("backNum");
			OrderList orderListDb = new OrderList();
			orderListDb.setOrderListId(orderListId);
			orderListDb = orderListService.displayOrderList(orderListDb);

			OrderList orderListNew = new OrderList();
			orderListNew.setOrderListId(PrimaryKeyUtil.generateKey());
			orderListNew.setOrderId(orderListDb.getOrderId());
			orderListNew.setSpId(orderListDb.getSpId());
			orderListNew.setVenId(orderListDb.getVenId());
			orderListNew.setVenName(orderListDb.getVenName());
			orderListNew.setPriceId(orderListDb.getPriceId());
			orderListNew.setProductName(orderListDb.getProductName());
			orderListNew.setPrice(orderListDb.getPrice());
			orderListNew.setNum(num + "");
			orderListNew.setGoodsPriceId(orderListDb.getGoodsPriceId());
			orderListNew.setChildName(orderListDb.getChildName());
			orderListNew.setProductId(orderListDb.getProductId());
			orderListNew.setMoney(orderBack.getBackMoney());
			orderListNew.setPayMoney(orderBack.getBackMoney());
			orderListNew.setBackNum(num + "");
			orderListNew.setTransFee("0");
			orderListNew.setDelFlag("0");
			orderListNew.setOrderListType("1");
			orderListService.createOrderList(orderListNew);

			int backNum = 0;
			if (orderListDb.getBackNum() != null && !orderListDb.getBackNum().equals("")) {
				backNum = Integer.valueOf(orderListDb.getBackNum());
			}
			backNum = num + backNum;
			OrderList orderList = new OrderList();
			orderList.setBackNum(backNum + "");
			orderList.setOrderListId(orderListId);
			orderListService.updateOrderList(orderList);

			Order orderDb = new Order();
			orderDb.setOrderId(orderListDb.getOrderId());
			orderDb = orderDao.queryOrder(orderDb);
			backNum = 0;
			if (orderDb.getBackNum() != null && !orderDb.getBackNum().equals("")) {
				backNum = Integer.valueOf(orderDb.getBackNum());
			}
			backNum = num + backNum;
			Order order = new Order();
			order.setOrderId(orderDb.getOrderId());
			order.setBackNum(backNum + "");
			orderDao.updateOrder(order);

			OrderLog orderLog = new OrderLog();
			orderLog.setOrderLogId(PrimaryKeyUtil.generateKey());
			orderLog.setLinkId(order.getOrderId());
			orderLog.setOpTime(DateTimeUtil.getDateTime19());
			orderLog.setOper(opUser.getUserName());
			orderLog.setOpContent("退订更新订单成功");
			orderLog.setType("1");
			orderLog.setResult("1");
			orderLogService.createOrderLog(orderLog);
		}
		return result;
	}

	public static void main(String[] args) {
		// x{"resultCode":"0","resultMsg":"","resultPojo":{"expressCode":"","expressFee":"0.00"}}
		Result result = new Result();
		result.setResultCode("0");
		result.setResultMsg("");
		JSONObject object = new JSONObject();
		object.put("expressCode", "");
		object.put("expressFee", "0.00");
		result.setResultPojo(object);

		JSONObject expressResultPojo = (JSONObject) result.getResultPojo();
		Double orderListTransFee = Double.valueOf(expressResultPojo.getString("expressFee"));
		log.error("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + orderListTransFee);
	}

	/**
	 * 验证山东移动是否能预订 param 参数 param.priceCode = 销售code opUser 操作人
	 */
	public Result sdMobileCanOrder(Map<String, String> param, User opUser) {
		Map<String, String> map = new HashMap();
		map.put("msisdn", opUser.getUserLoginName());
		map.put("priceCode", param.get("priceCode"));
		Result result = Common.validMemberMbr(map);
		return result;
	}

	/**
	 * 验证山东移动同步订单 param 参数 param.priceCode = 销售code param.orderId = 订单ID opUser
	 * 操作人
	 */
	public Result sdMobileSyncOrder(Map<String, String> param, User opUser) {
		Map<String, String> map = new HashMap<>();
		map.put("msisdn", opUser.getUserLoginName());
		map.put("priceCode", param.get("priceCode"));
		map.put("orderId", param.get("orderId"));
		Result result = Common.syncMemberMbrOrder(map);
		return result;
	}
}

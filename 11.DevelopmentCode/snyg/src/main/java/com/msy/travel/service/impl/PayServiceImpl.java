package com.msy.travel.service.impl;

import static com.alipay.api.AlipayConstants.APP_ID;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.alipay.config.AlipayConfig;
import com.chinamobile.sd.openapi.Common;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.LogicException;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.Result;
import com.msy.travel.common.WxPayUtil;
import com.msy.travel.common.config.AlipayConfigParameter;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.common.wx.Sha1Util;
import com.msy.travel.controller.PayController;
import com.msy.travel.dao.CityDao;
import com.msy.travel.pojo.City;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.Order;
import com.msy.travel.pojo.OrderList;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.ThirdPayFlow;
import com.msy.travel.pojo.User;
import com.msy.travel.service.ICityService;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.OrderListService;
import com.msy.travel.service.OrderService;
import com.msy.travel.service.PayService;
import com.msy.travel.service.ThirdPayFlowService;
import com.msy.travel.wx.utils.MD5Util;
import com.sun.org.apache.bcel.internal.generic.IUSHR;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 支付接口实现类
 * 
 * @author chengsb
 * 
 */
@Service
@Transactional
public class PayServiceImpl implements PayService {
	public static final Log log = LogFactory.getLog(PayServiceImpl.class);

	@Resource(name = "destspServiceImpl")
	private IDestspService destspService;

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "orderServiceImpl")
	private OrderService orderService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Resource(name = "orderListServiceImpl")
	private OrderListService orderListService;

	@Resource(name = "thirdPayFlowServiceImpl")
	private ThirdPayFlowService thirdPayFlowService;

	@Resource(name = "alipayClient")
	private AlipayClient alipayClient;





	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Resource(name = "alipayConfigParameter")
	private AlipayConfigParameter alipayConfigParameter;

	/**
	 * 微信支付方式-公众号原生
	 */
	private static String PAY_METHOD_WX = "WX";

	/**
	 * 微信支付方式-移动系统
	 */
	private static String PAY_METHOD_WX_WAP = "WX_WAP";

	/**
	 * 微信支付方式-pc系统二维码
	 */
	private static String PAY_METHOD_WX_PC = "WX_PC";

	/**
	 * 支付宝支付方式-wap方式
	 */
	private static String PAY_METHOD_ALIPAY_WAP = "ALIPAY_WAP";

	/**
	 * 支付宝支付方式-PC方式
	 */
	private static String PAY_METHOD_ALIPAY_PC = "ALIPAY_PC";

	/**
	 * 金额0自动支付支付方式
	 */
	private static String PAY_METHOD_ZERO_AUTO = "ZERO_AUTO";

	/**
	 * 获取 支付 信息
	 * @param paramObject 参数信息 {payMethod:支付方式,openId:微信用户openId,userId:登录用户Id,spId:运营商id,platformOrders:订单ids,remoteAddr;请求ip地址}
	 * @return
	 */
	public Result getPayInfo(JSONObject paramObject) throws Exception
	{
		Result result = new Result();

		String payMethod = paramObject.getString("payMethod") ;
		String openId = paramObject.getString("openId") ;
		String spId = paramObject.getString("spId");
		String platformOrders = paramObject.getString("platformOrders");
		String remoteAddr = paramObject.getString("remoteAddr");
 		Map<String,String> payInfoParam = new HashMap<>();
		payInfoParam.put("spId",spId);
		payInfoParam.put("remoteAddr",remoteAddr);
		payInfoParam.put("openId",openId);

		StringBuffer bodySb = new StringBuffer();
		BigDecimal totalFee = new BigDecimal("0.00"); //订单金额
		String[] orderIds = platformOrders.split(",");
		for (int i=0;i<orderIds.length;i++)
		{
			Order order = new Order();
			order.setOrderId(orderIds[i]);
			order = orderService.displayOrder(order);
			OrderList orderList = new OrderList();
			orderList.setOrderId(order.getOrderId());
			List<OrderList> orderListList = orderListService.queryOrderListList(orderList);
			// = orderListList.get(0).getGoodsPriceId();
			if ("1".equals(order.getPayTag())) //订单已支付
			{
				result.setResultCode("1");
				result.setResultMsg("订单已支付，无需再次支付");
			}
			if (!"0".equals(order.getBeforePayStatus())) //订单已支付
			{
				result.setResultCode("1");
				result.setResultMsg("订单已关闭，请重新下单后支付");
			}
			bodySb.append(order.getProductName());
			if (i==0)
			{
				payInfoParam.put("productId",orderListList.get(0).getPriceId());
				payInfoParam.put("orderId",order.getOrderId());
				if (configParameter.getWxpayValidateTime() != null && !configParameter.getWxpayValidateTime().trim().equals(""))
				{
					SimpleDateFormat sdf = new SimpleDateFormat(DateTimeUtil.sdf19);
					Calendar cal = Calendar.getInstance();
					cal.setTime(sdf.parse(order.getOrderDate()));
					cal.add(Calendar.SECOND,Integer.valueOf(configParameter.getWxpayValidateTime()));
					payInfoParam.put("timeExpire",sdf.format(cal.getTime()));
				}
			}
			totalFee = totalFee.multiply(new BigDecimal(order.getMoney()));
		}
		payInfoParam.put("body",bodySb.toString());

		//第三方支付流水表
		ThirdPayFlow thirdPayFlow = new ThirdPayFlow();
		thirdPayFlow.setFlowId(PrimaryKeyUtil.generateKey());
		thirdPayFlow.setPlatformFlowCode(PrimaryKeyUtil.getOnlyPlatformFlowCode());
		thirdPayFlow.setCreateTime(DateTimeUtil.getDateTime19());
		thirdPayFlow.setFlowState("0");
		thirdPayFlow.setFlowMoney(String.valueOf(totalFee.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()));
		thirdPayFlow.setPlatformOrders(platformOrders);
		thirdPayFlow.setSpId(spId);
		thirdPayFlowService.createThirdPayFlow(thirdPayFlow);
		payInfoParam.put("platformFlowCode",thirdPayFlow.getPlatformFlowCode());

		if (PAY_METHOD_WX.equals(payMethod)) //微信公众号支付
		{
			result = getPayInfoByWX(payInfoParam);
		}else if (PAY_METHOD_WX_PC.equals(payMethod)) //微信支付网站扫码
		{
			result = getPayInfoByWXPC(payInfoParam);
		}else if (PAY_METHOD_WX_WAP.equals(payMethod)) //微信移动浏览器支付
		{
			result = getPayInfoByWXWAP(payInfoParam);
		}else if (PAY_METHOD_ALIPAY_WAP.equals(payMethod)) //支付宝 wap支付
		{
			result = getPayInfoByAlipayWAP(payInfoParam);
		}else if (PAY_METHOD_ALIPAY_PC.equals(payMethod)) //支付宝 PC支付
		{
			result = getPayInfoByAlipayPC(payInfoParam);
		}else if(PAY_METHOD_ZERO_AUTO.equals(payMethod)) //0元自动支付
		{
			result = getPayInfoByZeroAuto(payInfoParam);
		}
		else
		{
			throw new LogicException("不支持的支付方式");
		}
		if (result.getResultCode().equals("1"))
		{
			throw new LogicException(result.getResultMsg());
		}
		return result;
	}

	/**
	 * 获取 微信支付方式-公众号原生 信息
	 * @param param 参数信息
	 * param.spId 运营商ID
	 * param.body 支付内容
	 * param.platformFlowCode 本系统支付流水ID
	 * param.remoteAddr 创建订单的用户ID
	 * param.timeExpire 订单失效时间
	 * param.openId 微信用户OpenId
	 * param.productId 订单的商品ID
	 * @return
	 */
	private Result getPayInfoByWX(Map<String,String> param) throws Exception
	{
		Result result = new Result();

		Destsp destsp = new Destsp();
		destsp.setSpId(param.get("spId"));
		destsp = destspService.displayDestsp(destsp);
		ServiceCode serviceCode = new ServiceCode();
		serviceCode.setServiceId(destsp.getWxServiceId());
		serviceCode = serviceCodeService.displayServiceCode(serviceCode);
		ThirdPayFlow thirdPayFlow = new ThirdPayFlow();
		thirdPayFlow.setPlatformFlowCode(param.get("platformFlowCode"));
		thirdPayFlow = thirdPayFlowService.displayThirdPayFlow(thirdPayFlow);

		//微信支付 http请求参数
		Map<String,String> httpRequestParamMap = new TreeMap<String, String>();
		httpRequestParamMap.put("appid", serviceCode.getAppId());  //公众账号 ID
		httpRequestParamMap.put("mch_id", serviceCode.getTenPayPartner()); //商户号
		//httpRequestParamMap.put("device_info", null); //设备号
		httpRequestParamMap.put("nonce_str", MD5Util
				.MD5Encode(String.valueOf(new Random().nextInt(10000)), "UTF-8"));//随机字符串，不长于32位
		//httpRequestParamMap.put("sign_type", "MD5"); //签名类型 默认为MD5，支持HMAC-SHA256和MD5。
		//httpRequestParamMap.put("body", (body.length()>175?body.substring(0,175):body.toString()));//商品描述
		String body = param.get("body");
		if (body.length()>175) //微信支付body最长175
		{
			body = body.substring(0,175);
		}
		httpRequestParamMap.put("body",body);
		//httpRequestParamMap.put("detail", null); //商品详情
		//httpRequestParamMap.put("attach", null); //附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。
		httpRequestParamMap.put("out_trade_no", thirdPayFlow.getPlatformFlowCode());//商户系统内部订单号
		//httpRequestParamMap.put("fee_type", "CNY");//符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见
		BigDecimal total_fee = new BigDecimal(thirdPayFlow.getFlowMoney());
		total_fee = total_fee.multiply(new BigDecimal(100));
		httpRequestParamMap.put("total_fee", String.valueOf(total_fee.intValue()));//金额 单位分
		httpRequestParamMap.put("spbill_create_ip", param.get("remoteAddr"));//终端IP
		//httpRequestParamMap.put("time_start", null); //订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
		if (param.get("timeExpire")!=null && !param.get("timeExpire").equals(""))
		{
			httpRequestParamMap.put("time_expire", param.get("timeExpire").replaceAll(":", "").replaceAll("-", "").replaceAll(" ", ""));
		}

		//httpRequestParamMap.put("goods_tag",null); //订单优惠标记
		httpRequestParamMap.put("notify_url", configParameter.getWxpayNotifyUrl()); //通知地址
		httpRequestParamMap.put("trade_type", "JSAPI");
		httpRequestParamMap.put("openid", param.get("openId"));
		//httpRequestParamMap.put("limit_pay", null); //上传此参数no_credit--可限制用户不能使用信用卡支付
		//httpRequestParamMap.put("receipt", null); //Y，传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
		//httpRequestParamMap.put("scene_info",null); //该字段常用于线下活动时的场景信息上报，支持上报实际门店信息，商户也可以按需求自己上报相关信息。该字段为JSON对象数据，对象格式为{"store_info":{"id": "门店ID","name": "名称","area_code": "编码","address": "地址" }} ，字段详细说明请点击行前的+展开

		String sign = WxPayUtil.createSign(httpRequestParamMap, serviceCode.getTenPayPartnerKey());
		httpRequestParamMap.put("sign", sign);
		org.dom4j.Document document = DocumentHelper.createDocument();
		Element elementXml = document.addElement("xml");
		for (Entry<String , String> entry : httpRequestParamMap.entrySet()) {
			elementXml.addElement(entry.getKey()).addCDATA(entry.getValue());
		}

		//请求统一支付接口
		String res = WxPayUtil.httpRequest(WxPayUtil.WX_PAY_URL, "POST", document.asXML());

		document = DocumentHelper.parseText(res);
		Element root = document.getRootElement();
		List<Element> list = root.elements();
		Map<String,String> httpResponseResultMap = new TreeMap<String, String>(); //存储统一微信支付响应的结果
		for (Element ele:list)
		{
			httpResponseResultMap.put(ele.getName(), ele.getText());
		}
		//支付成功
		if(httpResponseResultMap.get("return_code")!=null
				&&httpResponseResultMap.get("result_code")!=null
				&&"SUCCESS".equals(httpResponseResultMap.get("return_code").toUpperCase())
				&&"SUCCESS".equals(httpResponseResultMap.get("result_code").toUpperCase()))
		{
			Map<String,String> signParamMap = new TreeMap<String, String>();
			signParamMap.put("appId", httpResponseResultMap.get("appid"));
			signParamMap.put("timeStamp", Sha1Util.getTimeStamp());
			signParamMap.put("nonceStr", Sha1Util.getNonceStr());
			signParamMap.put("package", "prepay_id="+httpResponseResultMap.get("prepay_id"));
			signParamMap.put("signType", "MD5");
			sign = WxPayUtil.createSign(signParamMap, serviceCode.getTenPayPartnerKey());
			Map<String,String> payInfo = new HashMap<String,String>();
			payInfo.put("appId", httpResponseResultMap.get("appid"));
			payInfo.put("timeStamp", signParamMap.get("timeStamp"));
			payInfo.put("nonceStr", signParamMap.get("nonceStr"));
			payInfo.put("package", "prepay_id="+httpResponseResultMap.get("prepay_id"));
			payInfo.put("signType", "MD5");
			payInfo.put("paySign", sign);
			payInfo.put("platformFlowCode",thirdPayFlow.getPlatformFlowCode());
			result.setResultCode("0");
			result.setResultMsg("获取微信支付订单信息成功");
			result.setResultPojo(payInfo);
		}else
		{
			log.error(this.PAY_METHOD_WX+" 支付参数 xml:"+ document.getRootElement().asXML());
			log.error(this.PAY_METHOD_WX + " 支付接口响应:"+res);
			result.setResultCode("1");
			result.setResultMsg("获取微信支付信息失败");
		}
		return result;
	}

	/**
	 * 获取 微信支付方式-移动系统 信息
	 * @param param 参数信息
	 * param.spId 运营商ID
	 * param.body 支付内容
	 * param.platformFlowCode 本系统支付流水ID
	 * param.remoteAddr 创建订单的用户ID
	 * param.timeExpire 订单失效时间
	 * param.openId 微信用户OpenId
	 * param.productId 订单的商品ID
	 * @return
	 */
	private Result getPayInfoByWXWAP(Map<String,String> param) throws Exception
	{
		Result result = new Result();

		Destsp destsp = new Destsp();
		destsp.setSpId(param.get("spId"));
		destsp = destspService.displayDestsp(destsp);
		ServiceCode serviceCode = new ServiceCode();
		serviceCode.setServiceId(destsp.getWxServiceId());
		serviceCode = serviceCodeService.displayServiceCode(serviceCode);
		ThirdPayFlow thirdPayFlow = new ThirdPayFlow();
		thirdPayFlow.setPlatformFlowCode(param.get("platformFlowCode"));
		thirdPayFlow = thirdPayFlowService.displayThirdPayFlow(thirdPayFlow);

		//微信支付 http请求参数
		Map<String,String> httpRequestParamMap = new TreeMap<String, String>();
		httpRequestParamMap.put("appid", serviceCode.getAppId());  //公众账号 ID
		httpRequestParamMap.put("mch_id", serviceCode.getTenPayPartner()); //商户号
		//httpRequestParamMap.put("device_info", null); //设备号
		httpRequestParamMap.put("nonce_str", MD5Util
				.MD5Encode(String.valueOf(new Random().nextInt(10000)), "UTF-8"));//随机字符串，不长于32位
		//httpRequestParamMap.put("sign_type", "MD5"); //签名类型 默认为MD5，支持HMAC-SHA256和MD5。
		//httpRequestParamMap.put("body", (body.length()>175?body.substring(0,175):body.toString()));//商品描述
		String body = param.get("body");
		if (body.length()>175) //微信支付body最长175
		{
			body = body.substring(0,175);
		}
		httpRequestParamMap.put("body",body);
		//httpRequestParamMap.put("detail", null); //商品详情
		//httpRequestParamMap.put("attach", null); //附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。
		httpRequestParamMap.put("out_trade_no", thirdPayFlow.getPlatformFlowCode());//商户系统内部订单号
		//httpRequestParamMap.put("fee_type", "CNY");//符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见
		BigDecimal total_fee = new BigDecimal(thirdPayFlow.getFlowMoney());
		total_fee = total_fee.multiply(new BigDecimal(100));
		httpRequestParamMap.put("total_fee", String.valueOf(total_fee.intValue()));//金额 单位分

		httpRequestParamMap.put("spbill_create_ip", param.get("remoteAddr"));//终端IP
		//httpRequestParamMap.put("time_start", null); //订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
		if (param.get("timeExpire")!=null && !param.get("timeExpire").equals(""))
		{
			httpRequestParamMap.put("time_expire", param.get("timeExpire").replaceAll(":", "").replaceAll("-", "").replaceAll(" ", ""));
		}

		//httpRequestParamMap.put("goods_tag",null); //订单优惠标记
		httpRequestParamMap.put("notify_url", configParameter.getWxpayNotifyUrl()); //通知地址
		httpRequestParamMap.put("trade_type","MWEB");

		//httpRequestParamMap.put("limit_pay", null); //上传此参数no_credit--可限制用户不能使用信用卡支付
		//httpRequestParamMap.put("receipt", null); //Y，传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
		//httpRequestParamMap.put("scene_info",null); //该字段常用于线下活动时的场景信息上报，支持上报实际门店信息，商户也可以按需求自己上报相关信息。该字段为JSON对象数据，对象格式为{"store_info":{"id": "门店ID","name": "名称","area_code": "编码","address": "地址" }} ，字段详细说明请点击行前的+展开

		String sign = WxPayUtil.createSign(httpRequestParamMap, serviceCode.getTenPayPartnerKey());
		httpRequestParamMap.put("sign", sign);
		org.dom4j.Document document = DocumentHelper.createDocument();
		Element elementXml = document.addElement("xml");
		for (Entry<String , String> entry : httpRequestParamMap.entrySet()) {
			elementXml.addElement(entry.getKey()).addCDATA(entry.getValue());
		}

		//请求统一支付接口
		String res = WxPayUtil.httpRequest(WxPayUtil.WX_PAY_URL, "POST", document.asXML());

		document = DocumentHelper.parseText(res);
		Element root = document.getRootElement();
		List<Element> list = root.elements();
		Map<String,String> httpResponseResultMap = new TreeMap<String, String>(); //存储统一微信支付响应的结果
		for (Element ele:list)
		{
			httpResponseResultMap.put(ele.getName(), ele.getText());
		}
		//支付成功
		if(httpResponseResultMap.get("return_code")!=null
				&&httpResponseResultMap.get("result_code")!=null
				&&"SUCCESS".equals(httpResponseResultMap.get("return_code").toUpperCase())
				&&"SUCCESS".equals(httpResponseResultMap.get("result_code").toUpperCase()))
		{
			Map<String,String> signParamMap = new TreeMap<String, String>();
			signParamMap.put("appId", httpResponseResultMap.get("appid"));
			signParamMap.put("timeStamp", Sha1Util.getTimeStamp());
			signParamMap.put("nonceStr", Sha1Util.getNonceStr());
			signParamMap.put("package", "prepay_id="+httpResponseResultMap.get("prepay_id"));
			signParamMap.put("signType", "MD5");
			sign = WxPayUtil.createSign(signParamMap, serviceCode.getTenPayPartnerKey());
			Map<String,String> payInfo = new HashMap<String,String>();
			payInfo.put("mweb_url", httpResponseResultMap.get("mweb_url")+"&redirect_url="+ URLEncoder.encode(configParameter.getWxpayWapReturnUrl(), "UTF-8"));
			payInfo.put("platformFlowCode",thirdPayFlow.getPlatformFlowCode());
			result.setResultCode("0");
			result.setResultMsg("获取微信支付订单信息成功");
			result.setResultPojo(payInfo);
		}else
		{
			log.error(this.PAY_METHOD_WX_WAP+" 支付参数 xml:"+ document.getRootElement().asXML());
			log.error(this.PAY_METHOD_WX_WAP + " 支付接口响应:"+res);
			result.setResultCode("1");
			result.setResultMsg("获取微信支付信息失败");
		}
		return result;
	}


	/**
	 * 获取 微信支付方式-pc系统二维码 信息
	 * @param param 参数信息
	 * param.spId 运营商ID
	 * param.body 支付内容
	 * param.platformFlowCode 本系统支付流水ID
	 * param.remoteAddr 创建订单的用户ID
	 * param.timeExpire 订单失效时间
	 * param.openId 微信用户OpenId
	 * param.productId 订单的商品ID
	 * @return
	 */
	private Result getPayInfoByWXPC(Map<String,String> param) throws Exception
	{
		Result result = new Result();

		Destsp destsp = new Destsp();
		destsp.setSpId(param.get("spId"));
		destsp = destspService.displayDestsp(destsp);
		ServiceCode serviceCode = new ServiceCode();
		serviceCode.setServiceId(destsp.getWxServiceId());
		serviceCode = serviceCodeService.displayServiceCode(serviceCode);
		ThirdPayFlow thirdPayFlow = new ThirdPayFlow();
		thirdPayFlow.setPlatformFlowCode(param.get("platformFlowCode"));
		thirdPayFlow = thirdPayFlowService.displayThirdPayFlow(thirdPayFlow);

		//微信支付 http请求参数
		Map<String,String> httpRequestParamMap = new TreeMap<String, String>();
		httpRequestParamMap.put("appid", serviceCode.getAppId());  //公众账号 ID
		httpRequestParamMap.put("mch_id", serviceCode.getTenPayPartner()); //商户号
		//httpRequestParamMap.put("device_info", null); //设备号
		httpRequestParamMap.put("nonce_str", MD5Util
				.MD5Encode(String.valueOf(new Random().nextInt(10000)), "UTF-8"));//随机字符串，不长于32位
		//httpRequestParamMap.put("sign_type", "MD5"); //签名类型 默认为MD5，支持HMAC-SHA256和MD5。
		//httpRequestParamMap.put("body", (body.length()>175?body.substring(0,175):body.toString()));//商品描述
		String body = param.get("body");
		if (body.length()>175) //微信支付body最长175
		{
			body = body.substring(0,175);
		}
		httpRequestParamMap.put("body",body);
		//httpRequestParamMap.put("detail", null); //商品详情
		//httpRequestParamMap.put("attach", null); //附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。
		httpRequestParamMap.put("out_trade_no", thirdPayFlow.getPlatformFlowCode());//商户系统内部订单号
		//httpRequestParamMap.put("fee_type", "CNY");//符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见
		BigDecimal total_fee = new BigDecimal(thirdPayFlow.getFlowMoney());
		total_fee = total_fee.multiply(new BigDecimal(100));
		httpRequestParamMap.put("total_fee", String.valueOf(total_fee.intValue()));//金额 单位分
		httpRequestParamMap.put("spbill_create_ip", param.get("remoteAddr"));//终端IP
		//httpRequestParamMap.put("time_start", null); //订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
		if (param.get("timeExpire")!=null && !param.get("timeExpire").equals(""))
		{
			httpRequestParamMap.put("time_expire", param.get("timeExpire").replaceAll(":", "").replaceAll("-", "").replaceAll(" ", ""));
		}

		//httpRequestParamMap.put("goods_tag",null); //订单优惠标记
		httpRequestParamMap.put("notify_url", configParameter.getWxpayNotifyUrl()); //通知地址
		httpRequestParamMap.put("trade_type", "NATIVE");
		httpRequestParamMap.put("product_id",param.get("productId"));

		//httpRequestParamMap.put("limit_pay", null); //上传此参数no_credit--可限制用户不能使用信用卡支付
		//httpRequestParamMap.put("receipt", null); //Y，传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
		//httpRequestParamMap.put("scene_info",null); //该字段常用于线下活动时的场景信息上报，支持上报实际门店信息，商户也可以按需求自己上报相关信息。该字段为JSON对象数据，对象格式为{"store_info":{"id": "门店ID","name": "名称","area_code": "编码","address": "地址" }} ，字段详细说明请点击行前的+展开

		String sign = WxPayUtil.createSign(httpRequestParamMap, serviceCode.getTenPayPartnerKey());
		httpRequestParamMap.put("sign", sign);
		org.dom4j.Document document = DocumentHelper.createDocument();
		Element elementXml = document.addElement("xml");
		for (Entry<String , String> entry : httpRequestParamMap.entrySet()) {
			elementXml.addElement(entry.getKey()).addCDATA(entry.getValue());
		}

		//请求统一支付接口
		String res = WxPayUtil.httpRequest(WxPayUtil.WX_PAY_URL, "POST", document.asXML());


		document = DocumentHelper.parseText(res);
		Element root = document.getRootElement();
		List<Element> list = root.elements();
		Map<String,String> httpResponseResultMap = new TreeMap<String, String>(); //存储统一微信支付响应的结果
		for (Element ele:list)
		{
			httpResponseResultMap.put(ele.getName(), ele.getText());
		}
		//支付成功
		if(httpResponseResultMap.get("return_code")!=null
				&&httpResponseResultMap.get("result_code")!=null
				&&"SUCCESS".equals(httpResponseResultMap.get("return_code").toUpperCase())
				&&"SUCCESS".equals(httpResponseResultMap.get("result_code").toUpperCase()))
		{
			Map<String,String> signParamMap = new TreeMap<String, String>();
			signParamMap.put("appId", httpResponseResultMap.get("appid"));
			signParamMap.put("timeStamp", Sha1Util.getTimeStamp());
			signParamMap.put("nonceStr", Sha1Util.getNonceStr());
			signParamMap.put("package", "prepay_id="+httpResponseResultMap.get("prepay_id"));
			signParamMap.put("signType", "MD5");
			sign = WxPayUtil.createSign(signParamMap, serviceCode.getTenPayPartnerKey());
			Map<String,String> payInfo = new HashMap<String,String>();
			payInfo.put("code_url",httpResponseResultMap.get("code_url"));
			payInfo.put("platformFlowCode",thirdPayFlow.getPlatformFlowCode());
			result.setResultCode("0");
			result.setResultMsg("获取微信支付订单信息成功");
			result.setResultPojo(payInfo);
		}else
		{
			log.error(this.PAY_METHOD_WX_PC+" 支付参数 xml:"+ document.getRootElement().asXML());
			log.error(this.PAY_METHOD_WX_PC + " 支付接口响应:"+res);
			result.setResultCode("1");
			result.setResultMsg("获取微信支付信息失败");
		}
		return result;
	}


	/**
	 * 获取 阿里支付方式-wab 页面document.write内容
	 * @param param 参数信息
	 * param.spId 运营商ID
	 * param.body 支付内容
	 * param.platformFlowCode 本系统支付流水ID
	 * param.remoteAddr 创建订单的用户ID
	 * param.timeExpire 订单失效时间 2016-12-31 10:05:00
	 * param.openId 微信用户OpenId
	 * param.productId 订单的商品ID
	 * param.orderId 订单ID
	 * @return
	 */
	private Result getPayInfoByAlipayWAP(Map<String,String> param) throws Exception {
		Result result = new Result();

		ThirdPayFlow thirdPayFlow = new ThirdPayFlow();
		thirdPayFlow.setPlatformFlowCode(param.get("platformFlowCode"));
		thirdPayFlow = thirdPayFlowService.displayThirdPayFlow(thirdPayFlow);

		AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
		alipayRequest.setNotifyUrl(alipayConfigParameter.getNotifyUrl());
		alipayRequest.setReturnUrl(alipayConfigParameter.getWapReturnUrl()	);

		String body = param.get("body");
		if (body.length()>128) //支付宝支付body最长128
		{
			body = body.substring(0,128);
		}
//		body = "1";
		alipayRequest.setBizContent("{" +
				"\"body\":\""+body+"\"," +
				"\"subject\":\""+body+"\"," +
				"\"out_trade_no\":\""+thirdPayFlow.getPlatformFlowCode()+"\"," +
				"\"time_expire\":\""+param.get("timeExpire").substring(0,16)+"\"," +
				"\"total_amount\":"+thirdPayFlow.getFlowMoney()+"," +
				"\"quit_url\":\""+alipayConfigParameter.getWapReturnUrl()+"\"," +
				"\"product_code\":\""+param.get("productId")+"\""+
				" }");
		AlipayTradeWapPayResponse alipayResponse = alipayClient.pageExecute(alipayRequest);
		if(alipayResponse.isSuccess()){
			result.setResultCode("0");
			Map<String,String> payInfo = new HashMap<String,String>();
			payInfo.put("body",alipayResponse.getBody());
			payInfo.put("platformFlowCode",thirdPayFlow.getPlatformFlowCode());
			result.setResultPojo(payInfo);
			result.setResultMsg(alipayResponse.getMsg());
		} else {
			log.error(this.PAY_METHOD_ALIPAY_WAP+" 支付参数 xml:"+ JSON.toJSONString(alipayRequest));
			log.error(this.PAY_METHOD_ALIPAY_WAP + " 支付接口响应:"+JSON.toJSONString(alipayResponse));
			result.setResultCode("1");
			result.setResultMsg(alipayResponse.getMsg());
		}
		return result;
	}


	/**
	 * 获取 阿里支付方式-pc 页面document.write内容
	 * @param param 参数信息
	 * param.spId 运营商ID
	 * param.body 支付内容
	 * param.platformFlowCode 本系统支付流水ID
	 * param.remoteAddr 创建订单的用户ID
	 * param.timeExpire 订单失效时间 2016-12-31 10:05:00
	 * param.openId 微信用户OpenId
	 * param.productId 订单的商品ID
	 * param.orderId 订单ID
	 * @return
	 */
	private Result getPayInfoByAlipayPC(Map<String,String> param) throws Exception {
		Result result = new Result();

		ThirdPayFlow thirdPayFlow = new ThirdPayFlow();
		thirdPayFlow.setPlatformFlowCode(param.get("platformFlowCode"));
		thirdPayFlow = thirdPayFlowService.displayThirdPayFlow(thirdPayFlow);

		AlipayTradePagePayRequest alipayRequest =  new  AlipayTradePagePayRequest(); //创建API对应的request
		alipayRequest.setNotifyUrl(alipayConfigParameter.getNotifyUrl());
		alipayRequest.setReturnUrl(alipayConfigParameter.getPcReturnUrl());

		String body = param.get("body");
		if (body.length()>128) //支付宝支付body最长128
		{
			body = body.substring(0,128);
		}
//		body = "1";
		JSONObject bizContent = new JSONObject();
		bizContent.put("out_trade_no",thirdPayFlow.getPlatformFlowCode());
		bizContent.put("product_code","FAST_INSTANT_TRADE_PAY");
		bizContent.put("total_amount",0.01);//Double.parseDouble(thirdPayFlow.getFlowMoney()));
		bizContent.put("subject",body);
		bizContent.put("body",body);
		bizContent.put("time_expire",param.get("timeExpire"));
		alipayRequest.setBizContent(bizContent.toJSONString());
		Map<String,String> payInfo = new HashMap<String,String>();
		try  {
			result.setResultCode("0");
			result.setResultMsg("PAY_METHOD_ALIPAY_PC 获取支付内容成功");
			payInfo.put("body",alipayClient.pageExecute(alipayRequest).getBody());
			payInfo.put("platformFlowCode",thirdPayFlow.getPlatformFlowCode());
			result.setResultPojo(payInfo);
		}  catch  (AlipayApiException e) {
			log.error(this.PAY_METHOD_ALIPAY_PC+" 支付参数 xml:"+ JSON.toJSONString(alipayRequest));
			log.error(this.PAY_METHOD_ALIPAY_PC + " 支付接口响应:"+JSON.toJSONString(e));
			result.setResultCode("1");
			result.setResultCode(e.getErrMsg());
		}
		return result;
	}


	/**
	 * 获取 0元自动支付的方式
	 * @param param 参数信息
	 * param.spId 运营商ID
	 * param.body 支付内容
	 * param.platformFlowCode 本系统支付流水ID
	 * param.remoteAddr 创建订单的用户ID
	 * param.timeExpire 订单失效时间 2016-12-31 10:05:00
	 * param.openId 微信用户OpenId
	 * param.productId 订单的商品ID
	 * param.orderId 订单ID
	 * @return
	 */
	private Result getPayInfoByZeroAuto(Map<String,String> param) throws Exception {
		Result result = new Result();

		ThirdPayFlow thirdPayFlow = new ThirdPayFlow();
		thirdPayFlow.setPlatformFlowCode(param.get("platformFlowCode"));
		thirdPayFlow = thirdPayFlowService.displayThirdPayFlow(thirdPayFlow);
		if(Double.parseDouble(thirdPayFlow.getFlowMoney()) == 0) //如果金额为0，则可以使用0元自动支付
		{
			Map<String,String> payInfo = new HashMap<String,String>();
			payInfo.put("platformFlowCode",thirdPayFlow.getPlatformFlowCode());
			result.setResultCode("0");
			result.setResultMsg("生成订单金额为0的自动支付流水");
			result.setResultPojo(payInfo);
		}else
		{
			log.error(this.PAY_METHOD_ZERO_AUTO+" 支付 由于金额非0，不能成功!:"+ param.get("platformFlowCode"));
			result.setResultCode("1");
			result.setResultCode("订单金额不为0，不能自动支付");
		}
		return result;
	}

	/**
	 * @Description 收到支付宝的成功回调之后验证签名是否正确
	 * @param requestParams
	 * @return
	 */
	public boolean aliPayCheckSignature(Map<String, String> requestParams)
	{
		try {
			boolean flag = AlipaySignature.rsaCheckV1(requestParams, alipayConfigParameter.getAlipayPublicKey(), alipayConfigParameter.getCharset(),
					alipayConfigParameter.getSignType());
			return flag;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args)
	{
		BigDecimal b = new BigDecimal("1210");
		System.out.println(b.toString());
	}
}

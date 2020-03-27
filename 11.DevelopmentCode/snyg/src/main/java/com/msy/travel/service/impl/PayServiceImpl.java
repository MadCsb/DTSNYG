package com.msy.travel.service.impl;

import static com.alipay.api.AlipayConstants.APP_ID;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.LogicException;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.Result;
import com.msy.travel.common.WxPayUtil;
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
import com.msy.travel.service.ICityService;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.OrderListService;
import com.msy.travel.service.OrderService;
import com.msy.travel.service.PayService;
import com.msy.travel.service.ThirdPayFlowService;
import com.msy.travel.wx.utils.MD5Util;
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

	@Resource(name = "orderListServiceImpl")
	private OrderListService orderListService;

	@Resource(name = "thirdPayFlowServiceImpl")
	private ThirdPayFlowService thirdPayFlowService;

	@Resource(name = "alipayClient")
	private AlipayClient alipayClient;





	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

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
	 * 支付宝 wap方式
	 */
	private static String PAY_METHOD_ALIPAY_WAP = "ALIPAY_WAP";

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
		double totalFee = 0; //订单金额
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
				if (configParameter.getWxpayValidateTime() != null && !configParameter.getWxpayValidateTime().trim().equals(""))
				{
					SimpleDateFormat sdf = new SimpleDateFormat(DateTimeUtil.sdf19);
					Calendar cal = Calendar.getInstance();
					cal.setTime(sdf.parse(order.getOrderDate()));
					cal.add(Calendar.SECOND,Integer.valueOf(configParameter.getWxpayValidateTime()));
					payInfoParam.put("timeExpire",sdf.format(cal.getTime()));
				}
			}
			totalFee = totalFee + Double.valueOf(order.getMoney());
		}
		payInfoParam.put("body",bodySb.toString());

		//第三方支付流水表
		ThirdPayFlow thirdPayFlow = new ThirdPayFlow();
		thirdPayFlow.setFlowId(PrimaryKeyUtil.generateKey());
		thirdPayFlow.setPlatformFlowCode(PrimaryKeyUtil.getOnlyPlatformFlowCode());
		thirdPayFlow.setCreateTime(DateTimeUtil.getDateTime19());
		thirdPayFlow.setFlowState("0");
		thirdPayFlow.setFlowMoney(String.valueOf(totalFee));
		thirdPayFlow.setPlatformOrders(platformOrders);
		thirdPayFlow.setSpId(spId);
		thirdPayFlowService.createThirdPayFlow(thirdPayFlow);
		payInfoParam.put("flowId",thirdPayFlow.getFlowId());

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
	 * param.flowId 本系统支付流水ID
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
		thirdPayFlow.setFlowId(param.get("flowId"));
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
		httpRequestParamMap.put("total_fee", String.valueOf((int)(Double.valueOf(thirdPayFlow.getFlowMoney())*100)));//金额 单位分
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
		log.error("微信支付 WX params xml:"+ document.getRootElement().asXML());
		//请求统一支付接口
		String res = WxPayUtil.httpRequest(WxPayUtil.WX_PAY_URL, "POST", document.asXML());

		log.error("微信支付 WX 统一支付接口响应:"+res);
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
			payInfo.put("flowId",thirdPayFlow.getFlowId());
			result.setResultCode("0");
			result.setResultMsg("获取微信支付订单信息成功");
			result.setResultPojo(payInfo);
		}else
		{
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
	 * param.flowId 本系统支付流水ID
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
		thirdPayFlow.setFlowId(param.get("flowId"));
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
		httpRequestParamMap.put("total_fee", String.valueOf((int)(Double.valueOf(thirdPayFlow.getFlowMoney())*100)));//金额 单位分
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
		log.error("微信支付 WX params xml:"+ document.getRootElement().asXML());
		//请求统一支付接口
		String res = WxPayUtil.httpRequest(WxPayUtil.WX_PAY_URL, "POST", document.asXML());

		log.error("微信支付 WX 统一支付接口响应:"+res);
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
			payInfo.put("mweb_url", httpResponseResultMap.get("mweb_url"));
			result.setResultCode("0");
			result.setResultMsg("获取微信支付订单信息成功");
			result.setResultPojo(payInfo);
		}else
		{
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
	 * param.flowId 本系统支付流水ID
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
		thirdPayFlow.setFlowId(param.get("flowId"));
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
		httpRequestParamMap.put("total_fee", String.valueOf((int)(Double.valueOf(thirdPayFlow.getFlowMoney())*100)));//金额 单位分
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
		log.error("微信支付 WX params xml:"+ document.getRootElement().asXML());
		//请求统一支付接口
		String res = WxPayUtil.httpRequest(WxPayUtil.WX_PAY_URL, "POST", document.asXML());

		log.error("微信支付 WX 统一支付接口响应:"+res);
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
			result.setResultCode("0");
			result.setResultMsg("获取微信支付订单信息成功");
			result.setResultPojo(payInfo);
		}else
		{
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
	 * param.flowId 本系统支付流水ID
	 * param.remoteAddr 创建订单的用户ID
	 * param.timeExpire 订单失效时间
	 * param.openId 微信用户OpenId
	 * param.productId 订单的商品ID
	 * @return
	 */
	private Result getPayInfoByAlipayWAP(Map<String,String> param) throws Exception {

		AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
		alipayRequest.setReturnUrl("http://www.3nong1gou.com/pay_zfbPayedNotify");
		alipayRequest.setBizContent("{" +
				"\"body\":\"Iphone6 16G\"," +
				"\"subject\":\"大乐透\"," +
				"\"out_trade_no\":\"70501111111S001111119\"," +
				"\"timeout_express\":\"90m\"," +
				"\"time_expire\":\"2016-12-31 10:05\"," +
				"\"total_amount\":9.00," +
				"\"seller_id\":\"2088102147948060\"," +
				"\"auth_token\":\"appopenBb64d181d0146481ab6a762c00714cC27\"," +
				"\"goods_type\":\"0\"," +
				"\"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
				"\"quit_url\":\"http://www.taobao.com/product/113714.html\"," +
				"\"product_code\":\"QUICK_WAP_WAY\"," +
				"\"promo_params\":\"{\\\"storeIdType\\\":\\\"1\\\"}\"," +
				"\"royalty_info\":{" +
				"\"royalty_type\":\"ROYALTY\"," +
				"        \"royalty_detail_infos\":[{" +
				"          \"serial_no\":1," +
				"\"trans_in_type\":\"userId\"," +
				"\"batch_no\":\"123\"," +
				"\"out_relation_id\":\"20131124001\"," +
				"\"trans_out_type\":\"userId\"," +
				"\"trans_out\":\"2088101126765726\"," +
				"\"trans_in\":\"2088101126708402\"," +
				"\"amount\":0.1," +
				"\"desc\":\"分账测试1\"," +
				"\"amount_percentage\":\"100\"" +
				"          }]" +
				"    }," +
				"\"extend_params\":{" +
				"\"sys_service_provider_id\":\"2088511833207846\"," +
				"\"hb_fq_num\":\"3\"," +
				"\"hb_fq_seller_percent\":\"100\"," +
				"\"industry_reflux_info\":\"{\\\\\\\"scene_code\\\\\\\":\\\\\\\"metro_tradeorder\\\\\\\",\\\\\\\"channel\\\\\\\":\\\\\\\"xxxx\\\\\\\",\\\\\\\"scene_data\\\\\\\":{\\\\\\\"asset_name\\\\\\\":\\\\\\\"ALIPAY\\\\\\\"}}\"," +
				"\"card_type\":\"S0JP0000\"" +
				"    }," +
				"\"sub_merchant\":{" +
				"\"merchant_id\":\"19023454\"," +
				"\"merchant_type\":\"alipay: 支付宝分配的间连商户编号, merchant: 商户端的间连商户编号\"" +
				"    }," +
				"\"merchant_order_no\":\"20161008001\"," +
				"\"enable_pay_channels\":\"pcredit,moneyFund,debitCardExpress\"," +
				"\"disable_pay_channels\":\"pcredit,moneyFund,debitCardExpress\"," +
				"\"store_id\":\"NJ_001\"," +
				"\"settle_info\":{" +
				"        \"settle_detail_infos\":[{" +
				"          \"trans_in_type\":\"cardAliasNo\"," +
				"\"trans_in\":\"A0001\"," +
				"\"summary_dimension\":\"A0001\"," +
				"\"settle_entity_id\":\"2088xxxxx;ST_0001\"," +
				"\"settle_entity_type\":\"SecondMerchant、Store\"," +
				"\"amount\":0.1" +
				"          }]" +
				"    }," +
				"\"invoice_info\":{" +
				"\"key_info\":{" +
				"\"is_support_invoice\":true," +
				"\"invoice_merchant_name\":\"ABC|003\"," +
				"\"tax_num\":\"1464888883494\"" +
				"      }," +
				"\"details\":\"[{\\\"code\\\":\\\"100294400\\\",\\\"name\\\":\\\"服饰\\\",\\\"num\\\":\\\"2\\\",\\\"sumPrice\\\":\\\"200.00\\\",\\\"taxRate\\\":\\\"6%\\\"}]\"" +
				"    }," +
				"\"specified_channel\":\"pcredit\"," +
				"\"business_params\":\"{\\\"data\\\":\\\"123\\\"}\"," +
				"\"ext_user_info\":{" +
				"\"name\":\"李明\"," +
				"\"mobile\":\"16587658765\"," +
				"\"cert_type\":\"IDENTITY_CARD\"," +
				"\"cert_no\":\"362334768769238881\"," +
				"\"min_age\":\"18\"," +
				"\"fix_buyer\":\"F\"," +
				"\"need_check_info\":\"F\"" +
				"    }" +
				"  }");
		if ()
		AlipayTradeWapPayResponse response = alipayClient.pageExecute(alipayRequest);
		response.getCode();
		response.getMsg();
		response.getSubCode();
		response.getOutTradeNo();
		response.getBody();
		response.isSuccess()

		Result result = new Result();
		return result;
	}
}

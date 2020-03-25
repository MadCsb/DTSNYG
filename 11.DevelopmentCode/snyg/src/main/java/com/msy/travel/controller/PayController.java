package com.msy.travel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.Consts;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.LogicException;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.SysConsts;
import com.msy.travel.common.WxPayUtil;
import com.msy.travel.common.XmlJsonTool;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.common.wx.Sha1Util;
import com.msy.travel.pojo.*;
import com.msy.travel.service.*;
import com.msy.travel.wx.utils.MD5Util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

@Controller
@Scope(value = "prototype")
public class PayController extends BaseController {
	public static final Log log = LogFactory.getLog(PayController.class);

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

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	/**
	 * 微信支付方式-公众号原生
	 */
	private static String PAY_METHOD_WX = "WX";

	/**
	 * 微信支付方式-移动系统h5调用
	 */
	private static String PAY_METHOD_WX_H5 = "WX_H5";

	/**
	 * 微信支付方式-pc系统二维码
	 */
	private static String PAY_METHOD_WX_PC = "WX_PC";

	/**
	 * 获取当前微信用户的OpenId
	 * @param param{payMethod:支付方式,openId:微信用户openId,spId:运营商id,platformOrders:订单ids,}
	 * json返回内容{resultCode:成功0,resultMsg:,flowId:流水id,不同支付必须的信息}
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/pay_getPayInfo")
	public void getPayInfo(HttpServletRequest request, HttpServletResponse response,String param) {
		JSONObject paramObject = JSON.parseObject(param);
		Map<String,String> payInfo = new HashMap<String,String>();
		payInfo.put("resultCode","0"); //默认获取成功
		payInfo.put("resultMsg","获取支付信息成功");
		try{
			String payMethod = paramObject.getString("payMethod") ;
			String openId = paramObject.getString("openId") ;
			String spId = paramObject.getString("spId");
			String platformOrders = paramObject.getString("platformOrders");

			StringBuffer body = new StringBuffer(); //wx订单名称，最长180
			String productId = null;
			String timeExpire = null; //wx订单失效日期
			double totalFee = 0; //wx 订单金额
			String[] orderIds = platformOrders.split(",");
			for (int i=0;i<orderIds.length;i++)
			{
				Order order = new Order();
				order.setOrderId(orderIds[i]);
				order = orderService.displayOrder(order);
				OrderList orderList = new OrderList();
				orderList.setOrderId(order.getOrderId());
				List<OrderList> orderListList = orderListService.queryOrderListList(orderList);
				productId = orderListList.get(0).getGoodsPriceId();
				if ("1".equals(order.getPayTag())) //订单已支付
				{
					throw new LogicException("订单已支付，无需再次支付");
				}
				if (!"0".equals(order.getBeforePayStatus())) //订单已支付
				{
					throw new LogicException("订单已取消，无需支付");
				}
				body.append(order.getProductName());
				if (i==0)
				{
					if (configParameter.getWxpayValidateTime() != null && !configParameter.getWxpayValidateTime().trim().equals(""))
					{
						SimpleDateFormat sdf = new SimpleDateFormat(DateTimeUtil.sdf19);
						Calendar cal = Calendar.getInstance();
						cal.setTime(sdf.parse(order.getOrderDate()));
						cal.add(Calendar.SECOND,Integer.valueOf(configParameter.getWxpayValidateTime()));
						timeExpire = sdf.format(cal.getTime());
					}
				}
				totalFee = totalFee + Double.valueOf(order.getMoney());
			}

			Destsp destsp = new Destsp();
			destsp.setSpId(spId);
			destsp = destspService.displayDestsp(destsp);
			ServiceCode serviceCode = new ServiceCode();
			serviceCode.setServiceId(destsp.getWxServiceId());
			serviceCode = serviceCodeService.displayServiceCode(serviceCode);

			//第三方支付流水表
			ThirdPayFlow thirdPayFlow = new ThirdPayFlow();

			thirdPayFlow.setFlowId(PrimaryKeyUtil.generateKey());
			thirdPayFlow.setPlatformFlowCode(PrimaryKeyUtil.getOnlyPlatformFlowCode());
			thirdPayFlow.setCreateTime(DateTimeUtil.getDateTime19());
			thirdPayFlow.setFlowState("0");
			thirdPayFlow.setFlowMoney(totalFee+"");
			thirdPayFlow.setPlatformOrders(platformOrders);
			thirdPayFlow.setSpId(spId);

			//微信支付信息
			Map<String,String> paramMap = new TreeMap<String, String>();
			paramMap.put("appid", serviceCode.getAppId());  //公众账号 ID
			paramMap.put("mch_id", serviceCode.getTenPayPartner()); //商户号
			//paramMap.put("device_info", null); //设备号
			paramMap.put("nonce_str", MD5Util.MD5Encode(String.valueOf(new Random().nextInt(10000)), "UTF-8"));//随机字符串，不长于32位
			//paramMap.put("sign_type", "MD5"); //签名类型 默认为MD5，支持HMAC-SHA256和MD5。
			//paramMap.put("body", (body.length()>175?body.substring(0,175):body.toString()));//商品描述
			paramMap.put("body",(body.length()>175?body.substring(0,175):body.toString()));
			//paramMap.put("detail", null); //商品详情
			//paramMap.put("attach", null); //附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。
			paramMap.put("out_trade_no", thirdPayFlow.getPlatformFlowCode());//商户系统内部订单号
			//paramMap.put("fee_type", "CNY");//符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见
			paramMap.put("total_fee", (int)(totalFee*100)+"");//金额 单位分

			//判断是否是ipv6地址 如0:0:0:0:0:0:1
			if(request.getRemoteAddr().indexOf(":")>-1){
				paramMap.put("spbill_create_ip", "127.0.0.1");//终端IP
			}else{
				paramMap.put("spbill_create_ip", request.getRemoteAddr());//终端IP
			}
			//paramMap.put("time_start", null); //订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
			paramMap.put("time_expire", timeExpire.replaceAll(":", "").replaceAll("-", "").replaceAll(" ", ""));
			//paramMap.put("goods_tag",null); //订单优惠标记
			paramMap.put("notify_url", configParameter.getWxpayNotifyUrl()); //通知地址

			if(payMethod.equals(PAY_METHOD_WX)) //微信支付，
			{
				paramMap.put("trade_type", "JSAPI");
				paramMap.put("openid", openId);
			}else if(payMethod.equals("h5")) //移动端支付(OK)
			{
				paramMap.put("trade_type", "MWEB");
			}else if(payMethod.equals(PAY_METHOD_WX_PC)) //扫描支付(OK)
			{
				paramMap.put("trade_type", "NATIVE");
				paramMap.put("product_id",productId); //商品ID
			}
			//paramMap.put("limit_pay", null); //上传此参数no_credit--可限制用户不能使用信用卡支付
			//paramMap.put("receipt", null); //Y，传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
			//paramMap.put("scene_info",null); //该字段常用于线下活动时的场景信息上报，支持上报实际门店信息，商户也可以按需求自己上报相关信息。该字段为JSON对象数据，对象格式为{"store_info":{"id": "门店ID","name": "名称","area_code": "编码","address": "地址" }} ，字段详细说明请点击行前的+展开

			String sign = WxPayUtil.createSign(paramMap, serviceCode.getTenPayPartnerKey());
			paramMap.put("sign", sign);
			org.dom4j.Document document = DocumentHelper.createDocument();
			Element elementXml = document.addElement("xml");
			for (Entry<String , String> entry : paramMap.entrySet()) {
				elementXml.addElement(entry.getKey()).addCDATA(entry.getValue());
			}
			log.error("微信支付 params xml:"+ document.getRootElement().asXML());
			//请求统一支付接口
			String res = WxPayUtil.httpRequest(WxPayUtil.WX_PAY_URL, "POST", document.asXML());

			log.error("微信支付统一支付接口响应:"+res);
			document = DocumentHelper.parseText(res);
			Element root = document.getRootElement();
			List<Element> list = root.elements();
			paramMap = new TreeMap<String, String>();
			for (Element ele:list)
			{
				paramMap.put(ele.getName(), ele.getText());
			}
			//支付成功
			if(paramMap.get("return_code")!=null&&paramMap.get("result_code")!=null
					&&"SUCCESS".equals(paramMap.get("return_code").toUpperCase())
					&&"SUCCESS".equals(paramMap.get("result_code").toUpperCase())){

				//payMethod=wx微信浏览器，公众号直接支付
				//payMethod=h5移动端html5页面，非微信浏览器打开
				//payMethod=pc非移动浏览器打开，二维码
				if(payMethod.equals(PAY_METHOD_WX)) //微信支付，
				{
					Map<String,String> signParamMap = new TreeMap<String, String>();
					signParamMap.put("appId", paramMap.get("appid"));
					signParamMap.put("timeStamp", Sha1Util.getTimeStamp());
					signParamMap.put("nonceStr", Sha1Util.getNonceStr());
					signParamMap.put("package", "prepay_id="+paramMap.get("prepay_id"));
					signParamMap.put("signType", "MD5");
					log.error("支付签名前:"+JSON.toJSONString(signParamMap));
					sign = WxPayUtil.createSign(signParamMap, serviceCode.getTenPayPartnerKey());

					payInfo.put("appId", paramMap.get("appid"));
					payInfo.put("timeStamp", signParamMap.get("timeStamp"));
					payInfo.put("nonceStr", signParamMap.get("nonceStr"));
					payInfo.put("package", "prepay_id="+paramMap.get("prepay_id"));
					payInfo.put("signType", "MD5");
					payInfo.put("paySign", sign);
					log.error("支付签名后:"+JSON.toJSONString(payInfo));
				}else if(payMethod.equals(PAY_METHOD_WX_H5)) //移动端支付
				{
					payInfo.put("mweb_url", paramMap.get("mweb_url"));
				}else if(payMethod.equals(PAY_METHOD_WX_PC)) //扫描支付
				{
					payInfo.put("code_url",paramMap.get("code_url"));
				}
				thirdPayFlowService.createThirdPayFlow(thirdPayFlow);
				payInfo.put("flowId",thirdPayFlow.getFlowId());
			}else
			{
				throw new LogicException("获取微信支付结果失败");
			}
		}catch (LogicException e1)
		{
			log.error(e1.getMessage());
			payInfo.put("resultCode","1"); //获取失败
			payInfo.put("resultMsg",e1.getMessage());
		}catch (Exception e){
			log.error(e);
			payInfo.put("resultCode","1"); //获取失败
			payInfo.put("resultMsg","未知异常");

		}
		try {
			response.getWriter().write(JSON.toJSONString(payInfo).toString());
		}catch (Exception e)
		{
			log.error(e);
		}
	}

	@RequestMapping(value = "/pay_getThirdPayFlow")
	public void getThirdPayFlow(HttpServletRequest request, HttpServletResponse response,ThirdPayFlow thirdPayFlow) {
		try {
			thirdPayFlow = thirdPayFlowService.displayThirdPayFlow(thirdPayFlow);
			response.getWriter().write(net.sf.json.JSONObject.fromObject(thirdPayFlow).toString());
		}catch (Exception e)
		{
			log.error(e);
		}
	}

	/**
	 * 微信支付返回地址
	 */
	@RequestMapping(value = "/pay_wxPayedNotify")
	public void pay_wxPayedNotify(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			StringBuffer xmlStr = new StringBuffer();
			request.setCharacterEncoding("utf-8");
			BufferedReader reader = request.getReader();
			String line = "";
			while ((line = reader.readLine()) != null) {
				line = line.replaceAll("\r|\n", "");
				xmlStr.append(line);
			}

			org.dom4j.Document doc = DocumentHelper.parseText(xmlStr.toString());
			Element rootElt = doc.getRootElement();
			System.out.println("根节点：" + rootElt.getName());
			Iterator iter = rootElt.elementIterator();
			Map<String,String> resMap = new HashMap<>();
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				resMap.put(recordEle.getName(),recordEle.getText());
				log.error(recordEle.getName()+"========"+recordEle.getText());
			}

			if(resMap.get("return_code")!=null&&resMap.get("result_code")!=null
					&&"SUCCESS".equals(resMap.get("return_code").toUpperCase())
					&&"SUCCESS".equals(resMap.get("result_code").toUpperCase())) {
				//商户订单号
				String out_trade_no = resMap.get("out_trade_no");
				//财付通订单号
				String transaction_id = resMap.get("transaction_id");
				//
				String total_fee = resMap.get("total_fee");
				//支付类型
				String trade_type = resMap.get("trade_type");
				//随机字符串
				String nonce_str = resMap.get("nonce_str");
				//签名
				String sign = resMap.get("sign");

				ThirdPayFlow thirdPayFlow = new ThirdPayFlow();
				thirdPayFlow.setPlatformFlowCode(out_trade_no);
				List<ThirdPayFlow> thirdPayFlowList = thirdPayFlowService.queryThirdPayFlowList(thirdPayFlow);

				//支付验证
				if ((int) (Double.valueOf(thirdPayFlowList.get(0).getFlowMoney()) * 100) ==Integer.valueOf(total_fee))  // 返回的订单金额是否与商户侧的订单金额一致
				{

					//签名验证
					Destsp destsp = new Destsp();
					destsp.setSpId(thirdPayFlowList.get(0).getSpId());
					destsp = destspService.displayDestsp(destsp);

					ServiceCode serviceCode = new ServiceCode();
					serviceCode.setServiceId(destsp.getWxServiceId());
					serviceCode = serviceCodeService.displayServiceCode(serviceCode);

					resMap.remove("sign");
					String resultSign = WxPayUtil.createSign(resMap, serviceCode.getTenPayPartnerKey());

					if (resultSign.equals(sign)) {
						if(thirdPayFlowList.get(0).getFlowState().equals("0"))
						{
							thirdPayFlowList.get(0).setFlowState("1"); //流水成功
							thirdPayFlowList.get(0).setThirdFlowCode(transaction_id);
							thirdPayFlowList.get(0).setThirdCreateTime(DateTimeUtil.getDateTime19());

							thirdPayFlowService.flowReturn(thirdPayFlowList.get(0));
						}else
						{
							//已经支付成功
						}
						//发送通知成功消息给微信
						response.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
					}
				}
			}
		}catch(Exception e)
		{
			log.error("支付通知失败"+e);
		}

	}
}

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
import com.msy.travel.common.Result;
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

	@Resource(name = "payServiceImpl")
	private PayService payService;

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

			//{payMethod:支付方式,openId:微信用户openId,spId:运营商id,platformOrders:订单ids,remoteAddr;请求ip地址}
			JSONObject paramJSONObject = new JSONObject();
			paramJSONObject.put("payMethod",paramObject.getString("payMethod"));
			paramJSONObject.put("openId",paramObject.getString("openId"));
			paramJSONObject.put("spId",paramObject.getString("spId"));
			paramJSONObject.put("platformOrders",paramObject.getString("platformOrders"));
			if(request.getRemoteAddr().indexOf(":")>-1){
				paramJSONObject.put("remoteAddr","127.0.0.1");
			}else{
				paramJSONObject.put("remoteAddr",request.getRemoteAddr());
			}
			Result result = payService.getPayInfo(paramJSONObject);
			if ("0".equals(result.getResultCode()))
			{
				payInfo.putAll((Map<String,String>)result.getResultPojo());
			}else
			{
				throw new LogicException(result.getResultMsg());
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

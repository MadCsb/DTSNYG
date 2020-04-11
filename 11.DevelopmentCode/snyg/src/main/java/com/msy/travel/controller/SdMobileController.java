package com.msy.travel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.internal.util.AlipaySignature;
import com.chinamobile.sd.openapi.Common;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.LogicException;
import com.msy.travel.common.Result;
import com.msy.travel.common.WxPayUtil;
import com.msy.travel.common.config.AlipayConfigParameter;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.ThirdPayFlow;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.OrderListService;
import com.msy.travel.service.OrderService;
import com.msy.travel.service.PayService;
import com.msy.travel.service.SellPriceService;
import com.msy.travel.service.ThirdPayFlowService;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/sdmobile")
public class SdMobileController extends BaseController {
	public static final Log log = LogFactory.getLog(SdMobileController.class);

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;


	/**
	 * ajax 验证山东移动用户能否下单
	 * param
	 * {customerCouponId:客户优惠券关联ID,sellPrice[{priceId:销售id,num:数量}]}
	 */
	@RequestMapping(params = "method=canOrder")
	public void canOrder(String priceIds,String userId,HttpServletRequest request,HttpServletResponse response) {
		Result result = new Result();
		try
		{
			String[] priceIdArray = priceIds.split(",");
			User user = getLoginUser(request);
			if (user.getType().equals("2"))
			{
				Map<String ,String> param = new HashMap<>();

				for(int i=0;i<priceIdArray.length;i++)
				{
					SellPrice sellPrice = new SellPrice();
					sellPrice.setPriceId(priceIdArray[i]);
					sellPrice = sellPriceService.displaySellPrice(sellPrice);
					param.put("priceCode",sellPrice.getPriceCode());
					Map<String,String> map = new HashMap();
					map.put("msisdn",user.getUserLoginName());
					map.put("priceCode",param.get("priceCode"));
					Result sdResult =  Common.validMemberMbr(map);
					if (!"0".equals(sdResult.getResultCode()))
					{
						throw new LogicException(sdResult.getResultMsg());
					}
				}
				result.setResultCode("0");
				result.setResultMsg("可以预定");
			}
		}catch (LogicException le)
		{
			result = new Result();
			result.setResultCode("1");
			result.setResultMsg(le.getMessage());
		}
		catch (Exception e)
		{
			log.error(e,e);
			result = new Result();
			result.setResultCode("1");
			result.setResultMsg("系统异常");
		}
		try
		{
			response.getWriter().write(JSON.toJSONString(result));
		}catch (Exception e)
		{
			log.error(e);
		}
	}

}

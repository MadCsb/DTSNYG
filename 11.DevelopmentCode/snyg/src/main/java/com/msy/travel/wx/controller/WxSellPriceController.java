package com.msy.travel.wx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.pojo.Consignee;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.service.CompanyExpressService;
import com.msy.travel.service.ConsigneeService;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.SellPriceService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wx")
public class WxSellPriceController extends BaseController {
	public static final Log log = LogFactory.getLog(WxSellPriceController.class);

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;

	@Resource(name = "destspServiceImpl")
	private IDestspService destspService;

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Resource(name = "consigneeServiceImpl")
	private ConsigneeService consigneeService;

	@Resource(name = "companyExpressServiceImpl")
	private CompanyExpressService companyExpressService;

	/**
	 * 微信端获取商品列表
	 * 
	 * @author wzd
	 * @date 2019年10月5日 下午5:18:10
	 * @param sellPrice
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=querySellPriceListForWx")
	public void querySellPriceListForWx(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (sellPrice.getEntityPage() == null) {
				sellPrice.setEntityPage(new EntityPage());
				sellPrice.getEntityPage().setRowsPerPage(10);
			} else if (sellPrice.getEntityPage().getRowsPerPage() == 0) {
				sellPrice.getEntityPage().setRowsPerPage(10);
			}
			sellPrice.setDelFlag("0");
			sellPrice.setState("1");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pageNum", super.getPageNum(sellPrice.getEntityPage()));
			map.put("pageSize", super.getPageSize(sellPrice.getEntityPage()));
			map.put("reasonable", false);
			PageHelper.startPage(map);
			List<SellPrice> sellPricelist = sellPriceService.querySellPriceListForWx(sellPrice);

			JSONArray jsonArray = JSONArray.fromObject(sellPricelist);
			response.getWriter().print(jsonArray.toString());

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 微信端获取规格列表
	 * 
	 * @author wzd
	 * @date 2019年10月5日 下午5:18:10
	 * @param sellPrice
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=queryGoodsPriceListForWx")
	public void queryGoodsPriceListForWx(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (!"0".equals(sellPrice.getPriceType())) {
				sellPrice.setPriceDate(DateTimeUtil.getDateTime19());
			}
			List<SellPrice> sellPricelist = sellPriceService.queryGoodsPriceListForWx(sellPrice);

			if (sellPricelist != null && sellPricelist.size() > 0) {
				String userId = request.getParameter("userId");
				Consignee c = new Consignee();
				c.setUserId(userId);
				c.setEntityPage(new EntityPage());
				c.getEntityPage().setSortField("t.F_ISDEFAULT");
				c.getEntityPage().setSortOrder("DESC");
				List<Consignee> cList = consigneeService.queryConsigneeList(c);

				if (cList != null && cList.size() > 0) {
					c = cList.get(0);
					for (int i = 0; i < sellPricelist.size(); i++) {
						sellPricelist.get(i).setFreight(companyExpressService.getCompanyPrice(sellPricelist.get(i).getPriceId(), "1", c.getPcx().substring(0, c.getPcx().indexOf(" "))));
					}
				}
			}

			JSONArray jsonArray = JSONArray.fromObject(sellPricelist);
			response.getWriter().print(jsonArray.toString());

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 微信端获取规格列表
	 * 
	 * @author wzd
	 * @date 2019年10月5日 下午5:18:10
	 * @param sellPrice
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=queryGoodsPriceListForUpdate")
	public void queryGoodsPriceListForUpdate(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
		try {
			List<SellPrice> sellPricelist = sellPriceService.queryGoodsPriceListForWx(sellPrice);

			JSONArray jsonArray = JSONArray.fromObject(sellPricelist);
			response.getWriter().print(jsonArray.toString());

		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

package com.msy.travel.web.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.service.CompanyExpressService;
import com.msy.travel.service.ConsigneeService;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.SellPriceService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/webSellPrice")
public class WebSellPriceController extends BaseController {
	public static final Log log = LogFactory.getLog(WebSellPriceController.class);

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;

	@Resource(name = "destspServiceImpl")
	private IDestspService destspService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Resource(name = "consigneeServiceImpl")
	private ConsigneeService consigneeService;

	@Resource(name = "companyExpressServiceImpl")
	private CompanyExpressService companyExpressService;

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

			// if (sellPricelist != null && sellPricelist.size() > 0) {
			// String userId = request.getParameter("userId");
			// Consignee c = new Consignee();
			// c.setUserId(userId);
			// c.setEntityPage(new EntityPage());
			// c.getEntityPage().setSortField("t.F_ISDEFAULT");
			// c.getEntityPage().setSortOrder("DESC");
			// List<Consignee> cList = consigneeService.queryConsigneeList(c);
			//
			// if (cList != null && cList.size() > 0) {
			// c = cList.get(0);
			// for (int i = 0; i < sellPricelist.size(); i++) {
			// Result result =
			// companyExpressService.getCompanyPrice(sellPricelist.get(i).getPriceId(),
			// "1", c.getPcx().substring(0, c.getPcx().indexOf(" ")));
			// if (result.getResultCode().equals("0")) {
			// com.alibaba.fastjson.JSONObject json =
			// (com.alibaba.fastjson.JSONObject) result.getResultPojo();
			// sellPricelist.get(i).setFreight(json.getString("expressFee"));
			// }
			// }
			// }
			// }

			JSONArray jsonArray = JSONArray.fromObject(sellPricelist);
			response.getWriter().print(jsonArray.toString());

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	@RequestMapping(params = "method=querySellPriceListForWeb")
	public void querySellPriceListForWeb(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
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

			if (sellPricelist != null && sellPricelist.size() > 0) {
				for (int i = 0; i < sellPricelist.size(); i++) {
					SellPrice oldSellPrice = new SellPrice();
					oldSellPrice.setGoodsPriceId(sellPricelist.get(i).getGoodsPriceId());
					oldSellPrice.setPriceType("0");
					oldSellPrice = sellPriceService.displaySellPrice(oldSellPrice);

					sellPricelist.get(i).setOldPrice(oldSellPrice.getPrice());
				}
			}

			JSONArray jsonArray = JSONArray.fromObject(sellPricelist);
			response.getWriter().print(jsonArray.toString());

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 跳转列表页
	 * 
	 * @author wzd
	 * @date 2019年12月8日 下午2:07:38
	 * @param sellPrice
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=querySellPriceListForWebList")
	public ModelAndView querySellPriceListForWebList(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (sellPrice.getEntityPage() == null) {
				sellPrice.setEntityPage(new EntityPage());
			}
			if (sellPrice.getEntityPage().getSortField() == null || "".equals(sellPrice.getEntityPage().getSortField())) {
				sellPrice.getEntityPage().setSortField("p.F_UPDATETIME");
				sellPrice.getEntityPage().setSortOrder("DESC");
			}

			sellPrice.setDelFlag("0");
			sellPrice.setState("1");

			PageHelper.startPage(super.getPageNum(sellPrice.getEntityPage()), super.getPageSize(sellPrice.getEntityPage()));
			List<SellPrice> sellPricelist = sellPriceService.querySellPriceListForWx(sellPrice);
			PageInfo<SellPrice> pageInfo = new PageInfo<SellPrice>(sellPricelist);

			if (sellPricelist != null && sellPricelist.size() > 0) {
				for (int i = 0; i < sellPricelist.size(); i++) {
					if (!"0".equals(sellPricelist.get(i).getPriceType())) {
						SellPrice oldSellPrice = new SellPrice();
						oldSellPrice.setGoodsPriceId(sellPricelist.get(i).getGoodsPriceId());
						oldSellPrice.setPriceType("0");
						oldSellPrice = sellPriceService.displaySellPrice(oldSellPrice);

						sellPricelist.get(i).setOldPrice(oldSellPrice.getPrice());
					}
				}
			}

			view = new ModelAndView("web/commproduct/queryCommproduct");
			view.addObject("entityPage", sellPrice.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("sellPricelist", sellPricelist);
			view.addObject("sellPrice", sellPrice);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 获得热销数量
	 * 
	 * @author wzd
	 * @date 2019年12月9日 下午8:01:59
	 * @param sellPrice
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=getSellPriceByOrderCount")
	public void getSellPriceByOrderCount(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (sellPrice == null) {
				sellPrice = new SellPrice();
			}
			if (sellPrice.getEntityPage() == null) {
				sellPrice.setEntityPage(new EntityPage());
			}
			if (sellPrice.getEntityPage().getSortField() == null || "".equals(sellPrice.getEntityPage().getSortField())) {
				sellPrice.getEntityPage().setSortField("saleNum");
				sellPrice.getEntityPage().setSortOrder("DESC");
			}

			List<SellPrice> sellPricelist = sellPriceService.querySellPriceListOrderByOrderCount(sellPrice);

			JSONArray jsonArray = JSONArray.fromObject(sellPricelist);
			response.getWriter().print(jsonArray.toString());

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 获取浏览量
	 * 
	 * @author wzd
	 * @date 2019年12月9日 下午8:49:46
	 * @param sellPrice
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=querySellPriceListOrderByAccess")
	public void querySellPriceListOrderByAccess(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (sellPrice == null) {
				sellPrice = new SellPrice();
			}
			if (sellPrice.getEntityPage() == null) {
				sellPrice.setEntityPage(new EntityPage());
			}
			if (sellPrice.getEntityPage().getSortField() == null || "".equals(sellPrice.getEntityPage().getSortField())) {
				sellPrice.getEntityPage().setSortField("accTemp.F_PDCCOUNT");
				sellPrice.getEntityPage().setSortOrder("DESC");
			}

			List<SellPrice> sellPricelist = sellPriceService.querySellPriceListOrderByAccess(sellPrice);

			JSONArray jsonArray = JSONArray.fromObject(sellPricelist);
			response.getWriter().print(jsonArray.toString());

		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

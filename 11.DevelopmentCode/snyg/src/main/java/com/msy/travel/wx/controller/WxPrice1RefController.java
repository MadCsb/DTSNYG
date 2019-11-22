package com.msy.travel.wx.controller;

import java.util.List;

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

import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.pojo.Commproduct;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.GoodsPrice;
import com.msy.travel.pojo.Price1Ref;
import com.msy.travel.service.CommproductService;
import com.msy.travel.service.GoodsPriceService;
import com.msy.travel.service.Price1RefService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wx")
public class WxPrice1RefController extends BaseController {
	public static final Log log = LogFactory.getLog(WxPrice1RefController.class);

	@Resource(name = "price1RefServiceImpl")
	private Price1RefService price1RefService;

	@Resource(name = "commproductServiceImpl")
	private CommproductService commproductService;

	@Resource(name = "goodsPriceServiceImpl")
	private GoodsPriceService goodsPriceService;

	/**
	 * 商品详情页获取团购信息
	 * 
	 * @author wzd
	 * @date 2019年11月17日 下午7:16:35
	 * @param price1Ref
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=queryPrice1RefForJson")
	public void queryPrice1RefList(Price1Ref price1Ref, HttpServletRequest request, HttpServletResponse response) {

		try {
			if (price1Ref.getEntityPage() == null) {
				price1Ref.setEntityPage(new EntityPage());
			}
			price1Ref.getEntityPage().setSortField("F_PRICESTARTDATE");
			price1Ref.setValidateDate(DateTimeUtil.getDateTime19());
			List<Price1Ref> price1Reflist = price1RefService.queryPrice1RefListFowWx(price1Ref);
			JSONArray jsonArray = JSONArray.fromObject(price1Reflist);
			response.getWriter().print(jsonArray.toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 跳转到团购信息详情页
	 * 
	 * @author wzd
	 * @date 2019年11月17日 下午7:17:45
	 * @param sellPrice
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=queryPrice1RefList")
	public ModelAndView querySellPriceListForWx(Price1Ref price1Ref, HttpServletRequest request, HttpServletResponse response, String userId) {
		ModelAndView view = null;
		try {
			price1Ref.setEntityPage(new EntityPage());
			price1Ref.getEntityPage().setSortField("t.F_ISBEGIN DESC,t.F_CREATETIME ASC");
			List<Price1Ref> price1RefList = price1RefService.queryPrice1RefList(price1Ref);

			Commproduct commproduct = new Commproduct();
			commproduct.setPriceId(price1Ref.getPriceId());
			commproduct = commproductService.queryCommproductForWx(commproduct);

			GoodsPrice goodsPrice = new GoodsPrice();
			goodsPrice.setPriceType("1");
			goodsPrice.setPriceId(price1Ref.getPriceId());
			List<GoodsPrice> goodsPrceList = goodsPriceService.queryGoodsPriceList(goodsPrice);
			if (goodsPrceList != null && goodsPrceList.size() > 0) {
				goodsPrice = goodsPrceList.get(0);
			}

			int num = 0;
			if (commproduct.getPeopleNum() != null && !"".equals(commproduct.getPeopleNum())) {
				num = Integer.parseInt(commproduct.getPeopleNum()) - price1RefList.size();
			}

			view = new ModelAndView("wx/price1Ref/queryPrice1RefDetail");
			view.addObject("spId", Destsp.currentSpId);
			view.addObject("price1RefList", price1RefList);
			view.addObject("price1Ref", price1Ref);
			view.addObject("userId", userId);
			view.addObject("commproduct", commproduct);
			view.addObject("goodsPrice", goodsPrice);
			view.addObject("num", num);
		} catch (Exception e) {
			log.error(e, e);
		}
		return view;
	}
}

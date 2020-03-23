package com.msy.travel.wap.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.SysConsts;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Accessrecord;
import com.msy.travel.pojo.Commproduct;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.OrderList;
import com.msy.travel.pojo.RsPic;
import com.msy.travel.pojo.User;
import com.msy.travel.service.CommproductService;
import com.msy.travel.service.CompanyService;
import com.msy.travel.service.GoodsPriceService;
import com.msy.travel.service.IAccessrecordService;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IRsPicService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.OrderListService;
import com.msy.travel.service.SellPriceService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wapCommproduct")
public class WapCommproductController extends BaseController {
	public static final Log log = LogFactory.getLog(WapCommproductController.class);

	@Resource(name = "commproductServiceImpl")
	private CommproductService commproductService;

	@Resource(name = "companyServiceImpl")
	private CompanyService companyService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Resource(name = "rsPicServiceImpl")
	private IRsPicService rsPicService;

	@Resource(name = "goodsPriceServiceImpl")
	private GoodsPriceService goodsPriceService;

	@Resource(name = "destspServiceImpl")
	private IDestspService destspService;

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Resource(name = "orderListServiceImpl")
	private OrderListService orderListService;

	@Resource(name = "accessrecordServiceImpl")
	private IAccessrecordService accessrecordService;

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;

	/**
	 * 跳转到列表
	 */
	@RequestMapping(params = "method=toQueryCommproduct")
	public ModelAndView toQueryCommproduct(Commproduct commproduct, HttpServletRequest request, HttpServletResponse response, String priceType) {
		ModelAndView view = null;
		try {
			if (commproduct.getEntityPage() == null) {
				commproduct.setEntityPage(new EntityPage());
			}

			view = new ModelAndView("wap/commproduct/queryCommproduct");
			view.addObject("commproduct", commproduct);
			view.addObject("entityPage", commproduct.getEntityPage());
			view.addObject("spId", Destsp.currentSpId);
			view.addObject("priceType", priceType);
		} catch (Exception e) {
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 跳转到详情
	 */
	@RequestMapping(params = "method=toQueryCommproductDetailByPriceId")
	public ModelAndView toQueryCommproductDetailByPriceId(Commproduct commproduct, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			commproduct = commproductService.queryCommproductForWx(commproduct);

			if ("0".equals(commproduct.getPriceType())) {
				view = new ModelAndView("wap/commproduct/commproductDetail0");
			} else if ("1".equals(commproduct.getPriceType())) {
				view = new ModelAndView("wap/commproduct/commproductDetail1");
			} else if ("2".equals(commproduct.getPriceType())) {
				view = new ModelAndView("wap/commproduct/commproductDetail2");
			}

			RsPic rsPic = new RsPic();
			rsPic.setRsId(commproduct.getProductId());
			rsPic.setRsType(SysConsts.RSTYPE_COMMPRODUCT);
			if (rsPic.getEntityPage() == null) {
				rsPic.setEntityPage(new EntityPage());
			}
			rsPic.getEntityPage().setSortField("t.F_ORDER");
			rsPic.getEntityPage().setSortOrder("ASC");
			List<RsPic> rsPicList = rsPicService.queryRsPicList(rsPic);

			OrderList ol = new OrderList();
			ol.setPriceId(commproduct.getPriceId());
			ol.setPayTag("1");
			ol.setOrderListType("0");
			ol = orderListService.queryGoodPriceCount(ol);

			User user = (User) view.getModel().get("user");

			Accessrecord accessrecord = new Accessrecord();
			accessrecord.setSpId(commproduct.getSpId());
			accessrecord.setUserId(user.getUserId());
			accessrecord.setAccessTime(DateTimeUtil.getDateTime19());
			accessrecord.setPdcId(commproduct.getProductId());
			accessrecord.setType("2");
			accessrecordService.createAccessrecord(accessrecord);

			if (commproduct.getSaleNum() != null && !"".equals(commproduct.getSaleNum())) {
				int saleNum = Integer.parseInt(commproduct.getSaleNum()) + Integer.parseInt(ol.getNum());
				commproduct.setSaleNum(saleNum + "");
			} else {
				commproduct.setSaleNum(ol.getNum());
			}

			view.addObject("commproduct", commproduct);
			view.addObject("rsPicList", rsPicList);
			view.addObject("spId", Destsp.currentSpId);
		} catch (Exception e) {
			log.error(e, e);
		}
		return view;
	}
}

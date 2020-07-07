package com.msy.travel.wx.controller;

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
import com.msy.travel.common.BigDecimalUtil;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.ResourceCommon;
import com.msy.travel.common.SysConsts;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Accessrecord;
import com.msy.travel.pojo.Commproduct;
import com.msy.travel.pojo.Coupon;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.OrderList;
import com.msy.travel.pojo.RoleData;
import com.msy.travel.pojo.RsPic;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.service.CommproductService;
import com.msy.travel.service.CompanyService;
import com.msy.travel.service.CouponService;
import com.msy.travel.service.GoodsPriceService;
import com.msy.travel.service.IAccessrecordService;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IRsPicService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.OrderListService;
import com.msy.travel.service.RoleDataService;
import com.msy.travel.service.SellPriceService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wx")
public class WxCommproductController extends BaseController {
	public static final Log log = LogFactory.getLog(WxCommproductController.class);

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

	@Resource(name = "couponServiceImpl")
	private CouponService couponService;

	@Resource(name = "roleDataServiceImpl")
	private RoleDataService roleDataService;

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

			ServiceCode serviceCode = serviceCodeService.getServiceCodeBySpId(Destsp.currentSpId);

			view = new ModelAndView("wx/commproduct/queryCommproduct");
			view.addObject("commproduct", commproduct);
			view.addObject("entityPage", commproduct.getEntityPage());
			view.addObject("serviceCode", serviceCode);
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
			// commproduct = new Commproduct();
			// commproduct.setPriceId("a9b082e73d8a4d4bab956a6d01a342ab");
			commproduct = commproductService.queryCommproductForWx(commproduct);

			if (null != commproduct.getFeeMemo()) {
				String msgString = commproduct.getFeeMemo();// 费用说明 转义字符换成<br/>
				String newMsg = msgString.replaceAll("\r\n", "<br/>");
				commproduct.setFeeMemo(newMsg);
			}

			if (null != commproduct.getTigInfo()) {
				String msgString = commproduct.getTigInfo();// 温馨提示 转义字符换成<br/>
				String newMsg = msgString.replaceAll("\r\n", "<br/>");
				commproduct.setTigInfo(newMsg);
			}

			if ("0".equals(commproduct.getPriceType())) {
				view = new ModelAndView("wx/commproduct/commproductDetail0");
			} else if ("1".equals(commproduct.getPriceType())) {
				view = new ModelAndView("wx/commproduct/commproductDetail1");
			} else if ("2".equals(commproduct.getPriceType())) {
				view = new ModelAndView("wx/commproduct/commproductDetail2");
			} else if ("3".equals(commproduct.getPriceType())) {
				view = new ModelAndView("wx/commproduct/commproductDetail3");
			} else {// 其他进普通页
				view = new ModelAndView("wx/commproduct/commproductDetail0");
			}

			view.addObject("commproduct", commproduct);

			String userRoleDataId = request.getParameter("userRoleDataId");// 微信回调获取
			if (userRoleDataId != null && !"".equals(userRoleDataId)) {
				RoleData roleData = new RoleData();
				roleData.setUserRoleDataId(userRoleDataId);
				roleData = roleDataService.displayRoleData(roleData);

				User user = new User();
				user.setUserId(roleData.getUserId());
				user = userService.displayUser(user);

				user.setRoleData(roleData);

				request.getSession().setAttribute(ResourceCommon.LOGIN_USER, user);
			}

			// view.addObject("user", new User());
			ServiceCode serviceCode = serviceCodeService.getServiceCodeBySpId(Destsp.currentSpId);
			wxSetViewObjects(view, request, serviceCode, userService);

			User user = (User) view.getModel().get("user");
			if (user == null || "".equals(user.getUserId())) {
				return view;
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

			if (user != null && user.getUserId() != null && !"".equals(user.getUserId())) {
				Accessrecord accessrecord = new Accessrecord();
				accessrecord.setSpId(commproduct.getSpId());
				accessrecord.setUserId(user.getUserId());
				accessrecord.setAccessTime(DateTimeUtil.getDateTime19());
				accessrecord.setPdcId(commproduct.getProductId());
				accessrecord.setType("1");
				accessrecordService.createAccessrecord(accessrecord);
			}

			if (commproduct.getSaleNum() != null && !"".equals(commproduct.getSaleNum())) {
				int saleNum = Integer.parseInt(commproduct.getSaleNum()) + Integer.parseInt(ol.getNum());
				commproduct.setSaleNum(saleNum + "");
			} else {
				commproduct.setSaleNum(ol.getNum());
			}

			// 检索优惠券
			Coupon coupon = null;
			List<Coupon> couponList = couponService.queryCouponListByPriceId(user, commproduct.getPriceId());
			if (couponList != null && couponList.size() > 0) {
				coupon = couponList.get(0);
				coupon.setValidBegin(DateTimeUtil.dateToMonthDay(coupon.getValidBegin()));
				coupon.setValidEnd(DateTimeUtil.dateToMonthDay(coupon.getValidEnd()));
				coupon.setUseLimit(BigDecimalUtil.getPrettyNumber(coupon.getUseLimit()));
				coupon.setDiscount(BigDecimalUtil.getPrettyNumber(coupon.getDiscount()));
			}

			SellPrice sellPrice = new SellPrice();
			sellPrice.setDelFlag("0");
			sellPrice.setProductId(commproduct.getProductId());
			sellPrice.setPriceType(commproduct.getPriceType());
			List<SellPrice> sellPriceList = sellPriceService.querySellPriceListForPriceType(sellPrice, user.getUserId());

			view.addObject("rsPicList", rsPicList);
			view.addObject("spId", Destsp.currentSpId);
			view.addObject("coupon", coupon);
			view.addObject("sellPriceList", sellPriceList);
		} catch (Exception e) {
			log.error(e, e);
		}
		return view;
	}
}

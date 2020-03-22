package com.msy.travel.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.common.SysConsts;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Commproduct;
import com.msy.travel.pojo.Company;
import com.msy.travel.pojo.PdcType;
import com.msy.travel.pojo.RsPic;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.service.CommproductService;
import com.msy.travel.service.CompanyService;
import com.msy.travel.service.IRsPicService;
import com.msy.travel.service.PdcTypeService;
import com.msy.travel.service.SellPriceService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/sellPrice")
public class SellPriceController extends BaseController {
	public static final Log log = LogFactory.getLog(SellPriceController.class);

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;

	@Resource(name = "companyServiceImpl")
	private CompanyService companyService;

	@Resource(name = "pdcTypeServiceImpl")
	private PdcTypeService pdcTypeService;

	@Resource(name = "commproductServiceImpl")
	private CommproductService commproductService;

	@Resource(name = "rsPicServiceImpl")
	private IRsPicService rsPicService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddSellPrice(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("sellprice/addSellPrice");
		return view;
	}

	/**
	 * 新增SellPrice
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addSellPrice(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			sellPriceService.createSellPrice(sellPrice);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 跳转到修改页面
	 */
	@RequestMapping(params = "method=toUpdateDetail")
	public ModelAndView toUpdateSellPriceDetail(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			sellPrice = sellPriceService.displaySellPrice(sellPrice);

			Commproduct commproduct = new Commproduct();
			commproduct.setProductId(sellPrice.getProductId());
			commproduct = commproductService.displayCommproduct(commproduct);

			RsPic rsPic = new RsPic();
			rsPic.setRsId(commproduct.getProductId());
			rsPic.setRsType(SysConsts.RSTYPE_COMMPRODUCT);
			if (rsPic.getEntityPage() == null) {
				rsPic.setEntityPage(new EntityPage());
			}
			rsPic.getEntityPage().setSortField("t.F_ORDER");
			rsPic.getEntityPage().setSortOrder("ASC");
			List<RsPic> rsPicList = rsPicService.queryRsPicList(rsPic);

			// 1 团购价 2秒杀价
			view = new ModelAndView("sellprice/updateSellPriceDetail");
			view.addObject("sellPrice", sellPrice);
			view.addObject("commproduct", commproduct);
			view.addObject("rsPicList", rsPicList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改SellPrice
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateSellPrice(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			sellPriceService.updateSellPrice(sellPrice);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除SellPrice
	 */
	@RequestMapping(params = "method=delete")
	public void deleteSellPrice(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {

		try {
			sellPrice.setDelFlag("1");
			sellPriceService.deleteSellPrice(sellPrice);
			response.getWriter().print("success");
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 批量删除
	 */
	@RequestMapping(params = "method=deleteBatch")
	public ModelAndView deleteBatchSellPrice(SellPrice sellPrice, String checkedSellPriceIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] sellPriceIds = checkedSellPriceIds.split(",");
		List<String> sellPriceIdList = new ArrayList<String>();
		Collections.addAll(sellPriceIdList, sellPriceIds);
		try {
			sellPrice.setSellPriceIdList(sellPriceIdList);
			sellPriceService.deleteBatchSellPrice(sellPrice);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 分页查询
	 */
	@RequestMapping(params = "method=query")
	public ModelAndView querySellPriceList(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response, String priceType, String openFlag) {
		ModelAndView view = null;
		try {
			if (sellPrice.getEntityPage() == null) {
				sellPrice.setEntityPage(new EntityPage());
			}
			sellPrice.setDelFlag("0");
			sellPrice.setSpId(getLoginUser(request).getAccId());

			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(sellPrice.getEntityPage()), super.getPageSize(sellPrice.getEntityPage()));
			List<SellPrice> sellPricelist = sellPriceService.querySellPriceListForWx(sellPrice);
			PageInfo<SellPrice> pageInfo = new PageInfo<SellPrice>(sellPricelist);

			Company c = new Company();
			c.setDelFlag("0");
			c.setSpId(getLoginUser(request).getAccId());
			List<Company> companyList = companyService.queryCompanyList(c);

			PdcType p = new PdcType();
			p.setDelFlag("0");
			p.setLevel("1");
			List<PdcType> pdcTypeList = pdcTypeService.queryPdcTypeList(p);

			if (priceType.equals("1")) {
				view = new ModelAndView("sellprice/querySellPrice");
			} else if (priceType.equals("2")) {
				view = new ModelAndView("sellprice/querySellPrice2");
			}
			view.addObject("sellPricelist", sellPricelist);
			view.addObject("entityPage", sellPrice.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("sellPrice", sellPrice);
			view.addObject("priceType", priceType);
			view.addObject("companyList", companyList);
			view.addObject("pdcTypeList", pdcTypeList);
			view.addObject("openFlag", openFlag);
			view.addObject("domainName", configParameter.getPreviewUrl());
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 导出excel
	 */
	@RequestMapping(params = "method=export")
	public void exportSellPrice(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "SellPrice-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (sellPrice.getEntityPage() == null) {
				sellPrice.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(sellPrice.getEntityPage()), super.getPageSize(sellPrice.getEntityPage()));
			List<SellPrice> exportlist = sellPriceService.querySellPriceList(sellPrice);

			PoiWriteExcel<SellPrice> pwe = new PoiWriteExcel<SellPrice>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(sellPrice.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 跳转修改
	 * 
	 * @author wzd
	 * @date 2019年10月20日 下午9:19:16
	 * @param sellPrice
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=toUpdate")
	public ModelAndView toUpdateSellPrice(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			sellPrice = sellPriceService.displaySellPrice(sellPrice);

			view = new ModelAndView("sellprice/updateSellPrice");
			view.addObject("sellPrice", sellPrice);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增或修改
	 * 
	 * @author wzd
	 * @date 2019年10月20日 下午9:57:47
	 * @param sellPrice
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=updateSellPriceForPriceId")
	public ModelAndView updateSellPriceForPriceId(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (sellPrice.getPriceStartDate() == null || "".equals(sellPrice.getPriceStartDate())) {
				sellPrice.setPriceStartDate(null);
			}
			if (sellPrice.getPriceEndDate() == null || "".equals(sellPrice.getPriceEndDate())) {
				sellPrice.setPriceEndDate(null);
			}
			if (sellPrice.getMaxBuyCount() == null || "".equals(sellPrice.getMaxBuyCount())) {
				sellPrice.setMaxBuyCount(null);
			}
			if (sellPrice.getLimitBuyCount() == null || "".equals(sellPrice.getLimitBuyCount())) {
				sellPrice.setLimitBuyCount(null);
			}
			if (sellPrice.getPeopleNum() == null || "".equals(sellPrice.getPeopleNum())) {
				sellPrice.setPeopleNum(null);
			}
			sellPrice.setUpdateTime(DateTimeUtil.getDateTime19());
			sellPrice.setDelFlag("0");
			sellPriceService.updateSellPrice(sellPrice);

			view = new ModelAndView("sellprice/updateSellPrice");
			view.addObject("sellPrice", sellPrice);
			view.addObject("tag", "1");
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 分页查询 - 新增
	 */
	@RequestMapping(params = "method=toQuerySellPriceListForAdd")
	public ModelAndView toQuerySellPriceListForAdd(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response, String priceType) {
		ModelAndView view = null;
		try {

			if (priceType.equals("1")) {
				view = new ModelAndView("sellprice/querySellPriceForAdd");
			} else if (priceType.equals("2")) {
				view = new ModelAndView("sellprice/querySellPriceForAdd2");
			}
			view.addObject("sellPrice", sellPrice);
			view.addObject("priceType", priceType);
			view.addObject("tag", "");
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 分页查询 - 新增
	 */
	@RequestMapping(params = "method=querySellPriceListForAdd")
	public ModelAndView querySellPriceListForAdd(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response, String priceType, String isSearch) {
		ModelAndView view = null;
		try {

			if (priceType.equals("1")) {
				view = new ModelAndView("sellprice/queryAddOrCreateSellPrice");
			} else if (priceType.equals("2")) {
				view = new ModelAndView("sellprice/queryAddOrCreateSellPrice2");
			}

			PdcType p = new PdcType();
			p.setDelFlag("0");
			p.setLevel("1");
			List<PdcType> pdcTypeList = pdcTypeService.queryPdcTypeList(p);

			if (sellPrice.getEntityPage() == null) {
				sellPrice.setEntityPage(new EntityPage());
			}
			sellPrice.getEntityPage().setRowsPerPage(5);
			sellPrice.setDelFlag("0");
			sellPrice.setSpId(getLoginUser(request).getAccId());

			PageHelper.startPage(super.getPageNum(sellPrice.getEntityPage()), super.getPageSize(sellPrice.getEntityPage()));
			List<SellPrice> sellPricelist = new ArrayList<SellPrice>();
			if ("1".equals(isSearch)) {
				// 设置分页
				sellPricelist = sellPriceService.queryGoodsPriceListForAdd(sellPrice);
			}

			PageInfo<SellPrice> pageInfo = new PageInfo<SellPrice>(sellPricelist);

			view.addObject("entityPage", sellPrice.getEntityPage());
			view.addObject("sellPrice", sellPrice);
			view.addObject("priceType", priceType);
			view.addObject("pdcTypeList", pdcTypeList);

			view.addObject("sellPricelist", sellPricelist);
			view.addObject("isSearch", isSearch);
			view.addObject("pageInfo", pageInfo);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 批量新增或修改
	 * 
	 * @author wzd
	 * @date 2019年10月23日 下午8:05:35
	 * @param sellPrice
	 * @param request
	 * @param response
	 * @param priceType
	 * @param openFlag
	 * @param isSearch
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=createOrUpdateSellPrice")
	public ModelAndView createOrUpdateSellPrice(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response, String priceType) {
		ModelAndView view = null;
		try {
			sellPriceService.createOrUpdateSellPrice(sellPrice);
			if (priceType.equals("1")) {
				view = new ModelAndView("sellprice/querySellPriceForAdd");
			} else if (priceType.equals("2")) {
				view = new ModelAndView("sellprice/querySellPriceForAdd2");
			}
			view.addObject("tag", "1");
			view.addObject("entityPage", new EntityPage());
			view.addObject("sellPrice", sellPrice);
			view.addObject("priceType", priceType);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 优惠券选择商品
	 * 
	 * @author wzd
	 * @date 2020年3月22日 下午5:47:25
	 * @param sellPrice
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=queryForCoupon")
	public ModelAndView queryForCoupon(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (sellPrice.getEntityPage() == null) {
				sellPrice.setEntityPage(new EntityPage());
			}

			if (sellPrice.getEntityPage().getSortField() == null || sellPrice.getEntityPage().getSortField().equals("")) {

				sellPrice.getEntityPage().setSortField("p.F_SORTNUM ASC,p.F_PRODUCTNAME ASC");
				sellPrice.getEntityPage().setSortOrder("");
			}

			sellPrice.setDelFlag("0");
			sellPrice.setSpId(getLoginUser(request).getAccId());

			if (sellPrice.getCheckPdc().equals("0")) {
				// 设置分页
				PageHelper.startPage(super.getPageNum(sellPrice.getEntityPage()), super.getPageSize(sellPrice.getEntityPage()));
				List<SellPrice> sellPriceList = sellPriceService.querySellPriceListForCoupon(sellPrice);
				PageInfo<SellPrice> pageInfo = new PageInfo<SellPrice>(sellPriceList);

				String sellPriceIdList = "";
				if (sellPrice.getSellPriceIdList() != null && sellPrice.getSellPriceIdList().size() > 0) {
					for (int i = 0; i < sellPrice.getSellPriceIdList().size(); i++) {
						if (!sellPriceIdList.equals("")) {
							sellPriceIdList += ",";
						}
						sellPriceIdList += sellPrice.getSellPriceIdList().get(i);
					}
				}

				view = new ModelAndView("coupon/querySellPriceForCoupon");

				view.addObject("sellPriceIdList", sellPriceIdList);
				view.addObject("sellPriceList", sellPriceList);
				view.addObject("pageInfo", pageInfo);
			} else if (sellPrice.getCheckPdc().equals("1")) {
				view = new ModelAndView("coupon/querySellPriceForCouponCheck");

				List<SellPrice> sellPriceList = new ArrayList<SellPrice>();

				if (sellPrice.getSellPriceIdList() != null && sellPrice.getSellPriceIdList().size() > 0) {
					// 设置分页
					PageHelper.startPage(super.getPageNum(sellPrice.getEntityPage()), super.getPageSize(sellPrice.getEntityPage()));
					sellPriceList = sellPriceService.querySellPriceListForCoupon(sellPrice);

				}
				PageInfo<SellPrice> pageInfo = new PageInfo<SellPrice>(sellPriceList);
				view.addObject("pageInfo", pageInfo);
				view.addObject("sellPriceList", sellPriceList);

			}

			view.addObject("entityPage", sellPrice.getEntityPage());
			view.addObject("sellPrice", sellPrice);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 选择的商品 回显
	 * 
	 * @author wzd
	 * @date 2020年3月22日 下午8:51:31
	 * @param sellPrice
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=queryForCouponPost")
	public void queryForCouponPost(SellPrice sellPrice, HttpServletRequest request, HttpServletResponse response) {
		try {

			if (sellPrice.getEntityPage() == null) {
				sellPrice.setEntityPage(new EntityPage());
			}

			if (sellPrice.getEntityPage().getSortField() == null || sellPrice.getEntityPage().getSortField().equals("")) {

				sellPrice.getEntityPage().setSortField("p.F_SORTNUM ASC,p.F_PRODUCTNAME ASC");
				sellPrice.getEntityPage().setSortOrder("");
			}

			sellPrice.setDelFlag("0");
			sellPrice.setSpId(getLoginUser(request).getAccId());

			List<SellPrice> sellPriceList = sellPriceService.querySellPriceListForCoupon(sellPrice);

			JSONArray jsonArray = JSONArray.fromObject(sellPriceList);
			response.getWriter().print(jsonArray.toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

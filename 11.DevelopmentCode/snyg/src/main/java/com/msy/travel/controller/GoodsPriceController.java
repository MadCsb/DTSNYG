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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.Consts;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.common.UploadFileCom;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.CompanyExpress;
import com.msy.travel.pojo.GoodsPrice;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.service.CompanyExpressService;
import com.msy.travel.service.GoodsPriceService;
import com.msy.travel.service.SellPriceService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/goodsPrice")
public class GoodsPriceController extends BaseController {
	public static final Log log = LogFactory.getLog(GoodsPriceController.class);

	@Resource(name = "goodsPriceServiceImpl")
	private GoodsPriceService goodsPriceService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Resource(name = "companyExpressServiceImpl")
	private CompanyExpressService companyExpressService;

	@Resource(name = "sellPriceServiceImpl")
	private SellPriceService sellPriceService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddGoodsPrice(GoodsPrice goodsPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("goodsprice/addGoodsPrice");

			CompanyExpress companyExpress = new CompanyExpress();
			companyExpress.setSpId(getLoginUser(request).getAccId());
			companyExpress.setEntityPage(new EntityPage());
			companyExpress.getEntityPage().setSortField("t.F_UPDATETIME");
			companyExpress.getEntityPage().setSortOrder("DESC");
			// companyExpress.setCompanyId(companyId);
			List<CompanyExpress> companyExpressList = companyExpressService.queryCompanyExpressList(companyExpress);

			view.addObject("companyExpressList", companyExpressList);

		} catch (Exception e) {
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增GoodsPrice
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addGoodsPrice(GoodsPrice goodsPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			goodsPriceService.createGoodsPrice(goodsPrice);
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
	@RequestMapping(params = "method=toUpdate")
	public ModelAndView toUpdateGoodsPrice(GoodsPrice goodsPrice, HttpServletRequest request, HttpServletResponse response, String priceType) {
		ModelAndView view = null;
		try {
			GoodsPrice objGoodsPrice = goodsPriceService.queryGoodsPriceByPriceId(goodsPrice);

			CompanyExpress companyExpress = new CompanyExpress();
			companyExpress.setSpId(getLoginUser(request).getAccId());
			companyExpress.setEntityPage(new EntityPage());
			companyExpress.getEntityPage().setSortField("t.F_UPDATETIME");
			companyExpress.getEntityPage().setSortOrder("DESC");
			// companyExpress.setCompanyId(companyId);
			List<CompanyExpress> companyExpressList = companyExpressService.queryCompanyExpressList(companyExpress);

			view = new ModelAndView("goodsprice/updateGoodsPrice");
			view.addObject("goodsPrice", objGoodsPrice);
			view.addObject("priceType", priceType);
			view.addObject("companyExpressList", companyExpressList);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改GoodsPrice
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateGoodsPrice(GoodsPrice goodsPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			goodsPriceService.updateGoodsPrice(goodsPrice);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除GoodsPrice
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteGoodsPrice(GoodsPrice goodsPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			goodsPriceService.deleteGoodsPrice(goodsPrice);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 批量删除
	 */
	@RequestMapping(params = "method=deleteBatch")
	public ModelAndView deleteBatchGoodsPrice(GoodsPrice goodsPrice, String checkedGoodsPriceIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] goodsPriceIds = checkedGoodsPriceIds.split(",");
		List<String> goodsPriceIdList = new ArrayList<String>();
		Collections.addAll(goodsPriceIdList, goodsPriceIds);
		try {
			goodsPrice.setGoodsPriceIdList(goodsPriceIdList);
			goodsPriceService.deleteBatchGoodsPrice(goodsPrice);
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
	public ModelAndView queryGoodsPriceList(GoodsPrice goodsPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (goodsPrice.getEntityPage() == null) {
				goodsPrice.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(goodsPrice.getEntityPage()), super.getPageSize(goodsPrice.getEntityPage()));
			List<GoodsPrice> goodsPricelist = goodsPriceService.queryGoodsPriceList(goodsPrice);
			PageInfo<GoodsPrice> pageInfo = new PageInfo<GoodsPrice>(goodsPricelist);

			view = new ModelAndView("goodsprice/queryGoodsPrice");
			view.addObject("goodsPricelist", goodsPricelist);
			view.addObject("entityPage", goodsPrice.getEntityPage());
			view.addObject("pageInfo", pageInfo);
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
	public void exportGoodsPrice(GoodsPrice goodsPrice, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "GoodsPrice-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (goodsPrice.getEntityPage() == null) {
				goodsPrice.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(goodsPrice.getEntityPage()), super.getPageSize(goodsPrice.getEntityPage()));
			List<GoodsPrice> exportlist = goodsPriceService.queryGoodsPriceList(goodsPrice);

			PoiWriteExcel<GoodsPrice> pwe = new PoiWriteExcel<GoodsPrice>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(goodsPrice.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 新增或修改商品规格
	 */
	@RequestMapping(params = "method=merge")
	public ModelAndView toMergoodsprice(GoodsPrice goodsPrice, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "upload1", required = false) MultipartFile multipartFile, String priceType) {
		ModelAndView view = null;
		try {
			if (goodsPrice.getGoodsPriceId() == null || goodsPrice.getGoodsPriceId().equals("")) {
				String thumbPic = UploadFileCom.uploadFileByFolder(multipartFile, request, Consts.WX_PIC_FOLDER_NAME, configParameter.getUploadPicUrl());
				// 新增
				goodsPriceService.createGoodsPriceAndSellPrice(thumbPic, goodsPrice);

				view = new ModelAndView("goodsprice/addGoodsPrice");

			} else {
				String thumbPic = goodsPrice.getThumbPic();
				if (multipartFile != null && multipartFile.getSize() > 0) {
					thumbPic = UploadFileCom.uploadFileByFolder(multipartFile, request, Consts.WX_PIC_FOLDER_NAME, configParameter.getUploadPicUrl());
				}
				goodsPriceService.updateGoodsPriceAndSellPrice(thumbPic, goodsPrice);
				goodsPrice.setTag("1");
				view = new ModelAndView("goodsprice/updateGoodsPrice");
			}

			if (goodsPrice.getPriceIds() != null && !goodsPrice.getPriceIds().equals(""))
				goodsPrice.setPriceIds(goodsPrice.getPriceIds() + "," + goodsPrice.getGoodsPriceId());
			else
				goodsPrice.setPriceIds(goodsPrice.getGoodsPriceId());

			view.addObject("goodsPrice", goodsPrice);
			view.addObject("priceType", priceType);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 商品列表显示价格规格
	 */
	@RequestMapping(params = "method=toDetailForList")
	public void toDetailForList(GoodsPrice goodsPrice, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (goodsPrice.getEntityPage() == null) {
				goodsPrice.setEntityPage(new EntityPage());
			}

			if (goodsPrice.getEntityPage().getSortField() == null || "".equals(goodsPrice.getEntityPage().getSortField())) {
				goodsPrice.getEntityPage().setSortField("t.F_CREATETIME");
				goodsPrice.getEntityPage().setSortOrder("DESC");
			}
			goodsPrice.setDelFlag("0");
			List<GoodsPrice> objGoodsprice = goodsPriceService.queryGoodsPriceList(goodsPrice);
			JSONArray jsonArray = JSONArray.fromObject(objGoodsprice);
			response.getWriter().print(jsonArray.toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 删除Goodsprice
	 */
	@RequestMapping(params = "method=deletePrice")
	public void deletePrice(GoodsPrice goodsPrice, HttpServletRequest request, HttpServletResponse response) {
		try {
			goodsPriceService.deleteGoodsPrice(goodsPrice);
			response.getWriter().print("0");

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 修改Goodsprice
	 */
	@RequestMapping(params = "method=updateVoid")
	public void updateGoodspriceVoid(GoodsPrice goodsPrice, HttpServletRequest request, HttpServletResponse response) {
		try {
			goodsPrice.setDelFlag("0");
			goodsPriceService.updateGoodsPrice(goodsPrice);
			response.getWriter().print("0");
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 详情Goodsprice
	 */
	@RequestMapping(params = "method=toDetail")
	public ModelAndView toDetail(GoodsPrice goodsPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			goodsPrice = goodsPriceService.queryGoodsPriceByPriceId(goodsPrice);

			view = new ModelAndView("goodsprice/detailGoodsPrice");
			view.addObject("goodsPrice", goodsPrice);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 商品列表获取规格
	 * 
	 * @author wzd
	 * @date 2020年6月30日 上午10:12:18
	 * @param goodsPrice
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=toGetGoodsPriceForCommproduct")
	public void toGetGoodsPriceForCommproduct(GoodsPrice goodsPrice, HttpServletRequest request, HttpServletResponse response) {
		try {
			goodsPrice.setDelFlag("0");
			goodsPrice.setPriceType("0");
			List<GoodsPrice> goodsPriceList = goodsPriceService.queryGoodsPriceList(goodsPrice);
			for (int i = 0; i < goodsPriceList.size(); i++) {
				SellPrice sellPrice = new SellPrice();
				sellPrice.setGoodsPriceId(goodsPriceList.get(i).getGoodsPriceId());
				List<SellPrice> sellPriceList = sellPriceService.querySellPriceList(sellPrice);
				goodsPriceList.get(i).setSellPriceList(sellPriceList);
			}
			response.getWriter().print(JSONObject.toJSONString(goodsPriceList));
		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

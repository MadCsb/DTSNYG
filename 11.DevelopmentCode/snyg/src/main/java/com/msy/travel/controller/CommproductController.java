package com.msy.travel.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.Consts;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.SysConsts;
import com.msy.travel.common.UploadFileCom;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Commproduct;
import com.msy.travel.pojo.Company;
import com.msy.travel.pojo.CouponCommproduct;
import com.msy.travel.pojo.GoodsPrice;
import com.msy.travel.pojo.PdcType;
import com.msy.travel.pojo.RsPic;
import com.msy.travel.pojo.SaleType;
import com.msy.travel.pojo.Subject;
import com.msy.travel.pojo.User;
import com.msy.travel.service.CommproductService;
import com.msy.travel.service.CompanyService;
import com.msy.travel.service.CouponCommproductService;
import com.msy.travel.service.GoodsPriceService;
import com.msy.travel.service.IRsPicService;
import com.msy.travel.service.PdcTypeService;
import com.msy.travel.service.SaleTypeService;
import com.msy.travel.service.SubjectService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/commproduct")
public class CommproductController extends BaseController {
	public static final Log log = LogFactory.getLog(CommproductController.class);

	@Resource(name = "commproductServiceImpl")
	private CommproductService commproductService;

	@Resource(name = "companyServiceImpl")
	private CompanyService companyService;

	@Resource(name = "pdcTypeServiceImpl")
	private PdcTypeService pdcTypeService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Resource(name = "rsPicServiceImpl")
	private IRsPicService rsPicService;

	@Resource(name = "goodsPriceServiceImpl")
	private GoodsPriceService goodsPriceService;

	@Resource(name = "subjectServiceImpl")
	private SubjectService subjectService;

	@Resource(name = "saleTypeServiceImpl")
	private SaleTypeService saleTypeService;

	@Resource(name = "couponCommproductServiceImpl")
	private CouponCommproductService couponCommproductService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddCommproduct(Commproduct commproduct, HttpServletRequest request, HttpServletResponse response, String priceType) {
		ModelAndView view = null;
		try {
			String productId = PrimaryKeyUtil.generateKey();

			Company c = new Company();
			c.setDelFlag("0");
			c.setSpId(getLoginUser(request).getAccId());
			List<Company> companyList = companyService.queryCompanyList(c);

			PdcType p = new PdcType();
			p.setDelFlag("0");
			p.setLevel("1");
			List<PdcType> pdcTypeList = pdcTypeService.queryPdcTypeList(p);

			Subject subject = new Subject();
			subject.setSpId(getLoginUser(request).getAccId());
			List<Subject> subjectList = subjectService.querySubjectList(subject);

			view = new ModelAndView("commproduct/addCommproduct");
			view.addObject("productId", productId);
			view.addObject("companyList", companyList);
			view.addObject("pdcTypeList", pdcTypeList);
			view.addObject("subjectList", subjectList);
			view.addObject("rsType", SysConsts.RSTYPE_COMMPRODUCT);
			view.addObject("priceType", priceType);
		} catch (Exception e) {
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增Commproduct
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addCommproduct(Commproduct commproduct, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "upload1", required = false) MultipartFile multipartFile, String[] picIds, String priceType) {
		ModelAndView view = null;
		try {
			// 上传缩略图
			String thumbPic = UploadFileCom.uploadFileByFolder(multipartFile, request, Consts.WX_PIC_FOLDER_NAME, configParameter.getUploadPicUrl());

			commproductService.createCommproduct(thumbPic, picIds, commproduct, getLoginUser(request));
			view = new ModelAndView("success");
			view.addObject("priceType", priceType);
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
	public ModelAndView toUpdateCommproduct(Commproduct commproduct, HttpServletRequest request, HttpServletResponse response, String priceType) {
		ModelAndView view = null;
		try {
			Commproduct objCommproduct = commproductService.displayCommproduct(commproduct);

			Company c = new Company();
			c.setDelFlag("0");
			c.setSpId(getLoginUser(request).getAccId());
			List<Company> companyList = companyService.queryCompanyList(c);

			PdcType p = new PdcType();
			p.setDelFlag("0");
			p.setLevel("1");
			List<PdcType> pdcTypeList = pdcTypeService.queryPdcTypeList(p);

			PdcType sub = new PdcType();
			sub.setDelFlag("0");
			sub.setLevel("2");
			sub.setPpdcTypeId(objCommproduct.getType());
			List<PdcType> subPdcTypeList = pdcTypeService.queryPdcTypeList(sub);

			RsPic rsPic = new RsPic();
			rsPic.setRsId(objCommproduct.getProductId());
			rsPic.setRsType(SysConsts.RSTYPE_COMMPRODUCT);
			if (rsPic.getEntityPage() == null) {
				rsPic.setEntityPage(new EntityPage());
			}
			rsPic.getEntityPage().setSortField("t.F_ORDER");
			rsPic.getEntityPage().setSortOrder("ASC");
			List<RsPic> rsPicList = rsPicService.queryRsPicList(rsPic);

			// 处理价格规格
			// GoodsPrice goodsPrice = new GoodsPrice();
			// goodsPrice.setProductId(commproduct.getProductId());
			// goodsPrice.setPriceType("0");
			// goodsPrice.setDelFlag("0");
			//
			// List<GoodsPrice> goodsPriceList =
			// goodsPriceService.queryGoodsPriceList(goodsPrice);
			// String priceIds = "";
			// if (goodsPriceList != null && goodsPriceList.size() > 0) {
			// for (int i = 0; i < goodsPriceList.size(); i++) {
			// if (priceIds.length() > 0)
			// priceIds += ",";
			// priceIds += goodsPriceList.get(i).getGoodsPriceId();
			// }
			// }
			// objCommproduct.setPriceIds(priceIds);

			Subject subject = new Subject();
			subject.setSpId(getLoginUser(request).getAccId());
			List<Subject> subjectList = subjectService.querySubjectList(subject);

			view = new ModelAndView("commproduct/updateCommproduct");
			view.addObject("commproduct", objCommproduct);
			view.addObject("companyList", companyList);
			view.addObject("pdcTypeList", pdcTypeList);
			view.addObject("rsPicList", rsPicList);
			// view.addObject("goodsPriceList", goodsPriceList);
			view.addObject("subPdcTypeList", subPdcTypeList);
			view.addObject("subjectList", subjectList);
			view.addObject("rsType", SysConsts.RSTYPE_COMMPRODUCT);
			view.addObject("priceType", priceType);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改Commproduct
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateCommproduct(Commproduct commproduct, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "upload1", required = false) MultipartFile multipartFile, String[] picIds, String priceType) {
		ModelAndView view = null;
		try {
			String th = commproduct.getThumbPic();
			if (multipartFile != null && multipartFile.getSize() > 0) {
				th = UploadFileCom.uploadFileByFolder(multipartFile, request, Consts.WX_PIC_FOLDER_NAME, configParameter.getUploadPicUrl());
			}
			commproductService.updateCommproduct(th, picIds, commproduct, getLoginUser(request));
			view = new ModelAndView("success");
			view.addObject("priceType", priceType);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除Commproduct
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteCommproduct(Commproduct commproduct, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			// commproductService.deleteCommproduct(commproduct);
			commproduct = commproductService.displayCommproduct(commproduct);
			commproduct.setDelFlag("1");
			commproductService.updateCommproduct(commproduct);
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
	public ModelAndView deleteBatchCommproduct(Commproduct commproduct, String checkedCommproductIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] commproductIds = checkedCommproductIds.split(",");
		List<String> commproductIdList = new ArrayList<String>();
		Collections.addAll(commproductIdList, commproductIds);
		try {
			commproduct.setCommproductIdList(commproductIdList);
			commproductService.deleteBatchCommproduct(commproduct);
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
	public ModelAndView queryCommproductList(Commproduct commproduct, HttpServletRequest request, HttpServletResponse response, String openFlag, String priceType) {
		ModelAndView view = null;
		try {
			if (commproduct.getEntityPage() == null) {
				commproduct.setEntityPage(new EntityPage());
			}

			commproduct.setDelFlag("0");
			commproduct.setSpId(getLoginUser(request).getAccId());

			if (commproduct.getEntityPage().getSortField() == null || "".equals(commproduct.getEntityPage().getSortField())) {
				commproduct.getEntityPage().setSortField("t.F_UPDATETIME");
				commproduct.getEntityPage().setSortOrder("DESC");
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(commproduct.getEntityPage()), super.getPageSize(commproduct.getEntityPage()));
			List<Commproduct> commproductlist = commproductService.queryCommproductListAndPriceId(commproduct);
			PageInfo<Commproduct> pageInfo = new PageInfo<Commproduct>(commproductlist);

			Company c = new Company();
			c.setDelFlag("0");
			c.setSpId(getLoginUser(request).getAccId());
			List<Company> companyList = companyService.queryCompanyList(c);

			PdcType p = new PdcType();
			p.setDelFlag("0");
			p.setLevel("1");
			List<PdcType> pdcTypeList = pdcTypeService.queryPdcTypeList(p);

			// if (commproductlist != null && commproductlist.size() > 0) {
			// for (int i = 0; i < commproductlist.size(); i++) {
			// GoodsPrice g = new GoodsPrice();
			// g.setProductId(commproductlist.get(i).getProductId());
			// g.setDelFlag("0");
			// g.setPriceType("0");
			// List<GoodsPrice> goodsPriceList =
			// goodsPriceService.queryGoodsPriceList(g);
			// if (goodsPriceList != null && goodsPriceList.size() > 0) {
			// commproductlist.get(i).setPriceId(goodsPriceList.get(0).getPriceId());
			// } else {
			// commproductlist.get(i).setPriceId("");
			// }
			// }
			// }

			view = new ModelAndView("commproduct/queryCommproduct");
			view.addObject("commproductlist", commproductlist);
			view.addObject("entityPage", commproduct.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("companyList", companyList);
			view.addObject("pdcTypeList", pdcTypeList);
			view.addObject("openFlag", openFlag);
			view.addObject("priceType", priceType);
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
	public void exportCommproduct(Commproduct commproduct, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "Commproduct-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (commproduct.getEntityPage() == null) {
				commproduct.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(commproduct.getEntityPage()), super.getPageSize(commproduct.getEntityPage()));
			List<Commproduct> exportlist = commproductService.queryCommproductList(commproduct);

			PoiWriteExcel<Commproduct> pwe = new PoiWriteExcel<Commproduct>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(commproduct.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 跳转到详情页面
	 */
	@RequestMapping(params = "method=toDetail")
	public ModelAndView toDetail(Commproduct commproduct, HttpServletRequest request, HttpServletResponse response, String priceType) {
		ModelAndView view = null;
		try {
			Commproduct objCommproduct = commproductService.displayCommproduct(commproduct);

			Company c = new Company();
			c.setDelFlag("0");
			c.setSpId(getLoginUser(request).getAccId());
			List<Company> companyList = companyService.queryCompanyList(c);

			PdcType p = new PdcType();
			p.setDelFlag("0");
			p.setLevel("1");
			List<PdcType> pdcTypeList = pdcTypeService.queryPdcTypeList(p);

			PdcType sub = new PdcType();
			sub.setDelFlag("0");
			sub.setLevel("2");
			sub.setPpdcTypeId(objCommproduct.getType());
			List<PdcType> subPdcTypeList = pdcTypeService.queryPdcTypeList(sub);

			RsPic rsPic = new RsPic();
			rsPic.setRsId(objCommproduct.getProductId());
			rsPic.setRsType(SysConsts.RSTYPE_COMMPRODUCT);
			if (rsPic.getEntityPage() == null) {
				rsPic.setEntityPage(new EntityPage());
			}
			rsPic.getEntityPage().setSortField("t.F_ORDER");
			rsPic.getEntityPage().setSortOrder("ASC");
			List<RsPic> rsPicList = rsPicService.queryRsPicList(rsPic);

			// 处理价格规格
			GoodsPrice goodsPrice = new GoodsPrice();
			goodsPrice.setProductId(commproduct.getProductId());
			goodsPrice.setPriceType("0");

			List<GoodsPrice> goodsPriceList = goodsPriceService.queryGoodsPriceList(goodsPrice);
			String priceIds = "";
			if (goodsPriceList != null && goodsPriceList.size() > 0) {
				for (int i = 0; i < goodsPriceList.size(); i++) {
					if (priceIds.length() > 0)
						priceIds += ",";
					priceIds += goodsPriceList.get(i).getGoodsPriceId();
				}
			}
			objCommproduct.setPriceIds(priceIds);

			view = new ModelAndView("commproduct/detailCommproduct");
			view.addObject("commproduct", objCommproduct);
			view.addObject("companyList", companyList);
			view.addObject("pdcTypeList", pdcTypeList);
			view.addObject("rsPicList", rsPicList);
			view.addObject("goodsPriceList", goodsPriceList);
			view.addObject("subPdcTypeList", subPdcTypeList);
			view.addObject("rsType", SysConsts.RSTYPE_COMMPRODUCT);
			view.addObject("priceType", priceType);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 商品上架/下架
	 */
	@RequestMapping(params = "method=changeStateCommproduction")
	public void changeStateCommproduction(Commproduct commproduct, HttpServletRequest request, HttpServletResponse response) {
		try {
			commproductService.changeState(commproduct, getLoginUser(request));
			response.getWriter().print("0");
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 查找优惠券
	 * 
	 * @author wzd
	 * @date 2020年3月21日 下午1:27:18
	 * @param commproduct
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=queryForCoupon")
	public ModelAndView queryForCoupon(Commproduct commproduct, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			User u = getLoginUser(request);
			if (commproduct.getEntityPage() == null) {
				commproduct.setEntityPage(new EntityPage());
			}

			if (commproduct.getEntityPage().getSortField() == null || commproduct.getEntityPage().getSortField().equals("")) {

				commproduct.getEntityPage().setSortField("t.F_SORTNUM");
				commproduct.getEntityPage().setSortOrder("ASC");
			}

			commproduct.setDelFlag("0");
			commproduct.setSpId(u.getAccId());

			if (commproduct.getCheckPdc().equals("0")) {
				// 设置分页
				PageHelper.startPage(super.getPageNum(commproduct.getEntityPage()), super.getPageSize(commproduct.getEntityPage()));
				List<Commproduct> productionlist = commproductService.queryCommproductList(commproduct);
				PageInfo<Commproduct> pageInfo = new PageInfo<Commproduct>(productionlist);

				String productionIdList = "";
				if (commproduct.getCommproductIdList() != null && commproduct.getCommproductIdList().size() > 0) {
					for (int i = 0; i < commproduct.getCommproductIdList().size(); i++) {
						if (!productionIdList.equals("")) {
							productionIdList += ",";
						}
						productionIdList += commproduct.getCommproductIdList().get(i);
					}
				}

				CouponCommproduct cc = new CouponCommproduct();
				cc.setCouponId(commproduct.getCouponId());
				List<CouponCommproduct> couponCommproductList = couponCommproductService.queryCouponCommproductList(cc);

				view = new ModelAndView("commproduct/queryCommproductForCoupon");

				view.addObject("productionIdList", productionIdList);
				view.addObject("productionlist", productionlist);
				view.addObject("pageInfo", pageInfo);
				view.addObject("couponCommSize", couponCommproductList == null || couponCommproductList.size() == 0 ? 0 : couponCommproductList.size());
			} else if (commproduct.getCheckPdc().equals("1")) {
				view = new ModelAndView("commproduct/queryCommproductForCouponCheck");

				List<Commproduct> productionlist = new ArrayList<Commproduct>();

				// 设置分页
				PageHelper.startPage(super.getPageNum(commproduct.getEntityPage()), super.getPageSize(commproduct.getEntityPage()));
				productionlist = commproductService.queryCommproductListForCouponCheck(commproduct);

				PageInfo<Commproduct> pageInfo = new PageInfo<Commproduct>(productionlist);
				view.addObject("pageInfo", pageInfo);
				view.addObject("productionlist", productionlist);

			}

			SaleType saleType = new SaleType();
			saleType.setSpId(u.getAccId());
			saleType.setStatus("0");
			saleType.setEntityPage(new EntityPage());
			saleType.getEntityPage().setSortField("t.F_SALETYPEKEY asc");
			List<SaleType> saleTypeList = saleTypeService.querySaleTypeList(saleType);

			view.addObject("entityPage", commproduct.getEntityPage());
			view.addObject("commproduct", commproduct);
			view.addObject("saleTypeList", saleTypeList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}
}

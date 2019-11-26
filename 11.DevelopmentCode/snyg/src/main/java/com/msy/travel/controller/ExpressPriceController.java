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
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.pojo.City;
import com.msy.travel.pojo.ExpressPrice;
import com.msy.travel.service.ExpressPriceService;
import com.msy.travel.service.ICityService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/expressPrice")
public class ExpressPriceController extends BaseController {
	public static final Log log = LogFactory.getLog(ExpressPriceController.class);

	@Resource(name = "expressPriceServiceImpl")
	private ExpressPriceService expressPriceService;

	@Resource(name = "cityServiceImpl")
	private ICityService cityService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddExpressPrice(ExpressPrice expressPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("expressprice/addExpressPrice");
		return view;
	}

	/**
	 * 新增ExpressPrice
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addExpressPrice(ExpressPrice expressPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			expressPriceService.createExpressPrice(expressPrice);
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
	public ModelAndView toUpdateExpressPrice(ExpressPrice expressPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			ExpressPrice objExpressPrice = expressPriceService.displayExpressPrice(expressPrice);
			view = new ModelAndView("expressprice/updateExpressPrice");
			view.addObject("expressPrice", objExpressPrice);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改ExpressPrice
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateExpressPrice(ExpressPrice expressPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			expressPriceService.updateExpressPrice(expressPrice);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除ExpressPrice
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteExpressPrice(ExpressPrice expressPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			expressPriceService.deleteExpressPrice(expressPrice);
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
	public ModelAndView deleteBatchExpressPrice(ExpressPrice expressPrice, String checkedExpressPriceIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] expressPriceIds = checkedExpressPriceIds.split(",");
		List<String> expressPriceIdList = new ArrayList<String>();
		Collections.addAll(expressPriceIdList, expressPriceIds);
		try {
			expressPrice.setExpressPriceIdList(expressPriceIdList);
			expressPriceService.deleteBatchExpressPrice(expressPrice);
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
	public ModelAndView queryExpressPriceList(ExpressPrice expressPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (expressPrice.getEntityPage() == null) {
				expressPrice.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(expressPrice.getEntityPage()), super.getPageSize(expressPrice.getEntityPage()));
			List<ExpressPrice> expressPricelist = expressPriceService.queryExpressPriceList(expressPrice);
			PageInfo<ExpressPrice> pageInfo = new PageInfo<ExpressPrice>(expressPricelist);

			view = new ModelAndView("expressprice/queryExpressPrice");
			view.addObject("expressPricelist", expressPricelist);
			view.addObject("entityPage", expressPrice.getEntityPage());
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
	public void exportExpressPrice(ExpressPrice expressPrice, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "ExpressPrice-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (expressPrice.getEntityPage() == null) {
				expressPrice.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(expressPrice.getEntityPage()), super.getPageSize(expressPrice.getEntityPage()));
			List<ExpressPrice> exportlist = expressPriceService.queryExpressPriceList(expressPrice);

			PoiWriteExcel<ExpressPrice> pwe = new PoiWriteExcel<ExpressPrice>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(expressPrice.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 新增或修改
	 * 
	 * @author wzd
	 * @date 2019年11月25日 下午9:46:42
	 * @param expressPrice
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=toUpdateOrAdd")
	public ModelAndView toUpdateOrAdd(ExpressPrice expressPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			List<ExpressPrice> expressPriceList = expressPriceService.queryExpressPriceListGroup(expressPrice);

			view = new ModelAndView("expressprice/addExpressPrice");
			view.addObject("expressPriceList", expressPriceList);
			view.addObject("expressPrice", expressPrice);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新增或修改打开地区选择
	 * 
	 * @author wzd
	 * @date 2019年11月26日 上午10:02:36
	 * @param expressPrice
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=getCityList")
	public ModelAndView getCityList(ExpressPrice expressPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {

			view = new ModelAndView("expressprice/queryCity");

			// 加载省
			City city = new City();
			city.setCityLevel("1");// 1:省
			city.setForeigh("0");// 0:国内
			EntityPage entityPage = new EntityPage();
			city.setEntityPage(entityPage);
			entityPage.setSortField("t.F_PY");// 按拼音排列
			entityPage.setSortOrder("ASC");
			List<City> provList = cityService.queryCityList(city);

			view.addObject("provList", provList);
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
	 * @date 2019年11月26日 上午11:01:51
	 * @param expressPrice
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=addOrUpdate")
	public ModelAndView addOrUpdate(ExpressPrice expressPrice, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			ExpressPrice oldEP = new ExpressPrice();
			oldEP.setCompanyExpressId(expressPrice.getCompanyExpressId());
			expressPriceService.deleteExpressPrice(oldEP);

			List<ExpressPrice> expressPriceList = expressPrice.getExpressPriceList();
			if (expressPriceList != null && expressPriceList.size() > 0) {
				for (int i = 0; i < expressPriceList.size(); i++) {
					ExpressPrice e = expressPriceList.get(i);
					if (e.getProvinceId() != null && !"".equals(e.getProvinceId())) {
						String[] provinceIds = e.getProvinceId().split(",");
						String[] provinceNames = e.getProvince().split(",");

						String groupNum = PrimaryKeyUtil.generateNumCode();

						for (int j = 0; j < provinceIds.length; j++) {
							ExpressPrice newExpressPrice = new ExpressPrice();
							newExpressPrice.setExpressPriceId(PrimaryKeyUtil.generateKey());
							newExpressPrice.setCompanyExpressId(expressPrice.getCompanyExpressId());
							newExpressPrice.setProvince(provinceNames[j]);
							newExpressPrice.setProvinceId(provinceIds[j]);
							newExpressPrice.setExpressNum(e.getExpressNum());
							newExpressPrice.setExpressPrice(e.getExpressPrice());
							newExpressPrice.setExpressNumAdd(e.getExpressNumAdd());
							newExpressPrice.setExpressPriceAdd(e.getExpressPriceAdd());
							newExpressPrice.setGroupNum(groupNum);
							expressPriceService.createExpressPrice(newExpressPrice);
						}
					}
				}
			}

			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}
}

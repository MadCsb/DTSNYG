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
import com.msy.travel.pojo.Company;
import com.msy.travel.pojo.OrderList;
import com.msy.travel.service.CompanyService;
import com.msy.travel.service.IPubmapService;
import com.msy.travel.service.OrderListService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/orderList")
public class OrderListController extends BaseController {
	public static final Log log = LogFactory.getLog(OrderListController.class);

	@Resource(name = "orderListServiceImpl")
	private OrderListService orderListService;

	@Resource(name = "pubmapServiceImpl")
	private IPubmapService pubmapService;

	@Resource(name = "companyServiceImpl")
	private CompanyService companyService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddOrderList(OrderList orderList, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("orderList/addOrderList");
		return view;
	}

	/**
	 * 新增OrderList
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addOrderList(OrderList orderList, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			orderListService.createOrderList(orderList);
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
	public ModelAndView toUpdateOrderList(OrderList orderList, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			OrderList objOrderList = orderListService.displayOrderList(orderList);
			view = new ModelAndView("orderList/updateOrderList");
			view.addObject("orderList", objOrderList);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改OrderList
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateOrderList(OrderList orderList, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			orderListService.updateOrderList(orderList);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除OrderList
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteOrderList(OrderList orderList, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			orderListService.deleteOrderList(orderList);
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
	public ModelAndView deleteBatchOrderList(OrderList orderList, String checkedOrderListIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] orderListIds = checkedOrderListIds.split(",");
		List<String> orderListIdList = new ArrayList<String>();
		Collections.addAll(orderListIdList, orderListIds);
		try {
			orderList.setOrderListIdList(orderListIdList);
			orderListService.deleteBatchOrderList(orderList);
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
	public ModelAndView queryOrderListList(OrderList orderList, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (orderList.getEntityPage() == null) {
				orderList.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(orderList.getEntityPage()), super.getPageSize(orderList.getEntityPage()));
			List<OrderList> orderListlist = orderListService.queryOrderListList(orderList);
			PageInfo<OrderList> pageInfo = new PageInfo<OrderList>(orderListlist);

			view = new ModelAndView("orderList/queryOrderList");
			view.addObject("orderListlist", orderListlist);
			view.addObject("entityPage", orderList.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("orderList", orderList);
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
	public void exportOrderList(OrderList orderList, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "OrderList-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (orderList.getEntityPage() == null) {
				orderList.setEntityPage(new EntityPage());
			}
			List<OrderList> exportlist = orderListService.queryOrderListList(orderList);

			PoiWriteExcel<OrderList> pwe = new PoiWriteExcel<OrderList>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(orderList.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 账单清单
	 * 
	 * @author wzd
	 * @date 2019年11月17日 下午3:29:13
	 * @param orderList
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=queryOrderListBill")
	public ModelAndView queryOrderListMonth(OrderList orderList, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (orderList.getEntityPage() == null) {
				orderList.setEntityPage(new EntityPage());
			}
			if (orderList.getBillType() == null || "".equals(orderList.getBillType())) {
				orderList.setBillType("month");
			}
			super.saveBackUrl(request);

			// 设置分页
			PageHelper.startPage(super.getPageNum(orderList.getEntityPage()), super.getPageSize(orderList.getEntityPage()));
			List<OrderList> orderListlist = orderListService.queryOrderListBill(orderList);
			PageInfo<OrderList> pageInfo = new PageInfo<OrderList>(orderListlist);

			Company c = new Company();
			c.setDelFlag("0");
			c.setSpId(getLoginUser(request).getAccId());
			List<Company> companyList = companyService.queryCompanyList(c);

			if ("month".equals(orderList.getBillType())) {
				view = new ModelAndView("orderList/queryOrderListMonth");
			} else if ("day".equals(orderList.getBillType())) {
				view = new ModelAndView("orderList/queryOrderListDay");
			}
			OrderList orderListSum = orderListService.queryOrderListBillSum(orderList);

			view.addObject("orderListlist", orderListlist);
			view.addObject("entityPage", orderList.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("orderList", orderList);
			view.addObject("companyList", companyList);
			view.addObject("orderListSum", orderListSum);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 账单清单明细
	 * 
	 * @author wzd
	 * @date 2019年11月18日 下午6:45:57
	 * @param orderList
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=queryOrderListDetailList")
	public ModelAndView queryOrderListDetailList(OrderList orderList, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (orderList.getEntityPage() == null) {
				orderList.setEntityPage(new EntityPage());
			}
			orderList.setPayTag("1");

			if (orderList.getBillType() != null && !"".equals(orderList.getBillType())) {
				if ("month".equals(orderList.getBillType())) {
					if (orderList.getPayDateTimeStart() != null && !"".equals(orderList.getPayDateTimeStart())) {
						orderList.setPayDateTimeStart(orderList.getPayDateTimeStart() + "-01");
						orderList.setPayDateTimeEnd(DateTimeUtil.addMonthEnd(orderList.getPayDateTimeStart() + "-01", "0"));
					}
				}

			}

			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(orderList.getEntityPage()), super.getPageSize(orderList.getEntityPage()));
			List<OrderList> orderListlist = orderListService.queryOrderListDetailList(orderList);
			PageInfo<OrderList> pageInfo = new PageInfo<OrderList>(orderListlist);

			Company c = new Company();
			c.setDelFlag("0");
			c.setSpId(getLoginUser(request).getAccId());
			List<Company> companyList = companyService.queryCompanyList(c);

			view = new ModelAndView("orderList/queryOrderListDetailList");
			view.addObject("orderListlist", orderListlist);
			view.addObject("entityPage", orderList.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("orderList", orderList);
			view.addObject("companyList", companyList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 账单清单导出
	 * 
	 * @author wzd
	 * @date 2019年11月19日 下午1:31:44
	 * @param orderList
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=queryOrderListBillExport")
	public void queryOrderListBillExport(OrderList orderList, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			path = path + File.separator + "export";
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "账单清单-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (orderList.getBillType() == null || "".equals(orderList.getBillType())) {
				orderList.setBillType("month");
			}

			OrderList orderListSum = orderListService.queryOrderListBillSum(orderList);
			orderListSum.setPayDateTime("合计");

			List<OrderList> exportlist = orderListService.queryOrderListBill(orderList);
			exportlist.add(orderListSum);

			PoiWriteExcel<OrderList> pwe = new PoiWriteExcel<OrderList>();

			// 设置标题
			pwe.setFileTitle("账单清单");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(orderList.EXPORT_HEADERS_DAY);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 账单明细导出
	 * 
	 * @author wzd
	 * @date 2019年11月20日 上午10:46:02
	 * @param orderList
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=queryOrderListDetailListExport")
	public void queryOrderListDetailListExport(OrderList orderList, HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext().getRealPath("");
			path = path + File.separator + "export";
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "账单明细-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;
			orderList.setPayTag("1");

			List<OrderList> exportlist = orderListService.queryOrderListDetailList(orderList);
			if (exportlist != null && exportlist.size() > 0) {
				for (int i = 0; i < exportlist.size(); i++) {
					if ("0".equals(exportlist.get(i).getOrderListType())) {
						exportlist.get(i).setOrderListType("订单");
					} else if ("1".equals(exportlist.get(i).getOrderListType())) {
						exportlist.get(i).setOrderListType("退订单");
					} else if ("2".equals(exportlist.get(i).getOrderListType())) {
						exportlist.get(i).setOrderListType("赠品单");
					}
				}
			}

			PoiWriteExcel<OrderList> pwe = new PoiWriteExcel<OrderList>();

			// 设置标题
			pwe.setFileTitle("账单明细");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(orderList.EXPORT_HEADERS_DETAILLIST);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

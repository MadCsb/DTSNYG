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
import com.msy.travel.pojo.OrderCustomer;
import com.msy.travel.service.OrderCustomerService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/orderCustomer")
public class OrderCustomerController extends BaseController {
	public static final Log log = LogFactory.getLog(OrderCustomerController.class);

	@Resource(name = "orderCustomerServiceImpl")
	private OrderCustomerService orderCustomerService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddOrderCustomer(OrderCustomer orderCustomer, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("orderCustomer/addOrderCustomer");
		return view;
	}

	/**
	 * 新增OrderCustomer
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addOrderCustomer(OrderCustomer orderCustomer, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			orderCustomerService.createOrderCustomer(orderCustomer);
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
	public ModelAndView toUpdateOrderCustomer(OrderCustomer orderCustomer, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			OrderCustomer objOrderCustomer = orderCustomerService.displayOrderCustomer(orderCustomer);
			view = new ModelAndView("orderCustomer/updateOrderCustomer");
			view.addObject("orderCustomer", objOrderCustomer);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改OrderCustomer
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateOrderCustomer(OrderCustomer orderCustomer, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			orderCustomerService.updateOrderCustomer(orderCustomer);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除OrderCustomer
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteOrderCustomer(OrderCustomer orderCustomer, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			orderCustomerService.deleteOrderCustomer(orderCustomer);
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
	public ModelAndView deleteBatchOrderCustomer(OrderCustomer orderCustomer, String checkedOrderCustomerIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] orderCustomerIds = checkedOrderCustomerIds.split(",");
		List<String> orderCustomerIdList = new ArrayList<String>();
		Collections.addAll(orderCustomerIdList, orderCustomerIds);
		try {
			orderCustomer.setOrderCustomerIdList(orderCustomerIdList);
			orderCustomerService.deleteBatchOrderCustomer(orderCustomer);
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
	public ModelAndView queryOrderCustomerList(OrderCustomer orderCustomer, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (orderCustomer.getEntityPage() == null) {
				orderCustomer.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(orderCustomer.getEntityPage()), super.getPageSize(orderCustomer.getEntityPage()));
			List<OrderCustomer> orderCustomerlist = orderCustomerService.queryOrderCustomerList(orderCustomer);
			PageInfo<OrderCustomer> pageInfo = new PageInfo<OrderCustomer>(orderCustomerlist);

			view = new ModelAndView("orderCustomer/queryOrderCustomer");
			view.addObject("orderCustomerlist", orderCustomerlist);
			view.addObject("entityPage", orderCustomer.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("orderCustomer", orderCustomer);
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
	public void exportOrderCustomer(OrderCustomer orderCustomer, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "OrderCustomer-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (orderCustomer.getEntityPage() == null) {
				orderCustomer.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(orderCustomer.getEntityPage()), super.getPageSize(orderCustomer.getEntityPage()));
			List<OrderCustomer> exportlist = orderCustomerService.queryOrderCustomerList(orderCustomer);

			PoiWriteExcel<OrderCustomer> pwe = new PoiWriteExcel<OrderCustomer>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(orderCustomer.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

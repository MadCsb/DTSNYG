package com.msy.travel.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.pojo.User;

import com.msy.travel.common.BaseController;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.pojo.OrderExpress;
import com.msy.travel.service.OrderExpressService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/orderExpress")
public class OrderExpressController extends BaseController{
	public static final Log log = LogFactory.getLog(OrderExpressController.class);

	@Resource(name = "orderExpressServiceImpl")	
	private OrderExpressService orderExpressService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddOrderExpress(OrderExpress orderExpress,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			view = new ModelAndView("orderExpress/addOrderExpress");
			return view;
		}
	/**
	 * 新增OrderExpress
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addOrderExpress(OrderExpress orderExpress,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
	        		orderExpressService.createOrderExpress(orderExpress);
	        		view = new ModelAndView("success");
	        	
				} catch (Exception  e){
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
	public ModelAndView toUpdateOrderExpress(OrderExpress orderExpress,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
					OrderExpress  objOrderExpress=
					orderExpressService.displayOrderExpress(orderExpress);
					view = new ModelAndView("orderExpress/updateOrderExpress");
					view.addObject("orderExpress", objOrderExpress);	
				
				} catch (Exception e) {
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}
			return view;
		}	
	/**
	 * 修改OrderExpress
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateOrderExpress(OrderExpress orderExpress,HttpServletRequest request,HttpServletResponse response)   {
			ModelAndView view = null;
			try {
					orderExpressService.updateOrderExpress(orderExpress);
					view = new ModelAndView("success");
				
				}catch (Exception e) {	
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}		
			return view; 
		}
	/**
	 * 删除OrderExpress
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteOrderExpress(OrderExpress orderExpress,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try{
	        		orderExpressService.deleteOrderExpress(orderExpress);
	        		view = new ModelAndView("success");
				
				}catch (Exception  e){
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
	public ModelAndView deleteBatchOrderExpress(OrderExpress orderExpress,String checkedOrderExpressIds,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			String[] orderExpressIds= checkedOrderExpressIds.split(",");
			List<String> orderExpressIdList =new ArrayList<String>();
			Collections.addAll(orderExpressIdList, orderExpressIds);
			try{
					orderExpress.setOrderExpressIdList(orderExpressIdList);
					orderExpressService.deleteBatchOrderExpress(orderExpress);
					view = new ModelAndView("success");
	        	
				}catch (Exception  e){
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
	public ModelAndView queryOrderExpressList(OrderExpress orderExpress,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try {
				 if(orderExpress.getEntityPage()==null){
					 orderExpress.setEntityPage(new EntityPage());
		         }
				 super.saveBackUrl(request);
	        	// 设置分页
	        	PageHelper.startPage(super.getPageNum(orderExpress.getEntityPage()), super.getPageSize(orderExpress.getEntityPage()));
	        	List<OrderExpress>  orderExpresslist = 
		        			orderExpressService.queryOrderExpressList(orderExpress);
	        	PageInfo<OrderExpress> pageInfo = new PageInfo<OrderExpress>(orderExpresslist);

	        	view = new ModelAndView("orderExpress/queryOrderExpress");
				view.addObject("orderExpresslist", orderExpresslist);
				view.addObject("entityPage", orderExpress.getEntityPage());
				view.addObject("pageInfo", pageInfo);
				view.addObject("orderExpress", orderExpress);	
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
	public void exportOrderExpress(OrderExpress orderExpress,HttpServletRequest request,HttpServletResponse response)  {
			
			try {
				 String path = request.getSession().getServletContext().getRealPath("");
				 File fileFolder = new File(path);
				 if (!fileFolder.isDirectory()) {
					fileFolder.mkdir();
				 }
				 String tempName = "OrderExpress-" + DateTimeUtil.getDateTime14() + ".xls";
				 path = path + File.separator + tempName;

				 if(orderExpress.getEntityPage()==null){
					 orderExpress.setEntityPage(new EntityPage());
		         }
				// 设置分页
		        PageHelper.startPage(super.getPageNum(orderExpress.getEntityPage()), super.getPageSize(orderExpress.getEntityPage()));
		        List<OrderExpress>  exportlist = 
	        			orderExpressService.queryOrderExpressList(orderExpress);

	        	 PoiWriteExcel<OrderExpress> pwe = new PoiWriteExcel<OrderExpress>();

	        	 //设置标题
	             pwe.setFileTitle("");
	             //设置生成文件路径
	             pwe.setExportFileName(path);
	            
	             pwe.setHeaders(orderExpress.EXPORT_HEADERS);
	            
	             pwe.setDataset(exportlist);
	            
	             if (pwe.export())
	             {
	            	 downloadFile(request, response, path, tempName);
	             }
	        	
				 } catch (Exception e) {
					 log.error(e, e);
				}
	}
	
}

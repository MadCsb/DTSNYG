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
import com.msy.travel.pojo.OrderLog;
import com.msy.travel.service.OrderLogService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/orderLog")
public class OrderLogController extends BaseController{
	public static final Log log = LogFactory.getLog(OrderLogController.class);

	@Resource(name = "orderLogServiceImpl")	
	private OrderLogService orderLogService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddOrderLog(OrderLog orderLog,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			view = new ModelAndView("orderLog/addOrderLog");
			return view;
		}
	/**
	 * 新增OrderLog
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addOrderLog(OrderLog orderLog,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
	        		orderLogService.createOrderLog(orderLog);
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
	public ModelAndView toUpdateOrderLog(OrderLog orderLog,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
					OrderLog  objOrderLog=
					orderLogService.displayOrderLog(orderLog);
					view = new ModelAndView("orderLog/updateOrderLog");
					view.addObject("orderLog", objOrderLog);	
				
				} catch (Exception e) {
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}
			return view;
		}	
	/**
	 * 修改OrderLog
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateOrderLog(OrderLog orderLog,HttpServletRequest request,HttpServletResponse response)   {
			ModelAndView view = null;
			try {
					orderLogService.updateOrderLog(orderLog);
					view = new ModelAndView("success");
				
				}catch (Exception e) {	
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}		
			return view; 
		}
	/**
	 * 删除OrderLog
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteOrderLog(OrderLog orderLog,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try{
	        		orderLogService.deleteOrderLog(orderLog);
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
	public ModelAndView deleteBatchOrderLog(OrderLog orderLog,String checkedOrderLogIds,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			String[] orderLogIds= checkedOrderLogIds.split(",");
			List<String> orderLogIdList =new ArrayList<String>();
			Collections.addAll(orderLogIdList, orderLogIds);
			try{
					orderLog.setOrderLogIdList(orderLogIdList);
					orderLogService.deleteBatchOrderLog(orderLog);
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
	public ModelAndView queryOrderLogList(OrderLog orderLog,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try {
				 if(orderLog.getEntityPage()==null){
					 orderLog.setEntityPage(new EntityPage());
		         }
				 super.saveBackUrl(request);
	        	// 设置分页
	        	PageHelper.startPage(super.getPageNum(orderLog.getEntityPage()), super.getPageSize(orderLog.getEntityPage()));
	        	List<OrderLog>  orderLoglist = 
		        			orderLogService.queryOrderLogList(orderLog);
	        	PageInfo<OrderLog> pageInfo = new PageInfo<OrderLog>(orderLoglist);

	        	view = new ModelAndView("orderLog/queryOrderLog");
				view.addObject("orderLoglist", orderLoglist);
				view.addObject("entityPage", orderLog.getEntityPage());
				view.addObject("pageInfo", pageInfo);
				view.addObject("orderLog", orderLog);	
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
	public void exportOrderLog(OrderLog orderLog,HttpServletRequest request,HttpServletResponse response)  {
			
			try {
				 String path = request.getSession().getServletContext().getRealPath("");
				 File fileFolder = new File(path);
				 if (!fileFolder.isDirectory()) {
					fileFolder.mkdir();
				 }
				 String tempName = "OrderLog-" + DateTimeUtil.getDateTime14() + ".xls";
				 path = path + File.separator + tempName;

				 if(orderLog.getEntityPage()==null){
					 orderLog.setEntityPage(new EntityPage());
		         }
				// 设置分页
		        PageHelper.startPage(super.getPageNum(orderLog.getEntityPage()), super.getPageSize(orderLog.getEntityPage()));
		        List<OrderLog>  exportlist = 
	        			orderLogService.queryOrderLogList(orderLog);

	        	 PoiWriteExcel<OrderLog> pwe = new PoiWriteExcel<OrderLog>();

	        	 //设置标题
	             pwe.setFileTitle("");
	             //设置生成文件路径
	             pwe.setExportFileName(path);
	            
	             pwe.setHeaders(orderLog.EXPORT_HEADERS);
	            
	             pwe.setDataset(exportlist);
	            
	             if (pwe.export())
	             {
	            	 downloadFile(request, response, path, tempName);
	             }
	        	
				 } catch (Exception e) {
					 log.error(e, e);
				}
	}


	/**
	 * 查询全部
	 */
	@RequestMapping(params = "method=queryAll")
	public ModelAndView queryOrderLogListAll(OrderLog orderLog, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			orderLog.setEntityPage(new EntityPage());
			orderLog.getEntityPage().setSortField("t.F_OPTIME");
			orderLog.getEntityPage().setSortOrder("ASC");
			List<OrderLog> orderLoglist = orderLogService.queryOrderLogList(orderLog);

			view = new ModelAndView("orderLog/queryOrderLogForList");
			view.addObject("orderLoglist", orderLoglist);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}
}

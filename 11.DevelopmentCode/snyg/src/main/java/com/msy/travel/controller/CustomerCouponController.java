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
import com.msy.travel.pojo.CustomerCoupon;
import com.msy.travel.service.CustomerCouponService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/customerCoupon")
public class CustomerCouponController extends BaseController{
	public static final Log log = LogFactory.getLog(CustomerCouponController.class);

	@Resource(name = "customerCouponServiceImpl")	
	private CustomerCouponService customerCouponService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddCustomerCoupon(CustomerCoupon customerCoupon,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			view = new ModelAndView("CustomerCoupon/addCustomerCoupon");
			return view;
		}
	/**
	 * 新增CustomerCoupon
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addCustomerCoupon(CustomerCoupon customerCoupon,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
	        		customerCouponService.createCustomerCoupon(customerCoupon);
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
	public ModelAndView toUpdateCustomerCoupon(CustomerCoupon customerCoupon,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
					CustomerCoupon  objCustomerCoupon=
					customerCouponService.displayCustomerCoupon(customerCoupon);
					view = new ModelAndView("CustomerCoupon/updateCustomerCoupon");
					view.addObject("customerCoupon", objCustomerCoupon);	
				
				} catch (Exception e) {
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}
			return view;
		}	
	/**
	 * 修改CustomerCoupon
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateCustomerCoupon(CustomerCoupon customerCoupon,HttpServletRequest request,HttpServletResponse response)   {
			ModelAndView view = null;
			try {
					customerCouponService.updateCustomerCoupon(customerCoupon);
					view = new ModelAndView("success");
				
				}catch (Exception e) {	
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}		
			return view; 
		}
	/**
	 * 删除CustomerCoupon
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteCustomerCoupon(CustomerCoupon customerCoupon,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try{
	        		customerCouponService.deleteCustomerCoupon(customerCoupon);
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
	public ModelAndView deleteBatchCustomerCoupon(CustomerCoupon customerCoupon,String checkedCustomerCouponIds,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			String[] customerCouponIds= checkedCustomerCouponIds.split(",");
			List<String> customerCouponIdList =new ArrayList<String>();
			Collections.addAll(customerCouponIdList, customerCouponIds);
			try{
					customerCoupon.setCustomerCouponIdList(customerCouponIdList);
					customerCouponService.deleteBatchCustomerCoupon(customerCoupon);
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
	public ModelAndView queryCustomerCouponList(CustomerCoupon customerCoupon,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try {
				 if(customerCoupon.getEntityPage()==null){
					 customerCoupon.setEntityPage(new EntityPage());
		         }
				 super.saveBackUrl(request);
	        	// 设置分页
	        	PageHelper.startPage(super.getPageNum(customerCoupon.getEntityPage()), super.getPageSize(customerCoupon.getEntityPage()));
	        	List<CustomerCoupon>  customerCouponlist = 
		        			customerCouponService.queryCustomerCouponList(customerCoupon);
	        	PageInfo<CustomerCoupon> pageInfo = new PageInfo<CustomerCoupon>(customerCouponlist);

	        	view = new ModelAndView("CustomerCoupon/queryCustomerCoupon");
				view.addObject("customerCouponlist", customerCouponlist);
				view.addObject("entityPage", customerCoupon.getEntityPage());
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
	public void exportCustomerCoupon(CustomerCoupon customerCoupon,HttpServletRequest request,HttpServletResponse response)  {
			
			try {
				 String path = request.getSession().getServletContext().getRealPath("");
				 File fileFolder = new File(path);
				 if (!fileFolder.isDirectory()) {
					fileFolder.mkdir();
				 }
				 String tempName = "CustomerCoupon-" + DateTimeUtil.getDateTime14() + ".xls";
				 path = path + File.separator + tempName;

				 if(customerCoupon.getEntityPage()==null){
					 customerCoupon.setEntityPage(new EntityPage());
		         }
				// 设置分页
		        PageHelper.startPage(super.getPageNum(customerCoupon.getEntityPage()), super.getPageSize(customerCoupon.getEntityPage()));
		        List<CustomerCoupon>  exportlist = 
	        			customerCouponService.queryCustomerCouponList(customerCoupon);

	        	 PoiWriteExcel<CustomerCoupon> pwe = new PoiWriteExcel<CustomerCoupon>();

	        	 //设置标题
	             pwe.setFileTitle("");
	             //设置生成文件路径
	             pwe.setExportFileName(path);
	            
	             pwe.setHeaders(customerCoupon.EXPORT_HEADERS);
	            
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

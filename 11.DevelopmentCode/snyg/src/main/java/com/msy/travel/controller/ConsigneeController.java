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
import com.msy.travel.pojo.Consignee;
import com.msy.travel.service.ConsigneeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/consignee")
public class ConsigneeController extends BaseController{
	public static final Log log = LogFactory.getLog(ConsigneeController.class);

	@Resource(name = "consigneeServiceImpl")	
	private ConsigneeService consigneeService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddConsignee(Consignee consignee,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			view = new ModelAndView("consignee/addConsignee");
			return view;
		}
	/**
	 * 新增Consignee
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addConsignee(Consignee consignee,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
	        		consigneeService.createConsignee(consignee);
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
	public ModelAndView toUpdateConsignee(Consignee consignee,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
					Consignee  objConsignee=
					consigneeService.displayConsignee(consignee);
					view = new ModelAndView("consignee/updateConsignee");
					view.addObject("consignee", objConsignee);	
				
				} catch (Exception e) {
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}
			return view;
		}	
	/**
	 * 修改Consignee
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateConsignee(Consignee consignee,HttpServletRequest request,HttpServletResponse response)   {
			ModelAndView view = null;
			try {
					consigneeService.updateConsignee(consignee);
					view = new ModelAndView("success");
				
				}catch (Exception e) {	
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}		
			return view; 
		}
	/**
	 * 删除Consignee
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteConsignee(Consignee consignee,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try{
	        		consigneeService.deleteConsignee(consignee);
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
	public ModelAndView deleteBatchConsignee(Consignee consignee,String checkedConsigneeIds,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			String[] consigneeIds= checkedConsigneeIds.split(",");
			List<String> consigneeIdList =new ArrayList<String>();
			Collections.addAll(consigneeIdList, consigneeIds);
			try{
					consignee.setConsigneeIdList(consigneeIdList);
					consigneeService.deleteBatchConsignee(consignee);
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
	public ModelAndView queryConsigneeList(Consignee consignee,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try {
				 if(consignee.getEntityPage()==null){
					 consignee.setEntityPage(new EntityPage());
		         }
				 super.saveBackUrl(request);
	        	// 设置分页
	        	PageHelper.startPage(super.getPageNum(consignee.getEntityPage()), super.getPageSize(consignee.getEntityPage()));
	        	List<Consignee>  consigneelist = 
		        			consigneeService.queryConsigneeList(consignee);
	        	PageInfo<Consignee> pageInfo = new PageInfo<Consignee>(consigneelist);

	        	view = new ModelAndView("consignee/queryConsignee");
				view.addObject("consigneelist", consigneelist);
				view.addObject("entityPage", consignee.getEntityPage());
				view.addObject("pageInfo", pageInfo);
				view.addObject("consignee", consignee);	
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
	public void exportConsignee(Consignee consignee,HttpServletRequest request,HttpServletResponse response)  {
			
			try {
				 String path = request.getSession().getServletContext().getRealPath("");
				 File fileFolder = new File(path);
				 if (!fileFolder.isDirectory()) {
					fileFolder.mkdir();
				 }
				 String tempName = "Consignee-" + DateTimeUtil.getDateTime14() + ".xls";
				 path = path + File.separator + tempName;

				 if(consignee.getEntityPage()==null){
					 consignee.setEntityPage(new EntityPage());
		         }
				// 设置分页
		        PageHelper.startPage(super.getPageNum(consignee.getEntityPage()), super.getPageSize(consignee.getEntityPage()));
		        List<Consignee>  exportlist = 
	        			consigneeService.queryConsigneeList(consignee);

	        	 PoiWriteExcel<Consignee> pwe = new PoiWriteExcel<Consignee>();

	        	 //设置标题
	             pwe.setFileTitle("");
	             //设置生成文件路径
	             pwe.setExportFileName(path);
	            
	             pwe.setHeaders(consignee.EXPORT_HEADERS);
	            
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

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
import com.msy.travel.pojo.Price1Ref;
import com.msy.travel.service.Price1RefService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/price1Ref")
public class Price1RefController extends BaseController{
	public static final Log log = LogFactory.getLog(Price1RefController.class);

	@Resource(name = "price1RefServiceImpl")	
	private Price1RefService price1RefService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddPrice1Ref(Price1Ref price1Ref,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			view = new ModelAndView("price1Ref/addPrice1Ref");
			return view;
		}
	/**
	 * 新增Price1Ref
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addPrice1Ref(Price1Ref price1Ref,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
	        		price1RefService.createPrice1Ref(price1Ref);
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
	public ModelAndView toUpdatePrice1Ref(Price1Ref price1Ref,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
					Price1Ref  objPrice1Ref=
					price1RefService.displayPrice1Ref(price1Ref);
					view = new ModelAndView("price1Ref/updatePrice1Ref");
					view.addObject("price1Ref", objPrice1Ref);	
				
				} catch (Exception e) {
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}
			return view;
		}	
	/**
	 * 修改Price1Ref
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updatePrice1Ref(Price1Ref price1Ref,HttpServletRequest request,HttpServletResponse response)   {
			ModelAndView view = null;
			try {
					price1RefService.updatePrice1Ref(price1Ref);
					view = new ModelAndView("success");
				
				}catch (Exception e) {	
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}		
			return view; 
		}
	/**
	 * 删除Price1Ref
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deletePrice1Ref(Price1Ref price1Ref,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try{
	        		price1RefService.deletePrice1Ref(price1Ref);
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
	public ModelAndView deleteBatchPrice1Ref(Price1Ref price1Ref,String checkedPrice1RefIds,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			String[] price1RefIds= checkedPrice1RefIds.split(",");
			List<String> price1RefIdList =new ArrayList<String>();
			Collections.addAll(price1RefIdList, price1RefIds);
			try{
					price1Ref.setPrice1RefIdList(price1RefIdList);
					price1RefService.deleteBatchPrice1Ref(price1Ref);
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
	public ModelAndView queryPrice1RefList(Price1Ref price1Ref,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try {
				 if(price1Ref.getEntityPage()==null){
					 price1Ref.setEntityPage(new EntityPage());
		         }
				 super.saveBackUrl(request);
	        	// 设置分页
	        	PageHelper.startPage(super.getPageNum(price1Ref.getEntityPage()), super.getPageSize(price1Ref.getEntityPage()));
	        	List<Price1Ref>  price1Reflist = 
		        			price1RefService.queryPrice1RefList(price1Ref);
	        	PageInfo<Price1Ref> pageInfo = new PageInfo<Price1Ref>(price1Reflist);

	        	view = new ModelAndView("price1Ref/queryPrice1Ref");
				view.addObject("price1Reflist", price1Reflist);
				view.addObject("entityPage", price1Ref.getEntityPage());
				view.addObject("pageInfo", pageInfo);
				view.addObject("price1Ref", price1Ref);	
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
	public void exportPrice1Ref(Price1Ref price1Ref,HttpServletRequest request,HttpServletResponse response)  {
			
			try {
				 String path = request.getSession().getServletContext().getRealPath("");
				 File fileFolder = new File(path);
				 if (!fileFolder.isDirectory()) {
					fileFolder.mkdir();
				 }
				 String tempName = "Price1Ref-" + DateTimeUtil.getDateTime14() + ".xls";
				 path = path + File.separator + tempName;

				 if(price1Ref.getEntityPage()==null){
					 price1Ref.setEntityPage(new EntityPage());
		         }
				// 设置分页
		        PageHelper.startPage(super.getPageNum(price1Ref.getEntityPage()), super.getPageSize(price1Ref.getEntityPage()));
		        List<Price1Ref>  exportlist = 
	        			price1RefService.queryPrice1RefList(price1Ref);

	        	 PoiWriteExcel<Price1Ref> pwe = new PoiWriteExcel<Price1Ref>();

	        	 //设置标题
	             pwe.setFileTitle("");
	             //设置生成文件路径
	             pwe.setExportFileName(path);
	            
	             pwe.setHeaders(price1Ref.EXPORT_HEADERS);
	            
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

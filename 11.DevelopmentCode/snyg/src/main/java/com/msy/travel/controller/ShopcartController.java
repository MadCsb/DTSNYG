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
import com.msy.travel.pojo.Shopcart;
import com.msy.travel.service.ShopcartService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/shopcart")
public class ShopcartController extends BaseController{
	public static final Log log = LogFactory.getLog(ShopcartController.class);

	@Resource(name = "shopcartServiceImpl")	
	private ShopcartService shopcartService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddShopcart(Shopcart shopcart,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			view = new ModelAndView("Shopcart/addShopcart");
			return view;
		}
	/**
	 * 新增Shopcart
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addShopcart(Shopcart shopcart,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
	        		shopcartService.createShopcart(shopcart);
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
	public ModelAndView toUpdateShopcart(Shopcart shopcart,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
					Shopcart  objShopcart=
					shopcartService.displayShopcart(shopcart);
					view = new ModelAndView("Shopcart/updateShopcart");
					view.addObject("shopcart", objShopcart);	
				
				} catch (Exception e) {
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}
			return view;
		}	
	/**
	 * 修改Shopcart
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateShopcart(Shopcart shopcart,HttpServletRequest request,HttpServletResponse response)   {
			ModelAndView view = null;
			try {
					shopcartService.updateShopcart(shopcart);
					view = new ModelAndView("success");
				
				}catch (Exception e) {	
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}		
			return view; 
		}
	/**
	 * 删除Shopcart
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteShopcart(Shopcart shopcart,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try{
	        		shopcartService.deleteShopcart(shopcart);
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
	public ModelAndView deleteBatchShopcart(Shopcart shopcart,String checkedShopcartIds,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			String[] shopcartIds= checkedShopcartIds.split(",");
			List<String> shopcartIdList =new ArrayList<String>();
			Collections.addAll(shopcartIdList, shopcartIds);
			try{
					shopcart.setShopcartIdList(shopcartIdList);
					shopcartService.deleteBatchShopcart(shopcart);
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
	public ModelAndView queryShopcartList(Shopcart shopcart,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try {
				 if(shopcart.getEntityPage()==null){
					 shopcart.setEntityPage(new EntityPage());
		         }
				 super.saveBackUrl(request);
	        	// 设置分页
	        	PageHelper.startPage(super.getPageNum(shopcart.getEntityPage()), super.getPageSize(shopcart.getEntityPage()));
	        	List<Shopcart>  shopcartlist = 
		        			shopcartService.queryShopcartList(shopcart);
	        	PageInfo<Shopcart> pageInfo = new PageInfo<Shopcart>(shopcartlist);

	        	view = new ModelAndView("Shopcart/queryShopcart");
				view.addObject("shopcartlist", shopcartlist);
				view.addObject("entityPage", shopcart.getEntityPage());
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
	public void exportShopcart(Shopcart shopcart,HttpServletRequest request,HttpServletResponse response)  {
			
			try {
				 String path = request.getSession().getServletContext().getRealPath("");
				 File fileFolder = new File(path);
				 if (!fileFolder.isDirectory()) {
					fileFolder.mkdir();
				 }
				 String tempName = "Shopcart-" + DateTimeUtil.getDateTime14() + ".xls";
				 path = path + File.separator + tempName;

				 if(shopcart.getEntityPage()==null){
					 shopcart.setEntityPage(new EntityPage());
		         }
				// 设置分页
		        PageHelper.startPage(super.getPageNum(shopcart.getEntityPage()), super.getPageSize(shopcart.getEntityPage()));
		        List<Shopcart>  exportlist = 
	        			shopcartService.queryShopcartList(shopcart);

	        	 PoiWriteExcel<Shopcart> pwe = new PoiWriteExcel<Shopcart>();

	        	 //设置标题
	             pwe.setFileTitle("");
	             //设置生成文件路径
	             pwe.setExportFileName(path);
	            
	             pwe.setHeaders(shopcart.EXPORT_HEADERS);
	            
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

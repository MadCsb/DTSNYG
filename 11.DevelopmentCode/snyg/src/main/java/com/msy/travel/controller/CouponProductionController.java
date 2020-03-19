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
import com.msy.travel.pojo.CouponProduction;
import com.msy.travel.service.CouponProductionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/couponProduction")
public class CouponProductionController extends BaseController{
	public static final Log log = LogFactory.getLog(CouponProductionController.class);

	@Resource(name = "couponProductionServiceImpl")	
	private CouponProductionService couponProductionService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddCouponProduction(CouponProduction couponProduction,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			view = new ModelAndView("CouponProduction/addCouponProduction");
			return view;
		}
	/**
	 * 新增CouponProduction
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addCouponProduction(CouponProduction couponProduction,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
	        		couponProductionService.createCouponProduction(couponProduction);
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
	public ModelAndView toUpdateCouponProduction(CouponProduction couponProduction,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
					CouponProduction  objCouponProduction=
					couponProductionService.displayCouponProduction(couponProduction);
					view = new ModelAndView("CouponProduction/updateCouponProduction");
					view.addObject("couponProduction", objCouponProduction);	
				
				} catch (Exception e) {
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}
			return view;
		}	
	/**
	 * 修改CouponProduction
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateCouponProduction(CouponProduction couponProduction,HttpServletRequest request,HttpServletResponse response)   {
			ModelAndView view = null;
			try {
					couponProductionService.updateCouponProduction(couponProduction);
					view = new ModelAndView("success");
				
				}catch (Exception e) {	
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}		
			return view; 
		}
	/**
	 * 删除CouponProduction
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteCouponProduction(CouponProduction couponProduction,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try{
	        		couponProductionService.deleteCouponProduction(couponProduction);
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
	public ModelAndView deleteBatchCouponProduction(CouponProduction couponProduction,String checkedCouponProductionIds,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			String[] couponProductionIds= checkedCouponProductionIds.split(",");
			List<String> couponProductionIdList =new ArrayList<String>();
			Collections.addAll(couponProductionIdList, couponProductionIds);
			try{
					couponProduction.setCouponProductionIdList(couponProductionIdList);
					couponProductionService.deleteBatchCouponProduction(couponProduction);
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
	public ModelAndView queryCouponProductionList(CouponProduction couponProduction,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try {
				 if(couponProduction.getEntityPage()==null){
					 couponProduction.setEntityPage(new EntityPage());
		         }
				 super.saveBackUrl(request);
	        	// 设置分页
	        	PageHelper.startPage(super.getPageNum(couponProduction.getEntityPage()), super.getPageSize(couponProduction.getEntityPage()));
	        	List<CouponProduction>  couponProductionlist = 
		        			couponProductionService.queryCouponProductionList(couponProduction);
	        	PageInfo<CouponProduction> pageInfo = new PageInfo<CouponProduction>(couponProductionlist);

	        	view = new ModelAndView("CouponProduction/queryCouponProduction");
				view.addObject("couponProductionlist", couponProductionlist);
				view.addObject("entityPage", couponProduction.getEntityPage());
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
	public void exportCouponProduction(CouponProduction couponProduction,HttpServletRequest request,HttpServletResponse response)  {
			
			try {
				 String path = request.getSession().getServletContext().getRealPath("");
				 File fileFolder = new File(path);
				 if (!fileFolder.isDirectory()) {
					fileFolder.mkdir();
				 }
				 String tempName = "CouponProduction-" + DateTimeUtil.getDateTime14() + ".xls";
				 path = path + File.separator + tempName;

				 if(couponProduction.getEntityPage()==null){
					 couponProduction.setEntityPage(new EntityPage());
		         }
				// 设置分页
		        PageHelper.startPage(super.getPageNum(couponProduction.getEntityPage()), super.getPageSize(couponProduction.getEntityPage()));
		        List<CouponProduction>  exportlist = 
	        			couponProductionService.queryCouponProductionList(couponProduction);

	        	 PoiWriteExcel<CouponProduction> pwe = new PoiWriteExcel<CouponProduction>();

	        	 //设置标题
	             pwe.setFileTitle("");
	             //设置生成文件路径
	             pwe.setExportFileName(path);
	            
	             pwe.setHeaders(couponProduction.EXPORT_HEADERS);
	            
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

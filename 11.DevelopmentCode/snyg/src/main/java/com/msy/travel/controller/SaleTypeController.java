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
import com.msy.travel.pojo.SaleType;
import com.msy.travel.service.SaleTypeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/saleType")
public class SaleTypeController extends BaseController{
	public static final Log log = LogFactory.getLog(SaleTypeController.class);

	@Resource(name = "saleTypeServiceImpl")	
	private SaleTypeService saleTypeService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddSaleType(SaleType saleType,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			view = new ModelAndView("SaleType/addSaleType");
			return view;
		}
	/**
	 * 新增SaleType
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addSaleType(SaleType saleType,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
	        		saleTypeService.createSaleType(saleType);
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
	public ModelAndView toUpdateSaleType(SaleType saleType,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
					SaleType  objSaleType=
					saleTypeService.displaySaleType(saleType);
					view = new ModelAndView("SaleType/updateSaleType");
					view.addObject("saleType", objSaleType);	
				
				} catch (Exception e) {
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}
			return view;
		}	
	/**
	 * 修改SaleType
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateSaleType(SaleType saleType,HttpServletRequest request,HttpServletResponse response)   {
			ModelAndView view = null;
			try {
					saleTypeService.updateSaleType(saleType);
					view = new ModelAndView("success");
				
				}catch (Exception e) {	
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}		
			return view; 
		}
	/**
	 * 删除SaleType
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteSaleType(SaleType saleType,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try{
	        		saleTypeService.deleteSaleType(saleType);
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
	public ModelAndView deleteBatchSaleType(SaleType saleType,String checkedSaleTypeIds,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			String[] saleTypeIds= checkedSaleTypeIds.split(",");
			List<String> saleTypeIdList =new ArrayList<String>();
			Collections.addAll(saleTypeIdList, saleTypeIds);
			try{
					saleType.setSaleTypeIdList(saleTypeIdList);
					saleTypeService.deleteBatchSaleType(saleType);
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
	public ModelAndView querySaleTypeList(SaleType saleType,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try {
				 if(saleType.getEntityPage()==null){
					 saleType.setEntityPage(new EntityPage());
		         }
				 super.saveBackUrl(request);
	        	// 设置分页
	        	PageHelper.startPage(super.getPageNum(saleType.getEntityPage()), super.getPageSize(saleType.getEntityPage()));
	        	List<SaleType>  saleTypelist = 
		        			saleTypeService.querySaleTypeList(saleType);
	        	PageInfo<SaleType> pageInfo = new PageInfo<SaleType>(saleTypelist);

	        	view = new ModelAndView("SaleType/querySaleType");
				view.addObject("saleTypelist", saleTypelist);
				view.addObject("entityPage", saleType.getEntityPage());
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
	public void exportSaleType(SaleType saleType,HttpServletRequest request,HttpServletResponse response)  {
			
			try {
				 String path = request.getSession().getServletContext().getRealPath("");
				 File fileFolder = new File(path);
				 if (!fileFolder.isDirectory()) {
					fileFolder.mkdir();
				 }
				 String tempName = "SaleType-" + DateTimeUtil.getDateTime14() + ".xls";
				 path = path + File.separator + tempName;

				 if(saleType.getEntityPage()==null){
					 saleType.setEntityPage(new EntityPage());
		         }
				// 设置分页
		        PageHelper.startPage(super.getPageNum(saleType.getEntityPage()), super.getPageSize(saleType.getEntityPage()));
		        List<SaleType>  exportlist = 
	        			saleTypeService.querySaleTypeList(saleType);

	        	 PoiWriteExcel<SaleType> pwe = new PoiWriteExcel<SaleType>();

	        	 //设置标题
	             pwe.setFileTitle("");
	             //设置生成文件路径
	             pwe.setExportFileName(path);
	            
	             pwe.setHeaders(saleType.EXPORT_HEADERS);
	            
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

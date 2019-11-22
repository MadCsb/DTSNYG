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
import com.msy.travel.pojo.Destsp;
import com.msy.travel.service.IDestspService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/destsp")
public class DestspController extends BaseController{
	public static final Log log = LogFactory.getLog(DestspController.class);

	@Resource(name = "destspServiceImpl")	
	private IDestspService destspService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddDestsp(Destsp destsp,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			view = new ModelAndView("Destsp/addDestsp");
			return view;
		}
	/**
	 * 新增Destsp
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addDestsp(Destsp destsp,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
	        		destspService.createDestsp(destsp);
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
	public ModelAndView toUpdateDestsp(Destsp destsp,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
					Destsp  objDestsp=
					destspService.displayDestsp(destsp);
					view = new ModelAndView("Destsp/updateDestsp");
					view.addObject("destsp", objDestsp);	
				
				} catch (Exception e) {
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}
			return view;
		}	
	/**
	 * 修改Destsp
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateDestsp(Destsp destsp,HttpServletRequest request,HttpServletResponse response)   {
			ModelAndView view = null;
			try {
					destspService.updateDestsp(destsp);
					view = new ModelAndView("success");
				
				}catch (Exception e) {	
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}		
			return view; 
		}
	/**
	 * 删除Destsp
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteDestsp(Destsp destsp,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try{
	        		destspService.deleteDestsp(destsp);
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
	public ModelAndView deleteBatchDestsp(Destsp destsp,String checkedDestspIds,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			String[] destspIds= checkedDestspIds.split(",");
			List<String> destspIdList =new ArrayList<String>();
			Collections.addAll(destspIdList, destspIds);
			try{
					destsp.setDestspIdList(destspIdList);
					destspService.deleteBatchDestsp(destsp);
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
	public ModelAndView queryDestspList(Destsp destsp,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try {
				 if(destsp.getEntityPage()==null){
					 destsp.setEntityPage(new EntityPage());
		         }
				 super.saveBackUrl(request);
	        	// 设置分页
	        	PageHelper.startPage(super.getPageNum(destsp.getEntityPage()), super.getPageSize(destsp.getEntityPage()));
	        	List<Destsp>  destsplist = 
		        			destspService.queryDestspList(destsp);
	        	PageInfo<Destsp> pageInfo = new PageInfo<Destsp>(destsplist);

	        	view = new ModelAndView("Destsp/queryDestsp");
				view.addObject("destsplist", destsplist);
				view.addObject("entityPage", destsp.getEntityPage());
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
	public void exportDestsp(Destsp destsp,HttpServletRequest request,HttpServletResponse response)  {
			
			try {
				 String path = request.getSession().getServletContext().getRealPath("");
				 File fileFolder = new File(path);
				 if (!fileFolder.isDirectory()) {
					fileFolder.mkdir();
				 }
				 String tempName = "Destsp-" + DateTimeUtil.getDateTime14() + ".xls";
				 path = path + File.separator + tempName;

				 if(destsp.getEntityPage()==null){
					 destsp.setEntityPage(new EntityPage());
		         }
				// 设置分页
		        PageHelper.startPage(super.getPageNum(destsp.getEntityPage()), super.getPageSize(destsp.getEntityPage()));
		        List<Destsp>  exportlist = 
	        			destspService.queryDestspList(destsp);

	        	 PoiWriteExcel<Destsp> pwe = new PoiWriteExcel<Destsp>();

	        	 //设置标题
	             pwe.setFileTitle("");
	             //设置生成文件路径
	             pwe.setExportFileName(path);
	            
	             pwe.setHeaders(destsp.EXPORT_HEADERS);
	            
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

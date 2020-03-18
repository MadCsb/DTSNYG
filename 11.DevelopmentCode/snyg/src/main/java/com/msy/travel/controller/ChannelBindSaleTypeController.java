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
import com.msy.travel.pojo.ChannelBindSaleType;
import com.msy.travel.service.ChannelBindSaleTypeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/channelBindSaleType")
public class ChannelBindSaleTypeController extends BaseController{
	public static final Log log = LogFactory.getLog(ChannelBindSaleTypeController.class);

	@Resource(name = "channelBindSaleTypeServiceImpl")	
	private ChannelBindSaleTypeService channelBindSaleTypeService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddChannelBindSaleType(ChannelBindSaleType channelBindSaleType,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			view = new ModelAndView("ChannelBindSaleType/addChannelBindSaleType");
			return view;
		}
	/**
	 * 新增ChannelBindSaleType
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addChannelBindSaleType(ChannelBindSaleType channelBindSaleType,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
	        		channelBindSaleTypeService.createChannelBindSaleType(channelBindSaleType);
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
	public ModelAndView toUpdateChannelBindSaleType(ChannelBindSaleType channelBindSaleType,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
					ChannelBindSaleType  objChannelBindSaleType=
					channelBindSaleTypeService.displayChannelBindSaleType(channelBindSaleType);
					view = new ModelAndView("ChannelBindSaleType/updateChannelBindSaleType");
					view.addObject("channelBindSaleType", objChannelBindSaleType);	
				
				} catch (Exception e) {
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}
			return view;
		}	
	/**
	 * 修改ChannelBindSaleType
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateChannelBindSaleType(ChannelBindSaleType channelBindSaleType,HttpServletRequest request,HttpServletResponse response)   {
			ModelAndView view = null;
			try {
					channelBindSaleTypeService.updateChannelBindSaleType(channelBindSaleType);
					view = new ModelAndView("success");
				
				}catch (Exception e) {	
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}		
			return view; 
		}
	/**
	 * 删除ChannelBindSaleType
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteChannelBindSaleType(ChannelBindSaleType channelBindSaleType,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try{
	        		channelBindSaleTypeService.deleteChannelBindSaleType(channelBindSaleType);
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
	public ModelAndView deleteBatchChannelBindSaleType(ChannelBindSaleType channelBindSaleType,String checkedChannelBindSaleTypeIds,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			String[] channelBindSaleTypeIds= checkedChannelBindSaleTypeIds.split(",");
			List<String> channelBindSaleTypeIdList =new ArrayList<String>();
			Collections.addAll(channelBindSaleTypeIdList, channelBindSaleTypeIds);
			try{
					channelBindSaleType.setChannelBindSaleTypeIdList(channelBindSaleTypeIdList);
					channelBindSaleTypeService.deleteBatchChannelBindSaleType(channelBindSaleType);
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
	public ModelAndView queryChannelBindSaleTypeList(ChannelBindSaleType channelBindSaleType,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try {
				 if(channelBindSaleType.getEntityPage()==null){
					 channelBindSaleType.setEntityPage(new EntityPage());
		         }
				 super.saveBackUrl(request);
	        	// 设置分页
	        	PageHelper.startPage(super.getPageNum(channelBindSaleType.getEntityPage()), super.getPageSize(channelBindSaleType.getEntityPage()));
	        	List<ChannelBindSaleType>  channelBindSaleTypelist = 
		        			channelBindSaleTypeService.queryChannelBindSaleTypeList(channelBindSaleType);
	        	PageInfo<ChannelBindSaleType> pageInfo = new PageInfo<ChannelBindSaleType>(channelBindSaleTypelist);

	        	view = new ModelAndView("ChannelBindSaleType/queryChannelBindSaleType");
				view.addObject("channelBindSaleTypelist", channelBindSaleTypelist);
				view.addObject("entityPage", channelBindSaleType.getEntityPage());
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
	public void exportChannelBindSaleType(ChannelBindSaleType channelBindSaleType,HttpServletRequest request,HttpServletResponse response)  {
			
			try {
				 String path = request.getSession().getServletContext().getRealPath("");
				 File fileFolder = new File(path);
				 if (!fileFolder.isDirectory()) {
					fileFolder.mkdir();
				 }
				 String tempName = "ChannelBindSaleType-" + DateTimeUtil.getDateTime14() + ".xls";
				 path = path + File.separator + tempName;

				 if(channelBindSaleType.getEntityPage()==null){
					 channelBindSaleType.setEntityPage(new EntityPage());
		         }
				// 设置分页
		        PageHelper.startPage(super.getPageNum(channelBindSaleType.getEntityPage()), super.getPageSize(channelBindSaleType.getEntityPage()));
		        List<ChannelBindSaleType>  exportlist = 
	        			channelBindSaleTypeService.queryChannelBindSaleTypeList(channelBindSaleType);

	        	 PoiWriteExcel<ChannelBindSaleType> pwe = new PoiWriteExcel<ChannelBindSaleType>();

	        	 //设置标题
	             pwe.setFileTitle("");
	             //设置生成文件路径
	             pwe.setExportFileName(path);
	            
	             pwe.setHeaders(channelBindSaleType.EXPORT_HEADERS);
	            
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

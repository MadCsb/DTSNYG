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
import com.msy.travel.pojo.RoleData;
import com.msy.travel.service.RoleDataService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/roleData")
public class RoleDataController extends BaseController{
	public static final Log log = LogFactory.getLog(RoleDataController.class);

	@Resource(name = "roleDataServiceImpl")	
	private RoleDataService roleDataService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddRoleData(RoleData roleData,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			view = new ModelAndView("RoleData/addRoleData");
			return view;
		}
	/**
	 * 新增RoleData
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addRoleData(RoleData roleData,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
	        		roleDataService.createRoleData(roleData);
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
	public ModelAndView toUpdateRoleData(RoleData roleData,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
					RoleData  objRoleData=
					roleDataService.displayRoleData(roleData);
					view = new ModelAndView("RoleData/updateRoleData");
					view.addObject("roleData", objRoleData);	
				
				} catch (Exception e) {
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}
			return view;
		}	
	/**
	 * 修改RoleData
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateRoleData(RoleData roleData,HttpServletRequest request,HttpServletResponse response)   {
			ModelAndView view = null;
			try {
					roleDataService.updateRoleData(roleData);
					view = new ModelAndView("success");
				
				}catch (Exception e) {	
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}		
			return view; 
		}
	/**
	 * 删除RoleData
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteRoleData(RoleData roleData,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try{
	        		roleDataService.deleteRoleData(roleData);
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
	public ModelAndView deleteBatchRoleData(RoleData roleData,String checkedRoleDataIds,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			String[] roleDataIds= checkedRoleDataIds.split(",");
			List<String> roleDataIdList =new ArrayList<String>();
			Collections.addAll(roleDataIdList, roleDataIds);
			try{
					roleData.setRoleDataIdList(roleDataIdList);
					roleDataService.deleteBatchRoleData(roleData);
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
	public ModelAndView queryRoleDataList(RoleData roleData,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try {
				 if(roleData.getEntityPage()==null){
					 roleData.setEntityPage(new EntityPage());
		         }
				 super.saveBackUrl(request);
	        	// 设置分页
	        	PageHelper.startPage(super.getPageNum(roleData.getEntityPage()), super.getPageSize(roleData.getEntityPage()));
	        	List<RoleData>  roleDatalist = 
		        			roleDataService.queryRoleDataList(roleData);
	        	PageInfo<RoleData> pageInfo = new PageInfo<RoleData>(roleDatalist);

	        	view = new ModelAndView("RoleData/queryRoleData");
				view.addObject("roleDatalist", roleDatalist);
				view.addObject("entityPage", roleData.getEntityPage());
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
	public void exportRoleData(RoleData roleData,HttpServletRequest request,HttpServletResponse response)  {
			
			try {
				 String path = request.getSession().getServletContext().getRealPath("");
				 File fileFolder = new File(path);
				 if (!fileFolder.isDirectory()) {
					fileFolder.mkdir();
				 }
				 String tempName = "RoleData-" + DateTimeUtil.getDateTime14() + ".xls";
				 path = path + File.separator + tempName;

				 if(roleData.getEntityPage()==null){
					 roleData.setEntityPage(new EntityPage());
		         }
				// 设置分页
		        PageHelper.startPage(super.getPageNum(roleData.getEntityPage()), super.getPageSize(roleData.getEntityPage()));
		        List<RoleData>  exportlist = 
	        			roleDataService.queryRoleDataList(roleData);

	        	 PoiWriteExcel<RoleData> pwe = new PoiWriteExcel<RoleData>();

	        	 //设置标题
	             pwe.setFileTitle("");
	             //设置生成文件路径
	             pwe.setExportFileName(path);
	            
	             pwe.setHeaders(roleData.EXPORT_HEADERS);
	            
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

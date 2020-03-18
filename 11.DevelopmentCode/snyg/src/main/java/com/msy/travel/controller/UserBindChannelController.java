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
import com.msy.travel.pojo.UserBindChannel;
import com.msy.travel.service.UserBindChannelService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/userBindChannel")
public class UserBindChannelController extends BaseController{
	public static final Log log = LogFactory.getLog(UserBindChannelController.class);

	@Resource(name = "userBindChannelServiceImpl")	
	private UserBindChannelService userBindChannelService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddUserBindChannel(UserBindChannel userBindChannel,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			view = new ModelAndView("UserBindChannel/addUserBindChannel");
			return view;
		}
	/**
	 * 新增UserBindChannel
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addUserBindChannel(UserBindChannel userBindChannel,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
	        		userBindChannelService.createUserBindChannel(userBindChannel);
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
	public ModelAndView toUpdateUserBindChannel(UserBindChannel userBindChannel,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
					UserBindChannel  objUserBindChannel=
					userBindChannelService.displayUserBindChannel(userBindChannel);
					view = new ModelAndView("UserBindChannel/updateUserBindChannel");
					view.addObject("userBindChannel", objUserBindChannel);	
				
				} catch (Exception e) {
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}
			return view;
		}	
	/**
	 * 修改UserBindChannel
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateUserBindChannel(UserBindChannel userBindChannel,HttpServletRequest request,HttpServletResponse response)   {
			ModelAndView view = null;
			try {
					userBindChannelService.updateUserBindChannel(userBindChannel);
					view = new ModelAndView("success");
				
				}catch (Exception e) {	
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}		
			return view; 
		}
	/**
	 * 删除UserBindChannel
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteUserBindChannel(UserBindChannel userBindChannel,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try{
	        		userBindChannelService.deleteUserBindChannel(userBindChannel);
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
	public ModelAndView deleteBatchUserBindChannel(UserBindChannel userBindChannel,String checkedUserBindChannelIds,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			String[] userBindChannelIds= checkedUserBindChannelIds.split(",");
			List<String> userBindChannelIdList =new ArrayList<String>();
			Collections.addAll(userBindChannelIdList, userBindChannelIds);
			try{
					userBindChannel.setUserBindChannelIdList(userBindChannelIdList);
					userBindChannelService.deleteBatchUserBindChannel(userBindChannel);
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
	public ModelAndView queryUserBindChannelList(UserBindChannel userBindChannel,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try {
				 if(userBindChannel.getEntityPage()==null){
					 userBindChannel.setEntityPage(new EntityPage());
		         }
				 super.saveBackUrl(request);
	        	// 设置分页
	        	PageHelper.startPage(super.getPageNum(userBindChannel.getEntityPage()), super.getPageSize(userBindChannel.getEntityPage()));
	        	List<UserBindChannel>  userBindChannellist = 
		        			userBindChannelService.queryUserBindChannelList(userBindChannel);
	        	PageInfo<UserBindChannel> pageInfo = new PageInfo<UserBindChannel>(userBindChannellist);

	        	view = new ModelAndView("UserBindChannel/queryUserBindChannel");
				view.addObject("userBindChannellist", userBindChannellist);
				view.addObject("entityPage", userBindChannel.getEntityPage());
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
	public void exportUserBindChannel(UserBindChannel userBindChannel,HttpServletRequest request,HttpServletResponse response)  {
			
			try {
				 String path = request.getSession().getServletContext().getRealPath("");
				 File fileFolder = new File(path);
				 if (!fileFolder.isDirectory()) {
					fileFolder.mkdir();
				 }
				 String tempName = "UserBindChannel-" + DateTimeUtil.getDateTime14() + ".xls";
				 path = path + File.separator + tempName;

				 if(userBindChannel.getEntityPage()==null){
					 userBindChannel.setEntityPage(new EntityPage());
		         }
				// 设置分页
		        PageHelper.startPage(super.getPageNum(userBindChannel.getEntityPage()), super.getPageSize(userBindChannel.getEntityPage()));
		        List<UserBindChannel>  exportlist = 
	        			userBindChannelService.queryUserBindChannelList(userBindChannel);

	        	 PoiWriteExcel<UserBindChannel> pwe = new PoiWriteExcel<UserBindChannel>();

	        	 //设置标题
	             pwe.setFileTitle("");
	             //设置生成文件路径
	             pwe.setExportFileName(path);
	            
	             pwe.setHeaders(userBindChannel.EXPORT_HEADERS);
	            
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

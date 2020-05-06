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
import com.msy.travel.pojo.Event;
import com.msy.travel.service.EventService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="prototype")
@RequestMapping(value = "/event")
public class EventController extends BaseController{
	public static final Log log = LogFactory.getLog(EventController.class);

	@Resource(name = "eventServiceImpl")	
	private EventService eventService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddEvent(Event event,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			view = new ModelAndView("Event/addEvent");
			return view;
		}
	/**
	 * 新增Event
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addEvent(Event event,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
	        		eventService.createEvent(event);
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
	public ModelAndView toUpdateEvent(Event event,HttpServletRequest request,HttpServletResponse response) {
			ModelAndView view = null;
			try {
					Event  objEvent=
					eventService.displayEvent(event);
					view = new ModelAndView("Event/updateEvent");
					view.addObject("event", objEvent);	
				
				} catch (Exception e) {
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}
			return view;
		}	
	/**
	 * 修改Event
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateEvent(Event event,HttpServletRequest request,HttpServletResponse response)   {
			ModelAndView view = null;
			try {
					eventService.updateEvent(event);
					view = new ModelAndView("success");
				
				}catch (Exception e) {	
					view = new ModelAndView("error");
					view.addObject("e", getExceptionInfo(e));
					log.error(e, e);
				}		
			return view; 
		}
	/**
	 * 删除Event
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteEvent(Event event,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try{
	        		eventService.deleteEvent(event);
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
	public ModelAndView deleteBatchEvent(Event event,String checkedEventIds,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			String[] eventIds= checkedEventIds.split(",");
			List<String> eventIdList =new ArrayList<String>();
			Collections.addAll(eventIdList, eventIds);
			try{
					event.setEventIdList(eventIdList);
					eventService.deleteBatchEvent(event);
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
	public ModelAndView queryEventList(Event event,HttpServletRequest request,HttpServletResponse response)  {
			ModelAndView view = null;
			try {
				 if(event.getEntityPage()==null){
					 event.setEntityPage(new EntityPage());
		         }
				 super.saveBackUrl(request);
	        	// 设置分页
	        	PageHelper.startPage(super.getPageNum(event.getEntityPage()), super.getPageSize(event.getEntityPage()));
	        	List<Event>  eventlist = 
		        			eventService.queryEventList(event);
	        	PageInfo<Event> pageInfo = new PageInfo<Event>(eventlist);

	        	view = new ModelAndView("Event/queryEvent");
				view.addObject("eventlist", eventlist);
				view.addObject("entityPage", event.getEntityPage());
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
	public void exportEvent(Event event,HttpServletRequest request,HttpServletResponse response)  {
			
			try {
				 String path = request.getSession().getServletContext().getRealPath("");
				 File fileFolder = new File(path);
				 if (!fileFolder.isDirectory()) {
					fileFolder.mkdir();
				 }
				 String tempName = "Event-" + DateTimeUtil.getDateTime14() + ".xls";
				 path = path + File.separator + tempName;

				 if(event.getEntityPage()==null){
					 event.setEntityPage(new EntityPage());
		         }
				// 设置分页
		        PageHelper.startPage(super.getPageNum(event.getEntityPage()), super.getPageSize(event.getEntityPage()));
		        List<Event>  exportlist = 
	        			eventService.queryEventList(event);

	        	 PoiWriteExcel<Event> pwe = new PoiWriteExcel<Event>();

	        	 //设置标题
	             pwe.setFileTitle("");
	             //设置生成文件路径
	             pwe.setExportFileName(path);
	            
	             pwe.setHeaders(event.EXPORT_HEADERS);
	            
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

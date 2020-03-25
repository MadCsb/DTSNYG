package com.msy.travel.wap.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.msy.travel.common.BaseController;
import com.msy.travel.pojo.Consignee;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.service.ConsigneeService;
import com.msy.travel.service.ICityService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wapConsignee")
public class WapConsigneeController extends BaseController {
	public static final Log log = LogFactory.getLog(WapConsigneeController.class);

	@Resource(name = "consigneeServiceImpl")
	private ConsigneeService consigneeService;

	@Resource(name = "cityServiceImpl")
	private ICityService cityService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	/**
	 * 跳转到管理页面
	 */
	@RequestMapping(params = "method=toQueryConsignee")
	public ModelAndView toQueryConsignee(Consignee consignee, HttpServletRequest request, HttpServletResponse response, String isChoose) {
		ModelAndView view = null;
		try {

			view = new ModelAndView("wap/consignee/queryConsignee");
			view.addObject("spId", Destsp.currentSpId);
			view.addObject("isChoose", isChoose);
		} catch (Exception e) {
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 获取收货地址列表json
	 * 
	 * @author wzd
	 * @date 2019年10月15日 下午4:04:10
	 * @param consignee
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=toGetConsigneeListJson")
	public void toGetConsigneeListJson(Consignee consignee, HttpServletRequest request, HttpServletResponse response) {
		try {
			consignee.setUserId(getLoginUser(request).getUserId());
			List<Consignee> consigneeList = consigneeService.queryConsigneeList(consignee);
			JSONArray jsonArray = JSONArray.fromObject(consigneeList);
			response.getWriter().print(jsonArray.toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 更新默认地址
	 * 
	 * @author wzd
	 * @date 2019年10月15日 下午7:26:33
	 * @param consignee
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=updateIsDefault")
	public void updateIsDefault(Consignee consignee, HttpServletRequest request, HttpServletResponse response) {
		try {
			consignee.setUserId(getLoginUser(request).getUserId());
			consigneeService.updateConsigneeIsDefault(consignee);
			response.getWriter().print("success");
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 跳转到新增
	 */
	@RequestMapping(params = "method=toAddConsignee")
	public ModelAndView toAddConsignee(Consignee consignee, HttpServletRequest request, HttpServletResponse response, String isChoose) {
		ModelAndView view = null;
		try {

			view = new ModelAndView("wap/consignee/addConsignee");

			view.addObject("isChoose", isChoose);
		} catch (Exception e) {
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 新建收货人信息
	 * 
	 * @author wzd
	 * @date 2019年10月18日 下午1:27:07
	 * @param consignee
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=addConsignee")
	public void addConsignee(Consignee consignee, HttpServletRequest request, HttpServletResponse response) {
		try {
			consignee.setUserId(getLoginUser(request).getUserId());
			consigneeService.createConsigneeWx(consignee);
			response.getWriter().print("success");
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 删除收货地址
	 * 
	 * @author wzd
	 * @date 2019年10月20日 下午3:12:54
	 * @param consignee
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=deleteConsignee")
	public void deleteConsignee(Consignee consignee, HttpServletRequest request, HttpServletResponse response) {
		try {
			consignee.setUserId(getLoginUser(request).getUserId());
			consigneeService.deleteConsignee(consignee);
			response.getWriter().print("success");
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 修改收货人信息
	 * 
	 * @author wzd
	 * @date 2019年10月20日 下午3:26:11
	 * @param consignee
	 * @param request
	 * @param response
	 * @param userId
	 * @param spId
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=toUpdateConsignee")
	public ModelAndView toUpdateConsignee(Consignee consignee, HttpServletRequest request, HttpServletResponse response, String userId) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("wap/consignee/updateConsignee");

			consignee = consigneeService.displayConsignee(consignee);

			view.addObject("userId", userId);
			view.addObject("spId", Destsp.currentSpId);
			view.addObject("consignee", consignee);
		} catch (Exception e) {
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改收货人信息
	 * 
	 * @author wzd
	 * @date 2019年10月18日 下午1:27:07
	 * @param consignee
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=updateConsignee")
	public void updateConsignee(Consignee consignee, HttpServletRequest request, HttpServletResponse response) {
		try {
			consignee.setUserId(getLoginUser(request).getUserId());
			consigneeService.updateConsignee(consignee);
			response.getWriter().print("success");
		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

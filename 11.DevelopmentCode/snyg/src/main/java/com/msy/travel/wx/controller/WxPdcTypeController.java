package com.msy.travel.wx.controller;

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
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.PdcType;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.PdcTypeService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/wx")
public class WxPdcTypeController extends BaseController {
	public static final Log log = LogFactory.getLog(WxPdcTypeController.class);

	@Resource(name = "pdcTypeServiceImpl")
	private PdcTypeService pdcTypeService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	/**
	 * 跳转分类列表
	 * 
	 * @author wzd
	 * @date 2019年10月18日 下午5:25:35
	 * @param pdcType
	 * @param request
	 * @param response
	 * @param spId
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=toQueryPdcTypeList")
	public ModelAndView toQueryPdcTypeList(PdcType pdcType, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("wx/pdcType/queryPdcType");
			ServiceCode serviceCode = serviceCodeService.getServiceCodeBySpId(Destsp.currentSpId);
			wxSetViewObjects(view, request, serviceCode, userService);
			view.addObject("spId", Destsp.currentSpId);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 获取分类列表信息
	 * 
	 * @author wzd
	 * @date 2019年10月18日 下午5:25:56
	 * @param pdcType
	 * @param request
	 * @param response
	 * @param spId
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(params = "method=getPdcTypeListForWx")
	public void getPdcTypeListForWx(PdcType pdcType, HttpServletRequest request, HttpServletResponse response) {
		try {
			pdcType.setDelFlag("0");
			List<PdcType> pdcTypeList = pdcTypeService.queryPdcTypeList(pdcType);
			JSONArray jsonArray = JSONArray.fromObject(pdcTypeList);
			response.getWriter().print(jsonArray.toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

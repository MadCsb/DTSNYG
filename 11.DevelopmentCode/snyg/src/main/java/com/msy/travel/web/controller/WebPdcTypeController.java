package com.msy.travel.web.controller;

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

import com.msy.travel.common.BaseController;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.PdcType;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.PdcTypeService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/webPdcType")
public class WebPdcTypeController extends BaseController {
	public static final Log log = LogFactory.getLog(WebPdcTypeController.class);

	@Resource(name = "pdcTypeServiceImpl")
	private PdcTypeService pdcTypeService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

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
	@RequestMapping(params = "method=getPdcTypeListForWeb")
	public void getPdcTypeListForWeb(PdcType pdcType, HttpServletRequest request, HttpServletResponse response) {
		try {
			pdcType.setSpId(Destsp.currentSpId);
			pdcType.setDelFlag("0");
			List<PdcType> pdcTypeList = pdcTypeService.queryPdcTypeList(pdcType);
			if (pdcTypeList != null && pdcTypeList.size() > 0) {
				for (int i = 0; i < pdcTypeList.size(); i++) {
					PdcType subType = new PdcType();
					subType.setPpdcTypeId(pdcTypeList.get(i).getPdcTypeId());
					subType.setLevel("2");
					List<PdcType> subTypeList = pdcTypeService.queryPdcTypeList(subType);
					pdcTypeList.get(i).setPdcTypeList(subTypeList);
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(pdcTypeList);
			response.getWriter().print(jsonArray.toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

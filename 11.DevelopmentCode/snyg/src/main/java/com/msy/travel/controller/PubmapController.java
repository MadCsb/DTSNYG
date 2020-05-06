package com.msy.travel.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.EntityPage;
import com.msy.travel.pojo.Pubmap;
import com.msy.travel.service.IPubUserLogService;
import com.msy.travel.service.IPubmapService;

/**
 * @program: workBase_svn
 *
 * @description:
 *
 * @author: Mr.Wang
 *
 * @create: 2019-03-25 14:03
 **/
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/pubMap")
public class PubmapController extends BaseController {
	public static final Log log = LogFactory.getLog(PubmapController.class);

	@Resource(name = "pubmapServiceImpl")
	private IPubmapService pubmapService;
	@Resource(name = "pubUserLogServiceImpl")
	private IPubUserLogService pubUserLogService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAddPubmap")
	public ModelAndView toAddPubmap(Pubmap pubmap, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("pubmap/addPubmap");
		return view;
	}

	/**
	 * 新增Pubmap
	 */
	@RequestMapping(params = "method=addPubmap")
	public ModelAndView addPubmap(Pubmap pubmap, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (StringUtils.isBlank(pubmap.getSys())) {
				pubmap.setSys("0");
			}
			pubmapService.insertPubmap(pubmap);
			view = new ModelAndView("success");
			pubUserLogService.createUserLog(request, "新增系统字典", "1", null);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 跳转到修改页面
	 */
	@RequestMapping(params = "method=toUpdatePubmap")
	public ModelAndView toUpdatePubmap(Pubmap pubmap, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Pubmap objPubmap = pubmapService.displayPubmap(pubmap);
			view = new ModelAndView("pubmap/updatePubmap");
			view.addObject("pubmap", objPubmap);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改Pubmap
	 */
	@RequestMapping(params = "method=updatePubmap")
	public ModelAndView updatePubmap(Pubmap pubmap, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (StringUtils.isBlank(pubmap.getSys())) {
				pubmap.setSys("0");
			}
			pubmapService.updatePubmap(pubmap);
			view = new ModelAndView("success");
			pubUserLogService.createUserLog(request, "修改系统字典", "1", null);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除字典
	 */
	@RequestMapping(params = "method=deletePubmap")
	public ModelAndView deletePubmap(Pubmap pubmap, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			pubmapService.deletePubmap(pubmap);
			view = new ModelAndView("success");
			pubUserLogService.createUserLog(request, "删除系统字典", "1", null);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 批量删除
	 */
	@RequestMapping(params = "method=deleteBatchPubmap")
	public ModelAndView deleteBatchPubmap(Pubmap pubmap, String checkedPubMapIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] PubMapIds = checkedPubMapIds.split(",");
		List<String> pubMapIdList = new ArrayList<String>();
		Collections.addAll(pubMapIdList, PubMapIds);
		try {
			pubmap.setPubMapIdList(pubMapIdList);
			pubmapService.deleteBatchPubmap(pubmap);
			view = new ModelAndView("success");
			pubUserLogService.createUserLog(request, "批量系统字典", "1", null);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 分页查询
	 */
	@RequestMapping(params = "method=queryPubmapList")
	public ModelAndView queryPubmapList(Pubmap pubmap, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (pubmap.getEntityPage() == null) {
				pubmap.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(pubmap.getEntityPage()), super.getPageSize(pubmap.getEntityPage()));
			List<Pubmap> pubmapList = pubmapService.queryPubmapList(pubmap);
			PageInfo<Pubmap> pageInfo = new PageInfo<Pubmap>(pubmapList);

			view = new ModelAndView("pubmap/queryPubmap");
			List<Pubmap> allDesc = pubmapService.getAllDesc();
			view.addObject("pubmapList", pubmapList);
			view.addObject("pubmap", pubmap);
			view.addObject("entityPage", pubmap.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("descList", allDesc);
			view.addObject("mapDesc", pubmap.getMapDesc() == null ? "" : pubmap.getMapDesc());
			pubUserLogService.createUserLog(request, "查看系统字典", "1", null);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	@RequestMapping(params = "method=getPubmapJson")
	public void getPubmapJson(Pubmap pubmap, HttpServletRequest request, HttpServletResponse response) {
		if (null == pubmap) {
			pubmap = new Pubmap();
		}

		try {
			List<Pubmap> list = pubmapService.getPubmapListByType(pubmap.getMapType());

			String lstypes = JSONArray.fromObject(list).toString();

			response.setContentType("text/xml");
			response.getWriter().print(lstypes);
		} catch (Exception e) {
			log.error("getPubmapJson failed: ", e);
		}

	}

	@RequestMapping(params = "method=export")
	public void exportLineTemplate(Pubmap pubmap, HttpServletRequest request, HttpServletResponse response) {

		try {
			// String path =
			// request.getSession().getServletContext().getRealPath("");
			// path = path + File.separator + "export";
			// File fileFolder = new File(path);
			// if (!fileFolder.isDirectory()) {
			// fileFolder.mkdir();
			// }
			// String tempName = "系统字典-" + DateTimeUtil.getDateTime14() +
			// ".xls";
			// path = path + File.separator + tempName;
			//
			// if (pubmap.getEntityPage() == null) {
			// pubmap.setEntityPage(new EntityPage());
			// }
			// List<Pubmap> pubmapList = pubmapService.queryPubmapList(pubmap);
			//
			// List<Map<String, Object>> maps = new ArrayList<>();
			// for (Pubmap t : pubmapList) {
			// Map<String, Object> map = new HashMap<>();
			// map.put("mapType", t.getMapType());
			// map.put("mapKey", t.getMapKey());
			// map.put("mapValue", t.getMapValue());
			// map.put("mapDesc", t.getMapDesc());
			// maps.add(map);
			//
			// }
			//
			// PoiWriteExcel<Pubmap> pwe = new PoiWriteExcel<Pubmap>();
			// String[] headers = Pubmap.EXPORT_HEADERS;
			// if (pwe.exportForSXSSFWorkBook(path, headers, maps, "系统字典")) {
			// downloadFile(request, response, path, tempName);
			// }

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}

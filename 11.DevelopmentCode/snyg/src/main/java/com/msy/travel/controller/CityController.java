package com.msy.travel.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.msy.travel.common.BaseController;
import com.msy.travel.common.EntityPage;
import com.msy.travel.pojo.City;
import com.msy.travel.service.ICityService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/city")
public class CityController extends BaseController {
	public static final Log log = LogFactory.getLog(CityController.class);

	@Resource(name = "cityServiceImpl")
	private ICityService cityService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddCity(City city, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("city/addCity");
		return view;
	}

	/**
	 * 新增City
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addCity(City city, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {

			if (city.getCityLevel().equals("1")) {
				// 是省市
				city.setProvince(city.getCityName());// 省市名称为行政名称

			} else {
				// 非省市
				// 获取上级名称
				String cityId = city.getPcityId();
				City temp = new City();
				temp.setCityId(cityId);
				City cityParent = cityService.displayCity(temp);
				// 是地市
				if (city.getCityLevel().equals("2")) {
					city.setProvince(cityParent.getProvince());
					city.setCity(city.getCityName());
				} else if (city.getCityLevel().equals("3")) {
					// 是区县
					city.setProvince(cityParent.getProvince());
					city.setCity(cityParent.getCityName());
					city.setXian(city.getCityName());
				}
			}

			cityService.createCity(city);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 跳转到修改页面
	 */
	@RequestMapping(params = "method=toUpdate")
	public ModelAndView toUpdateCity(City city, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("city/updateCity");
			City objCity = cityService.displayCity(city);
			// 查询上级行政区划列表
			List<City> cityList = new ArrayList<City>();
			String level = objCity.getCityLevel();
			City temp = new City();
			temp.setForeigh(objCity.getForeigh());
			if ("2".equals(level)) {
				temp.setCityLevel("1");
				cityList = cityService.queryCityList(temp);
			}
			if ("3".equals(level)) {
				temp.setCityLevel("2");
				cityList = cityService.queryCityList(temp);
			}

			view.addObject("city", objCity);
			view.addObject("cityList", cityList);
		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改City
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateCity(City city, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			City temp = cityService.displayCity(city);
			temp.setCityCode(city.getCityCode());
			temp.setCityName(city.getCityName());
			temp.setForeigh(city.getForeigh());
			temp.setCityLevel(city.getCityLevel());
			temp.setPcityId(city.getPcityId());
			temp.setPy(city.getPy());
			temp.setIsAlaway(city.getIsAlaway());

			if (city.getCityLevel().equals("1")) {
				// 是省市
				temp.setProvince(temp.getCityName());// 省市名称为行政名称

			} else {
				// 非省市
				// 获取上级名称
				String cityId = city.getPcityId();
				City tempPare = new City();
				tempPare.setCityId(cityId);
				City cityParent = cityService.displayCity(tempPare);
				// 是地市
				if (temp.getCityLevel().equals("2")) {
					temp.setProvince(cityParent.getProvince());
					temp.setCity(temp.getCityName());
				} else if (temp.getCityLevel().equals("3")) {
					// 是区县
					temp.setProvince(cityParent.getProvince());
					temp.setCity(cityParent.getCityName());
					temp.setXian(temp.getCityName());
				}
			}

			cityService.updateCity(temp);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除City
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteCity(City city, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			cityService.deleteCity(city);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 分页查询
	 */
	@RequestMapping(params = "method=query")
	public ModelAndView queryCityList(City city, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (city.getEntityPage() == null) {
				city.setEntityPage(new EntityPage());
			}
			/*
			 * if(city.getForeigh()==null || "".equals(city.getForeigh())){
			 * city.setForeigh("0");//默认查询国内 } if(city.getCityLevel()==null ||
			 * "".equals(city.getCityLevel())){ city.setCityLevel("1");//默认省 }
			 */
			// 默认查询
			EntityPage ent = city.getEntityPage();
			if (ent.getSortField() == null || "".equals(ent.getSortField())) {
				ent.setSortField("F_CITYCODE");
			}
			if (ent.getSortOrder() == null || "".equals(ent.getSortOrder())) {
				ent.setSortOrder("desc");
			}

			// 设置页面参数
			int totalSize = cityService.getTotalCount(city);
			super.entityPageHandler(city.getEntityPage(), totalSize);
			super.saveBackUrl(request);
			List<City> citylist = cityService.queryCityList(city);

			view = new ModelAndView("city/queryCity");
			view.addObject("citylist", citylist);
			view.addObject("city", city);
			view.addObject("entityPage", city.getEntityPage());

		} catch (Exception e) {
			view = new ModelAndView("error");
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 查询省市 返回json
	 * 
	 */
	@RequestMapping(params = "method=getCityJson")
	public void getCityJson(City city, HttpServletRequest request, HttpServletResponse response) {
		try {

			List<City> cityList = cityService.queryCityList(city);
			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(JSON.toJSONString(cityList));
		} catch (Exception e) {
			log.error(e, e);
		}
	}
}

package com.msy.travel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/destPlace")
public class DestPlaceController {

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toDestPlace")
	public ModelAndView toDestPlace(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("destPlace/toDestPlace");
		return view;
	}
}

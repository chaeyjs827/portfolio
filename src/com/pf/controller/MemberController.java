package com.pf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController extends Member {

	@Override
	public ModelAndView LoginJSON(HttpServletRequest request) throws Exception {
//		ModelAndView mav = new ModelAndView("jsonView");
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
}

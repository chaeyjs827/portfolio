package com.pf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController extends Member {

	@Override
	public ModelAndView indexMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("legacyIndexMain");
		return mav;
	}
	
}

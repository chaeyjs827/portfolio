package com.pf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContentController extends Content{

	@Override
	public ModelAndView contentList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@Override
	public ModelAndView contentRead(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@Override
	public ModelAndView contentWrite(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@Override
	public ModelAndView contentModify(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}

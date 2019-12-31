package com.pf.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContentController extends Content{

	@Override
	public ModelAndView contentList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView contentRead(Integer contentIndex, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@Override
	public ModelAndView contentWriteJSON(@PathVariable String contentName, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("contentName", contentName);
		return mav;
	}
	
	@Override
	public ModelAndView contentModifyJSON(@PathVariable String contentName, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("contentName", contentName);
		return mav;
	}
}

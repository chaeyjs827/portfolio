package com.pf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = {"Index", "index"})
public abstract class Content {

	@RequestMapping(value = {"/ContentList"})
	public abstract ModelAndView contentList(HttpServletRequest request);
	
	@RequestMapping(value = {"/ContentRead"})
	public abstract ModelAndView contentRead(HttpServletRequest request);
	
	@RequestMapping(value = {"/ContentWrite"})
	public abstract ModelAndView contentWrite(HttpServletRequest request);
	
	@RequestMapping(value = {"/ContentModify"})
	public abstract ModelAndView contentModify(HttpServletRequest requset);
	
	
}

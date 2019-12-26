package com.pf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = {"/index", "/Index"})
public abstract class Member {
	
	@RequestMapping(value ={"/Member/LoginJSON"})
	public abstract ModelAndView LoginJSON(HttpServletRequest request) throws Exception;
	
}

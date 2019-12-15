package com.pf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/Index")
public abstract class Member {

	@RequestMapping("/Main")
	public abstract ModelAndView indexMain(HttpServletRequest request);
	
}

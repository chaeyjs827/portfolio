package com.pf.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pf.config.ProjectConstants;

@RequestMapping(value = {"/Index", "/index"})
public abstract class Main extends ProjectConstants {

	@RequestMapping("/Main")
	public abstract ModelAndView indexMain(HttpServletRequest request, Locale locale);
	
}

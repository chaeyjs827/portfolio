package com.pf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pf.config.ProjectConstants;

@RequestMapping(value = {"/index", "/Index"})
public abstract class Member extends ProjectConstants {
	
	@RequestMapping(value = {"/Member/CreateJSON"})
	public abstract ModelAndView CreateJSON(HttpServletRequest request) throws Exception;
	
	@RequestMapping(value ={"/Member/LoginJSON"})
	public abstract ModelAndView LoginJSON(HttpSession session, HttpServletRequest request) throws Exception;
	
	@RequestMapping(value = {"/Member/LogoutJSON"})
	public abstract ModelAndView LogoutJSON(HttpSession session) throws Exception;
	
}

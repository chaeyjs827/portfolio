package com.pf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = {"/Index", "/index"})
public abstract class Content {

	@RequestMapping(value = {"/Content/List"})
	public abstract ModelAndView contentList(HttpServletRequest request);
	
	@RequestMapping(value = {"/Content/Read/{contentIndex}"})
	public abstract ModelAndView contentRead(@PathVariable Integer contentIndex, HttpServletRequest request);
	
	@RequestMapping(value = {"/Content/WriteJSON/{contentName}"})
	public abstract ModelAndView contentWriteJSON(@PathVariable String contentName, HttpServletRequest request);
	
	@RequestMapping(value = {"/Content/ModifyJSON/{contentName}"})
	public abstract ModelAndView contentModifyJSON(@PathVariable String contentName, HttpServletRequest requset);
	
	
}

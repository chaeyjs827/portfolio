package com.pf.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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
//		ModelAndView mav = new ModelAndView("json");
//		System.out.println(contentIndex);
//		JSONObject jsonObj = new JSONObject();
//		jsonObj.put("testValue", "Hello");
//		mav.addObject(jsonObj);
		return mav;
	}
	
	@Override
	public ModelAndView contentWriteJSON(@PathVariable String contentName, HttpServletRequest request) {
//		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
//		MultipartFile multipartFile = null;
//		while(iterator.hasNext()) {
//			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
//			if(multipartFile.isEmpty() == false) {
//				System.out.println("------------- file start -------------");
//				System.out.println("name : "+multipartFile.getName());
//				System.out.println("filename : "+multipartFile.getOriginalFilename());
//				System.out.println("size : "+multipartFile.getSize());
//				System.out.println("-------------- file end --------------\n");
//			}
//		}
		
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

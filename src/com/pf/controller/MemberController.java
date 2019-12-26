package com.pf.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController extends Member {

	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView LoginJSON(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("test", "testValue");
		jsonObject.put("haha", "YEAH");
		mav.addObject("jsonObject", jsonObject);
//		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
}

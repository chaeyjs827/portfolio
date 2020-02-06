package com.pf.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.pf.sao.MemberSao;

@Controller
public class MemberController extends Member {

	@Autowired
	MemberSao memberSao;
	
	@Autowired
	MessageSource messageSource;
	
	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView CreateJSON(HttpServletRequest request) throws Exception {
		Integer returnCode = 1;
		String returnMsg = null;
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");

		Map<String, Object> returnObj = null;

		if(StringUtils.isBlank(userID)) {
			returnCode = 10201;
			returnMsg = "userID must not be empty";
		}
		
		if(returnCode == 1) {
			if(StringUtils.isBlank(userPW)) {
				returnCode = 10202;
				returnMsg = "userPW must not be empty";
			}
		}
		
		if(returnCode == 1) {
			returnObj = memberSao.memberCreate(userID, userPW);
		}
		
		JSONObject jsonObject = new JSONObject();
		if(returnCode == 1) {
			jsonObject.put("returnCode", returnObj.get("returnCode"));
			jsonObject.put("returnMsg", returnObj.get("returnMsg"));
		} else {
			jsonObject.put("returnCode", returnCode);
			jsonObject.put("returnMsg", returnMsg);
		}
		
		ModelAndView mav = new ModelAndView("jsonView");
		
		mav.addObject("jsonObject", jsonObject);
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView LoginJSON(HttpSession session, HttpServletRequest request) throws Exception {
		String returnUrl = "";
		
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		
		Integer returnCode = 1;
		String returnMsg = null;
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");

		if(returnCode == 1) {
			if(StringUtils.isEmpty(userID)) {
				returnCode = 10001;
				returnMsg = "UserID must be not empty";
			}
		}
		
		if(returnCode == 1) {
			if(StringUtils.isEmpty(userPW)) {
				returnCode = 10002;
				returnMsg = "UserPW must be not empty";
			}
		}
		
		Map<String, Object> returnObj = null;
		JSONObject jsonObject = new JSONObject();
		
		if(returnCode == 1) {
			returnObj = memberSao.memberLogin(userID, userPW);
			jsonObject.put("returnCode", returnObj.get("returnCode"));
			jsonObject.put("returnMsg", returnObj.get("returnMsg"));
		} else {
			jsonObject.put("returnCode", returnCode);
			jsonObject.put("returnMsg", returnMsg);
		}
		
		System.out.println("returnCode : " + returnCode);
		
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("jsonObject", jsonObject);
		return mav;
	}
	
	@Override
	public ModelAndView LogoutJSON(HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/Index/Main");
		session.invalidate();
		session.removeAttribute("login");
		return mav;
	}
	
}

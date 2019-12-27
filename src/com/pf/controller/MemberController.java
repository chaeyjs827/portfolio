package com.pf.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.pf.sao.MemberSao;

@Controller
public class MemberController extends Member {

	@Autowired
	MemberSao memberSao;
	
	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView LoginJSON(HttpServletRequest request) throws Exception {
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
			returnObj = memberSao.testSao();
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
	
}

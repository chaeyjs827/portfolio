package com.pf.utils;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UtilsController extends Utils {

	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView fileupload(MultipartHttpServletRequest request) {
		System.out.println("request : " + request);
		
//		String returnFileName = StringUtils.EMPTY;
		int    returnCode = 1;
		String returnMsg = "success";
		
		//temp
		String returnFileName = "hello";
		
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put("fileName", returnFileName);
			jsonObj.put("returnCode",  returnCode);
			jsonObj.put("returnMsg", returnMsg);
		} catch (net.sf.json.JSONException e) {
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("returnObj", jsonObj);
		return mav;
	}
	
}

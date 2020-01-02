package com.pf.utils;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UtilsController extends Utils {

	@Override
	public ModelAndView fileupload(MultipartHttpServletRequest request) {
		System.out.println("request : " + request);
		
		String returnFileName = StringUtils.EMPTY;
		int    returnCode = 1;
		String returnMsg = "success";
		
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

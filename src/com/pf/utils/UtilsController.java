package com.pf.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UtilsController extends Utils {

	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView fileupload(MultipartHttpServletRequest request) {
		System.out.println("request : " + request);
		
		String returnFileName = StringUtils.EMPTY;
		int returnCode = (request.getFileMap() != null) ? 1 : 10001;
		String returnMsg = "success";
		
		if(returnCode == 1) {
			Set set = request.getFileMap().entrySet();
			Iterator i = set.iterator();
			
			String fileName = StringUtils.EMPTY;
			MultipartFile multipartFile = null;
			while(i.hasNext()) {
				Map.Entry me = (Map.Entry)i.next();
				String fileId = (String)me.getKey();

	            System.out.println("fileId : " + fileId + ", value : " + me.getValue());
	            
	            if (StringUtils.isNotEmpty(fileId) && me.getValue() != null) {
	            	multipartFile = (MultipartFile)me.getValue();
	            	fileName = multipartFile.getOriginalFilename();
	            	
	                System.out.println("Original fileName - " +  multipartFile.getOriginalFilename());
	                System.out.println("fileName - " + fileName);
	            }
			}
		}
		
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

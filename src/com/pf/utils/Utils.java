package com.pf.utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public abstract class Utils {

	@RequestMapping(value = {"/utils/fileupload"})
	public abstract ModelAndView fileupload(MultipartHttpServletRequest request);
	
}

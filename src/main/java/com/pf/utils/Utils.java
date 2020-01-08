package com.pf.utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.pf.config.ProjectConstants;

public abstract class Utils extends ProjectConstants {

	@RequestMapping(value = {"/utils/fileupload"})
	public abstract ModelAndView fileupload(MultipartHttpServletRequest request);
	
}

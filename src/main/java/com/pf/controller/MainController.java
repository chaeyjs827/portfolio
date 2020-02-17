package com.pf.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import com.pf.dao.ContentDao;
import com.pf.sao.MemberSao;

@Controller
public class MainController extends Main {

	final static Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	MemberSao memberSao;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	LocaleResolver localeResolver;
	
	@Autowired
	ContentDao contentDao;
	
	@Override
	public ModelAndView indexMain(HttpServletRequest request, Locale locale) {
		ModelAndView mav = new ModelAndView("legacyIndexMain");
		
		List<Map<String, Object>> portfolioList = contentDao.getPortfolioList();
		
		logger.info("[logger info]");
		logger.warn("[logger warn]");
		logger.error("[logger error]");
		logger.debug("[logger debug]");
		
		// 임시
//		mav.addObject("sessionStatus", "login");
		mav.addObject("sessionStatus", "logout");
		// 임시
		
		return mav;
	}
	
}

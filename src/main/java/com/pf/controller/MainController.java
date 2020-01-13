package com.pf.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

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
	
	@Override
	public ModelAndView indexMain(HttpServletRequest request, Locale locale) {
		ModelAndView mav = new ModelAndView("legacyIndexMain");
		Locale.setDefault(new Locale("en", "EN"));
		System.out.println("[clientLocale] : " + locale);
		System.out.println("[sessionLocale] : " + localeResolver.resolveLocale(request));
		
		
		
		logger.info("[logger info]");
		logger.warn("[logger warn]");
		logger.error("[logger error]");
		logger.debug("[logger debug]");
		
//		memberSao.testSao();
		return mav;
	}
	
}

package com.pf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.pf.sao.MemberSao;

@Controller
public class MainController extends Main {

	@Autowired
	MemberSao memberSao;
	
	@Override
	public ModelAndView indexMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("legacyIndexMain");
		memberSao.testSao();
		return mav;
	}
	
}

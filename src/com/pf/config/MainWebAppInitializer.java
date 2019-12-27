package com.pf.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MainWebAppInitializer implements WebApplicationInitializer{
	
	@Override
	public void onStartup(final ServletContext sc) throws ServletException {
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		root.scan("com.pf");
		
		// 스프링 ioc컨테이너를 , application-context를 servlet-application의 생명 주기에 맞춰 바인딩해줌
		sc.addListener(new ContextLoaderListener(root));
		
		ServletRegistration.Dynamic appServlet = sc.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");
	}
	
}

package com.pf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.pf.interceptor.MainInterceptor;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Bean
	MainInterceptor mainInterceptor() {
		return new MainInterceptor();
	}
	
	// tiles 사용_begin
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("classpath:com/pf/template/template-*.xml");
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
		registry.order(1);
	}
	// tiles 사용_finish

	// jsonView 사용_begin
	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView mj2jv = new MappingJackson2JsonView();
		mj2jv.setContentType("application/json;charset=UTF-8");
		return mj2jv;
	}
	// jsonView 사용_finish
	
	
	// message properties_begin
	// 메세지 소스 생성
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasename("classpath:/messages/message");	// 메세지 pp 위치 및 이름 지정
		source.setDefaultEncoding("UTF-8");
		source.setCacheSeconds(60);							// pp 파일 변경 감지 시간
		source.setUseCodeAsDefaultMessage(true);			// 예외 경우 기본 메세지 표시
		return source;
	}
	// 변경된 언어 정보를 기억할 로케일 리졸버 생성, 세션에 저장
	@Bean
	public SessionLocaleResolver localResolver() {
		return new SessionLocaleResolver();
	}
	// 언어 변경을 위한 인터셉터
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}
	// message properties_finish

	
	// fileupload_begin
	private final int MAX_SIZE = 10 * 1024 * 1024;
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setMaxUploadSize(MAX_SIZE);
		cmr.setMaxUploadSizePerFile(MAX_SIZE);
		cmr.setMaxInMemorySize(0);
		return cmr;
	}
	// fileupload_finish
	
	// 인터셉터 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
		registry.addInterceptor(mainInterceptor());
	}
	
	@Bean
	public ViewResolver viewResolver() {
		return new BeanNameViewResolver();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}

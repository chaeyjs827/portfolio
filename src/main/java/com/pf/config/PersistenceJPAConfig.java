package com.pf.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@PropertySource("classpath:com/black/config/db.properties")
@EnableTransactionManagement
public class PersistenceJPAConfig {
	
//	@Value("${jdbc.url}")
//	private String jdbcUrl;
//	
//	@Value("${jdbc.id}")
//	private String jdbcId;
//	
//	@Value("${jdbc.pw}")
//	private String jdbcPw;
//	
//	@Value("${jdbc.driver}")
//	private String jdbcDriver;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] {"com.pf.data.model"});
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		System.out.println(jdbcDriver);
//		System.out.println(jdbcUrl);
//		System.out.println(jdbcId);
//		System.out.println(jdbcPw);
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mariadb://localhost:3306/portfolio");
		dataSource.setUsername("root");
		dataSource.setPassword("dudwns12");
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	Properties additionalProperties() {
		Properties properties = new Properties();
//	    properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	    properties.setProperty("hibernate.hbm2ddl.auto", "create");
//	    properties.setProperty("hibernate.hbm2ddl.auto", "validate"); // 운용중일때는 이렇게 씀 
	    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	    properties.setProperty("hibernate.show_sql", "true");
	    properties.setProperty("hibernate.format_sql", "true");
		return properties;
	}
	
}

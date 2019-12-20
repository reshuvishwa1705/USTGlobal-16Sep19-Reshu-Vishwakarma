package com.ustglobal.libraryapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
@Configuration
public class ORMController {
	@Bean
	public LocalEntityManagerFactoryBean getBean() {
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("libraryapp-unit");
		return bean;
	}
}

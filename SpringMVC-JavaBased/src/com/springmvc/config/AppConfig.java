package com.springmvc.config;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com")
public class AppConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver itr = new InternalResourceViewResolver();
		itr.setSuffix(".jsp");

		return itr;
	}

	@Bean
	public DriverManagerDataSource ds() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springmvcjavabased");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean ls = new LocalSessionFactoryBean();
		ls.setDataSource(ds());

		Properties p = new Properties();

		p.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		p.setProperty(Environment.SHOW_SQL, "true");
		p.setProperty(Environment.HBM2DDL_AUTO, "update");

		ls.setHibernateProperties(p);

		ls.setPackagesToScan("com.springmvc");
		return ls;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cr = new CommonsMultipartResolver();
		return cr;
	}
}

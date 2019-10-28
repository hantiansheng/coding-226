package com.imooc.workflow.workflow;

import org.activiti.app.conf.ApplicationConfiguration;
import org.activiti.app.servlet.ApiDispatcherServletConfiguration;
import org.activiti.app.servlet.AppDispatcherServletConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

@SpringBootApplication(exclude = {
		SecurityAutoConfiguration.class,
		org.activiti.spring.boot.SecurityAutoConfiguration.class,
})
@Import({ApplicationConfiguration.class})
public class WorkflowApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WorkflowApplication.class,args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WorkflowApplication.class);
	}



	@Bean
	public ServletRegistrationBean apiDispatcher() {
		DispatcherServlet api = new DispatcherServlet();
		api.setContextClass(AnnotationConfigWebApplicationContext.class);
		api.setContextConfigLocation(ApiDispatcherServletConfiguration.class.getName());
		ServletRegistrationBean apiDispatcher = new ServletRegistrationBean(api);
		apiDispatcher.addUrlMappings("/api/*");
		apiDispatcher.setLoadOnStartup(1);
		apiDispatcher.setAsyncSupported(true);
		apiDispatcher.setName("api");
		return apiDispatcher;
	}

	@Bean
	public ServletRegistrationBean appDispatcher() {
		DispatcherServlet app = new DispatcherServlet();
		app.setContextClass(AnnotationConfigWebApplicationContext.class);
		app.setContextConfigLocation(AppDispatcherServletConfiguration.class.getName());

		ServletRegistrationBean appDispatcher = new ServletRegistrationBean(app);
		appDispatcher.addUrlMappings("/app/*");
		appDispatcher.setLoadOnStartup(1);
		appDispatcher.setAsyncSupported(true);
		appDispatcher.setName("app");
		return appDispatcher;
	}

	@Bean
	public FilterRegistrationBean openEntityManagerInViewFilter(){
		FilterRegistrationBean bean = new FilterRegistrationBean(new OpenEntityManagerInViewFilter());
		bean.addUrlPatterns("/*");
		bean.setName("openEntityManagerInViewFilter");
		bean.setOrder(-200);
		bean.setDispatcherTypes(EnumSet.of(DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.ASYNC));
		return bean;

	}
}

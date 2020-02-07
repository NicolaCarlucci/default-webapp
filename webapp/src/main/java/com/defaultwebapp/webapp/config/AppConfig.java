package com.defaultwebapp.webapp.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.defaultwebapp.webapp")
public class AppConfig extends WebMvcConfigurerAdapter {

	/**
	 * Configure ViewResolvers to deliver preferred views.
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}

	/**
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript
	 * etc...
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	/**
	 * Configure MessageSource to lookup any validation/error message in
	 * internationalized property files
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

//	    @Bean
//	    public CommonsMultipartResolver multipartResolver(){
//	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//	        multipartResolver.setDefaultEncoding("UTF-8");
//	        multipartResolver.setMaxUploadSize(-1);
//	        return multipartResolver;
//	    }
//	    
//	    /**Optional. It's only required when handling '.' in @PathVariables which otherwise ignore everything after last '.' in @PathVaidables argument.
//	     * It's a known bug in Spring [https://jira.spring.io/browse/SPR-6164], still present in Spring 4.1.7.
//	     * This is a workaround for this issue.
//	     */
//	    @Override
//	    public void configurePathMatch(PathMatchConfigurer matcher) {
//	        matcher.setUseRegisteredSuffixPatternMatch(true);
//	    }
//	    
//
//		@Bean
//		public RestTemplate defaultRestTemplate() {
//			RestTemplate restTemplate = new RestTemplate();
//			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//			restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
//			return restTemplate;
//		}

}
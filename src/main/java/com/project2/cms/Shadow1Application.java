package com.project2.cms;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Configuration
@EnableWebMvc
public class Shadow1Application {

	public static void main(String[] args) {
		SpringApplication.run(Shadow1Application.class, args);
	}




	@Bean
	public FilterRegistrationBean processCorsFilter() {
	final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	final CorsConfiguration config = new CorsConfiguration();
	config.setAllowCredentials(true);
	config.addAllowedOrigin("'");
	config.addAllowedHeader("*");
	config.addAllowedMethod("*");
	source.registerCorsConfiguration("/**", config);


	final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter());
	bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	return bean;
	}



}

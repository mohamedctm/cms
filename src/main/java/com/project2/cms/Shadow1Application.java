package com.project2.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Shadow1Application {

	public static void main(String[] args) {
		SpringApplication.run(Shadow1Application.class, args);
	}
	
	  @Bean
	  public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE",
	            "OPTIONS");
	      }
	    };
	  }
	  


}

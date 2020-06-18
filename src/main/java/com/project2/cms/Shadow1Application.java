package com.project2.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public WebMvcConfigurer corsConfigurer() {
  // We're defining the class we're using inline here as a shortcut.
  // You could create a separate file
  return new WebMvcConfigurer() {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE",
          "OPTIONS").allowedOrigins("*");
    }
    
  };
}



}

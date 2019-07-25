package com.food.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer{		

	@Bean
    public WebMvcConfigurer corsConfigurer() {		
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				WebMvcConfigurer.super.addCorsMappings(registry);
				//registry.addMapping("/**");
				registry.addMapping("/food-api/**")
				.allowedOrigins("http://localhost:4200")
				.allowedMethods("DELETE", "POST", "PUT", "GET")
				.allowCredentials(false).maxAge(3600);
			}
		};
        
    }

}

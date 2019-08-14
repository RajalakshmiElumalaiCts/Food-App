package com.food.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class to allow the api calls from angular food app. 
 * Needed while designing spring boot app to communicate with angular app.
 * It is  to support CROS origin http requests
 *
 */
@Configuration
//@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer{		

	@Bean
    public WebMvcConfigurer corsConfigurer() {		
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				WebMvcConfigurer.super.addCorsMappings(registry);
				registry.addMapping("/food-api/**")
				.allowedOrigins("http://localhost:4200")
				.allowedMethods("DELETE", "POST", "PUT", "GET")
				.allowCredentials(false).maxAge(3600);
			}
		};
        
    }
	
	 /**
	   * Unregister the default {@link StringHttpMessageConverter} as we want Strings
	   * to be handled by the JSON converter.
	   *
	   * @param converters List of already configured converters
	   * @see WebMvcConfigurationSupport#addDefaultHttpMessageConverters(List)
	   */
	/*
	 * @Override protected void
	 * extendMessageConverters(List<HttpMessageConverter<?>> converters) {
	 * converters.stream() .filter(c -> c instanceof StringHttpMessageConverter)
	 * .findFirst().ifPresent(converters::remove); }
	 */

}

package com.smarthunter.api.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    private static final String PRODUCTION_URL = "https://jolly-water-098b5eb10.azurestaticapps.net";
    private static final String DEVELOPMENT_URL = "http://localhost:3000";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(PRODUCTION_URL, DEVELOPMENT_URL)
                .allowedMethods("*")
                .allowCredentials(true);
    }
}

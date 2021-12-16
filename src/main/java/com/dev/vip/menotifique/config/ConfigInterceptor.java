package com.dev.vip.menotifique.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RequiredArgsConstructor
@Component
public class ConfigInterceptor extends WebMvcConfigurerAdapter {

    private final Interceptor inperceptor;
    private final long MAX_AGE_SECS = 3600;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(inperceptor);
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
                .maxAge(MAX_AGE_SECS);
    }

}

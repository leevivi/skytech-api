package com.skytech.api.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class AccessConfig extends WebMvcConfigurerAdapter {

    private final Logger LOGGER = LoggerFactory.getLogger(AccessConfig.class);

    @Bean
    AuthInterceptor localInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LOGGER.info("AccessConfig");
        registry.addInterceptor(localInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}

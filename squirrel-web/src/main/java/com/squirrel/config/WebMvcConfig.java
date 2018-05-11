package com.squirrel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 拦截跳转登录页
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
    }

    /**
     * 由于thymeleaf问题，设置此映射配置
     * @param resourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry){
        resourceHandlerRegistry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}

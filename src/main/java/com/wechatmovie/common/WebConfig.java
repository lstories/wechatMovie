package com.wechatmovie.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    JwtInterceptor jwtInterceptor;


    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // 指定controller统一的接口
        configurer.addPathPrefix("/api", clazz -> clazz.isAnnotationPresent(RestController.class));
    }


    // 加自定义拦截器JwtInterceptor，设置拦截规则
    // excludePathPatterns放开登录接口, 一开始没有token
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/api/**").excludePathPatterns("/api/admin/login");
    }


}

package com.fc.config;

import com.fc.interceptor.CustomInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("注册拦截器");
        registry.addInterceptor(new CustomInterceptor()).addPathPatterns("/**") //拦截所有请求，包括静态资源文件
                .excludePathPatterns(
                        "/static/**",
                        "login.jsp",
                        "/index.html",
                        "/user/login",
                        "/css/**",
                        "/js/**",
                        "/images/**",
                        "/fonts/**",
                        "/**/*.jpg",
                        "/**/*.jsp",
                        "/**/*.js",
                        "/**/*.css",
                        "/**/*.woff",
                        "/**/*.woff2",
                        "/**/*.ttf",
                        "/**/*.eot",
                        "/**/*.otf",
                        "/**/*.svg",
                        "/**/*.less",
                        "/**/*.scss",
                        "/**/*.jpg",
                        "/**/*.ico",
                        "/**/*.jpeg",
                        "/**/*.png",
                        "/**/*.bmp",
                        "/**/*.gif"); //放行登录页，登陆操作，静态资源
    }
}

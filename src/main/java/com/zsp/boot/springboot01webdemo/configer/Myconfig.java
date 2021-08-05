package com.zsp.boot.springboot01webdemo.configer;

import com.zsp.boot.springboot01webdemo.intercerptor.Loginintercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class Myconfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Loginintercepter()).addPathPatterns("/**")
        .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}

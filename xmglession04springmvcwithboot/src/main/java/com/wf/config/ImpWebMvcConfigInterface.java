package com.wf.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// 可以进行一些我们自定义的WebMvcConfigurer配置，
// 在1.8之前存在WebMvcConfigurerAdapter这个适配类，我们会继承这个，编写我们自己的逻辑，1.8之后新增了接口的默认方法，所以我们可以直接实现接口类
@Component
public class ImpWebMvcConfigInterface implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 在handler之前进行执行，handler就是我们的一个个方法
        HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("preHandle coming...");
                return true;
            }
        };
        registry.addInterceptor(handlerInterceptor);
    }
}

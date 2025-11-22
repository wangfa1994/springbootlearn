package com.wf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Spring Web MVC 配置（类）
 *
 * @author 小马哥
 * @since 2018/5/20
 */
@Configuration
//@EnableWebMvc  // boot中可以删除了 激活我们的mvc组件 ，这个配置类可以进行删除，这个是spring mvc的如果要使用boot可以增加相关配置
public class WebMvcSimpleConfig  {

//     <!--<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">-->
//        <!--<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>-->
//        <!--<property name="prefix" value="/WEB-INF/jsp/"/>-->
//        <!--<property name="suffix" value=".jsp"/>-->
//    <!--</bean>-->
    @Bean
    public ViewResolver viewResolver(){ // springboot 默认给我们添加的是不带路径，需要注意的是这个名字自动装配的时候已经存在了，他对应的是ContentNegotiatingViewResolver协商视图view
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}

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
@EnableWebMvc  // 激活我们的mvc组件 ，这个配置类可以进行删除，这个是spring mvc的如果要使用boot可以增加相关配置
public class WebMvcSimpleConfig  {

//     <!--<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">-->
//        <!--<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>-->
//        <!--<property name="prefix" value="/WEB-INF/jsp/"/>-->
//        <!--<property name="suffix" value=".jsp"/>-->
//    <!--</bean>-->
    @Bean
    public ViewResolver viewResolver(){ // EnableWebMvc激活的mvc组件存在资源文件找不到问题进行追加添加，组件默认的不会进行覆盖，只会追加
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}

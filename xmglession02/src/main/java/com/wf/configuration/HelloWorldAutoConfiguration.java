package com.wf.configuration;

import com.wf.annotation.EnableHelloWorld;
import com.wf.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HelloWorld 自动装配
 *
 * @author 小马哥
 * @since 2018/5/15
 */
//@Configuration // Spring 模式注解装配
//@EnableHelloWorld // Spring @Enable 模块装配
//@ConditionalOnSystemProperty(name = "user.name", value = "Administrator") // 条件装配
public class HelloWorldAutoConfiguration {

    @Bean
    public String helloWorld() { // 方法名即 Bean 名称
        return "Hello,World 2018";
    }
}

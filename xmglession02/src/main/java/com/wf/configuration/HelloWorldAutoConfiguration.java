package com.wf.configuration;

import org.springframework.context.annotation.Bean;

/**
 * HelloWorld 自动装配
 *
 * @author 小马哥
 * @since 2018/5/15
 */

public class HelloWorldAutoConfiguration {

    @Bean
    public String helloWorld() { // 方法名即 Bean 名称
        System.out.println("通过EnableAuto自动装配到上下文中");
        return "Hello,World 2018";
    }
}

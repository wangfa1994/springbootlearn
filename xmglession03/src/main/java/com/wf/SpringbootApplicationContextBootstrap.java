package com.wf;

/*
*  springboot 的ApplicationContext 应用上下文类型的引导类
*
* */

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootApplicationContextBootstrap {


    public static void main(String[] args) {

        webApplication(args);
        notWebApplication(args);
    }


    public static void webApplication(String[] args){

        // 默认就是 servlet
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(SpringbootApplicationContextBootstrap.class)
                .web(WebApplicationType.SERVLET)
                .run(args);

        //  org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext
        System.out.println("webApplication的 ApplicationContext 类型 : "+applicationContext.getClass().getName());
        // org.springframework.web.context.support.StandardServletEnvironment
        System.out.println("webApplication的 Environment 类型 : "+applicationContext.getEnvironment().getClass().getName());
        applicationContext.close();

    }

    public static void notWebApplication(String[] args){

        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(SpringbootApplicationContextBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // org.springframework.context.annotation.AnnotationConfigApplicationContext
        System.out.println("notWebApplication 的 ApplicationContext 类型 : "+applicationContext.getClass().getName());

        // org.springframework.core.env.StandardEnvironment
        System.out.println("notWebApplication 的 Environment 类型 : "+applicationContext.getEnvironment().getClass().getName());

        applicationContext.close();

    }

    /* 需要引入 reactive 相关jar包pom  */
    public static void reactiveApplication(String[] args){

        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(SpringbootApplicationContextBootstrap.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);

        // org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext
        System.out.println("reactiveApplication 的 ApplicationContext  类型 : "+applicationContext.getClass().getName());

        // org.springframework.core.env.StandardEnvironment
        System.out.println("reactiveApplication 的 Environment 类型 : "+applicationContext.getEnvironment().getClass().getName());

        applicationContext.close();

    }
}

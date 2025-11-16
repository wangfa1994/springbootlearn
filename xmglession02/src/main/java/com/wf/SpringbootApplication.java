package com.wf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc   // 注解编程模式
@EnableCaching // 接口编程模式
@Profile("dev")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }


    public static void springBootStart(String[] args){
        SpringApplication build = new SpringApplicationBuilder(SpringbootApplication.class).
                web(WebApplicationType.NONE)
                .build(args);



    }

}

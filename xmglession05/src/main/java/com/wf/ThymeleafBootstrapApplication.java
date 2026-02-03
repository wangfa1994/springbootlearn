package com.wf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ThymeleafBootstrapApplication {
    public static void main(String[] args) {

        SpringApplication.run(ThymeleafBootstrapApplication.class,args);

    }
}

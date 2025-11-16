package com.wf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wf")
public class BootstrapSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapSpringbootApplication.class,args);
    }
}

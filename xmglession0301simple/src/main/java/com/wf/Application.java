package com.wf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
//@EnableAutoConfiguration(exclude = {SpringApplicationAdminJmxAutoConfiguration.class})
@SpringBootApplication
public class Application {

    @RequestMapping("/hello")
    @ResponseBody
    String home(){
        return "hello";
    }


    public static void main(String[] args) throws IOException {

        SpringApplication.run(Application.class,args);

    }
}

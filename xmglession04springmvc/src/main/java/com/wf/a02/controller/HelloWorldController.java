package com.wf.controller;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController /*implements EnvironmentAware*/ {

    // http://localhost:8080/index?name=zhangsan
    @RequestMapping("/index")
    public String index(Model model,@RequestParam("name") String name) {
        System.out.println("name"+name);
        model.addAttribute("hello","hello"+name);
        return "index";
    }


    @ModelAttribute("message")
    public String message(){
        return "Hello,World";
    }

    // http://localhost:8080/modelParam
    @RequestMapping("/modelParam")
    public String model1(Model model) {
        System.out.println();
        model.addAttribute("message"," hello model");

        return "model";
    }


   /* @Override
    public void setEnvironment(Environment environment) {

        System.out.println("Environment:"+environment); //StandardServletEnvironment 类 这个环境封装了ServletConfig,系统属性等
    }*/


    /**
     *
     *
     *
     *
     */
}

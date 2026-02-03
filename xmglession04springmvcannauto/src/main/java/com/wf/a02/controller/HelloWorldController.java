package com.wf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    //1 最简单实例  http://localhost:8080
    @RequestMapping("")
    public String index() {
        System.out.println("hello index");
        return "index";
    }
}

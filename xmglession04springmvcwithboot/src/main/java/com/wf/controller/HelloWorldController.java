package com.wf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //1 最简单实例  http://localhost:8080/exception/index 不传递参数，导致报错，会被@ControllerAdvice 和 @ExceptionHandler的类CommonException给拦截
    @RequestMapping("/index")
    public String index(@RequestParam("age") int age) {

        return "index";
    }
}

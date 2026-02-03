package com.wf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HelloWorld {@link Controller}
 *
 * @author 小马哥
 * @since 2018/5/24
 */
@Controller
public class HelloWorldController {


    //  http://127.0.0.1:8080/thymeleaf
    @GetMapping("/thymeleaf")
    public String helloWorld() {

        // View 逻辑名称
        return "hello-world";
    }

    // http://127.0.0.1:8080/jsp 这个用于找到对应的JSP页面
    @RequestMapping("/jsp")
    public String index(@RequestParam(required = false,defaultValue = "0") int value, Model model) {
        return "index";
    }



    @ModelAttribute("message") // ModelAttribute一定要指定对应的名称
    public String message() {
        return "HelloWorld";
    }
}

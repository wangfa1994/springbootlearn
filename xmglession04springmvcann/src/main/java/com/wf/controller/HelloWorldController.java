package com.wf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    //1 最简单实例  http://localhost:8080
    @RequestMapping("")
    public String index() {

        return "index";
    }


    //2 添加model实例 http://localhost:8080/model
    @RequestMapping("/model")
    public String model(Model model) {
        // 通过Model 可以讲我们的后台数据传递到jsp页面上面
        model.addAttribute("message","hello world");
        return "model";
    }

    //3 使用注册模型属性： @ModelAttribute 进行注册我们的属性 ，作用范围好像是整个Controller http://localhost:8080/modelAnn
    @ModelAttribute("message")
    public String message(){
        return "hello world";
    }
    @RequestMapping("/modelAnn")
    public String model1(Model model) {
        return "model";
    }



    //4.常用读取请求数据注解  @RequestHeader 读取请求头   @CookieValue 读取 Cookie   http://localhost:8080/oftenUseAnn
    @RequestMapping("/oftenUseAnn")
    public String oftenUseAnn(@RequestHeader("accept-language") String acceptLanguage,
                              @CookieValue("JSESSIONID") String jsessionId,
                              Model model) {
        // 通过Model 可以讲我们的后台数据传递到jsp页面上面
        model.addAttribute("acceptLanguage",acceptLanguage);
        model.addAttribute("jsessionId",jsessionId);
        return "model";
    }

    // 可以修改为通用的方法，这样的话，所有的都会存在这两个属性了，没有必要每次都要进行设置了  ModelAttribute模型注解的方法优先handler方法的执行
    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("accept-language") String acceptLanguage){
        return acceptLanguage;
    }
    @ModelAttribute("jsessionId")
    public String jsessionId(@CookieValue("JSESSIONID") String jsessionId){
        return jsessionId;
    }


}

package com.wf.advice;

import com.wf.controller.RepeatLogicAdviceController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

// @ControllerAdvice 用于提取一个Controller 所有handler的公共逻辑，不指定type的时候是所有的controller都会适配
@ControllerAdvice(assignableTypes = RepeatLogicAdviceController.class)
public class RepeatLogicAdvice {

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

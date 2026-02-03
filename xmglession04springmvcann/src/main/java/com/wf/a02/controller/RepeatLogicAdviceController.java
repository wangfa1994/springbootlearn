package com.wf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/repeat")
public class RepeatLogicAdviceController {

    //  与@ControllerAdvice 注解的 RepeatLogicAdvice类配合使用依然可以得到相关结果 逻辑提取，更好的封装性
    @RequestMapping("/model") //  http://localhost:8080/repeat/model
    public String model1(Model model) {
        return "model";
    }
}

package com.wf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    // 127.0.0.1:8080/hello
    @GetMapping(value = "/hello")
    public String  helloWorld(){
        return "hello.world";
    }

    // http://127.0.0.1:8080/helloP?num=12
    @GetMapping(value = "/helloP")
    public String  helloWorldParam(@RequestParam("num") Integer num){
        return "hello.world："+num;
    }
}


/* DispatcherServlet 为入口
*
*  DispatcherServlet 接收请求
*  HandlerMapping 查找对应的 Handler ,保存请求链接和对应的方法关联，客户请求到Controller映射 内置了7个handlerMapping
*        SimpleUrlHandlerMapping  RequestMappingHandlerMapping  WebMvcConfigurationSupport$EmptyHandlerMapping
*        BeanNameUrlHandlerMapping SimpleUrlHandlerMapping  WebMvcConfigurationSupport$EmptyHandlerMapping  WelcomePageHandlerMapping
*
*  HandlerAdapter 调用 Handler处理方法 进行逻辑处理   Mvc的流程编排接口SPI
*
* 执行 HandlerInterceptor 的 preHandle
*
* HandlerMethod InvocableHandlerMethod

* handlerMapping存在mappingRegistry属性，这里封装了我们的映射到方法界别的
* 方法会被封装为 RequestMappingInfo
*






Controller 处理请求，返回 ModelAndView

执行 HandlerInterceptor 的 postHandle

ViewResolver 解析视图名

View 渲染视图

执行 HandlerInterceptor 的 afterCompletion
*
* */


/*
*  根据URL找到对应的HandlerMapping,从HandlerMapping 中得到HandlerExecutionChain，
*  从HandlerExecutionChain中得到我们的HandlerAdapter，HandlerAdapter进行执行handler方法得到我们的ModelAndView
*  执行
* */
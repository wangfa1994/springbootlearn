package com.wf.springbootlearn.a01.web;

public class Main {

    /*
    * Web MVC视图：模版引擎，内容协商，异常处理等
    *   ViewResolver View 这两个接口是总览的，通过我们的ViewResolver可以得到我们的View，然后在View中的方法存在数据，进行渲染
    * 存在三种视图的模板引擎： Thymeleaf Freemarker 和JSP ，这么多视图的模板引擎，我们需要怎么找到对应的，这个时候就需要内容协商
    * 内容协商包括 ContentNegotiationConfigurer , ContentNegotiationStrategy  ContentNegotiatingViewResolver 进行处理
    *
    * 异常处理包括 在springmvc中  @ExceptionHandler   HandlerExceptionResolver-->ExceptionHandlerExceptionResolver
    *  spring boot 中 BasicErrorController(springboot 白页的处理)
    *
    *
    * web mvc rest :资源服务，资源跨域 服务发现等
    *
    *  资源服务   @requestMapping @GetMapping @PostMapping @ResponseBody @RequestBody
    *
    *  资源跨域  mvc的解决方案 注解驱动@CrossOrigin  bean驱动 WebMvcConfigurer  传统解决跨域方案 IFrame 和  jsonp
    *
    *
    *
    *  web mvc 核心： 核心架构 处理流程 核心组件
    *
    *
    * 核心组件  DispatcherServlet    HandlerMapping HandlerAdapter  ViewResolver  ModelAndView
    *
    *
    * */
}

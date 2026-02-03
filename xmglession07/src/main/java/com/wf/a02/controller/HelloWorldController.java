package com.wf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class HelloWorldController {

    //1 最简单实例  http://localhost:8080/helloWorld
    @RequestMapping("helloWorld")
    public DeferredResult<String> index() {
        DeferredResult<String> deferredResult = new DeferredResult<>();
        System.out.println("hello index");

        deferredResult.onTimeout(()->{
            System.out.println(Thread.currentThread().getName()+"：超时处理");
        });

        deferredResult.onCompletion(()->{
            System.out.println(Thread.currentThread().getName()+"：完成处理");
        });

        System.out.println("会一直阻塞吗，会直接进行业务逻辑的后续处理，但是前端会一直转圈圈");

        //deferredResult.setResult("hello index");

        return deferredResult;
    }
}

package com.wf;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ThymeleafDemo {

    public static void main(String[] args) throws IOException {
       // thymeleaf();

        thymeleafWithSpring();
    }

    private static void thymeleaf() {
        //
        // 1.构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // 2.创建渲染上下文
        Context context = new Context();
        context.setVariable("message", "Hello,World");
        // 3.模板的内容
        String content = "<p th:text=\"${message}\">!!!</p>";
        // 4.渲染（处理）结果
        String result = templateEngine.process(content, context);
        // 输出渲染（处理）结果
        System.out.println(result);
    }

    //  Thymeleaf 与 Spring 资源整合
    private static void thymeleafWithSpring() throws IOException {

        // 构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // 创建渲染上下文
        Context context = new Context();
        context.setVariable("messages", "Hello,World");

        // 模板的内容通过Spring 的资源进行加载
        String resourcePath = "classpath:/templates/thymeleaf/helloworld.html";

        // 使用Spring的相关类进行处理资源
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(resourcePath);
        File file = resource.getFile();

        InputStream inputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOUtils.copy(inputStream,outputStream);
        inputStream.close();

        String content = outputStream.toString(StandardCharsets.UTF_8.name());

        String process = templateEngine.process(content, context);
        System.out.println(process);



    }
}

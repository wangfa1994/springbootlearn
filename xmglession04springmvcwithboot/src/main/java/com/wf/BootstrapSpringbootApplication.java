package com.wf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
*  第四章的 4-18重构Spring web Mvc 项目
* */
@SpringBootApplication(scanBasePackages = "com.wf")
public class BootstrapSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapSpringbootApplication.class,args);
    }


/**
 *      *  jsp 整合Spring web mvc
 *      *  视图解析器 InternalResourceViewResolver
 *       视图   JstlView
 *
 * 1. 引入相关pom 并且修改打包方式为<packaging>war</packaging>
 * 2.  我们的jsp 放置的位置是在main下的webapp ,这个来自 DocumentRoot类
 * 3.  使用黑窗体 进入到我们的项目目录 xmglession04springmvcwithboot 进行打包
 *       mvn -Dmaven.test.skip -U clean package
 * 4. 打包之后进入target目录进行执行 java -jar xmglession04springmvcwithboot-0.0.1-SNAPSHOT.war
 * 5. 浏览器进行打开 http://127.0.0.1:8080/index 展示正常
 *
 * 这个不适合在idea中存在父pom的情况，因为父pom的路径保存不对  【maven多模块JSP定位问题】
 * 如果在idea中启动的话，进行访问的时候会报错 找不到页面
 *
 *
 */

}

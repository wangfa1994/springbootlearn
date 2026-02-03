package com.wf.support;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
*  通过此配置进行 spring web mvc 的自动装配
*  这个是用来代替Servlet的web.xml配置的，可以将我们的Servlet 的 web.xml的配置通过类进行装载
* */
@Configuration
@ComponentScan(basePackages = "com.wf")
public class DefaultAnnotationConfigDispatcherServletInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { // 这个表示是web.xml
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { // 这个是web.xml配置的DispatcherServlet相关
        return new Class[]{DefaultAnnotationConfigDispatcherServletInitializer.class};

    }

    @Override
    protected String[] getServletMappings() { // 这个是映射路径
        return new String[]{"/"};
    }
}

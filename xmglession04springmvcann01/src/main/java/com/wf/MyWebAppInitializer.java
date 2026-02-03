package com.wf;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) {
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("/WEB-INF/app-context.xml");

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

    /*
    *  WebApplicationInitializer 属于spring mvc 提供的接口，确保WebApplicationInitializer 自定义实现能够被任何Servlet3容器侦测并自动地实现初始化。
    *  如果实现WebApplicationInitializer接口比较困难，也可以实现简洁化实现方案。 我们自定义实现 AbstractDispatcherServletInitializer。 进行注册我们的DispatcherServlet
    *
    *  AbstractAnnotationConfigDispatcherServletInitializer 是spring给我们的一个实现。我们可以直接使用这个抽象类
    *
    * */
}

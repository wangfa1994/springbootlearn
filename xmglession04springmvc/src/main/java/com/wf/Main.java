package com.wf;

public class Main {

    /**
     *   Spring Framework 时代的一般认识 三个步骤配置一个servlet ：
     *   1.实现 Controller
     *
     *   2.配置 Web MVC 组件
     *    1. 在web.xml中添加我们自己的servlet与servlet引擎进行连接
     *      需要配置我们的servlet 和 servletMapping
     *    2. 配置我们的项目引用
     *      添加我们的app-context.xml文件处理 进行配置我们的web相关资源
     *
     *   3.部署 DispatcherServlet
     *
     *   可以使用内置插件，配置在pom中的插件模块，tomcat7-maven-plugin
     *   也可以直接部署到我们的Tomcat中
     *
     *
     * Spring Framework 时代的重新认知 三个
     * 1.  spring Mvc 的 核心组件
     *    1.1 处理器管理
     *      映射 HandlerMapping
     *      适配器 HandlerAdapter
     *      执行器 HandlerExecutionChain
     *
     *    1.2 页面渲染
     *      视图解析 ViewResolver
     *      国际化 LocaleResolver LocaleContextResolver
     *      个性化 ThemeResolver
     *      文件上传 MultipartResolver
     *
     *    1.3 异常处理
     *    HandlerExceptionResolver
     *
     *
     *
     * 2. spring mvc的注解驱动
     * 2.1 基本流程
     *  注解配置 @Configuration(spring范式注解)
     *  组件激活 @EnableWebMvc(spring模块注解)
     *  自定义组件 WebMvcConfigurer(spring bean)
     *
     * 2.2 注解驱动
     * 模型属性  @ModelAttribute
     * 请求头 @RequestHeader
     * Cookie: @CookieValue
     * 参数校验：@Valid @Validated
     * 异常处理@ExceptionHandler
     * 切面通知：@ControllerAdvice
     *
     *
     * 3. springmvc的自动装配
     *  这个需要Servlet 3.0+版本，在这个版本新增了一个 Servlet SPI:ServletContainerInitializer,在Servlet容器启动的时候可以进行回调，这个SPI 通过参数ServletContext，可以动态的进行装载我们的Servlet
     *  Spring针对这个SPI进行了适配SpringServletContainerInitializer，
     *  在这个适配上有抽象类自己的Spring SPI: WebApplicationInitializer
     *  编程方式：通过spring给我们提供的抽象驱动类进行扩展 AbstractDispatcherServletInitializer
     *  注解方式：通过注入这个类来进行扩展 AbstractAnnotationConfigDispatcherServletInitializer
     *
     */

    /*
    *  DispatcherServlet 类 流程
    *  org.springframework.web.servlet.FrameworkServlet.service
    *  org.springframework.web.servlet.DispatcherServlet.doDispatch
    *  org.springframework.web.servlet.DispatcherServlet.getHandler
    *  org.springframework.web.servlet.DispatcherServlet.getHandlerAdapter
    *  org.springframework.web.servlet.DispatcherServlet.resolveViewName
    *
    *  启动过程中通过DispatcherServlet类中的initXXX方法进行相关bean的注入,变成其对应字段的值
    *  org.springframework.web.servlet.DispatcherServlet.initHandlerAdapters
    *  org.springframework.web.servlet.DispatcherServlet.initHandlerMappings
    *
    *
    *
    *
    *
    * */
}

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
    * springmvc创建流程
    *
    * DispatcherServlet 是最主要的类，向上继承了FrameworkServlet,HttpServletBean,并且实现了 ApplicationContextAware，EnvironmentAware，EnvironmentCapable, EnvironmentAware接口
    *
    * 环境类：StandardServletEnvironment
    *
    * servlet常见的时候可以直接调用无法的init方法，在HttpServletBean中的init方法是主要入口,方法中调用抽象方法initServletBean进行初始化我们的bean，
    * 这个被FrameworkServlet抽象类实现initServletBean方法，从这里进行我们的入口，这个方法主要进行了webApplicationContext的初始化，
    * 在初始化webApplicationContext应用上下文的时候，进行了三件事的处理，获取spring的根容器rootContext，设置webApplicationContext并根据情况调用onRefresh方法
    * 将webApplicationContext设置到ServletContext中。 XmlWebApplicationContext是我们产生的容器上下文，并且添加了SourceFilteringListener监听器，这个监听器
    * 触发的时候会调用FrameworkServlet.onApplicationEvent方法，最终会尽性调用DispatcherServlet.onRefresh的方法，完成初始化
    * 给我们的应用上下文添加监听器之后，会进行执行refresh方法，开始进行我们的容器的刷新，这个流程就是spring容器的刷新方法。进行beanDefinition的创建，进行后置器的处理，进行bean的创建。
    * 创建完成之后，就会通过监听器回到DispatcherServlet.onRefresh方法中，进行Servlet的初始化。
    * DispatcherServlet会进行初始化9个组件。如果我们得不到我们自定义的相关组件的类的话，springmvc会通过默认的DispatcherServlet.properties文件中配置的信息进行相关类的初始化。
    *
    *
    * springmvc处理请求
    * DispatcherServlet  FrameworkServlet    HttpServletBean
    * LocaleContext 接口定义了 获取本地化信息的规范，Locale，
    * RequestAttributes 接口定义了属性获取的规范，ServletRequestAttributes是他的实现类。用来管理request和session的属性。
    * RequestContextHolder和LocaleContextHolder 工具类封装了ThreadLocal，将对应的RequestAttributes和LocaleContext进行了保存，可以方便使用
    *
    * HttpServletBean 主要参与创建工作，不涉及请求的处理。
    *
    *
    * FrameworkServlet 重新了Servlet的service ,doGet,doPost,doPut 等，除了doHead没有重写。通过重新对应的方法，但是逻辑都是被转到了processRequest中进行统一处理。
    * processRequest方法进行了一些简单的参数处理，LocaleContext，RequestAttributes，ServletRequestAttributes等。并且设置到RequestContextHolder和LocaleContextHolder中。
    * FrameworkServlet 将他们统一到processRequest方法中，然后再收归到doService方法，而doService方法则被DispatcherServlet进行实现，这样的话，就转到了DispatcherServlet
    * 然后通过doService和doDispatcher进行正在的业务逻辑处理
    *
    * DispatcherServlet的doService 主要是做了一下快照备份，属性设置工作。
    * include请求会进行快照备份。属性则是设置了WebApplicationContext，localeResolver，themeResolver，ThemeSource。这些主要用于handler和View中。
    * 还有一个就是针对flushMap的使用设置。
    *
    * 主要是doDispatch进行的具体处理。包括4个核心流程。
    * 1.根据request找到Handler
    * 2.根据Handler找到对应的HandlerAdapter。
    * 3.用HandlerAdapter处理Handler
    * 4.调用processDispatchResult方法处理结果，找到View并渲染给用户。
    *
    * Handler：处理器。对应的是mvc中的Controller层，表现形式可以是类，可以是方法。我们标注的了RequestMapping的所有方法都可以看作是Handler，只要可以处理请求，都可以是Handler。
    * HandlerMapping：用来查找Handler的，怎么找打Handler呢，通过请求，他们怎么绑定呢，通过HandlerMapping，每个请求都需要一个Handler进行处理，具体收到请求使用那个Handler，这个就是HandlerMapping要处理的事情。
    * HandlerAdapter：因为spring的Handler可以是任意形式的。只要能处理我的请求即可。但是Servlet需要处理的方法的结构都是固定的，都是以request和response为请求参数的方法，
    * 怎么让固定的Servlet处理方法调用灵活的Handler来进行处理呢，这个就是HandlerAdapter要做的事情
    *
    * Handler是干活的工具，HandlerMapping通过请求找到干活的工具。谁来使用工具干活呢，HandlerAdapter。HandlerAdapter是使用工具的人。
    *
    * View 和 ViewResolver 他们也是一组的，View用来展示数据，ViewResolver是用来查找匹配的View。找到对应的View之后，使用View来展示数据。
    *
    * 使用HandlerMapping来找到干活的工具Handler， 找到工具之后，再找到使用工具的HandlerAdapter，然后HandlerAdapter使用Handler干活得到View。
    *
    *
    * doDispatch方法内部结构的整体流程，主要分为两个部分：处理请求和渲染页面
    * 1. 首先检查是否是上传请求。
    * 2. 根据request找到Handler
    * 3. 根据Handler找到HandlerAdapter
    * 4. 处理GET，HEAD请求的Last-Modified
    * 5. 执行相应的Interceptor的preHandler
    * 6. HandlerAdapter使用Handler处理请求，得到view。
    * 7. 如果需要异步处理直接返回。
    * 8. 设置默认的View。当View为空时(Handler返回了void)，使用根据request设置默认的View。
    * 9. 执行相应的Interceptor的postHandle方法
    * 10. 处理返回结果，包括异常处理，渲染页面，发出完成通知触发Interceptor的afterCompletion
    * finally中
    * 11. 判断是否执行异步请求。
    * 12. 删除上传请求的资源
    *
    * HttpServletRequest变量：实际处理是所用到的request。
    * HandlerExecutionChain变量：处理请求的处理链，包含了处理器handler和拦截器HandlerInterceptor
    * multipartRequestParsed变量 上传请求标志。
    * ModelAndView 变量：Model 和View的容器，
    * dispatchException变量：请求过程中抛出的异常，不包括渲染过程中的异常。
    *
    * 在处理文件的时候使用 MultipartResolver 接口进行处理。
    * 在设置默认View的时候使用 RequestToViewNameTranslator 接口进行处理viewNameTranslator
    *
    * 在异常处理的时候包括了内外两层，内存请求处理异常之后，使用processDispatchResult进行处理，
    * 外层则是处理processDispatchResult时发生的异常。
    * processDispatchResult处理异常的流程主要是将相应的错误设置到View中，会使用对应的HandlerExceptionResolver处理
    * 设置好了ModelAndView之后，会进行render方法的处理，进行页面的具体渲染。。
    * 在render的时候，首先会设置response的locale，然后从View中得到viewName，然后通过viewResolvers处理ViewName得到View。
    * 然后调用View的render方法进行渲染，渲染的过程中会使用ThemeResolver.
    * 一切完成之后，再通过mappingHandler的triggerAfterCompletion方法进行触发Interceptor的afterCompletion
    *
    *
    * */
}

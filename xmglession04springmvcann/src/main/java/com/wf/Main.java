package com.wf;

public class Main {

    /**
     *  基于注解的 spring mvc
     *
     *  1.注解配置 @Configuration(spring范式注解)  指明类文件为配置文件，使得spring可以进行加载配置
     *
     *  2.组件激活 @EnableWebMvc(spring模块注解) 这里会进行默认设置我们的配置文件中的一些bean
     *  可以看到DispatchServlet中的 handlerMappings handlerAdapters  viewResolvers 进行了一些默认的设置
     *  但是 viewResolvers 中的视图解析器是错误的,没有前缀和后缀，需要我们进行修改,
     *
     *  @EnableWebMvc导入了DelegatingWebMvcConfiguration类
     *  这是一个配置类，在这个配置类中通过父类WebMvcConfigurationSupport中的@Bean进行了一些默认bean的创建
     *
     *
     *  启动过程中通过DispatcherServlet类中的initXXX方法进行相关配置的bean的注入，变成其对应字段的值
     *  org.springframework.web.servlet.DispatcherServlet.initHandlerAdapters
     *  org.springframework.web.servlet.DispatcherServlet.initHandlerMappings
     *
     *  3.自定义组件 WebMvcConfigurer(spring bean)
     *
     *   实现WebMvcConfigurer接口，进行我们自定义组件配置
     *
     *  @EnableWebMvc导入了DelegatingWebMvcConfiguration类
     *   DelegatingWebMvcConfiguration#setConfigurers(java.util.List) 这个利用了spring的自动注入@autowire,进行注入了我们的自定义的配置
     *   这里利用了组合模式和代理模式，会通过WebMvcConfigurerComposite 进行组合我们所有的自定义配置，然后在执行的过程中委派给实际对象
     *
     *
     * spring mvc 的组件我们不需要写任何的代码可以直接进行配置，这个要归功于@EnableWebMvc注解，通过这个注解给我们自动注入了许多默认配置bean
     *
     *
     *
     * spring mvc 常用注解
     * 模型属性  @ModelAttribute  模型注解的方法优先handler方法的执行
     * 请求头 @RequestHeader
     * Cookie: @CookieValue
     * 参数校验：@Valid @Validated
     * 异常处理@ExceptionHandler   异常处理配合ControllerAdvice 可用作通用异常处理，这个是很常用的一个应用场景
     * 切面通知：@ControllerAdvice    这个用于针对Controller的通用业务逻辑的提取
     *
     */
}

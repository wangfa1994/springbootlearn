package com.wf;

public class A01HandlerMappingAnalysis {

    /**
     * HandlerMapping 接口 主要的规范就是根据 HttpServletRequest 请求得到对应的 HandlerExecutionChain 包括 Handler和 Interceptor
     * 分为两个分支 AbstractUrlHandlerMapping 和 AbstractHandlerMethodMapping两个
     *
     * AbstractHandlerMapping抽象类实现类HandlerMapping并且定义了自己的抽象方法getHandlerInternal,用于获得对应的handler，
     * 然后自己则实现类拦截器的获取，这样的话，子类只需要处理得到对应的Handler即可，拦截器的实现给统一实现了，毕竟拦截器都是相同的。
     * 因为Handler返回的是Object对象，所以你也可以直接返回为HandlerExecutionChain，这样的话就会覆盖了统一获得拦截器的逻辑。
     *
     * AbstractHandlerMapping抽象类继承了WebApplicationObjectSupport，并且向上继承了ApplicationObjectSupport。
     * ApplicationObjectSupport实现了ApplicationContextAware，具备了aware接口的功能，并且在回调设置ApplicationContext的
     * 时候进行了初始化我们的应用上下文方法的调用initApplicationContext。这个也是一个抽象方法，不同的子类有不同的实现，用于完成自己的功能
     * WebApplicationObjectSupport进行了实现，并且进行了自己的抽象方法initServletContext的调用，用来初始化我们的ServletContext上下文。
     * 但是AbstractHandlerMapping也进行了initApplicationContext的实现。主要添加 自己的功能，直接覆盖了 WebApplicationObjectSupport的实现
     *
     * AbstractHandlerMapping的initApplicationContext方法中，主要做的事情就是处理我们的Interceptors,从容器中找到所有的MappedInterceptor类型的bean
     * 添加到自己属性adaptedInterceptors中，这样的话，自己就可以统一处理拦截器了，统一封装成了 HandlerInterceptor
     *
     * AbstractHandlerMapping的拦截器主要被两个字段承载：interceptors  和 adaptedInterceptors
     *
     *
     *
     * AbstractUrlHandlerMapping体系
     * 通过URL来进行匹配对应的Handler，将对应的URL和Handler 保存在一个Mao中，在getHandlerInternal抽象方法的实现中就是通过Map匹配获取。
     * 那么需要理解的是我们的这个Map在哪里进行初始化的呢？这个是通过registerHandler方法进行的。map的得到有两种方式，一种是手动配置在配置文件中，一种是spring容器中查找。
     * SimpleUrlHandlerMapping 是这个类的实现。
     * 而针对BeanNameUrlHAndlerMapping来说则是检查beanName和alias是否以/开头，如果是则作为url处理。
     * AbstractControllerUrlHandlerMapping 是 Spring MVC 早期基于 约定优于配置 的 URL 映射机制的一部分（例如，将 /hello.do 映射到 HelloController）。随着 Spring 2.5+ 引入 @RequestMapping 注解，以及后续 Spring 3.0+ 对 @Controller 和 @RestController 的全面支持，这种旧的映射方式逐渐被淘汰
     * 这个应该是你将类作为Handler使用。
     *
     * AbstractHandlerMethodMapping体系，这个是重点，将Method作为Handler使用
     * RequestMappingInfoHandlerMapping是抽象类， 而RequestMappingHandlerMapping 则是最终实现类，这种是适配了@RequstMapping注解的方式
     *
     * AbstractHandlerMethodMapping顶级抽象类中存在存在一个变量MappingRegistry，这个中保存着我们的映射关系
     *
     * AbstractHandlerMethodMapping实现类InitializingBean，这个会在实例化的时候，通过回调进行我们url和Method的映射关系的处理，initHandlerMethods。
     *
     * 通过后置方法进行了映射关系的处理，并且放置到MappingRegistry中
     *  isHandler是AbstractHandlerMethodMapping的抽象方法，RequestMappingHandlerMapping进行了实现，检查@Controller和@RequestMapping
     *
     *
     *
     * RequestCondition结构 RequestMappingInfo实现了RequestCondition接口，这个接口用来保存从request提取出用于匹配的Handler的条件。
     * 这个是@requestMapping中解析出来的封装的对象
     *
     * MappingRegistration（包含处理方法和元数据)
     *
     * HandlerMethod.这个封装了对应的Handler 和 Method。这个Handler是对应的bean对名称，Method是对应的方法， 这个就是一个Handler
     * HandlerMethod封装了关于这个方法的信息
     * 然后再加上requestMappingInfo组成一个映射  被注册到MappingRegistry中去。
     *
     * MappingRegistry中的变量，这个可以还短点调试
     *  registry 核心存储结构，存储完整的映射注册信息，key是RequestMappingInfo（URL模式、HTTP方法、请求参数等条件）
     *  MappingRegistry通过维护多个映射，实现了高效的请求映射查找。每个映射服务于不同的查找维度，从而在保证功能完整性的同时，提高了查找效率。同时，通过读写锁保证了并发环境下的线程安全
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
    * */
}

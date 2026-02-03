package com.wf;

public class A02HandlerAdapterAnalysis {
    /**
     *
     *  HandlerMapping 通过request找到Handler，HandlerAdapter使用Handler干活
     *  一个 HandlerAdapter 包装了一个Handler的具体使用方法。一共有四个实现类，
     * HttpRequestHandlerAdapter 适配 HttpRequestHandler
     * SimpleServletHandlerAdapter 适配 Servlet
     * SimpleControllerHandlerAdapter 适配 Controller
     *
     *
     * HandlerAdapter 包括三个方法：
     * supports用来判断是否支持传递的Handler，
     * ModelAndView handle 主要方法，用来处理传递进来的Handler，使用Handler处理请求
     * getLastModified 获取资源LastModified值
     *
     *
     * RequestMappingHandlerAdapter 最重要的一个
     * RequestMappingHandlerAdapter 继承了 AbstractHandlerMethodAdapter抽象类，这个抽象类进行了三个方法的实现，并且抽象了自己的抽象模板
     * AbstractHandlerMethodAdapter抽象类 还实现了Order接口，并且继承了WebContentGenerator，而这个有继承了WebApplicationObjectSupport，具备aware功能
     * RequestMappingHandlerAdapter 实现了  AbstractHandlerMethodAdapter的抽象方法，并且实现了BeanFactoryAware, InitializingBean接口
     *
     * RequestMappingHandlerAdapter的handleInternal()这个就是主要的逻辑处理。三个步骤
     * 备好处理器所需要的参数，使用处理器处理请求，处理返回值统一处理成ModelAndView类型
     * 使用处理器处理请求是使用反射调用的对应的处理器进行执行。
     * 1. 准备处理器所需要的参数，第一步需要明白有哪些参数需要绑定，参数的值的来源在哪里，怎么绑定到方法上。
     * 根据对应的方法可以得到绑定的参数，另外还需要单独处理两个方法的参数绑定，就是和当前处理器使用了@modelAttribute 和@InitBinder的方法。
     * 参数的来源有6个：
     * 1.request中的相关参数，包括url中的参数，post过来的参数，请求头所包含的值。
     * 2.cookie中的参数 3.session中的参数 4.设置到FlashMap中的参数，用于redirect的参数传递
     * 5.SessionAttributes传递的参数，通过@SessionAttribute注释传递。
     * 6.@ModelAttribute的方法进行设置的参数。
     *
     * 参数的解析使用了 HandlerMethodArgumentResolver 类型的组件来完成，不同的参数类型使用不同的ArgumentResolver来解析
     *
     *
     * RequestMappingHandlerAdapter 由于实现了InitializingBean接口，所在在创建的时候，会调用对应的回调方法afterPropertiesSet。
     * 在这个方法中，进行了自己属性的设置。
     *  1. argumentResolvers属性的赋值：这个用来给处理器方法和注释了@ModelAndView的方法设置参数，默认了16个
     *  2.initBinderArgumentResolvers属性的赋值：这个是用来给注释了@initBinder的方法设置参数
     *  3.returnValueHandlers 属性的赋值，这个是用来将处理器的返回值处理成ModelAndView的类型
     *  4.modelAttributeAdviceCache 和 initBinderAdviceCache 属性赋值，用来缓存@ControllerAdvice注释里面的@ModelAttribute和@initBinder的方法
     *  5.requestResponseBodyAdvice 属性用来保存实现了RequestBodyAdvice接口，可以修改返回的ResponseBody类 @ControllerAdvice
     *
     *  这些属性在执行Handler的过程中发挥了重要的作用
     *
     *
     *
     *
     *
     *
     *
     */
}

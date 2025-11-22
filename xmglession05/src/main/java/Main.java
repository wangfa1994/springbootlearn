public class Main {

    /**
     *
     *  1.模板引擎
     *  新一代的服务端模板引擎 Thymeleaf
     *
     *  模板引擎的核心要素包括三类
     *  1. 资源定位(模板的来源) ：
     *  文件资源：File，classpath资源：ClassLoader，统一资源：URL，web资源：ServletContext，
     *  spring进行了抽象形成了自己的资源：Resource
     *  2.渲染上下文(变量的来源)：
     *  thymeleaf渲染上下文：Context ，Spring Web Mvc模型：Model ，Servlet上下文：Attribute
     *  3.模板引擎(模板的渲染)：
     *  ITemplateEngine 实现：TemplateEngine 原生实现
     *  ISpringTemplateEngine针对Spring的抽象接口存在实现SpringTemplateEngine和ISpringWebFluxTemplateEngine
     *
     *
     *
     *  2.视图处理
     *  1. Spring web mvc 视图组件
     *  视图解析器：ViewResolver
     *  视图组件：View
     *  总控：DispatcherServlet
     *
     *  thymeleaf 整合Spring web mvc
     *  视图解析器：ViewResolver ----> ThymeleafViewResolver
     *  视图：View ----> ThymeleafView
     *  渲染：ISpringTemplateEngine ----> SpringTemplateEngine
     *
     *  通过DispatcherServlet#resolveViewName()得到我们的View ，这个View是排序的。在DispatcherServlet#initViewResolvers()初始化我们的View列表，并进行排序
     *
     *  在DispatcherServlet#render方法中调用resolveViewName方法得到我们的View之后，进行对应的模板引擎渲染，最后设置到我们的Response中进行返回给前端
     *
     *
     * 外部化配置一般都会存在对应的一个配置类 ThymeleafProperties
     *
     *
     * 3. 视图内容协商
     *  如何根据一些信息确定到我们要返回的内容
     * web客户端通过不同的请求策略，实现服务端响应对应视图内容的输出。
     * 比如可以根据Accept请求头，Accept:text/* 输出到支持文本的视图，根据请求参数/path?format=pdf 输出到支持pdf展示的视图上 根据路径扩展名， /abc.word 输出到支持word的视图上
     *
     * 前端不可能使用if else进行不同的判断，我们后端可以通过视图的内容协商来完成这个展示
     * 1. 核心组件
     *  视图解析 ContentNegotiatingViewResolver
     *  主要进行三个
     *  1.关联ViewResolver Bean 列表 (InternalResourceViewResolver BeanNameViewResolver ThymeleafViewResolver )
     *  2.关联 ContentNegotiationManager Bean实例
     *  3.解析出最佳匹配的View
     *
     *  配置策略
     *  配置bean：WebMvcConfigurer
     *      存在configureContentNegotiation默认方法，
     *  配置对象：ContentNegotiationConfigurer
     *
     *  策略管理
     *  内容协商管理器bean：ContentNegotiationManager ，这个bean是由ContentNegotiationConfigurer配置
     *  通过FactoryBean：ContentNegotiationManagerFactoryBean 进行创建
     *  并且会关联到策略ContentNegotiationStrategy集合上，进行管理这个集合
     *
     *  策略实现
     *  内容协商策略：ContentNegotiationStrategy
     *          1. 固定MediaType:  FixedContentNegotiationStrategy
     *          2. "Accept" 请求头： HeaderContentNegotiationStrategy
     *          3. 请求参数：ParameterContentNegotiationStrategy
     *          4. 路径扩展名：PathExtensionContentNegotiationStrategy
     *
     * 总的入口在 ContentNegotiationConfigurer
     * 通过这个配置类持有 ContentNegotiationManagerFactoryBean属性，类似代理模式，通过配置类可以给我们的ContentNegotiationManager进行配置策略，最后可以到到我们的ContentNegotiationManager
     * 在视图解析过程中，通过ContentNegotiatingViewResolver进行管理了我们的配置相关ContentNegotiationManager
     * 这样的还话，通过ContentNegotiatingViewResolver就关联到了 ContentNegotiationManager 并且还存在我们的视图解析器列表 ViewResolverList。
     * ContentNegotiatingViewResolve 通过解析处理，就可以得到对应的最佳匹配View
     *
     * 1. 需要通过WebMvcConfigurer进行配置我们的视图协商功能，实现configureContentNegotiation方法进行配置ContentNegotiationConfigurer
     *
     *
     *  所有的匹配最佳视图是通过 ContentNegotiatingViewResolver 进行解析处理的，而且这个视图的优先级是最高的
     *
     *
     *
     *
     * 4. springboot的自动装配视图组件
     * 1. 自动装配配置类 web MVc : webMvcAutoConfiguration 中条件装配 ContentNegotiatingViewResolver
     * 2. thymeleaf web mvc ：ThymeleafWebMvcConfiguration 配置
     *
     * 外部化配置：
     * 内容协商：WebMvcProperties.Contentnegotiation
     * thymeleaf ： ThymeleafProperties
     *
     */
}

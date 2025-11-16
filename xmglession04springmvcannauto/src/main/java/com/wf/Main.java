package com.wf;

public class Main {

    /**
    *  web mvc 的自动装配
     *
     *  这个需要Servlet 3.0+版本，在这个版本新增了一个 Servlet SPI:ServletContainerInitializer,
     *  在Servlet容器启动的时候可以进行回调，这个SPI通过参数ServletContext，可以动态的进行装载我们的Servlet,还有一个参数c,需要配合javax.servlet.annotation.HandlesTypes进行使用
     *  我们在进行添加回调的时候需要通过HandlesTypes进行过滤我们自己关注的类。
     *
     *
     *  Spring针对这个SPI进行了适配实现 SpringServletContainerInitializer，这个类就进行了HandlesTypes的使用， 这个可以用作回调
     *
     *  然后有抽象自己的Spring SPI: WebApplicationInitializer，通过HandlesTypes过滤spring自己的SPI抽象接口WebApplicationInitializer，这个参数就只有一个ServletContext
     *
     * 在这个适配上,WebApplicationInitializer提供了四个抽象类 ,其中在AbstractDispatcherServletInitializer中，就进行了相关Servlet的配置代码编写，完整了动态添加Servlet
     *
     *
     * 基础接口：WebApplicationInitializer
     *  编程方式：通过spring给我们提供的抽象驱动类进行扩展 AbstractDispatcherServletInitializer
     *  注解方式：通过注入这个类来进行扩展 AbstractAnnotationConfigDispatcherServletInitializer
    *
     *
     * 在xml中我们始终使用了web.xml进行我们的Servlet的配置，现在就可以通过上述的方式进行代码的自动装配了，而不在需要在web.xml中进行配置了
     *
     *
     * 在spring framework 3.2 版本其实就支持了spring web mvc 的自动装配 而不需要在springboot 中 ，而且我们可以通过 maven 插件 直接
     * 将我们的 war 包转换成jar包，进行使用java -jar 启动
     *
     *
     *
     * springboot 时代的简化
     * 1. 完全自动装配，
     *      1.1利用的还是Servlet3.0的SPI,进行了自己的封装 并且内置了相关Servlet容器。 自动状态的DispatcherServlet :DispatcherServletAutoConfiguration
     *      入口配置DispatcherServletAutoConfiguration，这个配置中创建了ServletRegistrationBean实例
     *      这个其实是实现了继承了RegistrationBean实现了ServletContextInitializer
     *      而ServletContextInitializer则是对Servlet3.0的SPI的一个封装，这个是boot 封装的，是个嵌入式的Servlet。这个是自我驱动。而不是访到容器中
     *      没有使用spring mvc的SpringServletContainerInitializer
     *
     *      1.2替换@EnableWebMvc: WebMvcAutoConfiguration配置类
     *      1.3 Servlet容器，不是利用插件打包的方式，而是使用 ServletWebServerFactoryAutoConfiguration 这个bean进行处理
     *
     *      自动配置的顺序控制存在两个注解：1.决定顺序@AutoConfigureOrder 2.相对顺序@AutoConfigureAfter。WebMvcAutoConfiguration 配置类就使用了绝对和相对顺序。
     *
     * 2. 条件装配
     *   Web类型：Servlet   使用web类型判断@ConditionalOnWebApplication,也是在配置文件 WebMvcAutoConfiguration 中  进行设置的
     *   API: Servlet ,spring web mvc   使用 @ConditionalOnClass 进行类的判断， 也是在配置文件 WebMvcAutoConfiguration 中  进行设置的
     *   bean依赖：webMvcConfigurationSupport 使用Bean的判断 @ConditionalOnMissingBean @ConditionalOnBean 进行是否存在bean 判断  也是在配置文件 WebMvcAutoConfiguration 中  进行设置的
     *   查看boot提供的 WebMvcAutoConfiguration 可以发现上述的条件装配，为了防止和spring mvc 手动配置冲突吧，才进行了条件判断
     *
     *
     *
     * 3.外部化配置
     *  web mvc 配置：WebMvcProperties  这个是配置文件WebMvcAutoConfiguration的相关属性，被大量使用
     *  资源配置：ResourceProperties
     *
     *
     *
    * */
}

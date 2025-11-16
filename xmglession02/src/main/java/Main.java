public class Main {

    /**
     * spring framework 手动装配
     *
     * spring 模式注解 装配
     *  模式注解：模式注解是一种用于声明在应用中扮演“组件”角色的注解。如 Spring Framework 中的  @Repository 标注在任何类上 ，用于扮演仓储角色的模式注解
     *  模式注解装配有两种方式 基于xml的和基于注解@componentScan
     *  https://github.com/spring-projects/spring-framework/wiki/Spring-Annotation-Programming-Model#stereotype-annotations
     *  @Component 作为一种由 Spring 容器托管的通用模式组件，任何被  @Component 标准的组件均为组件扫描的候选对象。类似地，凡是被  @Component 元标注（meta-annotated）的注解，如  @Service ，当任何组件标注它时，也被视作组件扫描的候选对象
     *
     * 除了利用spring内置的一些注解，还可以进行我们自定义注解模式，通过我们自定义的注解来进行相关装配
     *
     * 2.5版本引入了一些通用的注解，@Component @Service @Controller
     * 3.0增加的@Configuration 用于标识配置，@Import注解用于导入单个配置类
     * 3.1的时候又加入了ImportSelector接口规范，可以导入多个配置类，进行条件判断  @ComponentScan可以进行指定包的扫描
     *
     *
     *spring @enable模块 装配
     * Spring Framework 3.1 开始支持”@Enable 模块驱动“。所谓“模块”是指具备相同领域的功能组件集合， 组合所形成一个独立的单元。
     * 比如 Web MVC 模块、AspectJ代理模块、Caching（缓存）模块、JMX（Java 管 理扩展）模块、Async（异步处理）模块等
     *
     *
     * 虽然我们能在在ImportSelector接口规范中进行条件判断，返回不一样的分支，这种方式还是不够灵活，于是新增了添加注解进行更方便的条件判断使用
     * spring 条件装配
     *
     * 从 Spring Framework 3.1 开始，允许在 Bean 装配时增加前置条件判断 @Profile  和 @Conditional
     *
     * @Profile 配置化的注解装配   4.0之后增加了 Conditional注解，然后变成底层使用Conditional实现了
     *
     *
     *
     *  ConditionalOnProperty注解模拟  ConditionalOnSystemProperty
     *
     *
     *
     * Springboot 的 自动装配
     * spring基本是使用手动装配，需要我们进行手动处理，而spring boot的自动装配则是约定大于配置的
     *
     *  自动装配 META-INF/spring.factories
     *
     *  实现方法：1.激活自动装配 @EnableAutoConfiguration  2.实现自动装配 XXXAutoConfiguration    3.配置自动状态的实现 META-INF/spring.factories
     *
     *
     *
     *
     *
     *
     */
}

package com.wf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashSet;
import java.util.Set;

/**
 * SpringApplication 是Springboot的引导类
* SpringApplication 基本使用
*
* */
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplicationConfig.class, args);
       // applicationOther(args);
    }

    @SpringBootApplication
    public static class SpringbootApplicationConfig{

    }


    /*springboot 准备阶段流程================================*/
    /* 1.  springboot 的Bean 源 是如何加载的  准备阶段是在构造器中完成的 */
    public static void applicationOther(String[] args){

        Set<String> sources = new HashSet();
        // 配置Class 名称
        sources.add(SpringbootApplicationConfig.class.getName());
        // 自定义我们的SpringBoot 应用属性
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources); // 可以配置xml 路径也是可以的 springApplication里面有很多配置方法
        springApplication.setWebApplicationType(WebApplicationType.SERVLET); // 配置为Servlet
        springApplication.run(args);
    }

    /**
     * springApplication 的准备阶段 实是在构造器中完成的，通过静态方法run，也是会创建SpringApplication对象的
    * 构造器里会进行推导web应用类型， 设置SpringFactoriesInstances应用上下文初始器(很重要)， 设置监听器(很重要)， 推导引导类
     *  设置应用上下文初始器，实现了 ApplicationContextInitializer 接口的类
     *  设置监听器 都是利用了Spring 工厂加载机制
    *
     * springApplication的运行阶段 run方法
     *
     *
    * */



    /*
    * 2.  springboot 是如何推断Web 应用类型的 推断引导类和方法
    *  org.springframework.boot.SpringApplication#deduceMainApplicationClass
    * */


    /*
    * 3.   springboot 是如何推断引导类的 Main class
    * org.springframework.boot.SpringApplication#deduceMainApplicationClass
    * */

    /* 4. springboot 是入如何加载应用上下文初始器的
    * 利用 Spring 工厂加载机制，实例化  ApplicationContextInitializer 实现类，并排序对象集合
    *
    * 技术
    * 实现类： org.springframework.core.io.support.SpringFactoriesLoader
    * 配置资源： META-INF/spring.factories
    * 排序： AnnotationAwareOrderComparator#sort
    * 加载这个有什么用吗？
    * */
    public static void applicationContext(String[] args){

        Set<String> sources = new HashSet();
        // 配置Class 名称
        sources.add(SpringbootApplicationConfig.class.getName());
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
        springApplication.setWebApplicationType(WebApplicationType.SERVLET); // 容器没有关系
        springApplication.run(args);
    }


    /*
    * 5. 加载应用事件监听器   ApplicationListener
    *  利用 Spring 工厂加载机制，实例化  ApplicationListener 实现类，并排序对象集合
    *
    * 同加载应用上下文初始器
    *
    * */

    // springboot 准备阶段流程 是在SpringApplication构造器中完成的  运行阶段是在run方法中进行处理的

    /*springboot 准备阶段流程================================*/

    /*springboot 运行阶段流程======run方法中的流程==========================*/



    /*1. 加载 SpringApplication 运行监听器 SpringApplicationRunListeners
    * 利用 Spring 工厂加载机制，读取  SpringApplicationRunListener 对象集合，并且封装到组合类SpringApplicationRunListeners
    * */

    /* 2. 运行 SpringApplication 运行监听器  SpringApplicationRunListeners  EventPublishingRunListener 是默认实现
    *
    * SpringApplicationRunListener 监听多个运行状态方法
    * 监听方法 阶段说明 Spring Boot 起始版本
    * starting()      Spring 应用刚启动         1.0
    * environmentPrepared(ConfigurableEnvironment)         ConfigurableEnvironment 准备妥当，允许将其调整           1.0
    * contextPrepared(ConfigurableApplicationContext)      ConfigurableApplicationContext 准备妥当，允许将其调整    1.0
    * contextLoaded(ConfigurableApplicationContext)        ConfigurableApplicationContext 已装载，但仍未启动        1.0
    * started(ConfigurableApplicationContext)              ConfigurableApplicationContext 已启动，此时 Spring Bean 已初始化完成     2.0
    * running(ConfigurableApplicationContext)              Spring 应用正在运行                                 2.0
    * failed(ConfigurableApplicationContext,Throwable)     Spring 应用运行失败                                 2.0
    *
    *
    *
    *
    * */


    /* 3.  3. 监听 Spring Boot 事件 / Spring 事件
    * Spring Boot 通过  SpringApplicationRunListener 的实现类  EventPublishingRunListener 利用 Spring Framework 事件API ，广播 Spring Boot 事件
    * 是在spring 的实现上进行扩展的
    * Spring Framework 事件/监听器编程模型3个
    *   1.Spring 应用事件：  1.普通应用事件： ApplicationEvent   2.应用上下文事件： ApplicationContextEvent
    *   2.Spring 应用监听器 ：1.接口编程模型： ApplicationListener  2.注解编程模型： @EventListener
    *   3.Spring 应用事广播器  接口： ApplicationEventMulticaster 实现类： SimpleApplicationEventMulticaster 执行模式：同步或异步
    *
    *
    *
    *
    * */


    /* 4. 创建Spring 应用上下文 ConfigurableApplicationContext上下文，Environment 其他
    *
    * 根据准备阶段的推断 Web 应用类型创建对应的  ConfigurableApplicationContext 实例
    *
    * Web Reactive： AnnotationConfigReactiveWebServerApplicationContext 这个是springboot的 但是还是实现扩展了spring中的ApplicationContext接口
    * Web Servlet： AnnotationConfigServletWebServerApplicationContext   这个是springboot的 但是还是实现扩展了spring中的ApplicationContext接口
    * 非 Web：：     AnnotationConfigApplicationContext 这个是spring的
    * */


    // 5. 失败 故障分析报告
    // 6. 回调 CommandLineRunner , ApplicationRunner
    /*springboot 运行阶段流程================================*/

}

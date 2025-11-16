public class Main {

    /**
     *  1. 理解 spring web mvc 架构
     *
     *  演变流程：Servlet基础架构 ---->前端总控制器核心架构------>spring web mvc 架构
     *  基础的servlet架构是请求/响应式(Request/Response)的，并且屏蔽了关于网络的操作细节。完全的面向HTTP协议
     *
     *  前端总控制器架构 http://www.corej2eepatterns.com/FrontController.htm
     *  spring在前期是构建在前端总控制器架构上的，但是后期进行了修改，形成了自己的web mvc架构
     *  1.0核心是DispatcherServlet 就是一个前端总控制器的实现：https://docs.spring.io/spring-framework/docs/1.0.0/javadoc-api/org/springframework/web/servlet/DispatcherServlet.html
     *  5.0变更： Central dispatcher for HTTP request handlers/controllers, e.g. for web UI controllers or HTTP-based remote service exporters
     *  https://docs.spring.io/spring-framework/docs/5.0.0.RELEASE/javadoc-api/org/springframework/web/servlet/DispatcherServlet.html
     *
     *
     *  2.认识 spring web mvc
     *
     *  Spring Framework 时代的一般认识  ：1.实现 Controller 2.配置 Web MVC 组件 3.部署 DispatcherServlet
     *
     *
     *
     *
     *
     *  3.简化 spring web mvc
     *
     *  spring boot 时代的简化  完全自动装配
     *  -- 完全自动装配
     *
     *  -- 条件装配
     *  -- 外部化配置
     *
     *
     */
}

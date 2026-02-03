package com.wf;

public class Main {

    /*
    * springboot 的能力，其实就是利用规范化，对Spring 的特性进行 整合
    *
    * 1. REST
    * rest 概念
    *
    *
    * 2. web mvc 对REST的支持
    * 2.1 注解驱动
    *   定义注解： @Controller  @RestController
    *   映射注解： @RequestMapping @GetMapping @PostMapping @PutMapping @DeleteMapping @GetMapping  @PatchMapping
    *   请求注解： @RequestParam  @RequestHeader @CookieValue @RequestBody @PathVariable   RequestEntity
    *   响应注解： @ResponseBody  ResponseEntity  ResponseCookie
    *   拦截注解： @RestControllerAdvice   HandlerInterceptor
    *   跨域注解： @CrossOrigin  CorsFilter    WebMvcConfigurer#addCorsMappings
    *
    *
    * 3. REST 内容协商
    *  ContentNegotiationManager       内容协商管理器    ContentNegotiationStrategy 控制策略
    *   MediaType                      媒体类型         HTTP 消息媒体类型，如  text/html
    *  @RequestMapping#consumes         消费媒体类型      请求头Content-Type 媒体类型映射
    *  生产媒体类型 @RequestMapping#produces 响应头  Content-Type 媒体类型映射
    *  HttpMessageConverter  HTTP消息转换器    HTTP 消息转换器，用于反序列化 HTTP 请求或序列化响应
    *
    * WebMvcConfigurer               Web MVC 配置器                  配置 REST 相关的组件
    *
    *  HandlerMethodArgumentResolver   处理方法参数解析器 用于 HTTP 请求中解析  HandlerMethod 参数内容
    *  HandlerMethodReturnValueHandler 处理方法返回值解析器  用于 HandlerMethod 返回值解析为 HTTP 响应内容
    *
    *
    *
    *
    *
    * 4. CORS spring提供的能力
    *
    *
    *
    * webMvc 核心组件
    *
    * @RequestMapping的理解
    *
    *
    * ContentNegotiationManager
    * WebMvcConfigurer
    * MediaType
    *
    *
    *
    *
    *
    *
    * */
}

package com.wf.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 *  激活 HelloWorld 模块
 *
 * @author 小马哥
 * @since 2018/5/14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloWorldImportSelector.class) // Import支持导入beanConfig和ImportSelector , ImportSelector更加灵活
public @interface EnableHelloWorld {
}

package com.wf.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * HelloWorld {@link SpringApplicationRunListener}
 *
 * @author 小马哥
 * @since 2018/5/17
 */
public class HelloWorldRunListener implements SpringApplicationRunListener {

    /* 参数一定要有的，构造器参数一定是两个 只有默认构造器的话，会报错，模仿EventPublishingRunListener */
    public HelloWorldRunListener(SpringApplication application, String[] args) {
        System.out.println("HelloWorldRunListener 构造器");

    }

    @Override
    public void starting() {
        System.out.println("HelloWorldRunListener.starting()...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}

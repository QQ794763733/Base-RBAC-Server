package com.anonymous.developer.www.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 监听Springboot生命周期
 * @Datetime: 2019/9/17 11:30 下午
 */
public class ApplicationLifecycleEventListener implements ApplicationListener<ApplicationEvent> {
    private final Logger logger = LoggerFactory.getLogger("Information:");
    /**
     * Springboot声明周期
     * @param applicationEvent
     */
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        // 在这里可以监听到Spring Boot的生命周期
        if (applicationEvent instanceof ApplicationEnvironmentPreparedEvent) { // 初始化环境变量
            logger.info("初始化环境变量");
        } else if (applicationEvent instanceof ApplicationPreparedEvent) { // 初始化完成
            logger.info("初始化环境变量完成");
        } else if (applicationEvent instanceof ContextRefreshedEvent) { // 应用刷新，当ApplicationContext初始化或者刷新时触发该事件。
            logger.info("应用刷新");
        } else if (applicationEvent instanceof ApplicationReadyEvent) {// 应用已启动完成
            logger.info("应用已启动完成");
            printCurrentProjectInformation();
        } else if (applicationEvent instanceof ContextStartedEvent) { // 应用启动，Spring2.5新增的事件，当容器调用ConfigurableApplicationContext的 Start()方法开始/重新开始容器时触发该事件。
            logger.info("应用启动");
        } else if (applicationEvent instanceof ContextStoppedEvent) { // 应用停止，Spring2.5新增的事件，当容器调用ConfigurableApplicationContext 的Stop()方法停止容器时触发该事件。
            logger.info("应用停止");
        } else if (applicationEvent instanceof ContextClosedEvent) { // 应用关闭，当ApplicationContext被关闭时触发该事件。容器被关闭时，其管理的所有 单例Bean都被销毁。
            logger.info("应用关闭");
        }
    }

    /**
     * 打印项目信息
     */
    private void printCurrentProjectInformation(){
        printSeparator();
        printInformation("Api document web address:http://127.0.0.1:"+ProjectProperties.getPort()+"/swagger-ui.html");
        printSeparator();
    }

    /**
     * 打印信息分隔符
     */
    private void printSeparator(){
        logger.info("###################################################################################");

    }

    /**
     * 打印信息
     * @param information
     */
    private void printInformation(String information){
        logger.info("#\t\t"+information);
    }
}
package com.anonymous.developer.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 系统启动类
 * @Datetime: 2019/9/15 2:37 下午
 */
@SpringBootApplication
public class Application {
    //解决时区问题
    @PostConstruct
    void setDefaultTimezone() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
    }
    public static void main(String args[]){
        SpringApplication.run(Application.class,args);
    }
}
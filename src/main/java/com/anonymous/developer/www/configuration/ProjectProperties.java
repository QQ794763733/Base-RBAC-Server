package com.anonymous.developer.www.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 获取项目配置文件类
 * @Datetime: 2019/9/18 8:56 下午
 */
@Component
public class ProjectProperties {
    private static String port;

    public static String getPort() {
        return port;
    }

    /**
     * 静态变量的set方法需要去掉static
     * @param port
     */
    @Value("${server.port}")
    public void setPort(String port) {
        ProjectProperties.port = port;
    }
}
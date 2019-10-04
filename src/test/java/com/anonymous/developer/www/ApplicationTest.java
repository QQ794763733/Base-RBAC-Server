package com.anonymous.developer.www;

import org.mindrot.jbcrypt.BCrypt;

import java.net.UnknownHostException;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 测试类
 * @Datetime: 2019/9/16 9:39 下午
 */
public class ApplicationTest {
    public static void main(String args[]) throws UnknownHostException {
        String password = "xy942698.";
        if(BCrypt.checkpw(password,"$2a$10$kunyRzZrXo7w2jrWyJmsCuJN3L9P9eR2QDKS3LZkl097Q4.MoBb9q")){
            System.out.println("111");
        }
    }
}
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
        String password = "50b437a4c53f92ff9b3f95fb6d164e96";
        System.out.println(BCrypt.hashpw(password,BCrypt.gensalt()));
    }
}
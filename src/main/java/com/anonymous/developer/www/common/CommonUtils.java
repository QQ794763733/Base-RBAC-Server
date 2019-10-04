package com.anonymous.developer.www.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * 常用工具包
 */
public class CommonUtils {
    private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
    public static int port = 8080;

    /**
     * 生成随机字符串
     * @param length 字符串长度
     * @return 随机字符串
     */
    public static String getRandomString(Integer length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取当前主机IPV4的地址
     * @return
     */
    public static String getLocalHostIPV4Address(){
        try {
            String ipv4 = Inet4Address.getLocalHost().getHostAddress();
            return ipv4;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            logger.error("获取IPV4地址错误:"+e.getMessage());
            return "127.0.0.1";
        }
    }

    /**
     * 获取IPV6地址
     * @return
     */
    public static String getLocalHostIPV6Address(){
        try {
            String ipv6 = Inet6Address.getLocalHost().getHostAddress();
            return ipv6;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            logger.error("获取IPV6地址错误:"+e.getMessage());
            return "0:0:0:0:0:0:0:1";
        }
    }
}
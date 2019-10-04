package com.anonymous.developer.www.common;
/**
* @author: 肖宇
* @QQ: 794763733
* @WeChat: Anonymous-developer
* @Description: 通用异常接口
*/
public interface ICommonException {
    /**
     * 返回错误代码
     * @return 错误代码
     */
    int getExceptionCode();

    /**
     * 返回错误信息
     * @return
     */
    String getExceptionMessage();

    /**
     * 设置错误信息
     * @param message 错误信息
     * @return 当前对象
     */
    ICommonException setExceptionMessage(String message);
}
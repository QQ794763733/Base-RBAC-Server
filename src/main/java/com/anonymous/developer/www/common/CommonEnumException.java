package com.anonymous.developer.www.common;

/**
* @author: 肖宇
* @QQ: 794763733
* @WeChat: Anonymous-developer
* @Description: 通用的异常枚举类
* @Datetime: 2019/9/7 2:06 上午
*/
public enum CommonEnumException implements ICommonException{
    //未知错误
    UNKNOW_EXCEPTION(10000,"未知错误"),
    //从10000过后的都是用户错误
    ACCOUNT_IS_NOT_EXIST(10001,"账户不存在"),
    NAME_OR_PASSWORD_IS_NOT_VALID(10002,"账户或密码无效"),
    //从20000过后的都是参数错误
    PARAMETER_IS_ERROR(20001,"参数错误")
    ;
    //错误代码
    private int exceptionCode;
    //错误信息
    private String exceptionMessage;

    /**
     * 构造函数
     * @param exceptionCode
     * @param exceptionMessage
     */
    CommonEnumException(int exceptionCode, String exceptionMessage) {
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public int getExceptionCode() {
        return exceptionCode;
    }

    @Override
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    /**
     * 设置错误信息
     * @param message
     * @return
     */
    @Override
    public ICommonException setExceptionMessage(String message) {
        this.exceptionMessage = message;
        return this;
    }
}
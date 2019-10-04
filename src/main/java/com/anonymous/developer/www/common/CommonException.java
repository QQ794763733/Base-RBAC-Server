package com.anonymous.developer.www.common;

/**
* @author: 肖宇
* @QQ: 794763733
* @WeChat: Anonymous-developer
* @Description: 通用异常类
* @Datetime: 2019/9/7 2:20 上午
*/
public class CommonException extends Exception implements ICommonException{
    /**
     * 异常枚举类
     */
    private ICommonException commonException;

    /**
     * 异常类构造方法
     * @param commonException 异常枚举类
     */
    public CommonException(ICommonException commonException) {
        super();
        this.commonException = commonException;
    }

    /**
     * 异常类构造方法
     * @param commonException 异常枚举类
     * @param message 需要修改的异常信息
     */
    public CommonException(ICommonException commonException,String message){
        this.commonException = commonException.setExceptionMessage(message);
    }

    /**
     * 返回错误代码
     * @return 返回错误代码
     */
    @Override
    public int getExceptionCode() {
        return commonException.getExceptionCode();
    }

    /**
     * 返回错误信息
     * @return 返回错误信息
     */
    @Override
    public String getExceptionMessage() {
        return commonException.getExceptionMessage();
    }

    /**
     * 设置错误信息
     * @param message 需要设置的错误信息
     * @return 当前对象
     */
    @Override
    public ICommonException setExceptionMessage(String message) {
        this.commonException.setExceptionMessage(message);
        return this;
    }
}
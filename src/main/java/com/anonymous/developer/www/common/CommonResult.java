package com.anonymous.developer.www.common;

/**
* @author: 肖宇
* @QQ: 794763733
* @WeChat: Anonymous-developer
* @Description: 通用Json返回类
* @Datetime: 2019/9/7 2:20 上午
*/
public class CommonResult {
    //返回代码
    private int code;
    //返回信息
    private String message;
    //返回数据
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 静态构造方法
     * @param code Json代码
     * @param message Json信息
     * @param data Json数据
     * @return
     */
    public static CommonResult createCommonResult(int code, String message, Object data){
        CommonResult commonResult = new CommonResult();
        commonResult.code = code;
        commonResult.message = message;
        commonResult.data = data;
        return commonResult;
    }

    /**
     * 静态构造方法
     * @param message Json信息
     * @param data Json数据
     * @return
     */
    public static CommonResult createCommonResult(String message, Object data){
        return createCommonResult(200,message,data);
    }

    /**
     * 静态构造方法
     * @param data Json信息
     * @return Json数据
     */
    public static CommonResult createCommonResult(Object data){
        return createCommonResult(200,"请求成功",data);
    }
    /**
     * 错误构造方法
     * @param data
     * @return
     */
    public static CommonResult error(Object data){
        return createCommonResult(200,"发生错误",data);
    }
    /**
     * 成功构造方法
     * @param data Json信息
     * @return Json数据
     */
    public static CommonResult success(Object data){
        return createCommonResult(200,"请求成功",data);
    }

    /**
     * 失败构造方法
     * @param data
     * @return
     */
    public static CommonResult fail(Object data){
        return createCommonResult(200,"请求失败",data);
    }
}
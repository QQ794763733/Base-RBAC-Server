package com.anonymous.developer.www.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 登录信息传输类
 * @Datetime: 2019/10/6 6:34 下午
 */
public class LoginInformation {
    private boolean isLogin;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer accountId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String accountName;

    public boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean login) {
        isLogin = login;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}

package com.anonymous.developer.www.parameter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 登录接口参数
 * @Datetime: 2019/9/17 2:09 下午
 */
public class LoginRequestParam {
    @NotBlank(message = "账号名称为空")
    private String accountName;
    @NotBlank(message = "账号密码为空")
    private String accountPassword;
    @NotNull(message = "记住我为空")
    private Boolean rememberMe;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}

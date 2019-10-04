package com.anonymous.developer.www.model;

import com.anonymous.developer.www.enums.EnumAccountSex;
import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
    private Integer accountId;

    private String accountName;

    @Ignore
    private String accountPassword;

    private String accountDescription;

    private EnumAccountSex accountSex;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDatetime;

    private String operator;

    private String operatorIp;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date operateDatetime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastLoginDatetime;

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
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword == null ? null : accountPassword.trim();
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription == null ? null : accountDescription.trim();
    }

    public EnumAccountSex getAccountSex() {
        return accountSex;
    }

    public void setAccountSex(EnumAccountSex accountSex) {
        this.accountSex = accountSex;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getOperatorIp() {
        return operatorIp;
    }

    public void setOperatorIp(String operatorIp) {
        this.operatorIp = operatorIp == null ? null : operatorIp.trim();
    }

    public Date getOperateDatetime() {
        return operateDatetime;
    }

    public void setOperateDatetime(Date operateDatetime) {
        this.operateDatetime = operateDatetime;
    }

    public Date getLastLoginDatetime() {
        return lastLoginDatetime;
    }

    public void setLastLoginDatetime(Date lastLoginDatetime) {
        this.lastLoginDatetime = lastLoginDatetime;
    }
}
package com.anonymous.developer.www.model;

import com.anonymous.developer.www.enums.EnumMenuType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Menu {
    private Integer menuId;

    private String menuName;

    private String menuIcon;

    private EnumMenuType menuType;

    private String menuUrl;

    private Integer menuParentId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDatetime;

    private String operator;

    private String operatorIp;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date operateDatetime;

    private List<Menu> subMenus;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public EnumMenuType getMenuType() {
        return menuType;
    }

    public void setMenuType(EnumMenuType menuType) {
        this.menuType = menuType;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
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

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }
}
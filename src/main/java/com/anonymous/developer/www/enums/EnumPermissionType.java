package com.anonymous.developer.www.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
* @author: 肖宇
* @QQ: 794763733
* @WeChat: Anonymous-developer
* @Description: 权限类型枚举
*/
public enum EnumPermissionType {
    PAGE(0,"URL"),MENU(1,"菜单"),BUTTON(2,"按钮"),DIRECTORY(3,"文件");
    private Integer value;
    private String name;

    static Map<Integer,EnumPermissionType> enumPermissionTypeMap = new HashMap<>();
    static {
        for(EnumPermissionType enumPermissionType : EnumPermissionType.values()){
            enumPermissionTypeMap.put(enumPermissionType.getValue(),enumPermissionType);
        }
    }

    EnumPermissionType(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * 通过value返回EnumPermissionType
     * @param value
     * @return
     */
    public static EnumPermissionType getEnumPermissionTypeByValue(Integer value){
        return enumPermissionTypeMap.get(value);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
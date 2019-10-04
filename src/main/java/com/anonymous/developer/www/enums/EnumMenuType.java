package com.anonymous.developer.www.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 菜单类型枚举
 * @Datetime: 2019/9/23 5:02 下午
 */
public enum  EnumMenuType {
    SUBMENU(0,"子菜单"),GROUP(1,"菜单组"),ITEM(2,"菜单项");
    private Integer value;
    private String name;

    static Map<Integer,EnumMenuType> enumMenuTypeMap = new HashMap<>();
    static {
        for(EnumMenuType enumMenuType:EnumMenuType.values()){
            enumMenuTypeMap.put(enumMenuType.getValue(),enumMenuType);
        }
    }

    EnumMenuType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static EnumMenuType getEnumMenuTypeByValue(Integer value){
        return enumMenuTypeMap.get(value);
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

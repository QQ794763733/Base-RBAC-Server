package com.anonymous.developer.www.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
* @author: 肖宇
* @QQ: 794763733
* @WeChat: Anonymous-developer
* @Description: 账户性别枚举
*/
public enum EnumAccountSex {
    MALE(0,"男"),FEMALE(1,"女");
    private Integer value;
    private String name;

    /**
     * 把所有的枚举类型都放入到Map里面
     */
    static Map<Integer,EnumAccountSex> enumAccountSexMap = new HashMap<>();
    static {
        for (EnumAccountSex enumAccountSex : EnumAccountSex.values()){
            enumAccountSexMap.put(enumAccountSex.getValue(),enumAccountSex);
        }
    }

    EnumAccountSex(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * 通过value返回EnumAccountSex
     * @param value
     * @return
     */
    public static EnumAccountSex getEnumAccountSexByValue(Integer value){
        return enumAccountSexMap.get(value);
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

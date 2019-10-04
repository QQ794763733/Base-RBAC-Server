package com.anonymous.developer.www.enumhandler;

import com.anonymous.developer.www.enums.EnumAccountSex;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 处理账户性别枚举类型
 * @Datetime: 2019/9/9 4:57 下午
 */
public class EnumAccountSexHandler extends BaseTypeHandler<EnumAccountSex> {
    /**
     * Java类型转为数据库的类型
     * @param preparedStatement
     * @param i
     * @param enumAccountSex
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, EnumAccountSex enumAccountSex, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,enumAccountSex.getValue());
    }

    /**
     * 数据库类型转Java类型 字段名查找
     * @param resultSet
     * @param s
     * @return
     * @throws SQLException
     */
    @Override
    public EnumAccountSex getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int anInt = resultSet.getInt(s);
        if(resultSet.wasNull()){
            return null;
        }
        return EnumAccountSex.getEnumAccountSexByValue(anInt);
    }

    /**
     * 数据库类型转Java类型 字段名索引
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public EnumAccountSex getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int anInt = resultSet.getInt(i);
        if(resultSet.wasNull()){
            return null;
        }
        return EnumAccountSex.getEnumAccountSexByValue(anInt);
    }

    /**
     * 数据库类型转Java类型 字段名下标
     * @param callableStatement
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public EnumAccountSex getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int anInt = callableStatement.getInt(i);
        if(callableStatement.wasNull()){
            return null;
        }
        return EnumAccountSex.getEnumAccountSexByValue(anInt);
    }
}

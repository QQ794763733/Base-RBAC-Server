package com.anonymous.developer.www.enumhandler;

import com.anonymous.developer.www.enums.EnumPermissionType;
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
 * @Description: 处理权限类型枚举类型
 * @Datetime: 2019/9/9 5:21 下午
 */
public class EnumPermissionTypeHandler extends BaseTypeHandler<EnumPermissionType> {
    /**
     * Java类型转为数据库的类型
     * @param preparedStatement
     * @param i
     * @param enumPermissionType
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, EnumPermissionType enumPermissionType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,enumPermissionType.getValue());
    }

    /**
     * 数据库类型转Java类型 字段名查找
     * @param resultSet
     * @param s
     * @return
     * @throws SQLException
     */
    @Override
    public EnumPermissionType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int anInt = resultSet.getInt(s);
        if(resultSet.wasNull()){
            return null;
        }
        return EnumPermissionType.getEnumPermissionTypeByValue(anInt);
    }

    /**
     * 数据库类型转Java类型 索引查找
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public EnumPermissionType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int anInt = resultSet.getInt(i);
        if(resultSet.wasNull()){
            return null;
        }
        return EnumPermissionType.getEnumPermissionTypeByValue(anInt);
    }

    /**
     * 数据库类型转Java类型 下标查找
     * @param callableStatement
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public EnumPermissionType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int anInt = callableStatement.getInt(i);
        if(callableStatement.wasNull()){
            return null;
        }
        return EnumPermissionType.getEnumPermissionTypeByValue(anInt);
    }
}

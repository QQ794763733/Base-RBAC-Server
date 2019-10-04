package com.anonymous.developer.www.enumhandler;

import com.anonymous.developer.www.enums.EnumMenuType;
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
 * @Description: 菜单枚举处理器
 * @Datetime: 2019/9/23 5:09 下午
 */
public class EnumMenuTypeHandler extends BaseTypeHandler<EnumMenuType> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, EnumMenuType enumMenuType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,enumMenuType.getValue());
    }

    @Override
    public EnumMenuType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int anInt = resultSet.getInt(s);
        if(resultSet.wasNull()){
            return null;
        }
        return EnumMenuType.getEnumMenuTypeByValue(anInt);
    }

    @Override
    public EnumMenuType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int anInt = resultSet.getInt(i);
        if(resultSet.wasNull()){
            return null;
        }
        return EnumMenuType.getEnumMenuTypeByValue(anInt);
    }

    @Override
    public EnumMenuType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int anInt = callableStatement.getInt(i);
        if(callableStatement.wasNull()){
            return null;
        }
        return EnumMenuType.getEnumMenuTypeByValue(anInt);
    }
}

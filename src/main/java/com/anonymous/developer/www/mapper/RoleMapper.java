package com.anonymous.developer.www.mapper;

import com.anonymous.developer.www.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    Role selectByPrimaryKey(Integer roleId);

    Set<String> selectRoleNameByAccountPrimaryKey(Integer accountId);

    List<Role> selectLimit(@Param("keyWord") String keyWord, @Param("startRow") int startRow, @Param("endRow") int endRow);

    int selectCountAll();

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
}
package com.anonymous.developer.www.mapper;

import com.anonymous.developer.www.model.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface PermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    Set<String> selectPermissionNameByAccountPrimaryKey(Integer accountId);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);
}
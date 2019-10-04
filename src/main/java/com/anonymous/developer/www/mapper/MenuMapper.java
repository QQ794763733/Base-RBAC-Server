package com.anonymous.developer.www.mapper;

import com.anonymous.developer.www.model.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    Menu selectByPrimaryKey(Integer menuId);

    List<Menu> selectAll();

    int updateByPrimaryKey(Menu record);
}
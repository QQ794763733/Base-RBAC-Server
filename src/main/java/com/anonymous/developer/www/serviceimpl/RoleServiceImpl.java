package com.anonymous.developer.www.serviceimpl;

import com.anonymous.developer.www.dto.PageData;
import com.anonymous.developer.www.mapper.RoleMapper;
import com.anonymous.developer.www.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 角色服务实现类
 * @Datetime: 2019/9/25 8:19 下午
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Set<String> getRoleNameByAccountId(Integer accountId) {
        return roleMapper.selectRoleNameByAccountPrimaryKey(accountId);
    }

    @Override
    public PageData getCurrentPageData(String keyWord, int currentPage, int pageSize) {
        int startRow = (currentPage-1)*pageSize;
        int endRow = startRow + pageSize;
        PageData pageData = new PageData();
        pageData.setTotal(roleMapper.selectCountAll());
        pageData.setPageSize(pageSize);
        pageData.setData(roleMapper.selectLimit(keyWord,startRow,endRow));
        return pageData;
    }

    @Override
    public boolean deleteByRoleId(Integer roleId) {
        return roleMapper.deleteByPrimaryKey(roleId)>0;
    }
}
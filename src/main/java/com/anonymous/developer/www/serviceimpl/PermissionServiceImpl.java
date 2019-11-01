package com.anonymous.developer.www.serviceimpl;

import com.anonymous.developer.www.dto.PageData;
import com.anonymous.developer.www.mapper.PermissionMapper;
import com.anonymous.developer.www.model.Permission;
import com.anonymous.developer.www.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 权限服务实现类
 * @Datetime: 2019/9/22 10:53 下午
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Set<String> getPermissionByAccountId(Integer accountId) {
        return null;
    }

    @Override
    public PageData getCurrentPageData(String keyWord, int currentPage, int pageSize) {
        int startRow = (currentPage-1)*pageSize;
        int endRow = startRow + pageSize;
        PageData pageData = new PageData();
        pageData.setTotal(permissionMapper.selectCountAll());
        pageData.setPageSize(pageSize);
        pageData.setData(permissionMapper.selectLimit(keyWord,startRow,endRow));
        return pageData;
    }

    @Override
    public boolean deleteByPermissionId(Integer permissionId) {
        return permissionMapper.deleteByPrimaryKey(permissionId)>0;
    }

    @Override
    public int addPermission(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public boolean updateByPermissionId(Permission permission) {
        return permissionMapper.updateByPrimaryKey(permission)>0;
    }
}
package com.anonymous.developer.www.service;

import com.anonymous.developer.www.dto.PageData;
import com.anonymous.developer.www.model.Permission;

import java.util.Set;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description:
 * @Datetime: 2019/9/15 8:27 下午
 */
public interface PermissionService {
    /**
     * 通过账户ID查找权限名称
     * @param accountId
     * @return
     */
    Set<String> getPermissionByAccountId(Integer accountId);

    /**
     * 通过关键字、当前页、页尺寸、查找权限
     * @param keyWord
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageData getCurrentPageData(String keyWord, int currentPage, int pageSize);

    /**
     * 通过权限ID删除权限
     * @param permissionId
     * @return
     */
    boolean deleteByPermissionId(Integer permissionId);

    /**
     * 增加权限并返回增加权限的ID
     * @return
     */
    int addPermission(Permission permission);

    /**
     * 通过权限ID更新权限
     * @return
     */
    boolean updateByPermissionId(Permission permission);
}

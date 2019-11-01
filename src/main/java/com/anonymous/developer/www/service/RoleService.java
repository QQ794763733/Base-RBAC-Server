package com.anonymous.developer.www.service;

import com.anonymous.developer.www.dto.PageData;
import com.anonymous.developer.www.model.Role;

import java.util.Set;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 角色服务
 * @Datetime: 2019/9/15 8:26 下午
 */
public interface RoleService {
    /**
     * 通过账户ID查找角色名称
     * @param accountId
     * @return
     */
    Set<String> getRoleNameByAccountId(Integer accountId);

    /**
     * 通过关键字、当前页、页尺寸、查找角色
     * @param keyWord
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageData getCurrentPageData(String keyWord, int currentPage, int pageSize);

    /**
     * 通过角色ID删除角色
     * @param roleId
     * @return
     */
    boolean deleteByRoleId(Integer roleId);

    /**
     * 增加角色并返回增加角色的ID
     * @return
     */
    int addRole(Role role);

    /**
     * 通过角色ID更新角色
     * @param role
     * @return
     */
    boolean updateByRoleId(Role role);
}

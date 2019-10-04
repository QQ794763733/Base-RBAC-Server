package com.anonymous.developer.www.service;

import java.util.Set;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 角色服务
 * @Datetime: 2019/9/15 8:26 下午
 */
public interface RoleService {
    Set<String> getRoleByAccountId(Integer accountId);
}

package com.anonymous.developer.www.service;

import java.util.Set;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description:
 * @Datetime: 2019/9/15 8:27 下午
 */
public interface PermissionService {
    Set<String> getPermissionByAccountId(Integer accountId);
}

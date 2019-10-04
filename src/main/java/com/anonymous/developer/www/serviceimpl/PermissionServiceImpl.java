package com.anonymous.developer.www.serviceimpl;

import com.anonymous.developer.www.service.PermissionService;
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
    @Override
    public Set<String> getPermissionByAccountId(Integer accountId) {
        return null;
    }
}

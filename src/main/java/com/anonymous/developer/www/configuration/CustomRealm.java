package com.anonymous.developer.www.configuration;


import com.anonymous.developer.www.model.Account;
import com.anonymous.developer.www.service.AccountService;
import com.anonymous.developer.www.service.PermissionService;
import com.anonymous.developer.www.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
* @author: 肖宇
* @QQ: 794763733
* @WeChat: Anonymous-developer
* @Description: 自定义ShiroRealm
*/
public class CustomRealm extends AuthorizingRealm {
    private final Logger logger = LoggerFactory.getLogger(CustomRealm.class);
    //账户服务
    @Autowired
    private AccountService accountService;
    //角色服务
    @Autowired
    private RoleService roleService;
    //权限服务
    @Autowired
    private PermissionService permissionService;

    /**
     * 设置自定义的匹配器
     */
    {
        this.setCredentialsMatcher(new CustomCredentialsMatcher());
    }

    /**
     * 授权方法
     * @param principalCollection 身份信息集合
     * @return 授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if(principalCollection==null) throw new AuthorizationException("PrincipalCollection is null!");
        Account account = (Account) getAvailablePrincipal(principalCollection);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = roleService.getRoleByAccountId(account.getAccountId());
        Set<String> permissions = permissionService.getPermissionByAccountId(account.getAccountId());
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * 认证方法
     * @param authenticationToken 账号信息
     * @return 认证信息
     * @throws AuthenticationException 认证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        if(username==null) throw new AccountException("This username of currently account is null");
        Account account = accountService.findByAccountName(username);
        if(account==null) throw new AccountException("The account for "+username+" was not found");
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(account,account.getAccountPassword(),getName());
        logger.debug("当前用户"+username+"认证成功！");
        return authenticationInfo;
    }
}
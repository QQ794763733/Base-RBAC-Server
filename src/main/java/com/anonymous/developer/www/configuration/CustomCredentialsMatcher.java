package com.anonymous.developer.www.configuration;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.mindrot.jbcrypt.BCrypt;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 自定义密码验证
 * @Datetime: 2019/9/16 8:53 下午
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String loginPassword = String.valueOf(usernamePasswordToken.getPassword());
        return BCrypt.checkpw(loginPassword,info.getCredentials().toString());
    }
}

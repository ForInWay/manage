package com.morgan.manage.common.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @Author：Morgan.B.Chen
 * @Description: 密码检验
 * @Date:2018/7/4
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher{

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken newToken = (UsernamePasswordToken) token;
        //获取用户输入密码
        return super.doCredentialsMatch(token, info);
    }
}

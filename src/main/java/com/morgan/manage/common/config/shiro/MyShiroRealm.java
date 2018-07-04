package com.morgan.manage.common.config.shiro;

import com.morgan.manage.system.model.User;
import com.morgan.manage.system.service.MenuService;
import com.morgan.manage.system.service.RoleService;
import com.morgan.manage.system.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @Author：Morgan.B.Chen
 * @Description: 自定义shiro实现
 * @Date:2018/7/4
 */
public class MyShiroRealm extends AuthorizingRealm{
    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    /**
     * 添加角色相应权限
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String) principal.getPrimaryPrincipal();
        User user = userService.findUserByName(username);
        Set<String> roleNames = roleService.findRoleNamesByUserId(user.getId());
        logger.info("用户拥有角色："+roleNames);
        Set<String> menuNames = menuService.findMenuNamesByUserId(user.getId());
        logger.info("用户权限菜单："+menuNames);
        authorizationInfo.setRoles(roleNames);
        authorizationInfo.setStringPermissions(menuNames);
        return authorizationInfo;
    }

    /**
     * 登录验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        String password = new String(token.getPassword());
        User user = userService.findUserByName(userName);

        //账号不存在
        if(user==null){
            throw new UnknownAccountException("账号或密码不正确");
        }
        //密码错误
        if (!password.equals(user.getPassword())){
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        return new SimpleAuthenticationInfo(user,password,getName());
    }
}

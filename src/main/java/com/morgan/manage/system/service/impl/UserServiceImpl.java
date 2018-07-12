package com.morgan.manage.system.service.impl;

import com.morgan.manage.common.base.BaseServiceImpl;
import com.morgan.manage.system.dao.UserMapper;
import com.morgan.manage.system.model.SysUser;
import com.morgan.manage.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户管理
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<SysUser> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    @Override
    public SysUser findUserByName(String userName) {
        return userMapper.findUserByName(userName);
    }
}

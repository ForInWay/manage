package com.morgan.manage.system.service;


import com.morgan.manage.system.model.SysUser;

/**
 * 用户管理
 */
public interface UserService {

    SysUser findUserByName(String userName);
}

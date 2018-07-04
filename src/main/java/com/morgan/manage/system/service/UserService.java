package com.morgan.manage.system.service;


import com.morgan.manage.system.model.User;

/**
 * 用户管理
 */
public interface UserService {

    User findUserByName(String userName);
}

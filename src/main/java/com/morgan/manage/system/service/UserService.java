package com.morgan.manage.system.service;


import com.morgan.manage.common.base.BaseService;
import com.morgan.manage.system.model.SysUser;

/**
 * 用户管理
 */
public interface UserService extends BaseService<SysUser>{

    SysUser findUserByName(String userName);
}

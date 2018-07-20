package com.morgan.manage.system.service;


import com.morgan.manage.common.base.BaseService;
import com.morgan.manage.system.model.SysUser;

public interface UserService extends BaseService<SysUser>{

    SysUser findUserByName(String userName);
}

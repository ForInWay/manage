package com.morgan.manage.system.service;


import com.morgan.manage.system.model.SysRole;
import com.morgan.manage.system.model.SysUserRole;

import java.util.List;
import java.util.Set;

public interface RoleService {

    List<SysUserRole> findRolesByUserId(Integer userId);

    Set<String> findRoleNamesByUserId(Integer id);

    SysRole findRoleById(Integer id);
}

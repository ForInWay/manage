package com.morgan.manage.system.service;


import com.morgan.manage.system.model.Role;
import com.morgan.manage.system.model.UserRole;

import java.util.List;
import java.util.Set;

public interface RoleService {

    List<UserRole> findRolesByUserId(Integer userId);

    Set<String> findRoleNamesByUserId(Integer id);

    Role findRoleById(Integer id);
}

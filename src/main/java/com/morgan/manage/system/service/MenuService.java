package com.morgan.manage.system.service;


import com.morgan.manage.system.model.Menu;
import com.morgan.manage.system.model.RoleMenu;

import java.util.List;
import java.util.Set;

public interface MenuService {

    Set<String> findMenuNamesByUserId(Integer userId);

    Menu findMenuById(Integer id);

    List<RoleMenu> findMenusByRoleId(Integer roleId);
}

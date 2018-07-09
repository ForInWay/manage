package com.morgan.manage.system.service;


import com.morgan.manage.system.model.Menu;
import com.morgan.manage.common.base.model.Node;
import com.morgan.manage.system.model.RoleMenu;

import java.util.List;
import java.util.Set;

public interface MenuService {

    Menu findMenuById(Integer id);

    List<RoleMenu> findMenusByRoleId(Integer roleId);

    Set<String> findPermsByUserId(Integer userId);

    List<Node> findMenusByUserId(Integer userId);
}

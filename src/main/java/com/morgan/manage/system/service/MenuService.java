package com.morgan.manage.system.service;


import com.morgan.manage.system.model.SysMenu;
import com.morgan.manage.common.base.model.Node;
import com.morgan.manage.system.model.SysRoleMenu;

import java.util.List;
import java.util.Set;

public interface MenuService {

    SysMenu findMenuById(Integer id);

    List<SysRoleMenu> findMenusByRoleId(Integer roleId);

    Set<String> findPermsByUserId(Integer userId);

    List<Node> findMenusByUserId(Integer userId);
}

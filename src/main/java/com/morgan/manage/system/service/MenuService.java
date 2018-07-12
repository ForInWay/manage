package com.morgan.manage.system.service;


import com.morgan.manage.common.base.BaseService;
import com.morgan.manage.system.model.SysMenu;
import com.morgan.manage.common.base.model.Node;

import java.util.List;
import java.util.Set;

public interface MenuService extends BaseService<SysMenu>{

    Set<String> findPermsByUserId(Integer userId);

    List<Node> findMenusByUserId(Integer userId);
}

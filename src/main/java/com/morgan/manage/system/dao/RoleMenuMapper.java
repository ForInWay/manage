package com.morgan.manage.system.dao;

import com.morgan.manage.common.base.BaseMapper;
import com.morgan.manage.system.model.SysRoleMenu;
import org.springframework.stereotype.Repository;


/**
 * 角色菜单管理
 */
@Repository("roleMenuMapper")
public interface RoleMenuMapper extends BaseMapper<SysRoleMenu> {

}
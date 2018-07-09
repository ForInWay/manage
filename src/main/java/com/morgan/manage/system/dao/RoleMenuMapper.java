package com.morgan.manage.system.dao;

import com.morgan.manage.system.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色菜单管理
 */
@Repository("roleMenuMapper")
public interface RoleMenuMapper {

    List<SysRoleMenu> findMenusByRoleId(@Param("roleId") Integer roleId);
}
package com.morgan.manage.system.dao;

import com.morgan.manage.system.model.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 角色管理
 */
@Repository("roleMapper")
public interface RoleMapper {

    SysRole findRoleById(@Param("id") Integer id);
}
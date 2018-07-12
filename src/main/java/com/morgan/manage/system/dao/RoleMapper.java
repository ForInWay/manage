package com.morgan.manage.system.dao;

import com.morgan.manage.common.base.BaseMapper;
import com.morgan.manage.system.model.SysRole;
import org.springframework.stereotype.Repository;

/**
 * 角色管理
 */
@Repository("roleMapper")
public interface RoleMapper extends BaseMapper<SysRole>{

}
package com.morgan.manage.system.dao;

import com.morgan.manage.common.base.BaseMapper;
import com.morgan.manage.system.model.SysUserRole;
import org.springframework.stereotype.Repository;

/**
 * 用户角色管理
 */
@Repository("userRoleMapper")
public interface UserRoleMapper extends BaseMapper<SysUserRole>{

}
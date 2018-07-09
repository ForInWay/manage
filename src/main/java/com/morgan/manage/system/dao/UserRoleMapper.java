package com.morgan.manage.system.dao;

import com.morgan.manage.system.model.SysUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 用户角色管理
 */
@Repository("userRoleMapper")
public interface UserRoleMapper {
    List<SysUserRole> findRolesByUserId(@Param("userId") Integer userId);
}
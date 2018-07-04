package com.morgan.manage.system.dao;

import com.morgan.manage.system.model.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 用户角色管理
 */
@Repository("userRoleMapper")
public interface UserRoleMapper {
    List<UserRole> findRolesByUserId(@Param("userId") Integer userId);
}
package com.morgan.manage.system.dao;

import com.morgan.manage.common.base.BaseMapper;
import com.morgan.manage.system.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户管理mapper层
 */
@Repository("userMapper")
public interface UserMapper extends BaseMapper<SysUser> {

    SysUser findUserByName(@Param("userName") String userName);
}
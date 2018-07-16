package com.morgan.manage.system.dao;

import com.morgan.manage.common.base.BaseMapper;
import com.morgan.manage.system.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户管理mapper层
 */
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {

    SysUser findUserByName(@Param("userName") String userName);
}
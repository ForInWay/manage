package com.morgan.manage.system.dao;

import com.morgan.manage.system.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户管理mapper层
 */
@Repository("userMapper")
public interface UserMapper {

    User findUserByName(@Param("userName") String userName);
}
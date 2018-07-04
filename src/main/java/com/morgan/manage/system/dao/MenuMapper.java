package com.morgan.manage.system.dao;

import com.morgan.manage.system.model.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 菜单管理
 */
@Repository("menuMapper")
public interface MenuMapper {

    Menu findMenuById(@Param("id") Integer id);
}
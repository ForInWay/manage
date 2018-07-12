package com.morgan.manage.system.dao;

import com.morgan.manage.common.base.BaseMapper;
import com.morgan.manage.system.model.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单管理
 */
@Repository("menuMapper")
public interface MenuMapper extends BaseMapper<SysMenu>{

    List<String> findPermsByUserId(@Param("userId") Integer userId);

    List<SysMenu> findMenusByUserId(@Param("userId") Integer userId);
}
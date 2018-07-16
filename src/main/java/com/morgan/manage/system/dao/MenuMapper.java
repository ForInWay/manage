package com.morgan.manage.system.dao;

import com.morgan.manage.common.base.BaseMapper;
import com.morgan.manage.system.model.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单管理
 */
@Mapper
public interface MenuMapper extends BaseMapper<SysMenu>{

    List<String> findPermsByUserId(@Param("userId") Integer userId);

    List<SysMenu> findMenusByUserId(@Param("userId") Integer userId);
}
package com.morgan.manage.system.model;

import java.io.Serializable;

/**
 * 角色菜单实体类
 */
public class SysRoleMenu implements Serializable{

    private static final long serialVersionUID = 1L;

    //主键id
    private Integer id;
    //角色id
    private Integer roleId;
    //菜单id
    private Integer menuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "SysRoleMenu{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", menuId=" + menuId +
                '}';
    }
}
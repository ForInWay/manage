package com.morgan.manage.system.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 角色菜单实体类
 */
@Table(name = "sys_role_menu")
public class SysRoleMenu implements Serializable{

    //主键id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //角色id
    @Column(name = "role_id")
    private Integer roleId;
    //菜单id
    @Column(name = "menu_id")
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
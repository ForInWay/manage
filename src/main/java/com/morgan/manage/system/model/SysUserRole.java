package com.morgan.manage.system.model;

import java.io.Serializable;

/**
 * 用户角色实体类（多对多）
 */
public class SysUserRole implements Serializable{

    private static final long serialVersionUID = 1L;

    //主键id
    private Integer id;
    //用户id
    private Integer userId;
    //角色id
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SysUserRole{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
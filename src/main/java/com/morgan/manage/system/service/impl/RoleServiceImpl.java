package com.morgan.manage.system.service.impl;

import com.morgan.manage.system.dao.RoleMapper;
import com.morgan.manage.system.dao.UserRoleMapper;
import com.morgan.manage.system.model.SysRole;
import com.morgan.manage.system.model.SysUserRole;
import com.morgan.manage.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 角色管理service层
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 根据userId查找所有角色
     * @param userId
     * @return
     */
    @Override
    public List<SysUserRole> findRolesByUserId(Integer userId) {
        return userRoleMapper.findRolesByUserId(userId);
    }

    /**
     * 根据roleId查找角色
     * @param id
     * @return
     */
    @Override
    public SysRole findRoleById(Integer id){
        return roleMapper.findRoleById(id);
    }

    /**
     * 根据userId查找所有角色的角色名称
     * @param userId
     * @return
     */
    @Override
    public Set<String> findRoleNamesByUserId(Integer userId) {
        List<SysUserRole> userRoles = findRolesByUserId(userId);
        Set<String> userNames = new HashSet<>();
        SysRole role = null;
        if (userRoles!=null){
            int length = userRoles.size();
            for (int i=0;i<length;i++){
                role = findRoleById(userRoles.get(i).getRoleId());
                userNames.add(role.getRoleName());
            }
        }
        return userNames;
    }
}

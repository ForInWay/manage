package com.morgan.manage.system.service.impl;

import com.morgan.manage.system.dao.MenuMapper;
import com.morgan.manage.system.dao.RoleMenuMapper;
import com.morgan.manage.system.dao.UserRoleMapper;
import com.morgan.manage.system.model.Menu;
import com.morgan.manage.system.model.RoleMenu;
import com.morgan.manage.system.model.UserRole;
import com.morgan.manage.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 菜单管理service层
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 根据用户id查找权限菜单
     * @param userId
     * @return
     */
    @Override
    public Set<String> findMenuNamesByUserId(Integer userId) {
        List<UserRole> userRoles = userRoleMapper.findRolesByUserId(userId);
        Set<String> menuNames = new HashSet<>();
        Menu menu = null;
        if (userRoles!=null){
            int length = userRoles.size();
            for (int i=0;i<length;i++){
                List<RoleMenu> roleMenus = findMenusByRoleId(userRoles.get(i).getRoleId());
                if (roleMenus!=null){
                    int len = roleMenus.size();
                    for (int j=0;j<len;j++){
                        menu = findMenuById(roleMenus.get(j).getMenuId());
                        menuNames.add(menu.getName());
                    }
                }
            }
        }
        return menuNames;
    }

    /**
     * 根据菜单id查找菜单
     * @param id
     * @return
     */
    @Override
    public Menu findMenuById(Integer id) {
        return menuMapper.findMenuById(id);
    }

    /**
     * 根据roleId查找权限菜单
     * @param roleId
     * @return
     */
    @Override
    public List<RoleMenu> findMenusByRoleId(Integer roleId){
        return roleMenuMapper.findMenusByRoleId(roleId);
    }
}

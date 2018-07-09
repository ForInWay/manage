package com.morgan.manage.system.service.impl;

import com.morgan.manage.common.utils.StringUtils;
import com.morgan.manage.common.utils.TreeUtils;
import com.morgan.manage.system.dao.MenuMapper;
import com.morgan.manage.system.dao.RoleMenuMapper;
import com.morgan.manage.system.model.Menu;
import com.morgan.manage.common.base.model.Node;
import com.morgan.manage.system.model.RoleMenu;
import com.morgan.manage.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 菜单管理service层
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private MenuMapper menuMapper;

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


    /**
     * 根据userId查找权限
     * @param userId
     * @return
     */
    @Override
    public Set<String> findPermsByUserId(Integer userId) {
        List<String> perms = menuMapper.findPermsByUserId(userId);
        Set<String> permList = new HashSet<>();
        for (String perm:perms) {
            if (StringUtils.isEmpty(perm))
                permList.addAll(Arrays.asList(perm.trim().split(",")));
        }
        return permList;
    }

    /**
     * 根据用户id查找菜单
     * @param userId
     * @return
     */
    @Override
    public List<Node> findMenusByUserId(Integer userId) {
        List<Menu> menus = menuMapper.findMenusByUserId(userId);
        return createTree(menus);
    }

    /**
     * 根据菜单项生成树节点
     * @param menus
     * @return
     */
    private List<Node> createTree(List<Menu> menus) {
        List<Node> tree = new ArrayList<>();
        //菜单转换成节点
        for (Menu menu:menus) {
            Node node = new Node();
            node.setId(String.valueOf(menu.getId()));
            node.setParentId(String.valueOf(menu.getParentId()));
            node.setText(menu.getName());
            Map<String,Object> attributes = new HashMap<>(16);
            attributes.put("url",menu.getUrl());
            attributes.put("icon",menu.getIcon());
            attributes.put("perms",menu.getPerms());
            attributes.put("orderNum",menu.getOrderNum());
            tree.add(node);
        }
        //根据节点构造成节点菜单
        TreeUtils treeUtils = new TreeUtils(tree);
        return treeUtils.build();
    }
}

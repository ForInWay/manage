package com.morgan.manage.system.service.impl;

import com.morgan.manage.common.base.BaseService;
import com.morgan.manage.common.base.BaseServiceImpl;
import com.morgan.manage.common.utils.StringUtils;
import com.morgan.manage.common.utils.TreeUtils;
import com.morgan.manage.system.dao.MenuMapper;
import com.morgan.manage.system.model.SysMenu;
import com.morgan.manage.common.base.model.Node;
import com.morgan.manage.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 菜单管理service层
 */
@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<SysMenu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

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
        List<SysMenu> sysMenus = menuMapper.findMenusByUserId(userId);
        return createTree(sysMenus);
    }

    /**
     * 根据菜单项生成树节点
     * @param sysMenus
     * @return
     */
    private List<Node> createTree(List<SysMenu> sysMenus) {
        List<Node> tree = new ArrayList<>();
        //菜单转换成节点
        for (SysMenu sysMenu : sysMenus) {
            Node node = new Node();
            node.setId(String.valueOf(sysMenu.getId()));
            node.setParentId(String.valueOf(sysMenu.getParentId()));
            node.setText(sysMenu.getName());
            Map<String,Object> attributes = new HashMap<>(16);
            attributes.put("url", sysMenu.getUrl());
            attributes.put("icon", sysMenu.getIcon());
            attributes.put("perms", sysMenu.getPerms());
            attributes.put("orderNum", sysMenu.getOrderNum());
            node.setAttributes(attributes);
            tree.add(node);
        }
        //根据节点构造成节点菜单
        TreeUtils treeUtils = new TreeUtils(tree);
        return treeUtils.build();
    }
}

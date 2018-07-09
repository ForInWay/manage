package com.morgan.manage.common.utils;

import com.morgan.manage.common.base.model.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：Morgan.B.Chen
 * @Description: 节点工具类
 * @Date:2018/7/9
 */
public class TreeUtils {

    private List<Node> nodes = new ArrayList<>();

    public TreeUtils(List<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * 构造树
     * @return
     */
    public List<Node> build() {
        List<Node> tree = new ArrayList<>();
        // 获取所有根节点
        List<Node> rootNodes = getRootNodes();
        for (Node rootNode : rootNodes) {
            addChildNodes(rootNode);
            tree.add(rootNode);
        }
        return tree;
    }

    /**
     * 添加子节点
     * @param node
     */
    private void addChildNodes(Node node) {
        // 获取当前节点的下一级节点
        List<Node> childNodes = getChildren(node);

        if (!childNodes.isEmpty()) {
            for (Node childNode : childNodes) {
                addChildNodes(childNode);
            }
            node.setChildren(childNodes);
        }
    }

    /**
     * 获取子节点
     * @param pNode
     * @return
     */
    private List<Node> getChildren(Node pNode) {
        List<Node> childNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (pNode.getId().equals(node.getParentId())) {
                childNodes.add(node);
            }
        }
        return childNodes;
    }

    /**
     * 获取根节点
     * @return
     */
    private List<Node> getRootNodes() {
        List<Node> rootNodes = new ArrayList<>();
        for (Node node : nodes) {
            if ("0".equals(node.getParentId())) {
                rootNodes.add(node);
            }
        }
        return rootNodes;
    }
}

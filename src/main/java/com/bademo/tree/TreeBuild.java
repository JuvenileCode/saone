package com.bademo.tree;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/20 19:52
 * @Description: 生成树菜单测试
 */
public class TreeBuild {

    public static final String ROOT_NODE = "0";


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode("1", "广州", "0");
        TreeNode treeNode2 = new TreeNode("2", "深圳", "0");

        TreeNode treeNode3 = new TreeNode("3", "天河区", treeNode1);
        TreeNode treeNode4 = new TreeNode("4", "越秀区", treeNode1);
        TreeNode treeNode5 = new TreeNode("5", "黄埔区", treeNode1);
        TreeNode treeNode6 = new TreeNode("6", "石牌", treeNode3);
        TreeNode treeNode7 = new TreeNode("7", "百脑汇", treeNode6);


        TreeNode treeNode8 = new TreeNode("8", "南山区", treeNode2);
        TreeNode treeNode9 = new TreeNode("9", "宝安区", treeNode2);
        TreeNode treeNode10 = new TreeNode("10", "科技园", treeNode8);


        List<TreeNode> list = new ArrayList<>();

        list.add(treeNode1);
        list.add(treeNode2);
        list.add(treeNode3);
        list.add(treeNode4);
        list.add(treeNode5);
        list.add(treeNode6);
        list.add(treeNode7);
        list.add(treeNode8);
        list.add(treeNode9);
        list.add(treeNode10);


        Gson gson = new Gson();
        System.out.println(System.currentTimeMillis());
        // System.out.println(gson.toJson(buildByRecursive(list)));
        System.out.println(gson.toJson(bulid(list)));
        System.out.println(System.currentTimeMillis());


    }

    /**
     * 递归方法构建树
     * @param treeNodes
     * @return
     */
    public static List<TreeNode> buildByRecursive(List<TreeNode> treeNodes) {
        List<TreeNode> trees = new ArrayList<>();
        treeNodes.forEach(treeNode -> {
            if (ROOT_NODE.equals(treeNode.getParentId())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        });

        return trees;
    }

    /**
     * 递归查找子节点
     * @param treeNode
     * @param treeNodes
     * @return
     */
    public static TreeNode findChildren(TreeNode treeNode, List<TreeNode> treeNodes) {
        treeNodes.forEach(it -> {
            if (treeNode.getId().equals(it.getParentId())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        });
        return treeNode;
    }

    /**
     * 两层循环构建树
     *
     * @param treeNodes
     * @return
     */
    public static List<TreeNode> bulid(List<TreeNode> treeNodes) {
        List<TreeNode> trees = new ArrayList<>();
        treeNodes.forEach( treeNode -> {
            if (ROOT_NODE.equals(treeNode.getParentId())) {
                trees.add(treeNode);
            }

            treeNodes.forEach(it -> {
                if (it.getParentId().equals(treeNode.getId())) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.getChildren().add(it);
                }
            });
        });

        return trees;
    }

}

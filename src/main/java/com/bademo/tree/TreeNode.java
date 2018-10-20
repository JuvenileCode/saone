package com.bademo.tree;

import lombok.Data;

import java.util.List;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/20 19:46
 * @Description:
 */
@Data
public class TreeNode {

    private String id;
    private String name;
    private String parentId;
    private List<TreeNode> children;

    public TreeNode(String id, String name, TreeNode children) {
        this.id = id;
        this.name = name;
        this.parentId = children.getId();
    }

    public TreeNode(String id, String name, String parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
}

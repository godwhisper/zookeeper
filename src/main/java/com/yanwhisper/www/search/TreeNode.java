package com.yanwhisper.www.search;

/**
 * @author little whisper
 * @date 2020/2/14 18:33
 */
public class TreeNode {
    /**
     * 节点值
     */
    private int value;
    /**
     * 左子节点
     */
    private TreeNode left;
    /**
     * 右子节点
     */
    private TreeNode right;

    public static TreeNode valueOf(int value) {
        TreeNode treeNode = new TreeNode();
        treeNode.value = value;
        return treeNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

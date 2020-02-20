package com.yanwhisper.www.search;

/**
 * @author little whisper
 * @date 2020/2/14 18:37
 */
public class TreeFactory {

    public static TreeNode createTree() {
        TreeNode root = TreeNode.valueOf(10);
        TreeNode left = TreeNode.valueOf(6);
        root.setLeft(left);
        TreeNode right = TreeNode.valueOf(14);
        root.setRight(right);
        return root;
    }

}

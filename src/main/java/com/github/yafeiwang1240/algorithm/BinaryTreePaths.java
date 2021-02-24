package com.github.yafeiwang1240.algorithm;

import java.util.ArrayList;
import java.util.List;

/*
 给定一个二叉树，返回所有从根节点到叶子节点的路径。

 说明: 叶子节点是指没有子节点的节点。

 示例:

 输入:

 1
 /   \
 2     3
 \
 5

 输出: ["1->2->5", "1->3"]

 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class BinaryTreePaths {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(binaryTreePaths(node1));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> left = null;
        if (root.left != null) {
            left = binaryTreePaths(root.left);
        }
        List<String> right = null;
        if (root.right != null) {
            right = binaryTreePaths(root.right);
        }
        if (left == null && right == null) {
            List<String> result = new ArrayList<>();
            result.add("" + root.val);
            return result;
        } else if (left == null) {
            for (int i = 0; i < right.size(); i++) {
                right.set(i, root.val + "->" + right.get(i));
            }
            return right;
        } else if (right == null) {
            for (int i = 0; i < left.size(); i++) {
                left.set(i, root.val + "->" + left.get(i));
            }
            return left;
        } else {
            for (int i = 0; i < left.size(); i++) {
                left.set(i, root.val + "->" + left.get(i));
            }
            for (int i = 0; i < right.size(); i++) {
                right.set(i, root.val + "->" + right.get(i));
            }
            left.addAll(right);
            return left;
        }
    }

}

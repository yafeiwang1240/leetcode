package com.github.yafeiwang1240.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int last = 1;
        int current = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.right != null) {
                queue.offer(node.right);
                current++;
            }
            if (node.left != null) {
                queue.offer(node.left);
                current++;
            }
            for (int i = 1; i < last; i++) {
                node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                    current++;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    current++;
                }
            }
            last = current;
            current = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.right = node2;
        node1.left = node4;
        node2.left = node3;
        System.out.println(rightSideView(node1));
    }
}

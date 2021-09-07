package com.lwz.topic.medium;

import java.util.ArrayList;
import java.util.List;

public class Topic103 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> cel = new ArrayList<>();
        cel.add(root.val);
        res.add(cel);

        List<TreeNode> treeNodeList = new ArrayList<>();
        if (root.left != null) {
            treeNodeList.add(root.left);
        }
        if (root.right != null) {
            treeNodeList.add(root.right);
        }

        int index = 1;
        while (!treeNodeList.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            cel = new ArrayList<>();
            if (index % 2 == 1) {
                for (int i = treeNodeList.size() - 1; i >= 0; i--) {
                    TreeNode node = treeNodeList.get(i);
                    cel.add(node.val);
                    if (node.right != null) {
                        temp.add(node.right);
                    }
                    if (node.left != null) {
                        temp.add(node.left);
                    }
                }
            } else {
                for (int i = treeNodeList.size() - 1; i >= 0; i--) {
                    TreeNode node = treeNodeList.get(i);
                    cel.add(node.val);
                    if (node.left != null) {
                        temp.add(node.left);
                    }
                    if (node.right != null) {
                        temp.add(node.right);
                    }
                }
            }
            res.add(cel);
            treeNodeList = temp;
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        root.left = node1;
        TreeNode node2 = new TreeNode(20);
        root.right = node2;
        TreeNode node3 = new TreeNode(15);
        node2.left = node3;
        TreeNode node4 = new TreeNode(7);
        node2.right = node4;
        TreeNode node5 = new TreeNode(4);
        node3.left = node5;
        TreeNode node6 = new TreeNode(6);
        node4.left = node6;

        List<List<Integer>> lists = zigzagLevelOrder(root);
        System.out.println(lists);
    }

}

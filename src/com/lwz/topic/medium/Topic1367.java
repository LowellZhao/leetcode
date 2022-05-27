package com.lwz.topic.medium;

/**
 * https://leetcode-cn.com/problems/linked-list-in-binary-tree/
 *
 * @author lwz
 * @date 2022/3/15
 */
public class Topic1367 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return some(head, root) || isSubPath(head, root.right) || isSubPath(head, root.left);
    }

    public boolean some(ListNode head, TreeNode treeNode) {
        if (head == null) {
            return true;
        }
        if (treeNode == null) {
            return false;
        }
        if (head.val != treeNode.val) {
            return false;
        }
        return some(head.next, treeNode.right) || some(head.next, treeNode.left);
    }

    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(3);
//        TreeNode treeNode2 = new TreeNode(1);
//        TreeNode treeNode3 = new TreeNode(8, treeNode2, treeNode1);
//        TreeNode treeNode4 = new TreeNode(6);
//        TreeNode treeNode5 = new TreeNode(2, treeNode4, treeNode3);
//        TreeNode treeNode6 = new TreeNode(4, null, treeNode5);
//        TreeNode treeNode7 = new TreeNode(1);
//        TreeNode treeNode8 = new TreeNode(2, treeNode7, null);
//        TreeNode treeNode9 = new TreeNode(4, null, treeNode8);
//        TreeNode root = new TreeNode(1, treeNode9, treeNode6);
//
//        ListNode listNode1 = new ListNode(8);
//        ListNode listNode2 = new ListNode(2, listNode1);
//        ListNode head = new ListNode(4, listNode2);

//        TreeNode tree22122 = new TreeNode(3);
//        TreeNode tree22121 = new TreeNode(1);
//        TreeNode tree2212 = new TreeNode(8, tree22121, tree22122);
//        TreeNode tree2211 = new TreeNode(6);
//        TreeNode tree221 = new TreeNode(2, tree2211, tree2212);
//        TreeNode tree22 = new TreeNode(4, tree221, null);
//
//        TreeNode tree2121 = new TreeNode(1);
//        TreeNode tree212 = new TreeNode(2, tree2121, null);
//        TreeNode tree21 = new TreeNode(4, null, tree212);
//
//        TreeNode root = new TreeNode(1, tree21, tree22);
//
//        ListNode listNode3 = new ListNode(6);
//        ListNode listNode2 = new ListNode(2, listNode3);
//        ListNode listNode1 = new ListNode(4, listNode2);
//        ListNode head = new ListNode(1, listNode1);

        TreeNode tree2222 = new TreeNode(1);
        TreeNode tree222 = new TreeNode(2, null, tree2222);
        TreeNode tree22 = new TreeNode(2, null, tree222);
        TreeNode root = new TreeNode(2, null, tree22);

        ListNode listNode2 = new ListNode(1);
        ListNode listNode1 = new ListNode(2, listNode2);
        ListNode head = new ListNode(2, listNode1);

        boolean subPath = new Topic1367().isSubPath(head, root);
        System.out.println(subPath);
    }
}

package com.lwz.topic.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Topic82 {

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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        list.add(head.val);
        set.add(head.val);

        while (head.next != null) {
            head = head.next;
            int val = head.val;
            if (set.contains(val)) {
                list.remove(Integer.valueOf(val));
            } else {
                list.add(val);
            }
            set.add(val);
        }

        if (list.size() < 1) {
            return null;
        }

        ListNode root = new ListNode(list.get(0), null);

        ListNode temp = root;

        for (int i = 1; i < list.size(); i++) {
            temp.next = new ListNode(list.get(i), null);
            temp = temp.next;
        }

        return root;
    }

    public static void main(String[] args) {
        ListNode listNode = new Topic82().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, null))))));

        while (true) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
            if (listNode == null) {
                break;
            }
        }
    }

}

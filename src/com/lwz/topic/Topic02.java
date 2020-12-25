package com.lwz.topic;

public class Topic02 {

    static class ListNode {
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

    public static ListNode twoAdd(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = temp = new ListNode(sum % 10);
            } else {
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return head;
    }

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public static void main(String[] args) {
        ListNode one = new ListNode(9, new ListNode(9, new ListNode(9, null)));
        ListNode two = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
        System.out.println(999 + 9999);
        ListNode listNode = twoAdd(one, two);
        System.out.println(listNode);
    }

}

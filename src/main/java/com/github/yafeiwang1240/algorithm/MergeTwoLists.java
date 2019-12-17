package com.github.yafeiwang1240.algorithm;

/*
    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        if (l1.val > l2.val) {
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }
        ListNode p = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                p.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                p.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val > l2.val) {
                    p.next = l2;
                    l2 = l2.next;
                } else {
                    p.next = l1;
                    l1 = l1.next;
                }
            }
            p = p.next;
        }
        return head;
    }
}

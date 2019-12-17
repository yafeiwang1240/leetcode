package com.github.yafeiwang1240.algorithm;

/*
    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pNode = head;
        ListNode pNext = head;
        for (int i = 0; i < n; i++) {
            pNode = pNode.next;
        }
        if (pNode == null)
            return head.next;
        while (pNode.next != null) {
            pNode = pNode.next;
            pNext = pNext.next;
        }
        pNext.next = pNext.next.next;
        return head;
    }


}

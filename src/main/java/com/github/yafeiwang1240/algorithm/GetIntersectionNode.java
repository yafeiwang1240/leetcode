package com.github.yafeiwang1240.algorithm;

public class GetIntersectionNode {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode hA = headA;
        ListNode hB = headB;
        while (hA != null) {
            lenA++;
            hA = hA.next;
        }
        while (hB != null) {
            lenB++;
            hB = hB.next;
        }
        hA = headA;
        hB = headB;
        int length = 0;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                hA = hA.next;
            }
            length = lenB;
        } else if (lenA < lenB) {
            for (int i = 0; i < lenB - lenA; i++) {
                hB = hB.next;
            }
            length = lenA;
        }
        for (int i = 0; i < length; i++) {
            if (hA == hB) return hA;
            hA = hA.next;
            hB = hB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node3;
        node3.next = node4;
        node2.next = node4;
        System.out.print(getIntersectionNode(node1, node2).val);
    }
}

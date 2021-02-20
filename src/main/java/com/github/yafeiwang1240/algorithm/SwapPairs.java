package com.github.yafeiwang1240.algorithm;

public class SwapPairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + "";
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(swapPairs(node1));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode r = head.next;
        ListNode l = null;
        ListNode next;
        while (head != null) {
            if (head.next == null) break;
            next = head.next;
            head.next = next.next;
            next.next = head;
            if (l != null) {
                l.next = next;
            }
            l = head;
            head = head.next;
        }
        return r;
    }
}

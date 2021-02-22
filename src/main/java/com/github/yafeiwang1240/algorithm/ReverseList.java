package com.github.yafeiwang1240.algorithm;

public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }

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
        System.out.println(reverseList(node1));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head.next;
        ListNode next;
        ListNode last = head;
        while (current != null) {
            next = last.next = current.next;
            current.next = head;
            head = current;
            current = next;
        }
        return head;
    }
}

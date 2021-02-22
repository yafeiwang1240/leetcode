package com.github.yafeiwang1240.algorithm;

import java.util.Stack;

public class ReverseKGroup {

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
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        System.out.println(reverseKGroup(node1, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode l = null;
        ListNode r = null;
        ListNode next;
        ListNode pop;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            for (int i = 0; i < k; i++) {
                if (head == null) {
                    if (r != null) {
                        while (!stack.isEmpty()) {
                            l.next = stack.pop();
                        }
                    } else {
                        while (!stack.isEmpty()) {
                            r = stack.pop();
                        }
                    }
                    return r;
                }
                stack.push(head);
                head = head.next;
            }
            next = head;
            head = stack.pop();
            if (r == null) {
                r = head;
            }
            if (l != null) {
                l.next = head;
            }
            while (!stack.isEmpty()) {
                pop = stack.pop();
                head.next = pop;
                head = pop;
            }
            l = head;
            l.next = null;
            head = next;
        }
        return r;
    }
}

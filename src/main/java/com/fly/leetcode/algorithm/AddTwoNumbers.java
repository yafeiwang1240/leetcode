package com.fly.leetcode.algorithm;

import java.util.List;

public class AddTwoNumbers {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = getIntFromListNode(l1);
        int num2 = getIntFromListNode(l2);
        return setIntToListNode(num1 + num2);
    }

    private static int getIntFromListNode(ListNode node) {
        if(node == null) {
            return 0;
        }

        int num = node.val;
        ListNode _node = node.next;
        while (_node != null) {
            num = 10 * num + _node.val;
            _node = _node.next;
        }
        return num;
    }

    private static ListNode setIntToListNode(int num) {
        if(num == 0) {
            return new ListNode(num);
        }
        int _num = num;
        ListNode head = null;
        while(_num != 0) {
            ListNode node = new ListNode(_num % 10);
            node.next = head;
            head = node;
            _num /= 10;
        }
        return head;
    }

    public static ListNode addTwoNumbersBack(ListNode l1, ListNode l2) {
        int[] num1 = getIntFromListNodeBack(l1);
        int[] num2 = getIntFromListNodeBack(l2);
        return setIntToListNodeBack(num1, num2);
    }

    private static ListNode setIntToListNodeBack(int[] num1, int[] num2) {

        ListNode head = new ListNode((num1[0] + num2[0]) % 10);
        int over = (num1[0] + num2[0]) / 10;
        int index = 1;
        ListNode next = head;
        while(index < num1[100] || index < num2[100] || over > 0) {
            ListNode node = new ListNode((num1[index] + num2[index] + over) % 10);
            over = (num1[index] + num2[index] + over) / 10;
            next.next = node;
            next = node;
            index++;
        }
        return head;
    }

    private static int[] getIntFromListNodeBack(ListNode node) {
        int[] result = new int[101];
        if(node == null) {
            result[100] = 1;
            return result;
        }

        int index = 0;
        ListNode _node = node;
        while (_node != null) {
            result[index++] = _node.val;
            _node = _node.next;
        }
        result[100] = index;
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);

        node4.next = node5;
        node5.next = node6;

        addTwoNumbersBack(node1, node4);
    }
}

package ru.leetcode.app.t206;

import org.junit.Assert;

public class ReverseLinkedList {

    /**
     * https://leetcode.com/problems/reverse-linked-list/
     * <p>
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     */
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        root.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode result = reverseList(root);

        Assert.assertEquals(5, result.val);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

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
}

package ru.leetcode.app.t876;

import org.junit.Assert;

public class MiddleOfTheLinkedList {

    /**
     * https://leetcode.com/problems/middle-of-the-linked-list/
     *
     * Given the head of a singly linked list, return the middle node of the linked list.
     *
     * If there are two middle nodes, return the second middle node.
     */

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        root.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode listNode = middleNode(root);
        Assert.assertEquals(3, listNode.val);

        ListNode n5 = new ListNode(6);
        n4.next = n5;

        listNode = middleNode(root);
        Assert.assertEquals(4, listNode.val);
    }

    public static ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
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

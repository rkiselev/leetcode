package ru.leetcode.app.t141;

import org.junit.Assert;

public class LinkedListCycle {

    /**
     * https://leetcode.com/problems/linked-list-cycle/
     *
     * <p>
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     * <p>
     * There is a cycle in a linked list if there is some node in the list that can be reached again by
     * continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's
     * next pointer is connected to. Note that pos is not passed as a parameter.
     * <p>
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     */
    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        ListNode n = new ListNode(2);
        root.next = n;
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(4);
        n.next = n1;
        n1.next = n2;
        n2.next = n;

        Assert.assertTrue(hasCycle(root));

    }

    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

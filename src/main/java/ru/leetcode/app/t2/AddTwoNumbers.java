package ru.leetcode.app.t2;

import org.junit.Assert;

public class AddTwoNumbers {


    /**
     *
     * https://leetcode.com/problems/add-two-numbers/
     *
     * You are given two non-empty linked lists representing two non-negative integers. The digits
     * are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and
     * return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        var r = addTwoNumbers(l1, l4);
        Assert.assertEquals(7, r.val);
        r = r.next;

        Assert.assertEquals(0, r.val);
        r = r.next;

        Assert.assertEquals(8, r.val);
        r = r.next;

        Assert.assertNull(r);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode curr = result;
        int next = 0;
        while (l1 != null || l2 != null) {
            int v = getValue(l1) + getValue(l2) + next;
            next = 0;
            if (v / 10 == 0) {
                curr.next = new ListNode(v);
            } else {
                curr.next = new ListNode(v % 10);
                next = v / 10;
            }
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (next > 0) {
            curr.next = new ListNode(next);
        }
        return result.next;
    }

    private static int getValue(ListNode l) {
        return l == null ? 0 : l.val;
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
